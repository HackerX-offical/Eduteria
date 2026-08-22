package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LineHeightStyleSpan.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ8\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0002J'\u0010*\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u001e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u0006,"}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "mode", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "<init>", "(FIIZZFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineHeight", "()F", "getTrimFirstLineTop", "()Z", "getTrimLastLineBottom", "getMode-lzQqcRY", "()I", "I", "firstAscent", "ascent", "descent", "lastDescent", "value", "firstAscentDiff", "getFirstAscentDiff", "lastDescentDiff", "getLastDescentDiff", "chooseHeight", "", "text", "", "start", "end", "spanStartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "calculateTargetMetrics", Constants.COPY_TYPE, "copy$ui_text", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 8;
    private int ascent;
    private int descent;
    private final int endIndex;
    private int firstAscent;
    private int firstAscentDiff;
    private int lastDescent;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int mode;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;

    public /* synthetic */ LineHeightStyleSpan(float f2, int i, int i2, boolean z, boolean z2, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, i, i2, z, z2, f3, i3);
    }

    private LineHeightStyleSpan(float f2, int i, int i2, boolean z, boolean z2, float f3, int i3) {
        this.lineHeight = f2;
        this.startIndex = i;
        this.endIndex = i2;
        this.trimFirstLineTop = z;
        this.trimLastLineBottom = z2;
        this.topRatio = f3;
        this.mode = i3;
        this.firstAscent = Integer.MIN_VALUE;
        this.ascent = Integer.MIN_VALUE;
        this.descent = Integer.MIN_VALUE;
        this.lastDescent = Integer.MIN_VALUE;
        if ((0.0f <= f3 && f3 <= 1.0f) || f3 == -1.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getTrimFirstLineTop() {
        return this.trimFirstLineTop;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }

    /* JADX INFO: renamed from: getMode-lzQqcRY, reason: not valid java name and from getter */
    public final int getMode() {
        return this.mode;
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanStartVertical, int lineHeight, Paint.FontMetricsInt fontMetricsInt) {
        if (LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt) <= 0) {
            return;
        }
        boolean z = start == this.startIndex;
        boolean z2 = end == this.endIndex;
        if (z && z2 && this.trimFirstLineTop && this.trimLastLineBottom && !LineHeightStyle.Mode.m8681equalsimpl0(this.mode, LineHeightStyle.Mode.INSTANCE.m8687getTightlzQqcRY())) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = z ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z2 ? this.lastDescent : this.descent;
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        double dCeil;
        int iMin;
        int iMax;
        int iCeil = (int) Math.ceil(this.lineHeight);
        int iLineHeight = iCeil - LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        if (LineHeightStyle.Mode.m8681equalsimpl0(this.mode, LineHeightStyle.Mode.INSTANCE.m8686getMinimumlzQqcRY()) && iLineHeight <= 0) {
            this.ascent = fontMetricsInt.ascent;
            int i = fontMetricsInt.descent;
            this.descent = i;
            this.firstAscent = this.ascent;
            this.lastDescent = i;
            this.firstAscentDiff = 0;
            this.lastDescentDiff = 0;
            return;
        }
        float fAbs = this.topRatio;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        }
        if (iLineHeight <= 0) {
            dCeil = Math.ceil(iLineHeight * fAbs);
        } else {
            dCeil = Math.ceil(iLineHeight * (1.0f - fAbs));
        }
        int i2 = fontMetricsInt.descent + ((int) dCeil);
        this.descent = i2;
        this.ascent = i2 - iCeil;
        if (LineHeightStyle.Mode.m8681equalsimpl0(this.mode, LineHeightStyle.Mode.INSTANCE.m8685getFixedlzQqcRY()) || iLineHeight >= 0) {
            this.firstAscent = this.trimFirstLineTop ? fontMetricsInt.ascent : this.ascent;
            this.lastDescent = this.trimLastLineBottom ? fontMetricsInt.descent : this.descent;
            this.firstAscentDiff = fontMetricsInt.ascent - this.firstAscent;
            this.lastDescentDiff = this.lastDescent - fontMetricsInt.descent;
            return;
        }
        if (LineHeightStyle.Mode.m8681equalsimpl0(this.mode, LineHeightStyle.Mode.INSTANCE.m8687getTightlzQqcRY())) {
            if (this.trimFirstLineTop) {
                iMin = Math.max(fontMetricsInt.ascent, this.ascent);
            } else {
                iMin = Math.min(fontMetricsInt.ascent, this.ascent);
            }
            this.firstAscent = iMin;
            if (this.trimLastLineBottom) {
                iMax = Math.min(fontMetricsInt.descent, this.descent);
            } else {
                iMax = Math.max(fontMetricsInt.descent, this.descent);
            }
            this.lastDescent = iMax;
            this.firstAscentDiff = 0;
            this.lastDescentDiff = 0;
        }
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text$default(LineHeightStyleSpan lineHeightStyleSpan, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text(i, i2, z);
    }

    public final LineHeightStyleSpan copy$ui_text(int startIndex, int endIndex, boolean trimFirstLineTop) {
        return new LineHeightStyleSpan(this.lineHeight, startIndex, endIndex, trimFirstLineTop, this.trimLastLineBottom, this.topRatio, this.mode, null);
    }
}
