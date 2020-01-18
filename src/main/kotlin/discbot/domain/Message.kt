package discbot.domain

import java.time.Instant

data class Message(val author: String, val content: String, val date: Instant)