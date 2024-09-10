package testorder.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import testorder.domain.*;
import testorder.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private List<Long> foodId;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
