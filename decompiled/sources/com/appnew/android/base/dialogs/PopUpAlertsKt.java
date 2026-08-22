package com.appnew.android.base.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.appnew.android.Model.Video;
import com.eduteria.app.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopUpAlerts.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¨\u0006\b"}, d2 = {"popUpDeleteVideo", "", "context", "Landroid/content/Context;", "video", "Lcom/appnew/android/Model/Video;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PopUpAlertsKt {
    public static final void popUpDeleteVideo(Context context, Video video, final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.dialog_alert_simple);
        ((TextView) dialog.findViewById(R.id.titleDialog)).setVisibility(8);
        ((TextView) dialog.findViewById(R.id.msgDialog)).setText(context.getResources().getString(R.string.do_you_want_to_delete) + video.getTitle());
        Button button = (Button) dialog.findViewById(R.id.btn_cancel);
        button.setText(context.getResources().getString(R.string.no));
        Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
        button2.setText(context.getResources().getString(R.string.yes));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.PopUpAlertsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopUpAlertsKt.popUpDeleteVideo$lambda$0(listener, dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.PopUpAlertsKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popUpDeleteVideo$lambda$0(Function0 function0, Dialog dialog, View view) {
        function0.invoke();
        dialog.dismiss();
        dialog.cancel();
    }
}
