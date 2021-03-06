package lib.github1552980358.ktExtension.jvm.io

import java.io.BufferedWriter

/**
 * Write [str] to [BufferedWriter] and return [BufferedWriter] object
 **/
@Suppress("unused")
fun BufferedWriter.writing(str: String) = apply {
    write(str)
}

/**
 * Write [str] to [BufferedWriter], press enter key
 * and return [BufferedWriter] object
 **/
@Suppress("unused")
fun BufferedWriter.writingLn(str: String) = apply {
    write(str)
    newLine()
}

/**
 * Write [commands] and press enter for each command
 **/
@Suppress("unused")
fun BufferedWriter.enterCommands(vararg commands: String) = apply {
    commands.forEach { command ->
        write(command)
        newLine()
    }
}