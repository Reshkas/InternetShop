<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session ="false" %>

<style>
    <%@ include file="/css/admin_header.css"%>
</style>


<div class="header logo">
    <img src="img/contentImg.jpg" alt="logo">
</div>

<div class="header search">
    <input class="input_text" type="text" size="40"><input class="search_button" type="submit" value="Найти">
</div>

<div class="header info">

    <div class="wrapper_button">
        <table>
            <tr>
                <td>
                    <form name="form" action="${pageContext.request.contextPath}/adminPage" method="POST">
                        <input type="submit" class="button" name="tools" value="Настройки"/>
                    </form>
                </td>
                <td>
                    <form name="form" action="${pageContext.request.contextPath}/logout" method="POST">
                        <input type="submit" class="button" name="logout" value="Выход"/>
                    </form>
                </td>
            </tr>
        </table>


    </div>
    <div id="info_user">
        <div class="div_left"><span>Логин: </span><%= request.getSession().getAttribute("login") %></div>
        <div class="div_right"><span>Роль: </span><%= request.getSession().getAttribute("role")%></div>
    </div>
</div>

<div class="reset"></div>