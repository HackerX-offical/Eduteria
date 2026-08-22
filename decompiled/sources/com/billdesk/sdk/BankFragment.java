package com.billdesk.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BankFragment extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f345b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<String, Object> f350g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344a = BankFragment.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TreeMap<String, ArrayList<a.a.b.b>> f346c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f347d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f348e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a.a.b.b f349f = null;

    public class a extends ArrayAdapter<c> {
        public a(Context context, int i, List list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            View dropDownView = super.getDropDownView(i, view, viewGroup);
            ((TextView) dropDownView.findViewById(android.R.id.text1)).setTextColor(BankFragment.this.getResources().getColor(R.color.bd_loader_text));
            return dropDownView;
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            c cVar = (c) adapterView.getItemAtPosition(i);
            String str = BankFragment.this.f344a;
            String str2 = "Option selected [" + cVar.f353a + Constants.AES_SUFFIX;
            BankFragment bankFragment = BankFragment.this;
            bankFragment.f349f = null;
            BankFragment.this.f345b.removeView(bankFragment.f345b.findViewWithTag("tenureList"));
            if (cVar.f353a.equals("NA")) {
                return;
            }
            ArrayList<a.a.b.b> arrayList = BankFragment.this.f346c.get(cVar.f353a);
            BankFragment bankFragment2 = BankFragment.this;
            bankFragment2.getClass();
            LinearLayout linearLayout = new LinearLayout(bankFragment2.getActivity());
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout.addView(bankFragment2.a(false));
            LinearLayout linearLayout2 = new LinearLayout(bankFragment2.getActivity());
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.setWeightSum(14.0f);
            linearLayout2.addView(bankFragment2.a(true));
            TextView textView = new TextView(bankFragment2.getActivity());
            TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(0, -2);
            ((LinearLayout.LayoutParams) layoutParams2).weight = 4.0f;
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 17;
            textView.setLayoutParams(layoutParams2);
            textView.setText("Tenure");
            textView.setGravity(17);
            int i2 = bankFragment2.f348e / 2;
            textView.setPadding(0, i2, 0, i2);
            Helper.a(textView, true, (Activity) bankFragment2.getActivity());
            textView.setTextSize(2, 13.0f);
            linearLayout2.addView(textView);
            linearLayout2.addView(bankFragment2.a(true));
            TextView textView2 = new TextView(bankFragment2.getActivity());
            TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(0, -2);
            ((LinearLayout.LayoutParams) layoutParams3).weight = 2.0f;
            ((LinearLayout.LayoutParams) layoutParams3).gravity = 17;
            textView2.setLayoutParams(layoutParams3);
            textView2.setText("Int. Rate");
            textView2.setGravity(17);
            int i3 = bankFragment2.f348e / 2;
            textView2.setPadding(0, i3, 0, i3);
            Helper.a(textView2, true, (Activity) bankFragment2.getActivity());
            textView2.setTextSize(2, 13.0f);
            linearLayout2.addView(textView2);
            linearLayout2.addView(bankFragment2.a(true));
            TextView textView3 = new TextView(bankFragment2.getActivity());
            TableRow.LayoutParams layoutParams4 = new TableRow.LayoutParams(0, -2);
            ((LinearLayout.LayoutParams) layoutParams4).weight = 4.0f;
            ((LinearLayout.LayoutParams) layoutParams4).gravity = 17;
            textView3.setLayoutParams(layoutParams4);
            textView3.setText(PWEStaticDataModel.EMI_DISPLAY_NAME);
            textView3.setGravity(17);
            int i4 = bankFragment2.f348e / 2;
            textView3.setPadding(0, i4, 0, i4);
            Helper.a(textView3, true, (Activity) bankFragment2.getActivity());
            textView3.setTextSize(2, 13.0f);
            linearLayout2.addView(textView3);
            linearLayout2.addView(bankFragment2.a(true));
            TextView textView4 = new TextView(bankFragment2.getActivity());
            TableRow.LayoutParams layoutParams5 = new TableRow.LayoutParams(0, -2);
            ((LinearLayout.LayoutParams) layoutParams5).weight = 4.0f;
            ((LinearLayout.LayoutParams) layoutParams5).gravity = 17;
            textView4.setLayoutParams(layoutParams5);
            textView4.setText("Int. Payable");
            textView4.setGravity(17);
            int i5 = bankFragment2.f348e / 2;
            textView4.setPadding(0, i5, 0, i5);
            Helper.a(textView4, true, (Activity) bankFragment2.getActivity());
            textView4.setTextSize(2, 13.0f);
            linearLayout2.addView(textView4);
            linearLayout2.addView(bankFragment2.a(true));
            linearLayout.addView(linearLayout2);
            linearLayout.addView(bankFragment2.a(false));
            int i6 = 0;
            while (i6 < arrayList.size()) {
                a.a.b.b bVar = arrayList.get(i6);
                float f2 = Float.parseFloat(bVar.f140e) / 1200.0f;
                int i7 = Integer.parseInt(bVar.f138c);
                int i8 = i6;
                double d2 = f2 + 1.0f;
                ArrayList<a.a.b.b> arrayList2 = arrayList;
                double d3 = i7;
                int i9 = (int) ((((double) (Float.parseFloat(PaymentLibConstants.f514e) * f2)) * Math.pow(d2, d3)) / (Math.pow(d2, d3) - 1.0d));
                LinearLayout linearLayout3 = new LinearLayout(bankFragment2.getActivity());
                linearLayout3.setOrientation(0);
                linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                linearLayout3.setWeightSum(14.0f);
                linearLayout3.addView(bankFragment2.a(true));
                LinearLayout linearLayout4 = new LinearLayout(bankFragment2.getActivity());
                linearLayout4.setOrientation(0);
                linearLayout4.setLayoutParams(layoutParams2);
                RadioButton radioButton = new RadioButton(bankFragment2.getActivity());
                radioButton.setLayoutParams(layoutParams);
                radioButton.setGravity(17);
                radioButton.setClickable(false);
                linearLayout4.addView(radioButton);
                TextView textView5 = new TextView(bankFragment2.getActivity());
                textView5.setText(bVar.f139d);
                LinearLayout.LayoutParams layoutParams6 = layoutParams;
                textView5.setPadding(0, 0, 0, bankFragment2.f348e / 2);
                Helper.a(textView5, false, (Activity) bankFragment2.getActivity());
                textView5.setTextSize(2, 13.0f);
                linearLayout4.addView(textView5);
                linearLayout3.addView(linearLayout4);
                linearLayout3.addView(bankFragment2.a(true));
                TextView textView6 = new TextView(bankFragment2.getActivity());
                textView6.setLayoutParams(layoutParams3);
                textView6.setText(bVar.f140e + "%");
                textView6.setGravity(17);
                Helper.a(textView6, false, (Activity) bankFragment2.getActivity());
                textView6.setTextSize(2, 13.0f);
                linearLayout3.addView(textView6);
                linearLayout3.addView(bankFragment2.a(true));
                TextView textView7 = new TextView(bankFragment2.getActivity());
                textView7.setLayoutParams(layoutParams4);
                textView7.setText("₹ " + i9);
                textView7.setGravity(17);
                Helper.a(textView7, false, (Activity) bankFragment2.getActivity());
                textView7.setTextSize(2, 13.0f);
                linearLayout3.addView(textView7);
                linearLayout3.addView(bankFragment2.a(true));
                TextView textView8 = new TextView(bankFragment2.getActivity());
                textView8.setLayoutParams(layoutParams5);
                int i10 = (i9 * i7) - ((int) Float.parseFloat(PaymentLibConstants.f514e));
                textView8.setText(i10 > 0 ? "₹ " + i10 : "₹ 0");
                textView8.setGravity(17);
                textView8.setPadding(0, 0, 0, bankFragment2.f348e / 2);
                Helper.a(textView8, false, (Activity) bankFragment2.getActivity());
                textView8.setTextSize(2, 13.0f);
                linearLayout3.addView(textView8);
                linearLayout3.addView(bankFragment2.a(true));
                linearLayout3.setTag(bVar);
                linearLayout3.setOnClickListener(new a.a.c.a(bankFragment2));
                linearLayout.addView(linearLayout3);
                linearLayout.addView(bankFragment2.a(false));
                i6 = i8 + 1;
                arrayList = arrayList2;
                layoutParams = layoutParams6;
            }
            LinearLayout linearLayout5 = new LinearLayout(bankFragment2.getActivity());
            linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, bankFragment2.f348e));
            linearLayout5.setBackgroundColor(0);
            linearLayout.addView(linearLayout5);
            Button buttonA = Helper.a((Activity) bankFragment2.getActivity(), "CONTINUE");
            buttonA.setOnClickListener(new a.a.c.b(bankFragment2));
            linearLayout.addView(buttonA);
            linearLayout.setTag("tenureList");
            BankFragment.this.f345b.addView(linearLayout);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            String str = BankFragment.this.f344a;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f354b;

        public c(BankFragment bankFragment, String str, String str2) {
            this.f353a = str;
            this.f354b = str2;
        }

        public String toString() {
            return this.f354b;
        }
    }

    public BankFragment(String str, HashMap<String, Object> map, Context context) {
        this.f350g = map;
        try {
            a(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            Helper.a(getResources().getString(R.string.ERR13), context, true);
        }
    }

    public final LinearLayout a(boolean z) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setLayoutParams(z ? new LinearLayout.LayoutParams(this.f348e / 10, -1) : new LinearLayout.LayoutParams(-1, this.f348e / 10));
        linearLayout.setBackgroundColor(-7829368);
        return linearLayout;
    }

    public final void a(String str) throws JSONException {
        this.f346c = new TreeMap<>();
        this.f347d = new HashMap<>();
        JSONArray jSONArray = new JSONObject(str).getJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        for (int i = 0; i < jSONArray.length(); i++) {
            a.a.b.b bVar = new a.a.b.b();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            bVar.f136a = jSONObject.getString("bank-id");
            bVar.f137b = jSONObject.getString("bank-name");
            bVar.f138c = jSONObject.getString("tenure");
            bVar.f139d = jSONObject.getString("tenure-text");
            bVar.f140e = jSONObject.getString("ri");
            jSONObject.getString("redirect");
            jSONObject.getString("redirect-url");
            jSONObject.getString("hid-requestid");
            jSONObject.getString("hid-operation");
            jSONObject.getString("item-code");
            ArrayList<a.a.b.b> arrayList = this.f346c.containsKey(bVar.f136a) ? this.f346c.get(bVar.f136a) : new ArrayList<>();
            arrayList.add(bVar);
            this.f346c.put(bVar.f136a, arrayList);
            this.f347d.put(bVar.f136a, bVar.f137b);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f348e = (int) (getResources().getDisplayMetrics().density * 10.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        ScrollView scrollView = new ScrollView(getActivity());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.f345b = linearLayout;
        linearLayout.setOrientation(1);
        this.f345b.setPadding(0, 0, 0, this.f348e);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(this, "NA", "Please select"));
        for (String str : this.f346c.keySet()) {
            arrayList.add(new c(this, str, this.f347d.get(str)));
        }
        Spinner spinner = new Spinner(getActivity());
        a aVar = new a(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        aVar.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter((SpinnerAdapter) aVar);
        spinner.setOnItemSelectedListener(new b());
        spinner.setBackgroundColor(0);
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(layoutParams);
        int i = this.f348e / 2;
        relativeLayout.setPadding(i, i, i, i);
        int iA = Helper.a("bd_label_bg_img", (Context) getActivity());
        if (iA != 0) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageDrawable(getResources().getDrawable(iA));
            imageView.setLayoutParams(layoutParams);
            relativeLayout.addView(imageView);
        } else {
            relativeLayout.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.label_bg_img));
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15, -1);
        layoutParams2.setMargins(this.f348e / 2, 0, 0, 0);
        spinner.setLayoutParams(layoutParams2);
        relativeLayout.addView(spinner);
        ImageView imageView2 = new ImageView(getActivity());
        imageView2.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_more));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.setMargins(0, 0, this.f348e, 0);
        imageView2.setLayoutParams(layoutParams3);
        relativeLayout.addView(imageView2);
        this.f345b.addView(relativeLayout);
        scrollView.addView(this.f345b);
        return scrollView;
    }
}
