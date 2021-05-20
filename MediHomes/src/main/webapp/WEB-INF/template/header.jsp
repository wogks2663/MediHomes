<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div class="logo">		
		<a href="${ pageContext.servletContext.contextPath }/mediMain">
			<img class="logo_img" src="resources/images/logo.png" alt="Logo" />
		</a>
	</div>			
	<nav>
		<div class="navbar">
			<a href="mediMain">메인</a>
			<a href="mediSelfTest">자가 진단 테스트</a>
			<div class="subnav">
		    	<button class="subnavbtn">병명으로 병원 찾기</button>
	    		<div class="subnav-content">
			      	<a href="mediDisease?keyword=당뇨병&rate=NaN">당뇨</a>
					<a href="mediDisease?keyword=폐암&rate=NaN">폐암</a>
					<a href="mediDisease?keyword=위암&rate=NaN">위암</a>
					<a href="mediDisease?keyword=고혈압&rate=NaN">고혈압</a>
					<a href="mediDisease?keyword=급성기뇌졸중&rate=NaN">급성기 뇌졸중</a>
					<br/>
			      	<a href="mediDisease?keyword=급성심근경색증&rate=NaN">급성 심근경색증</a>
					<a href="mediDisease?keyword=만성폐쇄성폐질환&rate=NaN">만성 폐쇄성 폐질환</a>
					<a href="mediDisease?keyword=천식&rate=NaN">천식</a>
					<a href="mediDisease?keyword=혈액투석&rate=NaN">혈액투석</a>			
			    </div>
	  		</div>
	  		<div class="subnav">
		    	<button class="subnavbtn">의료기기로 병원 찾기</button>
		    	<div class="subnav-content">
		    		<a href="mediInstruments?keyword=진단용방사선발생장치">X-ray</a>
		    		<a href="mediInstruments?keyword=유방촬영용장치">유방촬영장치</a>
		    		<a href="mediInstruments?keyword=MRI">MRI</a>
		    		<a href="mediInstruments?keyword=CT">CT</a>
		    	</div>
		    </div>
		</div>
	</nav>
</header>