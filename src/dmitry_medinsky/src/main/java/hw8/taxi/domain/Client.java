package hw8.taxi.domain;

import week7.firmAssociate.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Дмитрий on 15.03.14.
 *
 * Клиент (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 */

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id // Для обозначения первичного ключа.
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENT_ID", allocationSize = 1, initialValue= 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long clientId = null;
    @Column(name = "NAME")
    private String clientName = null;
    @Column(name = "SECOND_NAME")
    private String clientSecondName = null;
    @Column(name = "PHONE_NUMBER")
    private String clientPhoneNumber = null;
    @Column(name = "ADDRESS_ORDER")
    private String addressOrder = null;
    @Column(name = "ORDER_AMOUNT")
    private Double orderAmount = null;
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_ORDER_DATE")
    private Date lastOrderDate = null;

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL) // Для того что бы вычитывать все сущности добавляем fetch = FetchType.EAGER
    // Для того что бы изменить все cascade = CascadeType.ALL
    private Set<Order> orders = new HashSet<>();

    public Client() {

    }

    public Client(String clientName, String clientSecondName, String clientPhoneNumber, String addressOrder, Double orderAmount, Date lastOrderDate) {
        this.clientName = clientName;
        this.clientSecondName = clientSecondName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.addressOrder = addressOrder;
        this.orderAmount = orderAmount;
        this.lastOrderDate = lastOrderDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSecondName() {
        return clientSecondName;
    }

    public void setClientSecondName(String clientSecondName) {
        this.clientSecondName = clientSecondName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (addressOrder != null ? !addressOrder.equals(client.addressOrder) : client.addressOrder != null)
            return false;
        if (clientId != null ? !clientId.equals(client.clientId) : client.clientId != null) return false;
        if (clientName != null ? !clientName.equals(client.clientName) : client.clientName != null) return false;
        if (clientPhoneNumber != null ? !clientPhoneNumber.equals(client.clientPhoneNumber) : client.clientPhoneNumber != null)
            return false;
        if (clientSecondName != null ? !clientSecondName.equals(client.clientSecondName) : client.clientSecondName != null)
            return false;
        if (lastOrderDate != null ? !lastOrderDate.equals(client.lastOrderDate) : client.lastOrderDate != null)
            return false;
        if (orderAmount != null ? !orderAmount.equals(client.orderAmount) : client.orderAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientSecondName != null ? clientSecondName.hashCode() : 0);
        result = 31 * result + (clientPhoneNumber != null ? clientPhoneNumber.hashCode() : 0);
        result = 31 * result + (addressOrder != null ? addressOrder.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (lastOrderDate != null ? lastOrderDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "сlient{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientSecondName='" + clientSecondName + '\'' +
                ", clientPhoneNumber=" + clientPhoneNumber +
                ", addressOrder='" + addressOrder + '\'' +
                ", orderAmount=" + orderAmount +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }
}
