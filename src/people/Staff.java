package people;
import java.util.Date;
public class Staff extends Employee {
    private String title;

    public Staff(String name, String emailAddress, double salary, String title ) {
        super(name, emailAddress, salary);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString(){

        return "Staff:"+getName();}
}
