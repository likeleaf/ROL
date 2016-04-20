<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="l" uri="http://tag.oneflyingleaf.com" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="./foreground/jsp/common/top.jsp"></jsp:include>
<jsp:include page="./foreground/jsp/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${ctx}/foreground/css/style.css"/>


	<div class="container">
		<!--tab1 热门推荐，图片的轮转 -->x	
		<div class="content-tab1">
			<div class="container extra">
				<div class="row main">
					<div class="col-lg-3 lab-display-left">
							<div class="lab-display-inner-left">
								<h3>热门推荐</h3>
								<i></i>
								
								<l:lists name="Book" var="labList1" order="bookId desc" pageCount="15" pageNow="1"/>
								<ul class="list-unstyled list-memu">
									<c:forEach var="lab1" items="${labList1 }">
									<li>
										<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab1.bookId }">[${lab1.bookType}]${lab1.bookName }</a><hr class="hr-color">
									</li>
									</c:forEach>
								</ul>
							</div>
						
					</div>
					<div id="" class="col-lg-6 lab-dispaly-center" >

						<div id="carouselTba1" class="carousel slide" style="width: 100%">
							<ol class="carousel-indicators">
								<li data-target="#carouselTba1" class="active" data-slide-to="0"></li>
								<li data-target="#carouselTba1" data-slide-to="1"></li>
								<li data-target="#carouselTba1" data-slide-to="2"></li>
								<li data-target="#carouselTba1" data-slide-to="3"></li>
								<li data-target="#carouselTba1" data-slide-to="4"></li>
							</ol>

							<div class="carousel-inner">
								<div class="item active">
									<img width="100%" src="${ctx}/foreground/images/book-display/1.jpg">
								</div>
								<div class="item">
									<img width="100%" src="${ctx}/foreground/images/book-display/2.jpg">
								</div>
								<div class="item">
									<img width="100%" src="${ctx}/foreground/images/book-display/3.jpg">
								</div>
								<div class="item">
									<img width="100%" src="${ctx}/foreground/images/book-display/4.jpg">
								</div>
								<div class="item">
									<img width="100%" src="${ctx}/foreground/images/book-display/5.jpg">
								</div>
							</div>
							<a href="#carouselTba1" data-slide="prev" class="carousel-control left">
								<span class="glyphicon glyphicon-chevron-left"></span>
							</a>
							<a href="#carouselTba1" data-slide="next" class="carousel-control right">
								<span class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>


						<div id="list" class="focus-lab-dispaly"> 
							<div> 
								<ul id="listFocus" class="list-unstyled focus-on">
									<li class="active" onmouseover="javascript:setLab('lab1',this)" style="border-left-width: 0px; "><a href="javascript:;">热点</a></li>
									<li onmouseover="javascript:setLab('lab2',this)"  style="border-right-width: 0px; border-left-width: 0px;"><a href="javascript:;">VIP</a></li>
									<li onmouseover="javascript:setLab('lab3',this)" style="border-right-width: 0px;"><a href="javascript:;">全本</a></li>
									<li onmouseover="javascript:setLab('lab4',this)" style="border-right-width: 0px;"> <a href="javascript:;">玄幻</a></li>
								</ul>
							</div>
							<div id="labDisplay" class="lab-display"><!-- 25 -->
								<div id="lab1">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="2" pageNow="80"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									
												<div class="row">
													<div class="col-lg-3">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">
															<img src="${lab2.bookImg}">
														</a>
													</div>
													<div class="col-lg-9">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${lab2.bookName }</a>
														<p class="p-lab">类型：${lab2.bookType } </p>
														<p class="p-lab">
															${fn:substring(lab2.bookDes,0,60) }
														</p>
													</div>
												</div>
											<c:if test="${!sta.last }"><hr></c:if><!--最后一条不显示  -->
									</c:forEach>
								</div>
								<div id="lab2" class="hid">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="2" pageNow="111"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									
												<div class="row">
													<div class="col-lg-3">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">
															<img src="${lab2.bookImg}">
														</a>
													</div>
													<div class="col-lg-9">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${lab2.bookName }</a>
														<p class="p-lab">类型：${lab2.bookType } </p>
														<p class="p-lab">
															${fn:substring(lab2.bookDes,0,60) }
														</p>
													</div>
												</div>
											<c:if test="${!sta.last }"><hr></c:if><!--最后一条不显示  -->
									</c:forEach>
								</div>
								<div id="lab3" class="hid">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="2" pageNow="123"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									
												<div class="row">
													<div class="col-lg-3">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">
															<img src="${lab2.bookImg}">
														</a>
													</div>
													<div class="col-lg-9">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${lab2.bookName }</a>
														<p class="p-lab">类型：${lab2.bookType } </p>
														<p class="p-lab">
															${fn:substring(lab2.bookDes,0,60) }
														</p>
													</div>
												</div>
											<c:if test="${!sta.last }"><hr></c:if><!--最后一条不显示  -->
									</c:forEach>
								</div>
								<div id="lab4" class="hid">

								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="2" pageNow="100"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									
												<div class="row">
													<div class="col-lg-3">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">
															<img src="${lab2.bookImg}">
														</a>
													</div>
													<div class="col-lg-9">
														<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${lab2.bookName }</a>
														<p class="p-lab">类型：${lab2.bookType } </p>
														<p class="p-lab">
															${fn:substring(lab2.bookDes,0,60) }
														</p>
													</div>
												</div>
											<c:if test="${!sta.last }"><hr></c:if><!--最后一条不显示  -->
									</c:forEach>
								
									
								</div>
							</div>
						</div>
					</div>



					<div class="col-lg-3 lab-display-right" >

						<div class="lab-display-inner-right">
								<h3>追更榜</h3>
								<ul class="list-unstyled list-memu" id="firstRightLabel">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="10" pageNow="100"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li onmouseover="javascript:setRightLabel(this)">
											<span class="circle flo">${sta.count }</span>
											<div class="lab flo">
												<a class="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }" href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">
													<c:choose>
														<c:when test="${sta.first }">
															<img class="display-right-img" src="${lab2.bookImg }">
														</c:when>
														<c:otherwise>
															<img class="display-right-img hid"    src="${lab2.bookImg }">
														</c:otherwise>
													</c:choose>
													<p class="display-right-p">[${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}</p>
												</a>
											</div>
											<div class="unflo"></div>
										</li>
										<c:if test="${!sta.last }"><hr class="hr-color"></c:if>
									</c:forEach>
										<div class="unflo"></div>
									</li>
								</ul>
							</div>
					</div>
				</div>
			</div>
			</div>
		
		<hr class="lab-split">

		<!-- lab2 精品推荐 热门榜单 -->
		<div class="content-tab2">
			<div class="container extra">
				<div class="row main">
					<div class="col-lg-3 lab-display-left">
							<div class="lab-display-inner-left">
								<h3>精品推荐</h3>
								<i></i>
								<ul class="list-unstyled list-memu">
								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="66"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">[${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}</a><hr class="hr-color">
										</li>
									</c:forEach>
								</ul>
							</div>
						
					</div>
					<div id="" class="col-lg-6 lab-dispaly-center" >
						<div class="tab2-center">
							<h3>热门精选</h3>
							<hr>
							<l:lists name="Book" var="labList2" order="bookId desc" pageCount="6" pageNow="34"/>
							<c:forEach var="lab2" items="${labList2}" varStatus="sta">
								<c:if test="${sta.index%3 ==0 }"><div class="row"></c:if>
									<div class="col-lg-4">
										<div class="lab">
											<a class="" href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }" style="">
												<img class="tab2-center-display-img"  src="${lab2.bookImg }" style="width:100px;height:136px">
												<p class="tab2-center-display-p">[${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}</p>
												<p class="tab2-center-display-p">作者：${fn:substring(lab2.authName,0,8 )}</p>
											</a>
										</div>
									</div>
								<c:if test="${sta.index%3 ==2 }"></div></c:if>
							</c:forEach>

							<div class="tab2-center-buttom-menu">
								<div class="title flo">
									热书速递
								</div>
								<div class="list flo">
									
									<div class="row">
										<l:lists name="Book" var="labList2" order="bookId desc" pageCount="12" pageNow="34"/>
										<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<c:if test="${sta.index %3==0}">
											<div class="col-lg-3">
												<ul class="list-unstyled menu">
										</c:if>
													<li><a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,6 )}</a></li>
										<c:if test="${sta.index %3 ==2}">
												</ul>
											</div>
										</c:if>
										</c:forEach>
									</div>
								</div>
								<div class="unflo"></div>
							</div>
						</div>
					


						
					</div>



					<div class="col-lg-3 lab-display-right" >

						<div class="lab-display-inner-right">
								<h3><a href="javascript:;" onclick="javascript:tab2Right('tab2Lab1','tab2Lab2')">鲜花新书榜</a> <a href="javascript:;" onclick="javascript:tab2Right('tab2Lab2','tab2Lab1')">鲜花月榜</a></h3>
								<ul class="list-unstyled list-memu" id="tab2Lab1">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="34"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,6 )}</a> 
												<div class="lab-brand">
													<div class="glyphicon glyphicon-certificate color" style="color: red"></div>
													${lab2.bookAtt }
												</div>
											<hr class="hr-color">
										</li>
									</c:forEach>

								</ul>
								<ul class="list-unstyled list-memu hid" id="tab2Lab2">
										<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="54"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,6 )}</a> 
												<div class="lab-brand">
													<div class="glyphicon glyphicon-certificate color" style="color: #F9CFCC"></div>
													${lab2.bookAtt }
												</div>
											<hr class="hr-color">
										</li>
									</c:forEach>
									
								</ul>
							</div>
					</div>
				</div>
			</div>
		</div>

		<hr class="lab-split">

		<!-- lab3 精品推荐 热门榜单 -->
		<div class="content-tab3">
			<div class="container extra">
				<div class="row main">
					<div class="col-lg-3 lab-display-left">
							<div class="lab-display-inner-left">
								<h3>VIP作品推荐</h3>
								<i></i>
								<ul class="list-unstyled list-memu">
								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="66"/>
								<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									<li>
										<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">[${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}</a><hr class="hr-color">
									</li>
								</c:forEach>
								</ul>
							</div>
						
					</div>
					<div id="" class="col-lg-6 lab-dispaly-center" >
						<div class="tab2-center">
							<h3>无线风向标</h3>
							<hr style="margin-bottom: 5px;">
							<div id="carouselTba3" class="carousel slide" style="width: 100%">
								<ol class="carousel-indicators">
									<li data-target="#carouselTba3" class="active" data-slide-to="0"></li>
									<li data-target="#carouselTba3" data-slide-to="1"></li>
									<li data-target="#carouselTba3" data-slide-to="2"></li>
									<li data-target="#carouselTba3" data-slide-to="3"></li>
									<li data-target="#carouselTba3" data-slide-to="4"></li>
								</ol>

								<div class="carousel-inner">
									<div class="item active">
										<img width="100%" src="${ctx}/foreground/images/book-display/1.jpg">
									</div>
									<div class="item">
										<img width="100%" src="${ctx}/foreground/images/book-display/2.jpg">
									</div>
									<div class="item">
										<img width="100%" src="${ctx}/foreground/images/book-display/3.jpg">
									</div>
									<div class="item">
										<img width="100%" src="${ctx}/foreground/images/book-display/4.jpg">
									</div>
									<div class="item">
										<img width="100%" src="${ctx}/foreground/images/book-display/5.jpg">
									</div>
								</div>
								<a href="#carouselTba3" data-slide="prev" class="carousel-control left">
									<span class="glyphicon glyphicon-chevron-left"></span>
								</a>
								<a href="#carouselTba3" data-slide="next" class="carousel-control right">
									<span class="glyphicon glyphicon-chevron-right"></span>
								</a>
						</div>
							<l:lists name="Book" var="labList2" order="bookId desc" pageCount="6" pageNow="87"/>
							<c:forEach var="lab2" items="${labList2}" varStatus="sta">
								<c:if test="${sta.index%3 ==0 }"><div class="row"></c:if>
									<div class="col-lg-4">
										<div class="lab">
											<a class="" href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }" style="">
												<img class="tab3-center-display-img"  src="${lab2.bookImg }" >
												<p class="tab3-center-display-p">${fn:substring(lab2.bookName,0,6 )}</p>
											</a>
										</div>
									</div>
								<c:if test="${sta.index%3 ==2 }"></div></c:if>
							</c:forEach>
								
							</div>
						</div>
					



					<div class="col-lg-3 lab-display-right" >

						<div class="lab-display-inner-right">
								<h3>月票总榜</h3>
								<ul class="list-unstyled list-memu " >
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="54"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,10 )}</a> 
												<div class="lab-brand">
													${lab2.bookAtt }
												</div>
											<hr class="hr-color">
										</li>
									</c:forEach>
								</ul>
							</div>
					</div>
				</div>
			</div>
		</div>

		<hr class="lab-split">
		<!-- lab4 -->
		<div class="content-tab4">
			<div class="container extra">
				<div class="row main">
					<div class="col-lg-3 lab-display-left">
							<div class="lab-display-inner-left">
								<h3>最近更新</h3>
								<i></i>
								<ul class="list-unstyled list-memu">
								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="66"/>
								<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									<li>
										<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">[${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}</a><hr class="hr-color">
									</li>
								</c:forEach>
								</ul>
							</div>
						
					</div>

					<div id="" class="col-lg-6 lab-dispaly-center" >
						<h3 class="tab4-h3">最热男生小说</h3>
						<div class="tab4-center">
							<table width="100%" class="table table-striped table-hover">
								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="15" pageNow="54"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									<tr>
										<td width="70%"> [${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}　
												<l:lists name="BookChaper" var="bbc" order="bookChaIndex desc" limit="bookId = '${lab2.bookId }'" onlyOne="true"/>
											<%-- 	${bbc.bookChaIndex } --%>
										</td>
										<td width="20%">${fn:substring(lab2.authName,0,6) }</td>
										<td width="10%">${lab.bookDate }</td>
									</tr>
									</c:forEach>
							</table>
								
						

						</div>
					


						
					</div>



					<div class="col-lg-3 lab-display-right" >

						<div class="lab-display-inner-right">
								<h3><a href="javascript:;" onclick="javascript:tab2Right('tab2Lab3','tab2Lab4')">月票榜</a> <a href="javascript:;" onclick="javascript:tab2Right('tab2Lab4','tab2Lab3')">推荐榜</a></h3>
								<ul class="list-unstyled list-memu" id="tab2Lab3">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="60"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,6 )}</a> 
												<div class="lab-brand">
													<div class="glyphicon glyphicon-heart color" style="color:blue !important;"></div>
													${lab2.bookAtt }
												</div>
											<hr class="hr-color">
										</li>
									</c:forEach>

								</ul>
								<ul class="list-unstyled list-memu hid" id="tab2Lab4">
										<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="39"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,6 )}</a> 
												<div class="lab-brand">
													<div class="glyphicon glyphicon-certificate color" style="color:#3399ff !important;"></div>
													${lab2.bookAtt }
												</div>
											<hr class="hr-color">
										</li>
									</c:forEach>
									
								</ul>
							</div>
					</div>
				</div>
			</div>
		</div>

		<hr class="lab-split">
		<!-- lab5 -->
		<div class="content-tab5">
			<div class="container extra">
				<div class="row main">
					<div class="col-lg-3 lab-display-left">
							<div class="lab-display-inner-left">
								<h3>最新独家私藏</h3>
								<i></i>
								<ul class="list-unstyled list-memu">
								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="76"/>
								<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									<li>
										<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">[${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}</a><hr class="hr-color">
									</li>
								</c:forEach>
								</ul>
							</div>
						
					</div>

					<div id="" class="col-lg-6 lab-dispaly-center" >
						<h3 class="tab4-h3">最受书友热追</h3>
						<div class="tab4-center">
							<table width="100%" class="table table-striped table-hover">
								<l:lists name="Book" var="labList2" order="bookId desc" pageCount="15" pageNow="54"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
									<tr>
										<td width="70%"> [${lab2.bookType }]${fn:substring(lab2.bookName,0,6 )}　
												<l:lists name="BookChaper" var="bbc" order="bookChaIndex desc" limit="bookId = '${lab2.bookId }'"/>
												${bbc[0].bookChaIndex } 
										</td>
										<td width="20%">${fn:substring(lab2.authName,0,6) }</td>
										<td width="10%">${lab.bookDate }</td>
									</tr>
									</c:forEach>
							</table>
								
						

						</div>
					


						
					</div>



					<div class="col-lg-3 lab-display-right" >

						<div class="lab-display-inner-right">
								<h3>最新女生小说</h3>
								<ul class="list-unstyled list-memu" id="tab2Lab1">
									<l:lists name="Book" var="labList2" order="bookId desc" pageCount="14" pageNow="60"/>
									<c:forEach var="lab2" items="${labList2}" varStatus="sta">
										<li>
											<a href="${ctx }/foreground/jsp/book/detail.jsp?bookId=${lab2.bookId }">${fn:substring(lab2.bookName,0,6 )}</a> 
												<div class="lab-brand">
													<div class="glyphicon glyphicon-arrow-up purple" style="color: purple"></div>
													${lab2.bookAtt }
												</div>
											<hr class="hr-color">
										</li>
									</c:forEach>
									
								</ul>
							</div>
					</div>
				</div>
			</div>
		</div>
		<hr class="lab-split">
		
		

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

<script type="text/javascript">

	//lab1中对中间下面部分对应的内容
	function setLab(id,doc){
		
		var oArr = $('#listFocus').children();

		oArr.removeClass('active');
		console.log(oArr);


	 	$(doc).addClass('active');

	 	oArr = $('#labDisplay').children();
	 	oArr.addClass('hid');
	 
		console.log($('#'+id));
		$('#'+id).removeClass('hid');

	}

	
	//lab1中右边部分的标签
	function setRightLabel(doc){

		var oArr = $("#firstRightLabel img");

		oArr.addClass("hid")
		console.log($(doc));
		$(doc).children(".lab").children().children("img").removeClass("hid");
	}

	//tab2右边的标签
	function tab2Right(show,hidden){
		$("#"+hidden).addClass('hid');
		$("#"+show).removeClass('hid');

	}


	//设置图片自动滚动
	//轮播自动播放
	$('#carouselTba1').carousel({
		//自动4秒播放
		interval : 4000,
	}); 
	$('#carouselTba3').carousel({
		//自动4秒播放
		interval : 4000,
	}); 

</script>
</html>