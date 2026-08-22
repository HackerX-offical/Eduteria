package com.easebuzz.payment.kit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import datamodels.CancellationReasonModel;
import datamodels.CardValidationModel;
import datamodels.PWEBankCodeModel;
import datamodels.PWEStaticDataModel;
import helper.PWEContextMenuListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qr_core.BarcodeFormat;
import qr_core.WriterException;
import qr_core.common.BitMatrix;
import qr_core.qrcode.QRCodeWriter;

/* JADX INFO: loaded from: classes7.dex */
public class PWEGeneralHelper {
    private Context context;
    public PWEPaymentInfoHandler paymentInfoHandler;
    public TextView tvAbTitle;
    public TextView tvMerchantName;
    private ArrayList<CardValidationModel> listCardExpression = new ArrayList<>();
    String exp_json = "";

    public PWEGeneralHelper(Context context) {
        this.context = context;
        this.paymentInfoHandler = new PWEPaymentInfoHandler(context);
    }

    public ArrayList<CardValidationModel> getCardTypeExpressionsList() {
        ArrayList<CardValidationModel> arrayList = new ArrayList<>();
        this.listCardExpression = arrayList;
        arrayList.clear();
        try {
            this.exp_json = this.paymentInfoHandler.getCardTypsExpJson();
            JSONObject jSONObject = new JSONObject(this.exp_json);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(itKeys.next());
                this.listCardExpression.add(new CardValidationModel(jSONObject2.optString("card_type"), jSONObject2.optString("card_reg_exp"), PWEStaticDataModel.PWEDefaultCardTypeIcon, jSONObject2.optBoolean("luhnFlag"), jSONObject2.optString("image")));
            }
        } catch (Exception unused) {
        }
        return this.listCardExpression;
    }

    public void setImageToImageView(String str, ImageView imageView, int i) {
        try {
            if (!str.equals("") && !str.equals("NA")) {
                String[] strArrSplit = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                String str2 = strArrSplit[strArrSplit.length - 1];
                Bitmap image = PWECacheImageManager.getImage(this.context, str2);
                if (image != null) {
                    imageView.setImageBitmap(image);
                    return;
                } else {
                    new PWEDownloadImageManager(this.context, str2, imageView).execute(str);
                    return;
                }
            }
            imageView.setImageResource(i);
        } catch (Error unused) {
            imageView.setImageResource(i);
        } catch (Exception unused2) {
            imageView.setImageResource(i);
        }
    }

    public void showPweToast(String str) {
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.pwe_toast_view, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.toast_text_messsage)).setText(str);
        Toast toast = new Toast(this.context);
        toast.setView(viewInflate);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    protected boolean validatePweCardByLunh(String str) {
        try {
            if (str.length() < 12) {
                return false;
            }
            int length = str.length();
            int[] iArr = new int[length];
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 1;
                iArr[i] = Integer.parseInt(str.substring(i, i2));
                i = i2;
            }
            for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
                int i4 = iArr[i3] * 2;
                if (i4 > 9) {
                    i4 = (i4 % 10) + 1;
                }
                iArr[i3] = i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                i5 += iArr[i6];
            }
            if (i5 % 10 == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public CardValidationModel getCardTypeObject(String str) {
        CardValidationModel cardValidationModel = new CardValidationModel();
        try {
            this.exp_json = this.paymentInfoHandler.getCardTypsExpJson();
            JSONObject jSONObject = new JSONObject(this.exp_json).getJSONObject(str);
            String strOptString = jSONObject.optString("card_reg_exp");
            boolean zOptBoolean = jSONObject.optBoolean("luhnFlag");
            String strOptString2 = jSONObject.optString("image");
            cardValidationModel.setCard_reg_exp(strOptString);
            cardValidationModel.setCard_type(str);
            cardValidationModel.setCard_type_image(strOptString2);
            cardValidationModel.setDefaultCardImage(PWEStaticDataModel.PWEDefaultCardTypeIcon);
            cardValidationModel.setLuhnFlag(zOptBoolean);
        } catch (Exception unused) {
        }
        return cardValidationModel;
    }

    public ArrayList<CancellationReasonModel> getCancellationsReasonList() {
        ArrayList<CancellationReasonModel> arrayList = new ArrayList<>();
        try {
            String[] strArrSplit = this.paymentInfoHandler.getCancelReasons().replace(Constants.AES_PREFIX, "").replace(Constants.AES_SUFFIX, "").replace("\"", "").split(Constants.SEPARATOR_COMMA);
            ArrayList<CancellationReasonModel> arrayList2 = new ArrayList<>();
            for (int i = 0; i < strArrSplit.length; i++) {
                try {
                    arrayList2.add(new CancellationReasonModel(i, strArrSplit[i], false));
                } catch (Exception unused) {
                    return arrayList2;
                }
            }
            arrayList2.add(new CancellationReasonModel(strArrSplit.length, "Any other reason", false));
            return arrayList2;
        } catch (Exception unused2) {
            return arrayList;
        }
    }

    protected String getAPIBaseURL() {
        if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            return PWEStaticDataModel.REST_BASE_URL_TEST + "/webservice/";
        }
        return PWEStaticDataModel.REST_BASE_URL + "/webservice/";
    }

    protected String getUPIAPIBaseURL() {
        if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            return PWEStaticDataModel.REST_BASE_URL_TEST + "/upi/";
        }
        return PWEStaticDataModel.REST_BASE_URL + "/upi/";
    }

    public JSONObject getCardPageMessage(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(this.paymentInfoHandler.getCardViewMsg());
        } catch (JSONException unused) {
        }
        if (!str.equals("PROCESS_PAYMENT")) {
            if (jSONObject.optJSONObject(str) != null && !jSONObject.getJSONObject(str).isNull("short_message") && !jSONObject.getJSONObject(str).isNull("description")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
                jSONObjectOptJSONObject.put("status", true);
                return jSONObjectOptJSONObject;
            }
            if (jSONObject.optJSONObject("global") != null && !jSONObject.getJSONObject("global").isNull("short_message") && !jSONObject.getJSONObject("global").isNull("description")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("global");
                jSONObject3.put("status", true);
                return jSONObject3;
            }
            jSONObject2.put("status", false);
            return jSONObject2;
        }
        jSONObject2.put("status", false);
        return jSONObject2;
    }

    protected ArrayList<PWEBankCodeModel> getBankNameCodeList(String str, String str2, String str3) {
        ArrayList<PWEBankCodeModel> arrayList = new ArrayList<>();
        if (str3.equals("ENACH_BANK_NAMES")) {
            PWEBankCodeModel pWEBankCodeModel = new PWEBankCodeModel();
            pWEBankCodeModel.setBank_name("Bank Name");
            pWEBankCodeModel.setImage_path("NA");
            pWEBankCodeModel.setBank_id("NA");
            pWEBankCodeModel.setBank_code("NA");
            arrayList.add(pWEBankCodeModel);
        }
        try {
            JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getBankCodeString());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.optString(Const.CATEGORY, "NA").equals(str2)) {
                    PWEBankCodeModel pWEBankCodeModel2 = new PWEBankCodeModel();
                    pWEBankCodeModel2.setBank_name(jSONObject.optString("bank_name", ""));
                    pWEBankCodeModel2.setImage_path(jSONObject.optString("image", "NA"));
                    if (str2.equals(PWEStaticDataModel.PAYOPT_ENACH_DISPLAY_NAME)) {
                        pWEBankCodeModel2.setBank_id(jSONObject.optString("enach_bank_id", "NA"));
                    } else {
                        pWEBankCodeModel2.setBank_id(jSONObject.optString("bank_id", "NA"));
                    }
                    pWEBankCodeModel2.setBank_code(jSONObject.optString("bank_code", "NA"));
                    arrayList.add(pWEBankCodeModel2);
                }
            }
        } catch (Error | Exception unused) {
        }
        return arrayList;
    }

    protected void initMerchantNameTextView(TextView textView) {
        this.tvMerchantName = textView;
    }

    protected void setPWEMerchantName(boolean z, ImageView imageView, String str) {
        try {
            if (z) {
                this.tvMerchantName.setVisibility(8);
                imageView.setVisibility(0);
                setImageToImageView(str, imageView, PWEStaticDataModel.PWEDefaultPlaceholder);
                return;
            }
            this.tvMerchantName.setVisibility(0);
            imageView.setVisibility(8);
            if (this.paymentInfoHandler.getMerchantName().isEmpty() || this.paymentInfoHandler.getMerchantName().equals("") || this.paymentInfoHandler.getMerchantName() == null) {
                return;
            }
            this.tvMerchantName.setText(this.paymentInfoHandler.getMerchantName());
        } catch (Error unused) {
            TextView textView = this.tvMerchantName;
            if (textView != null) {
                textView.setVisibility(0);
                this.tvMerchantName.setText("Pay with easebuzz");
            }
        } catch (Exception unused2) {
            TextView textView2 = this.tvMerchantName;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.tvMerchantName.setText("Pay with easebuzz");
            }
        }
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
        View view = null;
        int measuredHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            view = adapter.getView(i, view, listView);
            if (i == 0) {
                view.setLayoutParams(new ViewGroup.LayoutParams(iMakeMeasureSpec, -1));
            }
            view.measure(iMakeMeasureSpec, 0);
            measuredHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = measuredHeight + (listView.getDividerHeight() * adapter.getCount());
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    protected OkHttpClient getRetrofitConnectionFactory() {
        return new OkHttpClient.Builder().connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS).build();
    }

    public String validateJS(String str) {
        try {
            return str.startsWith(PWEStaticDataModel.JS_BASE_URL) ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean checkAutoOtpEnableForMode(String str, String str2, String str3) {
        boolean z = true;
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        try {
            if (!str2.equals("")) {
                str2 = str2.trim();
            }
            if (!str3.equals("")) {
                str3 = str3.trim();
            }
            JSONObject jSONObject = new JSONObject(str);
            List listAsList = Arrays.asList(jSONObject.optString("disabled_payment_mode", "").replace('[', ' ').replace(']', ' ').trim().split(Constants.SEPARATOR_COMMA));
            int i = 0;
            while (true) {
                if (i >= listAsList.size()) {
                    break;
                }
                if (((String) listAsList.get(i)).contains(str2)) {
                    z = false;
                    break;
                }
                i++;
            }
            List listAsList2 = Arrays.asList(jSONObject.optString("disabled_bank_code", "").replace('[', ' ').replace(']', ' ').trim().split(Constants.SEPARATOR_COMMA));
            for (int i2 = 0; i2 < listAsList2.size(); i2++) {
                if (((String) listAsList2.get(i2)).contains(str3)) {
                    return false;
                }
            }
        } catch (Error | Exception unused) {
        }
        return z;
    }

    public void pweDisableCopyAndPaste(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            editText.setLongClickable(false);
            editText.setOnTouchListener(new PWEContextMenuListener(inputMethodManager, editText));
        } catch (Exception unused) {
        }
    }

    public ArrayList<String> pweGetAccountTypeList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Account Type");
        arrayList.add("Savings");
        arrayList.add("Current");
        return arrayList;
    }

    public ArrayList<String> pweGetAuthTypeList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Auth Type");
        arrayList.add("NetBanking");
        arrayList.add(PWEStaticDataModel.PAYOPT_DEBITCARD_DISPLAY_NAME);
        if (this.paymentInfoHandler.getIsPaperBaseEnabled() == 1) {
            arrayList.add("Paper Base");
        }
        return arrayList;
    }

    public Date getCurrentDateWithOneMonthMinus() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        return calendar.getTime();
    }

    public void changeButtonWidth(Button button) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(20, 50, 20, 50);
        button.setLayoutParams(layoutParams);
    }

    public void hideKeyboard(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Bitmap generateQRCode(String str, int i, int i2) {
        try {
            BitMatrix bitMatrixEncode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i2);
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i3 = 0; i3 < height; i3++) {
                int i4 = i3 * width;
                for (int i5 = 0; i5 < width; i5++) {
                    iArr[i4 + i5] = bitMatrixEncode.get(i5, i3) ? -16777216 : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        } catch (WriterException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void enableScreenRecording(Context context) {
        try {
            if (context instanceof Activity) {
                ((Activity) context).getWindow().clearFlags(8192);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void disableScreenRecording(Context context) {
        try {
            if (context instanceof Activity) {
                ((Activity) context).getWindow().setFlags(8192, 8192);
            }
        } catch (Error | Exception unused) {
        }
    }
}
