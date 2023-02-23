public class Account extends Customer {

    private double AccountID;
    private double Balance;
    private Loan Lo;

    public Account() {

    }

    public Account(int natID, int PN, String n, String ad, String em) {
        super(natID, PN, n, ad, em);
    }

//Setter 
    public void setLo(Loan Lo) {
        this.Lo = Lo;
    }

    public void setAccountID(double AccountID) {
        this.AccountID = AccountID;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

//Getter
    public Loan getLo() {
        return Lo;
    }

    public double getAccountID() {
        return AccountID;
    }

    public double getBalance() {
        return Balance;
    }

//To String
    @Override
    public String toString() {
        return super.toString()
                + "\n" + "Account ID = " + getAccountID()
                + "\n" + "Balance = " + getBalance();
    }

}
