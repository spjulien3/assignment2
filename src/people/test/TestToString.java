package people.test;


import people.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestToString {

	private static final String name = "Alice";
	private static final String email = "a@k.edu";
	private static final double salary = 3.14159;
	private static final String officeHours = "3AM to 4AM Tuesdays";
	private static final String title = "chief copier";
	private static final String classStatus = "SO";
	
	@Test
	public void testPerson() {
		Person p = new Person(name, email);
		String tostr = "Person:" + name;
		assertEquals(tostr, p.toString());
	}

	@Test
	public void testFaculty() {
		Faculty f = new Faculty(name, email, salary, officeHours);
		String tostr = "Faculty:" + name;
		assertEquals(tostr, f.toString());
	}
	
	@Test
	public void testStudent() {
		Student s = new Student(name, email, classStatus);
		String tostr = "Student:" + name;
		assertEquals(tostr, s.toString());
	}
	
	@Test
	public void testEmployee() {
		Employee e = new Employee(name, email, salary);
		String tostr = "Employee:" + name;
		assertEquals(tostr, e.toString());
	}
	
	@Test 
	public void testStaff() {
		Staff s = new Staff(name, email, salary, title);
		String tostr = "Staff:" + name;
		assertEquals(tostr, s.toString());
	}
}
