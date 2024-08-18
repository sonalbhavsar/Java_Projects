public class App {
    public static void main(String[] args) throws Exception {

        ParkingLot parkingLot = new ParkingLot(1, 2, 3);
        Vehicle vehicle1 = new Vehicle(VehicleType.TRUCK);
        parkingLot.parkTheVehicle(vehicle1);

        Vehicle vehicle2 = new Vehicle(VehicleType.CAR);
        parkingLot.parkTheVehicle(vehicle2);

        Vehicle vehicle3 = new Vehicle(VehicleType.TRUCK);
        parkingLot.parkTheVehicle(vehicle3);

        parkingLot.unparkTheVehicle(vehicle1);

    }
}
