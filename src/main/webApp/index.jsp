<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="utf-8" %>
<style>
    <%@ include file="css/reset.css" %>
    <%@ include file="css/style.css"%>
</style>
<!DOCTYPE html>
<html lang="en">
<head>

</head>

<body>
    <div class="wrapper">

        <header id="header">
        <div class = "header logo">
            <img src="img/contentImg.jpg" alt="logo" >
        </div>

        <div class = "header search">
            <input type="text" size="40"><input type="submit" value="Найти">
        </div>

        <div class="header entry">
            <a href="authorization.jsp" alt="Login"><img src="img/login.jpg"/></a>
        </div>

        <dive class="header basket">
            <a href="registration.jsp" alt="Register"><img src="img/register.jpg" alt="Register"></a>
        </dive>
        <div class="reset"></div>
    </header>

        <menu class="menu">
        <ul class="ul_menu">
            <li class="li_menu"><a class="a_menu" href="index.jsp">Главная</a></li>
            <li class="li_menu"><a class="a_menu" href="#">Услуги</a></li>
            <li class="li_menu"><a class="a_menu" href="#">Акции</a></li>
            <li class="li_menu"><a class="a_menu" href="#">О нас</a></li>
            <li class="li_menu"><a class="a_menu" href="#">Контакты</a></li>
        </ul>
    </menu>

        <div id="main">
        <div class="main_category">
            <span class="caption"><p>Категории</p></span>
            <ul class="category-menu">
                <li><a href="#">Ноутбуки</a>
                    <ul class="sub-menu">
                        <li><a href="#">Asus</a></li>
                        <li><a href="#">Aser</a></li>
                        <li><a href="#">HP</a></li>
                        <li><a href="#">Lenovo</a></li>
                        <li><a href="#">Dell</a></li>
                        <li><a href="#">Apple</a></li>
                    </ul>
                </li>
                <li><a href="#">Телефоны</a>
                    <ul class="sub-menu">
                        <li><a href="#">Смартфоны</a></li>
                        <li><a href="#">Кнопочные</a></li>
                        <li><a href="#">Офисные</a></li>
                    </ul>
                </li>
                <li><a href="#">Телевизоры</a>
                    <ul class="sub-menu">
                        <li><a href="#">LG</a></li>
                        <li><a href="#">Panasonic</a></li>
                        <li><a href="#">Philips</a></li>
                        <li><a href="#">Samsung</a></li>
                        <li><a href="#">Toshiba</a></li>
                    </ul>
                </li>
                <li><a href="#">Фото Видео</a>
                    <ul class="sub-menu">
                        <li><a href="#">Фотоаппараты</a></li>
                        <li><a href="#">Видеокамеры</a></li>
                        <li><a href="#">Объективы</a></li>
                        <li><a href="#">Экшен камеры</a></li>
                    </ul>
                </li>
                <li><a href="#">Акссуары</a>
                    <ul class="sub-menu">
                        <li><a href="#">Мониторы</a></li>
                        <li><a href="#">Мыши</a></li>
                        <li><a href="#">Клавиатуры</a></li>
                    </ul>
                </li>
                <li><a href="#">Комплектующие</a>
                    <ul class="sub-menu">
                        <li><a href="#">Процессоры</a></li>
                        <li><a href="#">Видеокарты</a></li>
                        <li><a href="#">Процессоры</a></li>
                        <li><a href="#">Мат. платы</a></li>
                        <li><a href="#">Память</a></li>
                    </ul>
                </li>
                <li><a href="#">Другое</a></li>
            </ul>
        </div>

        <div class="main_content">

            <%--<%@include file="authorization.jsp"%>--%>

        </div>

        <div class="reset"></div>

    </div>

        <foter id="footer">
        <p>@ Футер</p>
    </foter>

    </div>

</body>
</html>