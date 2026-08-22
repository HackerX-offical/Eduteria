package com.billdesk.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Utils.Const;
import com.billdesk.sdk.R;
import com.billdesk.utils.SecurePreferences;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Helper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f502a = new AtomicInteger(1);

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f504b;

        public a(boolean z, Context context) {
            this.f503a = z;
            this.f504b = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            if (this.f503a) {
                ((Activity) this.f504b).finish();
            }
        }
    }

    public class b extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Paint f506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f507c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, int i) {
            super(context);
            this.f507c = i;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.f505a.set(0.0f, 0.0f, getWidth(), getHeight());
            RectF rectF = this.f505a;
            float f2 = this.f507c / 2;
            canvas.drawRoundRect(rectF, f2, f2, this.f506b);
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            Paint paint = new Paint(1);
            this.f506b = paint;
            paint.setColor(i);
            super.setBackgroundColor(0);
        }

        @Override // android.widget.LinearLayout
        public void setGravity(int i) {
            this.f505a = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            super.setGravity(i);
        }
    }

    public static float a(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static int a() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = f502a;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static final int a(String str, int i, Context context) {
        int identifier = context.getResources().getIdentifier(str, "dimen", context.getPackageName());
        return (int) (identifier == 0 ? context.getResources().getDimension(i) : context.getResources().getDimension(identifier));
    }

    public static final int a(String str, Context context) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static final ViewGroup.LayoutParams a(Context context, int i, int i2, int i3, int[] iArr) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        if (i3 <= 0) {
            i3 = 100;
        }
        int i4 = (width * i3) / 100;
        int height = defaultDisplay.getHeight();
        if (i2 <= 0) {
            i2 = 100;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, (height * i2) / 100);
        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        layoutParams.gravity = i;
        return layoutParams;
    }

    public static final LinearLayout a(Activity activity) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setBackgroundColor(c("bd_body_bg", ResourceConstants.f522b, activity.getApplicationContext()));
        int iA = a("body_bg_img", activity.getApplicationContext());
        if (iA != 0) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(activity.getResources(), iA));
            bitmapDrawable.setGravity(17);
            linearLayout.setBackgroundDrawable(bitmapDrawable);
        }
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public static LinearLayout a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(-1431984731);
        int i = (int) (context.getResources().getDisplayMetrics().density * 10.0f);
        b bVar = new b(context, i);
        bVar.setOrientation(1);
        bVar.setGravity(17);
        bVar.setBackgroundColor(context.getResources().getColor(R.color.bd_loader_bg));
        bVar.setPadding(i, i, i, i);
        ProgressBar progressBar = new ProgressBar(context);
        int iA = a("loader_img", context.getApplicationContext());
        if (iA == 0) {
            progressBar.getIndeterminateDrawable().setColorFilter(c("bd_progress_bar", ResourceConstants.f524d, context), PorterDuff.Mode.MULTIPLY);
        } else {
            progressBar.setIndeterminateDrawable(context.getResources().getDrawable(iA));
        }
        progressBar.setPadding(5, 5, 5, 5);
        TextView textView = new TextView(context);
        textView.setText(b("loaderString", ResourceConstants.f528h, context));
        textView.setGravity(17);
        textView.setTextColor(context.getResources().getColor(R.color.bd_loader_text));
        bVar.addView(progressBar);
        bVar.addView(textView);
        linearLayout.addView(bVar);
        return linearLayout;
    }

    public static final String a(String str) {
        return (str == null || str.trim().length() == 0 || str.trim().equalsIgnoreCase(Constants.NULL_VERSION_ID)) ? "NA" : str;
    }

    public static String a(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
        cipher.init(1, rSAPublicKey);
        byte[] bArrDoFinal = cipher.doFinal(str2.getBytes());
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[bArrDoFinal.length * 2];
        for (int i = 0; i < bArrDoFinal.length; i++) {
            byte b2 = bArrDoFinal[i];
            int i2 = i * 2;
            cArr[i2] = charArray[(b2 & 255) >>> 4];
            cArr[i2 + 1] = charArray[b2 & Ascii.SI];
        }
        String str3 = new String(cArr);
        "encryptedcode(OAEPwithSHA-256andMGF1Padding)=Hex\n".concat(str3);
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x001d, B:6:0x0032, B:9:0x0048, B:12:0x005c, B:15:0x0071, B:17:0x0076, B:19:0x0081, B:14:0x006d, B:8:0x0044), top: B:24:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0044 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x001d, B:6:0x0032, B:9:0x0048, B:12:0x005c, B:15:0x0071, B:17:0x0076, B:19:0x0081, B:14:0x006d, B:8:0x0044), top: B:24:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> a(java.util.HashMap<java.lang.String, java.lang.Object> r8, org.json.JSONObject r9) {
        /*
            java.lang.String r0 = "true"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "msg"
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = r3.toString()
            r1.put(r2, r3)
            java.lang.Object r8 = r8.get(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r2 = "override_item_code"
            java.lang.String r2 = r9.getString(r2)     // Catch: java.lang.Exception -> L8b
            boolean r2 = r2.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> L8b
            java.lang.String r3 = "NA"
            java.lang.String r4 = "item-code"
            java.lang.String r5 = "\\|"
            java.lang.String r6 = "txtItemCode"
            if (r2 == 0) goto L44
            java.lang.String[] r2 = r8.split(r5)     // Catch: java.lang.Exception -> L8b
            r7 = 8
            r2 = r2[r7]     // Catch: java.lang.Exception -> L8b
            java.lang.String r7 = a(r2)     // Catch: java.lang.Exception -> L8b
            boolean r7 = r7.equals(r3)     // Catch: java.lang.Exception -> L8b
            if (r7 == 0) goto L48
        L44:
            java.lang.String r2 = r9.getString(r4)     // Catch: java.lang.Exception -> L8b
        L48:
            r1.put(r6, r2)     // Catch: java.lang.Exception -> L8b
            java.lang.String r2 = "override_bank_id"
            java.lang.String r2 = r9.getString(r2)     // Catch: java.lang.Exception -> L8b
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> L8b
            java.lang.String r2 = "bank-id"
            java.lang.String r4 = "txtBankID"
            if (r0 == 0) goto L6d
            java.lang.String[] r8 = r8.split(r5)     // Catch: java.lang.Exception -> L8b
            r0 = 4
            r8 = r8[r0]     // Catch: java.lang.Exception -> L8b
            java.lang.String r0 = a(r8)     // Catch: java.lang.Exception -> L8b
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Exception -> L8b
            if (r0 == 0) goto L71
        L6d:
            java.lang.String r8 = r9.getString(r2)     // Catch: java.lang.Exception -> L8b
        L71:
            r1.put(r4, r8)     // Catch: java.lang.Exception -> L8b
            java.lang.String r8 = "hidOperation"
            java.lang.String r0 = "hid-operation"
            java.lang.String r0 = r9.getString(r0)     // Catch: java.lang.Exception -> L8b
            r1.put(r8, r0)     // Catch: java.lang.Exception -> L8b
            java.lang.String r8 = "hidRequestId"
            java.lang.String r0 = "hid-requestid"
            java.lang.String r9 = r9.getString(r0)     // Catch: java.lang.Exception -> L8b
            r1.put(r8, r9)     // Catch: java.lang.Exception -> L8b
            return r1
        L8b:
            r8 = move-exception
            r8.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.billdesk.utils.Helper.a(java.util.HashMap, org.json.JSONObject):java.util.HashMap");
    }

    public static final void a(TextView textView, Activity activity) {
        a(textView, false, activity);
    }

    public static final void a(TextView textView, boolean z, Activity activity) {
        String strB = b("body_font_face", ResourceConstants.j, activity.getApplicationContext());
        if (!strB.equalsIgnoreCase("Default")) {
            try {
                textView.setTypeface(Typeface.createFromAsset(activity.getApplication().getAssets(), strB));
            } catch (Exception unused) {
            }
            if (z) {
                textView.setTypeface(textView.getTypeface(), 1);
            }
        }
        textView.setTextColor(c("bd_body_text", ResourceConstants.f523c, activity.getApplicationContext()));
    }

    public static final void a(String str, Context context, boolean z) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setMessage(str).setNeutralButton("OK", new a(z, context)).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    public static final void a(String str, String str2, Context context) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (!jSONObject2.getString("ErrorDescription").equals("Success")) {
                Log.e(str, "QuickPay error [" + jSONObject2.getString("ErrorCode") + "][" + jSONObject2.getString("ErrorDescription") + com.clevertap.android.sdk.Constants.AES_SUFFIX);
                PaymentLibConstants.k = null;
                return;
            }
            JSONArray jSONArray = jSONObject2.getJSONObject("account").getJSONArray("card");
            if (jSONArray.length() < 1) {
                jSONObject = PaymentLibConstants.k;
            } else {
                jSONObject = new JSONObject();
                PaymentLibConstants.k = jSONObject;
            }
            jSONObject.put("quick_pay_list", jSONArray);
        } catch (Exception unused) {
            Log.e(str, "QuickPay error[" + context.getResources().getString(R.string.ERR38) + com.clevertap.android.sdk.Constants.AES_SUFFIX);
        }
    }

    public static final boolean a(Context context, String str) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j = new SecurePreferences(context).getLong(str + "_url_expiry", 0L);
        context.getClass().getName();
        String str2 = "Billdesk ExpName [url_expiry] ServerTime [" + timeInMillis + "] expiryTime [" + j + "] result [" + (timeInMillis > j) + com.clevertap.android.sdk.Constants.AES_SUFFIX;
        return timeInMillis > j;
    }

    public static boolean a(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("name", 0).edit();
        editorEdit.putInt(str, i);
        String str2 = "helper value [" + i + com.clevertap.android.sdk.Constants.AES_SUFFIX;
        return editorEdit.commit();
    }

    public static int b(Context context, String str) {
        int i = context.getSharedPreferences("name", 0).getInt(str, 0);
        String str2 = "helper ort [" + i + com.clevertap.android.sdk.Constants.AES_SUFFIX;
        return i;
    }

    public static final String b(String str, int i, Context context) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        return identifier == 0 ? context.getResources().getString(i) : context.getResources().getString(identifier);
    }

    public static final boolean b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static final int c(String str, int i, Context context) {
        int identifier = context.getResources().getIdentifier(str, "color", context.getPackageName());
        return identifier == 0 ? context.getResources().getColor(i) : context.getResources().getColor(identifier);
    }

    public static void c(Context context) {
        try {
            Activity activity = (Activity) context;
            if (activity.getRequestedOrientation() <= -1) {
                int iB = b(context, "config");
                if (iB == 2) {
                    activity.setRequestedOrientation(0);
                } else if (iB == 1) {
                    activity.setRequestedOrientation(1);
                } else {
                    activity.setRequestedOrientation(4);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final Button a(Activity activity, String str) {
        Button button = new Button(activity);
        button.setText(str);
        int color = activity.getResources().getColor(R.color.bd_button_text);
        a((TextView) button, false, activity);
        button.setTextColor(color);
        button.setTextSize(2, 24.0f);
        int identifier = activity.getResources().getIdentifier("button_bg_img", "drawable", activity.getPackageName());
        if (identifier != 0) {
            button.setBackgroundDrawable(activity.getResources().getDrawable(identifier));
        } else {
            int color2 = activity.getResources().getColor(R.color.bd_button_bg);
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable = new ColorDrawable(color2);
            colorDrawable.setAlpha(128);
            stateListDrawable.addState(new int[]{-16842910}, colorDrawable);
            stateListDrawable.addState(new int[0], new ColorDrawable(color2));
            button.setBackgroundDrawable(stateListDrawable);
        }
        byte[] bArrDecode = Base64.decode("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", 0);
        button.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(activity.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length), (int) (activity.getResources().getDisplayMetrics().density * 27.0f), (int) (activity.getResources().getDisplayMetrics().density * 31.0f), true)), (Drawable) null, (Drawable) null, (Drawable) null);
        return button;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.widget.LinearLayout a(java.lang.String r11, android.app.Activity r12) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.billdesk.utils.Helper.a(java.lang.String, android.app.Activity):android.widget.LinearLayout");
    }

    public static final void a(Context context, String str, String str2) throws Exception {
        boolean z;
        boolean z2;
        String str3;
        String string;
        String str4 = PubkeyElement.ELEMENT;
        String str5 = "Billdesk expiryTime[";
        String str6 = "id";
        context.getClass().getName();
        try {
            String str7 = "Billdesk onPostExecute responseStr[" + str + com.clevertap.android.sdk.Constants.AES_SUFFIX;
            new SecurePreferences(context);
            SecurePreferences.Editor editor = new SecurePreferences.Editor();
            JSONObject jSONObject = new JSONObject(str);
            editor.f538a.putString(str2 + Const.IMAGES, jSONObject.getString(Const.IMAGES));
            editor.f538a.commit();
            JSONArray jSONArray = new JSONArray(jSONObject.getString(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS));
            int length = jSONArray.length();
            String str8 = "BillDesk back jsonOptions.length[" + jSONArray.length() + com.clevertap.android.sdk.Constants.AES_SUFFIX;
            int i = 0;
            while (i < length) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string2 = jSONObject2.getString("name");
                String string3 = jSONObject2.getString(str6);
                String str9 = str4;
                int iIntValue = Integer.valueOf(jSONObject2.getString("order-index")).intValue();
                String str10 = str5;
                JSONObject jSONObject3 = jSONObject;
                String str11 = "LKJ json [" + jSONObject2.toString() + com.clevertap.android.sdk.Constants.AES_SUFFIX + string2;
                editor.f538a.putString(str2 + str6 + i, string3);
                editor.f538a.putString(str2 + SDKConstants.PARAM_GAME_REQUESTS_OPTIONS + i, string2);
                String str12 = str6;
                editor.putInt(str2 + string3 + "_is_active", jSONObject2.getInt("is_active"));
                editor.putInt(str2 + "Index" + i, iIntValue);
                if (string3.equalsIgnoreCase(PaymentLibConstants.t[0])) {
                    String str13 = "BillDesk json [" + jSONArray.getString(i) + com.clevertap.android.sdk.Constants.AES_SUFFIX + string2;
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.getString("urls"));
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                        String str14 = "Billdesk arrayElement [" + jSONObject4.toString() + "]key[" + jSONObject4.getString("Key") + "]values[" + jSONObject4.getString("Value") + com.clevertap.android.sdk.Constants.AES_SUFFIX;
                        editor.f538a.putString(str2 + jSONObject4.getString("Key"), jSONObject4.getString("Value"));
                    }
                    editor.f538a.commit();
                } else {
                    if (string3.equalsIgnoreCase(PaymentLibConstants.t[1])) {
                        String str15 = "BillDesk json [" + jSONArray.getString(i) + com.clevertap.android.sdk.Constants.AES_SUFFIX + string3;
                        str3 = str2 + "CreditCardType";
                        string = jSONObject2.toString();
                    } else if (string3.equalsIgnoreCase(PaymentLibConstants.t[2]) || string3.equalsIgnoreCase(PaymentLibConstants.t[3])) {
                        String str16 = "BillDesk json [" + jSONArray.getString(i) + com.clevertap.android.sdk.Constants.AES_SUFFIX + string3;
                        str3 = PaymentLibConstants.f511b + string3 + "BankList";
                        string = jSONObject2.toString();
                    } else {
                        str3 = str2 + "Other" + string3;
                        string = jSONObject2.toString();
                    }
                    editor.f538a.putString(str3, string);
                }
                i++;
                str4 = str9;
                str5 = str10;
                jSONObject = jSONObject3;
                str6 = str12;
            }
            String str17 = str4;
            String str18 = str5;
            JSONObject jSONObject5 = jSONObject;
            editor.putInt(str2 + "optionlen", length);
            long timeInMillis = Calendar.getInstance().getTimeInMillis() + (Long.parseLong(jSONObject5.getString("Expiry_Date")) * 3600000);
            String str19 = str18 + timeInMillis + com.clevertap.android.sdk.Constants.AES_SUFFIX;
            editor.putLong(str2 + "_url_expiry", timeInMillis);
            try {
                String string4 = jSONObject5.getString("SSLBypass");
                String str20 = str18 + timeInMillis + com.clevertap.android.sdk.Constants.AES_SUFFIX;
                editor.f538a.putString(str2 + "_SSLBypass", string4);
                String str21 = "Billdesk SSLBypass[" + string4 + com.clevertap.android.sdk.Constants.AES_SUFFIX;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                String string5 = jSONObject5.getString("OTP_Read");
                String str22 = "Billdesk Browser integrated : " + string5;
                editor.f538a.putString(str2 + "_BDBrowser", string5);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                z = Boolean.parseBoolean(jSONObject5.getString("CID_Unique"));
            } catch (Exception e4) {
                e4.printStackTrace();
                z = true;
            }
            editor.putBoolean(str2 + "_cid_unique", z);
            try {
                z2 = Boolean.parseBoolean(jSONObject5.getString("TXTPAYCATEGORY"));
            } catch (Exception e5) {
                e5.printStackTrace();
                z2 = false;
            }
            editor.putBoolean(str2 + "_txtpaycategory", z2);
            try {
                editor.f538a.putString(str2 + "_txtDefaultCategory", jSONObject5.getString("DEFAULT_CATEGORY"));
                editor.f538a.putString(str2 + "_txtPubkey", jSONObject5.has(str17) ? jSONObject5.getString(str17) : "NA");
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            editor.f538a.commit();
        } catch (Exception e7) {
            e7.printStackTrace();
            throw e7;
        }
    }
}
