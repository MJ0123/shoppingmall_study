<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>ShoppingMall</title>
	
	<script src="/resources/jquery/jquery-3.6.0.min.js"></script>
	
	<link rel="stylesheet" href="/resources/css/user/shop/cartList.css" />

</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="../include/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_box">
			<%@ include file="../include/nav.jsp" %>
		</div>
	</nav>
	
	<aside id="aside">
		<div id="aside_box">
			<%@ include file="../include/aside.jsp" %>
		</div>
	</aside>

		<section id="container">
			<div id="container_box">

				<section id="content">

					<ul>
						<li>
							<div class="allCheck">
								<input type="checkbox" name="allCheck" id="allCheck" /><label for="allCheck">모두 선택</label>
								
								<script>
								$("#allCheck").click(function(){
									var chk = $("#allCheck").prop("checked");
									if(chk) {
										$(".chBox").prop("checked", true);
									} else {
										$(".chBox").prop("checked", false);
									}
								});
								</script>
							</div>

							<div class="delBtn">
								<button type="button" class="selectDelete_btn">선택 삭제</button>

								<script>
									$(".selectDelete_btn").click(function() {
										var confirm_val = confirm("정말 삭제하시겠습니까?");

										if (confirm_val) {
											var checkArr = new Array();

											$("input[class='chBox']:checked").each(function() {
												checkArr.push($(this).attr("data-cartNum"));
											});
											
											$.ajax({
												url : "/shop/deleteCart",
												type : "post",
												data : {chbox : checkArr},
												success : function() {
													location.href = "/shop/cartList";
												}
											});
										}
									});
								</script>
							</div>
							
						</li>
						
						<c:set var="sum" value="0" />
						
						<c:forEach items="${cartList}" var="cartList">
							<li>
								<div class="checkBox">
									<input type="checkbox" name="chBox" class="chBox" data-cartNum="${cartList.cartNum}" />
								</div>
								
								<div class="thumb">
									<img src="${cartList.gdsThumbImg}" />
								</div>
								<div class="gdsInfo">
									<p>
										<span>상품명 :</span>${cartList.gdsName}<br />
										<span>개당 가격 :</span>
											<fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice}" /> 원<br />
										 <span>구입 수량 :</span>${cartList.cartStock} 개<br />
										 <span>최종 가격 :</span>
											<fmt:formatNumber pattern="###,###,###" value="${cartList.gdsPrice * cartList.cartStock}" /> 원<br />
									</p>

									<div class="delete">
										<button type="button" class="delete_${cartList.cartNum}_btn" data-cartNum="${cartList.cartNum}">삭제</button>
										
										<script>
											 $(".delete_${cartList.cartNum}_btn").click(function(){
											  	var confirm_val = confirm("정말 삭제하시겠습니까?");
											  
											  	if(confirm_val) {
											   		var checkArr = new Array();
											   
											   		checkArr.push($(this).attr("data-cartNum"));
											              
											   		$.ajax({
											    		url : "/shop/deleteCart",
											    		type : "post",
											    		data : { chbox : checkArr },
											    		success : function(result){
											    			
											     			if(result == 1) {            
											      				location.href = "/shop/cartList";
											     			} else {
											      				alert("삭제 실패");
											     			}
											    		}
											   		});
											  	} 
											});
										</script>
									</div>
								</div>
							</li>
						
						<!-- 카트 목록내 모든 상품의 가격 저장 -->
						<c:set var="sum" value="${sum + (cartList.gdsPrice * cartList.cartStock)}" />	
							
						</c:forEach>
					</ul>

				<div class="listResult">
					<div class="sum">
						총 합계 : <fmt:formatNumber pattern="###,###,###" value="${sum}" />원
					</div>
					<div class="orderOpen">
						<button type="button" class="orderOpen_btn">주문 정보 입력</button>

							<script>
								$(".orderOpen_btn").click(function() {
									$(".orderInfo").slideDown();
									$(".orderOpen_btn").slideUp();
								});
							</script>
							
						</div>
				</div>
				
				<div class="orderInfo">
					<form role="form" method="post" autocomplete="off">
					
						<input type="hidden" name="amount" value="${sum}" />
						
						<div class="inputArea">
							<label for="">수령인</label>
							<input type="text" name="orderRec" id="orderRec" required="required" />
						</div>
						
						<div class="inputArea">
							<label for="">수령인 연락처</label>
							<input type="text" name="orderPhone" id="orderPhone" required="required" />
						</div>
						
						<!-- <div class="inputArea">
							<label for="">우편번호</label>
							<input type="text" name="userAddr1" id="userAddr1" required="required" />
						</div>
						
						<div class="inputArea">
							<label for="">1차 주소</label>
							<input type="text" name="userAddr2" id="userAddr2" required="required" />
						</div>
						
						<div class="inputArea">
							<label for="">2차 주소</label>
							<input type="text" name="userAddr3" id="userAddr3" required="required" />
						</div> -->

						<div class="inputArea">
						
							<p>
								<input type="text" id="sample3_postcode" placeholder="우편번호"> 
								<input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기"><br>
							</p>
							<p>
								<input type="text" name="userAddr1" id="sample3_address" placeholder="주소">
								<input type="text" name="userAddr2" id="sample3_detailAddress" placeholder="상세주소">
								<input type="text" name="userAddr3" id="sample3_extraAddress" placeholder="참고항목">
							</p>
				
							<div id="wrap" style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
								<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1" onclick="foldDaumPostcode()" alt="접기 버튼">
							</div>

							<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script>
								// 우편번호 찾기 찾기 화면을 넣을 element
								var element_wrap = document.getElementById('wrap');

								function foldDaumPostcode() {
									// iframe을 넣은 element를 안보이게 한다.
									element_wrap.style.display = 'none';
								}

								function sample3_execDaumPostcode() {
									// 현재 scroll 위치를 저장해놓는다.
									var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
									new daum.Postcode(
											{
												oncomplete : function(data) {
													// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

													// 각 주소의 노출 규칙에 따라 주소를 조합한다.
													// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
													var addr = ''; // 주소 변수
													var extraAddr = ''; // 참고항목 변수

													//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
													if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
														addr = data.roadAddress;
													} else { // 사용자가 지번 주소를 선택했을 경우(J)
														addr = data.jibunAddress;
													}

													// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
													if (data.userSelectedType === 'R') {
														// 법정동명이 있을 경우 추가한다. (법정리는 제외)
														// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
														if (data.bname !== ''&& /[동|로|가]$/g.test(data.bname)) {
															extraAddr += data.bname;
														}
														// 건물명이 있고, 공동주택일 경우 추가한다.
														if (data.buildingName !== ''&& data.apartment === 'Y') {
															extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
														}
														// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
														if (extraAddr !== '') {
															extraAddr = ' (' + extraAddr + ')';
														}
														// 조합된 참고항목을 해당 필드에 넣는다.
														document.getElementById("sample3_extraAddress").value = extraAddr;

													} else {
														document.getElementById("sample3_extraAddress").value = '';
													}

													// 우편번호와 주소 정보를 해당 필드에 넣는다.
													document.getElementById('sample3_postcode').value = data.zonecode;
													document.getElementById("sample3_address").value = addr;
													// 커서를 상세주소 필드로 이동한다.
													document.getElementById("sample3_detailAddress").focus();

													// iframe을 넣은 element를 안보이게 한다.
													// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
													element_wrap.style.display = 'none';

													// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
													document.body.scrollTop = currentScroll;
												},
												// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
												onresize : function(size) {
													element_wrap.style.height = size.height + 'px';
												},
												width : '100%',
												height : '100%'
											}).embed(element_wrap);

									// iframe을 넣은 element를 보이게 한다.
									element_wrap.style.display = 'block';
								}
							</script>
							</div>

							<div class="inputArea">
							<button type="submit" class="order_btn">주문</button>
							<button type="button" class="cancel_btn">취소</button>

								<script>
									$(".cancel_btn").click(function() {
										$(".orderInfo").slideUp();
										$(".orderOpen_btn").slideDown();
									});
								</script>
								
							</div>
					</form>
				</div>
				
				</section>
			</div>
		</section>

		<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp" %>
		</div>
	</footer>
	
</div>
</body>
</html>
