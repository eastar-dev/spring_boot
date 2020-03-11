package dev.eastar.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import org.springframework.web.client.getForObject
import org.springframework.web.reactive.function.client.WebClient

@Component
class RestRunner : ApplicationRunner {

    @Autowired
    lateinit var restTemplateBuilder: RestTemplateBuilder

    override fun run(args: ApplicationArguments?) {
        val restTemplate = restTemplateBuilder.build()
        val stopWatch: StopWatch = StopWatch()
        stopWatch.start()

        val helloResult: String = restTemplate.getForObject("http://localhost:8080/hello")
        println(helloResult)

        val worldResult: String = restTemplate.getForObject("http://localhost:8080/world")
        println(worldResult)

        stopWatch.stop()
        println(stopWatch.prettyPrint())

    }
}


@Component
class RestRunner2 : ApplicationRunner {

    @Autowired
    lateinit var builder: WebClient.Builder

    override fun run(args: ApplicationArguments?) {
        val webClient = builder.build()
        val stopWatch: StopWatch = StopWatch()
        stopWatch.start()

        val helloMono = webClient.get().uri("http://localhost:8080/hello")
                .retrieve()
                .bodyToMono(String::class.java)

        helloMono.subscribe {
            println(it)
            if(stopWatch.isRunning)
                stopWatch.stop()
            println(stopWatch.prettyPrint())
            stopWatch.start()
        }

        val worldMono = webClient.get().uri("http://localhost:8080/world")
                .retrieve()
                .bodyToMono(String::class.java)

        worldMono.subscribe {
            println(it)
            if(stopWatch.isRunning)
                stopWatch.stop()
            println(stopWatch.prettyPrint())
            stopWatch.start()
        }
    }
}