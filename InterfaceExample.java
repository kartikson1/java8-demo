public interface Vehicle {

    void start();
    void stop();

    default void accelerate() {
        System.out.println("Vehicle is accelerating");
    }

    static void printType() {
        System.out.println("This is a Vehicle interface");
    }
}

public class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }

    // No implementation needed for accelerate()

}

public class Main {

    public static void main(String[] args) {

        Vehicle car = new Car();
        car.start();
        car.accelerate();
        car.stop();

        Vehicle.printType();

    }

}
