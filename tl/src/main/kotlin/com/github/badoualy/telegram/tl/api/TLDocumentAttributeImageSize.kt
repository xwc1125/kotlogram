package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * documentAttributeImageSize#6c37c15c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeImageSize() : TLAbsDocumentAttribute() {
    var w: Int = 0

    var h: Int = 0

    private val _constructor: String = "documentAttributeImageSize#6c37c15c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(w: Int, h: Int) : this() {
        this.w = w
        this.h = h
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(w)
        writeInt(h)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        w = readInt()
        h = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeImageSize) return false
        if (other === this) return true

        return w == other.w
                && h == other.h
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6c37c15c.toInt()
    }
}