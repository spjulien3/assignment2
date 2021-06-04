
package bankaccount;

public class SavingsAccount extends BankAccount {
    private double annualInterestRate;

    public SavingsAccount(String initialAccountId, double annualInterestRate) {
        super(initialAccountId);
        this.annualInterestRate = annualInterestRate;
    }

    public SavingsAccount(String initialAccountId, double initialBalance, double annualInterestRate) {
        super(initialAccountId, initialBalance);
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void month_end_process() {
        try {
            deposit(getBalance() * (annualInterestRate) / 12);
            super.month_end_process();
        } catch (Exception ex) {


        }
    }
}

