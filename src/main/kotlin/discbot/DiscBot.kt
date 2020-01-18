package discbot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class DiscBot

fun main(args: Array<String>) {
    SpringApplication.run(DiscBot::class.java, *args)
}
