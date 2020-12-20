package vip.tera.dddsamaple.domain;

import lombok.Data;

import java.util.List;

@Data
public class CustomerOrder {

    private int orderId;
    private String paymentMethod;
    private String address;
    private List<OrderItem> orderItems;

//    public float calculateTotalPrice() {
//        return orderItems.stream().map(OrderItem::getTotalPrice)
//                .reduce(0F, Float::sum);
//    }

}
