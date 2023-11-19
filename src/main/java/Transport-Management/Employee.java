package withgenerics;

public class Employee<T> {
    private String name;
    private int id;
    private boolean isFaculty;
    private T employeeInfo;


    public Employee(String name, int id,boolean isFaculty, T employeeInfo) {
        this.name = name;
        this.id = id;
        this.employeeInfo = employeeInfo;
        this.isFaculty = isFaculty;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(T employeeInfo) {
        this.employeeInfo = employeeInfo;
    }


    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Employee Type: " + (isFaculty ? "Faculty" : "Staff"));

    }
}
