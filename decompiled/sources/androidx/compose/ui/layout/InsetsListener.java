package androidx.compose.ui.layout;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowInsetsRulers.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0002J\u001e\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020)02H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0018\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0006\u00100\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00100\u001a\u00020\u0010H\u0002J\b\u00109\u001a\u00020'H\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006<"}, d2 = {"Landroidx/compose/ui/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getComposeView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "prepared", "", "runningAnimationMask", "", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "insetsValues", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "displayCutouts", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getDisplayCutouts", "()Landroidx/collection/MutableObjectList;", "displayCutoutRulers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/ui/layout/RectRulers;", "getDisplayCutoutRulers", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "updateInsetAnimationInfo", "insetsValue", "onProgress", "insets", "runningAnimations", "", "onEnd", "stopAnimationForRuler", "onApplyWindowInsets", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "updateInsets", "run", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    public static final int $stable = 8;
    private final AndroidComposeView composeView;
    private final SnapshotStateList<RectRulers> displayCutoutRulers;
    private final MutableObjectList<MutableState<Rect>> displayCutouts;
    private final MutableIntState generation;
    private final ScatterMap<Object, WindowWindowInsetsAnimationValues> insetsValues;
    private boolean prepared;
    private int runningAnimationMask;
    private WindowInsetsCompat savedInsets;

    public InsetsListener(AndroidComposeView androidComposeView) {
        super(1);
        this.composeView = androidComposeView;
        MutableScatterMap mutableScatterMap = new MutableScatterMap(9);
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getCaptionBar(), new WindowWindowInsetsAnimationValues("caption bar"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getDisplayCutout(), new WindowWindowInsetsAnimationValues("display cutout"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getIme(), new WindowWindowInsetsAnimationValues("ime"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getMandatorySystemGestures(), new WindowWindowInsetsAnimationValues("mandatory system gestures"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getNavigationBars(), new WindowWindowInsetsAnimationValues("navigation bars"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getStatusBars(), new WindowWindowInsetsAnimationValues("status bars"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getSystemGestures(), new WindowWindowInsetsAnimationValues("system gestures"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getTappableElement(), new WindowWindowInsetsAnimationValues("tappable element"));
        mutableScatterMap.set(WindowInsetsRulers.INSTANCE.getWaterfall(), new WindowWindowInsetsAnimationValues("waterfall"));
        this.insetsValues = mutableScatterMap;
        this.generation = SnapshotIntStateKt.mutableIntStateOf(0);
        this.displayCutouts = new MutableObjectList<>(4);
        this.displayCutoutRulers = SnapshotStateKt.mutableStateListOf();
    }

    public final AndroidComposeView getComposeView() {
        return this.composeView;
    }

    public final ScatterMap<Object, WindowWindowInsetsAnimationValues> getInsetsValues() {
        return this.insetsValues;
    }

    public final MutableIntState getGeneration() {
        return this.generation;
    }

    public final MutableObjectList<MutableState<Rect>> getDisplayCutouts() {
        return this.displayCutouts;
    }

    public final SnapshotStateList<RectRulers> getDisplayCutoutRulers() {
        return this.displayCutoutRulers;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat animation) {
        this.prepared = true;
        super.onPrepare(animation);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        this.prepared = false;
        this.savedInsets = null;
        if (animation.getDurationMillis() > 0 && windowInsetsCompat != null) {
            int typeMask = animation.getTypeMask();
            this.runningAnimationMask |= typeMask;
            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) WindowInsetsRulers_androidKt.WindowInsetsTypeMap.get(typeMask);
            if (windowInsetsRulers != null) {
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                Insets insets = windowInsetsCompat.getInsets(typeMask);
                long jM7579constructorimpl = ValueInsets.m7579constructorimpl(((long) insets.bottom) | (((long) insets.left) << 48) | (((long) insets.top) << 32) | (((long) insets.right) << 16));
                long current = windowWindowInsetsAnimationValues2.getCurrent();
                if (!ValueInsets.m7581equalsimpl0(jM7579constructorimpl, current)) {
                    windowWindowInsetsAnimationValues2.m7596setSourceValueInsetsYnlvx88(current);
                    windowWindowInsetsAnimationValues2.m7597setTargetValueInsetsYnlvx88(jM7579constructorimpl);
                    windowWindowInsetsAnimationValues2.setAnimating(true);
                    updateInsetAnimationInfo(windowWindowInsetsAnimationValues2, animation);
                    MutableIntState mutableIntState = this.generation;
                    mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
                    Snapshot.INSTANCE.sendApplyNotifications();
                }
            }
        }
        return super.onStart(animation, bounds);
    }

    private final void updateInsetAnimationInfo(WindowWindowInsetsAnimationValues insetsValue, WindowInsetsAnimationCompat animation) {
        insetsValue.setFraction(animation.getInterpolatedFraction());
        insetsValue.setAlpha(animation.getAlpha());
        insetsValue.setDurationMillis(animation.getDurationMillis());
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat animation) {
        this.prepared = false;
        int typeMask = animation.getTypeMask();
        this.runningAnimationMask &= ~typeMask;
        this.savedInsets = null;
        WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) WindowInsetsRulers_androidKt.WindowInsetsTypeMap.get(typeMask);
        if (windowInsetsRulers != null) {
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
            Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
            windowWindowInsetsAnimationValues2.setFraction(0.0f);
            windowWindowInsetsAnimationValues2.setAlpha(1.0f);
            windowWindowInsetsAnimationValues2.setDurationMillis(0L);
            windowWindowInsetsAnimationValues2.setFraction(0.0f);
            stopAnimationForRuler(windowWindowInsetsAnimationValues2);
            MutableIntState mutableIntState = this.generation;
            mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
            Snapshot.INSTANCE.sendApplyNotifications();
        }
        super.onEnd(animation);
    }

    private final void stopAnimationForRuler(WindowWindowInsetsAnimationValues insetsValue) {
        insetsValue.setAnimating(false);
        insetsValue.m7596setSourceValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
        insetsValue.m7597setTargetValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
        if (this.prepared) {
            this.savedInsets = insets;
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
                return insets;
            }
        } else if (this.runningAnimationMask == 0) {
            updateInsets(insets);
        }
        return insets;
    }

    private final void updateInsets(WindowInsetsCompat insets) {
        char c2;
        char c3;
        boolean z;
        char c4;
        boolean z2;
        boolean z3;
        long jM7579constructorimpl;
        long[] jArr;
        int[] iArr;
        Object[] objArr;
        long[] jArr2;
        int[] iArr2;
        long j;
        int i;
        char c5;
        Object[] objArr2;
        IntObjectMap intObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
        int[] iArr3 = intObjectMap.keys;
        Object[] objArr3 = intObjectMap.values;
        long[] jArr3 = intObjectMap.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i2 = 0;
            z2 = false;
            z3 = false;
            char c6 = 16;
            c2 = ' ';
            while (true) {
                long j2 = jArr3[i2];
                c3 = '0';
                z = true;
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j2 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c5 = c6;
                            int i7 = iArr3[i6];
                            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) objArr3[i6];
                            i = i3;
                            Insets insets2 = insets.getInsets(i7);
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            long jM7579constructorimpl2 = ValueInsets.m7579constructorimpl((((long) insets2.left) << 48) | (((long) insets2.top) << 32) | (((long) insets2.right) << c5) | ((long) insets2.bottom));
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                            Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                            j = j2;
                            if (!ValueInsets.m7581equalsimpl0(jM7579constructorimpl2, windowWindowInsetsAnimationValues2.getCurrent())) {
                                windowWindowInsetsAnimationValues2.m7594setCurrentYnlvx88(jM7579constructorimpl2);
                                z2 = true;
                                if (!ValueInsets.m7581equalsimpl0(jM7579constructorimpl2, ValueInsets_androidKt.getZeroValueInsets())) {
                                    z3 = true;
                                }
                            }
                            if (i7 != WindowInsetsCompat.Type.ime()) {
                                Insets insetsIgnoringVisibility = insets.getInsetsIgnoringVisibility(i7);
                                objArr2 = objArr3;
                                long jM7579constructorimpl3 = ValueInsets.m7579constructorimpl((((long) insetsIgnoringVisibility.top) << 32) | (((long) insetsIgnoringVisibility.left) << 48) | (((long) insetsIgnoringVisibility.right) << c5) | ((long) insetsIgnoringVisibility.bottom));
                                if (!ValueInsets.m7581equalsimpl0(windowWindowInsetsAnimationValues2.getMaximum(), jM7579constructorimpl3)) {
                                    windowWindowInsetsAnimationValues2.m7595setMaximumYnlvx88(jM7579constructorimpl3);
                                    z2 = true;
                                    if (!ValueInsets.m7581equalsimpl0(jM7579constructorimpl3, ValueInsets_androidKt.getZeroValueInsets())) {
                                        z3 = true;
                                    }
                                }
                            } else {
                                objArr2 = objArr3;
                            }
                            windowWindowInsetsAnimationValues2.setVisible(insets.isVisible(i7));
                        } else {
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            j = j2;
                            i = i3;
                            c5 = c6;
                            objArr2 = objArr3;
                        }
                        j2 = j >> i;
                        i5++;
                        objArr3 = objArr2;
                        i3 = i;
                        c6 = c5;
                        jArr3 = jArr2;
                        iArr3 = iArr2;
                    }
                    jArr = jArr3;
                    iArr = iArr3;
                    int i8 = i3;
                    c4 = c6;
                    objArr = objArr3;
                    if (i4 != i8) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                    iArr = iArr3;
                    objArr = objArr3;
                    c4 = c6;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                objArr3 = objArr;
                c6 = c4;
                jArr3 = jArr;
                iArr3 = iArr;
            }
        } else {
            c2 = ' ';
            c3 = '0';
            z = true;
            c4 = 16;
            z2 = false;
            z3 = false;
        }
        DisplayCutoutCompat displayCutout = insets.getDisplayCutout();
        if (displayCutout == null) {
            jM7579constructorimpl = ValueInsets_androidKt.getZeroValueInsets();
        } else {
            Insets waterfallInsets = displayCutout.getWaterfallInsets();
            jM7579constructorimpl = ValueInsets.m7579constructorimpl((((long) waterfallInsets.left) << c3) | (((long) waterfallInsets.top) << c2) | (((long) waterfallInsets.right) << c4) | ((long) waterfallInsets.bottom));
        }
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues3 = this.insetsValues.get(WindowInsetsRulers.INSTANCE.getWaterfall());
        Intrinsics.checkNotNull(windowWindowInsetsAnimationValues3);
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues4 = windowWindowInsetsAnimationValues3;
        windowWindowInsetsAnimationValues4.setVisible(!ValueInsets.m7581equalsimpl0(jM7579constructorimpl, ValueInsets_androidKt.getZeroValueInsets()));
        if (!ValueInsets.m7581equalsimpl0(windowWindowInsetsAnimationValues4.getCurrent(), jM7579constructorimpl)) {
            windowWindowInsetsAnimationValues4.m7594setCurrentYnlvx88(jM7579constructorimpl);
            windowWindowInsetsAnimationValues4.m7595setMaximumYnlvx88(jM7579constructorimpl);
            z2 = z;
            if (!ValueInsets.m7581equalsimpl0(jM7579constructorimpl, ValueInsets_androidKt.getZeroValueInsets())) {
                z3 = z2;
            }
        }
        if (displayCutout == null) {
            if (this.displayCutouts.getSize() > 0) {
                this.displayCutouts.clear();
                this.displayCutoutRulers.clear();
                z2 = z;
            }
        } else {
            List<Rect> boundingRects = displayCutout.getBoundingRects();
            if (boundingRects.size() < this.displayCutouts.getSize()) {
                this.displayCutouts.removeRange(boundingRects.size(), this.displayCutouts.getSize());
                this.displayCutoutRulers.removeRange(boundingRects.size(), this.displayCutoutRulers.size());
                z2 = z;
            } else {
                int size = boundingRects.size() - this.displayCutouts.getSize();
                int i9 = 0;
                while (i9 < size) {
                    MutableObjectList<MutableState<Rect>> mutableObjectList = this.displayCutouts;
                    mutableObjectList.add(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundingRects.get(mutableObjectList.getSize()), null, 2, null));
                    this.displayCutoutRulers.add(RectRulersKt.RectRulers("display cutout rect " + this.displayCutouts.getSize()));
                    i9++;
                    z2 = z;
                }
            }
            List<Rect> list = boundingRects;
            int size2 = list.size();
            for (int i10 = 0; i10 < size2; i10++) {
                Rect rect = boundingRects.get(i10);
                MutableState<Rect> mutableState = this.displayCutouts.get(i10);
                if (!Intrinsics.areEqual(mutableState.getValue(), rect)) {
                    mutableState.setValue(rect);
                    z2 = z;
                }
            }
            if (!list.isEmpty()) {
                z3 = z;
            }
        }
        if ((z3 || this.generation.getIntValue() != 0) && z2) {
            MutableIntState mutableIntState = this.generation;
            mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
            Snapshot.INSTANCE.sendApplyNotifications();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prepared) {
            this.runningAnimationMask = 0;
            this.prepared = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                updateInsets(windowInsetsCompat);
                this.savedInsets = null;
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, this);
        ViewCompat.setWindowInsetsAnimationCallback(view, this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, null);
        ViewCompat.setWindowInsetsAnimationCallback(view, null);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        int size = runningAnimations.size();
        for (int i = 0; i < size; i++) {
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = runningAnimations.get(i);
            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) WindowInsetsRulers_androidKt.WindowInsetsTypeMap.get(windowInsetsAnimationCompat.getTypeMask());
            if (windowInsetsRulers != null) {
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                if (windowWindowInsetsAnimationValues2.isAnimating()) {
                    updateInsetAnimationInfo(windowWindowInsetsAnimationValues2, windowInsetsAnimationCompat);
                }
            }
        }
        updateInsets(insets);
        return insets;
    }
}
