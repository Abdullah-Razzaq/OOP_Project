package withgenerics;

class Staff<T> extends Employee<T>{
    private String staffDepartment;

    public Staff(String name, int id, boolean isFaculty, T employeeInfo, String staffDepartment) {
        super(name, id, isFaculty, employeeInfo);
        this.staffDepartment = staffDepartment;
    }

    public Staff(String staff) {

    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Staff Department: " + staffDepartment);
    }
}