package discbot.infrastructure

import discbot.domain.Message
import discbot.port.MessageRepository

class MessageInMemoryRepository : MessageRepository {
    private var messages: Set<Message> = emptySet()

    override fun findMessages(): Set<Message> = messages

    override fun addMessage(message: Message) {
        messages = messages.plus(message)
    }
}