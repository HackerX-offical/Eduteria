package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontVariation;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Font.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000f¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/ResourceFont;", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "<init>", "(ILandroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getResId", "()I", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "I", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "getLoadingStrategy-PKNRLFQ$annotations", "()V", "getLoadingStrategy-PKNRLFQ", Constants.COPY_TYPE, "copy-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/ResourceFont;", "copy-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/ResourceFont;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceFont implements Font {
    public static final int $stable = 0;
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final FontVariation.Settings variationSettings;
    private final FontWeight weight;

    public /* synthetic */ ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, fontWeight, i2, settings, i3);
    }

    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ$annotations, reason: not valid java name */
    public static /* synthetic */ void m8427getLoadingStrategyPKNRLFQ$annotations() {
    }

    private ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3) {
        this.resId = i;
        this.weight = fontWeight;
        this.style = i2;
        this.variationSettings = settings;
        this.loadingStrategy = i3;
    }

    public final int getResId() {
        return this.resId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        FontWeight normal = (i4 & 2) != 0 ? FontWeight.INSTANCE.getNormal() : fontWeight;
        int iM8394getNormal_LCdwA = (i4 & 4) != 0 ? FontStyle.INSTANCE.m8394getNormal_LCdwA() : i2;
        this(i, normal, iM8394getNormal_LCdwA, (i4 & 8) != 0 ? FontVariation.INSTANCE.m8410Settings6EWAqTQ(normal, iM8394getNormal_LCdwA, new FontVariation.Setting[0]) : settings, (i4 & 16) != 0 ? FontLoadingStrategy.INSTANCE.m8378getAsyncPKNRLFQ() : i3, null);
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: from getter */
    public int getStyle() {
        return this.style;
    }

    public final FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ, reason: from getter */
    public int getLoadingStrategy() {
        return this.loadingStrategy;
    }

    /* JADX INFO: renamed from: copy-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ ResourceFont m8426copyRetOiIg$default(ResourceFont resourceFont, int i, FontWeight fontWeight, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = resourceFont.resId;
        }
        if ((i3 & 2) != 0) {
            fontWeight = resourceFont.getWeight();
        }
        if ((i3 & 4) != 0) {
            i2 = resourceFont.getStyle();
        }
        return resourceFont.m8429copyRetOiIg(i, fontWeight, i2);
    }

    /* JADX INFO: renamed from: copy-RetOiIg, reason: not valid java name */
    public final ResourceFont m8429copyRetOiIg(int resId, FontWeight weight, int style) {
        return m8425copyF3nL8kk$default(this, resId, weight, style, getLoadingStrategy(), null, 16, null);
    }

    /* JADX INFO: renamed from: copy-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ ResourceFont m8425copyF3nL8kk$default(ResourceFont resourceFont, int i, FontWeight fontWeight, int i2, int i3, FontVariation.Settings settings, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = resourceFont.resId;
        }
        if ((i4 & 2) != 0) {
            fontWeight = resourceFont.getWeight();
        }
        if ((i4 & 4) != 0) {
            i2 = resourceFont.getStyle();
        }
        if ((i4 & 8) != 0) {
            i3 = resourceFont.getLoadingStrategy();
        }
        if ((i4 & 16) != 0) {
            settings = resourceFont.variationSettings;
        }
        FontVariation.Settings settings2 = settings;
        int i5 = i2;
        return resourceFont.m8428copyF3nL8kk(i, fontWeight, i5, i3, settings2);
    }

    /* JADX INFO: renamed from: copy-F3nL8kk, reason: not valid java name */
    public final ResourceFont m8428copyF3nL8kk(int resId, FontWeight weight, int style, int loadingStrategy, FontVariation.Settings variationSettings) {
        return new ResourceFont(resId, weight, style, variationSettings, loadingStrategy, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) other;
        return this.resId == resourceFont.resId && Intrinsics.areEqual(getWeight(), resourceFont.getWeight()) && FontStyle.m8387equalsimpl0(getStyle(), resourceFont.getStyle()) && Intrinsics.areEqual(this.variationSettings, resourceFont.variationSettings) && FontLoadingStrategy.m8374equalsimpl0(getLoadingStrategy(), resourceFont.getLoadingStrategy());
    }

    public int hashCode() {
        return (((((((this.resId * 31) + getWeight().hashCode()) * 31) + FontStyle.m8388hashCodeimpl(getStyle())) * 31) + FontLoadingStrategy.m8375hashCodeimpl(getLoadingStrategy())) * 31) + this.variationSettings.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m8389toStringimpl(getStyle())) + ", loadingStrategy=" + ((Object) FontLoadingStrategy.m8376toStringimpl(getLoadingStrategy())) + ')';
    }
}
