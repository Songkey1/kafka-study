package com.songkey.kotlinbackend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class KafkaProducerService {
    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(topic: String, message: String) {
        kafkaTemplate.send(topic, message)
    }

    fun sendMessage(topic: String, key: String, message: String) {
        kafkaTemplate.send(topic, key, message)
    }
}
