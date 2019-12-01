<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head><title>First JSP</title></head>
<body>
<%! ArrayList<String> tasks = null; %>
<% tasks = (ArrayList<String>)request.getAttribute("tasks"); %>
<% for(int i = 0; i<tasks.size() ; ++i ){%>
    <%=tasks.get(i)%><br/>
<% }%>

<form action="<%=request.getContextPath()%>/add" method="post">
    Add task:<br/>
    <input type="text" name="taskname"><br/>
    <input type="submit" value="Submit">
</form>

</body>
</html>