package dao;

import model.*;

import java.util.*;

public class ParkingLot {
    // make this thread safe. 
    private  static  ParkingLot instance = null;
    // Implement priority queue for closest parking spot availability
    private Map<SpotType, List<ParkingSpot>> availableVehicle;
    private Map<SpotType, List<ParkingSpot>> occupiedParkingSpot;

    private Map<String, Ticket> vehicleTicketMap;
    private ParkingLot(){
        List<ParkingSpot> big = new ArrayList<>();
        List<ParkingSpot> mid = new ArrayList<>();
        List<ParkingSpot> small = new ArrayList<>();

        for(int i=0;i<1;i++){
            // Create Parking spot factory using factory design pattern. 
            big.add(new BigParkingSpot(i,0,SpotType.BIG,null));
        }

        for(int i=0;i<1;i++){
            mid.add(new MidParkingSpot(i,0,SpotType.MID,null));
        }

        for(int i=0;i<1;i++){
            small.add(new SmallParkingSpot(i,0,SpotType.SMALL,null));
        }

        availableVehicle = new HashMap<>();
        occupiedParkingSpot = new HashMap<>();
        vehicleTicketMap = new HashMap<>();

        availableVehicle.put(SpotType.BIG,big);
        availableVehicle.put(SpotType.MID,mid);
        availableVehicle.put(SpotType.SMALL,small);
        occupiedParkingSpot.put(SpotType.BIG,new ArrayList<>());
        occupiedParkingSpot.put(SpotType.MID,new ArrayList<>());
        occupiedParkingSpot.put(SpotType.SMALL,new ArrayList<>());

    };

    public static ParkingLot getInstance(){
        if(instance==null)
            instance = new ParkingLot();
        return instance;
    }

    public boolean isParkingAvail(SpotType spotType){
        return availableVehicle.get(spotType).size()==0?false:true;
    }

    public ParkingSpot getParkingSpot(SpotType spotType){
        ParkingSpot parkingSpot = availableVehicle.get(spotType).get(0);
        availableVehicle.get(spotType).remove(0);
        occupiedParkingSpot.get(spotType).add(parkingSpot);
        return parkingSpot;
    }

    public void unparkVehicle(ParkingSpot parkingSpot){
        SpotType spot = parkingSpot.getSpotType();
        occupiedParkingSpot.get(spot).remove(parkingSpot);
        availableVehicle.get(spot).add(parkingSpot);
    }

    public Ticket generateTicket(Ticket ticket){
        vehicleTicketMap.put(ticket.getVehicle().getVehicleNo(),ticket);
        return vehicleTicketMap.get(ticket.getVehicle().getVehicleNo());
    }
    public Ticket getTicket(String vehicleNo){
        return vehicleTicketMap.get(vehicleNo);
    }

    public void display(){
        System.out.println("BIG : "+availableVehicle.get(SpotType.BIG).size()+ ", "+"MID : "+availableVehicle.get(SpotType.MID).size()+" "+
                "SMALL : "+availableVehicle.get(SpotType.SMALL).size());
    }

}
