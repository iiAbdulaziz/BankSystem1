public class Loan {

    private int quantity;
    private int timing;
    private double rate = 1;
    private double TotalQuantity;
    private double NoInterest;
    private double Remaining;
    private double MonthlyPaymentSize;
    private Account Acc;

    public Loan(int quantity, int timing) {
        this.quantity = quantity;
        this.timing = timing;
        Remaining = quantity;
        NoInterest = quantity * (rate / 100);
        System.out.println("noInterest is: " + NoInterest);
        TotalQuantity = quantity + NoInterest;
        MonthlyPaymentSize = TotalQuantity / timing;
    }

    // Setter 
    public void setRemaining(double Remaining) {
        this.Remaining = Remaining;
    }

    public void setAcc(Account Acc) {
        this.Acc = Acc;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void settiming(int timing) {
        this.timing = timing;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.TotalQuantity = totalQuantity;
    }

    public void setNoInterest(double NoInterest) {
        this.NoInterest = NoInterest;
    }

    public void setMonthlyPaymentSize(double monthlyPaymentAmount) {
        this.MonthlyPaymentSize = monthlyPaymentAmount;
    }

    //Getter
    public double getRemaining() {
        return Remaining;
    }

    public Account getAcc() {
        return Acc;
    }

    public int getQuantity() {
        return quantity;
    }

    public int gettiming() {
        return timing;
    }

    public double getRate() {
        return rate;
    }

    public double getTotalQuantity() {
        return TotalQuantity;
    }

    public double getNoInterest() {
        return NoInterest;
    }

    public double getMonthlyPaymentSize() {
        return MonthlyPaymentSize;
    }

    // To String 
    @Override
    public String toString() {
        return "Loan information: " + "\n" + "Quantity = " + quantity
                + "\n" + " Timing = " + timing
                + "\n" + " Rate = " + rate
                + "\n" + " TotalQuantity = " + TotalQuantity
                + "\n" + " NoInterest = " + NoInterest
                + "\n" + " MonthlyPaymentSize = " + MonthlyPaymentSize
                + "\n" + " Remaining = " + Remaining;
    }
}
