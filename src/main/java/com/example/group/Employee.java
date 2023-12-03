package com.example.group;

public class Employee {
    private String name;
    private String id;
    private boolean isFaculty;
    private String route;
    private int Payment;
    private Status Payment_Status;


    public Employee(String name, String id, boolean isFaculty, String route, int payment, Status payment_Status) {
        this.name = name;
        this.id = id;
        this.isFaculty = isFaculty;
        this.route = route;
        Payment = payment;
        Payment_Status = payment_Status;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public String displayInfo() {

        return"Employee Type: " + (isFaculty ? "Faculty" : "Staff") + "\n" +
                "Name: " + name + "\n" +
                "ID: " + id + "\n"+
                "Employee Route: " + route + "\n" +
                "Employee payment: " + Payment + "\n" +
                "Payment Status: " +Payment_Status + "\n";
    }
    @Override
    public String toString() {
        return String.format("Name: %s | ID: %s | Route: %s | Payment: %d | Payment Status: %s",
                name, id, route, Payment, Payment_Status);
    }
}
