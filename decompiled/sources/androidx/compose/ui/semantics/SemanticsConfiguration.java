package androidx.compose.ui.semantics;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: SemanticsConfiguration.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001a¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150\u001a¢\u0006\u0002\u0010\u001bJ!\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u001eH\u0096\u0002J*\u0010\u001f\u001a\u00020 \"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010!\u001a\u0002H\u0015H\u0096\u0002¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020$\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002J\r\u0010%\u001a\u00020$H\u0000¢\u0006\u0002\b&J\u0015\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0000H\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u0000H\u0000¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020\u0000J\u0013\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016R&\u0010\b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010'\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*¨\u0006:"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "<init>", "()V", "props", "Landroidx/collection/MutableScatterMap;", "getProps$ui", "()Landroidx/collection/MutableScatterMap;", "mapWrapper", "", "_accessibilityExtraKeys", "Landroidx/collection/MutableScatterSet;", "accessibilityExtraKeys", "Landroidx/collection/ScatterSet;", "getAccessibilityExtraKeys$ui", "()Landroidx/collection/ScatterSet;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "iterator", "", "set", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "contains", "", "containsImportantForAccessibility", "containsImportantForAccessibility$ui", "isMergingSemanticsOfDescendants", "()Z", "setMergingSemanticsOfDescendants", "(Z)V", "isClearingSemantics", "setClearingSemantics", "mergeChild", "child", "mergeChild$ui", "collapsePeer", "peer", "collapsePeer$ui", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {
    public static final int $stable = 8;
    private MutableScatterSet<SemanticsPropertyKey<?>> _accessibilityExtraKeys;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private Map<SemanticsPropertyKey<?>, ? extends Object> mapWrapper;
    private final MutableScatterMap<SemanticsPropertyKey<?>, Object> props = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<SemanticsPropertyKey<?>, Object> getProps$ui() {
        return this.props;
    }

    public final ScatterSet<SemanticsPropertyKey<?>> getAccessibilityExtraKeys$ui() {
        return this._accessibilityExtraKeys;
    }

    public final <T> T get(SemanticsPropertyKey<T> key) {
        T t = (T) this.props.get(key);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Key not present: " + key + " - consider getOrElse or getOrNull");
    }

    public final <T> T getOrElse(SemanticsPropertyKey<T> key, Function0<? extends T> defaultValue) {
        T t = (T) this.props.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    public final <T> T getOrElseNullable(SemanticsPropertyKey<T> key, Function0<? extends T> defaultValue) {
        T t = (T) this.props.get(key);
        return t == null ? defaultValue.invoke() : t;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        Map<SemanticsPropertyKey<?>, ? extends Object> mapAsMap = this.mapWrapper;
        if (mapAsMap == null) {
            mapAsMap = this.props.asMap();
            this.mapWrapper = mapAsMap;
        }
        return mapAsMap.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public <T> void set(SemanticsPropertyKey<T> key, T value) {
        if ((value instanceof AccessibilityAction) && contains(key)) {
            Object obj = this.props.get(key);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
            MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = this.props;
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) value;
            String label = accessibilityAction2.getLabel();
            if (label == null) {
                label = accessibilityAction.getLabel();
            }
            Function action = accessibilityAction2.getAction();
            if (action == null) {
                action = accessibilityAction.getAction();
            }
            mutableScatterMap.set(key, new AccessibilityAction(label, action));
        } else {
            this.props.set(key, value);
        }
        if (key.getAccessibilityExtraKey() != null) {
            if (this._accessibilityExtraKeys == null) {
                this._accessibilityExtraKeys = ScatterSetKt.mutableScatterSetOf();
            }
            MutableScatterSet<SemanticsPropertyKey<?>> mutableScatterSet = this._accessibilityExtraKeys;
            if (mutableScatterSet != null) {
                mutableScatterSet.add(key);
            }
        }
    }

    public final <T> boolean contains(SemanticsPropertyKey<T> key) {
        return this.props.containsKey(key);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsImportantForAccessibility$ui() {
        /*
            r15 = this;
            androidx.collection.MutableScatterMap<androidx.compose.ui.semantics.SemanticsPropertyKey<?>, java.lang.Object> r0 = r15.props
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            java.lang.Object[] r1 = r0.keys
            java.lang.Object[] r2 = r0.values
            long[] r0 = r0.metadata
            int r3 = r0.length
            int r3 = r3 + (-2)
            r4 = 0
            if (r3 < 0) goto L52
            r5 = r4
        L11:
            r6 = r0[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L4d
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2b:
            if (r10 >= r8) goto L4b
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L47
            int r11 = r5 << 3
            int r11 = r11 + r10
            r12 = r1[r11]
            r11 = r2[r11]
            androidx.compose.ui.semantics.SemanticsPropertyKey r12 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r12
            boolean r11 = r12.getIsImportantForAccessibility()
            if (r11 == 0) goto L47
            r0 = 1
            return r0
        L47:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2b
        L4b:
            if (r8 != r9) goto L52
        L4d:
            if (r5 == r3) goto L52
            int r5 = r5 + 1
            goto L11
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.containsImportantForAccessibility$ui():boolean");
    }

    /* JADX INFO: renamed from: isMergingSemanticsOfDescendants, reason: from getter */
    public final boolean getIsMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    public final void setMergingSemanticsOfDescendants(boolean z) {
        this.isMergingSemanticsOfDescendants = z;
    }

    /* JADX INFO: renamed from: isClearingSemantics, reason: from getter */
    public final boolean getIsClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final void setClearingSemantics(boolean z) {
        this.isClearingSemantics = z;
    }

    public final void mergeChild$ui(SemanticsConfiguration child) {
        MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = child.props;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
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
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        SemanticsPropertyKey<?> semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        Object obj3 = this.props.get(semanticsPropertyKey);
                        Intrinsics.checkNotNull(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object objMerge = semanticsPropertyKey.merge(obj3, obj2);
                        if (objMerge != null) {
                            this.props.set(semanticsPropertyKey, objMerge);
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

    public final void collapsePeer$ui(SemanticsConfiguration peer) {
        int i;
        if (peer.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (peer.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = peer.props;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                int i5 = 0;
                while (i5 < i4) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        Object obj = objArr[i6];
                        Object obj2 = objArr2[i6];
                        SemanticsPropertyKey<?> semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        if (!this.props.contains(semanticsPropertyKey)) {
                            this.props.set(semanticsPropertyKey, obj2);
                        } else if (obj2 instanceof AccessibilityAction) {
                            Object obj3 = this.props.get(semanticsPropertyKey);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                            AccessibilityAction accessibilityAction = (AccessibilityAction) obj3;
                            MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap2 = this.props;
                            String label = accessibilityAction.getLabel();
                            if (label == null) {
                                label = ((AccessibilityAction) obj2).getLabel();
                            }
                            i = i3;
                            String str = label;
                            Function action = accessibilityAction.getAction();
                            if (action == null) {
                                action = ((AccessibilityAction) obj2).getAction();
                            }
                            mutableScatterMap2.set(semanticsPropertyKey, new AccessibilityAction(str, action));
                        }
                        i = i3;
                    } else {
                        i = i3;
                    }
                    j >>= i;
                    i5++;
                    i3 = i;
                }
                if (i4 != i3) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) other;
        return Intrinsics.areEqual(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics;
    }

    public int hashCode() {
        return (((this.props.hashCode() * 31) + Boolean.hashCode(this.isMergingSemanticsOfDescendants)) * 31) + Boolean.hashCode(this.isClearingSemantics);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[PHI: r2
      0x007b: PHI (r2v9 java.lang.String) = (r2v8 java.lang.String), (r2v10 java.lang.String) binds: [B:13:0x0042, B:20:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r19 = this;
            r0 = r19
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = r0.isMergingSemanticsOfDescendants
            java.lang.String r3 = ", "
            if (r2 == 0) goto L14
            java.lang.String r2 = "mergeDescendants=true"
            r1.append(r2)
            r2 = r3
            goto L16
        L14:
            java.lang.String r2 = ""
        L16:
            boolean r4 = r0.isClearingSemantics
            if (r4 == 0) goto L23
            r1.append(r2)
            java.lang.String r2 = "isClearingSemantics=true"
            r1.append(r2)
            r2 = r3
        L23:
            androidx.collection.MutableScatterMap<androidx.compose.ui.semantics.SemanticsPropertyKey<?>, java.lang.Object> r4 = r0.props
            androidx.collection.ScatterMap r4 = (androidx.collection.ScatterMap) r4
            java.lang.Object[] r5 = r4.keys
            java.lang.Object[] r6 = r4.values
            long[] r4 = r4.metadata
            int r7 = r4.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L80
            r8 = 0
            r9 = r8
        L34:
            r10 = r4[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L7b
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r8
        L4e:
            if (r14 >= r12) goto L79
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L75
            int r15 = r9 << 3
            int r15 = r15 + r14
            r16 = r5[r15]
            r15 = r6[r15]
            androidx.compose.ui.semantics.SemanticsPropertyKey r16 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r16
            r1.append(r2)
            java.lang.String r2 = r16.getName()
            r1.append(r2)
            java.lang.String r2 = " : "
            r1.append(r2)
            r1.append(r15)
            r2 = r3
        L75:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L4e
        L79:
            if (r12 != r13) goto L80
        L7b:
            if (r9 == r7) goto L80
            int r9 = r9 + 1
            goto L34
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.lang.String r3 = androidx.compose.ui.platform.JvmActuals_jvmKt.simpleIdentityToString(r0, r3)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "{ "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = " }"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.toString():java.lang.String");
    }
}
