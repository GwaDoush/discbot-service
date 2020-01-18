package discbot.infrastructure.config

import discbot.infrastructure.DiscordClient
import discbot.port.MessageHandler
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.AsyncTaskExecutor
import java.time.Clock
import javax.annotation.PostConstruct

@Configuration
class DiscordSetup(private val taskExecutor: AsyncTaskExecutor, private val messageHandler: MessageHandler) {

    @Value("\${discord.token}")
    private lateinit var token: String

    @PostConstruct
    fun launchDiscordClient() {
        taskExecutor.execute { DiscordClient(token, messageHandler, Clock.systemUTC()).start().login().block() }

    }
}
