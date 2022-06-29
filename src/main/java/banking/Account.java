package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 * <p>
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface{
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        // complete the constructor
    	this.accountHolder = accountHolder;
    	this.accountNumber = accountNumber;
    	this.pin = pin;
    	this.balance += startingDeposit;
    	
    }


    public boolean validatePin(int attemptedPin) {
        return attemptedPin == pin;
    }

    public synchronized double getBalance() {
        return this.balance;
    }


    public synchronized void creditAccount(double amount) {
        // complete the function
    	this.balance += amount;
    }

    public synchronized boolean debitAccount(double amount) {
        // complete the function
    	if(this.balance >= amount) {
    		this.balance -= amount;
    		return true;
    	}
    	return false;
    	
    }


	public AccountHolder getAccountHolder() {
		return accountHolder;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}
}
