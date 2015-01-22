package hw8.taxi.view;

import hw8.taxi.domain.Client;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyClientTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Client> beans;

    public MyClientTableModel(List<Client> beans) {
        this.beans = beans;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Имя";
            case 2:
                return "Фамилия";
            case 3:
                return "Номер телефона";
            case 4:
                return "Адресс";
            case 5:
                return "Сумма";
            case 6:
                return "Последняя дата заказа";
        }
        return "";
    }

    public int getRowCount() {
        return beans.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Client bean = beans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getClientId();
            case 1:
                return bean.getClientName();
            case 2:
                return bean.getClientSecondName();
            case 3:
                return bean.getClientPhoneNumber();
            case 4:
                return bean.getAddressOrder();
            case 5:
                return bean.getOrderAmount();
            case 6:
                return bean.getLastOrderDate();
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
