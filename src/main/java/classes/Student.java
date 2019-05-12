package classes;

public class Student {
    private int studentID;
    private String firstName;
    private String lastName;


    public Student(String firstName, String lastName, int studentID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public void setStudentID( int studentID){ this.studentID = studentID; }

    public void setFirstName( String firstName){ this.firstName = firstName; }

    public void setlastName( String lastName){ this.lastName = lastName; }


    public int getStudentID(){
        return studentID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
