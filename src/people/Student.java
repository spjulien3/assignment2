package people;

public class Student extends Person {
    private String classStatus;

    public Student(String name, String emailAddress, String classStatus) {
        super(name, emailAddress);
        this.classStatus = classStatus;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }
    @Override
    public String toString(){

        return "Student:"+getName();}
}
