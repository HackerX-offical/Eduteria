package com.razorpay;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PhoneNumberHintHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/razorpay/PhoneNumberHintHelper;", "", "()V", "request", "Lcom/google/android/gms/auth/api/identity/GetPhoneNumberHintIntentRequest;", "getRequest", "()Lcom/google/android/gms/auth/api/identity/GetPhoneNumberHintIntentRequest;", "onActivityResultReceived", "Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberResponse;", "activity", "Landroid/app/Activity;", "resultCode", "", "data", "Landroid/content/Intent;", "triggerPhoneNumberHintApi", "", "PhoneNumberHintResponseStates", "PhoneNumberResponse", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PhoneNumberHintHelper {
    public static final PhoneNumberHintHelper INSTANCE = new PhoneNumberHintHelper();
    private static final GetPhoneNumberHintIntentRequest request;

    /* JADX INFO: compiled from: PhoneNumberHintHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberHintResponseStates;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "FAILED_TO_FETCH_NUMBER", "USER_DECLINED", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum PhoneNumberHintResponseStates {
        SUCCESS,
        FAILED,
        FAILED_TO_FETCH_NUMBER,
        USER_DECLINED
    }

    private PhoneNumberHintHelper() {
    }

    /* JADX INFO: compiled from: PhoneNumberHintHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberResponse;", "", "state", "Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberHintResponseStates;", "contact", "", "message", "(Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberHintResponseStates;Ljava/lang/String;Ljava/lang/String;)V", "getContact", "()Ljava/lang/String;", "setContact", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getState", "()Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberHintResponseStates;", "setState", "(Lcom/razorpay/PhoneNumberHintHelper$PhoneNumberHintResponseStates;)V", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class PhoneNumberResponse {
        private String contact;
        private String message;
        private PhoneNumberHintResponseStates state;

        public static /* synthetic */ PhoneNumberResponse copy$default(PhoneNumberResponse phoneNumberResponse, PhoneNumberHintResponseStates phoneNumberHintResponseStates, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                phoneNumberHintResponseStates = phoneNumberResponse.state;
            }
            if ((i & 2) != 0) {
                str = phoneNumberResponse.contact;
            }
            if ((i & 4) != 0) {
                str2 = phoneNumberResponse.message;
            }
            return phoneNumberResponse.copy(phoneNumberHintResponseStates, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PhoneNumberHintResponseStates getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContact() {
            return this.contact;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final PhoneNumberResponse copy(PhoneNumberHintResponseStates state, String contact, String message) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new PhoneNumberResponse(state, contact, message);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PhoneNumberResponse)) {
                return false;
            }
            PhoneNumberResponse phoneNumberResponse = (PhoneNumberResponse) other;
            return this.state == phoneNumberResponse.state && Intrinsics.areEqual(this.contact, phoneNumberResponse.contact) && Intrinsics.areEqual(this.message, phoneNumberResponse.message);
        }

        public final int hashCode() {
            int iHashCode = this.state.hashCode() * 31;
            String str = this.contact;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.message;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            return "PhoneNumberResponse(state=" + this.state + ", contact=" + this.contact + ", message=" + this.message + ')';
        }

        public PhoneNumberResponse(PhoneNumberHintResponseStates state, String str, String str2) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.contact = str;
            this.message = str2;
        }

        public final PhoneNumberHintResponseStates getState() {
            return this.state;
        }

        public final void setState(PhoneNumberHintResponseStates phoneNumberHintResponseStates) {
            Intrinsics.checkNotNullParameter(phoneNumberHintResponseStates, "<set-?>");
            this.state = phoneNumberHintResponseStates;
        }

        public final String getContact() {
            return this.contact;
        }

        public final void setContact(String str) {
            this.contact = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }
    }

    static {
        GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequestBuild = GetPhoneNumberHintIntentRequest.builder().build();
        Intrinsics.checkNotNullExpressionValue(getPhoneNumberHintIntentRequestBuild, "builder().build()");
        request = getPhoneNumberHintIntentRequestBuild;
    }

    public final GetPhoneNumberHintIntentRequest getRequest() {
        return request;
    }

    public final void triggerPhoneNumberHintApi(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Identity.getSignInClient(activity).getPhoneNumberHintIntent(request).addOnSuccessListener(new OnSuccessListener() { // from class: com.razorpay.PhoneNumberHintHelper$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                PhoneNumberHintHelper.m12333triggerPhoneNumberHintApi$lambda0(activity, (PendingIntent) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.razorpay.PhoneNumberHintHelper$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                PhoneNumberHintHelper.m12334triggerPhoneNumberHintApi$lambda1(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: triggerPhoneNumberHintApi$lambda-0, reason: not valid java name */
    public static final void m12333triggerPhoneNumberHintApi$lambda0(Activity activity, PendingIntent result) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            AnalyticsUtil.trackEvent(AnalyticsEvent.PHONE_NUMBER_HINT_INTENT_LAUNCHED);
            ActivityCompat.startIntentSenderForResult(activity, result.getIntentSender(), 102, null, 0, 0, 0, null);
        } catch (Exception unused) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.PHONE_NUMBER_HINT_INTENT_LAUNCH_FAILED);
            Logger.e("Launching the PendingIntent failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: triggerPhoneNumberHintApi$lambda-1, reason: not valid java name */
    public static final void m12334triggerPhoneNumberHintApi$lambda1(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AnalyticsUtil.trackEvent(AnalyticsEvent.PHONE_NUMBER_HINT_INTENT_LAUNCH_FAILED);
        Logger.e("Phone Number Hint failed");
    }

    public final PhoneNumberResponse onActivityResultReceived(Activity activity, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (resultCode == -1 && data != null) {
            try {
                String phoneNumberFromIntent = Identity.getSignInClient(activity).getPhoneNumberFromIntent(data);
                Intrinsics.checkNotNullExpressionValue(phoneNumberFromIntent, "getSignInClient(activity…oneNumberFromIntent(data)");
                Logger.d("Selected Phone Number: " + phoneNumberFromIntent);
                if (!StringsKt.isBlank(phoneNumberFromIntent)) {
                    return new PhoneNumberResponse(PhoneNumberHintResponseStates.SUCCESS, phoneNumberFromIntent, null);
                }
                return new PhoneNumberResponse(PhoneNumberHintResponseStates.FAILED_TO_FETCH_NUMBER, null, "Unable to fetch contact details.");
            } catch (ApiException e2) {
                Log.e("PhoneHint", "Error extracting phone number", e2);
                PhoneNumberHintResponseStates phoneNumberHintResponseStates = PhoneNumberHintResponseStates.FAILED;
                String message = e2.getMessage();
                if (message == null) {
                    message = "Something went wrong.";
                }
                return new PhoneNumberResponse(phoneNumberHintResponseStates, null, message);
            }
        }
        return new PhoneNumberResponse(PhoneNumberHintResponseStates.USER_DECLINED, null, "User declined the request");
    }
}
