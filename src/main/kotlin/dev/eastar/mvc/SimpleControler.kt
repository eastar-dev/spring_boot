package dev.eastar.mvc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleControler {
    @GetMapping("/hello")
    fun hello(): String {
        Thread.sleep(5000L)
        return "hello"
    }

    @GetMapping("/world")
    fun world(): String {
        Thread.sleep(2000L)
        return "world"
    }
}