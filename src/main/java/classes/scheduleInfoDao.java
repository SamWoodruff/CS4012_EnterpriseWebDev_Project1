package classes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;


public class scheduleInfoDao {


    private static scheduleInfoDao instance = null;
    private scheduleInfoDao(){};
    //use getinstance to see if there and if is will return the current instance
    public static scheduleInfoDao getInstance(){
        if(instance == null){
            instance = new scheduleInfoDao();
        }
        return instance;
    }

    private static String CREATE_STUDENT = "INSERT INTO STUDENT (STUDENT_ID, FIRSTNAME, LASTNAME) VALUES (?,?,?)";
    private static String CREATE_COURSE = "INSERT INTO COURSE (COURSENAME, COURSENUMBER, COURSEDAYS, COURSETIMES) VALUES (?, ?, ?, ?)";
    private static String CREATE_SCHEDULE = "INSERT INTO SCHEDULE (SCHEDULENAME, STUDENT_ID, COURSE_ID) VALUES (?,?,?)";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/enterprise";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    //select courseid from schedule where student id is student_id
    //select coursename from schedule where courseid is courseid

   Connection connection = null;
   PreparedStatement prepStatement = null;
   Statement statement = null;
   ResultSet resultSet = null;

    //will verify if studentID already exists by looking for the student_id in the database
    public boolean isNewUser(Student student){
        boolean isNewUser = true;
        String sql = "SELECT student_ID FROM STUDENT";
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //System.out.println("Result(not working i hope)"+resultSet.getInt("STUDENT_ID"));
            while(resultSet.next()){
                if(resultSet.getInt("STUDENT_ID") == student.getStudentID()){
                    isNewUser = false;
                }
            }
            statement.close();
            connection.close();
            resultSet.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isNewUser;
    }

    //add student to database
    public void addStudent(Student student){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            prepStatement = connection.prepareStatement(CREATE_STUDENT);
            prepStatement.setInt(1, student.getStudentID());
            prepStatement.setString(2, student.getFirstName());
            prepStatement.setString(3, student.getLastName());
            prepStatement.executeUpdate();
            prepStatement.close();
            connection.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //will add course
    public void addCourse(Course course){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            prepStatement = connection.prepareStatement(CREATE_COURSE, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, course.getCourseName());
            prepStatement.setString(2, course.getCourseNumber());
            prepStatement.setString(3, course.getCourseDays());
            prepStatement.setString(4, course.getCourseTimes());
            prepStatement.executeUpdate();

            //get the generated id for the course
            resultSet = prepStatement.getGeneratedKeys();
            resultSet.next();
            course.setCourseID(resultSet.getInt(1));
            statement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //add to schedule
    public void addSchedule(Schedule schedule, Student student, Course course){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            prepStatement = connection.prepareStatement(CREATE_SCHEDULE);
            prepStatement.setString(1,schedule.getScheduleName() );
            prepStatement.setInt(2,student.getStudentID());
            prepStatement.setInt(3,course.getCourseID());
            prepStatement.executeUpdate();
            prepStatement.close();
            connection.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //will delete a class
    public void deleteCourse(int id){
        String sql="DELETE FROM COURSE WHERE COURSE_ID = " + id;
        String sql2="DELETE FROM SCHEDULE WHERE COURSE_ID = " + id;

        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.addBatch(sql2);
            statement.addBatch(sql);
            statement.executeBatch();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //will get all classes and store them in an arrayList
    public ArrayList<Course> getAllCourses(Student student){
        String sql = "SELECT COURSE_ID FROM SCHEDULE WHERE STUDENT_ID = " + student.getStudentID();
        //get all the course ids in the schedule table
        ArrayList<Integer> courseIDs = new ArrayList<Integer>();
        ArrayList<Course> courses = new ArrayList<Course>();

        try{
            Class.forName(DRIVER);

            //get ids from database
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            prepStatement = connection.prepareStatement(sql);
            resultSet = prepStatement.executeQuery(sql);

            //store ids in arraylist
            while(resultSet.next()){
               courseIDs.add(resultSet.getInt(1));
            }

            resultSet.close();

            //get courses with ids and store them in course arraylist
            for(int i = 0; i < courseIDs.size(); i++){
                String sql2 = "SELECT * FROM COURSE WHERE COURSE_ID = " + courseIDs.get(i);
                prepStatement = connection.prepareStatement(sql2);
                ResultSet resultSet2 = prepStatement.executeQuery(sql2);

                resultSet2.next();

                String courseName = resultSet2.getString(2);
                String courseNumber = resultSet2.getString(3);
                String courseDays = resultSet2.getString(4);
                String courseTimes = resultSet2.getString(5);

                String days[] = courseDays.split("-");

                for(int k = 0; k < days.length; k++) {
                    Course course = new Course(courseName, courseNumber, days[k], courseTimes);
                    course.setCourseID(courseIDs.get(i));
                    courses.add(course);
                }
                resultSet2.close();
            }

            resultSet.close();
            prepStatement.close();
            connection.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
        //get all the courses using course ids
    }
//yun,andrew H for group project
}