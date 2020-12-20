package vip.tera.dddsamaple.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.tera.dddsamaple.domain.OrderService;
import vip.tera.dddsamaple.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
public class CliOrderController {

    private final OrderService orderService;

    @Autowired
    public CliOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createCompleteOrder() {
        if (log.isInfoEnabled()) log.info("<<Create complete order>>");
        UUID orderId = createOrder();
        orderService.completeOrder(orderId);
    }

    public void createIncompleteOrder() {
        if (log.isInfoEnabled()) log.info("<<Create incomplete order>>");
        UUID orderId = createOrder();
    }

    private UUID createOrder() {
        if (log.isInfoEnabled()) log.info("Placing a new order with two products");
        Product mobilePhone = new Product(UUID.randomUUID(), BigDecimal.valueOf(200), "mobile");
        Product razor = new Product(UUID.randomUUID(), BigDecimal.valueOf(50), "razor");
        if (log.isInfoEnabled()) log.info("Creating order with mobile phone");
        UUID orderId = orderService.createOrder(mobilePhone);
        if (log.isInfoEnabled()) log.info("Adding a razor to the order");
        orderService.addProduct(orderId, razor);
        return orderId;
    }

}
