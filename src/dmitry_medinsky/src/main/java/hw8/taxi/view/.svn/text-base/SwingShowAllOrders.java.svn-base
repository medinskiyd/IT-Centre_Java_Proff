package hw8.taxi.view;

import hw8.taxi.service.OrderService;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class SwingShowAllOrders extends JFrame {

    public SwingShowAllOrders(OrderService orderService) {

        super("Заказы");

        TableModel model = new MyOrderTableModel(orderService.getAllOrder());
        JTable table = new JTable(model);

        getContentPane().add(new JScrollPane(table));

        setPreferredSize(new Dimension(500, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
