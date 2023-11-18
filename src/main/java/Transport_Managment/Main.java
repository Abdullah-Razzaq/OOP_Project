package Transport_Managment;

public class Main {
    public static void main(String[] args) {
        Students s = new Students("ewKf","SP23-BCS-021","ewf",Degree.Graduate,2,true,true,35000,Status.Paid);
        System.out.println(s);
        System.out.println(s.equals("SP23-BCS-021"));



    }
}
