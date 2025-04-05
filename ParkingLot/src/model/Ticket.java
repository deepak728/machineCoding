package model;

import java.time.LocalDateTime;


public class Ticket {
    private String id;
    private Vehicle vehicle;
    private LocalDateTime entry;
    private LocalDateTime exit;
    private ParkingSpot spot;
    private double amount;

    public Ticket(Vehicle vehicle, LocalDateTime entry, ParkingSpot spot) {
        this.id = vehicle.vehicleNo;
        this.vehicle = vehicle;
        this.entry = entry;
        this.exit = null;
        this.spot = spot;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntry() {
        return entry;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getExit() {
        return exit;
    }

    public void setExit(LocalDateTime exit) {
        this.exit = exit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", vehicle=" + vehicle +
                ", entry=" + entry +
                ", exit=" + exit +
                ", spot=" + spot +
                ", amount=" + amount +
                '}';
    }
}
