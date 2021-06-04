package bankaccount.test;


import bankaccount.AccountOwner;
import bankaccount.BankAccount;
import bankaccount.SavingsAccount;
import org.junit.Test;


public class TestStructure {



    @Test
    public  void testFields() {
        Tests.countFields(BankAccount.class, 4);
        Tests.countFields(SavingsAccount.class, 1);
        Tests.countFields(AccountOwner.class, 4);
    }

    @Test
    public  void testConstructors() {
        Tests.countConstructors(BankAccount.class, 3);
        Tests.countConstructors(SavingsAccount.class, 2);
        Tests.countConstructors(AccountOwner.class, 2);
    }

//    @Test
//    public  void testMethods() {
//        //Tests.countMethods(BankAccount.class, 3);
//    }

	

}