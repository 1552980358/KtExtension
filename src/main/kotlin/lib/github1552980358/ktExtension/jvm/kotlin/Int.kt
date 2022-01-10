package lib.github1552980358.ktExtension.jvm.kotlin

fun Int.pow(power: Int): Int {
    var tmp = 1
    repeat(power) {
        tmp *= this
    }
    return tmp
}