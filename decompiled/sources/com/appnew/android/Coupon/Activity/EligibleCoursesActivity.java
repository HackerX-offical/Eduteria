package com.appnew.android.Coupon.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Coupon.Adapter.EligibleCoursesAdapter;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class EligibleCoursesActivity extends AppCompatActivity {
    List<CoursesCoupon> coursesCouponList;
    String discount;
    EligibleCoursesAdapter eligibleCoursesAdapter;
    RecyclerView eligible_recyclerView;
    String id;
    ImageView image_back;
    List<String> mycourseTables = new ArrayList();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_eligible_courses);
        String id = SharedPreference.getInstance().getLoggedInUser().getId();
        if (id != null && !id.equalsIgnoreCase("0") && !TextUtils.isEmpty(id)) {
            MakeMyExam.setUserId(id);
            MakeMyExam.userId = id;
            if (UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getMyCourseDao().isRecordExists(id)) {
                this.mycourseTables = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getMyCourseDao().getAllcourseid(id);
            }
        }
        getIntentData();
        initViews();
        setAdapterData();
    }

    private void setAdapterData() {
        List<String> list = this.mycourseTables;
        if (list != null && list.size() > 0) {
            for (CoursesCoupon coursesCoupon : this.coursesCouponList) {
                Iterator<String> it = this.mycourseTables.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equalsIgnoreCase(coursesCoupon.getId())) {
                            coursesCoupon.setIs_purchased("1");
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        EligibleCoursesAdapter eligibleCoursesAdapter = new EligibleCoursesAdapter(this, this.coursesCouponList, this.discount, this.id);
        this.eligibleCoursesAdapter = eligibleCoursesAdapter;
        this.eligible_recyclerView.setAdapter(eligibleCoursesAdapter);
        ImageView imageView = (ImageView) findViewById(R.id.image_back);
        this.image_back = imageView;
        imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Activity.EligibleCoursesActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setAdapterData$0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setAdapterData$0() {
        finish();
        return null;
    }

    private void getIntentData() {
        if (getIntent() == null || !getIntent().hasExtra(Const.ELIGIBLE_COURSES)) {
            return;
        }
        this.coursesCouponList = (List) getIntent().getSerializableExtra(Const.ELIGIBLE_COURSES);
        this.discount = getIntent().getStringExtra("discount");
        this.id = getIntent().getStringExtra("id");
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.eligible_recyclerView);
        this.eligible_recyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
