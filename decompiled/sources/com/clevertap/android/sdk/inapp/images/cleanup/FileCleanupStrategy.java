package com.clevertap.android.sdk.inapp.images.cleanup;

import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FileCleanupStrategy.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J9\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\rH&J\b\u0010\u0011\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "getFileResourceProvider", "()Lkotlin/jvm/functions/Function0;", "clearFileAssets", "", "urls", "", "", "successBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "stop", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FileCleanupStrategy {
    void clearFileAssets(List<String> urls, Function1<? super String, Unit> successBlock);

    Function0<FileResourceProvider> getFileResourceProvider();

    void stop();
}
