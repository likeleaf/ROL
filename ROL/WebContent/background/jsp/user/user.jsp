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
<link rel="stylesheet" type="text/css" href="${basePath }/css/background/easyui.css">
<script type="text/javascript" src="${basePath }/js/common/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }/js/common/leaf.js"></script>
<script type="text/javascript" src="${basePath }/js/background/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath }/js/background/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="users" title="用户" class="easyui-datagrid" style="width:700px;height:250px"
			url="${basePath }/background/jsp/user/user_getUserJson"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="userId" width="50">用户id</th>
				<th field="userName" width="50">用户名</th>
				<th field="email" width="50">email</th>
				<th field="qq" width="50">QQ</th>
				<th field="createTime" width="50">创建时间</th>
				<th field="permission" width="50">用户权限</th>
			</tr>
		</thead>
	</table>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px;text-align:center"
			closed="true" buttons="#dlg-buttons">
		<div  style="text-align:center;font-weight:700">用户添加</div><br>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>用户名<span style='color:red;'>*</span>:　</label>
				<input name="userName" id="userName" class="easyui-validatebox" title="123312" onchange="checkName()">
			</div>
			<div class="fitem">
					<label>用户密码<span style='color:red;'>*</span>:</label>
						<input name="userPw" id="userPw"  class="easyui-validatebox" type="password" onchange="checkPw()">
			</div>
			<div class="fitem">
				<label>密码确认<span style='color:red;'>*</span>:</label>
				<input name="userPwCom"  class="easyui-validatebox"  type="password" onchange="checkUnique()">
			</div>
		</form>
	</div>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">修改用户</a>
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
	//校验用户名是否存在
	function checkNameSuc(msg){
		if(msg == 'err')
			alert('参数错误');
		if(msg == 'fal')
			alert('用户名已存在');
		if(msg == 'suc')
			 $.messager.alert('true');
		}
	//校验用户名的唯一性
	function checkUnique(){
		if($('userPw').val() != $('userPwCom').val()){
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
		$('#fm').form('submit',{
			url: myurl,
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
				if (result.suc == 'suc'){
					$('#dlg').dialog('close');		
					$('#dg').datagrid('reload');	
				} else {
					$.messager.show({
						title: 'Error',
						msg: result.msg
					});
				}
			}
		});
	}
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

	//easyui的tips
	function easyuiTips(id,content){
		$('#'+id).tooltip({
		    position: 'right',
		    content: '<span style="color:#fff">'+content+'</span>',
		    trackMouse:true,
		    
		    onShow: function(){
				$(this).tooltip('tip').css({
					backgroundColor: '#666',
					borderColor: '#666'
				});
		    },
		    onHide:function(){}
		});
	}

	//密码规则
	var pas = ['密码不能包含空格！','密码不能小于8位！','密码只能由数字大小写，+，-，=，\\，/组成！'];
	//校验密码
	function checkPw(){
		var value = $("#userPw").val();
		var space = /\s/g;
		if(space.test(value)){
			leaf.toolsTip("userPw", pas[0])
			$("#userPw").focus();
			return false;
		}
		if(value.length < 8){
			leaf.toolsTip("userPw", pas[1])
			$("#userPw").focus();
			return false;
		}
		var reg = /^[\w|-|+|=|\/|\\]*$/;
		if(reg.test(value)){
			leaf.toolsTip("userPw", pas[2])
			$("#userPw").focus();
			return false;
		} 
	}
	
	
	//密码提示框
	$(function(){
		var html = '';
		html += '<ol>'
		for(var i = 0;i < pas.length;i++){
			html += '<li>'+pas[i]+'</li>';
			}
		html += '</ol>';
		
		easyuiTips('userPw',html);
	});
</script>
</body>
</html>