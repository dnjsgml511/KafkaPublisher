package com.example.kafka.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateFormatting(date: LocalDateTime) {

    val dateTime: String

    init {
        val fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        dateTime = date.format(fmt)
    }
}