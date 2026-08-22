package com.razorpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: OpinionatedSoln.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0004H\u0002J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u000ej\b\u0012\u0004\u0012\u00020\u0011`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u000ej\b\u0012\u0004\u0012\u00020\u0011`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/razorpay/OpinionatedSoln;", "", "()V", "alertShownForStatus", "", "getAlertShownForStatus", "()Z", "setAlertShownForStatus", "(Z)V", "callbackSent", "checkedForSubMinorVersion", "getCheckedForSubMinorVersion", "setCheckedForSubMinorVersion", "dialogItemStatus", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dialogItemSubTitles", "", "dialogItemTitles", "dismissCallback", "Lcom/razorpay/OpinionatedSoln$DismissCallback;", "checkEnvVariablesForProject", "", "activity", "Landroid/app/Activity;", "checkIfVersionUpdateExists", "version", "getBuildConfigValue", "context", "Landroid/content/Context;", "fieldName", "getUpdatedVersionNumber", "isMinor", "integrationStatusCheck", "sendCallbackIfExists", "showDialog", "DismissCallback", "HandleDialogShowPreference", "MyListAdapter", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OpinionatedSoln {
    private static boolean alertShownForStatus;
    private static boolean callbackSent;
    private static boolean checkedForSubMinorVersion;
    private static DismissCallback dismissCallback;
    public static final OpinionatedSoln INSTANCE = new OpinionatedSoln();
    private static final ArrayList<String> dialogItemTitles = new ArrayList<>();
    private static final ArrayList<String> dialogItemSubTitles = new ArrayList<>();
    private static final ArrayList<Boolean> dialogItemStatus = new ArrayList<>();

    /* JADX INFO: compiled from: OpinionatedSoln.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/razorpay/OpinionatedSoln$DismissCallback;", "", "alertDismissed", "", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DismissCallback {
        void alertDismissed();
    }

    /* JADX INFO: compiled from: OpinionatedSoln.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/razorpay/OpinionatedSoln$HandleDialogShowPreference;", "", "errorFound", "", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface HandleDialogShowPreference {
        void errorFound();
    }

    private OpinionatedSoln() {
    }

    public final boolean getAlertShownForStatus() {
        return alertShownForStatus;
    }

    public final void setAlertShownForStatus(boolean z) {
        alertShownForStatus = z;
    }

    public final boolean getCheckedForSubMinorVersion() {
        return checkedForSubMinorVersion;
    }

    public final void setCheckedForSubMinorVersion(boolean z) {
        checkedForSubMinorVersion = z;
    }

    public final void integrationStatusCheck(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        checkIfVersionUpdateExists(activity, getUpdatedVersionNumber(true));
    }

    public final void integrationStatusCheck(Activity activity, DismissCallback dismissCallback2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dismissCallback2, "dismissCallback");
        Activity activity2 = activity;
        ConfigCheckout.ensureInitialized(activity2);
        CheckoutUtils.showLoader(activity2);
        callbackSent = false;
        dismissCallback = dismissCallback2;
        checkIfVersionUpdateExists(activity, getUpdatedVersionNumber(true));
    }

    private final void checkEnvVariablesForProject(Activity activity) {
        dialogItemTitles.add("Min SDK Version Check");
        dialogItemSubTitles.add("Min SDK Version Compatible");
        dialogItemStatus.add(Boolean.TRUE);
        showDialog(activity);
    }

    private final String getUpdatedVersionNumber(boolean isMinor) {
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) BuildConfig.VERSION_NAME, new String[]{"-"}, false, 0, 6, (Object) null).get(0), new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
        String str = (String) listSplit$default.get(0);
        String str2 = (String) listSplit$default.get(1);
        String str3 = (String) listSplit$default.get(2);
        if (isMinor) {
            return str + '.' + (Integer.parseInt(str2) + 1) + ".0";
        }
        return str + '.' + str2 + '.' + (Integer.parseInt(str3) + 1);
    }

    private final void checkIfVersionUpdateExists(final Activity activity, String version) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Owl.get("https://mvnrepository.com/artifact/com.razorpay/checkout/" + version, new Callback() { // from class: com.razorpay.OpinionatedSoln$$ExternalSyntheticLambda3
            @Override // com.razorpay.Callback
            public final void run(ResponseObject responseObject) {
                OpinionatedSoln.m12329checkIfVersionUpdateExists$lambda0(booleanRef, activity, responseObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: checkIfVersionUpdateExists$lambda-0, reason: not valid java name */
    public static final void m12329checkIfVersionUpdateExists$lambda0(Ref.BooleanRef versionUpdateExists, Activity activity, ResponseObject responseObject) {
        Intrinsics.checkNotNullParameter(versionUpdateExists, "$versionUpdateExists");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (responseObject != null && responseObject.getResponseCode() == 200) {
            versionUpdateExists.element = true;
            dialogItemTitles.add("Version Upgrade Check");
            dialogItemSubTitles.add("A version update was found. Click here to go to docs");
            dialogItemStatus.add(Boolean.FALSE);
            INSTANCE.checkEnvVariablesForProject(activity);
            return;
        }
        if (!checkedForSubMinorVersion) {
            checkedForSubMinorVersion = true;
            OpinionatedSoln opinionatedSoln = INSTANCE;
            opinionatedSoln.checkIfVersionUpdateExists(activity, opinionatedSoln.getUpdatedVersionNumber(false));
        } else {
            versionUpdateExists.element = false;
            dialogItemTitles.add("Version Upgrade Check");
            dialogItemSubTitles.add("Running the latest version");
            dialogItemStatus.add(Boolean.TRUE);
            INSTANCE.checkEnvVariablesForProject(activity);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.razorpay.OpinionatedSoln$showDialog$4] */
    public final void showDialog(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        Object buildConfigValue = getBuildConfigValue(activity2, "DEBUG");
        if (buildConfigValue != null) {
            if (((Boolean) buildConfigValue).booleanValue() && !alertShownForStatus) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
                View viewInflate = activity.getLayoutInflater().inflate(R.layout.sdk_integration_status, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(viewInflate, "activity.layoutInflater.…integration_status, null)");
                ListView listView = (ListView) viewInflate.findViewById(R.id.check_list);
                ArrayList<String> arrayList = dialogItemTitles;
                ArrayList<String> arrayList2 = dialogItemSubTitles;
                ArrayList<Boolean> arrayList3 = dialogItemStatus;
                listView.setAdapter((ListAdapter) new MyListAdapter(activity, arrayList, arrayList2, arrayList3));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.razorpay.OpinionatedSoln$$ExternalSyntheticLambda0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        OpinionatedSoln.m12330showDialog$lambda1(activity, adapterView, view, i, j);
                    }
                });
                builder.setView(viewInflate);
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.razorpay.OpinionatedSoln$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        OpinionatedSoln.m12331showDialog$lambda2(dialogInterface);
                    }
                });
                Iterator<Boolean> it = arrayList3.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    if (!it.next().booleanValue()) {
                        z = false;
                    }
                }
                if (z) {
                    builder.setNegativeButton("Hide notification forever", new DialogInterface.OnClickListener() { // from class: com.razorpay.OpinionatedSoln$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            OpinionatedSoln.m12332showDialog$lambda3(activity, dialogInterface, i);
                        }
                    });
                }
                Boolean opinionatedSolnPreference = BaseConfig.getOpinionatedSolnPreference(activity2);
                Intrinsics.checkNotNullExpressionValue(opinionatedSolnPreference, "getOpinionatedSolnPreference(activity)");
                if (opinionatedSolnPreference.booleanValue() || !z) {
                    if (!z) {
                        BaseConfig.setOpinionatedSolnPreference(activity2, Boolean.TRUE);
                    }
                    final AlertDialog alertDialogShow = builder.show();
                    alertShownForStatus = true;
                    new CountDownTimer() { // from class: com.razorpay.OpinionatedSoln.showDialog.4
                        @Override // android.os.CountDownTimer
                        public final void onTick(long millisUntilFinished) {
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(5000L, 1000L);
                        }

                        @Override // android.os.CountDownTimer
                        public final void onFinish() {
                            alertDialogShow.dismiss();
                            OpinionatedSoln.INSTANCE.sendCallbackIfExists();
                        }
                    }.start();
                    CheckoutUtils.dismissLoader();
                    return;
                }
                HashMap map = new HashMap();
                String str = "";
                for (String item : dialogItemTitles) {
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    ArrayList<String> arrayList4 = dialogItemSubTitles;
                    ArrayList<String> arrayList5 = dialogItemTitles;
                    String str2 = arrayList4.get(arrayList5.indexOf(item));
                    Intrinsics.checkNotNullExpressionValue(str2, "dialogItemSubTitles[dial…ItemTitles.indexOf(item)]");
                    map.put(item, str2);
                    if (!dialogItemStatus.get(arrayList5.indexOf(item)).booleanValue()) {
                        str = "https://razorpay.com/docs/payments/payment-gateway/android-integration/standard";
                    }
                }
                Logger.w("RAZORPAY_SDK: " + map + '\n' + str);
                sendCallbackIfExists();
                CheckoutUtils.dismissLoader();
                return;
            }
            CheckoutUtils.dismissLoader();
            sendCallbackIfExists();
            return;
        }
        CheckoutUtils.dismissLoader();
        sendCallbackIfExists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showDialog$lambda-1, reason: not valid java name */
    public static final void m12330showDialog$lambda1(Activity activity, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (i == 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://razorpay.com/docs/payments/payment-gateway/android-integration/standard/#list-of-razorpay-android-standard-sdk-versions-last"));
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showDialog$lambda-2, reason: not valid java name */
    public static final void m12331showDialog$lambda2(DialogInterface dialogInterface) {
        INSTANCE.sendCallbackIfExists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showDialog$lambda-3, reason: not valid java name */
    public static final void m12332showDialog$lambda3(Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Activity activity2 = activity;
        BaseConfig.setOpinionatedSolnPreference(activity2, Boolean.FALSE);
        Toast.makeText(activity2, "Status will be shown in logs. RAZORPAY_SDK", 1).show();
        INSTANCE.sendCallbackIfExists();
    }

    public final void sendCallbackIfExists() {
        DismissCallback dismissCallback2 = dismissCallback;
        if (dismissCallback2 == null || callbackSent) {
            return;
        }
        if (dismissCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dismissCallback");
            dismissCallback2 = null;
        }
        dismissCallback2.alertDismissed();
        callbackSent = true;
    }

    public final Object getBuildConfigValue(Context context, String fieldName) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Field field = fieldName != null ? Class.forName(context.getPackageName() + ".BuildConfig").getField(fieldName) : null;
            if (field != null) {
                return field.get(null);
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
        }
        return null;
    }

    /* JADX INFO: compiled from: OpinionatedSoln.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/razorpay/OpinionatedSoln$MyListAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/app/Activity;", "itemTitles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "itemDescs", "status", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getCount", "", "getView", "Landroid/view/View;", Const.POSITION, ViewHierarchyConstants.VIEW_KEY, Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MyListAdapter extends ArrayAdapter<String> {
        private final Activity context;
        private final ArrayList<String> itemDescs;
        private final ArrayList<String> itemTitles;
        private final ArrayList<Boolean> status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyListAdapter(Activity context, ArrayList<String> itemTitles, ArrayList<String> itemDescs, ArrayList<Boolean> status) {
            super(context, R.layout.single_item);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemTitles, "itemTitles");
            Intrinsics.checkNotNullParameter(itemDescs, "itemDescs");
            Intrinsics.checkNotNullParameter(status, "status");
            this.context = context;
            this.itemTitles = itemTitles;
            this.itemDescs = itemDescs;
            this.status = status;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final int getCount() {
            return this.itemTitles.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int position, View view, ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LayoutInflater layoutInflater = this.context.getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "context.layoutInflater");
            View rowView = layoutInflater.inflate(R.layout.single_item, (ViewGroup) null, true);
            View viewFindViewById = rowView.findViewById(R.id.tv_title);
            if (viewFindViewById == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) viewFindViewById;
            View viewFindViewById2 = rowView.findViewById(R.id.iv_check_mark);
            if (viewFindViewById2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            ImageView imageView = (ImageView) viewFindViewById2;
            View viewFindViewById3 = rowView.findViewById(R.id.tv_sub_item);
            if (viewFindViewById3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView2 = (TextView) viewFindViewById3;
            textView.setText(this.itemTitles.get(position));
            Boolean bool = this.status.get(position);
            Intrinsics.checkNotNullExpressionValue(bool, "status[position]");
            if (bool.booleanValue()) {
                imageView.setImageResource(R.drawable.ic_tick_mark);
            } else {
                imageView.setImageResource(R.drawable.ic_alert);
            }
            textView2.setText(this.itemDescs.get(position));
            Intrinsics.checkNotNullExpressionValue(rowView, "rowView");
            return rowView;
        }
    }
}
