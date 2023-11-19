package Transport_Managment;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Working{
    Scanner input = new Scanner(System.in);
    int choice, choice1, payment;
    String name, id, program,route, facultySpecialization, staffDepartment;
    boolean hostelite, scholarship;
    Status paymentStatus;

    Bus b;

    Routes r;
    Management m;

    public Working(){

        while (choice != 7) {
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

            switch (choice) {
                case 1: {
                    System.out.println("""
                            1: Add student
                            2: Remove student
                            3: Update student
                            """);
                    choice1 = input.nextInt();
                    if (choice1 == 1) {
                        name = input.nextLine();
                        Input();
                        m.Add_Student(new Students(name, id, program, route, hostelite, scholarship, payment, paymentStatus));
                    } else if (choice1 == 2) {
                        System.out.print("Enter ID or Registration: ");
                        id = input.nextLine();
                        m.Remove(id);
                    } else if (choice1 == 3) {
                        System.out.print("Enter previous ID or Registration: ");
                        id = input.nextLine();
                        System.out.println("Enter updated student details:");
                        Input();
                        m.Update(id, new Students(name, id, program, route, hostelite, scholarship, payment, paymentStatus));
                    }
                    break;
                }
                case 2: {
                    System.out.println("""
                            1: Add faculty
                            2: Remove faculty
                            3: Update faculty
                            """);
                    choice1 = input.nextInt();
                    if (choice1 == 1) {
                        Input3();
                        faculty();
                        m.Add_Faculty(new Faculty<>(name, id, true, route, payment, paymentStatus, facultySpecialization));
                    } else if (choice1 == 2) {
                        System.out.print("Enter ID or Registration: ");
                        id = input.nextLine();
                        m.Remove(id);
                    } else if (choice1 == 3) {
                        System.out.print("Enter previous ID or Registration: ");
                        id = input.nextLine();
                        System.out.println("Enter updated faculty details:");
                        Input3();
                        faculty();
                        m.Update(id, new Faculty<>(name, id, true, route, payment, paymentStatus, facultySpecialization));
                    }
                    break;
                }
                case 3: {
                    System.out.println("""
                            1: Add staff
                            2: Remove staff
                            3: Update staff
                            """);
                    choice1 = input.nextInt();
                    if (choice1 == 1) {
                        Input3();
                        staff();
                        m.Add_Staff(new Staff<>(name, id, true, route, payment, paymentStatus, staffDepartment));
                    } else if (choice1 == 2) {
                        System.out.print("Enter ID or Registration: ");
                        id = input.nextLine();
                        m.Remove(id);
                    } else if (choice1 == 3) {
                        System.out.print("Enter previous ID or Registration: ");
                        id = input.nextLine();
                        System.out.println("Enter updated faculty details:");
                        Input3();
                        staff();
                        m.Update(id, new Staff<>(name, id, true, route, payment, paymentStatus, staffDepartment));
                    }
                    break;
                }

                case 4: {
                    System.out.println("""
                            1: Add new Route
                            2: Route passengers quantity
                            3: All Routes detail
                            """);
                    choice1 = input.nextInt();
                    if (choice1 == 1) {
                        r.Add_New_Route();
                    } else if (choice == 2) {
                        System.out.println("Enter route no:");
                        int Route_no = input.nextInt();
                        Routes.Number_of_Passengers(Route_no);
                    } else if (choice == 3) {
                        System.out.println(r);
                    }
                    break;
                }
                case 5: {
                    System.out.println("""
                            1: Vehicles Required for route
                            2: Number of Vehicles left""");
                    choice1 = input.nextInt();
                    if (choice1 == 1) {
                        System.out.println("Enter route number:");
                        int route = input.nextInt();
                        System.out.println(b.Vehicle_Required_for_Route(route));
                    } else if (choice1 == 2) {
                        b.No_of_Vehicles_Left();
                    }
                    break;
                }
                case 6: {
                    System.out.println("Total payment received up till now: " + m.Total_Payment_Recieved());
                    break;
                }
                case 7: {
                    System.out.println("Successfully Exited");
                    break;
                }
                default: {
                    System.out.println("Wrong choice entered!");
                }
            }


        }
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

    void Input3(){
        System.out.print("Name: ");
        name = input.nextLine();

        System.out.print("ID or Registration: ");
        id = input.nextLine();

        Input_2();

    }

    void faculty(){

        System.out.print("Faculty Specialization: ");
        facultySpecialization = input.nextLine();
    }
    void staff(){

        System.out.print("Staff Department: ");
        staffDepartment = input.nextLine();
    }
}


