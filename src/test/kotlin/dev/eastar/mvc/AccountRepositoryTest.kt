package dev.eastar.mvc

import dev.eastar.mvc.account.Account
import dev.eastar.mvc.account.AccountRepository
import org.junit.jupiter.api.Test

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.junit4.SpringRunner
import javax.sql.DataSource

@RunWith(SpringRunner::class)
//@SpringBootTest
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    lateinit var dataSource: DataSource

    //@Autowired
    //lateinit var jdbcTemplate: JdbcTemplate

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun di() {
        println(dataSource.connection.metaData.url)
        println(dataSource.connection.metaData.driverName)
        println(dataSource.connection.metaData.driverVersion)

        val account = Account(username = "eastar", password = "pass" , email = "r@gamil.com")
        val newAccount = accountRepository.save(account)

        accountRepository.findByUsername(newAccount.username)

        //assert(accountRepository.findByUsername(newAccount.username)?.password == "pass")
        //assert(accountRepository.findByUsername("hello") == null)
    }
}