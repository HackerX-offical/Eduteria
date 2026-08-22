package com.clevertap.android.sdk.inapp.evaluation;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TriggerAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/TriggerCondition;", "", TriggerAdapter.INAPP_PROPERTYNAME, "", "op", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator;", "value", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerValue;", "<init>", "(Ljava/lang/String;Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator;Lcom/clevertap/android/sdk/inapp/evaluation/TriggerValue;)V", "getPropertyName", "()Ljava/lang/String;", "getOp", "()Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator;", "getValue", "()Lcom/clevertap/android/sdk/inapp/evaluation/TriggerValue;", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class TriggerCondition {
    private final TriggerOperator op;
    private final String propertyName;
    private final TriggerValue value;

    public static /* synthetic */ TriggerCondition copy$default(TriggerCondition triggerCondition, String str, TriggerOperator triggerOperator, TriggerValue triggerValue, int i, Object obj) {
        if ((i & 1) != 0) {
            str = triggerCondition.propertyName;
        }
        if ((i & 2) != 0) {
            triggerOperator = triggerCondition.op;
        }
        if ((i & 4) != 0) {
            triggerValue = triggerCondition.value;
        }
        return triggerCondition.copy(str, triggerOperator, triggerValue);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPropertyName() {
        return this.propertyName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TriggerOperator getOp() {
        return this.op;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TriggerValue getValue() {
        return this.value;
    }

    public final TriggerCondition copy(String propertyName, TriggerOperator op, TriggerValue value) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(value, "value");
        return new TriggerCondition(propertyName, op, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TriggerCondition)) {
            return false;
        }
        TriggerCondition triggerCondition = (TriggerCondition) other;
        return Intrinsics.areEqual(this.propertyName, triggerCondition.propertyName) && this.op == triggerCondition.op && Intrinsics.areEqual(this.value, triggerCondition.value);
    }

    public int hashCode() {
        return (((this.propertyName.hashCode() * 31) + this.op.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "TriggerCondition(propertyName=" + this.propertyName + ", op=" + this.op + ", value=" + this.value + ')';
    }

    public TriggerCondition(String propertyName, TriggerOperator op, TriggerValue value) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(value, "value");
        this.propertyName = propertyName;
        this.op = op;
        this.value = value;
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public final TriggerOperator getOp() {
        return this.op;
    }

    public final TriggerValue getValue() {
        return this.value;
    }
}
