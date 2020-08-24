@file:Suppress("NOTHING_TO_INLINE")

package mkl.extensions

// To force exhaustive on when operator
val <T> T.exhaustive: T
    get() = this