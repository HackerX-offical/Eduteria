package com.appnew.android.base.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.appnew.android.Model.Courses.Lists;
import com.eduteria.app.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleAlertDialogs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042#\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006\u001a7\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042#\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\r"}, d2 = {"deleteVideoDialog", "", "Landroid/content/Context;", "video", "Lcom/appnew/android/Model/Courses/Lists;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "downloadVideoDialog", "lists", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SimpleAlertDialogsKt {
    public static final void deleteVideoDialog(Context context, Lists video, final Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(context, "<this>");
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
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.SimpleAlertDialogsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleAlertDialogsKt.deleteVideoDialog$lambda$0(listener, dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.SimpleAlertDialogsKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteVideoDialog$lambda$0(Function1 function1, Dialog dialog, View view) {
        function1.invoke(view);
        dialog.dismiss();
        dialog.cancel();
    }

    public static final void downloadVideoDialog(Context context, Lists lists, final Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(lists, "lists");
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
        ((TextView) dialog.findViewById(R.id.titleDialog)).setText(context.getResources().getString(R.string.download_video));
        ((TextView) dialog.findViewById(R.id.msgDialog)).setText(lists.getTitle() + context.getResources().getString(R.string.this_video_will_be_downloaded_in_your_my_downloads));
        Button button = (Button) dialog.findViewById(R.id.btn_cancel);
        button.setText(context.getResources().getString(R.string.cancel));
        Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
        button2.setText(context.getResources().getString(R.string.download_));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.SimpleAlertDialogsKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleAlertDialogsKt.downloadVideoDialog$lambda$2(listener, dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.SimpleAlertDialogsKt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadVideoDialog$lambda$2(Function1 function1, Dialog dialog, View view) {
        function1.invoke(view);
        dialog.dismiss();
        dialog.cancel();
    }
}
