package vip.tera.dddsamaple.domain.service;

import vip.tera.dddsamaple.domain.Product;

import java.util.UUID;

public interface OrderService extends ApplicationService {
    UUID createOrder(Product product);

    void addProduct(UUID id, Product product);

    void completeOrder(UUID id);

    void deleteProduct(UUID id, UUID productId);

}
