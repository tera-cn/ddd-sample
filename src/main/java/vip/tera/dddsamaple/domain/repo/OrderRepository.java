package vip.tera.dddsamaple.domain.repo;

import vip.tera.dddsamaple.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<Order> findById(UUID id);

    void save(Order order);

}
