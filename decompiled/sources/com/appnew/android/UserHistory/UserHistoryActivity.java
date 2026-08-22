package com.appnew.android.UserHistory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.UserHistroyTable;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class UserHistoryActivity extends AppCompatActivity {
    Button backBtn;
    RecyclerView download_recycler;
    private HistoryAdapter historyAdapter;
    private List<UserHistroyTable> histroyTableArrayList = new ArrayList();
    private ImageView image_back;
    RelativeLayout no_data_found_RL;
    private UtkashRoom utkashRoom;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_user_histroy);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
            this.download_recycler = (RecyclerView) findViewById(R.id.download_recycler);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            ImageView imageView = (ImageView) findViewById(R.id.image_back);
            this.image_back = imageView;
            imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.UserHistory.UserHistoryActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.UserHistory.UserHistoryActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$1();
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        onBackPressed();
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getBoolean("sign_url")) {
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.UserHistory.UserHistoryActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$3();
                }
            });
            return;
        }
        SharedPreference.getInstance().putBoolean("sign_url", true);
        this.utkashRoom.getuserhistorydao().delete();
        if (this.histroyTableArrayList.size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.download_recycler.setVisibility(0);
            HistoryAdapter historyAdapter = new HistoryAdapter(this, this.histroyTableArrayList, this.utkashRoom);
            this.historyAdapter = historyAdapter;
            this.download_recycler.setAdapter(historyAdapter);
            return;
        }
        this.no_data_found_RL.setVisibility(0);
        this.download_recycler.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$3() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.utkashRoom.getuserhistorydao().delete();
                this.histroyTableArrayList = this.utkashRoom.getuserhistorydao().getallhistory(MakeMyExam.userId);
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.UserHistory.UserHistoryActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$2();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$2() {
        if (this.historyAdapter != null && this.histroyTableArrayList.size() > 0) {
            this.historyAdapter.chnagelist(this.histroyTableArrayList);
            return;
        }
        if (this.histroyTableArrayList.size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.download_recycler.setVisibility(0);
            HistoryAdapter historyAdapter = new HistoryAdapter(this, this.histroyTableArrayList, this.utkashRoom);
            this.historyAdapter = historyAdapter;
            this.download_recycler.setAdapter(historyAdapter);
            return;
        }
        this.no_data_found_RL.setVisibility(0);
        this.download_recycler.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.utkashRoom = null;
    }
}
