package com.example.kafka.enum

enum class KafkaEnum(private val topicName: String) {
    SAMPLE_TOPIC("sample-topic");

    fun getValue(): String{
        return topicName;
    }
}