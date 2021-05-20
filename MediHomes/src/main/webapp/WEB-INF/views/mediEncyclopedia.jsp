<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article class="article">
	<div class="page-content">
		<div class="tabbed">
			<input type="radio" id="tab1" name="css-tabs" checked> 
			<input type="radio" id="tab2" name="css-tabs">
			<ul class="tabs">
				<div class="tab"><label for="tab1">부위별</label></div>
			</ul>
			<c:if test="${ not empty encyclopediaList }">
				<div class="tab-content">
					<ul>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=1">가슴</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=2">골반</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=3">귀</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=4">기타</a>
						</li>
						<li class="disease_li_last">
							<a href="mediEncyclopedia?keyword=5">눈</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=6">다리</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=7">등/허리</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=8">머리</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=9">목</a>
						</li>
						<li class="disease_li_last">
							<a href="mediEncyclopedia?keyword=10">발</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=11">배</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=12">생식기</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=13">손</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=14">얼굴</a>
						</li>
						<li class="disease_li_last">
							<a href="mediEncyclopedia?keyword=15">엉덩이</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=16">유방</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=17">입</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=18">전신</a>
						</li>
						<li class="disease_li">
							<a href="mediEncyclopedia?keyword=19">코</a>
						</li>
						<li class="disease_li_last">
							<a href="mediEncyclopedia?keyword=20">팔</a>
						</li>			
						<li class="disease_li_last">
							<a href="mediEncyclopedia?keyword=21">피부</a>
						</li>
					</ul>
				</div>
			</c:if>
		</div>
		<div class="disease_AllList">
			<div class="disease_list">
				<ul>
					<c:if test="${ not empty encyclopediaList }">
						<c:forEach var="d" items="${ encyclopediaList }" varStatus="status">
							<li>
								<div class="photo2">
									<img width="190" height="168"
										src="resources/images/disease/${d.img }"
										alt="${d.data1 }">
								</div>
								<div class="box2">
									<strong class="contTitle"> 
										<a>${d.data1 }</a>
									</strong>
									<dl>
										<c:if test="${ not empty d.case1}"> 
											<dt>증상</dt>
											<dd>
												<p>${d.case1 }</p>
											</dd>
										</c:if>
										<c:if test="${ not empty d.case2}">
											<dt>관련질환</dt>
											<dd>
												<p>${d.case2 }</p>
											</dd>
										</c:if>
										<c:if test="${ not empty d.case3}">
											<dt>진료과</dt>
											<dd>
												<p>${d.case3 }</p>
											</dd>
										</c:if>
										<c:if test="${ not empty d.case4}">
											<dt>동의어</dt>
											<dd>
												<p>${d.case4 }</p>
											</dd>
										</c:if>
									</dl>
								</div>
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		
		<!--  증상백과 페이징 처리 -->
		<div class="pageNum">
			<c:if test="${ startPage > pageGroup }">
				<a href="mediEncyclopedia?pageNum=${ startPage - pageGroup }&keyword=${ keyword }">
					←</a>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					${ i }
				</c:if>
				<c:if test="${ i != currentPage }">
					<a href="mediEncyclopedia?pageNum=${ i }&keyword=${ keyword }">${ i }</a>
				</c:if>
			</c:forEach>
			<c:if test="${ endPage < pageCount }">
				<a href="mediEncyclopedia?pageNum=${ startPage + pageGroup }&keyword=${ keyword }">
				→</a>
			</c:if>
		</div>
		<div class="IwannaBack">
			<a href="javascript:history.back(-1)">뒤로가기</a>
		</div>
	</div>
</article>
