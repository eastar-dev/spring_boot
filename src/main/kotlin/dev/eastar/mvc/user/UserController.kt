package dev.eastar.mvc.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
public open class UserController {

    @GetMapping("hello")
    fun hello(): String = "hello?"


}

