package bankaccount.test;


import bankaccount.BankAccount;
import bankaccount.AccountOwner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestOwnershipTest {



    private final static double EPS = 1e-10;

    private AccountOwner ao1, ao2, ao3;
    private BankAccount ba1_1, ba1_2, ba1_3, ba2_1, ba2_2;


    @Before
    public void init() {
        ao1 = new AccountOwner("id001");
        ao2 = new AccountOwner("id002");
        ao3 = new AccountOwner("id003");

        ba1_1 = new BankAccount("act001", 100);
        ba1_2 = new BankAccount("act001", 200);
        ba1_3 = new BankAccount("act001", 300);
        ba2_1 = new BankAccount("act001", 400);
        ba2_2 = new BankAccount("act001", 500);

        ba1_1.setOwner(ao1);
        ba1_2.setOwner(ao1);
        ba1_3.setOwner(ao1);

        ao1.getAccountsOwned().add(ba1_1);
        ao1.getAccountsOwned().add(ba1_2);
        ao1.getAccountsOwned().add(ba1_3);

        ao2.getAccountsOwned().add(ba2_1);
        ao2.getAccountsOwned().add(ba2_2);
        ao2.getAccountsOwned().add(ba1_3);
    }

    @Test
    public void test_ownership1() {
        // Ownership is consistent
        assertTrue(ao1.ownerOfAllAccountsOwned());
    }

    @Test
    public void test_ownership2() {
        // Ownership is not consistent
        assertFalse(ao2.ownerOfAllAccountsOwned());
    }


    @Test
    public void test_ownership3() {
        // Ownership is consistent even when there are no accounts owned
        assertTrue(ao3.ownerOfAllAccountsOwned());
    }


}




