package testorder.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import testorder.FoodApplication;
import testorder.domain.FoodMaked;

@Entity
@Table(name = "Food_table")
@Data
//<<< DDD / Aggregate Root
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection
    private List<Long> materialId;

    @PostPersist
    public void onPostPersist() {
        FoodMaked foodMaked = new FoodMaked(this);
        foodMaked.publishAfterCommit();
    }

    public static FoodRepository repository() {
        FoodRepository foodRepository = FoodApplication.applicationContext.getBean(
            FoodRepository.class
        );
        return foodRepository;
    }

    //<<< Clean Arch / Port Method
    public static void makeFood(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Food food = new Food();
        repository().save(food);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(food->{
            
            food // do something
            repository().save(food);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
