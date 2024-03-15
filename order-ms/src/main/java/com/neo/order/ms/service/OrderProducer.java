package com.neo.order.ms.service;

import com.neo.order.ms.dto.CustomerOrder;
import com.neo.order.ms.dto.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    //send to kafka topic to be consumed by payment service
    public void produce(CustomerOrder customerOrder){
        //create order event to publish. will be consumed by payment ms
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(customerOrder);
        orderEvent.setType("ORDER_CREATED");
        kafkaTemplate.send("new-orders",orderEvent);
    }
}
