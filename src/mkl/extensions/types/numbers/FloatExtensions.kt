package mkl.extensions.types.numbers

fun Float.roundToFixedDigits(digits: Int): Float = toDouble().roundToFixedDigits(digits).toFloat()