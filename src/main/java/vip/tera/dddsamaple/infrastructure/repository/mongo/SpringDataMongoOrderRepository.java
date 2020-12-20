package vip.tera.dddsamaple.infrastructure.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vip.tera.dddsamaple.domain.Order;

import java.util.UUID;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {

}
