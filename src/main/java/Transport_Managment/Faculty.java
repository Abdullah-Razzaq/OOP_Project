package withgenerics;

class Faculty<T> extends Employee<T> {
    private String facultySpecialization;

    public Faculty(String name, int id, boolean isFaculty, T employeeInfo, String facultySpecialization) {
        super(name, id, isFaculty, employeeInfo);
        this.facultySpecialization = facultySpecialization;
    }

    public Faculty(String faculty) {

    }

    public String getFacultySpecialization() {
        return facultySpecialization;
    }

    public void setFacultySpecialization(String facultySpecialization) {
        this.facultySpecialization = facultySpecialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Faculty Specialization: " + facultySpecialization);
    }
}
