package bankaccount.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestStructure.class,  TestMinBalance.class,
                TestMinBalanceForSavings.class, TestSavingsAccount.class})
public class AllTests {


}
