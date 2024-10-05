package automobile;

public class Automobile {
    private String make;
    private String model;
    private int year;
    private String color;
    private String vinNumber;
    private int mileage;
    private double price;
    private Status status;       // e.g., new, used, sold
    private String transmission; // e.g., automatic, manual

    // Default constructor
    public Automobile() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.color = "Unknown";
        this.vinNumber = "Unknown";
        this.mileage = 0;
        this.price = 0.0;
        this.status = Status.UNKNOWN; // Make sure you have an UNKNOWN status in the enum
        this.transmission = "Unknown";
    }

    // Parameterized constructor
    public Automobile(String make, String model, int year, String color, String vinNumber,
                      int mileage, double price, Status status, String transmission) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vinNumber = vinNumber;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.transmission = transmission;
    }

    // Getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return String.join(", ", getMake(), getModel(), String.valueOf(getYear()), getColor(),
                getVinNumber(), String.valueOf(getMileage()), String.valueOf(getPrice()),
                getStatus().name(), getTransmission()); // Ensure status is converted to String
    }

    // Enum for status
    public enum Status {
        NEW, USED, SOLD, UNKNOWN // Include an UNKNOWN status
    }
}
