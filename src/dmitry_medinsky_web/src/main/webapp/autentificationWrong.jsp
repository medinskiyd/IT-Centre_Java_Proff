<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2><font color="#ff460dff">Wrong data!</font></h2>  <br/>
<form action="/serv" method="GET">
    login <input type="text" name="name"/></br>
    password <input type="text" name="password"/></br>
    <input type="submit" value="Enter"/>

    <output <%
        request.getAttribute("pass");
    %>/>

</form>
</body>
</html>
