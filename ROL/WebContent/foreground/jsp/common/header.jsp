<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
 <script>
	function search(){
		var value = document.getElementById("searchName").value;
		if(!value){
			return false;
		}
		window.open('${ctx}/foreground/jsp/book/book_show.jsp?name='+value,"_blank");
		return false;
		
	}
 </script>
<body>

	<!-- 顶边栏 登录 注册等相关功能 -->
	<div class="top-nav">
		<div class="container">
			<nav class="top-nav-list">
				<c:choose>
					<c:when test="${not empty USER}">
						<a href="${ctx }/foreground/jsp/user/login.jsp" class="top-nav-item">欢迎您，${sessionScope.USER.userName}</a>
						<a href="${ctx }/foreground/jsp/user/user_logout" class="top-nav-item" class="top-nav-item">退出</a>
						
					</c:when>
					<c:otherwise>
						<a href="${ctx }/foreground/jsp/user/login.jsp" class="top-nav-item">登录</a>
						<a href="${ctx }/foreground/jsp/user/register.jsp" class="top-nav-item" class="top-nav-item">注册</a>
					</c:otherwise>
				</c:choose>
					
				<a href="#" class="top-nav-item">开通会员</a>
			</nav>
		</div>
	</div>
	
	<div class="container">
		<!-- 搜索栏 -->
		<div class="search-lab" style="margin-top: 2px">
			<div class="container" >
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-md-offset-1 col-md-offset-1 col-lg-offset-1 hidden-xs">					
						<a href="${ctx }" class="logo" title="leaf阅读网"></a>
					</div>
					<div class="col-lg-6 col-md-7 col-sm-8">
						<form class="form-group form" rol="search">
							<div class="input-group">
								<input class="form-control" type="text" name="name" id="searchName" placeholder="请输入要查找的书籍名"></input>
								<div class="input-group-btn"><button class="btn btn-default" onclick="javascript:search();">搜索</button></div>
							</div>
							<p class="book-display"> 
								<a href="" class="book-dispaly-item">完美世界</a>
								<a href="" class="book-dispaly-item">雷武</a>
								<a href="" class="book-dispaly-item">星战风暴</a>
								<a href="" class="book-dispaly-item hidden-xs">帝霸</a>
								<a href="" class="book-dispaly-item hidden-xs">遮天</a>
								<a href="" class="book-dispaly-item hidden-sm hidden-xs">飘渺神之旅</a>
							</p>
							<input type="text" name="forhidden" style="display:none"/>
						</form>
					</div>
					<div class="col-lg-3 col-md-2 col-sm-1"  ></div>
				</div>	
			</div>	
		</div>
			
		<!-- 导航栏 -->
		<div class="container extra" >
			<div class="">
			 	<ul class="nav nav-tabs nav-justified nav-bar" >
			 		<li class="">
			 			<a href="${ctx }">首页</a>
			 		</li>
			 		<li>
			 			<a href="">全本小说</a>
			 		</li>
			 		<li>
			 			<a href="">排行榜</a>
			 		</li>
			 		<li>
			 			<a href="${ctx }/foreground/jsp/book/display.jsp">书库</a>
			 		</li>
			 		<li>
			 			<a href="">充值</a>
			 		</li>
			 			<li>
			 			<a href="">作者</a>
			 		</li>
			 		<li>
			 			<a href="">管理员专区</a>
			 		</li>
			 	</ul>
			</div>		
		</div>

		<!-- 具体分类 -->
		<div class="kind-bar">
			<div class="container extra">
				<ul class="kind-list list-inline">
					<li>频道：</li>
					 <l:lists  var="t" type="sql" sql="SELECT DISTINCT BOOK_TYPE FROM BOOKS" checkClass="false"/>
					 <c:forEach var="lab" items="${t }">
						<li><a href="${ctx }/foreground/jsp/book/display.jsp?bookType=${lab }" data-type="bookType">${lab }</a></li>
					 </c:forEach>
				</ul>
			</div>
		</div>
		
		
		</div>