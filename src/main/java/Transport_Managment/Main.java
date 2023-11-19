package Transport_Managment;

public class Main {
    public static void main(String[] args) {
        Students s = new Students("ewKf","SP23-BCS-021","ewf","route1",true,true,35000,Status.Paid);
        System.out.println(s);
        System.out.println(s.equals("SP23-BCS-021"));

        Routes r = new Routes();
        Management m =new Management();
        m.Add_Student(new Students("ewKf","SP23-BCS-021","ewf","route2",true,true,35000,Status.Paid));

        Bus b = new Bus();
        m.Add_Faculty(new Faculty<String>("da","2wd",true,"Route5",7400,Status.Paid,"Bscs"));
        m.Add_Faculty(new Faculty<String>("da","2wd",true,"Route2",7400,Status.Paid,"Bscs"));
        m.Add_Staff(new Staff("da","2wd",false,"Route12",7400,Status.Paid,"Bscs"));
        m.Update("sp23-bcs-021",new Students("Afgfh","SP23-BCS-021","ewf","route2",true,true,35000,Status.Paid));
        System.out.println(r);

        System.out.println(r.Number_of_Passengers(2));
        System.out.println(b.Vehicle_Required_for_Route(1));
        System.out.println(m.Total_Payment_Recieved());





    }
}
