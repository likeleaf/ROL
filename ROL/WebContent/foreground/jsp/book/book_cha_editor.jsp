<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/top.jsp">
	<jsp:param value="编辑章节" name="title"/>
</jsp:include>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="${ctx}/foreground/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/foreground/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <script type="text/javascript">
   
         window.UEDITOR_HOME_URL = "/foreground/ueditor"
        
    </script>
    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
	<c:choose>
		<c:when test="${empty param.bookId || empty param.bookChaId || USER.permission == '10'}">
				<script>
					window.location.href = '${ctx}';
				</script>
		</c:when>
		<c:otherwise>
			<l:lists var="book" name="Book" limit="bookId=${param.bookId }" onlyOne="true"/>
			<c:if test="${book[0].authName != USER.userName }">
				<script>
					window.location.href = '${ctx}';
				</script>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	<l:lists var="bc" name="BookChaper" limit="bookChaId=${param.bookChaId }" onlyOne="true"/>
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
<div>
	<h2 style="text-align: center;">编辑章节</h2>
	<form action="${ctx }/foreground/jsp/book/book_editBookCha" method="post" style="width:1024px;margin-left:auto;margin-right:auto;margin-top:30px">
		<input type="hidden" name="bookChaId" value="${param.bookChaId }">
		<input type="hidden" name="bookId" value="${param.bookId }">
		<input type="hidden" name="content" id="content">
		<input type="text" class="form-control" name="title" placeholder="章节标题" value="${bc[0].bookChaTitle }">
	</form>
    <script id="editor" type="text/plain" style="margin-top:30px;width:1024px;height:500px;margin-left:auto;margin-right:auto;"></script>
    <button class="btn btn-info" onclick="javascript:save()" style="margin-top:30px;width:1024px;margin-left:auto;margin-right:auto;display: block;">提交</button>
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
	<style>
		.footer{
			margin-left:3.5% !important;
		}
	</style>
	</body>
<script>
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');

	$(function(){
       // var content =$('#daily_content').val();
        //判断ueditor 编辑器是否创建成功
        ue.addListener("ready", function () {
        // editor准备好之后才可以使用
    	    ue.setContent('${bc[0].text}');
 
        });
    });


    function save(){
        $('#content').val(getPlainTxt());
		$('form').eq(0).submit();
        }

    function getPlainTxt() {
        return UE.getEditor('editor').getPlainTxt()
    }
</script>