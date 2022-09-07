<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Đăng nhập</h1>
        <c:if test="${!empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form method="post" action="/home/login">
<%--        <form method="post" action="/home/j_spring_security_check">--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p><input name="username" type="text"/></p>
            <p><input name="password" type="password"/></p>
            <p><input type="submit" name="commit" value="Login"></p>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>
