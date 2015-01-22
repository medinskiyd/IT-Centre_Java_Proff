package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by Дмитрий on 16.03.14.
 */
public interface OrderServiceInterfase {

    List<Order> getAllOrder();
    void addNewOrder(Order order);

}
