package androidx.compose.foundation.text;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CommonContextMenuArea.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/TextContextMenuItems;", "", "key", "", "stringId", "Landroidx/compose/foundation/text/ContextMenuStrings;", "drawableId", "Landroidx/compose/foundation/text/ContextMenuIcons;", "<init>", "(Ljava/lang/String;ILjava/lang/Object;II)V", "getKey", "()Ljava/lang/Object;", "getStringId-9Hzcbyc", "()I", "I", "getDrawableId-3I4p1mQ", "Cut", "Copy", "Paste", "SelectAll", "Autofill", "resolvedString", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextContextMenuItems {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextContextMenuItems[] $VALUES;
    private final int drawableId;
    private final Object key;
    private final int stringId;
    public static final TextContextMenuItems Cut = new TextContextMenuItems("Cut", 0, TextContextMenuKeys.INSTANCE.getCutKey(), ContextMenuStrings.INSTANCE.m1701getCut9Hzcbyc(), ContextMenuIcons.INSTANCE.m1688getActionModeCutDrawable3I4p1mQ());
    public static final TextContextMenuItems Copy = new TextContextMenuItems("Copy", 1, TextContextMenuKeys.INSTANCE.getCopyKey(), ContextMenuStrings.INSTANCE.m1700getCopy9Hzcbyc(), ContextMenuIcons.INSTANCE.m1687getActionModeCopyDrawable3I4p1mQ());
    public static final TextContextMenuItems Paste = new TextContextMenuItems("Paste", 2, TextContextMenuKeys.INSTANCE.getPasteKey(), ContextMenuStrings.INSTANCE.m1702getPaste9Hzcbyc(), ContextMenuIcons.INSTANCE.m1689getActionModePasteDrawable3I4p1mQ());
    public static final TextContextMenuItems SelectAll = new TextContextMenuItems("SelectAll", 3, TextContextMenuKeys.INSTANCE.getSelectAllKey(), ContextMenuStrings.INSTANCE.m1703getSelectAll9Hzcbyc(), ContextMenuIcons.INSTANCE.m1690getActionModeSelectAllDrawable3I4p1mQ());
    public static final TextContextMenuItems Autofill = new TextContextMenuItems("Autofill", 4, TextContextMenuKeys.INSTANCE.getAutofillKey(), ContextMenuStrings.INSTANCE.m1699getAutofill9Hzcbyc(), ContextMenuIcons.INSTANCE.m1691getID_NULL3I4p1mQ());

    private static final /* synthetic */ TextContextMenuItems[] $values() {
        return new TextContextMenuItems[]{Cut, Copy, Paste, SelectAll, Autofill};
    }

    public static EnumEntries<TextContextMenuItems> getEntries() {
        return $ENTRIES;
    }

    public static TextContextMenuItems valueOf(String str) {
        return (TextContextMenuItems) Enum.valueOf(TextContextMenuItems.class, str);
    }

    public static TextContextMenuItems[] values() {
        return (TextContextMenuItems[]) $VALUES.clone();
    }

    private TextContextMenuItems(String str, int i, Object obj, int i2, int i3) {
        this.key = obj;
        this.stringId = i2;
        this.drawableId = i3;
    }

    public final Object getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: getStringId-9Hzcbyc, reason: not valid java name and from getter */
    public final int getStringId() {
        return this.stringId;
    }

    /* JADX INFO: renamed from: getDrawableId-3I4p1mQ, reason: not valid java name and from getter */
    public final int getDrawableId() {
        return this.drawableId;
    }

    static {
        TextContextMenuItems[] textContextMenuItemsArr$values = $values();
        $VALUES = textContextMenuItemsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(textContextMenuItemsArr$values);
    }

    public final String resolvedString(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 479426150, "C(resolvedString)178@7376L19:CommonContextMenuArea.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(479426150, i, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (CommonContextMenuArea.kt:178)");
        }
        String strM1704getStringtk4Tqcs = ContextMenuStrings_androidKt.m1704getStringtk4Tqcs(this.stringId, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strM1704getStringtk4Tqcs;
    }
}
