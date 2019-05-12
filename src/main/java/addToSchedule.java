import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import classes.*;

@WebServlet(name = "addToSchedule",
        urlPatterns = "/addToSchedule")
public class addToSchedule extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //get variables
        String courseName = request.getParameter("courseName");
        String courseNumber = request.getParameter("courseNumber");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String courseTimes = startTime + "-" + endTime;

        Student student = (Student)session.getAttribute("student");

        String scheduleName = request.getParameter("schedule");
        Schedule schedule = new Schedule(scheduleName);

        String mon = request.getParameter("Monday");
        String tues = request.getParameter("Tuesday");
        String wed = request.getParameter("Wednesday");
        String thurs= request.getParameter("Thursday");
        String fri = request.getParameter("Friday");

        //find the days of the week
        String[] days = new String[5];
        String courseDays = null;
        days[0] = mon; days [1] = tues; days[2] = wed; days[3] = thurs; days[4] = fri;;
        for(int i = 0; i < days.length; i++){
            if(days[i] != null)
            {
                if(courseDays == null){courseDays = days[i];}
                else{ courseDays = courseDays + "-" + days[i];}

            }
        }

        //create dao and add course to db
        scheduleInfoDao dao = scheduleInfoDao.getInstance();
        Course course = new Course(courseName,courseNumber,courseDays,courseTimes);
        dao.addCourse(course);
        dao.addSchedule(schedule,student,course);

        //request page
        request.getRequestDispatcher("/updateCourses").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
