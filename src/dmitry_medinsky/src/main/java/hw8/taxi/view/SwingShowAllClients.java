package hw8.taxi.view;

import hw8.taxi.service.ClientService;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class SwingShowAllClients extends JFrame {

    public SwingShowAllClients(ClientService clientService) {

        super("Клиенты");

        TableModel model = new MyClientTableModel(clientService.getAllClient());
        JTable table = new JTable(model);

        getContentPane().add(new JScrollPane(table));

        setPreferredSize(new Dimension(500, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
