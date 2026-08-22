package com.billdesk.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.appnew.android.Utils.Const;
import com.billdesk.sdk.CreditCardView;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class CraditCardFragmentStrore extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CreditCardView f479b;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f479b = (CreditCardView) activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("data");
            this.f478a = bundle2;
            PaymentLibConstants.f514e = bundle2.getString("amount");
            PaymentLibConstants.l = this.f478a.getBoolean("remember");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setWeightSum(10.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, getContext()));
        CreditCardView creditCardView = this.f479b;
        creditCardView.getClass();
        LinearLayout linearLayoutA = Helper.a("", (Activity) creditCardView);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getConfiguration().orientation == 2 ? 38 : 12);
        layoutParams2.weight = 1.0f;
        linearLayoutA.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayoutA);
        linearLayout.addView(this.f479b.a(this.f478a));
        linearLayout.addView(this.f479b.a(true));
        return linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CreditCardView creditCardView = this.f479b;
        creditCardView.getClass();
        Bundle bundle2 = new Bundle();
        try {
            bundle2.putString("cardNo", creditCardView.f367c.getText().toString());
            bundle2.putString("ccvNo", creditCardView.f368d.getText().toString());
            bundle2.putString("holderName", creditCardView.f369e.getText().toString());
            bundle2.putInt("indexOfMonth", creditCardView.p.getSelectedItemPosition());
            bundle2.putInt("indexOfYear", creditCardView.q.getSelectedItemPosition());
            bundle2.putInt("indexOfCountry", creditCardView.r.getSelectedItemPosition());
            if (creditCardView.z != null) {
                bundle2.putBoolean("rememberMe", creditCardView.z.isChecked());
            }
            if (creditCardView.A != null) {
                bundle2.putBoolean("siCB", creditCardView.A.isChecked());
            }
            bundle2.putString("amount", PaymentLibConstants.f514e);
            bundle2.putBoolean("remember", PaymentLibConstants.l);
            bundle2.putString("batchcode", creditCardView.f370f.getText().toString());
            if ("CCPSI".equalsIgnoreCase(creditCardView.v) || "CCPSI-C".equalsIgnoreCase(creditCardView.v)) {
                bundle2.putString(Const.MOBILE, creditCardView.o.getText().toString());
                bundle2.putString("emailId", creditCardView.n.getText().toString());
            } else {
                int i = 0;
                while (true) {
                    if (i >= creditCardView.H.length) {
                        break;
                    }
                    String str = "for i " + i;
                    if (creditCardView.H[i].isChecked()) {
                        String str2 = "found checked i " + i;
                        bundle2.putBoolean("restoreRadio", true);
                        bundle2.putInt("checkedBox", i);
                        break;
                    }
                    i++;
                }
                String str3 = "value of after radio check i " + i;
                if (i < 2) {
                    bundle2.putString(Const.MOBILE, creditCardView.o.getText().toString());
                    bundle2.putString("emailId", creditCardView.n.getText().toString());
                    String str4 = "data saved in bundle \tfor indian cust is [" + creditCardView.o.getText().toString() + "] and email[" + creditCardView.n.getText().toString() + Constants.AES_SUFFIX;
                    if (i == 1) {
                        bundle2.putString("fName", creditCardView.f371g.getText().toString());
                        bundle2.putString("mName", creditCardView.f372h.getText().toString());
                        bundle2.putString("lName", creditCardView.i.getText().toString());
                        bundle2.putString("addR", creditCardView.j.getText().toString());
                        bundle2.putString("cityTown", creditCardView.k.getText().toString());
                        bundle2.putString("stateProvince", creditCardView.l.getText().toString());
                        bundle2.putString("zipCode", creditCardView.m.getText().toString());
                        bundle2.putInt("countrySpinner", creditCardView.r.getSelectedItemPosition());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str5 = "data saved in bundle[" + bundle2.toString() + Constants.AES_SUFFIX;
        this.f478a = bundle2;
        bundle.putBundle("data", bundle2);
    }
}
