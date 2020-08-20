@file:Suppress("unused")

package lib.github1552980358.ktExtension.jvm.kotlin

/**
 * Call [block] when the object is null,
 * so that manually checking of null (if (this==null) {  } )
 * is not required
 *
 * It can be work with [apply], [let], [also], etc.
 *
 * Example:
 * [Any Object].nullDo {
 *     /** Action when null **/
 * }?.apply {
 *     /** Action when not null **/
 * }
 */
fun <T> T?.nullDo(block: () -> Unit): T? {
    if (this==null) {
        block()
    }
    return this
}