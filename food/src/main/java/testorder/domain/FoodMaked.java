package testorder.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import testorder.domain.*;
import testorder.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FoodMaked extends AbstractEvent {

    private Long id;
    private String name;
    private List<Long> materialId;

    public FoodMaked(Food aggregate) {
        super(aggregate);
    }

    public FoodMaked() {
        super();
    }
}
//>>> DDD / Domain Event
