package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private String courseName;
    private String courseNumber;
    private String courseDays;
    private String courseTimes;
    int startTime, endTime;
    private int day;
    private int course_ID;

    public Course(String courseName, String courseNumber, String courseDays, String courseTimes) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseDays = courseDays;
        this.courseTimes = courseTimes;
        setDays();
        getTimes();

    }

    public void getTimes(){
        String [] times = courseTimes.split("-");
        this.startTime = Integer.parseInt(times[0]);
        this.endTime = Integer.parseInt(times[1]);
        System.out.println("Start Time: " + startTime + "End Time: " + endTime);
    }

    public void setDays(){
            if(courseDays.equals("M")){ day= 0;}
            if(courseDays.equals("T")){ day = 1;}
            if(courseDays.equals("W")){ day = 2;}
            if(courseDays.equals("Th")){ day = 3;}
            if(courseDays.equals("F")){ day = 4;}
    }

    public int getStartTime(){
        return startTime;
    }

    public int getEndTime(){
        return endTime;
    }

    public int getDay(){
        return day;
    }

    public Course(String courseName, String courseTimes) {
        this.courseName = courseName;
        this.courseTimes = courseTimes;

    }




    private void setCourseName( String courseName){ this.courseName = courseName; }

    private void setCourseNumber( String courseNumber){ this.courseNumber = courseNumber; }

    private void setCourseDays( String courseDays){ this.courseDays = courseDays; }

    private void setCourseTimes( String courseTimes){ this.courseTimes = courseTimes; }

    public void setCourseID(int courseID) {
        this.course_ID = courseID;
    }

    public int getCourseID(){
        return course_ID;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseNumber(){ return courseNumber; }

    public String getCourseDays(){
        return courseDays;
    }

    public String getCourseTimes(){
        return courseTimes;
    }

    @Override
    public String toString(){
        return (this.courseName + "-" + this.courseNumber);
    }

}
