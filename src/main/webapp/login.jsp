<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 9/13/2018
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .centered {
            position: fixed;
            top: 50%;
            left: 50%;
            /* bring your own prefixes */
            transform: translate(-50%, -50%);
        }
        body {
            background-color: #ffffcc;
        }

    </style>
</head>
<body>
<div class = "centered">

    <h2>Login</h2>
    <form action="login" method="post">

        First Name:<input type="text" name="firstName" id="firstName" value="">  <br><br>
        Last Name:<input type = "text" name="lastName" id="lastName" value="">   <br><br>
        Student ID:<input type="text" name="studentID" id="studentID" value="">  <br><br>
        <input type="reset" value="Reset"/>
        <input type="submit" name="submit1" value="Login"/>

    </form>

</div>
</body>
</html>
