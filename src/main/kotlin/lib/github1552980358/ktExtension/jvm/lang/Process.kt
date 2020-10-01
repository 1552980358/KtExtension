package lib.github1552980358.ktExtension.jvm.lang

import lib.github1552980358.ktExtension.jvm.keyword.tryCatch

/**
 * Write [command] and press enter
 **/
@Suppress("unused")
fun Process.writeCommand(command: String) = apply {
    outputStream.bufferedWriter().apply {
        write(command)
        newLine()
    }
}

/**
 * Writes [command] and press enter
 **/
@Suppress("unused")
fun Process.writeCommands(commands: List<String>) = apply {
    outputStream.bufferedWriter().apply {
        commands.forEach { command ->
            write(command)
            newLine()
        }
    }
}

/**
 * Complete and close the [OutputStream] from [Process]
 **/
@Suppress("unused")
fun Process.commandEnd() = apply {
    tryCatch { outputStream?.flush() }
    tryCatch { outputStream?.close() }
}

/**
 * Get the output of the [Process]
 **/
@Suppress("unused")
fun Process.getCommandOutputLines(): List<String>? {
    var lines: List<String>? = null
    try {
        inputStream?.use { inputStream ->
            try {
                inputStream.bufferedReader().use { bufferedReader ->
                    try {
                        lines = bufferedReader.readLines()
                    } catch (e: Exception) {  }
                }
            } catch (e: Exception) {  }
        }
    } catch (e: Exception) {  }
    return lines
}