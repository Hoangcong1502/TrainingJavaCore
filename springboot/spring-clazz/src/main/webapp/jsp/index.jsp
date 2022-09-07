<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<td>
    <h2 style="text-align: center">Home</h2>
    <tiles:insertDefinition name="template">
        <tiles:putAttribute name="body">
            <h2>${message}</h2>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</td>
</body>
</html>