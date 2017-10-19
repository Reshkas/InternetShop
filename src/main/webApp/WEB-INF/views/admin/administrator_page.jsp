<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator page</title>
    <style>
        <%@ include file="/css/reset.css" %>
        <%@ include file="/css/admin_page.css"%>
    </style>
</head>

<body>

<div class="wrapper">

    <header id="header">
        <jsp:include page="_header_administrator.jsp"></jsp:include>
    </header>

    <menu class="menu">
        <jsp:include page="_up_menu_admin.jsp"></jsp:include>
    </menu>

    <div id="main">
        <div class="result">
            <table id="result">
                <tr>
                    <td colspan="3"><p><b>Результат: <%= request.getAttribute("message")%>
                    </b></p></td>
                </tr>
                <tr class="result_tr">
                    <td class="result_td"><p>Логин пользователя</p></td>
                    <td class="result_td"><p>Id пользователя</p></td>
                    <td class="result_td"><p>Роль пользователя</p></td>
                </tr>
                <c:forEach var="userList" items="${userList}">
                    <tr class="result_tr">
                        <td class="result_td"><p>${userList.login}</p></td>
                        <td class="result_td"><p>${userList.id}</p></td>
                        <td class="result_td"><p>${userList.role}</p></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="reset"></div>
    </div>

    <foter id="footer">
        <jsp:include page="../_footer.jsp"></jsp:include>
    </foter>

</div>

</body>
</html>
