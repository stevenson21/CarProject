import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create an array (list) of Car objects
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Corolla", 2010, "Red", 7500, "ABC123"));
        cars.add(new Car(2, "Honda", "Civic", 2008, "Blue", 6200, "XYZ789"));
        cars.add(new Car(3, "Ford", "Fiesta", 2015, "Black", 10500, "LMN456"));
        cars.add(new Car(4, "Toyota", "Camry", 2012, "White", 8500, "DEF234"));
        cars.add(new Car(5, "Honda", "Accord", 2005, "Gray", 5000, "PQR678"));

        // A. Save a list of cars of a given brand (e.g., "Toyota")
        List<Car> toyotaCars = Car.filterByMake(cars, "Toyota");
        Car.saveToFile("toyota_cars.txt", toyotaCars);

        // B. Save a list of cars of a given model that have been in use for more than n years (e.g., "Civic", more than 10 years)
        List<Car> oldCivicCars = Car.filterByModelAndYearsInUse(cars, "Civic", 10);
        Car.saveToFile("old_civic_cars.txt", oldCivicCars);

        // C. Save a list of cars of a given year of manufacture, with price higher than specified (e.g., cars from 2010, price > 7000)
        List<Car> expensive2010Cars = Car.filterByYearAndPrice(cars, 2010, 7000);
        Car.saveToFile("expensive_2010_cars.txt", expensive2010Cars);

    }
}