<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${basePath }/background/css/background.css">
<script type="text/javascript" src="${basePath }/background/js/background.js"></script>
</head>
<style>
	#toolbar td{
	}
</style>
<body>
	<table id="users" title="用户信息管理" class="easyui-datagrid" style="width:850px;height:450px;text-align:center"
			url="${basePath }/background/jsp/user/user_getUserJson"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true" pageSize="20" method='get'>
		<thead>
			<tr>
				<!-- <th field="userId" width="150">用户id</th> -->
				<!-- <th field="userId" checkbox="true"></th> -->
				<th field="userName" width="100" data-options="editor:{type:'textbox',options:{
				required:true
				}}">用户名</th>
				<th field="email" width="100" data-options="editor:{type:'textbox',options:{
				required:true,
				validType:'email'
				}}">email</th>
				<th field="qq" width="80" data-options="editor:{type:'textbox',options:{
				}}">QQ</th>
				<th field="createTime"  width="50" formatter='formatDate' >创建时间</th>
				<th field="permission" width="50" formatter='swap' data-options="editor:{type:'combobox',
				options:{
					required:true,
					valueField :'value',
					textField:'label',
					data:[
						{'label':'普通用户','value':'10'},
						{'label':'作者','value':'20'},
						{'label':'vip','value':'30'},
						{'label':'管理员','value':'40'},
						{'label':'超级管理员','value':'50'}
						]
					}
				}">用户权限</th>
			</tr>
		</thead>
	</table>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px;text-align:center"
			closed="true" buttons="#dlg-buttons">
		<div  style="text-align:center;font-weight:700">用户添加</div><br>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>电子邮件<span style='color:red;'>*</span>:</label>
				<input name="user.email" id="email" class="easyui-validatebox"  validType="email" required="true" >
			</div>
			<div class="fitem">
					<label>用户密码<span style='color:red;'>*</span>:</label>
						<input name="user.userPw" id="userPw"  class="easyui-validatebox" type="password" required="true" validType="checkPw[]" >
			</div>
			<div class="fitem">
				<label>密码确认<span style='color:red;'>*</span>:</label>
				<input name="userPwCom"  class="easyui-validatebox"  type="password" required="true" validType="userPwCom[]">
			</div>
		</form>
	</div>
	<div id="toolbar">
		<form id="searchForm" method="post" >   
			<table border ="0">
				<tr>
					<td>
		        		<label for="name">用户名:</label>   
		        		<input class="easyui-validatebox" type="text" style="width:80px" name="user.userName" /> 
						<span>　</span>
					</td>
		       		<td>
		       			 <label for="email">电子邮件:</label>   
		        		 <input class="easyui-validatebox" type="text" style="width:80px" name="user.email" />   
		        		 <span>　</span>
		    	    </td>
					<td>
				        <label for="createStart" colspan='2'>创建时间:</label>   
				        <input class="easyui-datebox" type="text" id="createStart" name="createStart" style="width:95px" data-options="editable:false"/> 
				        <input class="easyui-datebox" type="text" id="createEnd" name="createEnd" style="width:95px" data-options="editable:false"/> 
				        <span>　</span>  
		       		</td>
		       		<td>
				        <label for="permission">用户角色:</label>   
						<select id="permission" class="easyui-combobox" name="user.permission" style="width:80px;" data-options="editable:false">   
							<option value="">全部</option>
						    <option value="10">普通用户</option>   
						    <option value="20">作者</option>   
						    <option value="30">管理员</option>   
						    <option value="40">超级管理员</option>   
						</select>  
						<span>　</span>
		    		</td>
		    		<td>
		    			<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:searchUser()">查询</a>  
		    		</td>
		    	</tr>
			</table>
		</form>  
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
<script>

	
	
	/**
	 * 校验用户名是否存在
	 */
	function checkName(){
		var name = $('#userName').val();
		var myurl = '${basePath}/background/jsp/user/user_checkName?userName='+name;
		leaf.ajax(myurl,null,null,checkNameSuc,null);
	}


	//添加用户的弹窗
	function newUser(){
		$('#dlg').dialog('open').dialog('setTitle','创建用户');
		$('#fm').form('clear');
	}

	//添加用户
	function saveUser(){
		var myurl = '${basePath}/background/jsp/user/user_saveUser';
		$('#userPw').destroy;
		
		$('#fm').form('submit',{
			url: myurl,
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
				var data = eval('(' + result + ')');  
				if (data.suc == 'suc'){
					$('#dlg').dialog('close');		
					$('#users').datagrid('reload');	
				} else {
					$.messager.alert('添加用户出错！','<span style="text-align:center;margin-left:auto;margin-right:auto;display:bolck">'+data.msg+'</span>','error');
				}
			}
		});
	}

	var pas = ['密码不能包含空格！','密码不能小于8位！','密码只能由数字,大小写字母，+，-，=，\\，/组成！'];
	//表单验证
	$.extend($.fn.validatebox.defaults.rules, {    
		checkPw: {    
			validator: function(value, param){ 
	    		var space = /\s/g;
	    		if(space.test(value)){
	    			$.fn.validatebox.defaults.rules.checkPw.message = pas[0];
	    			$("#userPw").focus();
	    			return false;
	    		}
	    		if(value.length <= 8){
	    			$.fn.validatebox.defaults.rules.checkPw.message =  pas[1];
	    			$("#userPw").focus();
	    			return false;
	    		}
	    		var reg = /^[\w|-|+|=|\/|\\]*$/;
	    		if(!reg.test(value)){
	    			$.fn.validatebox.defaults.rules.checkPw.message =  pas[2];
	    			$("#userPw").focus();
	    			return false;
	    		} 
	            return true;    
	        }
	    },
	    userPwCom :{
		    validator:function(value,param){
				return value == $("#userPw").val()
		 	   },
		    message:"密码和密码确认不一致!"
		    }    
	});

	


	//用户查询
	function searchUser(){

		var createStart = $('#createStart').datebox('getValue');

		var createEnd = $('#createEnd').datebox('getValue');

		if(createStart && createEnd && createStart > createEnd){
			$.messager.alert('时间选择错误！','开始时间不能大于结束时间！','error');
			return false;
		}

		var myQueryParams = $("#searchForm").serialize();
		
		var myurl = '${basePath}/background/jsp/user/user_searchUser?'+myQueryParams;
		$("#users").datagrid({url:myurl });
		//设置尾部栏
		initPager();
		
	}

	//将值进行替换
	function swap(value,row,index){
		return leaf.dataForSwap('role', value);
	}
	//数组格式化
	function formatDate(value,row,index){
		return leaf.formatDate(new Date(value.time),'yyyy-MM-dd');
		}

	var editRow = undefined;


	//设置相关的属性
	function initPager(){
		var pager = $('#users').datagrid('getPager');    // get the pager of datagrid
		console.log(pager);
		pager.pagination({
			showPageList:true,
			pageSize:20,
			buttons:[{
				iconCls:'icon-add',
				handler:function(){
					newUser();
				}
			},{
				iconCls:'icon-edit',
				handler:function(){
	                var row = $("#users").datagrid('getSelected');
	                var myurl = '${basePath}/background/jsp/user/user_updateUser';
	                
					
	                if (row !=null || editRow != undefined  ) {
	                    if (editRow != undefined) {
	                    	$("#users").datagrid('endEdit', editRow);
							if(editRow != undefined){
			                	var editRowDetail =  $('#users').datagrid('getRows')[editRow];
								//保存数据
								leaf.ajax({url:myurl,
										   data:{'user.userId':editRowDetail['userId'],'user.email':editRowDetail['email'],'user.userName':editRowDetail['userName'],'user.qq':editRowDetail['qq'],'user.permission':editRowDetail['permission']},
										   success:function(result){
												var res = eval('('+result+')');
												if(res.msg != 'suc'){
													if(res.msg == 'noPermisison'){
									                     $.messager.alert("错误", "非常抱歉，您所在的用户组没有没有权限更改权限！", "error");
								                     	 $("#users").datagrid('reload');
													}else{
									                     $.messager.alert("错误",res.msg, "error");
														}	
									}
										   }
										  });
							}
							editRow = undefined;
							return ;
	                    }
	 
	                    if (editRow == undefined) {
	                        var index = $("#users").datagrid('getRowIndex', row);
	                        $("#users").datagrid('beginEdit', index);
	                        editRow = index;
	                        $("#users").datagrid('unselectAll');
	                    }
	                } else {
	                     $.messager.alert("提示", "未选中行！", "info");
	                }
	            }
			},{
				iconCls:'icon-no',
				handler:function(){
					var row = $('#users').datagrid('getSelected');
					if(!row){
						$.messager.alert({title:'删除用户',msg:leaf.alertContent('请选择要删除的用户！')});
						}
					var myurl = '${basePath}/background/jsp/user/user_deleteUser?userId='+row['userId'];

					$.messager.confirm('删除','确认删除？',function(e){
						if(e){
							leaf.ajax({url:myurl,success:function deleteSuc(res){
								var res = eval('('+res+')');
								if(res.msg == 'suc'){
									$('#users').datagrid('reload');
								}else if(res.msg == 'noPermission'){
									$.massager.alert('删除出错','您没有权限进行该项操作！请联系管理员！','error');
								}else{
									$.massager.alert('删除出错','删除出错，请稍后再试！','error');
									}
							}});
						}
					});
					}
				}]
		});

		
	}


	function initDetail(){
		$("#users").datagrid({
			detailFormatter: function(rowIndex, rowData){
				alert(123);
				return '<table><tr>' +
						'<td style="border:0">' +
						'<p>Attribute: ' + rowData.email + '</p>' +
						'<p>Status: ' + rowData.permission + '</p>' +
						'</td>' +
						'</tr></table>';
				}
			});
	}
	//设置 
	
	
	$(function(){
		initPager();
	});

</script>
</body>
</html>
