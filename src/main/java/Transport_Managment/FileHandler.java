package Transport_Managment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    static File file = new File("Routes information");
    static FileWriter fw;
    static BufferedWriter bw;

    static Routes re = new Routes();

    public static void Write_File() throws IOException {
        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
        }
        catch (IOException e){

        }
        finally {
            for (int i = 0; i < Routes.routes.size(); i++) {
                for (int j = 0; j < Routes.routes.get(i).size(); j++) {
                    if(Routes.routes.get(i).size() == 1)
                    {
                        bw.write(String.valueOf(Routes.routes.get(i).get(j)));
                        bw.write("\n");
                        bw.write("none");
                        bw.write("\n");
                    }

                    else{
                        if(Routes.routes.get(i).contains("Route1")){
                            bw.write(String.valueOf(Routes.routes.get(i).get(j)));
                        }
                        bw.write(String.valueOf(Routes.routes.get(i).get(j)));
                    bw.write("\n");
                    }


                }
            }
        }

        bw.close();
        fw.close();
    }

    public static void Read_file() throws IOException {
             Scanner sc = new Scanner(file);
             int k = 0, p = 2;
             String s = String.format("Route%d", p);
            ArrayList<String> l = new ArrayList<>();
            if(!(sc.hasNextLine())){
                re.Array_Initialization();
            }
            else {
            while(sc.hasNextLine()) {
              l.add(sc.nextLine());}
            re.Array_Initialization_1();
                        for (int j = 0; j < l.size(); j++){
                            if(l.get(j).equals(s)){
                                p++;
                                k++;
                                s = String.format("Route%d", p);
                                Routes.routes.get(k).add(l.get(j));
                            }  else {
                            Routes.routes.get(k).add(l.get(j));}
            }
                for (int i = 0; i < Routes.routes.size(); i++) {
                    if( Routes.routes.size() > 3){
                        for (int j = 0; j < Routes.routes.get(i).size(); j++) {
                            if(Routes.routes.get(i).get(j).equals("none")){
                                Routes.routes.get(i).remove(j);
                            }
                        }
                    }
                }
            }


     }


}
