package testorder.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import testorder.OrderApplication;
import testorder.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<Long> foodId;

    private String userName;

    private Long userId;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void order() {
        //implement business logic here:

        testorder.external.GetUserQuery getUserQuery = new testorder.external.GetUserQuery();
        OrderApplication.applicationContext
            .getBean(testorder.external.UserService.class)
            .getUser(getUserQuery);
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
