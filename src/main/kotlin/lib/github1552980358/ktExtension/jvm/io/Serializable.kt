package lib.github1552980358.ktExtension.jvm.io

import java.io.File
import java.io.Serializable

@Suppress("unused")
fun Serializable.outputTo(file: File) = file.writeObject(this)

@Suppress("unused")
fun Serializable.outputTo(path: String) = File(path).writeObject(this)

@Suppress("unused")
fun Serializable.outputTo(dir: String, name: String) = File(dir, name).writeObject(this)

@Suppress("unused")
fun Serializable.outputTo(dir: File, name: String) = File(dir, name).writeObject(this)
