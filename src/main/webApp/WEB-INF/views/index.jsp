<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session ="false" %>
<style>
    <%@ include file="/css/reset.css"%>
    <%@ include file="/css/style.css"%>
</style>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>
    </head>

    <body>

        <div class="wrapper">

            <header id="header">
                <jsp:include page="_header.jsp"></jsp:include>
            </header>

            <menu class="menu">
                <jsp:include page="_upmenu.jsp"></jsp:include>
            </menu>

            <div id="main">
                <div class="main_category">
                    <span class="caption"><p>Категории</p></span>

                    <jsp:include page="_leftmenu.jsp"></jsp:include>

                </div>
                <div class="main_content">

                </div>

                <div class="reset"></div>
            </div>

            <foter id="footer">
                <jsp:include page="_footer.jsp"></jsp:include>
            </foter>

        </div>

    </body>
</html>