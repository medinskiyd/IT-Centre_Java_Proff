package hw8.taxi.view;

import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JMenuBarSwing extends JFrame {

    private static ClientService clientService;
    private static OrderService orderService;

    public static void createGUI(ClientService cService, final OrderService orderService) {

        final JFrame frame = new JFrame("Служба такси IT-centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu client = new JMenu("Клиент");

        JMenuItem addClient = new JMenuItem("Добавить");
        client.add(addClient);

        // Окно добавления нового клиента.
        addClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingAddClient addClientBar = new SwingAddClient();
            }
        });

        JMenuItem updClient = new JMenuItem("Редактировать");
        client.add(updClient);

        JMenuItem delClient = new JMenuItem("Удалить");
        client.add(delClient);

        client.addSeparator();

        JMenuItem showAllClients = new JMenuItem("Показать всех клиентов");
        client.add(showAllClients);

        showAllClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              SwingShowAllClients tf = new SwingShowAllClients(clientService);
            }
        });


        JMenu order = new JMenu("Заказ");

        JMenuItem addOrder = new JMenuItem("Добавить");
        order.add(addOrder);

//        addOrder.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                SwingAddOrder addClient1 = new SwingShowAllOrders(orderService);
//            }
//        });

        JMenuItem updOrder = new JMenuItem("Редактировать");
        order.add(updOrder);

        JMenuItem delOrder = new JMenuItem("Удалить");
        order.add(delOrder);

        order.addSeparator();

        JMenuItem showAllOrders = new JMenuItem("Показать все заказы");
        order.add(showAllOrders);

        showAllOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingShowAllOrders tf = new SwingShowAllOrders(orderService);
            }
        });

        JMenuItem exitItem = new JMenuItem("Выйти");
        client.add(menuBar);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(client);
        menuBar.add(order);
        menuBar.add(exitItem);

        frame.setJMenuBar(menuBar);

        frame.setPreferredSize(new Dimension(200, 200));
        frame.pack();
        frame.setLocationRelativeTo(null); // Располагает окно по центру экрана.
        frame.setVisible(true); // Для того что бы окно было видно.
    }

}