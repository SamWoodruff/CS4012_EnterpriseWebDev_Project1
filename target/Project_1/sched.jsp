<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 9/16/2018
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title></title>
    <style>
        table, th, td {
            border: 3px solid black;
            border-collapse: collapse;
        }
        th, td {
            height: 40px;
            width: 120px;
            text-align: center;
            vertical-align: middle;

        }
        tr:nth-child(even) {background-color: #ccffcc;}

    </style>
</head>
<body>



<div style="overflow-x:auto;">

    <table border>
        <thead colspan='6'>
        <tr>
            <th>Time</th>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednesday</th>
            <th>Thursday</th>
            <th>Friday</th>
        </tr>
        </thead>

        <c:forEach begin="8" end="21" step="1" var="time">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${time == 12}">
                            <c:out value="${time}"/>:00pm
                        </c:when>
                        <c:when test="${time > 12}">
                            <c:out value="${time - 12}"/>:00pm
                        </c:when>
                        <c:otherwise>
                            <c:out value="${time}"/>:00am
                        </c:otherwise>
                    </c:choose>
                </td>
                <c:forEach begin="0" end="4" step="1" var="day">
                    <td>
                        <c:forEach items="${courses}" var="current">
                            <c:if test="${current.startTime <= time && current.endTime > time && current.day == day}">
                                <c:out value="${current.courseName}-${current.courseNumber}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                </c:forEach>
            </tr>

        </c:forEach>
    </table>
</div>

</body>
</html>
