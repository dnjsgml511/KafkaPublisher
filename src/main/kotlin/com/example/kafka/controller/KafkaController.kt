package com.example.kafka.controller

import com.example.kafka.publisher.KafkaMessagePublisher
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception


@RestController
@RequestMapping("/producer-app")
class KafkaController(
    private val publisher: KafkaMessagePublisher
) {

    @GetMapping("/publish/{message}")
    fun publishMessage(@PathVariable message: String): ResponseEntity<Any>{

        return try {
            for(i: Int in 1..10000){
                publisher.sendMessageToTopic("$message : $i" )
            }
            ResponseEntity.ok("message published successfully ..")
        }catch (ex: Exception){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

}