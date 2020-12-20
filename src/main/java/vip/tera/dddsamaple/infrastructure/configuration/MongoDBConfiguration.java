package vip.tera.dddsamaple.infrastructure.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import vip.tera.dddsamaple.infrastructure.repository.mongo.SpringDataMongoOrderRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOrderRepository.class)
public class MongoDBConfiguration {

}