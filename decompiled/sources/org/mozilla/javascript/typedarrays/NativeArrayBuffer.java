package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
public class NativeArrayBuffer extends IdScriptableObject {
    public static final String CLASS_NAME = "ArrayBuffer";
    private static final int ConstructorId_isView = -3;
    private static final byte[] EMPTY_BUF = new byte[0];
    public static final NativeArrayBuffer EMPTY_BUFFER = new NativeArrayBuffer();
    private static final int Id_byteLength = 1;
    private static final int Id_constructor = 1;
    private static final int Id_isView = 3;
    private static final int Id_slice = 2;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final long serialVersionUID = 3110411773054879549L;
    final byte[] buffer;

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 1;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeArrayBuffer().exportAsJSClass(3, scriptable, z);
    }

    public NativeArrayBuffer() {
        this.buffer = EMPTY_BUF;
    }

    public NativeArrayBuffer(int i) {
        if (i < 0) {
            throw ScriptRuntime.constructError("RangeError", "Negative array length " + i);
        }
        if (i == 0) {
            this.buffer = EMPTY_BUF;
        } else {
            this.buffer = new byte[i];
        }
    }

    public int getLength() {
        return this.buffer.length;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public NativeArrayBuffer slice(int i, int i2) {
        byte[] bArr = this.buffer;
        int length = bArr.length;
        if (i2 < 0) {
            i2 += bArr.length;
        }
        int iMax = Math.max(0, Math.min(length, i2));
        if (i < 0) {
            i += this.buffer.length;
        }
        int iMin = Math.min(iMax, Math.max(0, i));
        int i3 = iMax - iMin;
        NativeArrayBuffer nativeArrayBuffer = new NativeArrayBuffer(i3);
        System.arraycopy(this.buffer, iMin, nativeArrayBuffer.buffer, 0, i3);
        return nativeArrayBuffer;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CLASS_NAME)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == -3) {
            return Boolean.valueOf(isArg(objArr, 0) && (objArr[0] instanceof NativeArrayBufferView));
        }
        if (iMethodId == 1) {
            return new NativeArrayBuffer(isArg(objArr, 0) ? ScriptRuntime.toInt32(objArr[0]) : 0);
        }
        if (iMethodId == 2) {
            NativeArrayBuffer nativeArrayBufferRealThis = realThis(scriptable2, idFunctionObject);
            return nativeArrayBufferRealThis.slice(isArg(objArr, 0) ? ScriptRuntime.toInt32(objArr[0]) : 0, isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : nativeArrayBufferRealThis.buffer.length);
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    private static NativeArrayBuffer realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof NativeArrayBuffer)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (NativeArrayBuffer) scriptable;
    }

    private static boolean isArg(Object[] objArr, int i) {
        return objArr.length > i && !Undefined.instance.equals(objArr[i]);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        if (i == 1) {
            str = "constructor";
        } else if (i == 2) {
            str = "slice";
        } else {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(CLASS_NAME, i, str, 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 5) {
            str2 = "slice";
            i = 2;
        } else if (length == 6) {
            str2 = "isView";
            i = 3;
        } else if (length == 11) {
            str2 = "constructor";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, CLASS_NAME, -3, "isView", 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 1) {
            return "byteLength";
        }
        return super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.wrapInt(this.buffer.length);
        }
        return super.getInstanceIdValue(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        if ("byteLength".equals(str)) {
            return instanceIdInfo(5, 1);
        }
        return super.findInstanceIdInfo(str);
    }
}
