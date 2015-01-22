package week2.Tasks.Parking;

import java.util.HashMap;

/**
 * Created by Дмитрий on 25.01.14.
 *  Написать класс представляющий парковку. С методами:
 - int park(Car cat) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Добавить к классу парковка возможность размещать грузовики (наследник машины и помещается на особом, расширенном паркоместе)

 (Используем HashMap (номер места это ключ, машина - эначение)).
 */

public class Parking {

    private String nameParking = ""; // Имя парковки.
    private int numberCar = 0; // Количество машин на парковке легковиков.
    private int numberCarTruck = 0; // Количество машин на парковке грузовиков.
    HashMap parking = new HashMap(); // Список парковочных мест для легковиков.
    HashMap parkingTruck = new HashMap(); // Список парковочных мест для грузовиков.
    private Integer numberParkPlace = 0; // Номер парковочного места.
    private Integer numberParkPlaceTruck = 0; // Номер парковочного места грузовика.
    private int amountParkPlace = 50; // Количество парковочных мест для легковиков.
    private int amountParkPlaceTruck = 20; // Количество парковочных мест для грузовиков.
    private boolean availabilityCar = false; // Наличие машины на парк. месте.


    public Parking () {

    }

    public Parking (String nameParking, int amountParkPlace, int amountParkPlaceTruck) {
        this.nameParking = nameParking;
        this.amountParkPlace = amountParkPlace;
        this.amountParkPlaceTruck = amountParkPlaceTruck;
    }

    // Поместить машину на парковку, возвращает номер паркоместа.
    public int park(Car car) throws IndexOutOfBoundsException, ParkFullException{

        try {
        if(car.getTypeCar() == "Легковушка") {
        for(int i = 1; i <= amountParkPlace; i++){
            availabilityCar = parking.containsKey(i); // Присваиваем наличие машины на месте.
            if (availabilityCar == false) { // Если машины нет, ->
                numberParkPlace = i; // Присваиваем номер места.
                parking.put(numberParkPlace, car); // Паркуем нашу машину в указаное место.
                System.out.println("Машина " + car.getName() + " припаркована на " + numberParkPlace + " место парковки для легковиков."); // Даем знать что машина припаркована.
                break; // Машина припаркована, заканчиваем проверку свободных мест.
            } else {
                if(numberParkPlace == amountParkPlace) throw new ParkFullException();
                }
            }
        } else if(car.getTypeCar() == "Грузовик") {
            for(int i = 1; i <= amountParkPlaceTruck; i++){
                availabilityCar = parkingTruck.containsKey(i); // Присваиваем наличие машины на месте.
                if (availabilityCar == false) { // Если машины нет, ->
                    numberParkPlaceTruck = i; // Присваиваем номер места.
                    parkingTruck.put(numberParkPlaceTruck, car); // Паркуем нашу машину в указаное место.
                    System.out.println("Грузовик " + car.getName() + " припаркован на " + numberParkPlaceTruck + " месте парковки для грузовиков."); // Даем знать что машина припаркована.
                    break; // Машина припаркована, заканчиваем проверку свободных мест.
                } else {
                    if(numberParkPlaceTruck == amountParkPlaceTruck) throw new ParkFullException();
                }
            }
        }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();

        } catch (ParkFullException pfe) {
            System.out.println("Все места на парковке заняти, попробуйте позже.");
        }
        return numberParkPlace;
    }

    // Удалить машину с парковки по номеру парокместа, возвращает удаляемую машину.
    public Car leave(int placeNumber, String typeCar) throws IndexOutOfBoundsException{ //()
        Car car = new Car();
        try {
            if(typeCar == "Легковик") {

            if (placeNumber > amountParkPlace) throw new IndexOutOfBoundsException();

            car = (Car)parking.get(placeNumber); // Вытаскиваем машину из колекции.
            parking.remove(placeNumber); // Удаляем информацию о том что парковочное место занято.
            System.out.println("Машина " + car.getName() + " с номерами " + car.getCarNumber() + " освободила парковку для легковиков." );
            } else if(typeCar == "Грузовик") {

                if (placeNumber > amountParkPlaceTruck) throw new IndexOutOfBoundsException();

                car = (Car)parkingTruck.get(placeNumber); // Вытаскиваем машину из колекции.
                parkingTruck.remove(placeNumber); // Удаляем информацию о том что парковочное место занято.
                System.out.println("Грузовик " + car.getName() + " с номерами " + car.getCarNumber() + " освободил парковку для грузовиков." );
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Такого места нет на парковке.");
        }
        return car; // Возвращаем машину оставившую парковку.
    }


    /**
     * Created by Дмитрий on 25.01.14.
     */
    public static class Car {

        private String name = ""; // Название машины.
        private int carNumber = 0; // Номер машины.
        private String typeCar = "Легковушка"; // Тип машины.

        public Car(){

        }

        public Car(String name, int сarNumber){
            this.name = name;
            this.carNumber = сarNumber;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(int carNumber) {
            this.carNumber = carNumber;
        }

        public String getTypeCar() {
            return typeCar;
        }

        public void setTypeCar(String typeCar) {
            this.typeCar = typeCar;
        }

        @Override
        public String toString(){

            return name + " " + carNumber;
        }
    }

    /**
     * Created by Дмитрий on 26.01.14.
     */
    public static class ParkFullException extends Exception {

    //    public ParkFullException(String text) {
    //        super(text);
    //    }
    }

    /**
     * Created by Дмитрий on 25.01.14.
     * Добавить к классу парковка возможность размещать грузовики (наследник машины и помещается на особом, расширенном паркоместе)
     */
    public static class Truck extends Car {

        private String typeCar = "Грузовик"; // Тип машины.

        public Truck(){

        }

        public Truck(String name, int сarNumber){
            super.name = name;
            super.carNumber = сarNumber;
        }

        public String getTypeCar() {
            return typeCar;
        }

        public void setTypeCar(String typeCar) {
            this.typeCar = typeCar;
        }
    }
}
