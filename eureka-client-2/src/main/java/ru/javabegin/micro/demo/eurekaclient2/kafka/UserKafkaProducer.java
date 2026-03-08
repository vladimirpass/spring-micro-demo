package ru.javabegin.micro.demo.eurekaclient2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.javabegin.micro.demo.eurekaclient2.dto.UserNotificationDto;

@Service
public class UserKafkaProducer {

    private Logger log = LoggerFactory.getLogger(UserKafkaProducer.class);


    private KafkaTemplate<String, UserNotificationDto> kafkaTemplate;

    public UserKafkaProducer(KafkaTemplate<String, UserNotificationDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderToKafka(UserNotificationDto userNotificationDto){
        kafkaTemplate.send("users", userNotificationDto.getUserId(), userNotificationDto);
        log.info("Order sent to kafka: id={}", userNotificationDto.getUserId());

    }

}
