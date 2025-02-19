import java.util.ArrayList;
import java.util.Scanner;
class Car {
    String name;
    int speed;

    public Car(String name, int speed){
        this.name = name;
        this.speed = speed;
    }
    public String toString() {
        return "Машина '" + name + "', скорость = " + speed;
    }
}
class Race {
    String name;

    public String findRaceWinner(ArrayList<Car> listCars){
        int bestResult = 0;
        String carName = null;
        for(int i = 0; i<3; i++){
            Car car = listCars.get(i);
            int length = car.speed * 24;
            if(bestResult < length){
                bestResult = length;
                carName = car.name;
            }
        }
        this.name = carName;
        return name;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> listCars = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String carName = getCarName(scanner, i);
            int speed = getCarSpeed(scanner, i);

            listCars.add(new Car(carName, speed));
        }

        for (Car car : listCars) {
            System.out.println(car);
        }

        Race race = new Race();
        String winner = race.findRaceWinner(listCars);

        System.out.println("Победитель гонки машина - '" + winner + "'");
    }

    private static String getCarName(Scanner scanner, int carNumber) {
        String carName;
        while (true) {
            System.out.println("Введите название " + carNumber + " автомобиля:");
            carName = scanner.nextLine().trim();
            if (carName.isEmpty()) {
                System.out.println("Пустое значение имени, попробуйте снова.");
            } else {
                break;
            }
        }
        return carName;
    }

    private static int getCarSpeed(Scanner scanner, int carNumber) {
        int speed;
        while (true) {
            System.out.println("Введите скорость " + carNumber + " автомобиля:");

            if (!scanner.hasNextInt()) {
                System.out.println("Неправильное числовое значение, попробуйте снова.");
                scanner.next();
                continue;
            }
            speed = scanner.nextInt();
            scanner.nextLine();
            if (speed <= 0 || speed > 250) {
                System.out.println("Некорректное значение скорости (скорость должна быть в диапазоне от 0 до 250 км/ч). Попробуйте снова.");
            } else {
                break;
            }
        }
        return speed;
    }
}