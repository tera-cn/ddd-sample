package vip.tera.dddsamaple.domain.service;

//import com.google.common.eventbus.EventBus;
import vip.tera.dddsamaple.domain.CustomerOrder;
import vip.tera.dddsamaple.domain.Product;

import java.util.UUID;

public class CustomerOrderService implements OrderService {

    public static final String EVENT_ORDER_READY_FOR_SHIPMENT = "OrderReadyForShipmentEvent";

//    private CustomerOrderRepository orderRepository;
//    private EventBus eventBus;

    public void placeOrder(CustomerOrder order) {
//        this.orderRepository.saveCustomerOrder(order);
//        Map<String, String> payload = new HashMap<>();
//        payload.put("order_id", String.valueOf(order.getOrderId()));
//        ApplicationEvent event = new ApplicationEvent(payload) {
//            @Override
//            public String getType() {
//                return EVENT_ORDER_READY_FOR_SHIPMENT;
//            }
//        };
//        this.eventBus.publish(event);
    }

    @Override
    public UUID createOrder(Product product) {
        return null;
    }

    @Override
    public void addProduct(UUID id, Product product) {

    }

    @Override
    public void completeOrder(UUID id) {

    }

    @Override
    public void deleteProduct(UUID id, UUID productId) {

    }
}
