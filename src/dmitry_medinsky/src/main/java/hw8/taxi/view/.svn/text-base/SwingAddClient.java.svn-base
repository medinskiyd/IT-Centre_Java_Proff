package hw8.taxi.view;

import hw8.taxi.domain.Client;
import hw8.taxi.service.ClientService;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SwingAddClient extends JFrame {

    private JTextField textField;
    private JTextField addName;
    private JTextField addSecondName;
    private JTextField addPhoneNumber;
    private JTextField addAddress;
    private JTextField addDate;
    private JTextField addCash;

    private String name;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String date;
    private String cash;

    private Client client;
    private ClientService clientService;


    public SwingAddClient() {
        super("Добавление клиента");
        createGUIAddclient(clientService);
    }

    public void createGUIAddclient(ClientService clientService) {

        final ClientService clientS = clientService;
        this.clientService = clientS;
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        addName = new JTextField("Имя");
        addSecondName = new JTextField("Фамилия");
        addPhoneNumber = new JTextField("Телефон");
        addAddress = new JTextField("Адрес");
        addDate = new JTextField("Дата");
        addCash = new JTextField("Сумма");
        panel.add(addName);
        panel.add(addSecondName);
        panel.add(addPhoneNumber);
        panel.add(addAddress);
        panel.add(addDate);
        panel.add(addCash);

        JButton addClientButton = new JButton("Добавить клиента");
        addClientButton.setActionCommand("Клиент добавлен!");
        panel.add(addClientButton);

        textField = new JTextField();
        textField.setColumns(10);
        panel.add(textField);

        getContentPane().add(panel);
        setPreferredSize(new Dimension(320, 100));

        addClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(e.getActionCommand());
                name = addName.getText();
                secondName = addName.getText();
                phoneNumber = addPhoneNumber.getText();
                address = addAddress.getText();
                date = addDate.getText();
                cash = addCash.getText();

                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                Date date1 = null;
                try {
                    date1 = format.parse(date);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                double sum = Double.parseDouble(cash);

                client = new Client(name,secondName,
                        phoneNumber, address, sum,
                        date1);
                System.out.println(" Добавляем пользователя: " + client);
                clientS.addNewClient(client);
            }

        });

        this.clientService = clientS;

    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getCash() {
        return cash;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}

