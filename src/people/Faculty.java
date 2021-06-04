package people;
import java.util.Date;
public class Faculty extends Employee  {
    private String officeHours;
    public Faculty(String name, String emailAddress, double salary,String officeHours) {
        super(name,emailAddress,salary);
        this.officeHours = officeHours;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    @Override
    public String toString(){

    return "Faculty:"+getName();}
}
