package lib.github1552980358.ktExtension.jvm.io

import java.io.InputStream
import java.io.ObjectInputStream

fun InputStream.readObject(): Any? {
    var temp: Any?
    use { `is` ->
        ObjectInputStream(`is`).use { ois ->
            temp = ois.readObject()
        }
    }
    return temp
}

fun <T> InputStream.readObjectAs(): T? {
    @Suppress("UNCHECKED_CAST")
    return readObject() as T?
}