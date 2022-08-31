<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/student/update">
    <h2>Update</h2>
    <table>
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
