package Transport_Managment;

import java.util.ArrayList;

public class Routes {

   static ArrayList<ArrayList<Object>> routes = new ArrayList<ArrayList<Object>>();

    Students students;

  {
       for (int i = 1; i < 13; i++) {
           routes.add(new ArrayList<Object>());
           routes.get(i-1).add(0,String.format("Route%d", i));
       }
    }

    public void Add_New_Route() {
        routes.add(new ArrayList<Object>());
        routes.get((routes.size()-1)).add(String.format("Route%d", (routes.size())));
    }


    public static int Number_of_Passengers(int Route_no){

      String route = String.format("Route%d", Route_no);
        for (int i = 0; i < routes.size(); i++) {
            if(route.equalsIgnoreCase((String) routes.get(i).get(0))) {
                return routes.get(i).size()-1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
      StringBuilder str = new StringBuilder();
        for (int i = 0; i < routes.size(); i++) {
            for (int j = 0; j < routes.get(i).size(); j++) {
                str.append(routes.get(i).get(j));
                if(j==0){str.append(":");}
                str.append("\n");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
