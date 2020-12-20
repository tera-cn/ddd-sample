package vip.tera.dddsamaple.infrastructure.configuration;

import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import vip.tera.dddsamaple.infrastructure.repository.cassandra.SpringDataCassandraOrderRepository;

@EnableCassandraRepositories(basePackageClasses = SpringDataCassandraOrderRepository.class)
public class CassandraConfiguration {

}