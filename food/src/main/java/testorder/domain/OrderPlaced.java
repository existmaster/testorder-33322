package testorder.domain;

import java.util.*;
import lombok.*;
import testorder.domain.*;
import testorder.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Object foodId;
}
