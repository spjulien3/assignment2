
package bankaccount;

import java.util.ArrayList;

public class AccountOwner {

	private String name;
	private String accountOwnerId;
	private String e_mail;
	private ArrayList<BankAccount>accountsOwned;
	
	/**
	 * Initialize the properties of this object to the given parameter values.
	 * If a value is not known, use null.
	 */
	public AccountOwner(String name, String accountOwnerId, String e_mail,ArrayList<BankAccount>accountsOwned) {
		this.name = name;
		this.accountOwnerId = accountOwnerId;
		this.e_mail = e_mail;
		this.accountsOwned=accountsOwned;
	}

	public ArrayList<BankAccount> getAccountsOwned() {
		return accountsOwned;
	}

	public AccountOwner(String accountOwnerId) {
		this.accountOwnerId = accountOwnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getAccountOwnerIdId() {
		return accountOwnerId;
	}
	
	public double totalBalanceOfAccountsOwned(){

		double sum=0;
		for(int i=0;i<accountsOwned.size();i++) {
			sum +=accountsOwned.get(i).getBalance();
		}
		return sum;
	}
	public boolean ownerOfAllAccountsOwned(){
		boolean x=false;
		for(int i=0;i<accountsOwned.size();i++){
			if (accountOwnerId==accountsOwned.get(i).getAccountId()){
				x=true;
			}
		}
		return x;
	}
	
}
