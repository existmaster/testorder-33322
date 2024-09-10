package testorder.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import testorder.config.kafka.KafkaProcessor;
import testorder.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodMaked'"
    )
    public void wheneverFoodMaked_DecreaseInventory(
        @Payload FoodMaked foodMaked
    ) {
        FoodMaked event = foodMaked;
        System.out.println(
            "\n\n##### listener DecreaseInventory : " + foodMaked + "\n\n"
        );

        // Sample Logic //
        Inventory.decreaseInventory(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
