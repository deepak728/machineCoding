import controller.ParkingLotController;
import model.*;
import service.CardPayment;
import service.CashPayment;

public class Main {
    public static void main(String[] args) {
        ParkingLotController parkingLotController = new ParkingLotController();
        parkingLotController.display();

        parkingLotController.parkVehicle(new Car("CAR-ABCD",VehicleType.CAR));
        parkingLotController.display();
        parkingLotController.parkVehicle(new Truck("TRUCK-ABCD",VehicleType.TRUCK));
        parkingLotController.display();
        parkingLotController.parkVehicle(new MotorCycle("MOTOR-ABCD",VehicleType.MOTORCYCLE));
        parkingLotController.display();

        parkingLotController.unParkVehicle("TRUCK-ABCD",new CashPayment());
        parkingLotController.display();
        parkingLotController.parkVehicle(new Truck("TRUCK-DEFG",VehicleType.TRUCK));
        parkingLotController.parkVehicle(new Truck("TRUCK-GHIJ",VehicleType.TRUCK));
        parkingLotController.display();
        parkingLotController.unParkVehicle("CAR-ABCD",new CardPayment());
        parkingLotController.display();
        parkingLotController.unParkVehicle("MOTOR-ABCD",new CardPayment());
        parkingLotController.display();
        parkingLotController.unParkVehicle("VAN-ABCD",new CashPayment());
        parkingLotController.display();


    }
}