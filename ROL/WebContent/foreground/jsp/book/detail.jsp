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
			<li><a href="#">${book[0].bookType }</a></li>
			<li><a class="active" href="">  ${book[0].bookName }  </a></li>
		</ol>
	</div>


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
					</div>
				</div>
				<div class="detail flo">
					<div class="detail-content">
						<div class="top">
							<div class="head">
								<label class="title"> ${book[0].bookName }</label><label class="auth">作者： ${book[0].authName }</label>
							</div>
							<div class="info">
								 <span>类别：${book[0].bookType }</span> <span>点击：-</span> <span>字数：2448367</span><span> 授权：A级签约</span>
							</div>
						</div>
						<div class="buttom" style="marfin-button:20px">
							<div class="intro">
									${book[0].bookDes }
							</div>
							<div class="check">
								<button class="btn btn-primary">开始阅读</button>
								<button class="btn btn-default">加入书架</button>
							</div>
							<div class="lastest">
								<h5><label class="back flo" style="padding-left:20px;width:300px">${bc[0].bookChaTitle }</label> <span class="time">2015-10-31 18:20:00</span></h5>
								<span>
										${fn:substring(bc[0].text,0,200)}
								</span>
							</div>

						</div>
					</div>
				</div>
				<div class="unflo"></div>
			</div>

			
			<div class="book-menu">
				<h3>仁者天下  章节目录</h3>
				<hr class="lab-split">
				<ul class="list-unstyled">
					<li><a href="">第五九四章 公孙冶之死</a></li>
					<li><a href="">第五九五章 杨战天之死</a></li>
					<li><a href="">第五九六章 阶下囚</a></li>
					<li><a href="">第五九七章 最后的一战</a></li>
					<li><a href="">第五九八章 天下一统</a></li>
					<li><a href="">第五九九章 恶有恶报</a></li>
					<li><a href="">第六零零章 回到原来的世界</a></li>
					<li><a href="">第六零一章 龙组的出现</a></li>
					<li><a href="">第六零二章 萧诚的报复</a></li>
					<li><a href="">第六零三章 强大的萧诚</a></li>
					<li><a href="">第六零四章 归来的萧晨</a></li>
					<li><a href="">第六零五章 归去来兮（大结局）</a></li>
				</ul>
				<div class="unflo"></div>
				<button class="btn btn-success"> 查看全部章节</button>
				<button class="btn btn-info	"> 订阅全部章节</button>
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


</html>
<script>



</script>