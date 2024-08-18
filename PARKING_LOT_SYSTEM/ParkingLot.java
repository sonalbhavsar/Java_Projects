import java.util.*;

public class ParkingLot {
    int largeSpotSize;
    int compactSpotSize;
    int bikeSpotSize;

    List<ParkingSpot> largeParkingSpotList;
    List<ParkingSpot> compactParkingSpotList;
    List<ParkingSpot> bikeParkingSpotList;

    public ParkingLot(int largeSpotSize, int compactSpotSize, int bikeSpotSize) {
        this.bikeSpotSize = bikeSpotSize;
        this.compactSpotSize = compactSpotSize;
        this.largeSpotSize = largeSpotSize;

        largeParkingSpotList = new ArrayList<>();
        compactParkingSpotList = new ArrayList<>();
        bikeParkingSpotList = new ArrayList<>();

    }

    public void parkTheVehicle(Vehicle vehicle) {
        if (VehicleType.TRUCK.equals(vehicle.getVehicleType())) {
            System.out.println("we are trying to park the vehicle " + vehicle.getVehicleType());
            if (largeSpotSize > 0) {
                parkingLargeVehicle(vehicle);
            } else {
                System.out.println("No Large Spot Available");
            }

        } else if (VehicleType.CAR.equals(vehicle.getVehicleType())) {
            if (compactSpotSize > 0) {
                System.out.println("we are trying to park the vehicle " + vehicle.getVehicleType());
                parkingCompactVehicle(vehicle);
            } else {
                System.out.println("No Compact Spot Available");
            }
        } else if (VehicleType.BIKE.equals(vehicle.getVehicleType())) {
            if (bikeSpotSize > 0) {
                System.out.println("we are trying to park the vehicle " + vehicle.getVehicleType());
                parkingBike(vehicle);
            } else {
                System.out.println("No Bike Spot Available");
            }
        }
    }

    private void parkingLargeVehicle(Vehicle vehicle) {
        ParkingSpot largeParkingSpot = new ParkingSpot(ParkingSpotType.LARGE);
        largeParkingSpot.setIsFree(false);
        largeParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeParkingSpot);

        largeParkingSpotList.add(largeParkingSpot);
        largeSpotSize--;
        System.out.println("Vehicle TRUCK parked successfully");
    }

    private void parkingCompactVehicle(Vehicle vehicle) {
        ParkingSpot compactParkingSpot = new ParkingSpot(ParkingSpotType.COMPACT);
        compactParkingSpot.setIsFree(false);
        compactParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactParkingSpot);

        compactParkingSpotList.add(compactParkingSpot);
        compactSpotSize--;
        System.out.println("Vehicle CAR parked successfully");
    }

    private void parkingBike(Vehicle vehicle) {
        ParkingSpot bikeParkingSpot = new ParkingSpot(ParkingSpotType.BIKE);
        bikeParkingSpot.setIsFree(false);
        bikeParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeParkingSpot);

        bikeParkingSpotList.add(bikeParkingSpot);
        bikeSpotSize--;
        System.out.println("Vehicle BIKE parked successfully");
    }

    public void unparkTheVehicle(Vehicle vehicle) {
        System.out.println("we are unparking the vehicle " + vehicle.getVehicleType());

        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setIsFree(true);

        if (VehicleType.BIKE.equals(vehicle.getVehicleType())) {
            bikeSpotSize++;
            bikeParkingSpotList.remove(parkingSpot);
        } else if (VehicleType.CAR.equals(vehicle.getVehicleType())) {
            compactSpotSize++;
            compactParkingSpotList.remove(parkingSpot);
        } else {
            largeSpotSize++;
            largeParkingSpotList.remove(parkingSpot);
        }

        System.out.println("Vehicle unparked successfully");
    }
}
