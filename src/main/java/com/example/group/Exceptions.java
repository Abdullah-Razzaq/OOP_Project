package com.example.group;



public class Exceptions {
    Bus bus_class = new Bus();
    Routes route_class = new Routes();
    Management management_class = new Management();

    public String Searchmethod(String id1){

        String data;
        data = management_class.Search_Using_Id(id1);
        return String.format("\n%s", data);
    }



    public String Removemethod(String remo){

        String data1;
        data1 = management_class.Remove(remo);
        if(data1.equalsIgnoreCase("Reg or Id not found")){
            return "\n\n\n\n\n* Reg or Id not found\n\n\n\n\n";
        }
        return String.format("\n\n%s\n\n", data1);
    }

    public String vehicle_required_ex(String r) {
        int r1 = 0, flag = 0;
        try {
            r1 = Integer.parseInt(r);
        } catch (NumberFormatException e1) {
            flag = 1;
            return "* Invalid input, Enter only numbers";
        }
        if (flag == 0) {
            if (r1 >= route_class.getN()) {
                return "* Route doesn't exist!";
            } else {
                return bus_class.Vehicle_Required_for_Route(r1);
            }
        }
        return "0";
    }

    public String vehicle_Add_ex(String s1, String s2){

        int b = 0, c = 0, flag = 0;
        try {
            b = Integer.parseInt(s1);
            c = Integer.parseInt(s2);
        } catch (NumberFormatException e1) {
            flag = 1;
            return "* Invalid input, Enter only numbers";
        }
        if (flag == 0) {
            bus_class.add_vehicles(b,c);
            return ". Successfully entered !";
        }
        return "0";
    }


    public String Pass_quantity_ex(String r) {
        int r1 = 0, flag = 0;
        try {
            r1 = Integer.parseInt(r);
        } catch (NumberFormatException e1) {
            flag = 1;
            return "* Invalid input, Enter only numbers";
        }
        if (flag == 0) {
            if (r1 >= route_class.getN()) {
                return "* Route doesn't exist!";
            } else {
                return String.format("Number of passengers: %02d",  Routes.Number_of_Passengers(r1));
            }
        }
        return "0";
    }
}
