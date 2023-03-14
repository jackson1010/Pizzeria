package TFIP.Test1.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import TFIP.Test1.Model.AddressModel;
import TFIP.Test1.Model.Order;
import TFIP.Test1.Model.PizzaModel;




@Repository
public class PizzaRepo {
    @Autowired
    RedisTemplate<String, String> redisTemplate;


    public void saveOrder(AddressModel addressModel, PizzaModel pizzaModel ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String orderJson = objectMapper.writeValueAsString(new Order(addressModel, pizzaModel));

        redisTemplate.opsForValue().set("order:" + addressModel.getId(), orderJson);

    }

}
