package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Дмитрий on 15.03.14.

 Функции:
 - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 - отредактировать заказ (поменять свойства заказа)
 - вывести список заказов на сумму в указанном диапазоне
 - вывести список всех заказов порциями по 5 штук (размер порции задается в properties файле)

 Класс задания hw8.taxi.service.OrderService
 */
@Service
public class OrderService implements OrderServiceInterfase {

    private OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.findAll();
    }

    @Override
    public void addNewOrder(Order order) {
        orderDao.create(order);
    }
}
