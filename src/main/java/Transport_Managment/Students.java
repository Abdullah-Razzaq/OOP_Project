package Transport_Managment;

public class Students {

    private String name;
    private String Reg_no;
    private String Program;
    private boolean hostelite;
    private boolean scholarship;
    private String route;
    private int Payment;
    private Status Payment_Status;

    public Students(){

    }
    public Students(String name, String reg_no, String program,String route, boolean hostelite, boolean scholarship, int payment, Status payment_Status) {
        this.name = name;
        Reg_no = reg_no;
        Program = program;
        this.route = route;
        this.hostelite = hostelite;
        this.scholarship = scholarship;
        Payment = payment;
        Payment_Status = payment_Status;
    }

    public boolean isHostelite() {
        return hostelite;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg_no() {
        return Reg_no;
    }

    public void setReg_no(String reg_no) {
        Reg_no = reg_no;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public boolean getHostelite() {
        return hostelite;
    }

    public void setHostelite(boolean hostelite) {
        this.hostelite = hostelite;
    }

    public boolean getScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public Status getPayment_Status() {
        return Payment_Status;
    }

    public void setPayment_Status(Status payment_Status) {
        Payment_Status = payment_Status;
    }


    @Override
    public String toString() {
        return "Students_info: " +
                "name= \"" + name + '\"' +
                ", Reg_no= \"" + Reg_no + '\"' +
                ", Program= \"" + Program + '\"' +
                ", hostelite= " + hostelite +
                ", scholarship= " + scholarship +
                ", route= \"" + route + '\"' +
                ", Payment= Rs" + Payment +
                ", Payment_Status= " + Payment_Status;
    }

    @Override
    public boolean equals(Object obj) {
        String s = (String) obj;
        return s.toLowerCase().equals(Reg_no.toLowerCase())?true:false;
    }
}
