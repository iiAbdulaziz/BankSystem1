public class Customer {

    private double nationalID;
    private int PhoneNumber;
    private String name;
    private String address;
    private String email;

    public Customer() {
    }

    public Customer(double natID, int PN, String n, String ad, String em) {
        nationalID = natID;
        PhoneNumber = PN;
        name = n;
        address = ad;
        email = em;
    }

    //Setter
    public void setnationalID(double nationalID) {
        this.nationalID = nationalID;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setemail(String email) {
        this.email = email;
    }

    //getter 
    public double getnationalID() {
        return nationalID;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public String getname() {
        return name;
    }

    public String getaddress() {
        return address;
    }

    public String getemail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer Class: "
                + "\n" + " Name = " + name
                + "\n" + " NationalID = " + nationalID
                + "\n" + " PhoneNumber = " + PhoneNumber
                + "\n" + " Address = " + address
                + "\n" + " Email = " + email;
    }

    public String toStringCustomer() {
        return "Customer information: "
                + "\n" + " Name = " + name
                + "\n" + " NationalID = " + nationalID
                + "\n" + " PhoneNumber = " + PhoneNumber
                + "\n" + " Address = " + address
                + "\n" + " Email = " + email;
    }
}
