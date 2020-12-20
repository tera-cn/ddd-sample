package vip.tera.dddsamaple.infrastructure.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.tera.dddsamaple.domain.Order;
import vip.tera.dddsamaple.domain.OrderRepository;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoDbOrderRepository implements OrderRepository {

    private SpringDataMongoOrderRepository orderRepository;

    @Autowired
    public MongoDbOrderRepository(SpringDataMongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
