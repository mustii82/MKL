package mkl.extensions.time

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.format(pattern: String) = this.format(DateTimeFormatter.ofPattern(pattern))
