package controller;

import dao.ParkingLot;
import model.*;
import service.DisplayService;
import service.ParkingService;
import service.Payment;
import utils.Config;

import java.time.Duration;
import java.time.LocalDateTime;


public class ParkingLotController {
    ParkingService parkingService;
    DisplayService displayService;

    ParkingLot parkingLot;

    public ParkingLotController(){
        this.parkingService = new ParkingService();
        this.displayService = new DisplayService();
        this.parkingLot = ParkingLot.getInstance();
    }

    boolean isParkingAvail(SpotType spotType){
        return parkingLot.isParkingAvail(spotType);
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        SpotType spotType = Config.getSpotType(vehicle.getVehicleType());

        if(!isParkingAvail(spotType)){
            System.out.println("Parking spot for this vehicle type is not available "+vehicle.getVehicleType());
            return;
        }

        // Design can be changed to allow concurrency effectively. When there are multiple servers and one database.

        ParkingSpot parkingSpot = parkingLot.getParkingSpot(spotType);
        if(parkingSpot==null){
            System.out.println("Unable to find parking spot");
        }
        Ticket ticket = parkingLot.generateTicket(new Ticket(vehicle, LocalDateTime.now(),parkingSpot));
        System.out.println("vehicle parked successfully. Ticket: "+ticket);
    }

    public void unParkVehicle(String vehicleNo, Payment paymentMode){
        Ticket ticket = parkingLot.getTicket(vehicleNo);
        if(ticket==null){
            System.out.println("Vehicle is not parked "+vehicleNo);
            return;
        }
        parkingLot.unparkVehicle(ticket.getSpot());
        ticket.setExit(LocalDateTime.now());
        ticket.setAmount(calculateAmount(ticket));

        makePayment(ticket,paymentMode);
        System.out.println("Unparked vehicle "+vehicleNo);
    }

    private double calculateAmount(Ticket ticket){
        double rate = Rate.getRate(ticket.getSpot().getSpotType());
        long elapsedTime = Duration.between(ticket.getEntry(),ticket.getExit()).toMillis()*2;
        return (elapsedTime)*rate;
    }

    public boolean makePayment(Ticket ticket, Payment mode){
        mode.processPayment(ticket.getAmount());
        return true;
    }

    public void display(){
        // Implement it here. For simplicity implemented in dao
        parkingLot.display();
    }

}
