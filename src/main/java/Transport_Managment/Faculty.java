package Transport_Managment;

class Faculty<T> extends Employee {
    private T facultySpecialization;

    public Faculty(String name, String id, boolean isFaculty, String route, int payment, Status payment_Status, T facultySpecialization) {
        super(name, id, isFaculty, route, payment, payment_Status);
        this.facultySpecialization = facultySpecialization;
    }

    public Faculty(String faculty) {

    }

    public T getFacultySpecialization() {
        return facultySpecialization;
    }

    public void setFacultySpecialization(T facultySpecialization) {
        this.facultySpecialization = facultySpecialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Faculty Specialization: " + facultySpecialization);
    }
}
