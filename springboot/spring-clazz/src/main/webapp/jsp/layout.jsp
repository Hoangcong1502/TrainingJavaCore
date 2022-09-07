<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
<h1>Spring Boot</h1>
  <table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td><tiles:insertAttribute name="title"/></td>
        <a href="/home/index"> Home </a>
    <sec:authorize access="!hasAnyRole('ROLE_USER')">
        <a href="/home/form-login"> Đăng nhập </a>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_USER')">
        <a href="/home/user">Cá nhân</a>
        <a style="text-align: center" href="/home/logout"> Đăng xuất </a>
    </sec:authorize>
    </tr>
    <tr>
        <td><tiles:insertAttribute name="body"/></td>
    </tr>
  </table>
</body>
</html>
