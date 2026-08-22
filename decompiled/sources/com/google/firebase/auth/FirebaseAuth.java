package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzgk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.api.internal.zzau;
import com.google.firebase.auth.api.internal.zzds;
import com.google.firebase.auth.api.internal.zzdv;
import com.google.firebase.auth.api.internal.zzeh;
import com.google.firebase.auth.api.internal.zzel;
import com.google.firebase.auth.api.internal.zzeq;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzap;
import com.google.firebase.auth.internal.zzas;
import com.google.firebase.auth.internal.zzav;
import com.google.firebase.auth.internal.zzaw;
import com.google.firebase.auth.internal.zzaz;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class FirebaseAuth implements InternalAuthProvider {
    private FirebaseApp zza;
    private final List<IdTokenListener> zzb;
    private final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    private List<AuthStateListener> zzd;
    private zzau zze;
    private FirebaseUser zzf;
    private com.google.firebase.auth.internal.zzo zzg;
    private final Object zzh;
    private String zzi;
    private final Object zzj;
    private String zzk;
    private final zzav zzl;
    private final zzam zzm;
    private com.google.firebase.auth.internal.zzau zzn;
    private zzaw zzo;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    class zza implements com.google.firebase.auth.internal.zza {
        zza() {
        }

        @Override // com.google.firebase.auth.internal.zza
        public final void zza(zzff zzffVar, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzffVar);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzffVar);
            FirebaseAuth.this.zza(firebaseUser, zzffVar, true);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    class zzb implements com.google.firebase.auth.internal.zza, com.google.firebase.auth.internal.zzae {
        zzb() {
        }

        @Override // com.google.firebase.auth.internal.zza
        public final void zza(zzff zzffVar, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzffVar);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzffVar);
            FirebaseAuth.this.zza(firebaseUser, zzffVar, true, true);
        }

        @Override // com.google.firebase.auth.internal.zzae
        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
                FirebaseAuth.this.signOut();
            }
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    class zzc extends zza implements com.google.firebase.auth.internal.zza, com.google.firebase.auth.internal.zzae {
        zzc(FirebaseAuth firebaseAuth) {
            super();
        }

        @Override // com.google.firebase.auth.internal.zzae
        public final void zza(Status status) {
        }
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzeh.zza(firebaseApp.getApplicationContext(), new zzel(firebaseApp.getOptions().getApiKey()).zza()), new zzav(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()), zzam.zza());
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzau zzauVar, zzav zzavVar, zzam zzamVar) {
        zzff zzffVarZzb;
        this.zzh = new Object();
        this.zzj = new Object();
        this.zza = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zze = (zzau) Preconditions.checkNotNull(zzauVar);
        zzav zzavVar2 = (zzav) Preconditions.checkNotNull(zzavVar);
        this.zzl = zzavVar2;
        this.zzg = new com.google.firebase.auth.internal.zzo();
        zzam zzamVar2 = (zzam) Preconditions.checkNotNull(zzamVar);
        this.zzm = zzamVar2;
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzo = zzaw.zza();
        FirebaseUser firebaseUserZza = zzavVar2.zza();
        this.zzf = firebaseUserZza;
        if (firebaseUserZza != null && (zzffVarZzb = zzavVar2.zzb(firebaseUserZza)) != null) {
            zza(this.zzf, zzffVarZzb, false);
        }
        zzamVar2.zza(this);
    }

    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public final void zza(FirebaseUser firebaseUser, zzff zzffVar, boolean z) {
        zza(firebaseUser, zzffVar, z, false);
    }

    final void zza(FirebaseUser firebaseUser, zzff zzffVar, boolean z, boolean z2) {
        boolean z3;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzffVar);
        boolean z4 = true;
        boolean z5 = this.zzf != null && firebaseUser.getUid().equals(this.zzf.getUid());
        if (z5 || !z2) {
            FirebaseUser firebaseUser2 = this.zzf;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z6 = (z5 && firebaseUser2.zze().zzd().equals(zzffVar.zzd())) ? false : true;
                z3 = z5 ? false : true;
                z4 = z6;
            }
            Preconditions.checkNotNull(firebaseUser);
            FirebaseUser firebaseUser3 = this.zzf;
            if (firebaseUser3 == null) {
                this.zzf = firebaseUser;
            } else {
                firebaseUser3.zza(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    this.zzf.zzb();
                }
                this.zzf.zzb(firebaseUser.zzh().zza());
            }
            if (z) {
                this.zzl.zza(this.zzf);
            }
            if (z4) {
                FirebaseUser firebaseUser4 = this.zzf;
                if (firebaseUser4 != null) {
                    firebaseUser4.zza(zzffVar);
                }
                zzc(this.zzf);
            }
            if (z3) {
                zzd(this.zzf);
            }
            if (z) {
                this.zzl.zza(firebaseUser, zzffVar);
            }
            zzd().zza(this.zzf.zze());
        }
    }

    public final void zza() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            zzav zzavVar = this.zzl;
            Preconditions.checkNotNull(firebaseUser);
            zzavVar.zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
            this.zzf = null;
        }
        this.zzl.zza("com.google.firebase.auth.FIREBASE_USER");
        zzc((FirebaseUser) null);
        zzd((FirebaseUser) null);
    }

    private final synchronized void zza(com.google.firebase.auth.internal.zzau zzauVar) {
        this.zzn = zzauVar;
    }

    private final synchronized com.google.firebase.auth.internal.zzau zzd() {
        if (this.zzn == null) {
            zza(new com.google.firebase.auth.internal.zzau(this.zza));
        }
        return this.zzn;
    }

    public FirebaseApp getApp() {
        return this.zza;
    }

    public final FirebaseApp zzb() {
        return this.zza;
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        this.zzo.execute(new zzl(this, idTokenListener));
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzd().zza(this.zzc.size());
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzd().zza(this.zzc.size());
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzo.execute(new zzn(this, authStateListener));
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    private final void zzc(FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        } else {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 45).append("Notifying id token listeners about user ( ").append(uid).append(" ).").toString());
        }
        this.zzo.execute(new zzm(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzg() : null)));
    }

    private final void zzd(FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        } else {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 47).append("Notifying auth state listeners about user ( ").append(uid).append(" ).").toString());
        }
        this.zzo.execute(new zzp(this));
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzf, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzaz, com.google.firebase.auth.zzo] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<GetTokenResult> zza(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzdv.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzff zzffVarZze = firebaseUser.zze();
        if (zzffVarZze.zzb() && !z) {
            return Tasks.forResult(zzap.zza(zzffVarZze.zzd()));
        }
        return this.zze.zza(this.zza, firebaseUser, zzffVarZze.zzc(), (zzaz) new zzo(this));
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            if (!emailAuthCredential.zzg()) {
                return this.zze.zzb(this.zza, emailAuthCredential.zzb(), emailAuthCredential.zzc(), this.zzk, new zza());
            }
            if (zzb(emailAuthCredential.zzd())) {
                return Tasks.forException(zzdv.zza(new Status(17072)));
            }
            return this.zze.zza(this.zza, emailAuthCredential, new zza());
        }
        if (authCredentialZza instanceof PhoneAuthCredential) {
            return this.zze.zza(this.zza, (PhoneAuthCredential) authCredentialZza, this.zzk, (com.google.firebase.auth.internal.zza) new zza());
        }
        return this.zze.zza(this.zza, authCredentialZza, this.zzk, new zza());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zza(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zze.zza(this.zza, firebaseUser, emailAuthCredential.zzb(), emailAuthCredential.zzc(), firebaseUser.zzd(), new zzb());
            }
            if (zzb(emailAuthCredential.zzd())) {
                return Tasks.forException(zzdv.zza(new Status(17072)));
            }
            return this.zze.zza(this.zza, firebaseUser, emailAuthCredential, (zzaz) new zzb());
        }
        if (authCredentialZza instanceof PhoneAuthCredential) {
            return this.zze.zza(this.zza, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzk, (zzaz) new zzb());
        }
        return this.zze.zza(this.zza, firebaseUser, authCredentialZza, firebaseUser.zzd(), (zzaz) new zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<AuthResult> zzb(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zze.zzb(this.zza, firebaseUser, emailAuthCredential.zzb(), emailAuthCredential.zzc(), firebaseUser.zzd(), new zzb());
            }
            if (zzb(emailAuthCredential.zzd())) {
                return Tasks.forException(zzdv.zza(new Status(17072)));
            }
            return this.zze.zzb(this.zza, firebaseUser, emailAuthCredential, (zzaz) new zzb());
        }
        if (authCredentialZza instanceof PhoneAuthCredential) {
            return this.zze.zzb(this.zza, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzk, (zzaz) new zzb());
        }
        return this.zze.zzb(this.zza, firebaseUser, authCredentialZza, firebaseUser.zzd(), (zzaz) new zzb());
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk, new zza());
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzb(this.zza, str, str2, this.zzk, new zza());
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null && firebaseUser.isAnonymous()) {
            com.google.firebase.auth.internal.zzn zznVar = (com.google.firebase.auth.internal.zzn) this.zzf;
            zznVar.zza(false);
            return Tasks.forResult(new com.google.firebase.auth.internal.zzh(zznVar));
        }
        return this.zze.zza(this.zza, new zza(), this.zzk);
    }

    public final void zza(String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z, String str2) {
        long jConvert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (jConvert < 0 || jConvert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        this.zze.zza(this.zza, new zzfr(str, jConvert, z, this.zzi, this.zzk, null), (this.zzg.zzc() && str.equals(this.zzg.zza())) ? new zzr(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks, activity, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.firebase.auth.FirebaseAuth$zzc, com.google.firebase.auth.internal.zzaz] */
    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        }
        if ((firebaseUser.zzd() != null && !firebaseUser.zzd().equals(this.zzk)) || ((str = this.zzk) != null && !str.equals(firebaseUser.zzd()))) {
            return Tasks.forException(zzdv.zza(new Status(17072)));
        }
        String apiKey = firebaseUser.zzc().getOptions().getApiKey();
        String apiKey2 = this.zza.getOptions().getApiKey();
        if (firebaseUser.zze().zzb() && apiKey2.equals(apiKey)) {
            zza(com.google.firebase.auth.internal.zzn.zza(this.zza, firebaseUser), firebaseUser.zze(), true);
            return Tasks.forResult(null);
        }
        return zza(firebaseUser, (zzaz) new zzc(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    public final Task<Void> zza(FirebaseUser firebaseUser) {
        return zza(firebaseUser, (zzaz) new zzb());
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, zzaz zzazVar) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(this.zza, firebaseUser, zzazVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<AuthResult> zzc(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(this.zza, firebaseUser, authCredential.zza(), (zzaz) new zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<AuthResult> zza(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzd(this.zza, firebaseUser, str, new zzb());
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zza(this.zza, str, str2, this.zzk, new zza());
    }

    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zza(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zze.zza(this.zza, firebaseUser, userProfileChangeRequest, (zzaz) new zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zzb(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzb(this.zza, firebaseUser, str, (zzaz) new zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zza(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zze.zza(this.zza, firebaseUser, (PhoneAuthCredential) phoneAuthCredential.zza(), (zzaz) new zzb());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzaz] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task<Void> zzc(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzc(this.zza, firebaseUser, str, new zzb());
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zza();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        actionCodeSettings.zza(zzgk.PASSWORD_RESET);
        return this.zze.zza(this.zza, str, actionCodeSettings, this.zzk);
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (!actionCodeSettings.canHandleCodeInApp()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        return this.zze.zzb(this.zza, str, actionCodeSettings, this.zzk);
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zza(str);
    }

    public final Task<Void> zza(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zza();
            }
            actionCodeSettings.zza(this.zzi);
        }
        return this.zze.zza(this.zza, actionCodeSettings, str);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzb(this.zza, str, this.zzk);
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzc(this.zza, str, this.zzk);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzd(this.zza, str, this.zzk);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zza(this.zza, str, str2, this.zzk);
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        if (!zzds.zza()) {
            return Tasks.forException(zzdv.zza(new Status(17063)));
        }
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzm.zza(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzdv.zza(new Status(17057)));
        }
        zzas.zza(activity.getApplicationContext(), this);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<AuthResult> zza(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        if (!zzds.zza()) {
            return Tasks.forException(zzdv.zza(new Status(17063)));
        }
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzm.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzdv.zza(new Status(17057)));
        }
        zzas.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<AuthResult> zzb(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        if (!zzds.zza()) {
            return Tasks.forException(zzdv.zza(new Status(17063)));
        }
        TaskCompletionSource<AuthResult> taskCompletionSource = new TaskCompletionSource<>();
        if (!this.zzm.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzdv.zza(new Status(17057)));
        }
        zzas.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzm.zzb();
    }

    public final Task<Void> zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zza(firebaseUser, new zzq(this, firebaseUser));
    }

    public void signOut() {
        zza();
        com.google.firebase.auth.internal.zzau zzauVar = this.zzn;
        if (zzauVar != null) {
            zzauVar.zza();
        }
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    public final void zza(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public final String zzc() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = zzeq.zza();
        }
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zze.zza(str);
    }

    private final boolean zzb(String str) {
        zzf zzfVarZza = zzf.zza(str);
        return (zzfVarZza == null || TextUtils.equals(this.zzk, zzfVarZza.zzc())) ? false : true;
    }
}
