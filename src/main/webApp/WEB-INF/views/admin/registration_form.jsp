<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session ="false" %>

<style>
    <%@ include file="/./css/form.css" %>
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
        <form id="back" name="return" action="${pageContext.request.contextPath}/adminPage" method="POST" >
            <input class="x" type="submit" value="X" />
        </form>
        <form name="registration-form" class="form" action="${pageContext.request.contextPath}/addUser" method="POST">
            <div class="header">
                <h1>Добавление пользователя</h1>
                <span>Введите регистрационные данные пользователя для регистрации в системе.</span>
            </div>
            <div class="content">
                <div class="field">
                    <label for="login">Логин </label>
                    <input id="login" name="login" type="text" class="input username" value="" />
                </div>
                <div class="field">
                    <label for="password">Пароль</label>
                    <input id="password" name="password" type="password" class="input password" value="" />
                </div>
                <div class="field">
                    <label for="confirm_password">Пароль</label>
                    <input id="confirm_password" name="confirmPassword" type="password" class="input password" value="" />
                </div>
            </div>
            <div class="footer">
                <input type="submit" name="registrationUser" value="Добавить" class="button_right"/>
            </div>
        </form>
    </div>
</body>
</html>

