package vip.tera.dddsamaple.ddd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import vip.tera.dddsamaple.ddd.TestEventHandler;
import vip.tera.dddsamaple.domain.Aggregate;
import vip.tera.dddsamaple.infrastructure.repository.mysql.AggregateRepository;

import static org.mockito.Mockito.verifyNoInteractions;

@SpringBootTest
class AggregateTest {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    AggregateRepository repository;

    @MockBean
    private TestEventHandler eventHandler;

    /**
     * 2、测试，在聚合中发布领域事件，由于查询出来的对象没有eventPublisher，所以无法发布领域事件，需要通过Factory重建对象，并注入eventPublisher
     */
    @DisplayName("given existing aggregate,"
            + " when do domain operation directly on aggregate,"
            + " then domain event is NOT published")
    @Test
    void aggregateEventsTest() {
        Aggregate existingDomainEntity = new Aggregate(0, eventPublisher);
        repository.save(existingDomainEntity);

        // when
        repository.findById(existingDomainEntity.getId())
                .get()
                .domainOperation();

        // then
        verifyNoInteractions(eventHandler);
    }

}