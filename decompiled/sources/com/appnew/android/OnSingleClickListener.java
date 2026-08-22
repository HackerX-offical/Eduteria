package com.appnew.android;

import android.os.SystemClock;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: OnSingleClickListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/appnew/android/OnSingleClickListener;", "Landroid/view/View$OnClickListener;", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "lastClickTime", "", "onClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnSingleClickListener implements View.OnClickListener {
    public static final int $stable = 8;
    private final Function0<Unit> block;
    private long lastClickTime;

    public OnSingleClickListener(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (SystemClock.elapsedRealtime() - this.lastClickTime < 1000) {
            return;
        }
        this.lastClickTime = SystemClock.elapsedRealtime();
        this.block.invoke();
    }
}
