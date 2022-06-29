package banking;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private Map<Long, Account> accounts;
    private AtomicLong lasId;

    public Bank() {
        // complete the function
    	this.accounts = Collections.synchronizedMap(new LinkedHashMap<Long, Account>()) ;
    	lasId = new AtomicLong(0l);
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
    	Account account = new CommercialAccount(company, lasId.incrementAndGet(), pin, startingDeposit);
    	accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
    	Account account = new ConsumerAccount(person, lasId.incrementAndGet(), pin, startingDeposit);
    	accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
    	Account account = this.getAccount(accountNumber);
    	if(Objects.nonNull(account))
    		return account.validatePin(pin);
    	return false;
    }

    public double getBalance(Long accountNumber) {
        // complete the function
    	Account account = this.getAccount(accountNumber);

    	if(Objects.nonNull(account))
    		return account.getBalance();
    	return 0;
    }

    public void credit(Long accountNumber, double amount) {
        // complete the function
    	Account account = this.getAccount(accountNumber);

    	if(Objects.nonNull(account))
    		account.creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        // complete the function
    	Account account = this.getAccount(accountNumber);
    	if(Objects.nonNull(account))
    		return account.debitAccount(amount);
    	return false;
    }
}
