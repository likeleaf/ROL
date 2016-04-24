<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../common/top.jsp">
	<jsp:param value="书籍详细信息" name="title"/>
</jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${ctx}/foreground/css/detail.css"/>

	<l:lists name="Book" var="book" order="bookId desc" limit= "bookId = ${param.bookId }" onlyOne="true"/>
	<l:lists name="BookChaper" var="bc" order="bookChaIndex desc" limit= "bookId = ${param.bookId }" pageCount="20"/>

	<!--书籍位置-->
	<div class="path">
		<ol class="breadcrumb">
			<li>当前位置</li>
			<li><a href="${ctx }/foreground/jsp/book/display.jsp?bookType=${book[0].bookType }">${book[0].bookType }</a></li>
			<li><a class="active" href="">  ${book[0].bookName }  </a></li>
		</ol>
	</div>

	<c:set var="authName" value="${book[0].authName }"></c:set>
	<!---->
	<div class="container">
		<div class="content">
			<div class="book-detail">
				<div class="book-img flo">
					<div class="img">
						<img src="${book[0].bookImg }" width="180px" height="250px">
					</div>
					<div class="function">
						<a class="btn btn-default" href="">打赏作品</a>
						<a class="btn btn-default" href="">送张月票</a>
						<a class="btn btn-default" href="">送朵鲜花</a>
						<a class="btn btn-default" href="javascript:;" onclick="javascript:downloadBook('${param.bookId }')">下载本书</a>
						<div class="alert alert-warning hid" id="tishi">
							<a href="#" class="close" data-dismiss="alert" >
							</a>
						</div>
					</div>
				</div>
				<div class="detail flo">
					<div class="detail-content">
						<div class="top">
							<div class="head">
								<label class="title cur" id="bookName"  ondblclick="javascript:setBookProperties('书名','bookName','bookName')"> ${book[0].bookName }</label><label class="auth">作者： ${book[0].authName }</label>
							</div>
							<div class="info">
								 <span>类别：${book[0].bookType }</span> <span>点击：-</span> <span>字数：2448367</span><span> 授权：A级签约</span>
							</div>
						</div>
						<div class="buttom" style="marfin-button:20px">
							<div class="intro cur" id="bookDes" ondblclick="javascript:setBookProperties('书籍简介','bookDes','bookDes')">
									${book[0].bookDes }
							</div>
							<div class="check">
								<button class="btn btn-primary" onclick="redirect('${book[0].bookId }')">开始阅读</button>
								<button class="btn btn-default">加入书架</button>
							</div>
							<div class="lastest">
								<h5><label class="back flo" style="padding-left:20px;width:300px"><a href="${ctx }/foreground/jsp/book/book_read.jsp?bookId=${book[0].bookId }&&bookChaId=${bc[0].bookChaId }">${bc[0].bookChaTitle }</a></label> <span class="time">2015-10-31 18:20:00</span></h5>
								<span>
										${fn:substring(bc[0].text,0,400)}
								</span>
							</div>

						</div>
					</div>
				</div>
				<div class="unflo"></div>
			</div>
			<!-- 模态框 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
			   aria-labelledby="myModalLabel" aria-hidden="true">
			   <div class="modal-dialog">
			      <div class="modal-content">
			         <div class="modal-header">
			            <button type="button" class="close" 
			               data-dismiss="modal" aria-hidden="true">
			                  &times;
			            </button>
			            <h4 class="modal-title" id="myModalLabel">
			           <span id="modalTitle"></span>
			            </h4>
			         </div>
			         <div class="modal-body">
			  			<input id="bookProperties" class="form-control"/>
			         </div>
			         <div class="modal-footer">
			            <button type="button" class="btn btn-default" 
			               data-dismiss="modal">关闭
			            </button>
			            <button type="button" onclick="save()" class="btn btn-primary">
			               提交更改
			            </button>
			         </div>
			      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>

			
			<div class="book-menu">
				<h3>仁者天下  章节目录</h3>
				<hr class="lab-split">
				<ul class="list-unstyled">
				<c:forEach var="lab" items="${bc }">
					<li><a href="${ctx }/foreground/jsp/book/book_read.jsp?bookId=${book[0].bookId }&&bookChaId=${lab.bookChaId }">${lab.bookChaTitle }</a></li>
				</c:forEach>
				</ul>
				<div class="unflo"></div>
				<button class="btn btn-success" onclick="redirect('${book[0].bookId }')"> 查看全部章节</button>
				<button class="btn btn-info	" onclick="redirect('${book[0].bookId }')"> 订阅全部章节</button>
			</div>

			<!--书籍评论-->
			<div class="book-comment">
				<div class="header">
					<label class="title">仁者天下  书评区</label>
					<label class="comment-count">全部123条 </label>
					<button class="btn btn-default btn-sm">我要评论</button>
				</div>
				<div class="comment-input">
					<textarea class="form-control" cols="4"></textarea>
				</div>
				<ul class="list-unstyled comment-detail">
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li><li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>
					<li>
						<div class="img"><img class="img-circle" src="${ctx}/foreground/images/user-icon/1.gif.jpg"></div>
						<div class="comment-display">
							<div class="owner">
								厚土
							</div>
							<div class="comment-content">
								大帅哥，强烈要求加更！好书，荡气回肠让人回味，跪求加更！《逆尘》前来问坊，望回坊，新人写作之路艰辛，需要道友间相互扶持！！！求赞！求赏！求花！求收藏！求订阅，新人写作之路艰辛，需要道友间相互扶持！！！
							</div>
							<div class="date">2015-10-23 17:19:44</div>
						</div>
						<div class="unflo"></div>
					</li>

					
				</ul>

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
	</div>


		<hr class="lab-split">
		
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
<c:if test="${not empty USER && not empty authName && authName == USER.userName}">
	<c:set var="permission" value="20"></c:set>
</c:if>
</html>
${USER.userName }===${authName }
<script>

var bookId = '${param.bookId }';
var str ;
var pro;
var id;
var permission = '${permission}';
function save(){
	if(permission != "20"){
		return false;
		}
	var value = $('#bookProperties').val();
	if(!value){
		alert(str+'不能为空');
		return ;
	}
	if($('.top .head.title').eq(0).text() == value){
		alert(str+'和原'+str+'相同');
		return;
	}
   var myurl = '${ctx}/foreground/jsp/book/book_updateBookProperties?bookId='+bookId+'&'+pro+'='+value+'&type='+pro;
	leaf.ajax({url:myurl,dataType:'json',success:doBookProperties});
}

function setBookProperties(str1,pro1,id1){
	
	if(permission != "20"){
		return false;
		}
	str = str1;
	pro = pro1;
	id = id1;
	setModalTitle(str+"修改");
	$('#myModal').modal("show");
	
}

function doBookProperties(msg){
	$('#myModal').modal("hide");
	if(msg.stat == 'suc'){
		$('#'+id).html($('#bookProperties').val());
		leaf.msg('修改成功');
		value = $('#bookProperties').val("");
		
	}else if(msg.stat == 'fal'){
		leaf.msg(msg.msg);
		}
	
}



function setModalTitle(str){
	
	$("#modalTitle").html(str);
}


function redirect(val){
	   window.location.href='${ctx}/foreground/jsp/book/book_menu.jsp?bookId='+val; 
}

function downloadBook(bookId){
	var myurl = '${ctx}/foreground/jsp/book/book_checkPermission?bookId='+bookId;

	leaf.ajax({url:myurl,success:doDownloadBook,dataType:'json'});
}

function doDownloadBook(msg){
	var myurl = '${ctx}/foreground/jsp/book/book_downloadBook';
	if('fal' == msg.stat){
		if('10' == msg.msg){//未登录
			showTips("请登录");
			
		}else{//
			showTips(msg.msg);
		}
	}else if('suc' == msg.stat){
		window.open(myurl,"_blank");
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

</script>