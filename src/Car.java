import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Car {
    // Fields for the Car class
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

    // Getter methods
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

    // Return a string representation of the car (for writing to file)
    // mainly used to put data into database
    @Override
    public String toString() {
        return "ID: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture +
                ", Color: " + color + ", Price: $" + price + ", Registration Number: " + registrationNumber + "\n";
    }
    // Method to save a list of cars to a file
    public static void saveToFile(String fileName, List<Car> carList) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Car car : carList) {
                writer.write(car.toString());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }

    // A. Method to filter cars by a given brand
    public static List<Car> filterByMake(List<Car> cars, String make) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    // B. Method to filter cars by model and years in use
    public static List<Car> filterByModelAndYearsInUse(List<Car> cars, String model, int yearsInUse) {
        int currentYear = Year.now().getValue();
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture()) > yearsInUse) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    // C. Method to filter cars by year of manufacture and price
    public static List<Car> filterByYearAndPrice(List<Car> cars, int year, double minPrice) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYearOfManufacture() == year && car.getPrice() > minPrice) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
