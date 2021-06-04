package people.test;

import people.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConstructorInitialization {

	private static final String name = "Ewing";
	private static final String email = "e@k.edu";
	private static final double salary = 2.718281828459045;
	private static final String officeHours = "3PM to 4PM in March";
	private static final String title = "subordinate copier";
	private static final String classStatus = "JR";
	
	private static final double EPS = 1e-10;
	
	@Test
	public void testPerson() {
		Person p = new Person(name, email);
		assertEquals(name, p.getName());
		assertEquals(email, p.getEmailAddress());
	}

	@Test
	public void testFaculty() {
		Faculty f = new Faculty(name, email, salary, officeHours);
		assertEquals(name, f.getName());
		assertEquals(email, f.getEmailAddress());
		assertEquals(salary, f.getSalary(), EPS);
		assertEquals(officeHours, f.getOfficeHours());
		
	}
	
	@Test
	public void testStudent() {
		Student s = new Student(name, email, classStatus);
		assertEquals(name, s.getName());
		assertEquals(email, s.getEmailAddress());
		assertEquals(classStatus, s.getClassStatus());
		
	}
	
	@Test
	public void testEmployee() {
		Employee e = new Employee(name, email, salary);
		assertEquals(name, e.getName());
		assertEquals(email, e.getEmailAddress());
		assertEquals(salary, e.getSalary(), EPS);
	}
	
	@Test 
	public void testStaff() {
		Staff s = new Staff(name, email, salary, title);
		assertEquals(name, s.getName());
		assertEquals(email, s.getEmailAddress());
		assertEquals(salary, s.getSalary(), EPS);
		assertEquals(title, s.getTitle());

	}

}
