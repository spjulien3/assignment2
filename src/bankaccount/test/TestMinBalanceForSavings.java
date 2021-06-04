package bankaccount.test;

import bankaccount.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class TestMinBalanceForSavings {

    private final static double EPS = 1e-10;
    private String id0 = "acct001";
    private String id1 = "acct002";
    private double bal1 = 200;
    private SavingsAccount sa0, sa1;


    @Before
    public void init() {
        sa0 = new SavingsAccount(id0, .12);
        sa1 = new SavingsAccount(id1, bal1, .12);
    }


    /**
     * Start with 0 balance, perform some actions, check that the minbalance is 0.
     */
    @Test
    public void test1() {
        sa0.deposit(200);
        sa0.withdraw(50);
        assertEquals("Min balance is not correct", 0, sa0.getMinBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit and withdraw to leave balance higher, min balance should be 200
     */
    @Test
    public void test2() {
        sa1.deposit(200);
        sa1.withdraw(50);
        assertEquals("Min balance is not correct", bal1, sa1.getMinBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit and withdraw to leave balance lower at the end.
     */
    @Test
    public void test3() {
        sa1.deposit(200);
        sa1.withdraw(250);
        assertEquals("Min balance is not correct", bal1-50, sa1.getMinBalance(), EPS);
    }


    /**
     * Start with 200 balance, deposit, withdraw, deposit to leave lowest balance in the middle.
     */
    @Test
    public void test4() {
        sa1.deposit(200);
        sa1.withdraw(250);
        sa1.deposit(100);
        assertEquals("Min balance is not correct", bal1-50, sa1.getMinBalance(), EPS);
    }

    /**
     * Start with 200 balance, deposit, withdraw, deposit, withdraw, deposit so min balance is after
     *  the first withdraw
     */
    @Test
    public void test5() {
        sa1.deposit(200);
        sa1.withdraw(250);
        sa1.deposit(100);
        sa1.withdraw(50);
        sa1.deposit(100);
        assertEquals("Min balance is not correct", bal1 - 50, sa1.getMinBalance(), EPS);
    }


    /**
     * Tests resetting the min balance.
     * The min balance before the reset is lower than the min balance after the reset.
     */
    @Test
    public void test6() {
        sa1.withdraw(50);  // 150
        sa1.deposit(200);  // 350
        assertEquals("", 150, sa1.getMinBalance(), EPS);
        sa1.resetMinBalance();
        sa1.withdraw(100);  // 250
        sa1.deposit(50);  // 300
        sa1.withdraw(100);  // 200
        sa1.deposit(100);  // 300
        assertEquals("", 200, sa1.getMinBalance(), EPS );
    }
}
