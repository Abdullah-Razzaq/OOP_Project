package Transport_Managment;

public class Bus {

    private int Bus = 9;
    private int Coaster = 3;
    private Routes r;

    public int getBus() {
        return Bus;
    }

    public void setBus(int bus) {
        Bus = bus;
    }

    public int getCoaster() {
        return Coaster;
    }

    public void setCoaster(int coaster) {
        Coaster = coaster;
    }

    public Routes getR() {
        return r;
    }

    public void setR(Routes r) {
        this.r = r;
    }

    public String Bus_Required_for_Route(int Route_no){
        int passengers;
        passengers = r.Number_of_Passengers(String.format("Route%d", Route_no-1));
        return passengers<=65 && passengers>=40?"Bus":"Coaster";
    }
}
