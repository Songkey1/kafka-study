package com.songkey.kotlinbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(val kafkaProducerService: KafkaProducerService) {
    @GetMapping("/login")
    fun test2(@RequestParam msg: String): String {
        kafkaProducerService.sendMessage("songkey.test.logined", msg)
        return "ok"
    }
}
