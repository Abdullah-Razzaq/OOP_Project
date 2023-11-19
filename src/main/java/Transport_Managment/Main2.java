package Transport_Managment;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter employee details:");

        System.out.print("Type 1 for Faculty or 2 for Staff : ");
        int category = input.nextInt();
        input.nextLine();

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("ID: ");
        String id = input.nextLine();

        System.out.print("Route: ");
        String route = input.nextLine();

        System.out.print("Payment: ");
        int payment = input.nextInt();
        input.nextLine();

        System.out.print("Payment Status (Paid, Unpaid): ");
        String paymentStatusString = input.nextLine();
        Status paymentStatus = Status.valueOf(paymentStatusString.toUpperCase());

        if (category == 1) {
            System.out.print("Faculty Specialization: ");
            String facultySpecialization = input.nextLine();
            Faculty<String> facultyInfo = new Faculty<>(name, id, true, route, payment, paymentStatus, facultySpecialization);
            System.out.println("\nEmployee Information:");
            facultyInfo.displayInfo();


        } else {
            System.out.print("Staff Department: ");
            String staffDepartment = input.nextLine();
            Staff<String> staffInfo = new Staff<>(name, id, false, route, payment, paymentStatus,staffDepartment);
            System.out.println("\nEmployee Information:");
            staffInfo.displayInfo();
        }

        input.close();
    }
}