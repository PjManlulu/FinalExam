package ceu.HardwareStore.forms;

import java.sql.Timestamp;

import ceu.HardwareStore.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {

    private Integer id;

    private Timestamp orderedAt;

    private int quantity;

    private int amount;

    public OrderForm(Order order) {
        this.id = order.getId();
        this.orderedAt = order.getOrderedAt();
        this.quantity = order.getQuantity();
        this.amount = order.getAmount();
    }

    public Order toEntity(Order order) {
        if (order == null) {
            order = new Order();
        }

        order.setOrderedAt(orderedAt);
        order.setQuantity(quantity);
        order.setAmount(amount);

        return order;
    }

}
