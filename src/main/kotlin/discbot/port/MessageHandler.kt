package discbot.port

import discbot.domain.Message

interface MessageHandler {
    fun handle(message: Message)
}