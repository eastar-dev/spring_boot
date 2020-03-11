package dev.eastar.mvc

import dev.eastar.mvc.account.Account
import dev.eastar.mvc.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Component

@Component
class RedisRunner : ApplicationRunner {
    @Autowired
    lateinit var redisTemplates: StringRedisTemplate

    @Autowired
    lateinit var accountRepository: AccountRepository


    override fun run(args: ApplicationArguments?) {
        val values: ValueOperations<String, String> = redisTemplates.opsForValue()
        values["name"] = "eastar"
        values["version"] = "1.0.1"
        values["hello"] = "world"


        val account : Account = Account( username = "eastar" ,email =  "eastar@mail.com")
        accountRepository.save(account)

        val result  = accountRepository.findById(account.id)
        println(result.get().email)
        println(result.get().username)

    }
}


