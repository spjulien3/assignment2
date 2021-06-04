package people;
import java.util.Date;
public class Employee extends Person {
    private double salary;
    private Date dateHired=new Date();
    public Employee (String name, String emailAddress, double salary){
        super(name, emailAddress);
        this.salary=salary;
    }
    public Date getDateHired(){
        return dateHired;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString(){

        return "Employee:"+getName();}
}
