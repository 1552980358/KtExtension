@file:Suppress("unused")

package lib.github1552980358.ktExtension.jvm.kotlin.random

/**
 * Get random value from [start] to [end]
 **/
fun random(start: Int, end: Int) = (start .. end).random()

fun random(start: Long, end: Long) = (start .. end).random()

fun random(start: Char, end: Char) = (start .. end).random()

/**
 * Get random or null value from [start] to [end]
 **/
fun randomOrNull(start: Int, end: Int) = (start .. end).randomOrNull()

fun randomOrNull(start: Long, end: Long) = (start .. end).randomOrNull()

fun randomOrNull(start: Char, end: Char) = (start .. end).randomOrNull()