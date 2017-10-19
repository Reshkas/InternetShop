<%@ page session ="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<ul class="ul_menu">
    <li class="li_menu"><a class="a_menu" href="${pageContext.request.contextPath}/formFindUser">Найти </a></li>
    <li class="li_menu"><a class="a_menu" href="${pageContext.request.contextPath}/formAddUser">Добавить </a></li>
    <li class="li_menu"><a class="a_menu" href="${pageContext.request.contextPath}/formDeleteUser">Удалить </a></li>
    <li class="li_menu"><a class="a_menu" href="${pageContext.request.contextPath}/formChangeUserRole">Изменить права </a></li>
    <li class="li_menu"><a class="a_menu" href="${pageContext.request.contextPath}/getAllUsers">Список всех пользователей</a></li>
</ul>
