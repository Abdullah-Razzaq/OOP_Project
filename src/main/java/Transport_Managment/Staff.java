package Transport_Managment;

class Staff<T> extends Employee{
    private T staffDepartment;

    public Staff(String name, String id, boolean isFaculty, String route, int payment, Status payment_Status, T staffDepartment) {
        super(name, id, isFaculty, route, payment, payment_Status);
        this.staffDepartment = staffDepartment;
    }

    public Staff() {

    }

    public T getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(T staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                "Staff Department: " + staffDepartment;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" | Staff Department: %s", staffDepartment);
    }

}
