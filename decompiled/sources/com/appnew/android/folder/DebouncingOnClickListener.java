package com.appnew.android.folder;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: DebouncingOnClickListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \f2\u00020\u0001:\u0001\fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/appnew/android/folder/DebouncingOnClickListener;", "Landroid/view/View$OnClickListener;", "intervalMillis", "", "doClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "<init>", "(JLkotlin/jvm/functions/Function1;)V", "onClick", "v", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DebouncingOnClickListener implements View.OnClickListener {
    public static final int $stable = 0;
    private final Function1<View, Unit> doClick;
    private final long intervalMillis;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean enabled = true;
    private static final Runnable ENABLE_AGAIN = new Runnable() { // from class: com.appnew.android.folder.DebouncingOnClickListener$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            DebouncingOnClickListener.enabled = true;
        }
    };

    public static final boolean getEnabled() {
        return INSTANCE.getEnabled();
    }

    public static final void setEnabled(boolean z) {
        INSTANCE.setEnabled(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebouncingOnClickListener(long j, Function1<? super View, Unit> doClick) {
        Intrinsics.checkNotNullParameter(doClick, "doClick");
        this.intervalMillis = j;
        this.doClick = doClick;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (enabled) {
            enabled = false;
            v.postDelayed(ENABLE_AGAIN, this.intervalMillis);
            this.doClick.invoke(v);
        }
    }

    /* JADX INFO: compiled from: DebouncingOnClickListener.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/appnew/android/folder/DebouncingOnClickListener$Companion;", "", "<init>", "()V", StreamManagement.Enabled.ELEMENT, "", "getEnabled$annotations", "getEnabled", "()Z", "setEnabled", "(Z)V", "ENABLE_AGAIN", "Ljava/lang/Runnable;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getEnabled$annotations() {
        }

        private Companion() {
        }

        public final boolean getEnabled() {
            return DebouncingOnClickListener.enabled;
        }

        public final void setEnabled(boolean z) {
            DebouncingOnClickListener.enabled = z;
        }
    }
}
