<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../common/top.jsp">
	<jsp:param value="阅读" name="title"/>
</jsp:include>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
 
 
<body>
<style>

</style>
<link rel="stylesheet" type="text/css" href="${ctx }/foreground/css/book-read.css"/>
<body>

	<!-- 顶边栏 登录 注册等相关功能 -->
	<div class="top-nav">
		<div class="container">
			<nav class="top-nav-list">
				<a href="#" class="top-nav-item">登录</a>
				<a href="#" class="top-nav-item">注册</a>
				<a href="#" class="top-nav-item">开通会员</a>
			</nav>
		</div>
	</div>
	
	<div class="split">
		
	</div>
	<l:lists name="Book" var="book" limit="bookId = ${param.bookId }"/>
	<l:lists name="BookChaper" var="bc" limit="bookChaId = ${param.bookChaId }" onlyOne="true"/>
	
	<div class="title">
		<span class="book-name"><a href="">${param.bookName }</a></span>  <span class="part">${bc[0].bookChaTitle }</span>
		<span></span>
	</div>

	<hr>
	<!---->
	<div class="container">
		<div class="content">
			<span class="title">${bc[0].bookChaTitle }</span>
			<span class="intro">
				<span>小说：${book[0].bookName } </span>
				<span>作者：${book[0].authName }</span>
				<span>更新时间：${book[0].bookDate }</span>
				<span>字数：${bc[0].wordSize } </span>
			</span>
		<div class="text-outer">
			<span class="text-show">
				${bc[0].text }
			</span>
		</div>
				<div class="page">
					<div class="page-list">
						<a class="btn btn-default btn-sm active">上一章</a>
						<a class="btn btn-default btn-sm" href="">目录</a>
						<a class="btn btn-default btn-sm disabled" href="">下一章</a>
					</div>
				</div>
		</div>
	</div>


		<hr class="lab-split" style="margin-top: 15px;">
		
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


</html>
<script>



</script>