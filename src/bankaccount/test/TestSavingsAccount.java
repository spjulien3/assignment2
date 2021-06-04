package bankaccount.test;


import bankaccount.BankAccount;
import bankaccount.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestSavingsAccount {

    private final static double EPS = 1e-10;
    private String id0 = "acct001";
    private String id1 = "acct002";
    private double bal1 = 200;
    private double irate0 = .12;
    private double irate1 = .12;
    private SavingsAccount sa0, sa1;


    @Before
    public void init() {
        sa0 = new SavingsAccount(id0, irate0);
        sa1 = new SavingsAccount(id1, bal1, irate1);
    }


    @Test
    public void test1() {
        assertEquals("Annual interest rate not stored properly in SavingsAccount",irate1, sa1.getAnnualInterestRate(), EPS);
    }



    /**
     * Start with 200 balance, deposit and withdraw to leave balance higher, min balance should be 200
     */
    @Test
    public void test2() {
        sa1.deposit(200);
        sa1.withdraw(50);
        double expectedInterest = sa1.getMinBalance() * irate1 / 12;
        double expectedBalance = sa1.getBalance() + expectedInterest;
        sa1.month_end_process();
        assertEquals("Savings interest not computed properly", expectedBalance, sa1.getBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit and withdraw to leave balance lower at the end.
     */
    @Test
    public void test3() {
        sa1.deposit(200);
        sa1.withdraw(250);

        double expectedInterest = sa1.getMinBalance() * irate1 / 12;
        double expectedBalance = sa1.getBalance() + expectedInterest;
        sa1.month_end_process();
        assertEquals("Savings interest not computed properly", expectedBalance, sa1.getBalance(), EPS);
    }


}
