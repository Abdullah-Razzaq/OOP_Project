package Transport_Managment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    static File file = new File("Raw Routes data");
    static File file2 = new File("Raw data");
    static FileWriter fw;
    static BufferedWriter bw;
    static FileWriter fw2;
    static BufferedWriter bw2;

    static Routes re = new Routes();
    static Bus b = new Bus();
    static ArrayList<Object> l = new ArrayList<>();

    public static void Write_File() throws IOException {
        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
        }
        catch (IOException e){

        }
        finally {
            for (int i = 0; i < Routes.info.size(); i++) {
                for (int j = 0; j < Routes.info.get(i).size(); j++) {

                    bw.write(String.valueOf(Routes.info.get(i).get(j)));
                    bw.write("\t");
                }

                bw.write("\n");
            }
        }
        bw.close();
        fw.close();

        fw2 = new FileWriter(file2);
        bw2 = new BufferedWriter(fw2);

        bw2.write(String.valueOf(b.getBus() + ","));
        bw2.write("\t");
        bw2.write(String.valueOf(b.getCoaster() + ","));
        bw2.write("\t");
        bw2.write(String.valueOf(re.getN() + ","));

        bw2.close();
        fw2.close();

    }



    public static void Read_file() throws IOException {

        Scanner sc2 = new Scanner(file2);
        while(sc2.hasNext()){
            String s1 = sc2.next();
            String s1_1 = s1.replaceAll(",$", "");
            int t1 = Integer.parseInt(s1_1);
            String s2 = sc2.next();
            String s2_1 = s2.replaceAll(",$", "");
            int t2 = Integer.parseInt(s2_1);
            String s3 = sc2.next();
            String s3_1 = s3.replaceAll(",$", "");
            int t3 = Integer.parseInt(s3_1);
            b.setBus(t1);
            b.setCoaster(t2);
            re.setN(t3);
        }

        if (b.getBus() == 0){b.setBus(10);}
        if(b.getCoaster() == 0){b.setCoaster(10);}

        re.Array_Initialization();
        Scanner sc = new Scanner(file);
        String h = "Student:";
        String h1 = "Faculty:";
        String h2 = "Staff:";

        while(sc.hasNext()) {
            String w = sc.next();
            if (w.contains(h)) {
                Student_add(sc);
                l.clear();
            }
            if (w.contains(h1)) {
                Faculty_a(sc);
                l.clear();
            }
            if(w.contains(h2)){
                Staff_a(sc);
                l.clear();
            }
        }

    }

    public static void Student_add(Scanner sc){
        for (int i = 1; i < 9; i++) {
            if (i == 1 || i <= 4) {
                String neet1 = sc.next();
                String neet = neet1.replaceAll(",$", "");
                l.add(neet);
            } else if (i == 5 || i == 6) {
                String a = sc.next();
                if(a.equalsIgnoreCase("true")){
                    l.add(true);}else{l.add(false);}
            } else if (i == 7) {
                String b = sc.next();
                String b1 = b.replaceAll(",$", "");
                int b2 = Integer.parseInt(b1);
                l.add(b2);

            } else if (i == 8) {
                String soup = sc.next();
                String soup1 = soup.replaceAll(",$", "");
                if (soup1.equalsIgnoreCase("paid"))
                {l.add(Status.PAID);}
                else{l.add(Status.Unpaid);}

            }}
        Management.Add_Student(new Students((String) l.get(0), (String) l.get(1), (String) l.get(2), (String) l.get(3), (Boolean) l.get(4), (Boolean) l.get(5),(int)l.get(6),(Status) l.get(7)));
    }

    public static void Faculty_a(Scanner sc){
        for (int i = 1; i < 8; i++) {
            if (i == 1 || i == 2 || i == 4 || i == 7) {
                String meet1 = sc.next();
                String meet = meet1.replaceAll(",$", "");
                l.add(meet);
            } else if (i == 3) {
                String a = sc.next();
                if(a.equalsIgnoreCase("true")){
                    l.add(true);}else{l.add(false);}
            } else if (i == 5) {
                String b = sc.next();
                String b1 = b.replaceAll(",$", "");
                int b2 = Integer.parseInt(b1);
                l.add(b2);

            } else if (i == 6) {
                String soup = sc.next();
                String soup1 = soup.replaceAll(",$", "");
                if (soup1.equalsIgnoreCase("paid"))
                {l.add(Status.PAID);}
                else{l.add(Status.Unpaid);}

            }}
        Management.Add_Faculty(new Faculty((String) l.get(0), (String) l.get(1), (boolean) l.get(2), (String) l.get(3), (int) l.get(4), (Status) l.get(5),(String)l.get(6)));
    }

    public static void Staff_a(Scanner sc){
        for (int i = 1; i < 8; i++) {
            if (i == 1 || i == 2 || i == 4 || i == 7) {
                String meet1 = sc.next();
                String meet = meet1.replaceAll(",$", "");
                l.add(meet);
            } else if (i == 3) {
                String a = sc.next();
                String seat = a.replaceAll(",$", "");
                if(seat.equalsIgnoreCase("true")){
                    l.add(true);}else{l.add(false);}
            } else if (i == 5) {
                String b = sc.next();
                String b1 = b.replaceAll(",$", "");
                int b2 = Integer.parseInt(b1);
                l.add(b2);

            } else if (i == 6) {
                String soup = sc.next();
                String soup1 = soup.replaceAll(",$", "");
                if (soup1.equalsIgnoreCase("paid"))
                {l.add(Status.PAID);}
                else{l.add(Status.Unpaid);}

            }}
        Management.Add_Staff(new Staff((String) l.get(0), (String) l.get(1), (boolean) l.get(2), (String) l.get(3), (int) l.get(4), (Status) l.get(5),(String)l.get(6)));
    }

}
