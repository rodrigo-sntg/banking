package banking;

public abstract class AccountHolder {
    protected int idNumber;

    /**
     * @param idNumber The government-issued ID used during account setup.
     */
    public AccountHolder(int idNumber) {
    	this.idNumber = idNumber;
        // complete the function
    }


    /**
     * @return private int {@link AccountHolder#idNumber}
     */
    public int getIdNumber() {
    	return idNumber;
    }
}
