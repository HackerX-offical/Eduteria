package androidx.window.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: VerificationMode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/core/VerificationMode;", "", "<init>", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VerificationMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VerificationMode[] $VALUES;
    public static final VerificationMode STRICT = new VerificationMode("STRICT", 0);
    public static final VerificationMode LOG = new VerificationMode("LOG", 1);
    public static final VerificationMode QUIET = new VerificationMode("QUIET", 2);

    private static final /* synthetic */ VerificationMode[] $values() {
        return new VerificationMode[]{STRICT, LOG, QUIET};
    }

    public static EnumEntries<VerificationMode> getEntries() {
        return $ENTRIES;
    }

    public static VerificationMode valueOf(String str) {
        return (VerificationMode) Enum.valueOf(VerificationMode.class, str);
    }

    public static VerificationMode[] values() {
        return (VerificationMode[]) $VALUES.clone();
    }

    private VerificationMode(String str, int i) {
    }

    static {
        VerificationMode[] verificationModeArr$values = $values();
        $VALUES = verificationModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(verificationModeArr$values);
    }
}
