package FinalExamsJavaFundamentals;

import java.util.*;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carsMileage = new TreeMap<>();
        Map<String, Integer> carsFuel = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String carInfo = scanner.nextLine();
            String car = carInfo.split("\\|")[0];
            int mileage = Integer.parseInt(carInfo.split("\\|")[1]);
            int fuel = Integer.parseInt(carInfo.split("\\|")[2]);

            carsMileage.put(car, mileage);
            carsFuel.put(car, fuel);

            if (carsFuel.get(car) > 75) {
                carsFuel.put(car, 75);
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] tokens = command.split(" : ");
            String carModel = tokens[1];
            switch (tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelNeed = Integer.parseInt(tokens[3]);
                    if (fuelNeed > carsFuel.get(carModel)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carsMileage.put(carModel, carsMileage.get(carModel) + distance);
                        carsFuel.put(carModel, carsFuel.get(carModel) - fuelNeed);
                        System.out.println(carModel + " driven for " + distance + " kilometers. "
                                + fuelNeed + " liters of fuel consumed.");
                        if (carsMileage.get(carModel) > 100000) {
                            System.out.println("Time to sell the " + carModel + "!");
                            carsMileage.remove(carModel);
                            carsFuel.remove(carModel);
                        }
                    }
                    break;
                case "Refuel":
                    int refillFuel = Integer.parseInt(tokens[2]);
                    int carMomentFuel = carsFuel.get(carModel);
                    carsFuel.put(carModel, carsFuel.get(carModel) + refillFuel);
                    if (carsFuel.get(carModel) > 75) {
                        carsFuel.put(carModel, 75);
                    }
                    System.out.printf("%s refueled with %d liters%n", carModel, carsFuel.get(carModel) - carMomentFuel);
                    break;
                case "Revert":
                    int km = Integer.parseInt(tokens[2]);
                    int realMileage = carsMileage.get(carModel);
                    carsMileage.put(carModel, carsMileage.get(carModel) - km);
                    if (carsMileage.get(carModel) < 10000) {
                        carsMileage.put(carModel, 10000);
                    }
                    System.out.printf("%s mileage decreased by %d kilometers%n", carModel, Math.abs(carsMileage.get(carModel) - realMileage));
                    break;
            }
            command = scanner.nextLine();
        }
        carsMileage.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(car -> System.out.println(car.getKey() + " -> Mileage: " + car.getValue() + " kms, Fuel in the tank: "
                        + carsFuel.get(car.getKey()) + " lt."));
    }
}
