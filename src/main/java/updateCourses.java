import classes.Course;
import classes.Student;
import classes.scheduleInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "updateCourses",
        urlPatterns = "/updateCourses")
public class updateCourses extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        scheduleInfoDao dao = scheduleInfoDao.getInstance();
        HttpSession session = request.getSession();//get current session
        Student student = (Student)session.getAttribute("student");//get student in the current session

        ArrayList<Course> courses = dao.getAllCourses(student);//get all courses for a student
        session.setAttribute("courses",courses);//Put all courses in session scope

        System.out.println(courses);

        request.getRequestDispatcher("/courseSchedulePage.jsp").forward(request, response);//send to calendar page
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
