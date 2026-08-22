package com.google.crypto.tink.subtle.prf;

import com.google.errorprone.annotations.Immutable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes8.dex */
@Immutable
public interface StreamingPrf {
    InputStream computePrf(final byte[] input);
}
