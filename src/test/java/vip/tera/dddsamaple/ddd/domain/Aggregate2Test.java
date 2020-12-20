package vip.tera.dddsamaple.ddd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import vip.tera.dddsamaple.ddd.TestEventHandler;
import vip.tera.dddsamaple.domain.Aggregate2;
import vip.tera.dddsamaple.domain.DomainEvent;
import vip.tera.dddsamaple.infrastructure.repository.mysql.Aggregate2Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class Aggregate2Test {

    @Autowired
    Aggregate2Repository repository;

    @MockBean
    private TestEventHandler eventHandler;

    /**
     * 3、测试使用DomainEvents注解
     */
    @DisplayName("given aggregate with @DomainEvents,"
            + " when do domain operation and save,"
            + " then event is published")
    @Test
    void domainEvents() {

        // given
        Aggregate2 aggregate = new Aggregate2();

        // when
        aggregate.domainOperation();
        repository.save(aggregate);

        // then
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));
    }

    @DisplayName("given aggregate with @AfterDomainEventPublication,"
            + " when do domain operation and save twice,"
            + " then an event is published only for the first time")
    @Test
    void afterDomainEvents() {

        // given
        Aggregate2 aggregate = new Aggregate2();

        // when
        aggregate.domainOperation();
        repository.save(aggregate);
        repository.save(aggregate);

        // then
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));
    }

}