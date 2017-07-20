<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="utf-8" %>
<style>
	<%@ include file="css/authorization_form.css" %>
</style>
<!DOCTYPE  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>Авторизация</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>

<body>

<div id="wrapper">

<form name="login-form" class="login-form" action="startServlet" method="POST">

    <div class="header">
		<h1>Авторизация</h1>
		<span>Введите ваши регистрационные данные для входа в ваш личный кабинет. </span>
    </div>

    <div class="content">
		<input name="username" type="text" class="input username" value="Логин" />
		<input name="password" type="password" class="input password" value="Пароль" />
    </div>

    <div class="footer">
		<input type="submit" name="enter" value="Войти" class="button" />
		<input type="submit" name="home" value="Главная" class="register" />
    </div>

</form>
</div>
<div class="gradient"></div>

</body>
</html>