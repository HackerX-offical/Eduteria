package androidx.compose.material3;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00128\b\u0002\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010&\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016RA\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "density", "Landroidx/compose/ui/unit/Density;", "topWindowInsets", "", "keyboardSignalState", "Landroidx/compose/runtime/State;", "", "verticalMargin", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "<init>", "(Landroidx/compose/ui/unit/Density;ILandroidx/compose/runtime/State;ILkotlin/jvm/functions/Function2;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTopWindowInsets", "()I", "getKeyboardSignalState", "()Landroidx/compose/runtime/State;", "getVerticalMargin", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final State<Unit> keyboardSignalState;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int topWindowInsets;
    private final int verticalMargin;

    /* JADX WARN: Multi-variable type inference failed */
    public ExposedDropdownMenuPositionProvider(Density density, int i, State<Unit> state, int i2, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.density = density;
        this.topWindowInsets = i;
        this.keyboardSignalState = state;
        this.verticalMargin = i2;
        this.onPositionCalculated = function2;
        this.startToAnchorStart = MenuPosition.startToAnchorStart$default(MenuPosition.INSTANCE, 0, 1, null);
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd$default(MenuPosition.INSTANCE, 0, 1, null);
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft$default(MenuPosition.INSTANCE, 0, 1, null);
        this.rightToWindowRight = MenuPosition.rightToWindowRight$default(MenuPosition.INSTANCE, 0, 1, null);
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom$default(MenuPosition.INSTANCE, 0, 1, null);
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop$default(MenuPosition.INSTANCE, 0, 1, null);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(i2);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(i2);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final int getTopWindowInsets() {
        return this.topWindowInsets;
    }

    public final State<Unit> getKeyboardSignalState() {
        return this.keyboardSignalState;
    }

    public /* synthetic */ ExposedDropdownMenuPositionProvider(Density density, int i, State state, int i2, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, i, (i3 & 4) != 0 ? null : state, (i3 & 8) != 0 ? density.mo482roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i2, (i3 & 16) != 0 ? new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuPositionProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ExposedDropdownMenuPositionProvider._init_$lambda$1((IntRect) obj, (IntRect) obj2);
            }
        } : function2);
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(IntRect intRect, IntRect intRect2) {
        return Unit.INSTANCE;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo450calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        MenuPosition.Horizontal horizontal;
        IntRect intRect;
        char c2;
        long j;
        int iMo4025position95KtPRI;
        MenuPosition.Vertical vertical;
        State<Unit> state = this.keyboardSignalState;
        if (state != null) {
            state.getValue();
        }
        char c3 = ' ';
        long j2 = 4294967295L;
        long jM8996constructorimpl = IntSize.m8996constructorimpl((((long) (((int) (windowSize & 4294967295L)) + this.topWindowInsets)) & 4294967295L) | (((long) ((int) (windowSize >> 32))) << 32));
        MenuPosition.Horizontal[] horizontalArr = new MenuPosition.Horizontal[3];
        int i = 0;
        horizontalArr[0] = this.startToAnchorStart;
        horizontalArr[1] = this.endToAnchorEnd;
        int i2 = (int) (jM8996constructorimpl >> 32);
        if (IntOffset.m8958getXimpl(anchorBounds.m8982getCenternOccac()) < i2 / 2) {
            horizontal = this.leftToWindowLeft;
        } else {
            horizontal = this.rightToWindowRight;
        }
        horizontalArr[2] = horizontal;
        List listListOf = CollectionsKt.listOf((Object[]) horizontalArr);
        int size = listListOf.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                intRect = anchorBounds;
                c2 = c3;
                j = j2;
                iMo4025position95KtPRI = 0;
                break;
            }
            c2 = c3;
            j = j2;
            int i4 = (int) (popupContentSize >> c2);
            int i5 = size;
            int i6 = i3;
            intRect = anchorBounds;
            List list = listListOf;
            iMo4025position95KtPRI = ((MenuPosition.Horizontal) listListOf.get(i3)).mo4025position95KtPRI(intRect, jM8996constructorimpl, i4, layoutDirection);
            if (i6 == CollectionsKt.getLastIndex(list) || (iMo4025position95KtPRI >= 0 && i4 + iMo4025position95KtPRI <= i2)) {
                break;
            }
            i3 = i6 + 1;
            listListOf = list;
            size = i5;
            c3 = c2;
            j2 = j;
        }
        MenuPosition.Vertical[] verticalArr = new MenuPosition.Vertical[3];
        verticalArr[0] = this.topToAnchorBottom;
        verticalArr[1] = this.bottomToAnchorTop;
        int i7 = (int) (jM8996constructorimpl & j);
        if (IntOffset.m8959getYimpl(intRect.m8982getCenternOccac()) < i7 / 2) {
            vertical = this.topToWindowTop;
        } else {
            vertical = this.bottomToWindowBottom;
        }
        verticalArr[2] = vertical;
        List listListOf2 = CollectionsKt.listOf((Object[]) verticalArr);
        int size2 = listListOf2.size();
        for (int i8 = 0; i8 < size2; i8++) {
            int i9 = (int) (popupContentSize & j);
            int iMo4026positionJVtK1S4 = ((MenuPosition.Vertical) listListOf2.get(i8)).mo4026positionJVtK1S4(intRect, jM8996constructorimpl, i9);
            if (i8 == CollectionsKt.getLastIndex(listListOf2) || (iMo4026positionJVtK1S4 >= 0 && i9 + iMo4026positionJVtK1S4 <= i7)) {
                i = iMo4026positionJVtK1S4;
                break;
            }
        }
        long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) iMo4025position95KtPRI) << c2) | (((long) i) & j));
        this.onPositionCalculated.invoke(intRect, IntRectKt.m8991IntRectVbeCjmY(jM8952constructorimpl, popupContentSize));
        return jM8952constructorimpl;
    }
}
