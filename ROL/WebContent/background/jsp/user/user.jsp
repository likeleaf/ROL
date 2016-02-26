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
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!-- <th field="userId" width="150">用户id</th> -->
				<th field="userName" width="100">用户名</th>
				<th field="email" width="100">email</th>
				<th field="qq" width="80">QQ</th>
				<th field="createTime"  width="50" formatter='formatDate'>创建时间</th>
				<th field="permission" width="50" formatter='swap'>用户权限</th>
			</tr>
		</thead>
	</table>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px;text-align:center"
			closed="true" buttons="#dlg-buttons">
		<div  style="text-align:center;font-weight:700">用户添加</div><br>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>电子邮件<span style='color:red;'>*</span>:</label>
				<input name="user.email" id="email" class="easyui-validatebox" title="123312" validType="email" required="true">
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
		        		<input class="easyui-validatebox" type="text" style="width:80px" name="userName"/> 
						<span>　</span>
					</td>
		       		<td>
		       			 <label for="email">电子邮件:</label>   
		        		 <input class="easyui-validatebox" type="text" style="width:80px" name="email" />   
		        		 <span>　</span>
		    	    </td>
					<td>
				        <label for="email" colspan='2'>创建时间:</label>   
				        <input class="easyui-datebox" type="text" id="createStart" name="createStart" style="width:95px" data-options="editable:false"/> 
				        <input class="easyui-datebox" type="text" id="createEnd" name="createEnd" style="width:95px" data-options="editable:false"/> 
				        <span>　</span>  
		       		</td>
		       		<td>
				        <label for="email">用户角色:</label>   
						<select id="permission" class="easyui-combobox" name="permission" style="width:80px;" data-options="editable:false">   
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
	//校验密码的一致
	function checkPwCom(){
		if($('userPw').val() != $('userPwCom').val()){
			leaf.toolsTip("userPwCom", "密码和确认密码不一致！");
			return false;
			}
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
					$.messager.alert({
						title: '添加用户出错！',
						msg: '<span style="text-align:center;margin-left:auto;margin-right:auto;color:red;display:bolck">'+data.msg+'</span>'
					});
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

	
	//删除用户
	function removeUser(){
		var row = $('#dg').datagrid('getSelected');
		
		if (row){
			$.messager.confirm('Confirm','确认删除？',function(r){
				if (r){
					$.post('${basePath}/background/jsp/user/user_removeUser',{id:row.id},function(result){
						if (result.success){
							$('#dg').datagrid('reload');	
						} else {
							$.messager.show({	
								title: '错误信息',
								msg: result.msg
							});
						}
					},'json');
				}
			});
		}
	}

	//用户查询
	function searchUser(){
		var myurl = '${basePath}/background/jsp/user/user_searchUser';

		var createStart = $('#createStart').datebox('getValue');

		var createEnd = $('#createEnd').datebox('getValue');

		if(createStart && createEnd && createStart > createEnd){
			$.massage.alert({mag:'开始时间不能大于结束时间！'});
			return false;
		}
		
		$('#searchForm').form('submit',{
			url: myurl,
			onSubmit: function(){
				return true;
			},
			success: function(result){
				var data = eval('(' + result + ')');  
				if (data.suc == 'suc'){
					$('#users').datagrid('reload');	
				} else {
					$.messager.alert({
						title: '查询出错！',
						msg: '<span style="text-align:center;margin-left:auto;margin-right:auto;color:red;display:bolck">'+data.msg+'</span>'
					});
				}
				return false;
			}
		});
	}

	//将值进行替换
	function swap(value,row,index){
		return leaf.dataForSwap('role', value);
	}
	//数组格式化
	function formatDate(value,row,index){
		return leaf.formatDate(new Date(value.time),'yyyy-MM-dd');
		}

	//创建底面的一栏
	function init(){
		var pager = $('#users').datagrid('getPager');    // get the pager of datagrid
		pager.pagination({
			showPageList:false,
			buttons:[{
				iconCls:'icon-search',
				handler:function(){
					alert('search');
				}
			},{
				iconCls:'icon-add',
				handler:function(){
					newUser();
				}
			},{
				iconCls:'icon-edit',
				handler:function(){
					alert('edit');
				}
			}]
		});

	}

	
	
	$(function(){
		init();
	});

</script>
</body>
</html>