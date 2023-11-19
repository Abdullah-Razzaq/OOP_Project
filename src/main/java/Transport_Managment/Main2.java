package withgenerics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter employee details:");
        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Type 1 for Faculty or 2 for Staff : ");
        int category = input.nextInt();
        input.nextLine();

        if (category == 1) {
            System.out.print("Faculty Specialization: ");
            String facultySpecialization = input.nextLine();
            Faculty<String> facultyInfo = new Faculty<>(name, id, true, null, facultySpecialization);
            System.out.println("\nEmployee Information:");
            facultyInfo.displayInfo();


        } else {
            System.out.print("Staff Department: ");
            String staffDepartment = input.nextLine();
            Staff<String> staffInfo = new Staff<>(name, id, false, null, staffDepartment);
            System.out.println("\nEmployee Information:");
            staffInfo.displayInfo();
        }

        input.close();
    }
}