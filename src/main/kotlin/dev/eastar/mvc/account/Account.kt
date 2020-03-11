package dev.eastar.mvc.account

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("accounts")
data class Account(@Id var id: String = "",
                   var username: String,
                   var email: String

)