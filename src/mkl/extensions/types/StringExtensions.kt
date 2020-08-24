@file:Suppress("NOTHING_TO_INLINE")

package mkl.extensions.types

import mkl.global.utils.randomIndex
import mkl.global.variables.lineSeperator

fun String.splitLines() = split(lineSeperator)
fun String.remove(substring: String) = replace(substring, "")

fun String.replaceLast(oldValue: String, newValue: String,ignoreCase: Boolean = false): String {
    val lastIndex = this.lastIndexOf(oldValue)
    if (lastIndex < 0) return this
    val tail = this.substring(lastIndex).replaceFirst(oldValue.toRegex(), newValue)
    return this.substring(0, lastIndex) + tail
}

fun String.doBreak(times: Int = 1): String {
    require(times > 0)
    var breaks = ""
    for (i in 1..times)
        breaks += lineSeperator

    return this + breaks
}

fun String.surrounded(string: String) = string + this + string

fun String.shuffled(): String {
    if (this.countUniqeChars() <= 1) {
        println("Shuffle Error: " + this.quoted())
        return this
    }

    var wort = this
    var shuffleWord = ""

    while (wort.isNotEmpty()) {
        val index = randomIndex(wort.length)
        shuffleWord += wort[index]
        wort = wort.removeCharAt(index)
    }

    if (this == shuffleWord)// Seltener Fall das trotz shuffle gleiches Wort rauskommt
        return this.shuffled()
    else
        return shuffleWord
}

fun CharSequence.containsWhitespace(): Boolean {
    if (this.isEmpty())
        return false

    forEach { c ->
        if (Character.isWhitespace(c)) {
            return true
        }
    }
    return false
}

fun String.countUniqeChars() = this.toCharArray().distinct().size

fun String.quoted(): String = "'$this'"
fun String.doubleQuoted(): String = "\"" + this + "\""

fun String.removeCharAt(index: Int) = this.removeRange(index, index + 1)