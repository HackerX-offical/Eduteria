package com.clevertap.android.sdk.inapp.customtemplates;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TemplateArgument.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgument;", "", "name", "", "type", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgumentType;", "defaultValue", "<init>", "(Ljava/lang/String;Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgumentType;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/clevertap/android/sdk/inapp/customtemplates/TemplateArgumentType;", "getDefaultValue", "()Ljava/lang/Object;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TemplateArgument {
    private final Object defaultValue;
    private final String name;
    private final TemplateArgumentType type;

    public TemplateArgument(String name, TemplateArgumentType type, Object obj) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
        this.defaultValue = obj;
    }

    public final String getName() {
        return this.name;
    }

    public final TemplateArgumentType getType() {
        return this.type;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }
}
