package com.appnew.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.DashboardTabIconAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GridSpacingItemDecoration;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.table.CourseTypeMasterTable;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class FreeMockTestActivity extends AppCompatActivity implements DashboardTabIconAdapter.addDashboardItemClicked, NetworkCall.MyNetworkCallBack {
    List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    DashboardTabIconAdapter dashboardTabAdapter;
    GridLayoutManager gridLayoutManager;
    ImageView image_back;
    RecyclerView tileRv;
    UtkashRoom utkashRoom;

    private void getCourseData(boolean showProgress) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(com.eduteria.app.app.R.layout.activity_free_mock_test);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        ImageView imageView = (ImageView) findViewById(com.eduteria.app.app.R.id.image_back);
        this.image_back = imageView;
        imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.FreeMockTestActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.tileRv = (RecyclerView) findViewById(com.eduteria.app.app.R.id.tileRv);
        if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
            this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
        }
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getName().equalsIgnoreCase("Free Mock Test")) {
                arrayList.add(courseTypeMasterTable);
            }
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.gridLayoutManager = gridLayoutManager;
        RecyclerView recyclerView = this.tileRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        this.tileRv.setNestedScrollingEnabled(false);
        this.tileRv.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
        DashboardTabIconAdapter dashboardTabIconAdapter = new DashboardTabIconAdapter(this, true, arrayList, this);
        this.dashboardTabAdapter = dashboardTabIconAdapter;
        this.tileRv.setAdapter(dashboardTabIconAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.appnew.android.Theme.Adapter.DashboardTabIconAdapter.addDashboardItemClicked
    public void onDashboardItemClicked(CourseTypeMasterTable courseTypeMasterTable, int position) {
        if (!courseTypeMasterTable.getCourse_id().equalsIgnoreCase("0")) {
            Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSE_ID_MAIN, courseTypeMasterTable.getCourse_id());
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            intent.putExtra(AnalyticsConstants.course_name, courseTypeMasterTable.getName());
            Helper.gotoActivity(intent, this);
            return;
        }
        Toast.makeText(this, "" + getResources().getString(com.eduteria.app.app.R.string.course_not_attached), 0).show();
    }
}
