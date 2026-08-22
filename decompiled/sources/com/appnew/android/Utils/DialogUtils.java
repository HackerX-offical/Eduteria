package com.appnew.android.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Adapter.EMIListAdapter;
import com.appnew.android.Model.Courses.EMIInfo;
import com.appnew.android.Utils.DialogUtils;
import com.eduteria.app.app.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DialogUtils {

    public interface addViewCallback {
        void showAdd();
    }

    public interface addViewControl {
        void onAddShow(addViewCallback addViewCback);
    }

    public interface onDialogUtilsButtonOneClick {
        void onButtonOneClick();
    }

    public interface onDialogUtilsButtonThreeClick {
        void onButtonThreeClick();
    }

    public interface onDialogUtilsButtonTwoClick {
        void onButtonTwoClick();
    }

    public interface onDialogUtilsCancelClick {
        void onCancelClick();
    }

    public interface onDialogUtilsExitClick {
        void onExitClick(boolean neverShowAgain);
    }

    public interface onDialogUtilsInputOkClick {
        void onInputOKClick(String trim);

        void onInputOKClick(String trim, String trim1);

        void onInputOKClick(String input, String input1, String input2);

        void onInputOKClick(String input, String input1, String input2, String input3, String input4);
    }

    public interface onDialogUtilsListItemClick {
        void onListItemClick(int position);
    }

    public interface onDialogUtilsOkClick {
        void onOKClick();
    }

    public interface onDialogUtilsOkTestFilterClick {
        void onOKTestFilterClick(boolean one, boolean two, boolean three);
    }

    public interface onDialogUtilsRatingBarClick {
        void onRatingBarClick();
    }

    public interface onDialogUtilsSkipClick {
        void onSkipClick();
    }

    public static void makeDialog(Context context, String titleTxt, String messageTxt, String submitTxt, String cancelTxt, boolean isCancelable, final onDialogUtilsOkClick okClick, final onDialogUtilsCancelClick cancelClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            TextView textView2 = (TextView) dialog.findViewById(R.id.msgDialog);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(titleTxt);
                if (BuildConfig.FLAVOR.equalsIgnoreCase("SharmaClasses")) {
                    textView.setTextColor(context.getResources().getColor(R.color.whiteApp));
                }
            }
            textView2.setText(messageTxt);
            button.setText(cancelTxt);
            button2.setText(submitTxt);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsOkClick ondialogutilsokclick = okClick;
                    if (ondialogutilsokclick != null) {
                        ondialogutilsokclick.onOKClick();
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsCancelClick ondialogutilscancelclick = cancelClick;
                    if (ondialogutilscancelclick != null) {
                        ondialogutilscancelclick.onCancelClick();
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void makeDialog1(Context context, String titleTxt, String messageTxt, String submitTxt, String cancelTxt, boolean isCancelable, final onDialogUtilsOkClick okClick, final onDialogUtilsCancelClick cancelClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            TextView textView2 = (TextView) dialog.findViewById(R.id.msgDialog);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            button.setVisibility(8);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(titleTxt);
                if (BuildConfig.FLAVOR.equalsIgnoreCase("SharmaClasses")) {
                    textView.setTextColor(context.getResources().getColor(R.color.whiteApp));
                }
            }
            textView2.setText(messageTxt);
            button.setText(cancelTxt);
            button2.setText(submitTxt);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsOkClick ondialogutilsokclick = okClick;
                    if (ondialogutilsokclick != null) {
                        ondialogutilsokclick.onOKClick();
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsCancelClick ondialogutilscancelclick = cancelClick;
                    if (ondialogutilscancelclick != null) {
                        ondialogutilscancelclick.onCancelClick();
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void makeCompleteCPDialog(Context context, String titleTxt, String messageTxt, String submitTxt, String cancelTxt, boolean isCancelable, final onDialogUtilsOkClick okClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_change_password_cmplt);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            Button button = (Button) dialog.findViewById(R.id.btn_submit);
            button.setText(submitTxt);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsOkClick ondialogutilsokclick = okClick;
                    if (ondialogutilsokclick != null) {
                        ondialogutilsokclick.onOKClick();
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void makeRoundedCarDialog(Context context, String titleTxt, String messageTxt, String submitTxt, String cancelTxt, boolean isCancelable, final onDialogUtilsOkClick okClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_change_password_success);
            Button button = (Button) dialog.findViewById(R.id.btnSubmit);
            button.setText(submitTxt);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogUtils.lambda$makeRoundedCarDialog$0(dialog, okClick, view);
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void lambda$makeRoundedCarDialog$0(Dialog dialog, onDialogUtilsOkClick ondialogutilsokclick, View view) {
        try {
            dialog.dismiss();
        } catch (Exception unused) {
        }
        if (ondialogutilsokclick != null) {
            ondialogutilsokclick.onOKClick();
        }
    }

    public static void makeSingleButtonDialog(Activity context, String titleTxt, String messageTxt, String submitTxt, boolean isCancelable, final onDialogUtilsOkClick okClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_single_button);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            WebView webView = (WebView) dialog.findViewById(R.id.msgDialog);
            webView.setBackgroundColor(context.getResources().getColor(R.color.dot_white));
            Button button = (Button) dialog.findViewById(R.id.btn_submit);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(titleTxt);
            }
            Helper.showWebData(context, Helper.getHtmlUpdatedData(messageTxt), webView);
            button.setText(submitTxt);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsOkClick ondialogutilsokclick = okClick;
                    if (ondialogutilsokclick != null) {
                        ondialogutilsokclick.onOKClick();
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void makeEmiPaymentDialog(Context context, String title, String emptyMessage, final List<EMIInfo> list, final onDialogUtilsListItemClick itemClick, final onDialogUtilsCancelClick cancelClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setLayout(100, -2);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.playlist_utils_emi_dialog);
            ListView listView = (ListView) dialog.findViewById(R.id.list);
            CardView cardView = (CardView) dialog.findViewById(R.id.imageCloseIV);
            Button button = (Button) dialog.findViewById(R.id.continueBtn);
            button.setText(context.getResources().getString(R.string.pay_now));
            ((TextView) dialog.findViewById(R.id.title)).setText(title);
            if (list == null || list.size() == 0) {
                listView.setVisibility(8);
            } else {
                listView.setAdapter((ListAdapter) new EMIListAdapter(context, list));
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.Utils.DialogUtils.7
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                    onDialogUtilsListItemClick ondialogutilslistitemclick = itemClick;
                    if (ondialogutilslistitemclick != null) {
                        ondialogutilslistitemclick.onListItemClick(position);
                    }
                }
            });
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                    onDialogUtilsCancelClick ondialogutilscancelclick = cancelClick;
                    if (ondialogutilscancelclick != null) {
                        ondialogutilscancelclick.onCancelClick();
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void makeEmiListDialog(Context context, String title, String emptyMessage, final List<EMIInfo> list, final onDialogUtilsListItemClick itemClick, final onDialogUtilsCancelClick cancelClick) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setLayout(100, -2);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.playlist_utils_emi_dialog);
            ListView listView = (ListView) dialog.findViewById(R.id.list);
            CardView cardView = (CardView) dialog.findViewById(R.id.imageCloseIV);
            Button button = (Button) dialog.findViewById(R.id.continueBtn);
            TextView textView = (TextView) dialog.findViewById(R.id.title);
            TextView textView2 = (TextView) dialog.findViewById(R.id.totalPrice);
            textView.setText(title);
            Iterator<EMIInfo> it = list.iterator();
            float f2 = 0.0f;
            while (it.hasNext()) {
                f2 += Float.parseFloat(it.next().getEmiMrp());
            }
            textView2.setText(String.format("%s %s %s", context.getResources().getString(R.string.total_price), context.getResources().getString(R.string.rs), Float.valueOf(f2)));
            if (list == null || list.size() == 0) {
                listView.setVisibility(8);
            } else {
                listView.setAdapter((ListAdapter) new EMIListAdapter(context, list));
            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.Utils.DialogUtils.10
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                }
            });
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                    onDialogUtilsCancelClick ondialogutilscancelclick = cancelClick;
                    if (ondialogutilscancelclick != null) {
                        ondialogutilscancelclick.onCancelClick();
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void makeCallEmailDialog(final Context context, boolean isCancelable) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.fragment_contactus_bottom_sheet);
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.bottomSheetBtnCall);
            LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.bottomSheetBtnEmail);
            linearLayout.setOnClickListener(new AnonymousClass13(context, dialog));
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Helper.isNetworkConnected(context.getApplicationContext())) {
                        String string = SharedPreference.getInstance().getString("contactus_email");
                        if (string == null || TextUtils.isEmpty(string)) {
                            Toast.makeText(context, "Email ID not exist from backend", 0);
                        } else {
                            context.startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", string, null)), "Send email..."));
                        }
                    } else {
                        Context context2 = context;
                        Toast.makeText(context2, context2.getResources().getString(R.string.internet_connection_offline_text_short), 0).show();
                    }
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.DialogUtils$13, reason: invalid class name */
    class AnonymousClass13 implements View.OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass13(final Context val$context, final Dialog val$dialog) {
            this.val$context = val$context;
            this.val$dialog = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int i = Calendar.getInstance().get(11);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.val$context);
            if (i >= 8) {
                builder.setTitle(this.val$context.getResources().getString(R.string.customer_support_select_title));
                String string = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2);
                if (!GenericUtils.isEmpty(string) && !string.equalsIgnoreCase(BuildConfig.FAQ_URL)) {
                    final String[] strArr = new String[2];
                    String string2 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
                    if (string2 != null && !string2.equalsIgnoreCase("")) {
                        strArr[0] = string2;
                        strArr[1] = string;
                        final Context context = this.val$context;
                        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils$13$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                DialogUtils.AnonymousClass13.lambda$onClick$0(strArr, context, dialogInterface, i2);
                            }
                        });
                    } else {
                        Toast.makeText(this.val$context, "First Mobile Number not exist from backend", 0);
                    }
                } else {
                    final String[] strArr2 = new String[1];
                    String string3 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
                    if (string3 != null && !string3.equalsIgnoreCase("")) {
                        strArr2[0] = string3;
                        final Context context2 = this.val$context;
                        builder.setItems(strArr2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils$13$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                DialogUtils.AnonymousClass13.lambda$onClick$1(strArr2, context2, dialogInterface, i2);
                            }
                        });
                    } else {
                        Toast.makeText(this.val$context, "Mobile Number not exist from backend", 0);
                    }
                }
            } else {
                builder.setMessage(this.val$context.getResources().getString(R.string.customer_support_message));
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils$13$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
            }
            builder.create().show();
            this.val$dialog.dismiss();
        }

        static /* synthetic */ void lambda$onClick$0(String[] strArr, Context context, DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + strArr[i]));
            dialogInterface.dismiss();
            context.startActivity(intent);
        }

        static /* synthetic */ void lambda$onClick$1(String[] strArr, Context context, DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + strArr[i]));
            dialogInterface.dismiss();
            context.startActivity(intent);
        }
    }

    public static void verifyEmailDialog(Activity context, String titleTxt, String messageTxt, String submitTxt, boolean isCancelable, final onDialogUtilsOkClick okClick, final onDialogUtilsCancelClick oncancel) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.email_verify_dialog);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            WebView webView = (WebView) dialog.findViewById(R.id.msgDialog);
            webView.setBackgroundColor(context.getResources().getColor(R.color.dot_white));
            Button button = (Button) dialog.findViewById(R.id.btn_submit);
            Button button2 = (Button) dialog.findViewById(R.id.btn_cancel);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(titleTxt);
            }
            Helper.showWebData(context, Helper.getHtmlUpdatedData(messageTxt), webView);
            button.setText(submitTxt);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                    onDialogUtilsOkClick ondialogutilsokclick = okClick;
                    if (ondialogutilsokclick != null) {
                        ondialogutilsokclick.onOKClick();
                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.DialogUtils.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }
}
