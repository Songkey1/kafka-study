package com.songkey.kotlinbackend

import org.apache.kafka.clients.consumer.ConsumerRecord

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaConsumerService {
    @KafkaListener(topics = ["songkey.test.logined"], groupId = "my-group")
    fun listen(record: ConsumerRecord<String?, String>) {
        println("Received Message: " + record.value())
    }
}
