package discbot.infrastructure

import discbot.domain.Message
import discbot.port.MessageHandler
import discord4j.core.DiscordClient
import discord4j.core.DiscordClientBuilder
import discord4j.core.event.domain.message.MessageCreateEvent
import java.time.Clock

class DiscordClient(private val token: String, private val messageHandler: MessageHandler, private val clock: Clock) {

    fun start(): DiscordClient {
        val client = DiscordClientBuilder(token).build()

        client.eventDispatcher.on(MessageCreateEvent::class.java)
                .subscribe { message -> handleMessage(message) }

        return client
    }

    private fun handleMessage(payload: MessageCreateEvent) {
        val message = payload.message
        if (message.author.isPresent && message.content.isPresent) {
            messageHandler.handle(
                    Message(
                            author = message.author.get().username,
                            content = message.content.get(),
                            date = clock.instant()
                    )
            )

        }
    }

}