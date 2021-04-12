package com.billy.controller;

import com.alibaba.fastjson.JSONObject;
import com.billy.kafka.KafkaParam;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer<String, String> customKafkaProducer;

    @Autowired
    private KafkaConsumer<String, String> customKafkaConsumer;

    @PostMapping("/produce")
    public void produce(@RequestBody KafkaParam params) {
        customKafkaProducer.send(new ProducerRecord<>("data", params.getKey(), params.getValue()));
    }

    @GetMapping("/consume")
    public void consume() {
        customKafkaConsumer.subscribe(Collections.singletonList("data"));
        while (true) {
            ConsumerRecords<String, String> msgList = customKafkaConsumer.poll(10);
            if (null != msgList && !msgList.isEmpty()) {
                msgList.forEach(System.out::println);
            }
        }
    }
}
