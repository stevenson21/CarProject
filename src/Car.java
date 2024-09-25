import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    // Constructor to initialize Car object
    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    // Method to display car details (used for outputting to a file)
    @Override
    public String toString() {
        return "Car ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture
                + ", Color: " + color + ", Price: $" + price + ", Registration Number: " + registrationNumber;
    }

    // Method to save a list of cars to a file
    public static void saveCarsToFile(String fileName, List<Car> cars) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Car car : cars) {
                writer.write(car.toString() + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving to " + fileName);
            e.printStackTrace();
        }
    }

    // A: Get a list of cars of a given brand
    public static List<Car> getCarsByBrand(List<Car> cars, String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    // B: Get a list of cars of a given model that have been in use for more than n years
    public static List<Car> getCarsByModelAndYears(List<Car> cars, String model, int yearsInUse) {
        int currentYear = java.time.Year.now().getValue();  // Get the current year
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture()) > yearsInUse) {
                result.add(car);
            }
        }
        return result;
    }

    // C: Get a list of cars of a given year of manufacture with price higher than the specified one
    public static List<Car> getCarsByYearAndPrice(List<Car> cars, int year, double minPrice) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYearOfManufacture() == year && car.getPrice() > minPrice) {
                result.add(car);
            }
        }
        return result;
    }
}