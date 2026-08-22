package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.internal.FederatedSignInActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class OAuthProvider extends FederatedAuthProvider {
    private final Bundle zza;

    private OAuthProvider(Bundle bundle) {
        this.zza = bundle;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static class CredentialBuilder {
        private final String zza;
        private String zzb;
        private String zzc;
        private String zzd;

        private CredentialBuilder(String str) {
            this.zza = str;
        }

        public CredentialBuilder setIdToken(String str) {
            this.zzb = str;
            return this;
        }

        public CredentialBuilder setIdTokenWithRawNonce(String str, String str2) {
            this.zzb = str;
            this.zzd = str2;
            return this;
        }

        public CredentialBuilder setAccessToken(String str) {
            this.zzc = str;
            return this;
        }

        public AuthCredential build() {
            return zzg.zza(this.zza, this.zzb, this.zzc, this.zzd);
        }
    }

    public static Builder newBuilder(String str) {
        return newBuilder(str, FirebaseAuth.getInstance());
    }

    public static Builder newBuilder(String str, FirebaseAuth firebaseAuth) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseAuth);
        if ("facebook.com".equals(str)) {
            throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
        }
        return new Builder(str, firebaseAuth, googleApiAvailability);
    }

    public String getProviderId() {
        Bundle bundle = this.zza;
        if (bundle == null) {
            return null;
        }
        return bundle.getString("com.google.firebase.auth.KEY_PROVIDER_ID", null);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zza(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.SIGN_IN");
        intent.setPackage(activity.getPackageName());
        intent.setClass(activity, FederatedSignInActivity.class);
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static class Builder {
        private final FirebaseAuth zza;
        private final Bundle zzb;
        private final Bundle zzc;

        private Builder(String str, FirebaseAuth firebaseAuth, GoogleApiAvailability googleApiAvailability) {
            Bundle bundle = new Bundle();
            this.zzb = bundle;
            Bundle bundle2 = new Bundle();
            this.zzc = bundle2;
            this.zza = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.zzb().getOptions().getApiKey());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", Integer.toString(googleApiAvailability.getClientVersion(firebaseAuth.zzb().getApplicationContext())));
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.zzc());
        }

        public Builder setScopes(List<String> list) {
            this.zzb.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(list));
            return this;
        }

        public Builder addCustomParameter(String str, String str2) {
            this.zzc.putString(str, str2);
            return this;
        }

        public Builder addCustomParameters(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.zzc.putString(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public OAuthProvider build() {
            return new OAuthProvider(this.zzb);
        }
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzb(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.LINK");
        intent.setPackage(activity.getPackageName());
        intent.setClass(activity, FederatedSignInActivity.class);
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzc(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.REAUTHENTICATE");
        intent.setPackage(activity.getPackageName());
        intent.setClass(activity, FederatedSignInActivity.class);
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    public static CredentialBuilder newCredentialBuilder(String str) {
        return new CredentialBuilder(Preconditions.checkNotEmpty(str));
    }

    @Deprecated
    public static AuthCredential getCredential(String str, String str2, String str3) {
        return zzg.zza(str, str2, str3);
    }
}
