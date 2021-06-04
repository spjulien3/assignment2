package bankaccount;


public class FeeForTransactionAccount extends BankAccount {

    private double feeForDeposit;
    private double feeForWithdrawal;

    public FeeForTransactionAccount(String accountId) {
        super(accountId);
    }

    public FeeForTransactionAccount(String accountID, double initialBalance,
                                    double initialFeeForDeposit, double initialFeeForWithdrawal) {
        super(accountID, initialBalance);
        feeForDeposit = initialFeeForDeposit;
        feeForWithdrawal = initialFeeForWithdrawal;
    }

    public FeeForTransactionAccount(String initialAccountid, double initialBalance,
                                    AccountOwner initialOwner, double feeForDeposit, double feeForWithdrawal) {
        super(initialAccountid, initialBalance, initialOwner);
        this.feeForDeposit = feeForDeposit;
        this.feeForWithdrawal = feeForWithdrawal;
    }

    public double getFeeForDeposit() {
        return feeForDeposit;
    }

    public void setFeeForDeposit(double feeForDeposit) {
        this.feeForDeposit = feeForDeposit;
    }

    public double getFeeForWithdrawal() {
        return feeForWithdrawal;
    }

    public void setFeeForWithdrawal(double feeForWithdrawal) {
        this.feeForWithdrawal = feeForWithdrawal;
    }

    @Override
    public void deposit(double amount) {
       // We also need to subtract the fee, we'll use withdraw for that
        // make sure the fee won't make the balance negative!
        //  Example: Balance is 5 cents, deposit is 4 cents and fee is 10 cents (problem)
        //  balance + amount >= deposit fee
        if((amount > 0) && (getBalance() + amount >= feeForDeposit)) {
            // do the deposit
            super.deposit(amount);
            // charge the fee
            super.withdraw(feeForDeposit);
        } else {
            System.err.println("Amount of deposit does not cover the deposit fee");
            System.exit(1);
        }

    }

    @Override
    public void withdraw(double amount) {
        // amount + fee for withdrawal <= balance
        if((amount >= 0) && (amount + feeForWithdrawal <= getBalance())) {
            super.withdraw(amount);
            super.withdraw(feeForWithdrawal);
        } else {
            System.err.println("Amount of withdrawal is too large");
            System.exit(1);
        }
    }

}
