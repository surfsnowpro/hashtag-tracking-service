package com.codespring.trackinghashtagservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class TrackingHashtagServiceApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(TrackingHashtagServiceApplication::class.java, *args)
        }
    }
}