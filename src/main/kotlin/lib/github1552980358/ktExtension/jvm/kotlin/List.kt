package lib.github1552980358.ktExtension.jvm.kotlin

/**
 * Copy List
 **/
fun <T> List<T>.copy() = listOf(this).toMutableList()

/**
 * Copy a new [MutableList] and [shuffle] content elements
 **/
@Suppress("unused")
fun <T> List<T>.copyAndShuffle() = copy().apply { shuffle() }