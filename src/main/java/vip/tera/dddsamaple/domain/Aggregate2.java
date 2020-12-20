package vip.tera.dddsamaple.domain;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Aggregate2 {

    @Transient
    private final Collection<DomainEvent> domainEvents;

    @Id
    @GeneratedValue
    private long id;

    public Aggregate2() {
        domainEvents = new ArrayList<>();
    }

    // ...
    public void domainOperation() {
        // some domain operation
        // 添加DomainEvents
        domainEvents.add(new DomainEvent());
    }

    // 3、使用DomainEvents注解
    @DomainEvents
    public Collection<DomainEvent> events() {
        return domainEvents;
    }

    @AfterDomainEventPublication
    public void clearEvents() {
        domainEvents.clear();
    }

}
