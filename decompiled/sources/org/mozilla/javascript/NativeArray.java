package org.mozilla.javascript;

import androidx.collection.SieveCacheKt;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.mozilla.javascript.TopLevel;

/* JADX INFO: loaded from: classes10.dex */
public class NativeArray extends IdScriptableObject implements List {
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_find = -22;
    private static final int ConstructorId_findIndex = -23;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_isArray = -26;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_reduce = -24;
    private static final int ConstructorId_reduceRight = -25;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_unshift = -11;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5d;
    private static final int Id_concat = 13;
    private static final int Id_constructor = 1;
    private static final int Id_every = 17;
    private static final int Id_filter = 18;
    private static final int Id_find = 22;
    private static final int Id_findIndex = 23;
    private static final int Id_forEach = 19;
    private static final int Id_indexOf = 15;
    private static final int Id_join = 5;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_length = 1;
    private static final int Id_map = 20;
    private static final int Id_pop = 9;
    private static final int Id_push = 8;
    private static final int Id_reduce = 24;
    private static final int Id_reduceRight = 25;
    private static final int Id_reverse = 6;
    private static final int Id_shift = 10;
    private static final int Id_slice = 14;
    private static final int Id_some = 21;
    private static final int Id_sort = 7;
    private static final int Id_splice = 12;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_unshift = 11;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    private static final int MAX_PROTOTYPE_ID = 26;
    private static final int SymbolId_iterator = 26;
    static final long serialVersionUID = 7331366857676127338L;
    private Object[] dense;
    private boolean denseOnly;
    private long length;
    private int lengthAttr;
    private static final Object ARRAY_TAG = "Array";
    private static final Integer NEGATIVE_ONE = -1;
    private static final Comparator<Object> STRING_COMPARATOR = new StringLikeComparator();
    private static final Comparator<Object> DEFAULT_COMPARATOR = new ElementComparator();
    private static int maximumInitialCapacity = 10000;

    private static long toSliceIndex(double d2, long j) {
        if (d2 >= 0.0d) {
            return d2 > ((double) j) ? j : (long) d2;
        }
        double d3 = d2 + j;
        if (d3 < 0.0d) {
            return 0L;
        }
        return (long) d3;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 1;
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0L).exportAsJSClass(26, scriptable, z);
    }

    static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    static void setMaximumInitialCapacity(int i) {
        maximumInitialCapacity = i;
    }

    public NativeArray(long j) {
        this.lengthAttr = 6;
        boolean z = j <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i = (int) j;
            Object[] objArr = new Object[i < 10 ? 10 : i];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j;
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = objArr.length;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Array";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lengthAttr = i2;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        if (str.equals(Range.ATTR_LENGTH)) {
            return instanceIdInfo(this.lengthAttr, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 1) {
            return Range.ATTR_LENGTH;
        }
        return super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.wrapNumber(this.length);
        }
        return super.getInstanceIdValue(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = ARRAY_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -5, "join", 1);
        addIdFunctionProperty(idFunctionObject, obj, -6, "reverse", 0);
        addIdFunctionProperty(idFunctionObject, obj, -7, "sort", 1);
        addIdFunctionProperty(idFunctionObject, obj, -8, "push", 1);
        addIdFunctionProperty(idFunctionObject, obj, -9, "pop", 0);
        addIdFunctionProperty(idFunctionObject, obj, -10, "shift", 0);
        addIdFunctionProperty(idFunctionObject, obj, -11, "unshift", 1);
        addIdFunctionProperty(idFunctionObject, obj, -12, "splice", 2);
        addIdFunctionProperty(idFunctionObject, obj, -13, "concat", 1);
        addIdFunctionProperty(idFunctionObject, obj, -14, "slice", 2);
        addIdFunctionProperty(idFunctionObject, obj, -15, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_lastIndexOf, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_every, "every", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_filter, "filter", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_forEach, "forEach", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_map, "map", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_some, "some", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_find, "find", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_findIndex, "findIndex", 1);
        addIdFunctionProperty(idFunctionObject, obj, -24, "reduce", 1);
        addIdFunctionProperty(idFunctionObject, obj, -25, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isArray, "isArray", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        if (i == 26) {
            initPrototypeMethod(ARRAY_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 2:
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 3:
                str2 = "toLocaleString";
                str3 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 4:
                str2 = "toSource";
                str3 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 5:
                str = "join";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 6:
                str2 = "reverse";
                str3 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 7:
                str = "sort";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 8:
                str = "push";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 9:
                str2 = "pop";
                str3 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 10:
                str2 = "shift";
                str3 = str2;
                i2 = 0;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 11:
                str = "unshift";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 12:
                str4 = "splice";
                i2 = 2;
                str3 = str4;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 13:
                str = "concat";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 14:
                str4 = "slice";
                i2 = 2;
                str3 = str4;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 15:
                str = "indexOf";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 16:
                str = "lastIndexOf";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 17:
                str = "every";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 18:
                str = "filter";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 19:
                str = "forEach";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 20:
                str = "map";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 21:
                str = "some";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 22:
                str = "find";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 23:
                str = "findIndex";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 24:
                str = "reduce";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            case 25:
                str = "reduceRight";
                str3 = str;
                i2 = 1;
                initPrototypeMethod(ARRAY_TAG, i, str3, (String) null, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r8, org.mozilla.javascript.Context r9, org.mozilla.javascript.Scriptable r10, org.mozilla.javascript.Scriptable r11, java.lang.Object[] r12) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.get(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr != null && i >= 0 && i < objArr.length) {
            return objArr[i];
        }
        return super.get(i, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter(null, i, false)) {
            return super.has(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length) {
            return super.has(i, scriptable);
        }
        return objArr[i] != NOT_FOUND;
    }

    private static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (obj instanceof Number) {
            return toArrayIndex(((Number) obj).doubleValue());
        }
        return -1L;
    }

    private static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1L;
    }

    private static long toArrayIndex(double d2) {
        if (d2 != d2) {
            return -1L;
        }
        long uint32 = ScriptRuntime.toUint32(d2);
        if (uint32 != d2 || uint32 == 4294967295L) {
            return -1L;
        }
        return uint32;
    }

    private static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= SieveCacheKt.NodeLinkMask) {
            return -1;
        }
        return (int) arrayIndex;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex >= this.length) {
                this.length = arrayIndex + 1;
                this.denseOnly = false;
            }
        }
    }

    private boolean ensureCapacity(int i) {
        Object[] objArr = this.dense;
        if (i <= objArr.length) {
            return true;
        }
        if (i > MAX_PRE_GROW_SIZE) {
            this.denseOnly = false;
            return false;
        }
        int iMax = Math.max(i, (int) (((double) objArr.length) * GROW_FACTOR));
        Object[] objArr2 = new Object[iMax];
        Object[] objArr3 = this.dense;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        Arrays.fill(objArr2, this.dense.length, iMax, Scriptable.NOT_FOUND);
        this.dense = objArr2;
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i >= 0 && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            if (!isExtensible() && this.length <= i) {
                return;
            }
            Object[] objArr = this.dense;
            if (i < objArr.length) {
                objArr[i] = obj;
                long j = i;
                if (this.length <= j) {
                    this.length = j + 1;
                    return;
                }
                return;
            }
            if (this.denseOnly && i < ((double) objArr.length) * GROW_FACTOR && ensureCapacity(i + 1)) {
                this.dense[i] = obj;
                this.length = ((long) i) + 1;
                return;
            }
            this.denseOnly = false;
        }
        super.put(i, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j2 = i;
            if (this.length <= j2) {
                this.length = j2 + 1;
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        Object[] objArr = this.dense;
        if (objArr != null && i >= 0 && i < objArr.length && !isSealed() && (this.denseOnly || !isGetterOrSetter(null, i, true))) {
            this.dense[i] = NOT_FOUND;
        } else {
            super.delete(i);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.dense;
        if (objArr != null) {
            int length = objArr.length;
            long j = this.length;
            if (length > j) {
                length = (int) j;
            }
            if (length != 0) {
                int length2 = ids.length;
                Object[] objArr2 = new Object[length + length2];
                int i = 0;
                for (int i2 = 0; i2 != length; i2++) {
                    if (this.dense[i2] != NOT_FOUND) {
                        objArr2[i] = Integer.valueOf(i2);
                        i++;
                    }
                }
                if (i != length) {
                    Object[] objArr3 = new Object[i + length2];
                    System.arraycopy(objArr2, 0, objArr3, 0, i);
                    objArr2 = objArr3;
                }
                System.arraycopy(ids, 0, objArr2, i, length2);
                return objArr2;
            }
        }
        return ids;
    }

    public Integer[] getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString(int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) {
            return Long.valueOf(this.length);
        }
        return super.getDefaultValue(cls);
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, parentScope, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        nativeObject.defineProperty("writable", (Object) true, 0);
        nativeObject.defineProperty("enumerable", (Object) true, 0);
        nativeObject.defineProperty("configurable", (Object) true, 0);
        return nativeObject;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public int getAttributes(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || objArr[i] == NOT_FOUND) {
            return super.getAttributes(i);
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    protected ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && objArr[denseIndex] != NOT_FOUND) {
                return defaultIndexPropertyDescriptor(this.dense[denseIndex]);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    protected void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] != NOT_FOUND) {
                    put(i, this, objArr[i]);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0L);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Object obj = objArr[0];
        if (objArr.length > 1 || !(obj instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32(obj);
        if (uint32 != ((Number) obj).doubleValue()) {
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        return new NativeArray(uint32);
    }

    public long getLength() {
        return this.length;
    }

    @Deprecated
    public long jsGet_length() {
        return getLength();
    }

    void setDenseOnly(boolean z) {
        if (z && !this.denseOnly) {
            throw new IllegalArgumentException();
        }
        this.denseOnly = z;
    }

    private void setLength(Object obj) {
        if ((this.lengthAttr & 1) != 0) {
            return;
        }
        double number = ScriptRuntime.toNumber(obj);
        long uint32 = ScriptRuntime.toUint32(number);
        double d2 = uint32;
        if (d2 != number) {
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
        if (this.denseOnly) {
            long j = this.length;
            if (uint32 < j) {
                Object[] objArr = this.dense;
                Arrays.fill(objArr, (int) uint32, objArr.length, NOT_FOUND);
                this.length = uint32;
                return;
            } else {
                if (uint32 < 1431655764 && d2 < j * GROW_FACTOR && ensureCapacity((int) uint32)) {
                    this.length = uint32;
                    return;
                }
                this.denseOnly = false;
            }
        }
        long j2 = this.length;
        if (uint32 < j2) {
            if (j2 - uint32 > 4096) {
                for (Object obj2 : getIds()) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (toArrayIndex(str) >= uint32) {
                            delete(str);
                        }
                    } else {
                        int iIntValue = ((Integer) obj2).intValue();
                        if (iIntValue >= uint32) {
                            delete(iIntValue);
                        }
                    }
                }
            } else {
                for (long j3 = uint32; j3 < this.length; j3++) {
                    deleteElem(this, j3);
                }
            }
        }
        this.length = uint32;
    }

    static long getLengthProperty(Context context, Scriptable scriptable) {
        if (scriptable instanceof NativeString) {
            return ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        Object property = ScriptableObject.getProperty(scriptable, Range.ATTR_LENGTH);
        if (property == Scriptable.NOT_FOUND) {
            return 0L;
        }
        return ScriptRuntime.toUint32(property);
    }

    private static Object setLengthProperty(Context context, Scriptable scriptable, long j) {
        Number numberWrapNumber = ScriptRuntime.wrapNumber(j);
        ScriptableObject.putProperty(scriptable, Range.ATTR_LENGTH, numberWrapNumber);
        return numberWrapNumber;
    }

    private static void deleteElem(Scriptable scriptable, long j) {
        int i = (int) j;
        if (i == j) {
            scriptable.delete(i);
        } else {
            scriptable.delete(Long.toString(j));
        }
    }

    private static Object getElem(Context context, Scriptable scriptable, long j) {
        Object rawElem = getRawElem(scriptable, j);
        return rawElem != Scriptable.NOT_FOUND ? rawElem : Undefined.instance;
    }

    private static Object getRawElem(Scriptable scriptable, long j) {
        if (j > SieveCacheKt.NodeLinkMask) {
            return ScriptableObject.getProperty(scriptable, Long.toString(j));
        }
        return ScriptableObject.getProperty(scriptable, (int) j);
    }

    private static void defineElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > SieveCacheKt.NodeLinkMask) {
            scriptable.put(Long.toString(j), scriptable, obj);
        } else {
            scriptable.put((int) j, scriptable, obj);
        }
    }

    private static void setElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > SieveCacheKt.NodeLinkMask) {
            ScriptableObject.putProperty(scriptable, Long.toString(j), obj);
        } else {
            ScriptableObject.putProperty(scriptable, (int) j, obj);
        }
    }

    private static void setRawElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (obj == NOT_FOUND) {
            deleteElem(scriptable, j);
        } else {
            setElem(context, scriptable, j, obj);
        }
    }

    private static String toStringHelper(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z, boolean z2) {
        String str;
        boolean zHas;
        boolean z3;
        long j;
        long j2;
        boolean z4;
        long j3;
        long lengthProperty = getLengthProperty(context, scriptable2);
        StringBuilder sb = new StringBuilder(256);
        if (z) {
            sb.append('[');
            str = ", ";
        } else {
            str = Constants.SEPARATOR_COMMA;
        }
        if (context.iterating == null) {
            context.iterating = new ObjToIntMap(31);
            zHas = false;
            z3 = true;
        } else {
            zHas = context.iterating.has(scriptable2);
            z3 = false;
        }
        long j4 = 0;
        if (zHas) {
            j2 = 0;
            j = 0;
            z4 = false;
        } else {
            try {
                context.iterating.put(scriptable2, 0);
                boolean z5 = !z || context.getLanguageVersion() < 150;
                boolean z6 = false;
                j = 0;
                while (j < lengthProperty) {
                    if (j > j4) {
                        sb.append(str);
                    }
                    Object rawElem = getRawElem(scriptable2, j);
                    if (rawElem == NOT_FOUND || (z5 && (rawElem == null || rawElem == Undefined.instance))) {
                        j3 = j4;
                        z6 = false;
                    } else {
                        if (z) {
                            sb.append(ScriptRuntime.uneval(context, scriptable, rawElem));
                        } else if (rawElem instanceof String) {
                            String str2 = (String) rawElem;
                            if (z) {
                                sb.append('\"');
                                sb.append(ScriptRuntime.escapeString(str2));
                                sb.append('\"');
                            } else {
                                sb.append(str2);
                            }
                        } else {
                            if (z2) {
                                j3 = j4;
                                rawElem = ScriptRuntime.getPropFunctionAndThis(rawElem, "toLocaleString", context, scriptable).call(context, scriptable, ScriptRuntime.lastStoredScriptable(context), ScriptRuntime.emptyArgs);
                            } else {
                                j3 = j4;
                            }
                            sb.append(ScriptRuntime.toString(rawElem));
                            z6 = true;
                        }
                        j3 = j4;
                        z6 = true;
                    }
                    j++;
                    j4 = j3;
                }
                j2 = j4;
                z4 = z6;
            } finally {
                if (z3) {
                    context.iterating = null;
                }
            }
        }
        if (z) {
            if (!z4 && j > j2) {
                sb.append(", ]");
            } else {
                sb.append(']');
            }
        }
        return sb.toString();
    }

    private static String js_join(Context context, Scriptable scriptable, Object[] objArr) {
        String string;
        Object obj;
        long lengthProperty = getLengthProperty(context, scriptable);
        int i = (int) lengthProperty;
        if (lengthProperty != i) {
            throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
        }
        int i2 = 0;
        if (objArr.length < 1 || objArr[0] == Undefined.instance) {
            string = Constants.SEPARATOR_COMMA;
        } else {
            string = ScriptRuntime.toString(objArr[0]);
        }
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                StringBuilder sb = new StringBuilder();
                while (i2 < i) {
                    if (i2 != 0) {
                        sb.append(string);
                    }
                    Object[] objArr2 = nativeArray.dense;
                    if (i2 < objArr2.length && (obj = objArr2[i2]) != null && obj != Undefined.instance && obj != Scriptable.NOT_FOUND) {
                        sb.append(ScriptRuntime.toString(obj));
                    }
                    i2++;
                }
                return sb.toString();
            }
        }
        if (i == 0) {
            return "";
        }
        String[] strArr = new String[i];
        int length = 0;
        for (int i3 = 0; i3 != i; i3++) {
            Object elem = getElem(context, scriptable, i3);
            if (elem != null && elem != Undefined.instance) {
                String string2 = ScriptRuntime.toString(elem);
                length += string2.length();
                strArr[i3] = string2;
            }
        }
        StringBuilder sb2 = new StringBuilder(length + ((i - 1) * string.length()));
        while (i2 != i) {
            if (i2 != 0) {
                sb2.append(string);
            }
            String str = strArr[i2];
            if (str != null) {
                sb2.append(str);
            }
            i2++;
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.mozilla.javascript.Scriptable js_reverse(org.mozilla.javascript.Context r11, org.mozilla.javascript.Scriptable r12, java.lang.Object[] r13) {
        /*
            boolean r13 = r12 instanceof org.mozilla.javascript.NativeArray
            if (r13 == 0) goto L22
            r13 = r12
            org.mozilla.javascript.NativeArray r13 = (org.mozilla.javascript.NativeArray) r13
            boolean r0 = r13.denseOnly
            if (r0 == 0) goto L22
            long r0 = r13.length
            int r11 = (int) r0
            int r11 = r11 + (-1)
            r0 = 0
        L11:
            if (r0 >= r11) goto L45
            java.lang.Object[] r1 = r13.dense
            r2 = r1[r0]
            r3 = r1[r11]
            r1[r0] = r3
            r1[r11] = r2
            int r0 = r0 + 1
            int r11 = r11 + (-1)
            goto L11
        L22:
            long r0 = getLengthProperty(r11, r12)
            r2 = 2
            long r2 = r0 / r2
            r4 = 0
        L2c:
            int r13 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r13 >= 0) goto L45
            long r6 = r0 - r4
            r8 = 1
            long r6 = r6 - r8
            java.lang.Object r13 = getRawElem(r12, r4)
            java.lang.Object r10 = getRawElem(r12, r6)
            setRawElem(r11, r12, r4, r10)
            setRawElem(r11, r12, r6, r13)
            long r4 = r4 + r8
            goto L2c
        L45:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_reverse(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.mozilla.javascript.Scriptable js_sort(org.mozilla.javascript.Context r8, final org.mozilla.javascript.Scriptable r9, org.mozilla.javascript.Scriptable r10, java.lang.Object[] r11) {
        /*
            int r0 = r11.length
            r1 = 0
            if (r0 <= 0) goto L22
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
            r11 = r11[r1]
            if (r0 == r11) goto L22
            org.mozilla.javascript.Callable r4 = org.mozilla.javascript.ScriptRuntime.getValueFunctionAndThis(r11, r8)
            org.mozilla.javascript.Scriptable r7 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r8)
            r11 = 2
            java.lang.Object[] r3 = new java.lang.Object[r11]
            org.mozilla.javascript.NativeArray$ElementComparator r11 = new org.mozilla.javascript.NativeArray$ElementComparator
            org.mozilla.javascript.NativeArray$1 r2 = new org.mozilla.javascript.NativeArray$1
            r5 = r8
            r6 = r9
            r2.<init>()
            r11.<init>(r2)
            goto L25
        L22:
            r5 = r8
            java.util.Comparator<java.lang.Object> r11 = org.mozilla.javascript.NativeArray.DEFAULT_COMPARATOR
        L25:
            long r8 = getLengthProperty(r5, r10)
            int r0 = (int) r8
            long r2 = (long) r0
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 != 0) goto L4d
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r9 = r1
        L32:
            if (r9 == r0) goto L3e
            long r2 = (long) r9
            java.lang.Object r2 = getRawElem(r10, r2)
            r8[r9] = r2
            int r9 = r9 + 1
            goto L32
        L3e:
            org.mozilla.javascript.Sorting.hybridSort(r8, r11)
        L41:
            if (r1 >= r0) goto L4c
            long r2 = (long) r1
            r9 = r8[r1]
            setRawElem(r5, r10, r2, r9)
            int r1 = r1 + 1
            goto L41
        L4c:
            return r10
        L4d:
            java.lang.String r10 = "msg.arraylength.too.big"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            org.mozilla.javascript.EvaluatorException r8 = org.mozilla.javascript.Context.reportRuntimeError1(r10, r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_sort(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    private static Object js_push(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j = nativeArray.length;
                    nativeArray.length = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.wrapNumber(nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        while (i < objArr.length) {
            setElem(context, scriptable, ((long) i) + lengthProperty, objArr[i]);
            i++;
        }
        return context.getLanguageVersion() == 120 ? objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1] : setLengthProperty(context, scriptable, lengthProperty + ((long) objArr.length));
    }

    private static Object js_pop(Context context, Scriptable scriptable, Object[] objArr) {
        Object elem;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[(int) j2];
                    objArr2[(int) j2] = NOT_FOUND;
                    return obj;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        if (lengthProperty > 0) {
            lengthProperty--;
            elem = getElem(context, scriptable, lengthProperty);
            deleteElem(scriptable, lengthProperty);
        } else {
            elem = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return elem;
    }

    private static Object js_shift(Context context, Scriptable scriptable, Object[] objArr) {
        Object elem;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j2);
                    nativeArray.dense[(int) nativeArray.length] = NOT_FOUND;
                    return obj == NOT_FOUND ? Undefined.instance : obj;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        if (lengthProperty > 0) {
            lengthProperty--;
            elem = getElem(context, scriptable, 0L);
            if (lengthProperty > 0) {
                for (long j3 = 1; j3 <= lengthProperty; j3++) {
                    setRawElem(context, scriptable, j3 - 1, getRawElem(scriptable, j3));
                }
            }
            deleteElem(scriptable, lengthProperty);
        } else {
            elem = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return elem;
    }

    private static Object js_unshift(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i < objArr.length) {
                    nativeArray.dense[i] = objArr[i];
                    i++;
                }
                long length = nativeArray.length + ((long) objArr.length);
                nativeArray.length = length;
                return ScriptRuntime.wrapNumber(length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        int length2 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j = lengthProperty - 1; j >= 0; j--) {
                    setRawElem(context, scriptable, ((long) length2) + j, getRawElem(scriptable, j));
                }
            }
            while (i < objArr.length) {
                setElem(context, scriptable, i, objArr[i]);
                i++;
            }
        }
        return setLengthProperty(context, scriptable, lengthProperty + ((long) objArr.length));
    }

    private static Object js_splice(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        NativeArray nativeArray;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        Object objNewArray;
        Object obj;
        if (scriptable2 instanceof NativeArray) {
            nativeArray = (NativeArray) scriptable2;
            z = nativeArray.denseOnly;
        } else {
            nativeArray = null;
            z = false;
        }
        Scriptable topLevelScope = getTopLevelScope(scriptable);
        int length = objArr.length;
        if (length == 0) {
            return context.newArray(topLevelScope, 0);
        }
        long lengthProperty = getLengthProperty(context, scriptable2);
        long sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
        int i = length - 1;
        if (objArr.length == 1) {
            j2 = lengthProperty - sliceIndex;
            z2 = z;
            j = 0;
        } else {
            double integer = ScriptRuntime.toInteger(objArr[1]);
            if (integer < 0.0d) {
                z2 = z;
                j2 = 0;
                j = 0;
            } else {
                z2 = z;
                long j5 = lengthProperty - sliceIndex;
                j = 0;
                if (integer <= j5) {
                    j5 = (long) integer;
                }
                j2 = j5;
            }
            i = length - 2;
        }
        long j6 = j2;
        long j7 = sliceIndex + j6;
        if (j6 != j) {
            if (j6 == 1 && context.getLanguageVersion() == 120) {
                j3 = j6;
                j4 = j7;
                objNewArray = getElem(context, scriptable2, sliceIndex);
            } else if (z2) {
                j3 = j6;
                int i2 = (int) (j7 - sliceIndex);
                Object[] objArr2 = new Object[i2];
                System.arraycopy(nativeArray.dense, (int) sliceIndex, objArr2, 0, i2);
                j4 = j7;
                objNewArray = context.newArray(topLevelScope, objArr2);
            } else {
                j3 = j6;
                Scriptable scriptableNewArray = context.newArray(topLevelScope, 0);
                j4 = j7;
                long j8 = sliceIndex;
                while (j8 != j4) {
                    Object rawElem = getRawElem(scriptable2, j8);
                    long j9 = j8;
                    if (rawElem != NOT_FOUND) {
                        setElem(context, scriptableNewArray, j9 - sliceIndex, rawElem);
                    }
                    j8 = j9 + 1;
                }
                setLengthProperty(context, scriptableNewArray, j4 - sliceIndex);
                objNewArray = scriptableNewArray;
            }
        } else {
            j3 = j6;
            j4 = j7;
            if (context.getLanguageVersion() == 120) {
                objNewArray = Undefined.instance;
            } else {
                objNewArray = context.newArray(topLevelScope, 0);
            }
        }
        long j10 = i;
        long j11 = j10 - j3;
        if (z2) {
            Object obj2 = objNewArray;
            long j12 = lengthProperty + j11;
            if (j12 < SieveCacheKt.NodeLinkMask) {
                Object obj3 = obj2;
                int i3 = (int) j12;
                obj = obj3;
                if (nativeArray.ensureCapacity(i3)) {
                    Object[] objArr3 = nativeArray.dense;
                    System.arraycopy(objArr3, (int) j4, objArr3, (int) (j10 + sliceIndex), (int) (lengthProperty - j4));
                    if (i > 0) {
                        System.arraycopy(objArr, 2, nativeArray.dense, (int) sliceIndex, i);
                    }
                    if (j11 < j) {
                        Arrays.fill(nativeArray.dense, i3, (int) lengthProperty, NOT_FOUND);
                    }
                    nativeArray.length = j12;
                    return obj3;
                }
            } else {
                obj = obj2;
            }
        } else {
            obj = objNewArray;
        }
        if (j11 > j) {
            for (long j13 = lengthProperty - 1; j13 >= j4; j13--) {
                setRawElem(context, scriptable2, j13 + j11, getRawElem(scriptable2, j13));
            }
        } else if (j11 < j) {
            for (long j14 = j4; j14 < lengthProperty; j14++) {
                setRawElem(context, scriptable2, j14 + j11, getRawElem(scriptable2, j14));
            }
            for (long j15 = lengthProperty + j11; j15 < lengthProperty; j15++) {
                deleteElem(scriptable2, j15);
            }
        }
        int length2 = objArr.length - i;
        for (int i4 = 0; i4 < i; i4++) {
            setElem(context, scriptable2, ((long) i4) + sliceIndex, objArr[i4 + length2]);
        }
        setLengthProperty(context, scriptable2, lengthProperty + j11);
        return obj;
    }

    private static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        int i = 0;
        Scriptable scriptableNewArray = context.newArray(getTopLevelScope(scriptable), 0);
        if ((scriptable2 instanceof NativeArray) && (scriptableNewArray instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable2;
            NativeArray nativeArray2 = (NativeArray) scriptableNewArray;
            if (nativeArray.denseOnly && nativeArray2.denseOnly) {
                int i2 = (int) nativeArray.length;
                boolean z = true;
                for (int i3 = 0; i3 < objArr.length && z; i3++) {
                    Object obj = objArr[i3];
                    if (obj instanceof NativeArray) {
                        NativeArray nativeArray3 = (NativeArray) obj;
                        z = nativeArray3.denseOnly;
                        i2 = (int) (((long) i2) + nativeArray3.length);
                    } else {
                        i2++;
                    }
                }
                if (z && nativeArray2.ensureCapacity(i2)) {
                    System.arraycopy(nativeArray.dense, 0, nativeArray2.dense, 0, (int) nativeArray.length);
                    int i4 = (int) nativeArray.length;
                    for (int i5 = 0; i5 < objArr.length && z; i5++) {
                        Object obj2 = objArr[i5];
                        if (obj2 instanceof NativeArray) {
                            NativeArray nativeArray4 = (NativeArray) obj2;
                            System.arraycopy(nativeArray4.dense, 0, nativeArray2.dense, i4, (int) nativeArray4.length);
                            i4 += (int) nativeArray4.length;
                        } else {
                            nativeArray2.dense[i4] = obj2;
                            i4++;
                        }
                    }
                    nativeArray2.length = i2;
                    return scriptableNewArray;
                }
            }
        }
        long j2 = 0;
        if (js_isArray(scriptable2)) {
            long lengthProperty = getLengthProperty(context, scriptable2);
            j = 0;
            while (j < lengthProperty) {
                Object rawElem = getRawElem(scriptable2, j);
                if (rawElem != NOT_FOUND) {
                    defineElem(context, scriptableNewArray, j, rawElem);
                }
                j++;
            }
        } else {
            defineElem(context, scriptableNewArray, 0L, scriptable2);
            j = 1;
        }
        while (i < objArr.length) {
            if (js_isArray(objArr[i])) {
                Scriptable scriptable3 = (Scriptable) objArr[i];
                long lengthProperty2 = getLengthProperty(context, scriptable3);
                long j3 = j2;
                while (j3 < lengthProperty2) {
                    Object rawElem2 = getRawElem(scriptable3, j3);
                    if (rawElem2 != NOT_FOUND) {
                        defineElem(context, scriptableNewArray, j, rawElem2);
                    }
                    j3++;
                    j++;
                }
            } else {
                defineElem(context, scriptableNewArray, j, objArr[i]);
                j++;
            }
            i++;
            j2 = 0;
        }
        setLengthProperty(context, scriptableNewArray, j);
        return scriptableNewArray;
    }

    private Scriptable js_slice(Context context, Scriptable scriptable, Object[] objArr) {
        long sliceIndex;
        Scriptable scriptableNewArray = context.newArray(getTopLevelScope(this), 0);
        long lengthProperty = getLengthProperty(context, scriptable);
        if (objArr.length == 0) {
            sliceIndex = 0;
        } else {
            sliceIndex = toSliceIndex(ScriptRuntime.toInteger(objArr[0]), lengthProperty);
            if (objArr.length != 1 && objArr[1] != Undefined.instance) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(objArr[1]), lengthProperty);
            }
        }
        for (long j = sliceIndex; j < lengthProperty; j++) {
            Object rawElem = getRawElem(scriptable, j);
            if (rawElem != NOT_FOUND) {
                defineElem(context, scriptableNewArray, j - sliceIndex, rawElem);
            }
        }
        setLengthProperty(context, scriptableNewArray, Math.max(0L, lengthProperty - sliceIndex));
        return scriptableNewArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[PHI: r8
      0x0028: PHI (r8v2 long) = (r8v1 long), (r8v4 long) binds: [B:10:0x0020, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object js_indexOf(org.mozilla.javascript.Context r10, org.mozilla.javascript.Scriptable r11, java.lang.Object[] r12) {
        /*
            int r0 = r12.length
            if (r0 <= 0) goto L7
            r0 = 0
            r0 = r12[r0]
            goto L9
        L7:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
        L9:
            long r1 = getLengthProperty(r10, r11)
            int r10 = r12.length
            r3 = 2
            r4 = 1
            r6 = 0
            if (r10 >= r3) goto L16
            goto L32
        L16:
            r10 = 1
            r10 = r12[r10]
            double r8 = org.mozilla.javascript.ScriptRuntime.toInteger(r10)
            long r8 = (long) r8
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 >= 0) goto L28
            long r8 = r8 + r1
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 >= 0) goto L28
            goto L29
        L28:
            r6 = r8
        L29:
            long r8 = r1 - r4
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L32
            java.lang.Integer r10 = org.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r10
        L32:
            boolean r10 = r11 instanceof org.mozilla.javascript.NativeArray
            if (r10 == 0) goto L6a
            r10 = r11
            org.mozilla.javascript.NativeArray r10 = (org.mozilla.javascript.NativeArray) r10
            boolean r12 = r10.denseOnly
            if (r12 == 0) goto L6a
            org.mozilla.javascript.Scriptable r11 = r10.getPrototype()
            int r12 = (int) r6
        L42:
            long r3 = (long) r12
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L67
            java.lang.Object[] r5 = r10.dense
            r5 = r5[r12]
            java.lang.Object r6 = org.mozilla.javascript.NativeArray.NOT_FOUND
            if (r5 != r6) goto L55
            if (r11 == 0) goto L55
            java.lang.Object r5 = org.mozilla.javascript.ScriptableObject.getProperty(r11, r12)
        L55:
            java.lang.Object r6 = org.mozilla.javascript.NativeArray.NOT_FOUND
            if (r5 == r6) goto L64
            boolean r5 = org.mozilla.javascript.ScriptRuntime.shallowEq(r5, r0)
            if (r5 == 0) goto L64
            java.lang.Long r10 = java.lang.Long.valueOf(r3)
            return r10
        L64:
            int r12 = r12 + 1
            goto L42
        L67:
            java.lang.Integer r10 = org.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r10
        L6a:
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 >= 0) goto L83
            java.lang.Object r10 = getRawElem(r11, r6)
            java.lang.Object r12 = org.mozilla.javascript.NativeArray.NOT_FOUND
            if (r10 == r12) goto L81
            boolean r10 = org.mozilla.javascript.ScriptRuntime.shallowEq(r10, r0)
            if (r10 == 0) goto L81
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            return r10
        L81:
            long r6 = r6 + r4
            goto L6a
        L83:
            java.lang.Integer r10 = org.mozilla.javascript.NativeArray.NEGATIVE_ONE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_indexOf(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Object js_lastIndexOf(Context context, Scriptable scriptable, Object[] objArr) {
        long j;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        long lengthProperty = getLengthProperty(context, scriptable);
        if (objArr.length < 2) {
            j = lengthProperty - 1;
        } else {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer >= lengthProperty) {
                j = lengthProperty - 1;
            } else {
                if (integer < 0) {
                    integer += lengthProperty;
                }
                j = integer;
            }
            if (j < 0) {
                return NEGATIVE_ONE;
            }
        }
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i = (int) j; i >= 0; i--) {
                    Object property = nativeArray.dense[i];
                    if (property == NOT_FOUND && prototype != null) {
                        property = ScriptableObject.getProperty(prototype, i);
                    }
                    if (property != NOT_FOUND && ScriptRuntime.shallowEq(property, obj)) {
                        return Long.valueOf(i);
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        while (j >= 0) {
            Object rawElem = getRawElem(scriptable, j);
            if (rawElem != NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j--;
        }
        return NEGATIVE_ONE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x00db, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00db A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object iterativeMethod(org.mozilla.javascript.Context r21, org.mozilla.javascript.IdFunctionObject r22, org.mozilla.javascript.Scriptable r23, org.mozilla.javascript.Scriptable r24, java.lang.Object[] r25) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.iterativeMethod(org.mozilla.javascript.Context, org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Object reduceMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long lengthProperty = getLengthProperty(context, scriptable2);
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = i == 24;
        Object objCall = objArr.length > 1 ? objArr[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(scriptable2, j2);
            if (rawElem != Scriptable.NOT_FOUND) {
                objCall = objCall == Scriptable.NOT_FOUND ? rawElem : function.call(context, topLevelScope, topLevelScope, new Object[]{objCall, rawElem, Long.valueOf(j2), scriptable2});
            }
        }
        if (objCall != Scriptable.NOT_FOUND) {
            return objCall;
        }
        throw ScriptRuntime.typeError0("msg.empty.array.reduce");
    }

    private static boolean js_isArray(Object obj) {
        if (obj instanceof Scriptable) {
            return "Array".equals(((Scriptable) obj).getClassName());
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = get(i2);
        }
        return objArr;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        long j = this.length;
        if (j <= SieveCacheKt.NodeLinkMask) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    @Override // org.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    public Object get(long j) {
        if (j < 0 || j >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object rawElem = getRawElem(this, j);
        if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
            return null;
        }
        return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
    }

    @Override // java.util.List
    public Object get(int i) {
        return get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        int i2 = 0;
        if (obj == null) {
            while (i2 < i) {
                if (get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < i) {
            if (obj.equals(get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (obj == null) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (get(i2) == null) {
                    return i2;
                }
            }
            return -1;
        }
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (obj.equals(get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        long j = this.length;
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalStateException();
        }
        int i2 = (int) j;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return new ListIterator(i, i2) { // from class: org.mozilla.javascript.NativeArray.2
            int cursor;
            final /* synthetic */ int val$len;
            final /* synthetic */ int val$start;

            {
                this.val$start = i;
                this.val$len = i2;
                this.cursor = i;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.cursor < this.val$len;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                int i3 = this.cursor;
                if (i3 == this.val$len) {
                    throw new NoSuchElementException();
                }
                NativeArray nativeArray = NativeArray.this;
                this.cursor = i3 + 1;
                return nativeArray.get(i3);
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.cursor > 0;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                int i3 = this.cursor;
                if (i3 == 0) {
                    throw new NoSuchElementException();
                }
                NativeArray nativeArray = NativeArray.this;
                int i4 = i3 - 1;
                this.cursor = i4;
                return nativeArray.get(i4);
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.cursor;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.cursor - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 26 : 0;
    }

    public static final class StringLikeComparator implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ScriptRuntime.toString(obj).compareTo(ScriptRuntime.toString(obj2));
        }
    }

    public static final class ElementComparator implements Comparator<Object> {
        private final Comparator<Object> child;

        public ElementComparator() {
            this.child = NativeArray.STRING_COMPARATOR;
        }

        public ElementComparator(Comparator<Object> comparator) {
            this.child = comparator;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == Undefined.instance) {
                if (obj2 == Undefined.instance) {
                    return 0;
                }
                return obj2 == Scriptable.NOT_FOUND ? -1 : 1;
            }
            if (obj == Scriptable.NOT_FOUND) {
                return obj2 == Scriptable.NOT_FOUND ? 0 : 1;
            }
            if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
                return -1;
            }
            return this.child.compare(obj, obj2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0119  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.findPrototypeId(java.lang.String):int");
    }
}
