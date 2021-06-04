package bankaccount.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class Tests {




	public static void countFields(Class<?> cl, int numberOfFields) {
		Field[] fields = cl.getDeclaredFields();
		assertEquals("The class '" + cl.getName() + "' should have exactly " + numberOfFields + " fields.",
				numberOfFields, fields.length);
		for(Field f : fields ) {
			assertNotSame("The instance field '" + f.getName()
						+ "' in class '" + cl.getName() + "' should be private.",
					0, f.getModifiers() & Modifier.PRIVATE);
		}

	}

	/**
	 *  The number of constructors is checked and each constructor is checked
	 *  	to be public.
	 */
	public static void countConstructors(Class<?> cl, int numberOfConstructors) {
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		assertEquals("The class '" + cl.getName() + "' should have exactly " + numberOfConstructors
                        + " constructors.",
                numberOfConstructors, constructors.length);
		for (int i = 0; i < constructors.length; i++) {
			assertNotSame("The constructor " + "in class '" + cl.getName() + "' should be public.",
			0, constructors[0].getModifiers() & Modifier.PUBLIC);
		}

	}


	/**
	 * Count the methods and compare to the number specified.
	 */
	public static void countMethods(Class<?> cl, int numberOfMethods) {
		Method[] methods = cl.getDeclaredMethods();
		assertEquals("The class '" + cl.getName() + "' should have exactly "
				+ numberOfMethods + " methods.",
				numberOfMethods, methods.length);
	}




}
