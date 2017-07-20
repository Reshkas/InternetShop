
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="css/registration_form.css" %>
</style>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrapper">

    <form name="registration-form" class="registration-form" action="startServlet" method="POST">

        <div class="header">
            <h1>Регистрация</h1>
            <span>Введите ваши регистрационные данные для регистрации Вас в системе.</span>
        </div>

        <div class="content">
            <input name="username" type="text" class="input username" value="Логин" />
            <input name="password" type="password" class="input password" value="Пароль" />
            <input name="password_re" type="password" class="input password" value="Пароль" />
        </div>

        <div class="footer">
            <input type="submit" name="register" value="Регистрация" class="button" />
            <input type="submit" name="home" value="Главная" class="enter" />
        </div>

    </form>
</div>
<div class="gradient"></div>

</body>
</html>
