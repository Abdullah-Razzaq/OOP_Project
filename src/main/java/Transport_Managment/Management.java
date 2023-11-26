package Transport_Managment;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Management {

    Routes r;
    static int k = 0;
    static int Total_Payment;

    public static void Add_Student(Students student){

        for (int i = 0; i < Routes.routes.size(); i++) {

            if(student.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + student.getPayment();
                Routes.routes.get(i).add(student);
            }}
        Routes.info.add(new ArrayList<Object>());
        Routes.info.get(k).add("Student:");
        Routes.info.get(k).add(student.getName() + ",");
        Routes.info.get(k).add(student.getReg_no() + ",");
        Routes.info.get(k).add(student.getProgram() + ",");
        Routes.info.get(k).add(student.getRoute() + ",");
        Routes.info.get(k).add(student.getHostelite() + ",");
        Routes.info.get(k).add(student.getScholarship() + ",");
        Routes.info.get(k).add(student.getPayment() + ",");
        Routes.info.get(k).add(student.getPayment_Status() + ",");
        k++;
    }

    public void Add_Student_1(Students s){
        for (int i = 0; i < Routes.routes.size(); i++) {

            if(s.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + s.getPayment();
                Routes.routes.get(i).add(s);
            }}
    }


    public static void  Add_Faculty(Faculty faculty){

        for (int i = 0; i < Routes.routes.size(); i++) {

            if(faculty.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + faculty.getPayment();
                Routes.routes.get(i).add(faculty);
            }}

        Routes.info.add(new ArrayList<Object>());
        Routes.info.get(k).add("Faculty:");
        Routes.info.get(k).add(faculty.getName() + ",");
        Routes.info.get(k).add(faculty.getId() + ",");
        Routes.info.get(k).add(true + ",");
        Routes.info.get(k).add(faculty.getRoute() + ",");
        Routes.info.get(k).add(faculty.getPayment() + ",");
        Routes.info.get(k).add(faculty.getPayment_Status() + ",");
        Routes.info.get(k).add(faculty.getFacultySpecialization() + ",");
        k++;
    }
    public void Add_Faculty_1(Faculty faculty){

        for (int i = 0; i < Routes.routes.size(); i++) {

            if(faculty.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + faculty.getPayment();
                Routes.routes.get(i).add(faculty);
            }}
    }

    public static void Add_Staff(Staff staff){

        for (int i = 0; i < Routes.routes.size(); i++) {

            if(staff.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + staff.getPayment();
                Routes.routes.get(i).add(staff);
            }}

        Routes.info.add(new ArrayList<Object>());
        Routes.info.get(k).add("Staff:");
        Routes.info.get(k).add(staff.getName() + ",");
        Routes.info.get(k).add(staff.getId() + ",");
        Routes.info.get(k).add(false + ",");
        Routes.info.get(k).add(staff.getRoute() + ",");
        Routes.info.get(k).add(staff.getPayment() + ",");
        Routes.info.get(k).add(staff.getPayment_Status() + ",");
        Routes.info.get(k).add(staff.getStaffDepartment() + ",");
        k++;
    }

    public void Add_Staff_1(Staff staff){

        for (int i = 0; i < Routes.routes.size(); i++) {

            if(staff.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + staff.getPayment();
                Routes.routes.get(i).add(staff);
            }}
    }
    public void Remove(String Id_or_Registration){

        for (int i = 0; i < r.routes.size(); i++) {
            for (int j = 0; j < r.routes.get(i).size(); j++) {
                if(r.routes.get(i).get(j).equals(Id_or_Registration)){
                    r.routes.get(i).remove(j);
                }
            }
        }

        for (int i = 0; i < r.info.size(); i++) {
            for (int j = 0; j < r.info.get(i).size(); j++) {
                if(r.info.get(i).get(j).equals(Id_or_Registration + ",")){
                    r.info.get(i).clear();
                }
            }
        }

        System.out.println("Successfully removed");
    }

    public void Update_Student(String Id_or_Registration, Students student){

        for (int i = 0; i < r.routes.size(); i++) {
            for (int j = 0; j < r.routes.get(i).size(); j++) {
                if(r.routes.get(i).get(j).equals(Id_or_Registration)){
                    Students h =(Students) r.routes.get(i).get(j);
                    Total_Payment -= h.getPayment();
                    r.routes.get(i).remove(j);
                    Add_Student_1(student);
                }
            }
        }

        for (int i = 0; i < r.info.size(); i++) {
            for (int j = 0; j < r.info.get(i).size(); j++) {
                String s =(String) r.info.get(i).get(j);
                if(s.equalsIgnoreCase(Id_or_Registration + ",")){
                    r.info.get(i).clear();
                    Routes.info.add(new ArrayList<Object>());
                    r.info.get(k).add("Student:");
                    r.info.get(k).add(student.getName() + ",");
                    r.info.get(k).add(student.getReg_no() + ",");
                    r.info.get(k).add(student.getProgram() + ",");
                    r.info.get(k).add(student.getRoute() + ",");
                    r.info.get(k).add(student.getHostelite() + ",");
                    r.info.get(k).add(student.getScholarship() + ",");
                    r.info.get(k).add(student.getPayment() + ",");
                    r.info.get(k).add(student.getPayment_Status() + ",");
                    k++;
                }
            }
        }
    }

    public void Update_Faculty(String Id_or_Registration, Faculty faculty){

        for (int i = 0; i < r.routes.size(); i++) {
            for (int j = 0; j < r.routes.get(i).size(); j++) {
                if(r.routes.get(i).get(j).equals(Id_or_Registration)){
                    Faculty h1 =(Faculty) r.routes.get(i).get(j);
                    Total_Payment -= h1.getPayment();
                    r.routes.get(i).remove(j);
                    Add_Faculty_1(faculty);
                }
            }
        }

        for (int i = 0; i < r.info.size(); i++) {
            for (int j = 0; j < r.info.get(i).size(); j++) {
                if(r.info.get(i).get(j).equals(Id_or_Registration + ",")){
                    r.info.get(i).clear();
                    Routes.info.add(new ArrayList<Object>());
                    r.info.get(k).add("Faculty:");
                    r.info.get(k).add(faculty.getName() + ",");
                    r.info.get(k).add(faculty.getId() + ",");
                    r.info.get(k).add(true + ",");
                    r.info.get(k).add(faculty.getRoute() + ",");
                    r.info.get(k).add(faculty.getPayment() + ",");
                    r.info.get(k).add(faculty.getPayment_Status() + ",");
                    r.info.get(k).add(faculty.getFacultySpecialization() + ",");
                    k++;
                }
            }
        }
    }

    public void Update_Staff(String Id_or_Registration, Staff staff){

        for (int i = 0; i < r.routes.size(); i++) {
            for (int j = 0; j < r.routes.get(i).size(); j++) {
                if(r.routes.get(i).get(j).equals(Id_or_Registration)){
                    Staff h1 =(Staff) r.routes.get(i).get(j);
                    Total_Payment -= h1.getPayment();
                    r.routes.get(i).remove(j);
                    Add_Staff_1(staff);
                }
            }
        }

        for (int i = 0; i < r.info.size(); i++) {
            for (int j = 0; j < r.info.get(i).size(); j++) {
                if(r.info.get(i).get(j).equals(Id_or_Registration + ",")){
                    r.info.get(i).clear();
                    Routes.info.add(new ArrayList<Object>());
                    r.info.get(k).add("Staff:");
                    r.info.get(k).add(staff.getName() + ",");
                    r.info.get(k).add(staff.getId() + ",");
                    r.info.get(k).add(false + ",");
                    r.info.get(k).add(staff.getRoute() + ",");
                    r.info.get(k).add(staff.getPayment() + ",");
                    r.info.get(k).add(staff.getPayment_Status() + ",");
                    r.info.get(k).add(staff.getStaffDepartment() + ",");
                    k++;
                }
            }
        }
    }


    public void Search_Using_Id(String Id_or_Registration){

        for (int i = 0; i < r.routes.size(); i++) {
            for (int j = 0; j < r.routes.get(i).size(); j++) {
                if(r.routes.get(i).get(j).equals(Id_or_Registration)){
                    r.routes.get(i).get(j);
                }
            }
        }
    }


    public int Total_Payment_Recieved(){
        return Total_Payment;
    }

}
