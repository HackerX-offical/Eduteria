package com.clevertap.android.sdk.inapp.evaluation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TriggerAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator;", "", "operatorValue", "", "<init>", "(Ljava/lang/String;II)V", "getOperatorValue", "()I", "GreaterThan", "Equals", "LessThan", "Contains", "Between", "NotEquals", "Set", "NotSet", "NotContains", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TriggerOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TriggerOperator[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int operatorValue;
    public static final TriggerOperator GreaterThan = new TriggerOperator("GreaterThan", 0, 0);
    public static final TriggerOperator Equals = new TriggerOperator("Equals", 1, 1);
    public static final TriggerOperator LessThan = new TriggerOperator("LessThan", 2, 2);
    public static final TriggerOperator Contains = new TriggerOperator("Contains", 3, 3);
    public static final TriggerOperator Between = new TriggerOperator("Between", 4, 4);
    public static final TriggerOperator NotEquals = new TriggerOperator("NotEquals", 5, 15);
    public static final TriggerOperator Set = new TriggerOperator("Set", 6, 26);
    public static final TriggerOperator NotSet = new TriggerOperator("NotSet", 7, 27);
    public static final TriggerOperator NotContains = new TriggerOperator("NotContains", 8, 28);

    private static final /* synthetic */ TriggerOperator[] $values() {
        return new TriggerOperator[]{GreaterThan, Equals, LessThan, Contains, Between, NotEquals, Set, NotSet, NotContains};
    }

    public static EnumEntries<TriggerOperator> getEntries() {
        return $ENTRIES;
    }

    private TriggerOperator(String str, int i, int i2) {
        this.operatorValue = i2;
    }

    public final int getOperatorValue() {
        return this.operatorValue;
    }

    static {
        TriggerOperator[] triggerOperatorArr$values = $values();
        $VALUES = triggerOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(triggerOperatorArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: TriggerAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator$Companion;", "", "<init>", "()V", "fromOperatorValue", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator;", "operatorValue", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TriggerOperator fromOperatorValue(int operatorValue) {
            TriggerOperator triggerOperator;
            TriggerOperator[] triggerOperatorArrValues = TriggerOperator.values();
            int length = triggerOperatorArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    triggerOperator = null;
                    break;
                }
                triggerOperator = triggerOperatorArrValues[i];
                if (triggerOperator.getOperatorValue() == operatorValue) {
                    break;
                }
                i++;
            }
            return triggerOperator == null ? TriggerOperator.Equals : triggerOperator;
        }
    }

    public static TriggerOperator valueOf(String str) {
        return (TriggerOperator) Enum.valueOf(TriggerOperator.class, str);
    }

    public static TriggerOperator[] values() {
        return (TriggerOperator[]) $VALUES.clone();
    }
}
