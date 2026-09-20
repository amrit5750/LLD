package DesignPatterns.CreationalDesignPattern;

public class AbstractFactoryDesignPattern {

    public static void main(String[] args) {

        VehicleFactory factory = new HondaFactory();
        Vehicle honda = factory.CreateVehile();
        honda.start();
        honda.stop();
        VehicleFactory toyotaFactory = new ToyataFactory();
        Vehicle toyota = toyotaFactory.CreateVehile();
        toyota.start();
        toyota.stop();
    }

}

interface Vehicle {

    void start();

    void stop();

}

// class carFactory {

// public static Vehicle getCarBrand(String brand) {
// if (brand.equals("Honda")) {
// return new Honda();
// } else if (brand.equals("Toyata")) {
// return new Toyata();
// } else if (brand.equals("BMW")) {
// return new BMW();
// } else {
// throw new IllegalArgumentException("Invaid Argument");
// }

// }

// }

class HondaFactory implements VehicleFactory {

    @Override
    public Vehicle CreateVehile() {
        return new Honda();
    }
}

class ToyataFactory implements VehicleFactory {

    @Override
    public Vehicle CreateVehile() {
        return new Toyata();
    }
}

class BMWFactory implements VehicleFactory {

    @Override
    public Vehicle CreateVehile() {
        return new BMW();
    }
}

interface VehicleFactory {

    Vehicle CreateVehile();

}

class Honda implements Vehicle {

    @Override
    public void start() {
        System.out.println("Starting Honda car");
    }

    @Override
    public void stop() {
        System.out.println("stopping Honda car");
    }

}

class Toyata implements Vehicle {

    @Override
    public void start() {
        System.out.println("Starting Toyata car");
    }

    @Override
    public void stop() {
        System.out.println("stopping Toyata car");
    }

}

class BMW implements Vehicle {

    @Override
    public void start() {
        System.out.println("Starting BMW car");
    }

    @Override
    public void stop() {
        System.out.println("stopping BMW car");
    }

}
