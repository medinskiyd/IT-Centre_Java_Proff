package week2.Tasks.Parking;

/**
 * Created by Дмитрий on 25.01.14.
 */
public class Main {

    public static void main(String[] args) throws Parking.ParkFullException {

        Parking parkingTest = new Parking("Парковка №1", 50, 20); // Создаем новую парковку на 50 мест для легковых и 20 мест для грузовых.
        Parking.Car volvo = new Parking.Car("volvo", 1530);
        Parking.Car audi = new Parking.Car("audi", 3531);
        Parking.Car audi1 = new Parking.Car("audi1", 3531);
        Parking.Car audi2 = new Parking.Car("audi2", 3531);

        parkingTest.park(volvo);
        parkingTest.park(audi);
        parkingTest.park(audi1);
        parkingTest.park(audi2);

        parkingTest.leave(2, "Легковик");

        Parking.Truck volvoTruck = new Parking.Truck("volvoTruck", 1530);
        Parking.Truck audiTruck = new Parking.Truck("audiTruck", 3531);

        parkingTest.park(volvoTruck);
        parkingTest.park(audiTruck);

        parkingTest.leave(2, "Грузовик");

    }

//    Имеем после выполнения программы:
//    Машина volvo припаркована на 1 место парковки для легковиков.
//    Машина audi припаркована на 2 место парковки для легковиков.
//    Машина audi1 припаркована на 3 место парковки для легковиков.
//    Машина audi2 припаркована на 4 место парковки для легковиков.
//    Машина audi с номерами 3531 освободила парковку для легковиков.
//    Грузовик volvoTruck припаркован на 1 месте парковки для грузовиков.
//    Грузовик audiTruck припаркован на 2 месте парковки для грузовиков.
//    Грузовик audiTruck с номерами 3531 освободил парковку для грузовиков.

}
