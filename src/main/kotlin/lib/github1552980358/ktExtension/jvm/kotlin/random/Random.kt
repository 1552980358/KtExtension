package lib.github1552980358.ktExtension.jvm.kotlin.random

/**
 * Get random value from [start] to [end]
 **/
@Suppress("unused")
fun random(start: Int, end: Int) = (start .. end).random()

@Suppress("unused")
fun random(start: Long, end: Long) = (start .. end).random()

@Suppress("unused")
fun random(start: Char, end: Char) = (start .. end).random()

/**
 * Get random or null value from [start] to [end]
 **/
@Suppress("unused")
fun randomOrNull(start: Int, end: Int) = (start .. end).randomOrNull()

@Suppress("unused")
fun randomOrNull(start: Long, end: Long) = (start .. end).randomOrNull()

@Suppress("unused")
fun randomOrNull(start: Char, end: Char) = (start .. end).randomOrNull()