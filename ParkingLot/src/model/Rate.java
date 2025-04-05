package model;

public class Rate {
    public static double getRate(SpotType spotType){
        // Implement map for this
        if(spotType == SpotType.BIG) return 10;
        if(spotType == SpotType.MID) return 5;
        if(spotType == SpotType.SMALL) return 1;
        return 0;
    }
}
