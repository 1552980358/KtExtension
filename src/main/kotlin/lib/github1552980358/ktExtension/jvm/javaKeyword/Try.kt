package lib.github1552980358.ktExtension.jvm.javaKeyword

/**
 * [Try]
 * @author  : 1552980328
 * @since   :
 * @date    : 2020/6/5
 * @time    : 9:44
 **/

/**
 * Try [block] without writing
 * catch (e: Exception) { ... }
 *
 * Return true if complete
 * Return fail if exception caught
 **/
inline fun tryCatch(block: () -> Unit) = try {
    block()
    true
} catch (e: Exception) {
    e.printStackTrace()
    false
}


/**
 * Try [block], usage look at [apply]
 **/
inline fun <T> T.tryApply(block: T.() -> Unit) = this.apply {
    tryCatch { block(this) }
}

/**
 * Try [block], usage look at [also]
 **/
inline fun <T> T.tryAlso(block: (T) -> Unit) = this.apply {
    tryCatch { block(this) }
}

/**
 * Try [block], usage look at [run]
 **/
inline fun <T, R> T.tryRun(block: T.() -> R): R = block(this)

