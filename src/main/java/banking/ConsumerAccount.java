package banking;

public class ConsumerAccount extends Account {
    Person person; 
    Long accountNumber; 
    int pin; 
    double currentBalance;
    public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
        // complete the function
    	super(person, accountNumber, pin, currentBalance);
        this.person = person; 
        this.accountNumber = accountNumber; 
        this.pin = pin; 
        this.currentBalance = currentBalance;
    }
}
