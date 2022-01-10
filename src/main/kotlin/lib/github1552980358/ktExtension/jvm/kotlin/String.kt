package lib.github1552980358.ktExtension.jvm.kotlin

class IllegalFormatException(message: String): IllegalArgumentException(message)

/**
 * Check whether the [String] is hex string
 *
 * @return [Boolean]
 **/
val String.isHexStr get(): Boolean {
    repeat(length) { index ->
        if (this[index] !in '0' .. '9' && this[index] !in 'A' .. 'F' && this[index] !in 'a' .. 'f') {
            return false
        }
    }
    return true
}

/**
 * Convert hex contented [String] into [Int]
 *
 * @throws IllegalFormatException
 * @return [Int]
 **/
val String.hexStrToInt: Int get() {
    var tmp = 0
    repeat(length) { index ->
        tmp += when {
            this[index] in '0' .. '9' -> {
                (this[index].code - 48) * (16).pow(lastIndex - index)
            }
            this[index] in 'A' .. 'F' -> {
                (this[index].code - 55) * (16).pow(lastIndex - index)
            }
            this[index] in 'a' .. 'f' -> {
                (this[index].code - 87) * (16).pow(lastIndex - index)
            }
            else -> throw IllegalFormatException("Unknown character: ${this[index]}")
        }
    }
    return tmp
}