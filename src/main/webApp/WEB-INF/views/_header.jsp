<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session ="false" %>

<div class = "header logo">
    <img src="img/contentImg.jpg" alt="logo" >
</div>

<div class = "header search">
    <input type="text" size="40"><input type="submit" value="Найти">
</div>

<div class="header entry">
    <a href="${pageContext.request.contextPath}/authorization" alt="Login"><img src="img/login.jpg"/></a>
</div>

<dive class="header registration">
    <a href="${pageContext.request.contextPath}/registration" alt="Register"><img src="img/register.jpg" alt="Register"></a>
</dive>

<div class="reset"></div>
