<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 15.06.13
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Numbers form</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

    <form method="get" action="/numberer" id="project">

        Введите числа (через пробел) <br> <input type="text" name="numbers" value="" size="50"/><br/>
        <input type="submit" value="Send Numbers" size="40" id="form-submit"><br/>
    </form>
</body>
</html>