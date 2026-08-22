package com.billdesk.utils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.appnew.android.Utils.Const;
import com.billdesk.sdk.PaymentOptions;
import com.clevertap.android.sdk.Constants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class FragmentStore extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495a = FragmentStore.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PaymentOptions f500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f501g;

    public FragmentStore() {
    }

    public FragmentStore(HashMap<String, Object> map, String str, String str2, Bundle bundle) {
        this.f497c = map;
        this.f499e = str2;
        this.f498d = str;
        this.f501g = bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f500f = (PaymentOptions) activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle != null) {
            String str = "savedInstanceState [" + bundle + Constants.AES_SUFFIX;
            this.f497c = (HashMap) bundle.getSerializable("valMap");
            this.f499e = bundle.getString(Const.MOBILE);
            string = bundle.getString("email");
        } else {
            this.f497c = this.f497c;
            this.f499e = this.f499e;
            string = this.f498d;
        }
        this.f498d = string;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("valMap", this.f497c);
        bundle.putString(Const.MOBILE, this.f499e);
        bundle.putString("email", this.f498d);
        String str = "Saving instance [" + bundle + Constants.AES_SUFFIX;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0236  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.LayoutInflater r22, android.view.ViewGroup r23, android.os.Bundle r24) {
        /*
            Method dump skipped, instruction units count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.billdesk.utils.FragmentStore.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }
}
