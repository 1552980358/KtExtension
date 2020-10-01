package lib.github1552980358.ktExtension.jvm.lang

import java.io.File

/**
 * Execute command without calling [Runtime.getRuntime().exec]
 **/
@Suppress("unused")
fun execCmd(cmd: String) = Runtime.getRuntime().exec(cmd)

@Suppress("unused")
fun execCmd(array: Array<String>) = Runtime.getRuntime().exec(array)

@Suppress("unused")
fun execCmd(cmd: String, array: Array<String>) = Runtime.getRuntime().exec(cmd, array)

@Suppress("unused")
fun execCmd(array1: Array<String>, array2: Array<String>) = Runtime.getRuntime().exec(array1, array2)

@Suppress("unused")
fun execCmd(array1: Array<String>, array2: Array<String>, file: File) = Runtime.getRuntime().exec(array1, array2, file)

@Suppress("unused")
fun execCmd(cmd: String, array: Array<String>, file: File) = Runtime.getRuntime().exec(cmd, array, file)