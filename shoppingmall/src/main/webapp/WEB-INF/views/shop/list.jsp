<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>ShoppingMall</title>
	
	<link rel="stylesheet" href="/resources/css/user/shop/list.css" />
	
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
					<c:forEach items="${list}" var="list">
					<li>
						<div class="goodsThumb">
							<img src="${list.gdsThumbImg}">
						</div>
						<div class="goodsName">
							<a href="/shop/view?n=${list.gdsNum}">${list.gdsName}</a>
						</div>
					</li>
					</c:forEach>
				</ul>
				
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
