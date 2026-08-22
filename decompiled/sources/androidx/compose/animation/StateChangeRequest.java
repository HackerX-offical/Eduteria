package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SharedTransitionStateMachine.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/animation/StateChangeRequest;", "", "<init>", "(Ljava/lang/String;I)V", "NoRequest", "MatchFound", "VisibleContentAbsentDuringTransition", "NoMatchFound", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StateChangeRequest {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StateChangeRequest[] $VALUES;
    public static final StateChangeRequest NoRequest = new StateChangeRequest("NoRequest", 0);
    public static final StateChangeRequest MatchFound = new StateChangeRequest("MatchFound", 1);
    public static final StateChangeRequest VisibleContentAbsentDuringTransition = new StateChangeRequest("VisibleContentAbsentDuringTransition", 2);
    public static final StateChangeRequest NoMatchFound = new StateChangeRequest("NoMatchFound", 3);

    private static final /* synthetic */ StateChangeRequest[] $values() {
        return new StateChangeRequest[]{NoRequest, MatchFound, VisibleContentAbsentDuringTransition, NoMatchFound};
    }

    public static EnumEntries<StateChangeRequest> getEntries() {
        return $ENTRIES;
    }

    public static StateChangeRequest valueOf(String str) {
        return (StateChangeRequest) Enum.valueOf(StateChangeRequest.class, str);
    }

    public static StateChangeRequest[] values() {
        return (StateChangeRequest[]) $VALUES.clone();
    }

    private StateChangeRequest(String str, int i) {
    }

    static {
        StateChangeRequest[] stateChangeRequestArr$values = $values();
        $VALUES = stateChangeRequestArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(stateChangeRequestArr$values);
    }
}
