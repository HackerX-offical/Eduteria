package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuPosition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00128\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010&\u001a\u00020'2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b0\u0010\u0013J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J9\u00103\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0003Jh\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u000728\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tHÆ\u0001¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RA\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "verticalMargin", "", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "", "<init>", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getVerticalMargin", "()I", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "component4", Constants.COPY_TYPE, "copy-uVxBXkw", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;)Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, int i, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, i, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-uVxBXkw$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m4056copyuVxBXkw$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        Density density2 = density;
        if ((i2 & 4) != 0) {
            i = dropdownMenuPositionProvider.verticalMargin;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m4058copyuVxBXkw(j2, density2, i3, function2);
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name and from getter */
    public final long getContentOffset() {
        return this.contentOffset;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public final Function2<IntRect, IntRect, Unit> component4() {
        return this.onPositionCalculated;
    }

    /* JADX INFO: renamed from: copy-uVxBXkw, reason: not valid java name */
    public final DropdownMenuPositionProvider m4058copyuVxBXkw(long contentOffset, Density density, int verticalMargin, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated) {
        return new DropdownMenuPositionProvider(contentOffset, density, verticalMargin, onPositionCalculated, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m8890equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((((DpOffset.m8895hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + Integer.hashCode(this.verticalMargin)) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m8898toStringimpl(this.contentOffset)) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long j, Density density, int i, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j;
        this.density = density;
        this.verticalMargin = i;
        this.onPositionCalculated = function2;
        int iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(DpOffset.m8891getXD9Ej5fM(j));
        this.startToAnchorStart = MenuPosition.INSTANCE.startToAnchorStart(iMo482roundToPx0680j_4);
        this.endToAnchorEnd = MenuPosition.INSTANCE.endToAnchorEnd(iMo482roundToPx0680j_4);
        this.leftToWindowLeft = MenuPosition.INSTANCE.leftToWindowLeft(0);
        this.rightToWindowRight = MenuPosition.INSTANCE.rightToWindowRight(0);
        int iMo482roundToPx0680j_42 = density.mo482roundToPx0680j_4(DpOffset.m8893getYD9Ej5fM(j));
        this.topToAnchorBottom = MenuPosition.INSTANCE.topToAnchorBottom(iMo482roundToPx0680j_42);
        this.bottomToAnchorTop = MenuPosition.INSTANCE.bottomToAnchorTop(iMo482roundToPx0680j_42);
        this.centerToAnchorTop = MenuPosition.INSTANCE.centerToAnchorTop(iMo482roundToPx0680j_42);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(i);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(i);
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m4059getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, int i, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, (i2 & 4) != 0 ? density.mo482roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i, (i2 & 8) != 0 ? new Function2() { // from class: androidx.compose.material3.internal.DropdownMenuPositionProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DropdownMenuPositionProvider._init_$lambda$1((IntRect) obj, (IntRect) obj2);
            }
        } : function2, null);
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
        long j;
        char c2;
        int iMo4025position95KtPRI;
        MenuPosition.Vertical vertical;
        int iMo4026positionJVtK1S4;
        int i;
        char c3 = 3;
        MenuPosition.Horizontal[] horizontalArr = new MenuPosition.Horizontal[3];
        horizontalArr[0] = this.startToAnchorStart;
        horizontalArr[1] = this.endToAnchorEnd;
        int i2 = (int) (windowSize >> 32);
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
                j = windowSize;
                c2 = c3;
                iMo4025position95KtPRI = 0;
                break;
            }
            MenuPosition.Horizontal horizontal2 = (MenuPosition.Horizontal) listListOf.get(i3);
            int i4 = (int) (popupContentSize >> 32);
            int i5 = size;
            c2 = c3;
            j = windowSize;
            int i6 = i3;
            intRect = anchorBounds;
            iMo4025position95KtPRI = horizontal2.mo4025position95KtPRI(intRect, j, i4, layoutDirection);
            if (i6 == CollectionsKt.getLastIndex(listListOf) || (iMo4025position95KtPRI >= 0 && i4 + iMo4025position95KtPRI <= i2)) {
                break;
            }
            i3 = i6 + 1;
            size = i5;
            c3 = c2;
        }
        MenuPosition.Vertical[] verticalArr = new MenuPosition.Vertical[4];
        verticalArr[0] = this.topToAnchorBottom;
        verticalArr[1] = this.bottomToAnchorTop;
        verticalArr[2] = this.centerToAnchorTop;
        int i7 = (int) (j & 4294967295L);
        if (IntOffset.m8959getYimpl(intRect.m8982getCenternOccac()) < i7 / 2) {
            vertical = this.topToWindowTop;
        } else {
            vertical = this.bottomToWindowBottom;
        }
        verticalArr[c2] = vertical;
        List listListOf2 = CollectionsKt.listOf((Object[]) verticalArr);
        int size2 = listListOf2.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size2) {
                iMo4026positionJVtK1S4 = 0;
                break;
            }
            int i9 = i7;
            int i10 = (int) (popupContentSize & 4294967295L);
            iMo4026positionJVtK1S4 = ((MenuPosition.Vertical) listListOf2.get(i8)).mo4026positionJVtK1S4(intRect, j, i10);
            if (i8 == CollectionsKt.getLastIndex(listListOf2) || (iMo4026positionJVtK1S4 >= (i = this.verticalMargin) && i10 + iMo4026positionJVtK1S4 <= i9 - i)) {
                break;
            }
            i8++;
            i7 = i9;
        }
        long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) iMo4025position95KtPRI) << 32) | (((long) iMo4026positionJVtK1S4) & 4294967295L));
        this.onPositionCalculated.invoke(intRect, IntRectKt.m8991IntRectVbeCjmY(jM8952constructorimpl, popupContentSize));
        return jM8952constructorimpl;
    }
}
