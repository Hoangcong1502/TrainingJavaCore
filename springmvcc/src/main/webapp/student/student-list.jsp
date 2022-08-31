<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td colspan="2">thao tac</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><a href="/student/delete/${student.id}">Delete</a>
                <a href="/student/edit/${student.id}">Edit</a>

        </tr>
    </c:forEach>
</table>
</body>
<script>
    function view(id){
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET","json/"+id,true)
        xmlHttp.onload = function (){
            if(this.status!=200){
                return;
                console.log(this.responseText);
            }
        }
        xmlHttp.send();
    }
</script>
</html>
