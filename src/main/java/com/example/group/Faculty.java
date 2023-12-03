package com.example.group;

class Faculty<T> extends Employee {
    private T facultySpecialization;

    public Faculty(String name, String id, boolean isFaculty, String route, int payment, Status payment_Status, T facultySpecialization) {
        super(name, id, isFaculty, route, payment, payment_Status);
        this.facultySpecialization = facultySpecialization;
    }

    public Faculty() {

    }

    public T getFacultySpecialization() {
        return facultySpecialization;
    }

    public void setFacultySpecialization(T facultySpecialization) {
        this.facultySpecialization = facultySpecialization;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                "Faculty Specialization: " + facultySpecialization;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" | Faculty Specialization: %s", facultySpecialization);
    }
}
