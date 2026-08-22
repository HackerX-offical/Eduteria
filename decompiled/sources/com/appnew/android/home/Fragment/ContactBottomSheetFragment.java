package com.appnew.android.home.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class ContactBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    final String TAG = "ContactBottomSheet";
    private LinearLayout btnCall;
    private LinearLayout btnChat;
    private LinearLayout btnEmail;
    private Context sContext;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_contactus_bottom_sheet, container, false);
        init(viewInflate);
        return viewInflate;
    }

    private void init(View view) {
        this.sContext = getContext();
        this.btnCall = (LinearLayout) view.findViewById(R.id.bottomSheetBtnCall);
        this.btnEmail = (LinearLayout) view.findViewById(R.id.bottomSheetBtnEmail);
        this.btnChat = (LinearLayout) view.findViewById(R.id.bottomSheetBtnChat);
        this.btnCall.setOnClickListener(this);
        this.btnEmail.setOnClickListener(this);
        this.btnChat.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id != R.id.bottomSheetBtnCall) {
            if (id != R.id.bottomSheetBtnEmail) {
                return;
            }
            if (Helper.isNetworkConnected(getActivity())) {
                String string = SharedPreference.getInstance().getString("contactus_email");
                if (string == null || TextUtils.isEmpty(string)) {
                    Toast.makeText(this.sContext, "Email ID not exist from backend", 0);
                } else {
                    this.sContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", string, null)), "Send email..."));
                }
            } else {
                Context context = this.sContext;
                Toast.makeText(context, context.getResources().getString(R.string.internet_connection_offline_text_short), 0).show();
            }
            dismiss();
            return;
        }
        int i = Calendar.getInstance().get(11);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.sContext);
        if (i >= 6) {
            builder.setTitle(this.sContext.getResources().getString(R.string.customer_support_select_title));
            String string2 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2);
            if (!GenericUtils.isEmpty(string2) && !string2.equalsIgnoreCase("")) {
                final String[] strArr = new String[2];
                String string3 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
                if (string3 != null && !string3.equalsIgnoreCase("")) {
                    strArr[0] = string3;
                    strArr[1] = string2;
                    builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.Fragment.ContactBottomSheetFragment$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onClick$0(strArr, dialogInterface, i2);
                        }
                    });
                } else {
                    Toast.makeText(this.sContext, "First Mobile Number not exist from backend", 0);
                }
            } else {
                final String[] strArr2 = new String[1];
                String string4 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
                if (string4 != null && !string4.equalsIgnoreCase("")) {
                    strArr2[0] = string4;
                    builder.setItems(strArr2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.Fragment.ContactBottomSheetFragment$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onClick$1(strArr2, dialogInterface, i2);
                        }
                    });
                } else {
                    Toast.makeText(this.sContext, "Mobile Number not exist from backend", 0);
                }
            }
        } else {
            builder.setMessage(this.sContext.getResources().getString(R.string.customer_support_message));
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.Fragment.ContactBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.create().show();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$0(String[] strArr, DialogInterface dialogInterface, int i) {
        String str = strArr[i];
        if ("1".equalsIgnoreCase("7") && str.split(" ").length > 0) {
            str = str.split(" ")[0];
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        dialogInterface.dismiss();
        this.sContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$1(String[] strArr, DialogInterface dialogInterface, int i) {
        String str = strArr[i];
        if ("1".equalsIgnoreCase("7") && str.split(" ").length > 0) {
            str = str.split(" ")[0];
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        dialogInterface.dismiss();
        this.sContext.startActivity(intent);
    }

    private boolean isAppInstalledOrNot(String uri) {
        try {
            this.sContext.getPackageManager().getPackageInfo(uri, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
