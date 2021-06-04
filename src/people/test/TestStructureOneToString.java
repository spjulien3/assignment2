package people.test;
/*
 * Use this test if you define toString only in the Person class.
 * Again: not recommended, but you might enjoy the puzzle.
 */


import people.*;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class TestStructureOneToString {

	

	/**
	 * There should be two private fields and no others.
	 */
	@Test
	public void testFieldsPerson() {
		countFields(Person.class, 2);
	}

	/**
	 * There should be two private fields and no others.
	 */
	@Test
	public void testFieldsEmployee() {
		countFields(Employee.class, 2);
	}

	/**
	 * There should be one private field and no others.
	 */
	@Test
	public void testFieldsFaculty() {
		countFields(Faculty.class, 1);
	}

	/**
	 * There should be one private field and no others.
	 */
	@Test
	public void testFieldsStaff() {
		countFields(Staff.class, 1);
	}

	/**
	 * There should be one private field and no others.
	 */
	@Test
	public void testFieldsStudent() {
		countFields(Student.class, 1);
	}


	public void countFields(Class<?> cl, int numberOfFields) {
		Field[] fields = cl.getDeclaredFields();
		assertEquals("The class '" + cl.getName() + "' should have exactly " + numberOfFields + " fields.",
				numberOfFields, fields.length);
		for(Field f : fields ) {
			assertNotSame("The instance field '" + f.getName() 
						+ "' in class '" + cl.getName() + "' should be private.",
					0, f.getModifiers() & Modifier.PRIVATE);
		}
		
	}
	

	@Test
	public void testConstructorsPerson() {
		countConstructors(Person.class, 1);
	}
	

	@Test
	public void testConstructorsEmployee() {
		countConstructors(Employee.class, 1);
	}
	

	@Test
	public void testConstructorsStudent() {
		countConstructors(Student.class, 1);
	}
	

	@Test
	public void testConstructorsStaff() {
		countConstructors(Staff.class, 1);
	}
	

	@Test
	public void testConstructorsFaculty() {
		countConstructors(Faculty.class, 1);
	}
	

	/**
	 *  The number of constructors is checked and each constructor is checked
	 *  	to be public.
	 */
	public void countConstructors(Class<?> cl, int numberOfConstructors) {
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		assertEquals(numberOfConstructors, constructors.length);
		for (int i = 0; i < constructors.length; i++) {
			assertNotSame("The constructor " + "in class '" + cl.getName() + "' should be public.",
			0, constructors[0].getModifiers() & Modifier.PUBLIC);
		}

	}

	
	@Test
	public void testPersonMethods() {
		countMethods(Person.class, 5);
	}

	@Test
	public void testEmployeeMethods() {
		countMethods(Employee.class, 3);
	}

	@Test
	public void testStudentMethods() {
		countMethods(Student.class, 2);
	}

	@Test
	public void testStaffMethods() {
		countMethods(Staff.class, 2);
	}

	@Test
	public void testFacultyMethods() {
		countMethods(Faculty.class, 2);
	}
	
	/**
	 * Count the methods and compare to the number specified.
	 */
	public void countMethods(Class<?> cl, int numberOfMethods) {
		//Class<?> cl = Length.class;
		//int numberOfMethods = 7;
		Method[] methods = cl.getDeclaredMethods();
		assertEquals("The class '" + cl.getName() + "' should have exactly " 
				+ numberOfMethods + " methods.", 
				numberOfMethods, methods.length);
		
	}
	

	

}