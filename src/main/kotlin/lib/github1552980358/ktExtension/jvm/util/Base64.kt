package lib.github1552980358.ktExtension.jvm.util

import java.util.Base64

/**
 * Decode raw [Base64] content [String] into [String]
 **/
fun String.decodeBase64() = String(Base64.getDecoder().decode(this))

/**
 * Encode message [String] content [String] into Base64 [ByteArray]
 **/
fun String.encodeBase64() = Base64.getEncoder().encode(toByteArray())

/**
 * Encode [ByteArray] content [String] into Base64 [ByteArray]
 **/
fun ByteArray.encodeBase64() = Base64.getEncoder().encode(this)