package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/ScaffoldLayoutContent;", "", "<init>", "(Ljava/lang/String;I)V", "TopBar", "MainContent", "Snackbar", "Fab", "BottomBar", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScaffoldLayoutContent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScaffoldLayoutContent[] $VALUES;
    public static final ScaffoldLayoutContent TopBar = new ScaffoldLayoutContent("TopBar", 0);
    public static final ScaffoldLayoutContent MainContent = new ScaffoldLayoutContent("MainContent", 1);
    public static final ScaffoldLayoutContent Snackbar = new ScaffoldLayoutContent("Snackbar", 2);
    public static final ScaffoldLayoutContent Fab = new ScaffoldLayoutContent("Fab", 3);
    public static final ScaffoldLayoutContent BottomBar = new ScaffoldLayoutContent("BottomBar", 4);

    private static final /* synthetic */ ScaffoldLayoutContent[] $values() {
        return new ScaffoldLayoutContent[]{TopBar, MainContent, Snackbar, Fab, BottomBar};
    }

    public static EnumEntries<ScaffoldLayoutContent> getEntries() {
        return $ENTRIES;
    }

    private ScaffoldLayoutContent(String str, int i) {
    }

    static {
        ScaffoldLayoutContent[] scaffoldLayoutContentArr$values = $values();
        $VALUES = scaffoldLayoutContentArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(scaffoldLayoutContentArr$values);
    }

    public static ScaffoldLayoutContent valueOf(String str) {
        return (ScaffoldLayoutContent) Enum.valueOf(ScaffoldLayoutContent.class, str);
    }

    public static ScaffoldLayoutContent[] values() {
        return (ScaffoldLayoutContent[]) $VALUES.clone();
    }
}
