package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
public class NativeDataView extends NativeArrayBufferView {
    public static final String CLASS_NAME = "DataView";
    private static final int Id_constructor = 1;
    private static final int Id_getFloat32 = 8;
    private static final int Id_getFloat64 = 9;
    private static final int Id_getInt16 = 4;
    private static final int Id_getInt32 = 6;
    private static final int Id_getInt8 = 2;
    private static final int Id_getUint16 = 5;
    private static final int Id_getUint32 = 7;
    private static final int Id_getUint8 = 3;
    private static final int Id_setFloat32 = 16;
    private static final int Id_setFloat64 = 17;
    private static final int Id_setInt16 = 12;
    private static final int Id_setInt32 = 14;
    private static final int Id_setInt8 = 10;
    private static final int Id_setUint16 = 13;
    private static final int Id_setUint32 = 15;
    private static final int Id_setUint8 = 11;
    private static final int MAX_PROTOTYPE_ID = 17;
    private static final long serialVersionUID = 1427967607557438968L;

    public NativeDataView() {
    }

    public NativeDataView(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeDataView().exportAsJSClass(17, scriptable, z);
    }

    private void rangeCheck(int i, int i2) {
        if (i < 0 || i + i2 > this.byteLength) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
    }

    private void checkOffset(Object[] objArr, int i) {
        if (objArr.length <= i) {
            throw ScriptRuntime.constructError("TypeError", "missing required offset parameter");
        }
        if (Undefined.instance.equals(objArr[i])) {
            throw ScriptRuntime.constructError("RangeError", "invalid offset");
        }
    }

    private void checkValue(Object[] objArr, int i) {
        if (objArr.length <= i) {
            throw ScriptRuntime.constructError("TypeError", "missing required value parameter");
        }
        if (Undefined.instance.equals(objArr[i])) {
            throw ScriptRuntime.constructError("RangeError", "invalid value parameter");
        }
    }

    private static NativeDataView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof NativeDataView)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (NativeDataView) scriptable;
    }

    private NativeDataView js_constructor(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        if (i2 < 0) {
            throw ScriptRuntime.constructError("RangeError", "length out of range");
        }
        if (i < 0 || i + i2 > nativeArrayBuffer.getLength()) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        return new NativeDataView(nativeArrayBuffer, i, i2);
    }

    private Object js_getInt(int i, boolean z, Object[] objArr) {
        boolean z2 = false;
        checkOffset(objArr, 0);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1])) {
            z2 = true;
        }
        if (i == 1) {
            byte[] bArr = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt8(bArr, this.offset + int32) : ByteIo.readUint8(bArr, this.offset + int32);
        }
        if (i == 2) {
            byte[] bArr2 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt16(bArr2, this.offset + int32, z2) : ByteIo.readUint16(bArr2, this.offset + int32, z2);
        }
        if (i == 4) {
            byte[] bArr3 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt32(bArr3, this.offset + int32, z2) : ByteIo.readUint32(bArr3, this.offset + int32, z2);
        }
        throw new AssertionError();
    }

    private Object js_getFloat(int i, Object[] objArr) {
        boolean z = false;
        checkOffset(objArr, 0);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1])) {
            z = true;
        }
        if (i == 4) {
            return ByteIo.readFloat32(this.arrayBuffer.buffer, this.offset + int32, z);
        }
        if (i == 8) {
            return ByteIo.readFloat64(this.arrayBuffer.buffer, this.offset + int32, z);
        }
        throw new AssertionError();
    }

    private void js_setInt(int i, boolean z, Object[] objArr) {
        boolean z2 = false;
        checkOffset(objArr, 0);
        checkValue(objArr, 1);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2])) {
            z2 = true;
        }
        if (i == 1) {
            if (z) {
                ByteIo.writeInt8(this.arrayBuffer.buffer, this.offset + int32, Conversions.toInt8(objArr[1]));
                return;
            } else {
                ByteIo.writeUint8(this.arrayBuffer.buffer, this.offset + int32, Conversions.toUint8(objArr[1]));
                return;
            }
        }
        if (i == 2) {
            if (z) {
                ByteIo.writeInt16(this.arrayBuffer.buffer, this.offset + int32, Conversions.toInt16(objArr[1]), z2);
                return;
            } else {
                ByteIo.writeUint16(this.arrayBuffer.buffer, this.offset + int32, Conversions.toUint16(objArr[1]), z2);
                return;
            }
        }
        if (i != 4) {
            throw new AssertionError();
        }
        if (z) {
            ByteIo.writeInt32(this.arrayBuffer.buffer, this.offset + int32, Conversions.toInt32(objArr[1]), z2);
        } else {
            ByteIo.writeUint32(this.arrayBuffer.buffer, this.offset + int32, Conversions.toUint32(objArr[1]), z2);
        }
    }

    private void js_setFloat(int i, Object[] objArr) {
        boolean z = false;
        checkOffset(objArr, 0);
        checkValue(objArr, 1);
        int int32 = ScriptRuntime.toInt32(objArr[0]);
        rangeCheck(int32, i);
        if (isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2])) {
            z = true;
        }
        double number = ScriptRuntime.toNumber(objArr[1]);
        if (i == 4) {
            ByteIo.writeFloat32(this.arrayBuffer.buffer, this.offset + int32, number, z);
        } else {
            if (i == 8) {
                ByteIo.writeFloat64(this.arrayBuffer.buffer, this.offset + int32, number, z);
                return;
            }
            throw new AssertionError();
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                if (isArg(objArr, 0)) {
                    Object obj = objArr[0];
                    if (obj instanceof NativeArrayBuffer) {
                        NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
                        int int32 = isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0;
                        return js_constructor(nativeArrayBuffer, int32, isArg(objArr, 2) ? ScriptRuntime.toInt32(objArr[2]) : nativeArrayBuffer.getLength() - int32);
                    }
                }
                throw ScriptRuntime.constructError("TypeError", "Missing parameters");
            case 2:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, true, objArr);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, false, objArr);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, true, objArr);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, false, objArr);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, true, objArr);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, false, objArr);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_getFloat(4, objArr);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getFloat(8, objArr);
            case 10:
                realThis(scriptable2, idFunctionObject).js_setInt(1, true, objArr);
                return Undefined.instance;
            case 11:
                realThis(scriptable2, idFunctionObject).js_setInt(1, false, objArr);
                return Undefined.instance;
            case 12:
                realThis(scriptable2, idFunctionObject).js_setInt(2, true, objArr);
                return Undefined.instance;
            case 13:
                realThis(scriptable2, idFunctionObject).js_setInt(2, false, objArr);
                return Undefined.instance;
            case 14:
                realThis(scriptable2, idFunctionObject).js_setInt(4, true, objArr);
                return Undefined.instance;
            case 15:
                realThis(scriptable2, idFunctionObject).js_setInt(4, false, objArr);
                return Undefined.instance;
            case 16:
                realThis(scriptable2, idFunctionObject).js_setFloat(4, objArr);
                return Undefined.instance;
            case 17:
                realThis(scriptable2, idFunctionObject).js_setFloat(8, objArr);
                return Undefined.instance;
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        switch (i) {
            case 1:
                str = "constructor";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 2:
                str = "getInt8";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 3:
                str = "getUint8";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 4:
                str = "getInt16";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 5:
                str = "getUint16";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 6:
                str = "getInt32";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 7:
                str = "getUint32";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 8:
                str = "getFloat32";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 9:
                str = "getFloat64";
                str2 = str;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 10:
                str2 = "setInt8";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 11:
                str2 = "setUint8";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 12:
                str2 = "setInt16";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 13:
                str2 = "setUint16";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 14:
                str2 = "setInt32";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 15:
                str2 = "setUint32";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 16:
                str2 = "setFloat32";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            case 17:
                str2 = "setFloat64";
                initPrototypeMethod(getClassName(), i, str2, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.typedarrays.NativeDataView.findPrototypeId(java.lang.String):int");
    }
}
