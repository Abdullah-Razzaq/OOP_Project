package Transport_Managment;

public class Main {
    public static void main(String[] args) {
        Students s = new Students("ewKf","SP23-BCS-021","ewf",Degree.Graduate,2,"route1",true,true,35000,Status.Paid);
        System.out.println(s);
        System.out.println(s.equals("SP23-BCS-021"));

        Routes r = new Routes();
        r.Add_Person(new Students("ewKf","SP23-BCS-021","ewf",Degree.Graduate,2,"route2",true,true,35000,Status.Paid));

        Bus b = new Bus();






    }
}
