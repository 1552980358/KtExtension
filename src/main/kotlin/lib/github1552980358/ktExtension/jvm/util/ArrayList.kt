@file:Suppress("unused")

package lib.github1552980358.ktExtension.jvm.util

import java.util.Collections

/**
 * Copy all elements of an arrayList
 **/
fun <T> ArrayList<T>.copy() = ArrayList<T>().also { arrayList ->
    this.forEach { origin -> arrayList.add(origin) }
}

/**
 * Quick call of [Collections.swap]
 **/
fun <T> ArrayList<T>.swap(i: Int, j: Int) {
    Collections.swap(this, i, j)
}

/**
 * Copy a new [ArrayList] and [shuffle] content elements
 **/
fun <T> ArrayList<T>.copyAndShuffle() = copy().apply { shuffle() }

/**
 * Move element of index [i] into index [j]
 **/
fun <T> ArrayList<T>.moveAndShift(i: Int, j: Int) = add(j, removeAt(i))

/**
 * Advanced searching method for [String]
 **/
fun ArrayList<String>.binSearch(value: String, sort: Boolean = false): Int {
    if (sort) sort()
    
    var first = 0
    var last = lastIndex
    var mid = lastIndex / 2
    
    while ((this[mid] > value || this[mid] < value) || first > last) {
        if (this[mid] > value) {
            last = mid
        } else if (this[mid] < value) {
            first = mid
        }
        mid = (first + last) / 2
    }
    
    return if (this[mid] == value) mid else -1
}

/**
 * Advanced searching method for [Char]
 **/
fun ArrayList<Char>.binSearch(value: Char, sort: Boolean = false): Int {
    if (sort) sort()
    
    var first = 0
    var last = lastIndex
    var mid = lastIndex / 2
    
    while ((this[mid] > value || this[mid] < value) || first > last) {
        if (this[mid] > value) {
            last = mid
        } else if (this[mid] < value) {
            first = mid
        }
        mid = (first + last) / 2
    }
    
    return if (this[mid] == value) mid else -1
}

/**
 * Advanced searching method for [Int]
 **/
fun ArrayList<Int>.binSearch(value: Int, sort: Boolean = false): Int {
    if (sort) sort()
    
    var first = 0
    var last = lastIndex
    var mid = lastIndex / 2
    
    while ((this[mid] > value || this[mid] < value) || first > last) {
        if (this[mid] > value) {
            last = mid
        } else if (this[mid] < value) {
            first = mid
        }
        mid = (first + last) / 2
    }
    
    return if (this[mid] == value) mid else -1
}

/**
 * Advanced searching method for [Long]
 **/
fun ArrayList<Long>.binSearch(value: Long, sort: Boolean = false): Int {
    if (sort) sort()
    
    var first = 0
    var last = lastIndex
    var mid = lastIndex / 2
    
    while ((this[mid] > value || this[mid] < value) || first > last) {
        if (this[mid] > value) {
            last = mid
        } else if (this[mid] < value) {
            first = mid
        }
        mid = (first + last) / 2
    }
    
    return if (this[mid] == value) mid else -1
}

/**
 * Advanced searching method for [Float]
 **/
fun ArrayList<Float>.binSearch(value: Float, sort: Boolean = false): Int {
    if (sort) sort()
    
    var first = 0
    var last = lastIndex
    var mid = lastIndex / 2
    
    while ((this[mid] > value || this[mid] < value) || first > last) {
        if (this[mid] > value) {
            last = mid
        } else if (this[mid] < value) {
            first = mid
        }
        mid = (first + last) / 2
    }
    
    return if (this[mid] == value) mid else -1
}

/**
 * Advanced searching method for [Double]
 **/
fun ArrayList<Double>.binSearch(value: Double, sort: Boolean = false): Int {
    if (sort) sort()
    
    var first = 0
    var last = lastIndex
    var mid = lastIndex / 2
    
    while ((this[mid] > value || this[mid] < value) || first > last) {
        if (this[mid] > value) {
            last = mid
        } else if (this[mid] < value) {
            first = mid
        }
        mid = (first + last) / 2
    }
    
    return if (this[mid] == value) mid else -1
}