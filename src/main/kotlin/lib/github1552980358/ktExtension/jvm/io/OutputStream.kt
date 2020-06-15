package lib.github1552980358.ktExtension.jvm.io

import lib.github1552980358.ktExtension.jvm.keyword.tryCatch
import java.io.OutputStream

/**
 * Flush and close after complete [block], use as [apply]
 **/
inline fun OutputStream.osApply(block: OutputStream.() -> Unit) = this.apply {
    try {
        block(this)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        tryCatch { flush() }
        tryCatch { close() }
    }
}

/**
 * Flush and close after complete [block], use as [run]
 **/
inline fun <R> OutputStream.osRun(block: OutputStream.() -> R): R {
    try {
        return block(this)
    } catch (e: Exception) {
        throw e
    } finally {
        tryCatch { flush() }
        tryCatch { close() }
    }
}

/**
 * Close after [block] is processed
 **/
inline fun OutputStream.osUse(block: OutputStream.() -> Unit) {
    try {
        block(this)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}