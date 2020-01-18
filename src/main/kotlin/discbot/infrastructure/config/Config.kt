package discbot.infrastructure.config

import discbot.domain.DefaultMessageHandler
import discbot.infrastructure.MessageInMemoryRepository
import discbot.port.MessageHandler
import discbot.port.MessageRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    fun messageHandler(messageRepository: MessageRepository) : MessageHandler = DefaultMessageHandler(messageRepository)

    @Bean
    fun messageRepository() : MessageRepository = MessageInMemoryRepository()

}
