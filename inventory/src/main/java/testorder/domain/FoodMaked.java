package testorder.domain;

import java.util.*;
import lombok.*;
import testorder.domain.*;
import testorder.infra.AbstractEvent;

@Data
@ToString
public class FoodMaked extends AbstractEvent {

    private Long id;
    private String name;
    private Object materialId;
}
