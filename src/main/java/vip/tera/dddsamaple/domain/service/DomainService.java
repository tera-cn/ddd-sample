package vip.tera.dddsamaple.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vip.tera.dddsamaple.domain.DomainEvent;
import vip.tera.dddsamaple.infrastructure.repository.mysql.AggregateRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
public class DomainService {

    private final ApplicationEventPublisher eventPublisher;
    private final AggregateRepository repository;

    public DomainService(AggregateRepository repository, ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    /**
     * 3.1、在service中实现领域事件发布
     * @param entityId
     */
    @Transactional
    public void serviceDomainOperation(long entityId) {
        repository.findById(entityId)
                .ifPresent(entity -> {
                    entity.domainOperation();
                    repository.save(entity);
                    eventPublisher.publishEvent(new DomainEvent());
                });
    }

    @Async
    @EventListener
    public void test(DomainEvent domainEvent) throws InterruptedException {
        log.error("Cool, I got a domainEvent: {}", domainEvent);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            log.error("wait {}", i);
        }
    }

}
