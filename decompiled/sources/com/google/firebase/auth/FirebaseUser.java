package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    @Override // com.google.firebase.auth.UserInfo
    public abstract String getDisplayName();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getEmail();

    public abstract FirebaseUserMetadata getMetadata();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getPhoneNumber();

    @Override // com.google.firebase.auth.UserInfo
    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getProviderId();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getUid();

    public abstract boolean isAnonymous();

    public abstract FirebaseUser zza(List<? extends UserInfo> list);

    public abstract List<String> zza();

    public abstract void zza(zzff zzffVar);

    public abstract FirebaseUser zzb();

    public abstract void zzb(List<zzy> list);

    public abstract FirebaseApp zzc();

    public abstract String zzd();

    public abstract zzff zze();

    public abstract String zzf();

    public abstract String zzg();

    public abstract zzz zzh();

    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zzc()).zza(this, z);
    }

    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zzc()).zza(this);
    }

    public Task<Void> reauthenticate(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzc()).zza(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzc()).zzb(this, authCredential);
    }

    public Task<AuthResult> startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zzc()).zzb(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzc()).zzc(this, authCredential);
    }

    public Task<AuthResult> startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zzc()).zza(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> unlink(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzc()).zza(this, str);
    }

    public Task<Void> updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zzc()).zza(this, userProfileChangeRequest);
    }

    public Task<Void> updateEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzc()).zzb(this, str);
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zzc()).zza(this, phoneAuthCredential);
    }

    public Task<Void> updatePassword(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzc()).zzc(this, str);
    }

    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zzc()).zzb(this);
    }

    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzc()).zza(this, false).continueWithTask(new zzu(this));
    }

    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzc()).zza(this, false).continueWithTask(new zzv(this, actionCodeSettings));
    }
}
