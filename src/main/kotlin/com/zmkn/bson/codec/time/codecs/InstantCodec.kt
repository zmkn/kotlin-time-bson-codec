package com.zmkn.bson.codec.time.codecs

import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class InstantCodec : Codec<Instant> {
    override fun encode(writer: BsonWriter, value: Instant, encoderContext: EncoderContext) {
        writer.writeString(value.toString())
    }

    override fun getEncoderClass(): Class<Instant> {
        return Instant::class.java
    }

    override fun decode(reader: BsonReader, decoderContext: DecoderContext): Instant {
        return Instant.parse(reader.readString())
    }
}
