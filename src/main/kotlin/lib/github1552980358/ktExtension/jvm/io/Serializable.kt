@file:Suppress("unused")

package lib.github1552980358.ktExtension.jvm.io

import java.io.File
import java.io.Serializable

fun Serializable.outputTo(file: File) = file.writeObject(this)

fun Serializable.outputTo(path: String) = File(path).writeObject(this)

fun Serializable.outputTo(dir: String, name: String) = File(dir, name).writeObject(this)

fun Serializable.outputTo(dir: File, name: String) = File(dir, name).writeObject(this)
