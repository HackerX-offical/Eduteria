package com.appnew.android.LiveClass.Activity;

import android.content.Context;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.Fragment.Completed;
import com.appnew.android.LiveClass.Fragment.LiveClasses;
import com.appnew.android.LiveClass.Fragment.Upcoming;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.Liveawsactivity;
import com.appnew.android.player.VODPlayerActivity;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class LiveClassActivity extends AppCompatActivity implements OnDataSendListener, NetworkCall.MyNetworkCallBack {
    private static ViewPager view_pager;
    private Context activity;
    private LiveViewPagerAdapter adapter;
    ChildEventListener childEventListenercompleteclass;
    private Completed completedFragment;
    DatabaseReference databaseReference;
    ImageView image_back;
    private LiveClasses liveclassesFragment;
    public UtkashRoom myDBClass;
    NetworkCall networkCall;
    private TabLayout tabLayout;
    private Upcoming upcomingFragment;
    private String rating = "";
    private String courseId = "";
    private String ratingMessage = "";
    private int rating_type = 0;
    private String live_class_feedback = "";
    private String live_test_feedback = "";
    final Utils.FeedbackBottomSheetDialog[] feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    private boolean isBottomSheetOpen = false;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_live_class);
        this.activity = this;
        this.networkCall = new NetworkCall(this, this);
        getFirebaseData();
        this.live_class_feedback = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
        initListeners();
        this.tabLayout = (TabLayout) findViewById(R.id.tabs);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.LiveClass.Activity.LiveClassActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
            }
        });
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.LiveClass.Activity.LiveClassActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.LiveClass.Activity.LiveClassActivity.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        setupViewPager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    private void getFirebaseData() {
        try {
            this.databaseReference = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/live_class_status/");
            ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.LiveClass.Activity.LiveClassActivity.3
                @Override // com.google.firebase.database.ChildEventListener
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    if (LiveClassActivity.this.upcomingFragment != null) {
                        try {
                            String string = new JSONObject(String.valueOf(dataSnapshot.getValue())).getString("is_live");
                            if (string.equalsIgnoreCase("1")) {
                                LiveClassActivity.this.upcomingFragment.checkVideoId(dataSnapshot.getKey(), LiveClassActivity.this.liveclassesFragment);
                            }
                            if (string.equalsIgnoreCase("2")) {
                                LiveClassActivity.this.liveclassesFragment.checkVideoId(((String) Objects.requireNonNull(dataSnapshot.getKey())).replace("_complete", ""), LiveClassActivity.this.completedFragment);
                            }
                        } catch (JSONException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("Firebase", "Error: " + databaseError.getMessage());
                }
            };
            this.childEventListenercompleteclass = childEventListener;
            DatabaseReference databaseReference = this.databaseReference;
            if (databaseReference != null) {
                databaseReference.addChildEventListener(childEventListener);
                this.databaseReference.keepSynced(true);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.LiveClass.interface_.OnDataSendListener
    public void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int testOrVideo) {
        Log.e("TAG_APP", "onDataSent: " + isLive + " particularId " + particularId + "ratingType " + testOrVideo);
        this.courseId = particularId;
        this.rating_type = testOrVideo;
        if ((TextUtils.isEmpty(this.live_class_feedback) || !this.live_class_feedback.equalsIgnoreCase("1")) && (TextUtils.isEmpty(this.live_test_feedback) || !this.live_test_feedback.equalsIgnoreCase("1") || TextUtils.isEmpty(attemptOrReAttempt) || !attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT))) {
            return;
        }
        openFeedbackBottomSheet();
    }

    private void openFeedbackBottomSheet() {
        if (this.isBottomSheetOpen) {
            return;
        }
        this.isBottomSheetOpen = true;
        this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.LiveClass.Activity.LiveClassActivity.4
            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onClose() {
                LiveClassActivity.this.feedbackDialog[0].dismiss();
                LiveClassActivity.this.isBottomSheetOpen = false;
            }

            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onSubmit() {
                RatingBar ratingBar = (RatingBar) LiveClassActivity.this.feedbackDialog[0].findViewById(R.id.ratingBar);
                EditText editText = (EditText) LiveClassActivity.this.feedbackDialog[0].findViewById(R.id.ratingComment);
                LiveClassActivity.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                LiveClassActivity.this.ratingMessage = editText != null ? editText.getText().toString().trim() : "";
                if (ratingBar.getRating() <= 0.0f) {
                    Toast.makeText(LiveClassActivity.this, "Please select rating!", 0).show();
                } else {
                    if (LiveClassActivity.this.ratingMessage.isEmpty()) {
                        Toast.makeText(LiveClassActivity.this, "Please write feedback!", 0).show();
                        return;
                    }
                    LiveClassActivity.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                    LiveClassActivity.this.feedbackDialog[0].dismiss();
                    LiveClassActivity.this.isBottomSheetOpen = false;
                }
            }
        });
        Utils.INSTANCE.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{this.feedbackDialog[0]});
        this.feedbackDialog[0].show();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.POST_COURSE_REVIEW)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.courseId);
        encryptionData.setRating(this.rating);
        encryptionData.setMessage(this.ratingMessage);
        encryptionData.setRating_type(Integer.valueOf(this.rating_type));
        return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.POST_COURSE_REVIEW)) {
            Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !");
        }
    }

    public class LiveViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;

        public LiveViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.mFragmentList = new ArrayList();
            this.mFragmentTitleList = new ArrayList();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* JADX INFO: renamed from: getCount */
        public int getTotalTabs() {
            return this.mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }

    private void setupViewPager() {
        try {
            this.adapter = new LiveViewPagerAdapter(getSupportFragmentManager());
            LiveClasses liveClasses = new LiveClasses();
            this.liveclassesFragment = liveClasses;
            this.adapter.addFragment(liveClasses, this.activity.getResources().getString(R.string.live));
            Upcoming upcoming = new Upcoming();
            this.upcomingFragment = upcoming;
            this.adapter.addFragment(upcoming, this.activity.getResources().getString(R.string.upcoming));
            Completed completed = new Completed();
            this.completedFragment = completed;
            this.adapter.addFragment(completed, this.activity.getResources().getString(R.string.completed));
            view_pager.setAdapter(this.adapter);
            this.tabLayout.setupWithViewPager(view_pager);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            initListeners();
            if (this.myDBClass == null) {
                UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
                this.myDBClass = appDatabase;
                appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
            }
            if (Constants.REFRESHPAGE.equalsIgnoreCase("true")) {
                if (view_pager.getCurrentItem() == 0) {
                    this.liveclassesFragment.refresh_data();
                } else if (view_pager.getCurrentItem() == 1) {
                    this.upcomingFragment.refresh_data();
                } else if (view_pager.getCurrentItem() == 2) {
                    this.completedFragment.refresh_data();
                }
                Constants.REFRESHPAGE = "";
            }
        } catch (SQLiteDiskIOException e2) {
            Log.e("DatabaseHelper", "SQLiteDiskIOException during onUpgrade: " + e2.getMessage());
        } catch (SQLiteFullException e3) {
            Log.e("DatabaseHelper", "SQLiteFullException during onUpgrade: " + e3.getMessage());
        } catch (IllegalStateException e4) {
            Log.e("DatabaseHelper", "IllegalStateException (DB closed): " + e4.getMessage());
        } catch (Exception e5) {
            Log.e("DatabaseHelper", "Unhandled Exception: " + e5.getMessage());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.myDBClass = null;
    }

    private void initListeners() {
        VODPlayerActivity.setOnDataSendListener(this);
        Liveawsactivity.setOnDataSendListener(this);
        LiveStreamingYoutube.setOnDataSendListener(this);
        QuizActivity.setOnDataSendListener(this);
        TestBaseActivity.setOnDataSendListener(this);
        TestBaseActivitySSCPattern.setOnDataSendListener(this);
    }
}
