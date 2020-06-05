package lib.github1552980358.ktExtension.jvm.stream

import lib.github1552980358.ktExtension.jvm.javaKeyword.tryCatch
import java.io.File
import java.io.OutputStream

/**
 * [OutputStream]
 * @author  : 1552980328
 * @since   : 0.1
 * @date    : 2020/6/5
 * @time    : 10:01
 **/

/**
 * flush and close after complete [block], use as [apply]
 **/
fun OutputStream.osApply(block: OutputStream.() -> Unit) = this.apply {
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
 * flush and close after complete [block], use as [run]
 **/
fun <R> OutputStream.osRun(block: OutputStream.() -> R): R {
    try {
        return block(this)
    } catch (e: Exception) {
        throw e
    } finally {
        tryCatch { flush() }
        tryCatch { close() }
    }
}
