package a.a.c;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.billdesk.sdk.BankFragment;
import com.billdesk.sdk.CreditCardView;
import com.billdesk.sdk.R;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.SecurePreferences;
import com.clevertap.android.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BankFragment f142a;

    public b(BankFragment bankFragment) {
        this.f142a = bankFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        BankFragment bankFragment = this.f142a;
        if (bankFragment.f349f == null) {
            Helper.a(bankFragment.getResources().getString(R.string.ERR14), (Context) this.f142a.getActivity(), false);
            return;
        }
        SecurePreferences securePreferences = new SecurePreferences(this.f142a.getActivity());
        try {
            Intent intent = new Intent(this.f142a.getActivity(), (Class<?>) CreditCardView.class);
            JSONObject jSONObject = new JSONObject(securePreferences.getString(PaymentLibConstants.f511b + "CreditCardType", "{}"));
            jSONObject.toString();
            String string = jSONObject.getString("makePaymentCreditUrl");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("card-type"));
            String str2 = this.f142a.f344a;
            String str3 = "BillDesk back payOptions.length[" + jSONArray.length() + Constants.AES_SUFFIX;
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                String string2 = jSONObject2.getString("name");
                String string3 = jSONObject2.getString("bank_id");
                String string4 = jSONObject2.getString("item-code");
                int i2 = i;
                if ("American Express".equalsIgnoreCase(string2)) {
                    intent.putExtra("hasamex", "1");
                    intent.putExtra("A_bankID", string3);
                    str = "A_itemCode";
                } else if ("MasterCard".equalsIgnoreCase(string2)) {
                    intent.putExtra("hasmaster", "1");
                    intent.putExtra("M_bankID", string3);
                    str = "M_itemCode";
                } else if ("Visa".equalsIgnoreCase(string2)) {
                    intent.putExtra("hasvisa", "1");
                    intent.putExtra("V_bankID", string3);
                    str = "V_itemCode";
                } else if ("Diners".contains(string2)) {
                    intent.putExtra("hasdiners", "1");
                    intent.putExtra("D_bankID", string3);
                    str = "D_itemCode";
                } else {
                    String str4 = this.f142a.f344a;
                    String str5 = "BillDesk Card Type is [" + string2 + Constants.AES_SUFFIX;
                    i = i2 + 1;
                }
                intent.putExtra(str, string4);
                String str42 = this.f142a.f344a;
                String str52 = "BillDesk Card Type is [" + string2 + Constants.AES_SUFFIX;
                i = i2 + 1;
            }
            intent.putExtra("override_bank_id", jSONObject.getString("override_bank_id"));
            intent.putExtra("override_item_code", jSONObject.getString("override_item_code"));
            intent.putExtra("url", string);
            intent.putExtra("paymentDetail", this.f142a.f350g);
            this.f142a.startActivity(intent);
        } catch (JSONException e2) {
            e2.printStackTrace();
            String str6 = this.f142a.f344a;
            String str7 = "String [" + securePreferences.getString(PaymentLibConstants.f511b + "CreditCardType", "{}") + Constants.AES_SUFFIX;
            Helper.a(this.f142a.getResources().getString(R.string.ERR13), (Context) this.f142a.getActivity(), false);
        }
    }
}
