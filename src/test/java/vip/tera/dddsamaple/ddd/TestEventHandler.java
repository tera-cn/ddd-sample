package vip.tera.dddsamaple.ddd;

import org.springframework.context.event.EventListener;
import vip.tera.dddsamaple.domain.DomainEvent;

public interface TestEventHandler {

    @EventListener
    void handleEvent(DomainEvent event);

}
