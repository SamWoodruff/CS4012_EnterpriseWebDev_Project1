import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;

import classes.*;//imports java classes

@WebServlet(name = "login",
            urlPatterns = "/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();//get current session
        //get dao
        scheduleInfoDao dao = scheduleInfoDao.getInstance();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        String scheduleName = request.getParameter("scheduleName");

        Schedule schedule = new Schedule(scheduleName);
        Student student = new Student(firstName,lastName,studentID);



        session.setAttribute("student", student);
        ArrayList<Course> courses = dao.getAllCourses(student);//get all courses for a student
        session.setAttribute("courses", courses);

        session.setAttribute("schedule", schedule);

        if(dao.isNewUser(student) == false)//add student to db if new user then foward to calendar page
        {
            request.getRequestDispatcher("/updateCourses").forward(request, response);
        }
        else if (dao.isNewUser(student) == true){ //get all courses stored in db if user isnt new user and then forward to calendar page
            dao.addStudent(student);
            request.getRequestDispatcher("/courseSchedulePage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
