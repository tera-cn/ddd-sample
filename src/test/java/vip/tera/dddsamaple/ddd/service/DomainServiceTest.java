package vip.tera.dddsamaple.ddd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import vip.tera.dddsamaple.domain.DomainEvent;
import vip.tera.dddsamaple.ddd.TestEventHandler;
import vip.tera.dddsamaple.domain.Aggregate;
import vip.tera.dddsamaple.domain.service.DomainService;
import vip.tera.dddsamaple.infrastructure.repository.mysql.AggregateRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringJUnitConfig
@SpringBootTest
class DomainServiceTest {

    @Autowired
    private DomainService domainService;

    @MockBean
    private TestEventHandler eventHandler;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private AggregateRepository aggregateRepository;

    // @formatter:off
    @DisplayName("given existing aggregate,"
            + " when do domain operation directly on aggregate,"
            + " then domain event is NOT published")
    // @formatter:on
    @Test
    void aggregateEventsTest() {
        Aggregate existingDomainEntity = new Aggregate(0, eventPublisher);
        existingDomainEntity.domainOperation();
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));
//        repository.save(existingDomainEntity);

        // when
        aggregateRepository.findById(existingDomainEntity.getId())
                .get()
                .domainOperation();

        // then
        verifyNoMoreInteractions(eventHandler);

        existingDomainEntity.domainOperation();
        verify(eventHandler, times(2)).handleEvent(any(DomainEvent.class));
    }

    @BeforeEach
    void beforeEach() {
        aggregateRepository.deleteAll();
    }

    /**
     * 3.1、测试在service中实现领域事件发布
     */
    // @formatter:off
    @DisplayName("given existing aggregate,"
            + " when do domain operation on service,"
            + " then domain event is published")
    // @formatter:on
    @Test
    void serviceEventsTest() {
        Aggregate existingDomainEntity = new Aggregate(1, null);
        aggregateRepository.save(existingDomainEntity);

        // when
        domainService.serviceDomainOperation(existingDomainEntity.getId());

        // then
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));
    }

//    @TestConfiguration
//    public static class TestConfig {
//        @Bean
//        public DomainService domainService(AggregateRepository repository, ApplicationEventPublisher eventPublisher) {
//            return new DomainService(repository, eventPublisher);
//        }
//    }
}