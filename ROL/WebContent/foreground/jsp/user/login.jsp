<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../common/top.jsp">
	<jsp:param value="账号登录" name="title"/>
</jsp:include>
<body>
<style>

</style>
<link rel="stylesheet" type="text/css" href="${ctx }/foreground/css/login.css"/>
<body>

		<div class="header">
			<img src="${ctx }/foreground/images/login.png">
		</div>

		<hr class="lab-split">
		<div class="form">
			<form role="form" method="post" action="${ctx}/foreground/jsp/user/user_login">
				<input type="text" id="email" name="email" class="form-control" placeholder="邮箱"></input>
				<div class="alert alert-warning hid" id="tishi">
					<a href="#" class="close" data-dismiss="alert">
								     
					</a>
				</div>
				<input type="password" id="password"  name="password" class="form-control" placeholder="密码"></input>
				<input type="button" class="btn btn-primary" value="登录" onclick="save()"></input>
			</form>
				
			<div>
				<div>
					<div class="checkbox">
					            <label>
					               <input type="checkbox"> 请记住我
					            </label>
	        		</div>
	        		<span class="redirect"><a href="">忘记密码？</a><a href="">注册</a></span>	
        		</div>	
    		</div>
    		<div class="unflo"></div>
			
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
	function emailCheck(){
		var email = $("#email").val();
		if(!email){
			showTips("email不能为空！","email");
			return false;
		}else if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/g.test(email)){
			showTips("email格式错误","email");
			return false;
		}else{
			$('#tishi').addClass('hid');
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
		if(!pass){
			showTips("密码不能为空！");
			return false;
			}
		return true;
	}


	function save(){
		if(!checkPass()){
			return false;
		}
		emailCheck();
		$('form').submit();
	}
</script>
</html>