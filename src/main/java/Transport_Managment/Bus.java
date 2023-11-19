package Transport_Managment;

public class Bus {

    private int Bus = 10;
    private int Coaster = 10;
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


    public String Vehicle_Required_for_Route(int Route_no){
        int passengers;
        passengers = r.Number_of_Passengers(Route_no);
        if(Bus == 0){ return "Busses are not available";}
        if(Coaster == 0){ return "Coasters are not available";}
        if(passengers == 0){return "No vehicle is requires as no Passenger uses this route";}
        if (passengers<=65 && passengers>=40)
        {   Bus = Bus - 1;
            return "Bus";}
        else if (passengers > 65 )
        {
            if (passengers > 65 && passengers <= 105)
            {  Bus = Bus - 1;
                Coaster = Coaster - 1;
             return "1 Bus and 1 Coaster";}

            else if (passengers > 105 && passengers <=130 ) {
            Bus = Bus - 2;
                return "2 Busses";
            }
        }
        Coaster = Coaster - 1;
            return "Coaster";
    }

    public String No_of_Vehicles_Left(){
        return String.format("Busses: %d , Coaster: %d", Bus, Coaster);
    }
}
