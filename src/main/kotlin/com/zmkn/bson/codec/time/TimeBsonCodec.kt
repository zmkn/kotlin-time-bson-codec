package com.zmkn.bson.codec.time

import com.zmkn.bson.codec.time.codecs.InstantCodec
import org.bson.codecs.Codec

object TimeBsonCodec {
    val instantCodec = {
        InstantCodec()
    }

    val all: List<Codec<*>> by lazy {
        generateCodec(
            instantCodec,
        )
    }

    fun generateCodec(vararg codecs: () -> Codec<*>): List<Codec<*>> {
        return codecs.map {
            it()
        }
    }
}
