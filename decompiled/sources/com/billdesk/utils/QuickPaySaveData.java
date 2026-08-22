package com.billdesk.utils;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes6.dex */
public class QuickPaySaveData extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f520c;

    public QuickPaySaveData() {
    }

    public QuickPaySaveData(String str, String str2, String str3) {
        this.f518a = str;
        this.f519b = str2;
        this.f520c = str3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle != null) {
            this.f518a = bundle.getString("jsonData");
            this.f519b = bundle.getString("amount");
            this.f520c = bundle.getString("merchant");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("jsonData", this.f518a);
        bundle.putString("amount", this.f519b);
        bundle.putString("merchant", this.f520c);
    }
}
