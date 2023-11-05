package com.example.kafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaProducerConfig {

    @Bean
    fun createTopic(): NewTopic{
        return NewTopic("lwh-demo-3", 5, 1.toShort())
    }

}