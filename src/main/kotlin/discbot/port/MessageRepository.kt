package discbot.port

import discbot.domain.Message

interface MessageRepository {
    fun findMessages(): Set<Message>
    fun addMessage(message: Message)
}