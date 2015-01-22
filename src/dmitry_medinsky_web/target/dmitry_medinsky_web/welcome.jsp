<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 9/8/13
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <%
      String name = (String)request.getAttribute("name");
      out.println(name);

  %>

    ${name}
</body>
</html>