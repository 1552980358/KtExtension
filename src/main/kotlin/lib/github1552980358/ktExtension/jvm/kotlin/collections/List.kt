package lib.github1552980358.ktExtension.jvm.kotlin.collections

/**
 * Copy List
 **/
fun <T> List<T>.copy() = listOf(this).toMutableList()

/**
 * Copy a new [MutableList] and [shuffle] content elements
 **/
@Suppress("unused")
fun <T> List<T>.copyAndShuffle() = copy().apply { shuffle() }

fun <charSequence: CharSequence> List<charSequence>.joinTogether() = joinToString(separator = "")