<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/top.jsp">
	<jsp:param value="书籍列表" name="title"/>
</jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${ctx}/foreground/css/book-show.css"/>
<c:choose>
	<c:when test="${not empty param.author}">
		<l:lists var="book" name="Book"  limit="authName = '${USER.userName }'" showCount="true" limitCheck="true"/>
	</c:when>
	<c:otherwise>
		<l:lists var="book" type="hql" name="Book" hql="from Book where bookName like '#${param.name }#' or authName like '#${param.name }#' or bookDes like '#${param.name }#'" showCount="true" />
	</c:otherwise>
</c:choose>
<div class="container">
	<div class="container">
		<div class="content">
			<div class="book-show-top">
				<div class="show-text">
					共查询到${count }本和“<strong>
					<c:choose>
						<c:when test="${not empty param.author}">
							${user.userName }
						</c:when>
						<c:otherwise>
							${param.name }					
						</c:otherwise>
					</c:choose>
					</strong>”相关的作品
				</div>
			</div>

			<div class="book-show-list">
			<c:forEach var="b" items="${book }">
				<div class="book-show-item" id="book${b.bookId}">
					<dl>
						<dt>
							<a href=""><img src="${b.bookImg }"></a>						
						</dt>
						<dd>
							<strong><a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${b.bookId}">${b.bookName }</a>(<a href="${ctx }/foreground/jsp/book/bookshow.jsp?auth=auth">${b.authName }（著）</a>)</strong>
							<p>
								<strong>${b.bookType } | <l:lists var="bc" name="BookChaper" limit="bookId=${b.bookId }" order="bookChaIndex desc"/> ${bc[0].bookChaTitle }| 更新：2016-04-16 01:00:00</strong>
							</p>
							<p class="intro">
								${b.bookDes }
							</p>
							<div>
								<a href="${ctx }/foreground/jsp/book/book_menu.jsp?bookId=${b.bookId}" class="btn btn-success">开始阅读</a>
								<a class="btn btn-info">加入书架</a>
								<c:if test="${USER.permission == '20' && USER.userName == b.authName}">
									<a href="javascript:;" class="btn btn-info" onclick="javascript:deleteBook('${b.bookId}')">删除本书</a>
								</c:if>
							</div>
						</dd>													
					</dl>
				</div>
			</c:forEach>
				<div class="unflo"></div>
			</div>

			<div class="page">
				<div class="page-list">
					<a class="btn btn-default btn-sm active">第一页</a>
					<a class="btn btn-default btn-sm" href="">1</a>
					<a class="btn btn-default btn-sm" href="">2</a>
					<a class="btn btn-default btn-sm" href="">3</a>
					<a class="btn btn-default btn-sm" href="">4</a>
					<a class="btn btn-default btn-sm" href="">5</a>
					<a class="btn btn-default btn-sm" href="">6</a>
					<a class="btn btn-default btn-sm" href="">...</a>
					<a class="btn btn-default btn-sm disabled" href="">最后一页</a>
				</div>
			</div>

		</div>
	</div>


	<!--尾部 -->
	</div>
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

<script type="text/javascript">
	var book = '';
	function deleteBook(bookId){
		book = bookId; 
		if(!bookId){
			alert("请刷新重试！");
			}
		var myurl = '${ctx}/foreground/jsp/book/book_deleteBook?bookId='+bookId;

		if(confirm('确认删除本书？')){
			leaf.ajax({url:myurl,success:doDeleteBook,dataType:'json'});
		}

	}

	function doDeleteBook(msg){
		if(msg.stat == 'fal'){
			leaf.msg(msg.msg);
		}else if('suc' == msg.stat){
			leaf.msg('书籍删除成功');
			$('#book'+book).remove();
		}
		
		}
</script>
</html>