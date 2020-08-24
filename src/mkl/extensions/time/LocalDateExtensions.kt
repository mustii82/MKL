package mkl.extensions.time

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.format(pattern: String) = this.format(DateTimeFormatter.ofPattern(pattern))
