<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>


<!doctype html>
<html lang="en">
<head>
    <style>
        <%@ include file="/css/form.css" %>
    </style>
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
        <form name="find_user_form" class="form" action="${pageContext.request.contextPath}/findUser" method="POST">
            <div class="header">
                <h1>Поиск пользователя</h1>
                <span>Ведите логин пользователя</span>
            </div>
            <div class="content">
                <div class="field">
                    <label for="login">Логин: </label>
                    <input id="login" name="login" type="text" class="input password" value=""/>
                </div>
            </div>
            <div class="footer">
                <input type="submit" name="findUser" value="Найти" class="button_right"/>
            </div>
        </form>
    </div>
</body>
</html>
