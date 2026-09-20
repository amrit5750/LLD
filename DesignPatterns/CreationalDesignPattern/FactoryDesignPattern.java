package DesignPatterns.CreationalDesignPattern;

public class FactoryDesignPattern {

    public static void main(String[] args) {

        Vehicle bikeVehicle = new Bike();
        bikeVehicle.start();
        bikeVehicle.stop();
        Vehicle TruckVehicle = new Truck();
        TruckVehicle.start();
        Vehicle carVehicle = new Car();
        carVehicle.start();

        // Small Optimization
        Vehicle VehicleType = null;
        String type = "Car";

        if (type.equals("Car")) {
            VehicleType = new Car();
        } else if (type.equals("Truck")) {
            VehicleType = new Truck();
        } else {
            VehicleType = new Bike();
        }
        VehicleType.start();
        VehicleType.stop();

        // Optimized Aproach

        VehicleFactory factory = new VehicleFactory();
        Vehicle carVehicleType = factory.getVehicle("Car");
        Vehicle TruckVehicleType = factory.getVehicle("Car");
        Vehicle BikeVehicleType = factory.getVehicle("Car");

        carVehicleType.start();
        carVehicleType.stop();
        TruckVehicleType.start();
        TruckVehicleType.stop();
        BikeVehicleType.start();
        BikeVehicleType.stop();

    }

}

class VehicleFactory {

    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car();
        } else if (vehicleType.equals("Truck")) {
            return new Truck();
        } else if (vehicleType.equals("Bike")) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

interface Vehicle {
    void start();

    void stop();
}

class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Stating Bike");
    }

    @Override
    public void stop() {
        System.out.println("stopping Bike");
    }

}

class Truck implements Vehicle {

    @Override
    public void start() {
        System.out.println("Stating Truck");
    }

    @Override
    public void stop() {
        System.out.println("stopping Truck");
    }

}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Stating car");
    }

    @Override
    public void stop() {
        System.out.println("stopping car");
    }

}
