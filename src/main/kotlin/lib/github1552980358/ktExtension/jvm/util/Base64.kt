package lib.github1552980358.ktExtension.jvm.util

import java.util.Base64

/**
 * Decode raw [Base64] content [String] into [String]
 **/
val String.decodeBase64 get(): String? = String(Base64.getDecoder().decode(this))

/**
 * Encode message [String] content [String] into Base64 [ByteArray]
 **/
@Suppress("unused")
val String.encodeBase64 get(): ByteArray? = Base64.getEncoder().encode(toByteArray())

/**
 * Encode [ByteArray] content [String] into Base64 [ByteArray]
 **/
@Suppress("unused")
val ByteArray.encodeBase64 get(): ByteArray? = Base64.getEncoder().encode(this)