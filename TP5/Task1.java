// Vehicle.java (Base Class)
class Vehicle {
    String plateNumber;
    int maxSpeed;
    int currentSpeed;

    public Vehicle(String plateNumber, int maxSpeed) {
        this.plateNumber = plateNumber;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0; // Initial speed starts at 0
    }

    public void accelerate(int delta) {
        if (delta > 0) {
            currentSpeed += delta;
            if (currentSpeed > maxSpeed) {
                currentSpeed = maxSpeed; // Cap at max speed
            }
        }
    }

    public void brake(int delta) {
        if (delta > 0) {
            currentSpeed -= delta;
            if (currentSpeed < 0) {
                currentSpeed = 0; // Speed cannot drop below 0
            }
        }
    }

    public String info() {
        return "Vehicle [Plate: " + plateNumber + ", Max Speed: " + maxSpeed + " km/h, Current Speed: " + currentSpeed + " km/h]";
    }
}

// Taxi.java (Subclass extending Vehicle)
class Taxi extends Vehicle {
    boolean meterOn;
    double pricePerKm;

    public Taxi(String plateNumber, int maxSpeed, double pricePerKm) {
        super(plateNumber, maxSpeed); // Initialize parent attributes via super()[cite: 158]
        this.pricePerKm = pricePerKm;
        this.meterOn = false;         // Meter starts turned off
    }

    public void startMeter() {
        this.meterOn = true;
    }

    public void stopMeter() {
        this.meterOn = false;
    }

    @Override
    public String info() {
        // Reuse parent info() via super.info() and add taxi-specific state[cite: 158]
        return "Taxi {" + super.info() + ", Price/Km: " + pricePerKm + " DA, Meter On: " + meterOn + "}";
    }
}

// Main.java (Executable Class)
public class Task1 {
    public static void main(String[] args) {
        // 1. Create a Taxi instance
        Taxi myTaxi = new Taxi("16-2026-15", 180, 50.0);

        System.out.println("=== Initial State ===");
        System.out.println(myTaxi.info());

        // 2. Test speed control (accelerate & brake)[cite: 158]
        System.out.println("\n=== Testing Speed Control ===");
        myTaxi.accelerate(60);
        System.out.println("After accelerating by 60: Speed = " + myTaxi.currentSpeed + " km/h");
        
        myTaxi.accelerate(150); // Attempts to exceed maxSpeed (180)
        System.out.println("After accelerating beyond limit: Speed = " + myTaxi.currentSpeed + " km/h");

        myTaxi.brake(40);
        System.out.println("After braking by 40: Speed = " + myTaxi.currentSpeed + " km/h");

        // 3. Test taxi meter toggling[cite: 158]
        System.out.println("\n=== Testing Meter Control ===");
        myTaxi.startMeter();
        System.out.println(myTaxi.info());

        myTaxi.stopMeter();
        System.out.println(myTaxi.info());
    }
}