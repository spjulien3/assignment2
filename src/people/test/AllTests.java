package people.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestStructure.class, TestToString.class, TestConstructorInitialization.class,
				TestSetters.class})
public class AllTests {

}
