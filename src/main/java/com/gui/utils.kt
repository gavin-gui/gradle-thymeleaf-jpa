package com.gui

import java.security.MessageDigest

/**
 * Created by gui on 2017/5/29.
 */
object Utils {
    fun md5(src: String) : String {
        val md = MessageDigest.getInstance("MD5")
        return hex(md.digest(src.toByteArray()))
    }

    fun hex(byteArray: ByteArray) : String {
        val buffer = StringBuffer()
        byteArray.forEach {
            buffer.append(Integer.toHexString((it.toInt() and 0xFF) or 0x100).substring(1,3))
        }
        return buffer.toString()
    }
}

fun String.md5() : String {
    return Utils.md5(this)
}

fun main(args: Array<String>) {
    println("123".md5())
}

