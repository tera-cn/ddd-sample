package vip.tera.dddsamaple.infrastructure.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import vip.tera.dddsamaple.domain.Aggregate;

public interface AggregateRepository extends CrudRepository<Aggregate, Long>  {

}
