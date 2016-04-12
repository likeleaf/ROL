<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/top.jsp">
	<jsp:param value="书籍列表" name="title"/>
</jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${ctx}/foreground/css/book-menu.css"/>

<l:lists name="Book" var="book" order="bookId desc" limit= "bookId = ${param.bookId }"/>
<l:lists name="BookChaper" var="bc" order="bookChaIndex " limit= "bookId = ${param.bookId }" />


	<!--书籍位置-->
	<div class="path">
		<ol class="breadcrumb">
			<li>当前位置</li>
			<li><a href="#">${book[0].bookType }</a></li>
			<li><a class="active" href="">  ${book[0].bookName }  </a></li>
		</ol>
	</div>


	<!---->
	<div class="container">
		<div class="content">
			<div class="border-split">
				<div class="title">作品相关介绍</div>
				<div class="book-menu">
					<ul class="list-unstyled">
			
					</ul>
					<div class="unflo"></div>
				</div>
			</div>

				<div class="border-split">
				<div class="title">正文</div>
				<div class="book-menu">
					<ul class="list-unstyled">
						<c:forEach var="lab" items="${bc}">
							<li><a href="${ctx }/foreground/jsp/book/book_read.jsp?bookId=${param.bookId }&bookChaId=${lab.bookChaId }">${lab.bookChaTitle }</a></li>
						</c:forEach>
					</ul>
					<div class="unflo"></div>
				</div>
			</div>


		</div>
	</div>


		<hr class="lab-split" style="margin-top: 15px;">
		
		<div class="footer">
			<div class="container">	
				<div class="outer-link"> 
					<strong>友情链接：</strong> 
					<a href="http://www.zhulang.com/">逐浪小说</a> | 
					<a href="http://m.zhulang.com/">逐浪手机</a> | 
					<a href="http://yuedu.163.com/yc">网易云阅读</a> | 
					<a href="http://book.ifeng.com/">凤凰网读书</a> | 
					<a href="http://yc.ireader.com.cn/">掌阅小说网</a> | 
					<a href="http://www.yousuu.com/">优书网</a> | 
					<a href="http://www.tadu.com/">塔读小说</a> | 
					<a href="http://www.17k.com">17K小说网</a> | 
					<a href="http://www.xxsy.net">潇湘小说</a> | 
					<a href="http://www.haoread.com/">浩阅文学</a> | 
					<a href="http://www.xs8.cn">言情小说吧</a> | 
					<a href="http://www.hongshu.com/">红薯小说网</a> | 
					<a href="http://www.heiyan.com/">黑岩阅读网</a> | 
					<a href="http://www.motie.com/">磨铁小说网</a> | 
					<a href="http://www.cjzww.com/">长江中文网</a> | 
					<a href="http://www.xdyqw.com/">心动言情网</a> | 
					<a href="http://www.kongfz.com/">孔夫子旧书</a> | 		
					<a href="http://www.jxvdy.com/">金象微电影</a> | 
					<a href="http://www.shuhai.com/">书海小说网</a> | 
					<a href="http://www.oklink.net/">白鹿书院</a> | 
					<a href="http://www.fmx.cn">凤鸣轩言情小说</a> | 
					<a href="http://www.fbook.net/">天下书盟</a> | 
					<a href="http://book.114la.com/">114啦小说</a> | 
					<a href="http://www.cqph.com/">天健出版</a> | 
					<a href="http://www.sxcnw.net/">书香电子书</a> | 
					<a href="http://www.qwsy.com"> 蔷薇书院</a>| 
					<a href="http://www.lkong.net">龙的天空 </a>|
					<a href="http://www.txtbbs.com">TXT小说网 </a> | 
					<a href="http://www.dm456.com/">动画片大全</a> | 
					<a href="http://www.abada.com/">阿巴达小说网 </a> | 
					<a href="http://www.hxtk.com/">华夏天空小说网 </a> | 
					<a href="http://baike.mipang.com">米胖百科</a> | 
					<a href="http://www.ycsd.cn">原创书殿 </a> | 
					<a href="http://www.duantian.com/">断天小说网 </a> | 
					<a href="http://www.hengyan.com/">恒言中文网 </a> | 
					<a href="http://www.chuangbie.com/">创别书城 </a> | 
					<a href="http://www.txtbook.com.cn/">乐读电子书</a> | 
					<a href="http://book.2345.com/">2345小说大全 </a> | 
					<a href="http://www.feiku.com/">飞库网</a> | 
					<a href="http://www.zhaoxiaoshuo.com/">找小说网 </a> | 
					<a href="http://www.dushu.com/">读书网</a> | 
					<a href="http://xiaoshuo.sogou.com/sites/">搜狗网址大全</a> | 
					<a href="http://www.ouj.com/">偶家中文</a> | 
					<a href="http://hao.uc.cn/">UC网址导航</a> | 
					<a href="http://dm.10086.cn/">咪咕动漫</a> | 
					<a href="http://www.kuaidi.com/">快递单号查询</a> 
				</div>	
			</div>
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