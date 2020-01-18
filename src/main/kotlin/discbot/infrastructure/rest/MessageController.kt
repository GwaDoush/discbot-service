package discbot.infrastructure.rest

import discbot.domain.Message
import discbot.port.MessageRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping(path = ["/messages"])
class MessageController(private val messageRepository: MessageRepository) {

    @RequestMapping(path = ["/all"], method = [RequestMethod.GET])
    fun getMessages() = messageRepository.findMessages().map { message -> MessageView.from(message) }

}

data class MessageView(val author: String, val content: String, val date: Instant) {
    companion object {
        fun from(message: Message) = MessageView(
                message.author,
                message.content,
                message.date
        )
    }
}
