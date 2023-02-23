import java.util.Scanner;
import java.util.Vector;

public class Bank {

    static Scanner in = new Scanner(System.in);
    private static double accID = 0.0;

    //Vector
    static Vector<Account> acc = new Vector<Account>();

    //Search
    public static Account searchAccount(double ID) {

        //For Loop
        for (Account acc : acc) {
            if (acc.getAccountID() == ID) {
                return acc;
            }
        }
        System.out.println("The Account ID is rong! ");
        return null;
    }

    public static void Call1() {

        Account C1 = new Account();
        System.out.println("Create a new account.");

        //Print Account Class
        System.out.print("Enter your Name: ");
        C1.setname(in.next());
        System.out.print("Enter your National ID: ");
        C1.setnationalID(in.nextInt());
        System.out.print("Enter your PhoneNumber: ");
        C1.setPhoneNumber(in.nextInt());
        System.out.print("Enter your Address: ");
        C1.setaddress(in.next());
        System.out.print("Enter your Email: ");
        C1.setemail(in.next());
        System.out.println("");
        accID = accID + 1.0;
        C1.setAccountID(accID);
        System.out.println(C1);
        acc.add(C1);
    }

    public static void Call2() {

        System.out.println("Deposit an size on an existing account. ");

        //Print Account Class
        //Deposite
        System.out.print("Enter your Account ID: ");
        double deposite = in.nextDouble();
        Account search = searchAccount(deposite);
        if (search != null) {
            System.out.println("How much money do you want to leave in your account? ");

            int size = in.nextInt();
            if (size <= 0) {
                System.out.println("This is invalid number!! "
                        + "\n" + "Please enter a valid number. ");
            } else {
                search.setBalance(search.getBalance() + size);
                System.out.println("Balance = " + search.getBalance() + " SAR");
                System.out.println("");
                System.out.println(search);
            }
        }
    }

    public static void Call3() {

        System.out.println("Withdraw an size from an existing account. ");

        //Print Account Class
        //Withdraw
        System.out.print("Enter your Account ID: ");
        double Withdraw = in.nextDouble();
        Account search2 = searchAccount(Withdraw);
        if (search2 != null) {
            System.out.println("How much money do you want to withdraw from your account? ");
            int size2 = in.nextInt();
            if (size2 <= 0) {
                System.out.println("This is invalid number!! " + "\n" + "Please enter a valid number. ");

            } else {
                if (search2.getBalance() - size2 >= 0) {
                    search2.setBalance(search2.getBalance() - size2);
                    System.out.println("Balance = " + search2.getBalance() + " SAR");
                    System.out.println("");
                    System.out.println(search2);
                } else {
                    System.out.println("You don't have that amount!!! ");
                }
            }

        }
    }

    public static void Call4() {

        Account search = new Account();
        System.out.println("Check the current Balance of an existing account. ");
        System.out.print("Enter your Account ID: ");
        double AccountID = in.nextInt();
        search = searchAccount(AccountID);
        System.out.println(search.toStringCustomer());
        System.out.println("Account ID = " + search.getAccountID());
        System.out.println("Balance = " + search.getBalance() + " SAR");
    }

    public static void Call5() {

        Account search = new Account();
        System.out.println("Get a new loan on an existing account. ");
        System.out.print("Enter your Account ID: ");
        double loan = in.nextInt();
        search = searchAccount(loan);

        //If statment for in order to verify the existence of the account.
        if (search != null) {
            //If statment for to check whether there is a loan or not.
            if (search.getLo() == null) {
                System.out.println("How much loan do you want to borrow? ");
                int much = in.nextInt();
                System.out.println("In how many months do you want to pay? ");
                int month = in.nextInt();
                Loan l = new Loan(much, month);
                search.setLo(l);
                l.setAcc(search);
                search.setBalance(search.getBalance() + much);
            }
        }
    }

    public static void Call6() {

        Account search = new Account();
        System.out.println("Check an existing loan status. ");
        System.out.print("Enter your Account ID: ");
        double LoCheck = in.nextInt();
        search = searchAccount(LoCheck);

        //If statment for to check whether the account is in the bank or not.
        if (search != null) {
            //If statment for in order to check whether there is a loan in the account or not.
            if (search.getLo() != null) {
                System.out.println(search.getLo());
            }
        }
    }

    public static void Call7() {

        Account search = new Account();
        System.out.println("Pay for the monthly payment for an existing loan. ");
        System.out.println("Check an existing loan status. ");
        System.out.print("Enter your Account ID: ");
        double LoPay = in.nextInt();
        search = searchAccount(LoPay);

        //If statment for to check whether the account is in the bank or not.
        if (search != null) {

            //If statment for in order to check whether there is a loan in the account or not.
            if (search.getLo() != null) {

                //If statment for his balance in the bank is more than his monthly installment.
                if (search.getBalance() >= search.getLo().getMonthlyPaymentSize()
                        && search.getLo().getRemaining() > search.getLo().getMonthlyPaymentSize()) {
                    search.getLo().setRemaining(search.getLo().getRemaining() - search.getLo().getMonthlyPaymentSize());
                    search.setBalance(search.getBalance() - search.getLo().getMonthlyPaymentSize());
                    System.out.println("");
                    System.out.println(search.getLo());
                } else if (search.getBalance() >= search.getLo().getRemaining()
                        && search.getLo().getRemaining() <= search.getLo().getMonthlyPaymentSize()) {
                    search.setBalance(search.getBalance() - search.getLo().getRemaining());
                    search.getLo().setRemaining(0);

                    //If statment for to make sure the loan has finished.
                    if (search.getLo().getRemaining() == 0) {
                        search.setLo(null);
                        System.out.println("Congratulation the Loan is Cleared");
                    } else {
                        System.out.println(search.getLo());
                    }
                } else {
                    System.out.println("No Money");
                }
            } else {
                System.out.println("No Loan");
            }
        } else {
            System.out.println("Not found this account! ");
        }
    }

    public static void main(String[] arg) {
       
        Account ccc1 = new Account(101300, 055547, "Abdo", "ALshwqya", "beso@gmail.com");
        accID++;
        ccc1.setAccountID(accID);
        acc.add(ccc1);

        //Do While Loop for the option page ane switch statment.
        do {
            System.out.println("");
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
            System.out.println("Student : Abdulaziz Almalki , 442010123");

            Account acc1 = null;

            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
            System.out.println("");
            System.out.println("1) Create a new customer account.");
            System.out.println("2) Deposite an amount on an existing account.");
            System.out.println("3) Withdraw an amount from an existing account.");
            System.out.println("4) Check an existing account.");
            System.out.println("5) Get a new loan on for an existing account.");
            System.out.println("6) Check a new loan on for an existing account.");
            System.out.println("7) Pay for a loan for an existing loan.");
            System.out.println("8) Exist.");

            System.out.println("Please choose a choice between 1 and 8 ");
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
            System.out.println("");
            System.out.print("Enter the Option number: ");
            int Option = in.nextInt();

            //Switch Statment
            switch (Option) {

                case 1:

                    Call1();
                    break;

                case 2:
                    Call2();
                    break;
                case 3:
                    Call3();

                    break;
                case 4:
                    Call4();
                    break;

                case 5:
                    Call5();
                    break;
                case 6:
                    Call6();
                    break;
                case 7:
                    Call7();
                    break;
                case 8: {
                    System.out.println("Exit");
                    System.exit(0);
                    System.out.println("Thank you for using us! ");
                    break;
                }

                default:
                    System.out.println("Not found the Option." + "\n" + "Please choose again. ");
            }
        } while (true);
    }
}
