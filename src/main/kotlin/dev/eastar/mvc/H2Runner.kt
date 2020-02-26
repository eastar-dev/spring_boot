package dev.eastar.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class H2Runner : ApplicationRunner {
    @Autowired
    lateinit var dataSource: DataSource

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    override fun run(args: ApplicationArguments?) {
        dataSource.connection.let {
            it.metaData.url
            it.metaData.userName

            val ststement = it.createStatement()
            val sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))"
            ststement.executeUpdate(sql)
        }

        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'eastar')")

    }


}