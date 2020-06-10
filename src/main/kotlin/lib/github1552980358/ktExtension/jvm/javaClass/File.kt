@file:Suppress("unused")

package lib.github1552980358.ktExtension.jvm.javaClass

import lib.github1552980358.ktExtension.jvm.javaKeyword.tryCatch
import lib.github1552980358.ktExtension.jvm.stream.osApply
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

/**
 * [File]
 * @author  : 1552980328
 * @since   : 0.1
 * @date    : 2020/6/5
 * @time    : 10:12
 **/

/**
 * Write [Any] class into [File]
 *
 * It is warned that [Serializable] interface should be implemented
 **/
fun File.writeObject(obj: Any) {
    outputStream().osApply {
        ObjectOutputStream(this).osApply {
            @Suppress("unused")
            (this as ObjectOutputStream).writeObject(obj)
        }
    }
}

/**
 * Read Object from [File] as [Any]?
 * Exceptions will be thrown by [ObjectInputStream] if some exception is found
 **/
fun File.readObject(): Any? {
    var temp: Any?
    inputStream().use { `is` ->
        ObjectInputStream(`is`).use { ois ->
            temp = ois.readObject()
        }
    }
    return temp
}

/**
 * Read Object from [File]
 * null will be returned if [File] does not exist or exception thrown
 * Nullable Any will be returned if no exception found
 **/
fun File.readObjectSafe(): Any? {
    if (!exists()) {
        return null
    }
    if (length() == 0L) {
        return null
    }
    var temp: Any? = null
    tryCatch { temp = readObject() }
    return temp
}

/**
 * Read Object from [File] as [T]?
 * Exceptions will be thrown by [ObjectInputStream] if some exception is found
 * or thrown if casting failed
 **/
fun <T> File.readObjectAs(): T? {
    @Suppress("UNCHECKED_CAST")
    return readObject() as T?
}

/**
 * Read Object and try casting as [T]
 * null will be returned if casting is not success,
 * Exception thrown by ObjectInputStream,
 * [File] does not exists or
 * [File] is empty
 **/
fun <T> File.readObjectSafeAs(): T? {
    if (!exists()) {
        return null
    }
    if (length() == 0L) {
        return null
    }
    var temp: T? = null
    tryCatch {
        @Suppress("UNCHECKED_CAST")
        temp = readObject() as T?
    }
    return temp
}

/**
 * Rename file into [name] within the same directory
 * No path is required to provide
 **/
fun File.renameAs(name: String) = renameTo(File(this.parent, name))

/**
 * Move [File] into [file]
 * Full path should be specified
 *
 * Return 0 if full processes success
 * Return 1 if copy process failed
 * Return 2 if exception found during deletion process
 * Return 3 if deletion process failed
 * Return 4 when unknown error
 **/
fun File.moveTo(file: File): Int {
    try {
        copyTo(file)
    } catch (e: Exception) {
        e.printStackTrace()
        return 1
    }
    if (file.exists() && file.length() == length()) {
        try {
            delete()
        } catch (e: Exception) {
            e.printStackTrace()
            return 2
        }
        if (!exists()) {
            return 3
        }
        return 0
    }
    return 4
}

fun File.moveTo(absolutePath: String) = moveTo(File(absolutePath))

fun File.moveTo(dir: String, name: String) = moveTo(File(dir, name))

fun File.moveTo(dir: File, name: String) = moveTo(File(dir, name))
