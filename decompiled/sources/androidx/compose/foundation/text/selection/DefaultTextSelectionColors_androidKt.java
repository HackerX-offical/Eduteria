package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultTextSelectionColors.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"DefaultSelectionColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getDefaultTextSelectionColors$annotations", "()V", "getDefaultTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DefaultTextSelectionColors_androidKt {
    private static final long DefaultSelectionColor;
    private static final TextSelectionColors DefaultTextSelectionColors;

    public static /* synthetic */ void getDefaultTextSelectionColors$annotations() {
    }

    static {
        long jColor = ColorKt.Color(4282550004L);
        DefaultSelectionColor = jColor;
        DefaultTextSelectionColors = new TextSelectionColors(jColor, Color.m5967copywmQWz5c$default(jColor, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    public static final TextSelectionColors getDefaultTextSelectionColors() {
        return DefaultTextSelectionColors;
    }
}
