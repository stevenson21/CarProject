import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create an array of Car objects
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "Toyota", "Camry", 2018, "Blue", 23000, "ABC123"));
        carList.add(new Car(2, "Honda", "Civic", 2015, "Black", 19000, "DEF456"));
        carList.add(new Car(3, "Toyota", "Corolla", 2012, "White", 15000, "GHI789"));
        carList.add(new Car(4, "Ford", "Mustang", 2020, "Red", 35000, "JKL012"));
        carList.add(new Car(5, "BMW", "X5", 2019, "Silver", 45000, "MNO345"));

        // A: Get a list of cars of a given brand
        List<Car> toyotaCars = Car.getCarsByBrand(carList, "Toyota");
        Car.saveCarsToFile("toyota_cars.txt", toyotaCars);  // Save to file

        // B: Get a list of cars of a given model that have been in use for more than 5 years
        List<Car> oldCivics = Car.getCarsByModelAndYears(carList, "Civic", 5);
        Car.saveCarsToFile("old_civics.txt", oldCivics);  // Save to file

        // C: Get a list of cars of a given year of manufacture, with price higher than $20000
        List<Car> expensiveCars2019 = Car.getCarsByYearAndPrice(carList, 2019, 20000);
        Car.saveCarsToFile("expensive_cars_2019.txt", expensiveCars2019);  // Save to file
    }
}