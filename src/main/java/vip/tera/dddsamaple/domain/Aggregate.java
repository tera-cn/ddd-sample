package vip.tera.dddsamaple.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Slf4j
@Data
@Entity
public class Aggregate {

    @Transient
    private ApplicationEventPublisher eventPublisher;
    @Id
    private long id;

    private Aggregate() {
    }

    public Aggregate(long id, ApplicationEventPublisher eventPublisher) {
        this.id = id;
        this.eventPublisher = eventPublisher;
    }

    public void domainOperation() {
        // some business logic
        log.error("eventPublisher: {}", eventPublisher);
        if (eventPublisher != null) {
            eventPublisher.publishEvent(new DomainEvent());
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DomainEntity [id=" + id + "]";
    }
}
