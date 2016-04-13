<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../common/top.jsp">
	<jsp:param value="账号注册" name="title"/>
</jsp:include>
<body>
<style>

</style>
<link rel="stylesheet" type="text/css" href="${ctx }/foreground/css/register.css"/>
<div class="hidden-window hid"> </div>
		<div class="header">
			<img src="${ctx }/foreground/images/login.png">
		</div>

		<div class="container">
			<div class="content">
				<div class="top">
					<div class="title">
						注册leaf账号
					</div>
					<div class="redirect">
						如果您已经有leaf账号，点此<a href="login.jsp">登录</a>
					</div>
				</div>

				<div class="buttom">
					<div class="register-form">
						<h4>手机注册</h4>
						<form role="form" method="post" action="${ctx}/foreground/jsp/user/user_registUser">
							<input type="text" name="email" id="email" class="form-control" placeholder="邮箱" onchange="emailCheck()" > </input>
							<div class="alert alert-warning hid" id="tishi">
							   <a href="#" class="close" data-dismiss="alert">
							     
							   </a>
							</div>
							<input type="password" id="password" name="password" class="form-control" placeholder="密码"></input>
							<input type="password" id="passwordCheck" name="passwordCheck" class="form-control" placeholder="确认密码" onchange="checkPass()"></input>
							<input type="button" class="btn btn-primary"  value="注册" onclick="save()"></input>
						</form>
					</div>
				</div>
			</div>
		</div>

		
		<div class="footer">
			<hr class="lab-split">
			<div class="container">
				<div class="row"> 
					<div class="col-lg-3">专业：计算机科学与技术</div>
					<div class="col-lg-2">班级：计科2</div>
					<div class="col-lg-2">学号：20122308045</div>
					<div class="col-lg-2">指导老师：李振宏</div>
					<div class="col-lg-3">设计题目：在线阅读设计与实现</div>
				</div>
			</div>	

		</div>
		<hr class="lab-split">
		<hr class="lab-split">


</body>

<script type="text/javascript">
	var saveStr = ''
	function emailCheck(){
		var email = $("#email").val();
		if(!email){
			showTips("email不能为空！","email");
			return false;
		}else if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/g.test(email)){
			showTips("email格式错误","email");
			return false;
		}else{
			email = encodeURI(email);
			leaf.ajax({url:'${ctx}/foreground/jsp/user/user_checkEmail',success:doSuc,data:{'email':email},dataType:'json'
				});
		}
	}
	function doSuc(msg){
		if(msg.stat == 'fal'){
			showTips(msg.msg,"email");
			this.saveStr = '';	
			return false;
		}else if(msg.stat == 'suc'){
			if('save' == saveStr){
				$('form').submit();
			}
			showTips("email可以使用","email","信息:");
			$('#tishi').removeClass('alert-warning');
			$('#tishi').addClass('alert-success');
		}
	}
	


	function showTips(content,id,strongStr){
		if(!strongStr){
			strongStr = '警告:';
			}
		$('#tishi').removeClass('alert-success');
		$('#tishi').addClass('alert-warning');
		$("#tishi").children('span').remove();
		$("#tishi").append("<span><strong>"+strongStr+"</strong>"+content+"</span>");
		$("#tishi").removeClass("hid");
		$("#"+id).addClass("has-error");
	}

	function checkPass(){
		var pass = $('#password').val();
		var passC = $('#passwordCheck').val();
		if(!pass || !passC){
			showTips("密码和确认密码不能为空！");
			return false;
			}
		if(pass != passC){
			showTips("两次的密码不一致！");
			return false;
		}
		showTips("密码可以使用","email","信息:");
		$('#tishi').removeClass('alert-warning');
		$('#tishi').addClass('alert-success');
		return true;
	}


	function save(){
		this.saveStr = 'save';
		if(!checkPass()){
			return false;
		}
		emailCheck();
	}
	

</script>
</html>