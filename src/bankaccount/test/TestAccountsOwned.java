package bankaccount.test;


import bankaccount.BankAccount;
import bankaccount.AccountOwner;
import bankaccount.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestAccountsOwned {



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
    public void test_total_balance1() {
        // normal total balance
        assertEquals(600, ao1.totalBalanceOfAccountsOwned(), EPS);
    }


    @Test
    public void test_total_balance2() {
        // balance still works even though p2 doesn't really own one of the accounts included
        assertEquals(1200, ao2.totalBalanceOfAccountsOwned(), EPS);
    }


    @Test
    public void test_total_balance3() {
        // no accounts means 0 total balance
        assertEquals(0, ao3.totalBalanceOfAccountsOwned(), EPS);
    }



}




