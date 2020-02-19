package dev.eastar.mvc.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
public open class UserController {

    @GetMapping("hello")
    fun hello(): String = "hello?"

    @PostMapping("/users/create")
    fun create(@RequestBody user: User): User {
        return user
    }


}

data class User(var id: Long,
                var username: String,
                var password: String)


