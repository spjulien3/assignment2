package people.test;

import people.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.Date;
public class TestSetters {

	
	private static final String name = "Alice";
	private static final String email = "a@k.edu";
	private static final double salary = 3.14159;
	private static final String officeHours = "3AM to 4AM Tuesdays";
	private static final String title = "chief copier";
	private static final String classStatus = "SO";
	
	private static final String name2 = "Ewing";
	private static final String email2 = "e@k.edu";
	private static final double salary2 = 2.718281828459045;
	private static final String officeHours2 = "3PM to 4PM in March";
	private static final String title2 = "subordinate copier";
	private static final String classStatus2 = "JR";
	
private static final double EPS = 1e-10;
	
	private void testNameEmail(Person p) {
		p.setName(name2);
		assertEquals(name2, p.getName());
		p.setEmailAddress(email2);
		assertEquals(email2, p.getEmailAddress());		
	}
	
	private void testNameEmailSalary(Employee e) {
		testNameEmail(e);
		e.setSalary(salary2);
		assertEquals(salary2, e.getSalary(), EPS);
	}

	@Test
	public void testPerson() {
		Person p = new Person(name, email);
		testNameEmail(p);
	}

	@Test
	public void testFaculty() {
		Faculty f = new Faculty(name, email, salary, officeHours);
		testNameEmailSalary(f);
		f.setOfficeHours(officeHours2);
		assertEquals(officeHours2, f.getOfficeHours());
		
	}
	
	@Test
	public void testStudent() {
		Student s = new Student(name, email, classStatus);
		testNameEmail(s);
		s.setClassStatus(classStatus2);
		assertEquals(classStatus2, s.getClassStatus());
		
	}
	
	@Test
	public void testEmployee() {
		Employee e = new Employee(name, email, salary);
		testNameEmailSalary(e);
	}
	
	@Test 
	public void testStaff() {
		Staff s = new Staff(name, email, salary, title);
		testNameEmailSalary(s);
		s.setTitle(title2);
		assertEquals(title2, s.getTitle());

	}

}
