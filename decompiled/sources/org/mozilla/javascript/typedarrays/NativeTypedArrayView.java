package org.mozilla.javascript.typedarrays;

import com.paytm.pgsdk.Constants;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ExternalArrayData;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeArrayIterator;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Symbol;
import org.mozilla.javascript.SymbolKey;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
public abstract class NativeTypedArrayView<T> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData {
    private static final int Id_BYTES_PER_ELEMENT = 11;
    private static final int Id_constructor = 1;
    private static final int Id_get = 2;
    private static final int Id_length = 10;
    private static final int Id_set = 3;
    private static final int Id_subarray = 4;
    private static final int MAX_INSTANCE_ID = 11;
    protected static final int MAX_PROTOTYPE_ID = 5;
    private static final int SymbolId_iterator = 5;
    protected final int length;

    protected abstract NativeTypedArrayView construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2);

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
    }

    public abstract int getBytesPerElement();

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 11;
    }

    protected abstract Object js_get(int i);

    protected abstract Object js_set(int i, Object obj);

    protected abstract NativeTypedArrayView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject);

    protected NativeTypedArrayView() {
        this.length = 0;
    }

    protected NativeTypedArrayView(NativeArrayBuffer nativeArrayBuffer, int i, int i2, int i3) {
        super(nativeArrayBuffer, i, i3);
        this.length = i2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return js_get(i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i > 0 && i < this.length;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        js_set(i, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = Integer.valueOf(i);
        }
        return objArr;
    }

    protected boolean checkIndex(int i) {
        return i < 0 || i >= this.length;
    }

    private NativeArrayBuffer makeArrayBuffer(Context context, Scriptable scriptable, int i) {
        return (NativeArrayBuffer) context.newObject(scriptable, NativeArrayBuffer.CLASS_NAME, new Object[]{Integer.valueOf(i)});
    }

    private NativeTypedArrayView js_constructor(Context context, Scriptable scriptable, Object[] objArr) {
        int length;
        if (!isArg(objArr, 0)) {
            return construct(NativeArrayBuffer.EMPTY_BUFFER, 0, 0);
        }
        Object obj = objArr[0];
        if ((obj instanceof Number) || (obj instanceof String)) {
            int int32 = ScriptRuntime.toInt32(obj);
            return construct(makeArrayBuffer(context, scriptable, getBytesPerElement() * int32), 0, int32);
        }
        if (obj instanceof NativeTypedArrayView) {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            NativeTypedArrayView nativeTypedArrayViewConstruct = construct(makeArrayBuffer(context, scriptable, nativeTypedArrayView.length * getBytesPerElement()), 0, nativeTypedArrayView.length);
            while (int32 < nativeTypedArrayView.length) {
                nativeTypedArrayViewConstruct.js_set(int32, nativeTypedArrayView.js_get(int32));
                int32++;
            }
            return nativeTypedArrayViewConstruct;
        }
        if (obj instanceof NativeArrayBuffer) {
            NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
            int32 = isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0;
            if (isArg(objArr, 2)) {
                length = ScriptRuntime.toInt32(objArr[2]) * getBytesPerElement();
            } else {
                length = nativeArrayBuffer.getLength() - int32;
            }
            if (int32 < 0 || int32 > nativeArrayBuffer.buffer.length) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            }
            if (length < 0 || int32 + length > nativeArrayBuffer.buffer.length) {
                throw ScriptRuntime.constructError("RangeError", "length out of range");
            }
            if (int32 % getBytesPerElement() != 0) {
                throw ScriptRuntime.constructError("RangeError", "offset must be a multiple of the byte size");
            }
            if (length % getBytesPerElement() != 0) {
                throw ScriptRuntime.constructError("RangeError", "offset and buffer must be a multiple of the byte size");
            }
            return construct(nativeArrayBuffer, int32, length / getBytesPerElement());
        }
        if (obj instanceof NativeArray) {
            List list = (List) obj;
            NativeTypedArrayView nativeTypedArrayViewConstruct2 = construct(makeArrayBuffer(context, scriptable, list.size() * getBytesPerElement()), 0, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                nativeTypedArrayViewConstruct2.js_set(int32, it.next());
                int32++;
            }
            return nativeTypedArrayViewConstruct2;
        }
        throw ScriptRuntime.constructError(Constants.EVENT_ACTION_ERROR, "invalid argument");
    }

    private void setRange(NativeTypedArrayView nativeTypedArrayView, int i) {
        int i2 = this.length;
        if (i >= i2) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        if (nativeTypedArrayView.length > i2 - i) {
            throw ScriptRuntime.constructError("RangeError", "source array too long");
        }
        int i3 = 0;
        if (nativeTypedArrayView.arrayBuffer == this.arrayBuffer) {
            Object[] objArr = new Object[nativeTypedArrayView.length];
            for (int i4 = 0; i4 < nativeTypedArrayView.length; i4++) {
                objArr[i4] = nativeTypedArrayView.js_get(i4);
            }
            while (i3 < nativeTypedArrayView.length) {
                js_set(i3 + i, objArr[i3]);
                i3++;
            }
            return;
        }
        while (i3 < nativeTypedArrayView.length) {
            js_set(i3 + i, nativeTypedArrayView.js_get(i3));
            i3++;
        }
    }

    private void setRange(NativeArray nativeArray, int i) {
        if (i > this.length) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        }
        if (nativeArray.size() + i > this.length) {
            throw ScriptRuntime.constructError("RangeError", "offset + length out of range");
        }
        Iterator it = nativeArray.iterator();
        while (it.hasNext()) {
            js_set(i, it.next());
            i++;
        }
    }

    private Object js_subarray(Context context, Scriptable scriptable, int i, int i2) {
        if (i < 0) {
            i += this.length;
        }
        if (i2 < 0) {
            i2 += this.length;
        }
        int iMax = Math.max(0, i);
        int iMax2 = Math.max(0, Math.min(this.length, i2) - iMax);
        return context.newObject(scriptable, getClassName(), new Object[]{this.arrayBuffer, Integer.valueOf(Math.min(iMax * getBytesPerElement(), this.arrayBuffer.getLength())), Integer.valueOf(iMax2)});
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            return js_constructor(context, scriptable, objArr);
        }
        if (iMethodId == 2) {
            if (objArr.length > 0) {
                return realThis(scriptable2, idFunctionObject).js_get(ScriptRuntime.toInt32(objArr[0]));
            }
            throw ScriptRuntime.constructError(Constants.EVENT_ACTION_ERROR, "invalid arguments");
        }
        if (iMethodId != 3) {
            if (iMethodId != 4) {
                if (iMethodId == 5) {
                    return new NativeArrayIterator(scriptable, scriptable2);
                }
                throw new IllegalArgumentException(String.valueOf(iMethodId));
            }
            if (objArr.length > 0) {
                NativeTypedArrayView nativeTypedArrayViewRealThis = realThis(scriptable2, idFunctionObject);
                return nativeTypedArrayViewRealThis.js_subarray(context, scriptable, ScriptRuntime.toInt32(objArr[0]), isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : nativeTypedArrayViewRealThis.length);
            }
            throw ScriptRuntime.constructError(Constants.EVENT_ACTION_ERROR, "invalid arguments");
        }
        if (objArr.length > 0) {
            NativeTypedArrayView nativeTypedArrayViewRealThis2 = realThis(scriptable2, idFunctionObject);
            Object obj = objArr[0];
            if (obj instanceof NativeTypedArrayView) {
                nativeTypedArrayViewRealThis2.setRange((NativeTypedArrayView) objArr[0], isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                return Undefined.instance;
            }
            if (obj instanceof NativeArray) {
                nativeTypedArrayViewRealThis2.setRange((NativeArray) objArr[0], isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                return Undefined.instance;
            }
            if (obj instanceof Scriptable) {
                return Undefined.instance;
            }
            if (isArg(objArr, 2)) {
                return nativeTypedArrayViewRealThis2.js_set(ScriptRuntime.toInt32(objArr[0]), objArr[1]);
            }
        }
        throw ScriptRuntime.constructError(Constants.EVENT_ACTION_ERROR, "invalid arguments");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        if (i == 5) {
            initPrototypeMethod(getClassName(), i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        if (i == 1) {
            str = "constructor";
        } else if (i == 2) {
            str = "get";
        } else {
            if (i == 3) {
                str3 = "set";
            } else if (i == 4) {
                str3 = "subarray";
            } else {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            str2 = str3;
            i2 = 2;
            initPrototypeMethod(getClassName(), i, str2, (String) null, i2);
        }
        i2 = 1;
        str2 = str;
        initPrototypeMethod(getClassName(), i, str2, (String) null, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 5 : 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 1;
        if (length == 3) {
            char cCharAt = str.charAt(0);
            if (cCharAt == 'g') {
                if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                    return 2;
                }
            } else if (cCharAt == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else {
            if (length == 8) {
                str2 = "subarray";
                i = 4;
            } else if (length == 11) {
                str2 = "constructor";
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                return i;
            }
            return 0;
        }
        str2 = null;
        i = 0;
        if (str2 != null) {
        }
        return i;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.put("BYTES_PER_ELEMENT", idFunctionObject, ScriptRuntime.wrapInt(getBytesPerElement()));
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 10) {
            return Range.ATTR_LENGTH;
        }
        if (i == 11) {
            return "BYTES_PER_ELEMENT";
        }
        return super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        if (i == 10) {
            return ScriptRuntime.wrapInt(this.length);
        }
        if (i == 11) {
            return ScriptRuntime.wrapInt(getBytesPerElement());
        }
        return super.getInstanceIdValue(i);
    }

    @Override // org.mozilla.javascript.typedarrays.NativeArrayBufferView, org.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 6) {
            str2 = Range.ATTR_LENGTH;
            i = 10;
        } else if (length == 17) {
            str2 = "BYTES_PER_ELEMENT";
            i = 11;
        } else {
            str2 = null;
            i = 0;
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        return instanceIdInfo(5, i2);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public Object getArrayElement(int i) {
        return js_get(i);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public void setArrayElement(int i, Object obj) {
        js_set(i, obj);
    }

    @Override // org.mozilla.javascript.ExternalArrayData
    public int getArrayLength() {
        return this.length;
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        return this.length;
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = js_get(i);
        }
        return objArr;
    }

    @Override // java.util.List, java.util.Collection
    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < this.length) {
            uArr = (U[]) ((Object[]) Array.newInstance(uArr.getClass().getComponentType(), this.length));
        }
        for (int i = 0; i < this.length; i++) {
            try {
                uArr[i] = js_get(i);
            } catch (ClassCastException unused) {
                throw new ArrayStoreException();
            }
        }
        return uArr;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        try {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            if (this.length != nativeTypedArrayView.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if (!js_get(i).equals(nativeTypedArrayView.js_get(i))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.length; i++) {
            iHashCode += js_get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return new NativeTypedArrayIterator(this, i);
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
}
