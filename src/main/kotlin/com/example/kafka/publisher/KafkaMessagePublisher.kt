package com.example.kafka.publisher

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class KafkaMessagePublisher(
    private val template: KafkaTemplate<String, Any>
) {

    fun sendMessageToTopic(message: String){
        val future: CompletableFuture<SendResult<String, Any>> = template.send("lwh-demo-3", message)

        future.whenComplete { result, ex ->
            if(ex == null){
                println("Sent message=[$message] with offset=[${result.recordMetadata.offset()}]")
            }else{
                println("Unable to send message=[$message] due to : ${ex.message}")
            }
        }

    }

}