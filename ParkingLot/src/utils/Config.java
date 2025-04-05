package utils;

import model.SpotType;
import model.VehicleType;

public class Config {

    public static SpotType getSpotType(VehicleType vehicleType){
        // Use map of fetch from config file.
        if(vehicleType.equals(VehicleType.CAR)) return SpotType.MID;
        if(vehicleType.equals(VehicleType.TRUCK)) return SpotType.BIG;
        if(vehicleType.equals(VehicleType.VAN)) return SpotType.MID;
        if(vehicleType.equals(VehicleType.MOTORCYCLE)) return SpotType.SMALL;
        return SpotType.SMALL;
    }
}
