package Transport_Managment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String file = "employee_data.txt";

    public static void writeFile(Object o) {
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(o.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        Routes.routes.clear();
        for (String routeLine : lines) {
            ArrayList<Object> routeData = new ArrayList<>();
            routeData.add(routeLine);
            Routes.routes.add(routeData);
        }
        return lines;
    }


}
