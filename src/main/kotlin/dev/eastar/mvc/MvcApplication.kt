package dev.eastar.mvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MvcApplication {
    @Bean
    fun webClientCustomizer(): WebClientCustomizer = WebClientCustomizer {
        it.baseUrl("http://localhost:8080")
    }

}

fun main(args: Array<String>) {
    runApplication<MvcApplication>(*args)
}
