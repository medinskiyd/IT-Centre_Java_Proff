package hw8.taxi.dao;

import hw8.taxi.domain.Order;

import java.util.List;

/**
 * Created by Дмитрий on 16.03.14.
 */
public interface OrderDao {

    void create(Order order);
    Order read(Long id);
    void update(Order order);
    void delete(Order order);
    List<Order> findAll();

}
