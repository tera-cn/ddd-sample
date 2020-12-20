package vip.tera.dddsamaple.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.tera.dddsamaple.domain.DomainOrderService;
import vip.tera.dddsamaple.domain.OrderRepository;
import vip.tera.dddsamaple.domain.OrderService;
import vip.tera.dddsamaple.infrastructure.repository.mongo.MongoDbOrderRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderService orderService(final MongoDbOrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }

}
