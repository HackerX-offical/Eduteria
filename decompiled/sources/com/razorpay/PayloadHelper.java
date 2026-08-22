package com.razorpay;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PayloadHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\bM\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010~\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0006\u0010\u007f\u001a\u000203R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001c\u0010#\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001e\u0010&\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\rR\u001c\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001e\u0010,\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u001c\u0010:\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u0017R\u001c\u0010=\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0015\"\u0004\b?\u0010\u0017R\u001c\u0010@\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R\u001c\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0015\"\u0004\bE\u0010\u0017R\u001c\u0010F\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010\u0017R\u001c\u0010I\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0015\"\u0004\bK\u0010\u0017R\u001c\u0010L\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0015\"\u0004\bN\u0010\u0017R\u001c\u0010O\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0015\"\u0004\bQ\u0010\u0017R\u001c\u0010R\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0015\"\u0004\bT\u0010\u0017R\u001e\u0010U\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bV\u0010\u000b\"\u0004\bW\u0010\rR\u001e\u0010X\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bY\u0010\u000b\"\u0004\bZ\u0010\rR\u001e\u0010[\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\\\u0010\u000b\"\u0004\b]\u0010\rR\u001c\u0010^\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001e\u0010c\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bd\u0010\u000b\"\u0004\be\u0010\rR\u001e\u0010f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bg\u0010\u000b\"\u0004\bh\u0010\rR\u001e\u0010i\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bj\u0010\u000b\"\u0004\bk\u0010\rR\u001e\u0010l\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010q\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001e\u0010r\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bs\u0010\u000b\"\u0004\bt\u0010\rR\u001e\u0010u\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\bv\u0010\u000b\"\u0004\bw\u0010\rR\u001c\u0010x\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0015\"\u0004\bz\u0010\u0017R\u001e\u0010{\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010q\u001a\u0004\b|\u0010n\"\u0004\b}\u0010p¨\u0006\u0080\u0001"}, d2 = {"Lcom/razorpay/PayloadHelper;", "", FirebaseAnalytics.Param.CURRENCY, "", "amount", "", "orderId", "(Ljava/lang/String;ILjava/lang/String;)V", "allowRotation", "", "getAllowRotation", "()Ljava/lang/Boolean;", "setAllowRotation", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAmount", "()I", "setAmount", "(I)V", "backDropColor", "getBackDropColor", "()Ljava/lang/String;", "setBackDropColor", "(Ljava/lang/String;)V", "callbackUrl", "getCallbackUrl", "setCallbackUrl", "color", "getColor", "setColor", "getCurrency", "setCurrency", "customerId", "getCustomerId", "setCustomerId", "description", "getDescription", "setDescription", "hideTopBar", "getHideTopBar", "setHideTopBar", "image", "getImage", "setImage", "modalConfirmClose", "getModalConfirmClose", "setModalConfirmClose", "name", "getName", "setName", "notes", "Lorg/json/JSONObject;", "getNotes", "()Lorg/json/JSONObject;", "setNotes", "(Lorg/json/JSONObject;)V", "getOrderId", "setOrderId", "prefillBankName", "getPrefillBankName", "setPrefillBankName", "prefillCardCvv", "getPrefillCardCvv", "setPrefillCardCvv", "prefillCardExp", "getPrefillCardExp", "setPrefillCardExp", "prefillCardNum", "getPrefillCardNum", "setPrefillCardNum", "prefillContact", "getPrefillContact", "setPrefillContact", "prefillEmail", "getPrefillEmail", "setPrefillEmail", "prefillMethod", "getPrefillMethod", "setPrefillMethod", "prefillName", "getPrefillName", "setPrefillName", "prefillVpa", "getPrefillVpa", "setPrefillVpa", "readOnlyContact", "getReadOnlyContact", "setReadOnlyContact", "readOnlyEmail", "getReadOnlyEmail", "setReadOnlyEmail", "readOnlyName", "getReadOnlyName", "setReadOnlyName", "recurring", "getRecurring", "()Ljava/lang/Object;", "setRecurring", "(Ljava/lang/Object;)V", "redirect", "getRedirect", "setRedirect", "rememberCustomer", "getRememberCustomer", "setRememberCustomer", "retryEnabled", "getRetryEnabled", "setRetryEnabled", "retryMaxCount", "getRetryMaxCount", "()Ljava/lang/Integer;", "setRetryMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sendSmsHash", "getSendSmsHash", "setSendSmsHash", "subscriptionCardChange", "getSubscriptionCardChange", "setSubscriptionCardChange", "subscriptionId", "getSubscriptionId", "setSubscriptionId", "timeout", "getTimeout", "setTimeout", "checkColorValidityAndSanitize", "getJson", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayloadHelper {
    private Boolean allowRotation;
    private int amount;
    private String backDropColor;
    private String callbackUrl;
    private String color;
    private String currency;
    private String customerId;
    private String description;
    private Boolean hideTopBar;
    private String image;
    private Boolean modalConfirmClose;
    private String name;
    private JSONObject notes;
    private String orderId;
    private String prefillBankName;
    private String prefillCardCvv;
    private String prefillCardExp;
    private String prefillCardNum;
    private String prefillContact;
    private String prefillEmail;
    private String prefillMethod;
    private String prefillName;
    private String prefillVpa;
    private Boolean readOnlyContact;
    private Boolean readOnlyEmail;
    private Boolean readOnlyName;
    private Object recurring;
    private Boolean redirect;
    private Boolean rememberCustomer;
    private Boolean retryEnabled;
    private Integer retryMaxCount;
    private Boolean sendSmsHash;
    private Boolean subscriptionCardChange;
    private String subscriptionId;
    private Integer timeout;

    public PayloadHelper(String currency, int i, String orderId) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.currency = currency;
        this.amount = i;
        this.orderId = orderId;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setAmount(int i) {
        this.amount = i;
    }

    public final void setCurrency(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currency = str;
    }

    public final void setOrderId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final String getPrefillName() {
        return this.prefillName;
    }

    public final void setPrefillName(String str) {
        this.prefillName = str;
    }

    public final String getPrefillEmail() {
        return this.prefillEmail;
    }

    public final void setPrefillEmail(String str) {
        this.prefillEmail = str;
    }

    public final String getPrefillContact() {
        return this.prefillContact;
    }

    public final void setPrefillContact(String str) {
        this.prefillContact = str;
    }

    public final String getPrefillMethod() {
        return this.prefillMethod;
    }

    public final void setPrefillMethod(String str) {
        this.prefillMethod = str;
    }

    public final String getPrefillCardNum() {
        return this.prefillCardNum;
    }

    public final void setPrefillCardNum(String str) {
        this.prefillCardNum = str;
    }

    public final String getPrefillCardExp() {
        return this.prefillCardExp;
    }

    public final void setPrefillCardExp(String str) {
        this.prefillCardExp = str;
    }

    public final String getPrefillCardCvv() {
        return this.prefillCardCvv;
    }

    public final void setPrefillCardCvv(String str) {
        this.prefillCardCvv = str;
    }

    public final String getPrefillBankName() {
        return this.prefillBankName;
    }

    public final void setPrefillBankName(String str) {
        this.prefillBankName = str;
    }

    public final String getPrefillVpa() {
        return this.prefillVpa;
    }

    public final void setPrefillVpa(String str) {
        this.prefillVpa = str;
    }

    public final JSONObject getNotes() {
        return this.notes;
    }

    public final void setNotes(JSONObject jSONObject) {
        this.notes = jSONObject;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final Boolean getHideTopBar() {
        return this.hideTopBar;
    }

    public final void setHideTopBar(Boolean bool) {
        this.hideTopBar = bool;
    }

    public final String getBackDropColor() {
        return this.backDropColor;
    }

    public final void setBackDropColor(String str) {
        this.backDropColor = str;
    }

    public final Boolean getModalConfirmClose() {
        return this.modalConfirmClose;
    }

    public final void setModalConfirmClose(Boolean bool) {
        this.modalConfirmClose = bool;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public final Boolean getSubscriptionCardChange() {
        return this.subscriptionCardChange;
    }

    public final void setSubscriptionCardChange(Boolean bool) {
        this.subscriptionCardChange = bool;
    }

    public final Object getRecurring() {
        return this.recurring;
    }

    public final void setRecurring(Object obj) {
        this.recurring = obj;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    public final void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public final Boolean getRedirect() {
        return this.redirect;
    }

    public final void setRedirect(Boolean bool) {
        this.redirect = bool;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final Integer getTimeout() {
        return this.timeout;
    }

    public final void setTimeout(Integer num) {
        this.timeout = num;
    }

    public final Boolean getRememberCustomer() {
        return this.rememberCustomer;
    }

    public final void setRememberCustomer(Boolean bool) {
        this.rememberCustomer = bool;
    }

    public final Boolean getReadOnlyName() {
        return this.readOnlyName;
    }

    public final void setReadOnlyName(Boolean bool) {
        this.readOnlyName = bool;
    }

    public final Boolean getReadOnlyEmail() {
        return this.readOnlyEmail;
    }

    public final void setReadOnlyEmail(Boolean bool) {
        this.readOnlyEmail = bool;
    }

    public final Boolean getReadOnlyContact() {
        return this.readOnlyContact;
    }

    public final void setReadOnlyContact(Boolean bool) {
        this.readOnlyContact = bool;
    }

    public final Boolean getSendSmsHash() {
        return this.sendSmsHash;
    }

    public final void setSendSmsHash(Boolean bool) {
        this.sendSmsHash = bool;
    }

    public final Boolean getAllowRotation() {
        return this.allowRotation;
    }

    public final void setAllowRotation(Boolean bool) {
        this.allowRotation = bool;
    }

    public final Boolean getRetryEnabled() {
        return this.retryEnabled;
    }

    public final void setRetryEnabled(Boolean bool) {
        this.retryEnabled = bool;
    }

    public final Integer getRetryMaxCount() {
        return this.retryMaxCount;
    }

    public final void setRetryMaxCount(Integer num) {
        this.retryMaxCount = num;
    }

    public final JSONObject getJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, this.currency);
            jSONObject.put("amount", this.amount);
            if (!StringsKt.startsWith$default(this.orderId, "order_", false, 2, (Object) null)) {
                JSONObject jSONObjectPut = new JSONObject().put("error", "Invalid order id. Order ID starts with order_");
                Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"error\"…r ID starts with order_\")");
                return jSONObjectPut;
            }
            jSONObject.put("order_id", this.orderId);
            String str = this.name;
            if (str != null) {
                jSONObject.put("name", str);
            }
            String str2 = this.description;
            if (str2 != null) {
                jSONObject.put("description", str2);
            }
            String str3 = this.image;
            if (str3 != null) {
                jSONObject.put("image", str3);
            }
            String str4 = this.prefillName;
            if (str4 != null) {
                jSONObject3.put("name", str4);
            }
            String str5 = this.prefillContact;
            if (str5 != null) {
                jSONObject3.put("contact", str5);
            }
            String str6 = this.prefillEmail;
            if (str6 != null) {
                jSONObject3.put("email", str6);
            }
            String str7 = this.prefillMethod;
            if (str7 != null) {
                jSONObject3.put(FirebaseAnalytics.Param.METHOD, str7);
            }
            String str8 = this.prefillCardNum;
            if (str8 != null) {
                jSONObject3.put("card[number]", str8);
            }
            String str9 = this.prefillCardExp;
            if (str9 != null) {
                jSONObject3.put("card[expiry]", str9);
            }
            String str10 = this.prefillCardCvv;
            if (str10 != null) {
                jSONObject3.put("card[cvv]", str10);
            }
            String str11 = this.prefillBankName;
            if (str11 != null) {
                jSONObject3.put("bank", str11);
            }
            String str12 = this.prefillVpa;
            if (str12 != null) {
                jSONObject3.put("vpa", str12);
            }
            if (jSONObject3.length() > 0) {
                jSONObject.put("prefill", jSONObject3);
            }
            JSONObject jSONObject5 = this.notes;
            if (jSONObject5 != null) {
                jSONObject.put("notes", jSONObject5);
            }
            String str13 = this.color;
            if (str13 != null) {
                String strCheckColorValidityAndSanitize = checkColorValidityAndSanitize(str13);
                if (!StringsKt.startsWith$default(strCheckColorValidityAndSanitize, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) {
                    JSONObject jSONObjectPut2 = new JSONObject().put("error", strCheckColorValidityAndSanitize);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"error\",sanitizedColor)");
                    return jSONObjectPut2;
                }
                jSONObject4.put("color", strCheckColorValidityAndSanitize);
            }
            Boolean bool = this.hideTopBar;
            if (bool != null) {
                jSONObject4.put("hide_topbar", bool.booleanValue());
            }
            String str14 = this.backDropColor;
            if (str14 != null) {
                String strCheckColorValidityAndSanitize2 = checkColorValidityAndSanitize(str14);
                if (!StringsKt.startsWith$default(strCheckColorValidityAndSanitize2, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) {
                    JSONObject jSONObjectPut3 = new JSONObject().put("error", strCheckColorValidityAndSanitize2);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectPut3, "JSONObject().put(\"error\",sanitizedColor)");
                    return jSONObjectPut3;
                }
                jSONObject4.put("backdrop_color", strCheckColorValidityAndSanitize2);
            }
            if (jSONObject4.length() > 0) {
                jSONObject.put(Const.THEME, jSONObject4);
            }
            Boolean bool2 = this.modalConfirmClose;
            if (bool2 != null) {
                boolean zBooleanValue = bool2.booleanValue();
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("confirm_close", zBooleanValue);
                jSONObject.put("modal", jSONObject6);
            }
            String str15 = this.subscriptionId;
            if (str15 != null) {
                jSONObject.put("subscription_id", str15);
            }
            Boolean bool3 = this.subscriptionCardChange;
            if (bool3 != null) {
                jSONObject.put("subscription_card_change", bool3.booleanValue());
            }
            Object obj = this.recurring;
            if (obj != null) {
                jSONObject.put("recurring", obj);
            }
            String str16 = this.callbackUrl;
            if (str16 != null) {
                jSONObject.put("callback_url", str16);
            }
            Boolean bool4 = this.redirect;
            if (bool4 != null) {
                jSONObject.put("redirect", bool4.booleanValue());
            }
            String str17 = this.customerId;
            if (str17 != null) {
                if (!StringsKt.startsWith$default(str17, "cust_", false, 2, (Object) null)) {
                    JSONObject jSONObjectPut4 = new JSONObject().put("error", "Invalid Customer ID. It starts with cust_");
                    Intrinsics.checkNotNullExpressionValue(jSONObjectPut4, "JSONObject().put(\"error\"…D. It starts with cust_\")");
                    return jSONObjectPut4;
                }
                jSONObject.put("customer_id", str17);
            }
            Integer num = this.timeout;
            if (num != null) {
                jSONObject.put("timeout", num.intValue());
            }
            Boolean bool5 = this.rememberCustomer;
            if (bool5 != null) {
                jSONObject.put("remember_customer", bool5.booleanValue());
            }
            Boolean bool6 = this.retryEnabled;
            if (bool6 != null) {
                boolean zBooleanValue2 = bool6.booleanValue();
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(StreamManagement.Enabled.ELEMENT, zBooleanValue2);
                Integer num2 = this.retryMaxCount;
                jSONObject7.put("max_count", num2 != null ? num2.intValue() : 4);
                jSONObject.put("retry", jSONObject7);
            }
            Boolean bool7 = this.readOnlyName;
            if (bool7 != null) {
                jSONObject2.put("name", bool7.booleanValue());
            }
            Boolean bool8 = this.readOnlyContact;
            if (bool8 != null) {
                jSONObject2.put("contact", bool8.booleanValue());
            }
            Boolean bool9 = this.readOnlyEmail;
            if (bool9 != null) {
                jSONObject2.put("email", bool9.booleanValue());
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("readonly", jSONObject2);
            }
            Boolean bool10 = this.allowRotation;
            if (bool10 != null) {
                jSONObject.put("allow_rotation", bool10.booleanValue());
            }
            Boolean bool11 = this.sendSmsHash;
            if (bool11 != null) {
                jSONObject.put("send_sms_hash", bool11.booleanValue());
            }
            return jSONObject;
        } catch (JSONException e2) {
            JSONObject jSONObjectPut5 = new JSONObject().put("error", e2.getLocalizedMessage());
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut5, "JSONObject().put(\"error\", e.localizedMessage)");
            return jSONObjectPut5;
        }
    }

    private final String checkColorValidityAndSanitize(String color) {
        return color.length() < 6 ? "Invalid color" : color.length() == 6 ? StringsKt.startsWith$default(color, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null) ? "Invalid color" : MqttTopic.MULTI_LEVEL_WILDCARD + color : (color.length() == 7 && StringsKt.startsWith$default(color, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) ? color : "Invalid color";
    }
}
