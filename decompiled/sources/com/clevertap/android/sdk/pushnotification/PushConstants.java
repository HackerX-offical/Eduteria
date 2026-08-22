package com.clevertap.android.sdk.pushnotification;

/* JADX INFO: loaded from: classes7.dex */
public class PushConstants {
    public static final String FCM_DELIVERY_TYPE = "fcm";
    public static final String FCM_LOG_TAG = "FCM";
    public static final String FCM_PUSH_TYPE = "FCM";
    public static final String LOG_TAG = "PushProvider";
    public static final String FCM_PROPERTY_REG_ID = "fcm_token";
    public static final String CT_FIREBASE_PROVIDER_CLASS = "com.clevertap.android.sdk.pushnotification.fcm.FcmPushProvider";
    public static final String FIREBASE_SDK_CLASS = "com.google.firebase.messaging.FirebaseMessagingService";
    public static final PushType FCM = new PushType("fcm", FCM_PROPERTY_REG_ID, CT_FIREBASE_PROVIDER_CLASS, FIREBASE_SDK_CLASS);

    private PushConstants() {
    }
}
