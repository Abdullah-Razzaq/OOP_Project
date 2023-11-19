package withgenerics;

class Staff<T> extends Employee{
    private T staffDepartment;

    public Staff(String name, String id, boolean isFaculty, String route, int payment, Status payment_Status, T staffDepartment) {
        super(name, id, isFaculty, route, payment, payment_Status);
        this.staffDepartment = staffDepartment;
    }

    public Staff(String staff) {

    }

    public T getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(T staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Staff Department: " + staffDepartment);
    }
}
