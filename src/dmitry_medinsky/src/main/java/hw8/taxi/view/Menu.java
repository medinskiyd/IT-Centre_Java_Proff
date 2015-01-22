package hw8.taxi.view;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Дмитрий on 15.03.14.
 */
@Component
public class Menu {
    private static final int EXIT_ITEM = 0;
    private static final int SHOW_ALL_CLIENT_ITEM = 1;
    private static final int ADD_NEW_CLIENT_ITEM = 2;
    private static final int ADD_NEW_ORDER_ITEM = 3;
    private static final int SHOW_ALL_ORDER_ITEM = 4;


    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;
    private Scanner scan;
    private Client client1;

    public Menu(ClientService userService, OrderService orderService) {
        this();
        this.clientService = userService;
        this.orderService = orderService;
    }

    public Menu() {
        scan = new Scanner(System.in);
    }

    public void main() {
        int choise = EXIT_ITEM;
        autoriz();
        showSwingMenu();
        do {
            showMenu();
            choise = getInput();

            switch (choise) {
                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case SHOW_ALL_CLIENT_ITEM:
                    showAllClients();
                    break;
                case ADD_NEW_CLIENT_ITEM:
                    addNewClient();
                    break;
                case ADD_NEW_ORDER_ITEM:
                    addNewOrder();
                    break;
                case SHOW_ALL_ORDER_ITEM:
                    showAllOrders();

            }
        } while (choise != EXIT_ITEM);

    }

    private void showAllClients() {
        new SwingShowAllClients(clientService);
        for (Client client : clientService.getAllClient()) {
            System.out.println(client);
        }
    }

    private void showAllOrders() {
        new SwingShowAllOrders(orderService);
        for (Order order : orderService.getAllOrder()) {
            System.out.println(order);
        }
    }

    private void addNewClient() {

//        System.out.println(" Введите имя клиента:");
//        String name = scan.nextLine();
//        System.out.println(" Введите фамилию клиента:");
//        String surname = scan.nextLine();
//        System.out.println(" Введите номер телефона клиента:");
//        String phoneNumber = scan.nextLine();
//        System.out.println(" Введите адресс клиента:");
//        String address = scan.nextLine();
//        Date date = scanDateWithRetry(" Введите дату последнего вызова такси:");
//        System.out.println(" Введите сумму оплаченную при последней поездке:");
//        double sum = scan.nextDouble();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingAddClient swingAddClient = new SwingAddClient();
                swingAddClient.pack();
                swingAddClient.setLocationRelativeTo(null);
                swingAddClient.setVisible(true);

                clientService = swingAddClient.getClientService();
            }
        });



    }

    private void addNewOrder() {
        Date date = scanDateWithRetry(" Введите дату заказа:");
        System.out.println(" Введите Id клиента:");
        Long id = scan.nextLong();
        System.out.println(" Введите сумму для оплаты:");
        double sum = scan.nextDouble();
        System.out.println(" Введите адресс подачи:");
        String addressFeed = scan.nextLine();
        System.out.println(" Введите адресс назначения:");
        String addressDestination = scan.nextLine();
        Order order = new Order(date, sum, addressFeed, addressDestination, clientService.getClientById(id));
        System.out.println(" Добавляем заказ: " + order);
        orderService.addNewOrder(order);
        scan.close();
    }

    private double scanDoubleWithRetry(String message) {
        return 0;
    }

    private Date scanDateWithRetry(String message) {
        final String DATE_FORMAT = "mm.dd.yyyy";
        Date date = null;
        String dateStr;
        do {
            System.out.println(message);
            dateStr = scan.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException pe) {
                System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
            }
        } while (date == null);
        return date;
    }

    private int scanIntWithRetry(String ageMsg) {
        Integer age = null;
        String ageStr;
        do {
            System.out.println(ageMsg);
            ageStr = scan.nextLine();
            try {
                age = Integer.valueOf(ageStr);
            } catch (NumberFormatException nfe) {
                System.out.println("Not an int value, input again");
            }
        } while (age == null);

        return age;
    }

    private int getInput() {
        int res = -1;
        String inputStr = scan.nextLine();
        try {
            res = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String " + inputStr + " is not a number");
        }

        return res;
    }

    public void showMenu() {
        System.out.println("-----------------");
        System.out.println("1. Показать всех клиентов");
        System.out.println("2. Добавить нового клиента");
        System.out.println("3. Добавить новый заказ");
        System.out.println("4. Показать все заказы");
        System.out.println("0. Выйти");
    }

    public void showSwingMenu() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JMenuBarSwing.createGUI(clientService, orderService);
            }
        });
    }

    public void autoriz() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Autorization aut = new Autorization();
            }
        });
    }
}

