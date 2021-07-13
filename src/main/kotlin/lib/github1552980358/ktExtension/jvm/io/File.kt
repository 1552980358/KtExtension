package lib.github1552980358.ktExtension.jvm.io

import lib.github1552980358.ktExtension.jvm.keyword.tryCatch
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

/**
 * Check whether [File] is empty
 **/
val File.isEmpty get() = length() == 0L

/**
 * Check whether [File] is null or empty
 **/
@Suppress("unused")
val File?.isNullOrEmpty get() = this == null || isEmpty

/**
 * Write [Any]? class into [File]
 *
 * It is warned that [Serializable] interface should be implemented
 **/
fun File.writeObject(obj: Any?) {
    if (exists()) {
        delete()
    }
    createNewFile()
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
val File.readObject get(): Any? = inputStream().readObject

/**
 * Read Object from [File]
 * null will be returned if [File] does not exist or exception thrown
 * Nullable Any will be returned if no exception found
 **/
val File.readObjectSafe get(): Any? {
    if (!exists()) {
        return null
    }
    if (length() == 0L) {
        return null
    }
    var temp: Any? = null
    tryCatch { temp = readObject }
    return temp
}

/**
 * Read Object from [File] as [T]?
 * Exceptions will be thrown by [ObjectInputStream] if some exception is found
 * or thrown if casting failed
 **/
fun <T> File.readObjectAs(): T? = inputStream().readObjectAs()

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
        temp = readObjectAs()
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
