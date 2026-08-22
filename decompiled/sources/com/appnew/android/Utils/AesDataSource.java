package com.appnew.android.Utils;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: compiled from: AesDataSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/Utils/AesDataSource;", "Landroidx/media3/datasource/DataSource;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Ljavax/crypto/Cipher;)V", "inputStream", "Ljavax/crypto/CipherInputStream;", "uri", "Landroid/net/Uri;", "open", "", "dataSpec", "Landroidx/media3/datasource/DataSpec;", "read", "", TypedValues.AttributesType.S_TARGET, "", "offset", Range.ATTR_LENGTH, "addTransferListener", "", "transferListener", "Landroidx/media3/datasource/TransferListener;", "getUri", "close", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AesDataSource implements DataSource {
    public static final int $stable = 8;
    private final Cipher cipher;
    private CipherInputStream inputStream;
    private Uri uri;

    @Override // androidx.media3.datasource.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(transferListener, "transferListener");
    }

    public AesDataSource(Cipher cipher) {
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.cipher = cipher;
    }

    @Override // androidx.media3.datasource.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        CipherInputStream cipherInputStream;
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
        Uri uri = dataSpec.uri;
        this.uri = uri;
        Uri uri2 = null;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
            uri = null;
        }
        if (uri.getPath() == null) {
            return 0L;
        }
        Uri uri3 = this.uri;
        if (uri3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uri");
        } else {
            uri2 = uri3;
        }
        String path = uri2.getPath();
        Intrinsics.checkNotNull(path);
        File canonicalFile = new File(path).getCanonicalFile();
        Intrinsics.checkNotNull(canonicalFile);
        this.inputStream = new CipherInputStream(new FileInputStream(canonicalFile), this.cipher);
        if (dataSpec.position != 0 && (cipherInputStream = this.inputStream) != null) {
            ExtensionKt.forceSkip(cipherInputStream, dataSpec.position);
        }
        return dataSpec.length;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] target, int offset, int length) throws IOException {
        CipherInputStream cipherInputStream;
        Intrinsics.checkNotNullParameter(target, "target");
        if (length == 0 || (cipherInputStream = this.inputStream) == null) {
            return 0;
        }
        return cipherInputStream.read(target, offset, length);
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        Uri uri = this.uri;
        if (uri != null) {
            return uri;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uri");
        return null;
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() throws IOException {
        CipherInputStream cipherInputStream = this.inputStream;
        if (cipherInputStream != null) {
            cipherInputStream.close();
        }
    }
}
