package hw8.taxi.view;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyOrderTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Order> beans;

    public MyOrderTableModel(List<Order> beans) {
        this.beans = beans;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Дата";
            case 2:
                return "Сумма";
            case 3:
                return "Адресс подачи";
            case 4:
                return "Адресс назначения";
        }
        return "";
    }

    public int getRowCount() {
        return beans.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Order bean = beans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getOrderId();
            case 1:
                return bean.getOrderDate();
            case 2:
                return bean.getOrderAmount();
            case 3:
                return bean.getAddressFeed();
            case 4:
                return bean.getAddresDestination();

        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

}
