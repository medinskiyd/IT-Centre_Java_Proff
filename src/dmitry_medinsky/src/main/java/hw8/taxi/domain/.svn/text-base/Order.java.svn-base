package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Дмитрий on 16.03.14.
 *
 * заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id // Для обозначения первичного ключа.
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_ORDER_ID", allocationSize = 1, initialValue= 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long orderId = null;
    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    private Date orderDate = null;
    @Column(name = "ORDER_AMOUNT")
    private Double orderAmount = null;
    @Column(name = "ADDRESS_FEED")
    private String addressFeed = null;
    @Column(name = "ADDRESS_DESTINATION")
    private String addresDestination = null;

    @ManyToOne
    private Client client;

    public Order() {
    }

    public Order(Date orderDate, Double orderAmount, String addressFeed, String addresDestination, Client client) {
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.addressFeed = addressFeed;
        this.addresDestination = addresDestination;
        this.client = client;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getAddressFeed() {
        return addressFeed;
    }

    public void setAddressFeed(String addressFeed) {
        this.addressFeed = addressFeed;
    }

    public String getAddresDestination() {
        return addresDestination;
    }

    public void setAddresDestination(String addresDestination) {
        this.addresDestination = addresDestination;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (addresDestination != null ? !addresDestination.equals(order.addresDestination) : order.addresDestination != null)
            return false;
        if (addressFeed != null ? !addressFeed.equals(order.addressFeed) : order.addressFeed != null) return false;
        if (client != null ? !client.equals(order.client) : order.client != null) return false;
        if (orderAmount != null ? !orderAmount.equals(order.orderAmount) : order.orderAmount != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (addressFeed != null ? addressFeed.hashCode() : 0);
        result = 31 * result + (addresDestination != null ? addresDestination.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                ", addressFeed='" + addressFeed + '\'' +
                ", addresDestination='" + addresDestination + '\'' +
                ", client=" + client +
                '}';
    }
}
