<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/top.jsp">
	<jsp:param value="书籍详细信息" name="title"/>
</jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${ctx}/foreground/css/display.css"/>

<%-- <l:lists name="Book" var="book" order="bookId desc" limit= "bookId = ${param.bookId }" onlyOne="true"/>
<l:lists name="BookChaper" var="bc" order="bookChaIndex desc" limit= "bookId = ${param.bookId }" pageCount="20"/> --%>

	
	<!--书籍选择展示-->
	<div class="container">
		<div class="content">
			<div class="produce-h3"><a name="top" href="#top">全本</a></div>
			<hr class="blue-line">

			<div class="book-select">
				<div class="book-select-title">
					作品频道:
				</div>
				<ul class="book-display-list list-unstyled">
					<li><a id="init" class="cur" href="javascript:;" data-type="bookType">全部</a></li>
					 <l:lists  var="t" type="sql" sql="SELECT DISTINCT BOOK_TYPE FROM BOOKS" checkClass="false"/>
					 <c:forEach var="lab" items="${t }">
						<li><a href="javascript:;" data-type="bookType">${lab }</a></li>
					 </c:forEach>
				</ul>
			</div>
			<div class="unflo">
				
			</div>
				<div class="book-select">
				<div class="book-select-title">
					作品字数:
				</div>
				<ul class="book-display-list list-unstyled">
					
					<li><a href="javascript:;">不限</a></li>
					
					
					
					<li><a href="javascript:;">30万以下</a></li>
					<li><a href="javascript:;">30-50万</a></li>
					<li><a href="javascript:;">50-100万</a></li>
					<li><a href="javascript:;">100-200万</a></li>
					<li><a href="javascript:;">200万以上</a></li>

				</ul>
			</div>
			<div class="unflo"></div>
		

		
			<div class="book-select">
				<div class="book-select-title">
					更新时间:
				</div>
				<ul class="book-display-list list-unstyled">
					
					<li><a href="javascript:;">不限</a></li>
					<li><a href="javascript:;">三日内</a></li>
					
					
					<li><a href="javascript:;">七日内</a></li>
					<li><a href="javascript:;">半月内</a></li>
					<li><a href="javascript:;">一月内</a></li>
		

				</ul>
			</div>
			<div class="unflo"></div>

			<div class="book-select">
				<div class="book-select-title">
					排序方式:
				</div>
				<ul class="book-display-list list-unstyled">
					
					<li><a href="javascript:;">更新时间</a></li>
					<li><a href="javascript:;">点击数</a></li>
					
					<li><a href="javascript:;">鲜花数</a></li>
		

				</ul>
			</div>
			<div class="unflo"></div>


			<table class="table table-hover">
				<tr class="success">
					<th width="10%">序号</th>
					<th width="44%">书名</th>
					<th width="10%">作者</th>
					<th width="10%">字数</th>
					<th width="10%">点击</th>
					<th width="16%">更新时间</th>
				</tr>

			<!-- 	<tr>
					<td style="color: #ff6600">1</td>
					<td> 	[异世大陆]   <a href=""> 战梦天道</a> <a href="">完本感言</a> </td>
					<td><a href="">永世幻生</a></td>
					<td>1231231</td>
					<td>12312</td>
					<td> 2016-03-31 15:48:55</td>
				</tr>
				<tr>
					<td style="color: #ff6600">1</td>
					<td> 	[异世大陆]   <a href=""> 战梦天道</a> <a href="">完本感言</a> </td>
					<td><a href="">永世幻生</a></td>
					<td>1231231</td>
					<td>12312</td>
					<td> 2016-03-31 15:48:55</td>
				</tr><tr>
					<td style="color: #ff6600">1</td>
					<td> 	[异世大陆]   <a href=""> 战梦天道</a> <a href="">完本感言</a> </td>
					<td><a href="">永世幻生</a></td>
					<td>1231231</td>
					<td>12312</td>
					<td> 2016-03-31 15:48:55</td>
				</tr><tr>
					<td style="color: #ff6600">1</td>
					<td> 	[异世大陆]   <a href=""> 战梦天道</a> <a href="">完本感言</a> </td>
					<td><a href="">永世幻生</a></td>
					<td>1231231</td>
					<td>12312</td>
					<td> 2016-03-31 15:48:55</td>
				</tr> -->
			</table>
			<hr class="lab-split">
			<div class="page">
				<div class="page-list">
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
	//用来存放选中的标签的内容
	var arr = {};
	var myurl = '${ctx}/ajax/ajax_ajax?'
	var rowCount;
	var pageCount = 30;
	var pageNow = 1;
	var likeLimit;

	var def = ['全部'];
	$(function(){
		$('.book-display-list li a').on("click",function(e){
			dealPage(e);			
		});
		var value = leaf.getQueryValue('bookType');
		value = decodeURI(value);
		if(value){
			var aLab = $('.book-display-list.list-unstyled li').children('a[data-type=bookType]');
			for(var i = 0;i<aLab.length;i++){
				if(aLab.eq(i).text() == value){
					aLab.eq(i).click();
					break;
					}
				}
		}else{
			$('#init').click();	
		}

		dealPage();
	});

	

	//ajax从后台查找数据
	function dealPage(e){
		var temp = '';
		if(e){
			pageNow = 1;
			$(e.target).parent().parent().children().children().removeClass('cur');
			$(e.target).addClass('cur');
			var key = $(e.target).attr("data-type");
			if(!key){
				return;
				}
			var value = $(e.target).text();
			arr[key] = value;
			for(var key in arr){
				var str = arr[key];
				for(var k in def){
					if(def[k] == str){
						str = '';
						break;
						}	
				}
				temp = 'and ' +key+ ' = '+str+'' ;
			}
			if(temp.length > 1){
				temp = "'"+temp.substr(3)+"'";
				}
			 likeLimit = temp;
	   }
		var jsonStr =  "{'name':'Book','likeLimit':"+likeLimit+",'pageCount':"+pageCount+",'showCount':true,'pageNow':"+pageNow+"}";
		jsonStr = "json=" + encodeURI(jsonStr);
		
		leaf.ajax({url:myurl+jsonStr,dataType:'json',success:doPage});

	}

	function doPage(msg){
		var obj = $('.table.table-hover');
			obj.children().remove();	
		var str = "";
		var i=1;
		rowCount = msg.count;
		msg = msg.pojo;
		for(var key in msg){
			str  += '<tr> <td style="color: #ff6600">'+i+'</td><td> 	['+msg[key]['bookType']+']   <a href=""> '+msg[key]['bookName']+'</a> <a href="">完本感言</a> </td>'
			+'<td><a href="">'+msg[key]['authName']+'</a></td>'
			+'<td>1231231</td>'
			+'<td>12312</td>'
			+'<td> 2016-03-31 15:48:55</td>'+
			+'</tr>';
			obj.append($(str));
			str = ""
			i++;
		}	

		doSplitPage();
	}

	function doSplitPage(){
		var pageNumber = rowCount%pageCount==0?parseInt(rowCount/pageCount):parseInt(rowCount/pageCount)+1;
		var page = $('.page .page-list');
		page.children().remove();
		
		//第一页
		if(pageNow != 1){
			page.append(getNumberPage("首页"));
		}
		if(pageNow -2 >0){
			page.append(getNumberPage(pageNow-2));
		}
		if(pageNow -1>0){
			page.append(getNumberPage(pageNow-1));
		}
		var row = getNumberPage(pageNow);
		page.append(row.addClass('active'));
		if(pageNow+1 <= pageNumber ){
			page.append(getNumberPage(pageNow+1));
		}
		if(pageNow+2 <= pageNumber ){
			page.append(getNumberPage(pageNow+2));
		}
		if(pageNow !=  pageNumber){
			page.append(getNumberPage('末页'));
		}
		page.children().on('click',function(e){
			if('首页' != $(e.target).text() && '末页' != $(e.target).text()){
				doSplitPage();
			}
			pageNow = parseInt($(e.target).text());
			if('首页' == $(e.target).text()){
				pageNow = 1;
				
			}
			if('末页' == $(e.target).text()){
				pageNow = pageNumber;
			}
			dealPage();
			document.location.href = document.location.href.split("#")[0]+"#top";

		});
				
			
	}

	function getNumberPage(page){
		var row = $('<a class="btn btn-default btn-sm"></a>');
		row.html(page+"");
		return row;
	}

</script>
</html>