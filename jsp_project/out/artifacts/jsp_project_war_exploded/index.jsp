<%@ page import="java.util.List" %>
<%@ page import="ro.gr8.jsp.data.repository.ToDoItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controler.TodoServlet" %>
<%@ page import="ro.gr8.jsp.data.repository.TodoItemRepository" %><%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 14.10.2019
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/first.css" type="text/css">
    <title>To Do List</title>
</head>
<body>
<%
    request.setAttribute("todoItems", TodoItemRepository.getInstance().getToDoItems());
%>
<div class="head">
    <table style="margin: auto   ">
<%--        <div class="img">--%>
<%--        <img src="img/do.jpg">--%>
<%--        </div>>--%>
        <h1>To Do List</h1>
    <div class="img">
                <img src="img/do.jpg" width="50%" height="20%">
    </div>
       <c:forEach items="#{todoItems}" var="todoItem">
        <tr>
            <td><c:out value="${todoItem.name}"/>
            </td>
            <td>
                <c:if test="${todoItem.completed}">
                <img class="tick" src="img/tick.png"/>
                </c:if>
                <c:if test="${!todoItem.completed}">
                      <input type="checkbox"/>
                </c:if>
            </td>
        </tr>
       </c:forEach>
    </table>
</div>

<div class="center">
    <form method="post" action="/todoItem">
        <div class="center1">
            <label for="create">Create to do</label>
            <input type="text" name="actionName" id="create"/>
            <input type="submit" value="Add">
        </div>
    </form>
</div>

</body>
</html>
