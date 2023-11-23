package Transport_Managment;

public class Management {

    Routes r;
    static int Total_Payment;

    public void Add_Student(Students student){

        for (int i = 0; i < r.routes.size(); i++) {

            if(student.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + student.getPayment();
                r.routes.get(i).add(student);
            }}
    }

    public void Add_Faculty(Faculty faculty){

        for (int i = 0; i < r.routes.size(); i++) {

            if(faculty.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + faculty.getPayment();
                r.routes.get(i).add(faculty);
            }}
    }

    public void Add_Staff(Staff staff){

        for (int i = 0; i < r.routes.size(); i++) {

            if(staff.getRoute().equalsIgnoreCase(String.format("Route%d", i+1))){
                Total_Payment = Total_Payment + staff.getPayment();
                r.routes.get(i).add(staff);
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
        System.out.println("Successfully removed");
    }

    public void Update(String Id_or_Registration, Object o){

        for (int i = 0; i < r.routes.size(); i++) {
            for (int j = 0; j < r.routes.get(i).size(); j++) {
                if(r.routes.get(i).get(j).equals(Id_or_Registration)){
                    r.routes.get(i).set(j,o);
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
