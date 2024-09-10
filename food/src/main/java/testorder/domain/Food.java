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
        
        repository().findAllById(orderPlaced.getFoodId()).forEach(food-> {
            FoodMaked foodMaked = new FoodMaked();
            foodMaked.setId(food.getId());
            foodMaked.setMaterialId(food.materialId);
            foodMaked.setName(food.getName());
            foodMaked.publishAfterCommit();   
        }); 
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
