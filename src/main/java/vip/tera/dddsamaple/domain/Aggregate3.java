package vip.tera.dddsamaple.domain;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 4、使用AbstractAggregateRoot聚合根模版
 */
@Entity
public class Aggregate3 extends AbstractAggregateRoot {

    @Id
    @GeneratedValue
    private long id;

    public void domainOperation() {
        // some domain operation
        // 注册领域事件
        registerEvent(new DomainEvent());
    }

}
