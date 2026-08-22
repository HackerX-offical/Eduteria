package com.appnew.android.UserHistory;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ContactUsLayoutBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.pojo.Userinfo.Data;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ContactUsPage extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity;
    ContactUsLayoutBinding binding;
    Toolbar main_toolbar;
    private NetworkCall networkCall;
    private String course_id = "";
    String selectedType = "";
    private String clicktype1 = "";
    List<String> preferences = new ArrayList();
    List<String> preferences1 = new ArrayList();
    List<String> preferencesFoundation = new ArrayList();
    List<String> preferencesJEE = new ArrayList();
    List<String> preferencesNEET = new ArrayList();

    private void setFilters() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Data loggedInUser;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setPreferenceData();
        ContactUsLayoutBinding contactUsLayoutBindingInflate = ContactUsLayoutBinding.inflate(getLayoutInflater());
        this.binding = contactUsLayoutBindingInflate;
        setContentView(contactUsLayoutBindingInflate.getRoot());
        this.activity = this;
        this.networkCall = new NetworkCall(this, this);
        this.binding.issue.setOnClickListener(this);
        setFilters();
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), this.binding.getRoot(), this.binding.mainToolbar);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            this.binding.classStreamLL.setVisibility(0);
            this.binding.viewConversation.setVisibility(8);
        }
        this.binding.selectStream.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContactUsPage.this.selectStream();
            }
        });
        this.binding.selectClass.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Helper.isStringValid(ContactUsPage.this.binding.selectStream.getText().toString().trim())) {
                    ContactUsPage.this.selectClass();
                } else {
                    Toast.makeText(ContactUsPage.this.activity, ContactUsPage.this.getResources().getString(R.string.please_enter_stream), 0).show();
                    ContactUsPage.this.binding.message.requestFocus();
                }
            }
        });
        if (getIntent() != null && getIntent().hasExtra("from") && getIntent().getStringExtra("from").equalsIgnoreCase(Constants.LEFT_NAV_KEY.contact_us_query)) {
            this.binding.toolbarTitleTV.setText("Inquiry");
        } else {
            this.binding.toolbarTitleTV.setText(getResources().getString(R.string.contact_us));
        }
        this.binding.submitBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.viewConversation.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        if (BuildConfig.FLAVOR.equalsIgnoreCase("tradeWithHiren")) {
            this.binding.toolbarTitleTV.setText(R.string.contact_us);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana") && (loggedInUser = SharedPreference.getInstance().getLoggedInUser()) != null && loggedInUser.getMobile() != null && !TextUtils.isEmpty(loggedInUser.getMobile())) {
            this.binding.name.setEnabled(false);
            this.binding.email.setEnabled(false);
            this.binding.mobile.setEnabled(false);
            this.binding.name.setText(loggedInUser.getName());
            this.binding.email.setText(loggedInUser.getEmail());
            this.binding.mobile.setText(loggedInUser.getMobile());
        }
        this.binding.imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (Helper.isNetworkConnected(this.activity)) {
            getData();
        } else {
            Helper.showInternetToast(this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (Helper.isNetworkConnected(this.activity)) {
            startActivity(new Intent(getApplicationContext(), (Class<?>) ViewConversationPage.class));
        } else {
            Helper.showInternetToast(this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        getOnBackPressedDispatcher().onBackPressed();
    }

    private void setPreferenceData() {
        this.preferencesFoundation.add("Presently Studying in 7 (Moving to 8)");
        this.preferencesFoundation.add("Presently Studying in 8 (Moving to 9)");
        this.preferencesFoundation.add("Presently Studying in 9 (Moving to 10)");
        this.preferencesJEE.add("Presently Studying in 10 (Moving to 11)");
        this.preferencesJEE.add("Presently Studying in 11 (Moving to 12)");
        this.preferencesJEE.add("12 Appearing/Passed");
        this.preferencesNEET.add("Presently Studying in 10 (Moving to 11)");
        this.preferencesNEET.add("Presently Studying in 11 (Moving to 12)");
    }

    private void getData() {
        if (Helper.isStringValid(this.binding.name.getText().toString().trim())) {
            if (Helper.isStringValid(this.binding.mobile.getText().toString().trim())) {
                if (Helper.checkMobileNumber(this.binding.mobile.getText().toString().trim())) {
                    if (Helper.isStringValid(this.binding.email.getText().toString().trim())) {
                        if (Patterns.EMAIL_ADDRESS.matcher(this.binding.email.getText().toString().trim()).matches()) {
                            if (this.selectedType.equalsIgnoreCase("")) {
                                Helper.showToast(this.activity, getResources().getString(R.string.please_select_atleast_one_issue), 1);
                                return;
                            }
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                                if (Helper.isStringValid(this.binding.selectStream.getText().toString().trim())) {
                                    if (Helper.isStringValid(this.binding.selectClass.getText().toString().trim())) {
                                        if (Helper.isStringValid(this.binding.message.getText().toString().trim())) {
                                            hitapiforsavecontactus();
                                            return;
                                        } else {
                                            Toast.makeText(this.activity, getResources().getString(R.string.please_enter_message), 0).show();
                                            this.binding.message.requestFocus();
                                            return;
                                        }
                                    }
                                    Toast.makeText(this.activity, getResources().getString(R.string.please_enter_Class), 0).show();
                                    this.binding.selectClass.requestFocus();
                                    return;
                                }
                                Toast.makeText(this.activity, getResources().getString(R.string.please_enter_stream), 0).show();
                                this.binding.selectStream.requestFocus();
                                return;
                            }
                            if (Helper.isStringValid(this.binding.message.getText().toString().trim())) {
                                hitapiforsavecontactus();
                                return;
                            } else {
                                Toast.makeText(this.activity, getResources().getString(R.string.please_enter_message), 0).show();
                                this.binding.message.requestFocus();
                                return;
                            }
                        }
                        Toast.makeText(this.activity, getResources().getString(R.string.please_enter_your_valid_email), 0).show();
                        this.binding.email.requestFocus();
                        return;
                    }
                    Toast.makeText(this.activity, getResources().getString(R.string.please_enter_your_valid_email), 0).show();
                    this.binding.email.requestFocus();
                    return;
                }
                Toast.makeText(this.activity, getResources().getString(R.string.please_enter_valid_mobile_number), 0).show();
                this.binding.mobile.requestFocus();
                return;
            }
            Toast.makeText(this.activity, getResources().getString(R.string.please_enter_valid_mobile_number), 0).show();
            this.binding.mobile.requestFocus();
            return;
        }
        Toast.makeText(this.activity, getResources().getString(R.string.please_enter_name), 0).show();
        this.binding.name.requestFocus();
    }

    private void hitapiforsavecontactus() {
        this.networkCall.NetworkAPICall(API.CONTACT_US_URL, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.CONTACT_US_URL)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setName(this.binding.name.getText().toString());
        encryptionData.setMobile(this.binding.mobile.getText().toString());
        encryptionData.setEmail(this.binding.email.getText().toString());
        encryptionData.setCourse_id(this.course_id);
        encryptionData.setMessage(this.binding.message.getText().toString());
        encryptionData.setStream(this.binding.selectStream.getText().toString());
        encryptionData.setNew_class(this.binding.selectClass.getText().toString());
        encryptionData.setPage("0");
        encryptionData.setAppId("166");
        encryptionData.setType(this.selectedType);
        return service.doContactUsQuery(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (!apitype.equals(API.CONTACT_US_URL)) {
            if (apitype.equals(API.API_CONTACT_US)) {
                try {
                    if (jsonstring.optString("status").equals("true")) {
                        return;
                    }
                    Toast.makeText(this, jsonstring.getString("message").toString(), 0).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            if (jsonstring.optString("status").equals("true")) {
                if (!BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                    this.binding.name.setText("");
                    this.binding.mobile.setText("");
                    this.binding.email.setText("");
                }
                this.binding.issue.setText(getResources().getString(R.string.please_select_one));
                this.binding.message.setText("");
                this.binding.selectStream.setText("");
                this.binding.selectClass.setText("");
                this.binding.message.clearFocus();
                Toast.makeText(this.activity, "" + jsonstring.getString("data"), 0).show();
                return;
            }
            ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
            RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        apitype.hashCode();
        if (apitype.equals(API.CONTACT_US_URL)) {
            Toast.makeText(this.activity, jsonstring, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != R.id.issue) {
            return;
        }
        selectIssue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectStream() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.selectStream, 3);
        this.preferences.clear();
        this.preferences.add("Foundation");
        this.preferences.add("JEE (Main + Advanced)");
        this.preferences.add("NEET");
        Iterator<String> it = this.preferences.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "1";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    public void selectIssue() {
        this.binding.issue.setOnClickListener(null);
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.issue_dialog);
        dialog.setCancelable(true);
        dialog.show();
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.id_ll_feilds);
        final TextView textView = (TextView) dialog.findViewById(R.id.issue1);
        final TextView textView2 = (TextView) dialog.findViewById(R.id.issue2);
        final TextView textView3 = (TextView) dialog.findViewById(R.id.issue3);
        final TextView textView4 = (TextView) dialog.findViewById(R.id.issue4);
        final TextView textView5 = (TextView) dialog.findViewById(R.id.issue5);
        final TextView textView6 = (TextView) dialog.findViewById(R.id.issue6);
        final TextView textView7 = (TextView) dialog.findViewById(R.id.issue7);
        final TextView textView8 = (TextView) dialog.findViewById(R.id.issue8);
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$3(textView, dialog, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$4(textView2, dialog, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$5(textView3, dialog, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$6(textView4, dialog, view);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$7(textView5, dialog, view);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$8(textView6, dialog, view);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$9(textView7, dialog, view);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectIssue$10(textView8, dialog, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$selectIssue$11(dialogInterface);
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.UserHistory.ContactUsPage$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$selectIssue$12(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$3(TextView textView, Dialog dialog, View view) {
        this.selectedType = "0";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$4(TextView textView, Dialog dialog, View view) {
        this.selectedType = "1";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$5(TextView textView, Dialog dialog, View view) {
        this.selectedType = "2";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$6(TextView textView, Dialog dialog, View view) {
        this.selectedType = "3";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$7(TextView textView, Dialog dialog, View view) {
        this.selectedType = "4";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$8(TextView textView, Dialog dialog, View view) {
        this.selectedType = "5";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$9(TextView textView, Dialog dialog, View view) {
        this.selectedType = "6";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$10(TextView textView, Dialog dialog, View view) {
        this.selectedType = "7";
        this.binding.issue.setText(textView.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$11(DialogInterface dialogInterface) {
        this.binding.issue.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectIssue$12(DialogInterface dialogInterface) {
        this.binding.issue.setOnClickListener(this);
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.clicktype1.equalsIgnoreCase("1")) {
            for (String str : this.preferences) {
                if (str.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.selectStream.setText(str);
                    this.binding.selectClass.setText("");
                }
            }
        }
        if (!this.clicktype1.equalsIgnoreCase("2")) {
            return false;
        }
        this.binding.selectClass.setText(menuItem.getTitle().toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectClass() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.selectClass, 3);
        if (this.binding.selectStream.getText().toString().equals("Foundation")) {
            Iterator<String> it = this.preferencesFoundation.iterator();
            while (it.hasNext()) {
                popupMenu.getMenu().add(it.next());
            }
        } else if (this.binding.selectStream.getText().toString().equals("JEE (Main + Advanced)")) {
            Iterator<String> it2 = this.preferencesJEE.iterator();
            while (it2.hasNext()) {
                popupMenu.getMenu().add(it2.next());
            }
        } else if (this.binding.selectStream.getText().toString().equals("NEET")) {
            Iterator<String> it3 = this.preferencesNEET.iterator();
            while (it3.hasNext()) {
                popupMenu.getMenu().add(it3.next());
            }
        }
        this.clicktype1 = "2";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }
}
