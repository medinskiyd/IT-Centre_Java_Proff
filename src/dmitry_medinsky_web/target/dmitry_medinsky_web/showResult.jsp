<%@ page import="java.util.ArrayList" %>
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

<h2>Последовательность в обратном порядке</h2>
<br/>
<%
    ArrayList<Integer> task1Data = (ArrayList<Integer>)request.getAttribute("task1Data");

    for (Integer line : task1Data) {
        out.println(line.toString());
    }

%>

<h2>Увеличить все эелементы последовательности</h2>
<br/>
<%
    ArrayList<Integer> task2Data = (ArrayList<Integer>)request.getAttribute("task2Data");

    for (Integer line : task2Data) {
        out.println(line.toString());
    }

%>

<h2>Заменить все четные в последовательности на 0</h2>
<br/>
<%
    ArrayList<Integer> task3Data = (ArrayList<Integer>)request.getAttribute("task3Data");

    for (Integer line : task3Data) {
        out.println(line.toString());
    }

%>

<h2>Удалить из последовательности все простые числа</h2>
<br/>
<%
    ArrayList<Integer> task4Data = (ArrayList<Integer>)request.getAttribute("task4Data");

    for (Integer line : task4Data) {
        out.println(line.toString());
    }

%>

<h2>Вевести на экран вторую последовательность</h2>
<br/>
<%
    ArrayList<Integer> task5Data = (ArrayList<Integer>)request.getAttribute("task5Data");

    for (Integer line : task5Data) {
        out.println(line.toString());
    }

%>

<h2>Вычислить сумму всех элементов и среднее арифметическое</h2>
<br/>
<%
    ArrayList<Integer> task6Data = (ArrayList<Integer>)request.getAttribute("task6Data");

    for (Integer line : task6Data) {
        out.println(line.toString());
    }

%>



${name}
</body>
</html>