package Transport_Managment;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String file = "employee_data.txt";


    public static void writeEmployee(Employee employee) {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(employee.toString());
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> readEmployees() {
        ArrayList<Employee> employeesList = new ArrayList<>();

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                int category = Integer.parseInt(data[0]);
                Employee employee;
                if (category == 1) {
                    employee = new Faculty<>(data[1], data[2], Boolean.parseBoolean(data[3]),
                            data[4], Integer.parseInt(data[5]), Status.valueOf(data[6]), data[7]);
                } else {
                    employee = new Staff<>(data[1], data[2], Boolean.parseBoolean(data[3]),
                            data[4], Integer.parseInt(data[5]), Status.valueOf(data[6]), data[7]);
                }
                employeesList.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeesList;
    }

    public static void writeStudent(Students student) {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(student.toString());
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> readStudents() {
        ArrayList<Students> studentsList = new ArrayList<>();

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Students student = new Students(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4],
                        Boolean.parseBoolean(data[5]), Boolean.parseBoolean(data[6]),
                        Integer.parseInt(data[7]), Status.valueOf(data[8]));
                studentsList.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentsList;
    }

}
