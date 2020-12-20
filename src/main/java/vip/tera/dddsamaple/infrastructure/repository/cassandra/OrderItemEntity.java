package vip.tera.dddsamaple.infrastructure.repository.cassandra;

import lombok.Data;
import vip.tera.dddsamaple.domain.OrderItem;
import vip.tera.dddsamaple.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItemEntity {

    private UUID productId;
    private BigDecimal price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(final OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.price = orderItem.getPrice();
    }

    public OrderItem toOrderItem() {
        return new OrderItem(new Product(productId, price, ""));
    }

}
