package androidx.compose.ui.platform.actionmodecallback;

import android.R;
import com.appnew.android.Utils.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TextActionModeCallback.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "", "id", "", Const.ORDER, "<init>", "(Ljava/lang/String;III)V", "getId", "()I", "getOrder", "Copy", "Paste", "Cut", "SelectAll", "Autofill", "titleResource", "getTitleResource", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuItemOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MenuItemOption[] $VALUES;
    private final int id;
    private final int order;
    public static final MenuItemOption Copy = new MenuItemOption("Copy", 0, R.id.copy, 0);
    public static final MenuItemOption Paste = new MenuItemOption("Paste", 1, R.id.paste, 1);
    public static final MenuItemOption Cut = new MenuItemOption("Cut", 2, R.id.cut, 2);
    public static final MenuItemOption SelectAll = new MenuItemOption("SelectAll", 3, R.id.selectAll, 3);
    public static final MenuItemOption Autofill = new MenuItemOption("Autofill", 4, R.id.autofill, 4);

    /* JADX INFO: compiled from: TextActionModeCallback.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MenuItemOption.values().length];
            try {
                iArr[MenuItemOption.Copy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuItemOption.Paste.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuItemOption.Cut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuItemOption.SelectAll.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuItemOption.Autofill.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ MenuItemOption[] $values() {
        return new MenuItemOption[]{Copy, Paste, Cut, SelectAll, Autofill};
    }

    public static EnumEntries<MenuItemOption> getEntries() {
        return $ENTRIES;
    }

    public static MenuItemOption valueOf(String str) {
        return (MenuItemOption) Enum.valueOf(MenuItemOption.class, str);
    }

    public static MenuItemOption[] values() {
        return (MenuItemOption[]) $VALUES.clone();
    }

    private MenuItemOption(String str, int i, int i2, int i3) {
        this.id = i2;
        this.order = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }

    static {
        MenuItemOption[] menuItemOptionArr$values = $values();
        $VALUES = menuItemOptionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(menuItemOptionArr$values);
    }

    public final int getTitleResource() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return R.string.copy;
        }
        if (i == 2) {
            return R.string.paste;
        }
        if (i == 3) {
            return R.string.cut;
        }
        if (i == 4) {
            return R.string.selectAll;
        }
        if (i == 5) {
            return R.string.autofill;
        }
        throw new NoWhenBranchMatchedException();
    }
}
