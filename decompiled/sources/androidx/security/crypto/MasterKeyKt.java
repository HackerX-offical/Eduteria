package androidx.security.crypto;

import android.content.Context;
import androidx.security.crypto.MasterKey;
import java.io.IOException;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MasterKey.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\r"}, d2 = {"MasterKey", "Landroidx/security/crypto/MasterKey;", "context", "Landroid/content/Context;", "keyAlias", "", "keyScheme", "Landroidx/security/crypto/MasterKey$KeyScheme;", "authenticationRequired", "", "userAuthenticationValidityDurationSeconds", "", "requestStrongBoxBacked", "security-crypto-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MasterKeyKt {
    public static /* synthetic */ MasterKey MasterKey$default(Context context, String str, MasterKey.KeyScheme keyScheme, boolean z, int i, boolean z2, int i2, Object obj) {
        boolean z3;
        int i3;
        MasterKey.KeyScheme keyScheme2;
        boolean z4;
        Context context2;
        String str2;
        if ((i2 & 2) != 0) {
            str = MasterKey.DEFAULT_MASTER_KEY_ALIAS;
        }
        if ((i2 & 4) != 0) {
            keyScheme = MasterKey.KeyScheme.AES256_GCM;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            i = MasterKey.getDefaultAuthenticationValidityDurationSeconds();
        }
        if ((i2 & 32) != 0) {
            z3 = false;
            z4 = z;
            i3 = i;
            str2 = str;
            keyScheme2 = keyScheme;
            context2 = context;
        } else {
            z3 = z2;
            i3 = i;
            keyScheme2 = keyScheme;
            z4 = z;
            context2 = context;
            str2 = str;
        }
        return MasterKey(context2, str2, keyScheme2, z4, i3, z3);
    }

    public static final MasterKey MasterKey(Context context, String keyAlias, MasterKey.KeyScheme keyScheme, boolean z, int i, boolean z2) throws GeneralSecurityException, IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(keyScheme, "keyScheme");
        MasterKey masterKeyBuild = new MasterKey.Builder(context, keyAlias).setKeyScheme(keyScheme).setUserAuthenticationRequired(z, i).setRequestStrongBoxBacked(z2).build();
        Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "Builder(context, keyAlia…ngBoxBacked)\n    .build()");
        return masterKeyBuild;
    }
}
