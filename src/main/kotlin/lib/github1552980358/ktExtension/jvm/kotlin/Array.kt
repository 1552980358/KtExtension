package lib.github1552980358.ktExtension.jvm.kotlin

import java.lang.IllegalArgumentException
import java.util.Collections

/**
 * Swap element of index [i] and [j]
 * Same function as [Collections.swap]
 **/
@Suppress("unused")
fun <T> Array<T>.swap(i: Int, j: Int) {
    if (i == j) {
        // Do Nothing
        return
    }
    if (i < 0 || i >= size) {
        throw Exception("Out of range: Location $i, ArraySize: $size")
    }
    if (j < 0 || j >= size) {
        throw Exception("Out of range: Location $j, ArraySize: $size")
    }
    
    this[i].also { tmp ->
        this[i] = this[j]
        this[j] = tmp
    }
}

/**
 * Move element of index [i] into index [j]
 **/
@Suppress("unused")
fun <T> Array<T>.moveAndShift(i: Int, j: Int) {
    if (i == j) {
        return
    }
    if (i < 0 || i >= size) {
        throw IllegalArgumentException("Out of range: Location $i, ArraySize: $size")
    }
    if (j < 0 || j >= size) {
        throw IllegalArgumentException("Out of range: Location $j, ArraySize: $size")
    }
    
    // Shifting
    if (i > j) {
        this[i].also { temp ->
            for (index in j until i) {
                this[index + 1] = this[index]
            }
            this[j] = temp
        }
        return
    }
    
    this[i].also { temp ->
        for (index in i until j) {
            this[index] = this[index + 1]
        }
        this[j] = temp
    }
}

/**
 * Add [component] into the array and return a new array
 **/
@Suppress("unused")
inline fun <reified T> Array<T>.add(component: T) =
    toMutableList()
        .apply { add(component) }
        .toTypedArray()

/**
 * Add [components] into the array and return a new array
 **/
@Suppress("unused")
inline fun <reified T> Array<T>.add(vararg components: T) =
    toMutableList()
        .apply { components.forEach { component -> add(component) } }
        .toTypedArray()

/**
 * Add [componentsArray] into the array and return a new array
 **/
@Suppress("unused")
inline fun <reified T> Array<T>.add(vararg componentsArray: Array<T>) =
    toMutableList().apply {
        componentsArray.forEach { outer -> outer.forEach { inner -> add(inner) } }
    }.toTypedArray()