package com.appnew.android.TeacherTimeTable.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Noticeboard.NoticeBoardModel;
import com.appnew.android.TeacherTimeTable.Adapter.NoticeboardAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityNoticeboardBinding;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: Noticeboard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J.\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J.\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0019"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Activity/Noticeboard;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "setNoticeBoardAdapter", "noticeBoardModel", "Lcom/appnew/android/Model/Noticeboard/NoticeBoardModel;", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Noticeboard extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NoticeboardKt.binding = ActivityNoticeboardBinding.inflate(getLayoutInflater());
        ActivityNoticeboardBinding activityNoticeboardBinding = NoticeboardKt.binding;
        ActivityNoticeboardBinding activityNoticeboardBinding2 = null;
        if (activityNoticeboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNoticeboardBinding = null;
        }
        setContentView(activityNoticeboardBinding.getRoot());
        if (Build.VERSION.SDK_INT == 36) {
            Noticeboard noticeboard = this;
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            ActivityNoticeboardBinding activityNoticeboardBinding3 = NoticeboardKt.binding;
            if (activityNoticeboardBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityNoticeboardBinding3 = null;
            }
            LinearLayout root = activityNoticeboardBinding3.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            LinearLayout linearLayout = root;
            ActivityNoticeboardBinding activityNoticeboardBinding4 = NoticeboardKt.binding;
            if (activityNoticeboardBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityNoticeboardBinding4 = null;
            }
            Toolbar mainToolbar = activityNoticeboardBinding4.mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(noticeboard, window, linearLayout, mainToolbar);
        }
        ActivityNoticeboardBinding activityNoticeboardBinding5 = NoticeboardKt.binding;
        if (activityNoticeboardBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityNoticeboardBinding2 = activityNoticeboardBinding5;
        }
        activityNoticeboardBinding2.noticeboardBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TeacherTimeTable.Activity.Noticeboard$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.finish();
            }
        });
        Noticeboard noticeboard2 = this;
        NoticeboardKt.setNetworkCall(new NetworkCall(this, noticeboard2));
        if (getIntent() != null) {
            NoticeboardKt.id = getIntent().getStringExtra("id");
            Helper.showProgressDialog(noticeboard2);
            NetworkCall networkCall = NoticeboardKt.getNetworkCall();
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.API_NOTICE_BOARD, "", true, false);
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_NOTICE_BOARD)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setPage("1");
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            if (service != null) {
                return service.getNoticeboardData(strEncrypt);
            }
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        if (Intrinsics.areEqual(apitype, API.API_NOTICE_BOARD)) {
            try {
                Helper.dismissProgressDialog();
                if (StringsKt.equals$default(jsonstring != null ? jsonstring.getString("status") : null, "true", false, 2, null)) {
                    Object objFromJson = new Gson().fromJson(String.valueOf(jsonstring), (Class<Object>) NoticeBoardModel.class);
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    setNoticeBoardAdapter((NoticeBoardModel) objFromJson);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final void setNoticeBoardAdapter(NoticeBoardModel noticeBoardModel) {
        Noticeboard noticeboard = this;
        NoticeboardAdapter noticeboardAdapter = new NoticeboardAdapter(noticeBoardModel.getData(), noticeboard);
        ActivityNoticeboardBinding activityNoticeboardBinding = NoticeboardKt.binding;
        ActivityNoticeboardBinding activityNoticeboardBinding2 = null;
        if (activityNoticeboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNoticeboardBinding = null;
        }
        activityNoticeboardBinding.noticeboardList.setLayoutManager(new LinearLayoutManager(noticeboard));
        ActivityNoticeboardBinding activityNoticeboardBinding3 = NoticeboardKt.binding;
        if (activityNoticeboardBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNoticeboardBinding3 = null;
        }
        activityNoticeboardBinding3.noticeboardList.setAdapter(noticeboardAdapter);
        ActivityNoticeboardBinding activityNoticeboardBinding4 = NoticeboardKt.binding;
        if (activityNoticeboardBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityNoticeboardBinding2 = activityNoticeboardBinding4;
        }
        activityNoticeboardBinding2.noticeboardList.setNestedScrollingEnabled(false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
