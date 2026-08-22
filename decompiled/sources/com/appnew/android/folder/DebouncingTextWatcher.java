package com.appnew.android.folder;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebouncingTextWatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J*\u0010\u0015\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0018H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/appnew/android/folder/DebouncingTextWatcher;", "Landroid/text/TextWatcher;", "onDebouncedTextChanged", "Lkotlin/Function1;", "", "", "debounceDelay", "", "<init>", "(Lkotlin/jvm/functions/Function1;J)V", "handler", "Landroid/os/Handler;", "runnable", "Ljava/lang/Runnable;", "beforeTextChanged", CmcdData.Factory.STREAMING_FORMAT_SS, "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebouncingTextWatcher implements TextWatcher {
    public static final int $stable = 8;
    private final long debounceDelay;
    private final Handler handler;
    private final Function1<String, Unit> onDebouncedTextChanged;
    private Runnable runnable;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebouncingTextWatcher(Function1<? super String, Unit> onDebouncedTextChanged, long j) {
        Intrinsics.checkNotNullParameter(onDebouncedTextChanged, "onDebouncedTextChanged");
        this.onDebouncedTextChanged = onDebouncedTextChanged;
        this.debounceDelay = j;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public /* synthetic */ DebouncingTextWatcher(Function1 function1, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? 500L : j);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(final Editable s) {
        Runnable runnable = this.runnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.appnew.android.folder.DebouncingTextWatcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DebouncingTextWatcher.afterTextChanged$lambda$1(this.f$0, s);
            }
        };
        this.runnable = runnable2;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, this.debounceDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void afterTextChanged$lambda$1(DebouncingTextWatcher debouncingTextWatcher, Editable editable) {
        debouncingTextWatcher.onDebouncedTextChanged.invoke(String.valueOf(editable));
    }
}
