<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2><font color="#ff9d0dff">Hello!</font></h2>  <br/>
<form action="/serv" method="GET">
    <% Date date = new Date();
        out.println("Date today:" + date);
    %> <br/>
    login <input type="text" name="login"/></br>
    password <input type="text" name="password"/></br>
    <input type="submit" value="Enter"/>

</form>
<a href="http://localhost:8083/form.jsp"><strong>Ввод чисел</strong></a> <br/>
</body>
</html>
