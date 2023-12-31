package com.example.group;

public class Bus {

    private static int Bus;
    private static int Coaster;
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


    public void add_vehicles(int bus, int coaster){
        setBus(bus);
        setCoaster(coaster);
    }
    public String Vehicle_Required_for_Route(int Route_no){
        int passengers;
        passengers = r.Number_of_Passengers(Route_no);

        if(passengers == 0){return ". No vehicle is requires as \n\n. No Passenger uses this route";}
        if(Coaster == 0 && Bus == 0){return ". Neither the Coasters \n\n. Nor the Busses are Available";}

        if(passengers <= 40){
            if (Coaster == 0){
                Bus = Bus - 1;
                return ". Coasters are not available \n\n. Busses required: 01";
            }
            else {
                Coaster = Coaster - 1;
                return ". Busses Required: 00 \n\n. Coasters required: 01";
            }}

        else if (passengers<=65 && passengers>=40)
        {  if(Bus == 0){
            if (passengers >= 65 && passengers <= 80){
                Coaster = Coaster - 2;
                return String.format(". Busses are not available \n\n. Coasters required: 02");}
        }
        else {
            Bus = Bus - 1;
            return ". Busses Required: 01 \n\n. Coaster Required: 00";}}

        else if (passengers > 65)
        {
            if (passengers > 65 && passengers <= 105)
            {
                if (Bus == 0 && passengers > 80){
                    return ". Busses are not available \n\n. Coasters required: 03 \n\n. It would be very costly. \n\n. Try arranging some in other routes or add busses";
                }
                if (Bus == 0 && passengers <= 80){
                    Coaster = Coaster - 2;
                    return ". Busses are not available. \n\n. Coasters required: 02";}
                if (Coaster == 0){
                    Bus = Bus - 2;
                    return ". Coasters are not available. \n\n. Busses required: 02";}
                else{
                    Bus = Bus - 1;
                    Coaster = Coaster - 1;
                    return ". Busses Required: 01 \n\n. Coasters Required: 01";}}

            else if (passengers > 105 && passengers <=130 ) {
                if(Bus == 0){return ". Busses are not available.\n\n. Coasters Required: 04.\n\n. It is very Costly.\n\n. Try adjusting in other routes or add busses.";}
                else {Bus = Bus - 2;
                    return ". Busses required: 02 \n\n. Coasters required: 00";
                }}
        }
        return ". Route has more passengers than \n\n. multiple Busses and Coaster can handle";
    }

    public String No_of_Vehicles_Left(){
        return String.format(". Busses Left : %02d \n\n. Coaster Left : %02d", Bus, Coaster);
    }
}
