package Transport_Managment;

import java.util.ArrayList;

public class Routes {

    static ArrayList<ArrayList<Object>> routes = new ArrayList<ArrayList<Object>>(12);

    Students students;

  {
       for (int i = 1; i < 13; i++) {
           routes.add(new ArrayList<Object>());
           routes.get(i-1).add(0,String.format("Route%d", i));
       }
    }

    public void Add_New_Route() {
        routes.add(new ArrayList<Object>());
        routes.get((routes.size()+1)).add(String.format("Route%d", (routes.size()+1)));
    }

    public void Add_Student(Students student){

        for (int i = 0; i < routes.size(); i++) {

      if(student.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
          routes.get(i).add(student);
      }}
    }
//    public void Add_Faculty(Faculty faculty){
//
//        for (int i = 0; i < routes.size(); i++) {
//
//            if(faculty.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
//                routes.get(i).add(faculty);
//            }}
//    }

//    public void Add_Staff(Staff staff){
//
//        for (int i = 0; i < routes.size(); i++) {
//
//            if(staff.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
//                routes.get(i).add(staff);
//            }}
//    }


    public int Number_of_Passengers(String route){
        for (int i = 0; i < routes.size(); i++) {
            if(route.equalsIgnoreCase((String) routes.get(i).get(0))) {
                return routes.get(i).size();
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
