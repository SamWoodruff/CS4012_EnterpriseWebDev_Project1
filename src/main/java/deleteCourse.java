import classes.Course;
import classes.scheduleInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "deleteCourse",
        urlPatterns = "/deleteCourse")
public class deleteCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        scheduleInfoDao dao = scheduleInfoDao.getInstance();
        String course = request.getParameter("course");

        if(course == null) {
            request.getRequestDispatcher("/courseSchedulePage.jsp").forward(request, response);
        }else{
            //delete class
            //get student id then pass to function
            ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");

            for(int i = 0; i < courses.size(); i++){
               if(courses.get(i).toString() == course);
                {
                    System.out.println(courses.get(i).getCourseID());
                    dao.deleteCourse(courses.get(i).getCourseID());
                    request.getRequestDispatcher("/updateCourses").forward(request, response);
                }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
