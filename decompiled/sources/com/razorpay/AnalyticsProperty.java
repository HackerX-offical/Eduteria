package com.razorpay;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class AnalyticsProperty {
    Scope scope;
    Object value;

    enum Scope {
        PAYMENT,
        ORDER
    }

    AnalyticsProperty(int i, Scope scope) {
        this.value = Integer.valueOf(i);
        this.scope = scope;
    }

    AnalyticsProperty(long j, Scope scope) {
        this.value = Long.valueOf(j);
        this.scope = scope;
    }

    AnalyticsProperty(String str, Scope scope) {
        this.value = str;
        this.scope = scope;
    }

    AnalyticsProperty(boolean z, Scope scope) {
        this.value = Boolean.valueOf(z);
        this.scope = scope;
    }

    AnalyticsProperty(JSONObject jSONObject, Scope scope) {
        this.value = jSONObject;
        this.scope = scope;
    }
}
