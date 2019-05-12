<%@ page import="classes.Student" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%--@elvariable id="student" type="classes.Student"--%>
<%--@elvariable id="course" type="classes.Course"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <style>

        body {
            background-color: #ffffcc;
        }
    </style>
</head>
<body>
    <title>Schedule Manager</title>

    <h1>Schedule Manager</h1>

    Welcome ${student.firstName} ${student.lastName}!<br>
    Student ID: ${student.studentID}<br><br>
    Fill out the text boxes and check the proper days of the week below to add a course to your schedule.<br><br>

        <form action="addToSchedule" method="post">
            Course Name:<input type="text" name="courseName" id="courseName" value="">
            <br><br>
            Course Number:<input type="text" name="courseNumber" id="courseNumber" value="">
            <br><br>

            <select name="startTime">
                <option value="8">8:00am</option>
                <option  value="9">9:00am</option>
                <option value="10">10:00am</option>
                <option value="11">11:00am</option>
                <option value="12">12:00pm</option>
                <option value="13">1:00pm</OPTION>
                <option value="14">2:00pm</option>
                <option value="15">3:00pm</option>
                <option value="16">4:00pm</option>
                <option value="17">5:00pm</OPTION>
                <option value="18">6:00pm</option>
                <option value="19">7:00pm</option>
                <option value="20">8:00pm</option>
                <option value="21">9:00pm</option>
            </select>
            to
            <select name="endTime">
                <option value="9">9:00am</option>
                <option value="10">10:00am</OPTION>
                <option value="11">11:00am</option>
                <option value="12">12:00pm</option>
                <option value="13">1:00pm</OPTION>
                <option value="14">2:00pm</option>
                <option value="15">3:00pm</option>
                <option value="16">4:00pm</option>
                <option value="17">5:00pm</option>
                <option value="18">6:00pm</option>
                <option value="19">7:00pm</option>
                <option value="20">8:00pm</OPTION>
                <option value="21">9:00pm</option>
                <option value="22">10:00pm</option>
            </select>
            <br><br>

            <input type="checkbox" name="Monday" value="M">Monday
            <input type="checkbox" name="Tuesday" value="T">Tuesday
            <input type="checkbox" name="Wednesday" value="W">Wednesday
            <input type="checkbox" name="Thursday" value="Th">Thursday
            <input type="checkbox" name="Friday" value="F">Friday
            <br><br>

            Create a name for your schedule:<br>
            <input type="text" name="schedule" id="schedule" value="Not Required"><br><br>

            <input type="reset" value="Reset"/>
            <input type="submit" name="submit1" value="Add Course"/>
        </form>
    <br><br>

    <!--TODO fix this
    Delete Course:
    <form action="deleteCourse" method="post">
        <select name = "course">
            <option selected disabled>Delete Course</option>
           <%-- <c:forEach items="${courses}" var="course">
                <option value = "${course}">${course}</option>
            </c:forEach>--%>
            <input type="submit" name="submit1" value="Delete Course"/>
        </select>
    </form>
    -->

    <br><br>
    <%@ include file="sched.jsp" %>
    <br><br>
    <form action="confirmationPage.jsp" method="post">
        <input type="submit" name="submit1" value="Confirm Schedule"/>
    </form>
    <br><br>
</body>
</html>
