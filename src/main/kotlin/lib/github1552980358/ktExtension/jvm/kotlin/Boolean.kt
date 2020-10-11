package lib.github1552980358.ktExtension.jvm.kotlin

/**
 * Check whether [Boolean] variable is null or not
 **/
@Suppress("unused")
fun Boolean?.isNull() = this == null

/**
 * Check whether [Boolean] variable is null or false
 **/
@Suppress("unused")
fun Boolean?.isNullOrFalse() = this == null || this == false