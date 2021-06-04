package bankaccount.test;

import bankaccount.BankAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class TestMinBalance {

    private final static double EPS = 1e-10;
    private String id0 = "acct001";
    private String id1 = "acct002";
    private double bal1 = 200;
    private BankAccount ba0, ba1;


    @Before
    public void init() {
        ba0 = new BankAccount(id0);
        ba1 = new BankAccount(id1, bal1);
    }


    /**
     * Start with 0 balance, perform some actions, check that the minbalance is 0.
     */
    @Test
    public void test1() {
        ba0.deposit(200);
        ba0.withdraw(50);
        assertEquals("Min balance is not correct", 0, ba0.getMinBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit and withdraw to leave balance higher, min balance should be 200
     */
    @Test
    public void test2() {
        ba1.deposit(200);
        ba1.withdraw(50);
        assertEquals("Min balance is not correct", bal1, ba1.getMinBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit and withdraw to leave balance lower at the end.
     */
    @Test
    public void test3() {
        ba1.deposit(200);
        ba1.withdraw(250);
        assertEquals("Min balance is not correct", bal1-50, ba1.getMinBalance(), EPS);
    }


    /**
     * Start with 200 balance, deposit, withdraw, deposit to leave lowest balance in the middle.
     */
    @Test
    public void test4() {
        ba1.deposit(200);
        ba1.withdraw(250);
        ba1.deposit(100);
        assertEquals("Min balance is not correct", bal1-50, ba1.getMinBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit, withdraw, deposit, withdraw, deposit so min balance is after
     *  the first withdraw
     */
    @Test
    public void test5() {
        ba1.deposit(200);
        ba1.withdraw(250);
        ba1.deposit(100);
        ba1.withdraw(50);
        ba1.deposit(100);
        assertEquals("Min balance is not correct", bal1 - 50, ba1.getMinBalance(), EPS);
    }


    /**
     * Tests resetting the min balance.
     * The min balance before the reset is lower than the min balance after the reset.
     */
    @Test
    public void test6() {
        ba1.withdraw(50);  // 150
        ba1.deposit(200);  // 350
        assertEquals("", 150, ba1.getMinBalance(), EPS);
        ba1.resetMinBalance();
        ba1.withdraw(100);  // 250
        ba1.deposit(50);  // 300
        ba1.withdraw(100);  // 200
        ba1.deposit(100);  // 300
        assertEquals("", 200, ba1.getMinBalance(), EPS );
    }
}
