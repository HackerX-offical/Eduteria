package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
public class NativeUint32Array extends NativeTypedArrayView<Long> {
    private static final int BYTES_PER_ELEMENT = 4;
    private static final String CLASS_NAME = "Uint32Array";
    private static final long serialVersionUID = -7987831421954144244L;

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 4;
    }

    public NativeUint32Array() {
    }

    public NativeUint32Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 4);
    }

    public NativeUint32Array(int i) {
        this(new NativeArrayBuffer(i * 4), 0, i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint32Array().exportAsJSClass(5, scriptable, z);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected NativeTypedArrayView construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint32Array(nativeArrayBuffer, i, i2);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected NativeTypedArrayView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof NativeUint32Array)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (NativeUint32Array) scriptable;
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_get(int i) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        return ByteIo.readUint32(this.arrayBuffer.buffer, (i * 4) + this.offset, false);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, (i * 4) + this.offset, Conversions.toUint32(obj), false);
        return null;
    }

    @Override // java.util.List
    public Long get(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long) js_get(i);
    }

    @Override // java.util.List
    public Long set(int i, Long l) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Long) js_set(i, l);
    }
}
