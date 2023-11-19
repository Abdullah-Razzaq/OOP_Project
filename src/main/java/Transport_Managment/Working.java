package Transport_Managment;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Working{
    Scanner input = new Scanner(System.in);
    int choice, choice1, payment;
    String name, id, program,route;
    boolean hostelite, scholarship;
    Status paymentStatus
    Management m;

    {


        System.out.println("""
                        Select an option:
                        1: Student  
                        2: Faculty
                        3: Staff
                        4: Routes details       
                        5: Bus details 
                        6: Total Payment Collected
                        7: Exit      
                """);

        choice = input.nextInt();

        switch (choice)
        {
            case 1:{
                System.out.println("""
                        1: Add student
                        2: Remove student
                        3: Update student
                        """);
                choice1 = input.nextInt();
                if (choice1 == 1)
                {
                    Input();
                 m.Add_Student(new Students(name,id,program,route,hostelite,scholarship,payment,paymentStatus));
                } else if (choice1 == 2) {
                    System.out.print("Enter ID or Registration: ");
                    id = input.nextLine();
                    m.Remove(id);
                }
                else if(choice1 == 3){
                    System.out.print("Enter previous ID or Registration: ");
                    id = input.nextLine();
                    System.out.println("Enter updated student details:");
                    Input();
                    m.Update(id, new Object());
                }
                break;
            }
            case 2:{
                System.out.println("""
                        1: Add faculty
                        2: Remove faculty
                        3: Update faculty
                        """);
                choice1 = input.nextInt();
            }
            case 3:{
                System.out.println("""
                        1: Add staff
                        2: Remove staff
                        3: Update staff
                        """);
                choice1 = input.nextInt();
            }

        }
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

    void Input(){
        System.out.print("Name: ");
        name = input.nextLine();

        System.out.print("ID or Registration: ");
         id = input.nextLine();

        System.out.print("Program : ");
         program = input.nextLine();

        System.out.print("Hostelite (true for yes, false for no) : ");
         hostelite = input.nextBoolean();

        System.out.print("scholarship (true for yes, false for no) : ");
         scholarship = input.nextBoolean();

         Input_2();

    }
    void Input_2(){
        System.out.print("Route: ");
        route = input.nextLine();

        System.out.print("Payment: ");
         payment = input.nextInt();
        input.nextLine();

        System.out.print("Payment Status (Paid, Unpaid): ");
        String paymentStatusString = input.nextLine();
        Status paymentStatus = Status.valueOf(paymentStatusString.toUpperCase());

    }
}