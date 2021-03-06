package lib.github1552980358.ktExtension.jvm.io

import lib.github1552980358.ktExtension.jvm.keyword.tryCatch
import java.io.BufferedWriter
import java.io.OutputStream

/**
 * Flush and close after complete [block], use as [apply]
 **/
@Suppress("unused")
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
@Suppress("unused")
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
@Suppress("unused")
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

@Suppress("unused")
inline fun OutputStream.applyAsBufferedWriter(block: BufferedWriter.() -> Unit) =
    osApply {
        bufferedWriter().use { bufferedWriter ->
            block(bufferedWriter)
            bufferedWriter.flush()
        }
    }

@Suppress("unused")
inline fun <R> OutputStream.runAsBufferedWriter(block: BufferedWriter.() -> R): R =
    try {
        bufferedWriter().use { bufferedWriter ->
            val value = block(bufferedWriter)
            bufferedWriter.flush()
            return value
        }
    } catch (e: Exception) {
        throw e
    } finally {
        tryCatch { flush() }
        tryCatch { close() }
    }

/**
 * Extension allows writing [String] directly without manually converting into [ByteArray]
 **/
fun OutputStream.write(string: String) = write(string.toByteArray())

/**
 * Write data to stream wrapped with [tryCatch]
 **/
fun OutputStream.tryWrite(string: String) = tryCatch { write(string) }

fun OutputStream.tryWrite(byteArray: ByteArray) = tryCatch { write(byteArray) }

fun OutputStream.tryWrite(byteArray: ByteArray, off: Int, len: Int) = tryCatch { write(byteArray, off, len) }

/**
 * [OutputStream.flush] and [OutputStream.close] after writing to the stream
 **/
fun OutputStream.writeAndClose(string: String) = osApply { write(string) }

fun OutputStream.writeAndClose(byteArray: ByteArray) = osApply { write(byteArray) }

fun OutputStream.writeAndClose(byteArray: ByteArray, off: Int, len: Int) = osApply { write(byteArray, off, len) }
