package model;

public abstract class ParkingSpot {
    private int id;
    private int level;
    private SpotType spotType;

    public ParkingSpot(int id, int level, SpotType spotType, Vehicle parkedVehicle) {
        this.id = id;
        this.level = level;
        this.spotType = spotType;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", level=" + level +
                ", spotType=" + spotType +
                '}';
    }
}
