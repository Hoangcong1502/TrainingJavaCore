<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>

<body>
<h2>Please input student information</h2>
<form:form method="post" action="save">
  <table>
    <tr>
      <c:if test="${id>0}">
        <td>id update:${id}</td>
      </c:if>
    </tr>
    <tr>
      <td>id:</td>
      <td><form:input path="id" type="number" min="0"/></td>
    </tr>
    <tr>
      <td>Name: </td>
      <td><form:input path="name"/>
        <form:errors path="name"/>
      </td>
    </tr>
    <tr>
      <td>age: </td>
      <td><form:input path="age" type="number"/>
        <form:errors path="age"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit">
      </td>
    </tr>
  </table>
</form:form>
</body>

</html>
