package com.clevertap.android.sdk.utils;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jivesoftware.smackx.hashes.element.HashElement;

/* JADX INFO: compiled from: UrlHashGenerator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/clevertap/android/sdk/utils/UrlHashGenerator;", "", "<init>", "()V", HashElement.ELEMENT, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "hashWithTsSeed", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UrlHashGenerator {
    public static final UrlHashGenerator INSTANCE = new UrlHashGenerator();

    public final Function1<String, String> hash() {
        return new Function1() { // from class: com.clevertap.android.sdk.utils.UrlHashGenerator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UrlHashGenerator.hash$lambda$0((String) obj);
            }
        };
    }

    private UrlHashGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hash$lambda$0(String key) {
        UUID uuidNameUUIDFromBytes;
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            byte[] bytes = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            uuidNameUUIDFromBytes = UUID.nameUUIDFromBytes(bytes);
        } catch (InternalError unused) {
            String.valueOf(key.hashCode());
            uuidNameUUIDFromBytes = null;
        }
        return (uuidNameUUIDFromBytes == null || (string = uuidNameUUIDFromBytes.toString()) == null) ? String.valueOf(key.hashCode()) : string;
    }

    public final String hashWithTsSeed() {
        Function1<String, String> function1Hash = hash();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        Intrinsics.checkNotNullExpressionValue(strValueOf, "valueOf(...)");
        return function1Hash.invoke(strValueOf);
    }
}
