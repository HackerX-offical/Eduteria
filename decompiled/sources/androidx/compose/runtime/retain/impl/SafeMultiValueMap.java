package androidx.compose.runtime.retain.impl;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectListKt;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;

/* JADX INFO: compiled from: SafeMultiValueMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u00010\u00022\u00020\u0002:\u00017B\u001d\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001a\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001¢\u0006\u0004\b\u001b\u0010\u001eJ\u001f\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001¢\u0006\u0004\b \u0010\u001eJ\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\b#\u0010$J;\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002!\u0010&\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0'H\u0086\b¢\u0006\u0004\b*\u0010+J3\u0010%\u001a\u00020\t2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0'H\u0086\b¢\u0006\u0004\b*\u0010,J\u0015\u0010-\u001a\u00020\u0002*\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b.\u0010\u001cJ\u0016\u0010/\u001a\u00028\u0001*\u0004\u0018\u00010\u0002H\u0080\b¢\u0006\u0004\b0\u0010\u001cJ\u0014\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¨\u00068"}, d2 = {"Landroidx/compose/runtime/retain/impl/SafeMultiValueMap;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "add", "", "key", "value", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", FasteningElement.ATTR_CLEAR, "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "contains", "", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "isEmpty", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isNotEmpty", "isNotEmpty-impl", "removeLast", "removeLast-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "defaultIfAbsent", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "removeFirst", "removeFirst-impl", "values", "Landroidx/collection/ObjectList;", "values-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/ObjectList;", "forEachValue", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachValue-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "safeWrapIfNecessary", "safeWrapIfNecessary-impl$runtime_retain", "unwrapSafeValue", "unwrapSafeValue-impl$runtime_retain", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ValueSafetyWrapper", "runtime-retain"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class SafeMultiValueMap<K, V> {
    private final MutableScatterMap<Object, Object> map;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SafeMultiValueMap m5328boximpl(MutableScatterMap mutableScatterMap) {
        return new SafeMultiValueMap(mutableScatterMap);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <K, V> MutableScatterMap<Object, Object> m5330constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5333equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof SafeMultiValueMap) && Intrinsics.areEqual(mutableScatterMap, ((SafeMultiValueMap) obj).getMap());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5334equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5337hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5344toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "SafeMultiValueMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object other) {
        return m5333equalsimpl(this.map, other);
    }

    public int hashCode() {
        return m5337hashCodeimpl(this.map);
    }

    public String toString() {
        return m5344toStringimpl(this.map);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }

    private /* synthetic */ SafeMultiValueMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableScatterMap m5331constructorimpl$default(MutableScatterMap mutableScatterMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = 1;
        if ((i & 1) != 0) {
            mutableScatterMap = new MutableScatterMap(0, i2, null);
        }
        return m5330constructorimpl(mutableScatterMap);
    }

    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    public static final void m5327addimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, V v) {
        Object objMutableObjectListOf;
        if (k == null) {
            k = (K) SafeMultiValueMapKt.NULL_SENTINEL;
        }
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(k);
        boolean z = iFindInsertIndex < 0;
        Object value = null;
        Object obj = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (obj == null) {
            objMutableObjectListOf = m5343safeWrapIfNecessaryimpl$runtime_retain(mutableScatterMap, v);
        } else if (obj instanceof MutableObjectList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableObjectList<kotlin.Any?>");
            MutableObjectList mutableObjectList = (MutableObjectList) obj;
            mutableObjectList.add(v);
            objMutableObjectListOf = mutableObjectList;
        } else {
            if (obj instanceof ValueSafetyWrapper) {
                value = ((ValueSafetyWrapper) obj).getValue();
            } else if (obj != SafeMultiValueMapKt.NULL_SENTINEL) {
                value = obj;
            }
            objMutableObjectListOf = ObjectListKt.mutableObjectListOf(value, v);
        }
        if (z) {
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = k;
            mutableScatterMap.values[i] = objMutableObjectListOf;
            return;
        }
        mutableScatterMap.values[iFindInsertIndex] = objMutableObjectListOf;
    }

    /* JADX INFO: renamed from: clear-impl, reason: not valid java name */
    public static final void m5329clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m5332containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        if (k == null) {
            k = (K) SafeMultiValueMapKt.NULL_SENTINEL;
        }
        return mutableScatterMap.contains(k);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m5338isEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isEmpty();
    }

    /* JADX INFO: renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m5339isNotEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: removeLast-impl, reason: not valid java name */
    public static final V m5341removeLastimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        if (k == null) {
            k = (K) SafeMultiValueMapKt.NULL_SENTINEL;
        }
        V v = (V) mutableScatterMap.get(k);
        if (v == 0) {
            return null;
        }
        if (v instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) v;
            V v2 = (V) mutableObjectList.removeAt(mutableObjectList.getSize() - 1);
            if (mutableObjectList.getSize() == 1) {
                mutableScatterMap.set(k, m5343safeWrapIfNecessaryimpl$runtime_retain(mutableScatterMap, mutableObjectList.first()));
            }
            return v2;
        }
        mutableScatterMap.remove(k);
        if (v instanceof ValueSafetyWrapper) {
            return (V) ((ValueSafetyWrapper) v).getValue();
        }
        if (v == SafeMultiValueMapKt.NULL_SENTINEL) {
            return null;
        }
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: removeLast-impl, reason: not valid java name */
    public static final V m5342removeLastimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, V v) {
        if (k == null) {
            k = (K) SafeMultiValueMapKt.NULL_SENTINEL;
        }
        V v2 = (V) mutableScatterMap.get(k);
        if (v2 == 0) {
            return v;
        }
        if (v2 instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) v2;
            V v3 = (V) mutableObjectList.removeAt(mutableObjectList.getSize() - 1);
            if (mutableObjectList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            if (mutableObjectList.getSize() == 1) {
                mutableScatterMap.set(k, m5343safeWrapIfNecessaryimpl$runtime_retain(mutableScatterMap, mutableObjectList.first()));
            }
            return v3;
        }
        mutableScatterMap.remove(k);
        if (v2 instanceof ValueSafetyWrapper) {
            return (V) ((ValueSafetyWrapper) v2).getValue();
        }
        if (v2 == SafeMultiValueMapKt.NULL_SENTINEL) {
            return null;
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: removeFirst-impl, reason: not valid java name */
    public static final V m5340removeFirstimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, V v) {
        if (k == null) {
            k = (K) SafeMultiValueMapKt.NULL_SENTINEL;
        }
        Object obj = mutableScatterMap.get(k);
        if (obj == null) {
            return v;
        }
        if (obj instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) obj;
            V v2 = (V) mutableObjectList.removeAt(0);
            if (mutableObjectList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            if (mutableObjectList.getSize() == 1) {
                mutableScatterMap.set(k, m5343safeWrapIfNecessaryimpl$runtime_retain(mutableScatterMap, mutableObjectList.first()));
            }
            return v2;
        }
        V v3 = (V) mutableScatterMap.remove(k);
        if (v3 instanceof ValueSafetyWrapper) {
            return (V) ((ValueSafetyWrapper) v3).getValue();
        }
        if (v3 == SafeMultiValueMapKt.NULL_SENTINEL) {
            return null;
        }
        return v3;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX INFO: renamed from: values-impl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.collection.ObjectList<V> m5346valuesimpl(androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r14) {
        /*
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto Lb
            androidx.collection.ObjectList r14 = androidx.collection.ObjectListKt.emptyObjectList()
            return r14
        Lb:
            androidx.collection.MutableObjectList r0 = new androidx.collection.MutableObjectList
            r1 = 0
            r2 = 0
            r3 = 1
            r0.<init>(r2, r3, r1)
            androidx.collection.ScatterMap r14 = (androidx.collection.ScatterMap) r14
            java.lang.Object[] r1 = r14.values
            long[] r14 = r14.metadata
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L68
            r4 = r2
        L1f:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L63
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L39:
            if (r9 >= r7) goto L61
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L5d
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof androidx.collection.MutableObjectList
            if (r11 == 0) goto L5a
            java.lang.String r11 = "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
            androidx.collection.MutableObjectList r10 = (androidx.collection.MutableObjectList) r10
            androidx.collection.ObjectList r10 = (androidx.collection.ObjectList) r10
            r0.addAll(r10)
            goto L5d
        L5a:
            r0.add(r10)
        L5d:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L61:
            if (r7 != r8) goto L68
        L63:
            if (r4 == r3) goto L68
            int r4 = r4 + 1
            goto L1f
        L68:
            androidx.collection.ObjectList r0 = (androidx.collection.ObjectList) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.retain.impl.SafeMultiValueMap.m5346valuesimpl(androidx.collection.MutableScatterMap):androidx.collection.ObjectList");
    }

    /* JADX INFO: renamed from: forEachValue-impl, reason: not valid java name */
    public static final void m5335forEachValueimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, Function1<? super V, Unit> function1) {
        if (k == null) {
            k = (K) SafeMultiValueMapKt.NULL_SENTINEL;
        }
        Object value = mutableScatterMap.get(k);
        if (value != null) {
            if (value instanceof MutableObjectList) {
                MutableObjectList mutableObjectList = (MutableObjectList) value;
                Object[] objArr = mutableObjectList.content;
                int i = mutableObjectList._size;
                for (int i2 = 0; i2 < i; i2++) {
                    function1.invoke(objArr[i2]);
                }
                return;
            }
            if (value instanceof ValueSafetyWrapper) {
                value = ((ValueSafetyWrapper) value).getValue();
            } else if (value == SafeMultiValueMapKt.NULL_SENTINEL) {
                value = null;
            }
            function1.invoke(value);
        }
    }

    /* JADX INFO: renamed from: forEachValue-impl, reason: not valid java name */
    public static final void m5336forEachValueimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function1<? super V, Unit> function1) {
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        Object obj = objArr[(i << 3) + i3];
                        if (obj instanceof MutableObjectList) {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>");
                            MutableObjectList mutableObjectList = (MutableObjectList) obj;
                            Object[] objArr2 = mutableObjectList.content;
                            int i4 = mutableObjectList._size;
                            for (int i5 = 0; i5 < i4; i5++) {
                                function1.invoke(objArr2[i5]);
                            }
                        } else {
                            function1.invoke(obj);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: SafeMultiValueMap.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/retain/impl/SafeMultiValueMap$ValueSafetyWrapper;", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "runtime-retain"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ValueSafetyWrapper {
        public static final int $stable = 8;
        private final Object value;

        public ValueSafetyWrapper(Object obj) {
            this.value = obj;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: safeWrapIfNecessary-impl$runtime_retain, reason: not valid java name */
    public static final Object m5343safeWrapIfNecessaryimpl$runtime_retain(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return obj instanceof MutableObjectList ? new ValueSafetyWrapper(obj) : obj == null ? SafeMultiValueMapKt.NULL_SENTINEL : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: unwrapSafeValue-impl$runtime_retain, reason: not valid java name */
    public static final V m5345unwrapSafeValueimpl$runtime_retain(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        if (obj instanceof ValueSafetyWrapper) {
            return (V) ((ValueSafetyWrapper) obj).getValue();
        }
        if (obj == SafeMultiValueMapKt.NULL_SENTINEL) {
            return null;
        }
        return obj;
    }
}
