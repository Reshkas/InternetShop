<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session ="false" %>
<style>
    <%@ include file="/css/form.css" %>
</style>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
</head>
<body>
    <div id="wrapper">
        <form id="back" name="return" action="${pageContext.request.contextPath}/home" method="POST" >
            <input class="x" type="submit" value="X" />
        </form>
        <form name="login-form" class="form" action="${pageContext.request.contextPath}/login" method="POST">

            <div class="header">
                <h1>Авторизация</h1>
                <span>Введите ваши регистрационные данные для входа в ваш личный кабинет. </span>
            </div>
            <div class="content">
                <div class="field">
                    <label for="login">Логин </label>
                    <input id="login" class="input username"  name="login"  type="text"  value="login0" />
                </div>
                <div class="field">
                    <label for="password">Пароль </label>
                    <input id="password" class="input password" name="password" type="text" value="password0" />
                </div>
            </div>
            <div class="footer">
                <input type="submit" name="enter" value="Войти" class="button_right" />
            </div>
        </form>
    </div>
</body>
</html>
