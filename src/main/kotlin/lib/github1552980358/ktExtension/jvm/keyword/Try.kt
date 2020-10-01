package lib.github1552980358.ktExtension.jvm.keyword

/**
 * Try [block] without writing
 * catch (e: Exception) { ... }
 *
 * Return true if complete
 * Return fail if exception caught
 **/
@Suppress("unused")
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
@Suppress("unused")
inline fun <T> T.tryApply(block: T.() -> Unit) = this.apply {
    tryCatch { block(this) }
}

/**
 * Try [block], usage look at [also]
 **/
@Suppress("unused")
inline fun <T> T.tryAlso(block: (T) -> Unit) = this.apply {
    tryCatch { block(this) }
}

/**
 * Try [block], usage look at [run]
 **/
@Suppress("unused")
inline fun <T, R> T.tryRun(block: T.() -> R): R? =
    try { block(this) } catch (e: Exception) { null }

