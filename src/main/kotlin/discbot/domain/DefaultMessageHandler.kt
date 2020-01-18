package discbot.domain

import discbot.port.MessageHandler
import discbot.port.MessageRepository

class DefaultMessageHandler(private val messageRepository: MessageRepository) : MessageHandler {
    override fun handle(message: Message) {
        messageRepository.addMessage(message)
        println(message)
    }
}