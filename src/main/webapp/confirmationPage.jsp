<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 9/6/2018
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title><h1>Confirmation</h1></title>
    <style>
        body {
            background-color: #ffffcc;
        }

    </style>
</head>
<body>

<h2>Your schedule:</h2>:
<br><br>
<%@ include file="sched.jsp" %>


Select confirm if you are happy with your schedule, or edit to make further changes.<br><br>
<form action="confirmation" method="post">
    <input type="submit" name="button1" value="Confirm" />
    <input type="submit" name="button2" value="Edit" />
</form>

</body>
</html>
