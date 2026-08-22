package com.appnew.android.home.Activity;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Interfaces.OnSuccessListner;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.home.Fragment.BatchFragment;
import com.appnew.android.home.Fragment.FreeFragment;
import com.appnew.android.home.Fragment.PaidFragment;
import com.appnew.android.home.interfaces.batchsortClickListner;
import com.appnew.android.home.interfaces.freesortClickListner;
import com.appnew.android.home.interfaces.sortClickListner;
import com.appnew.android.home.model.Menu;
import com.appnew.android.home.model.MyCourse;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.BottomMenuTable;
import com.appnew.android.table.MycourseTable;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.Gson;
import com.razorpay.PaymentResultListener;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class MyLibraryActivty extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentResultListener {
    public static String selectedTab = "Paid Course";
    private ViewPagerAdapter adapter;
    Button backBtn;
    private BatchFragment batchFragment;
    private batchsortClickListner batchsortClickListner;
    LinearLayout bottomLL;
    BottomSetting bottomSetting;
    public String courseIdOfRemoveCourse;
    public DatabaseReference firebaseDatabase;
    private FreeFragment freeFragment;
    private freesortClickListner freesortClickListner;
    private ImageView image_back;
    RelativeLayout layout;
    String libraryType;
    private sortClickListner listner;
    RelativeLayout mainCover;
    public MyCourse myCourse;
    public UtkashRoom myDBClass;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    private NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    public OnSuccessListner onSuccessListner;
    public PaidFragment paidFragment;
    public PaymentViewModel paymentViewModel;
    private PowerMenu powerMenu;
    private SwipeRefreshLayout pullToReferesh;
    RelativeLayout root_view;
    private s3ImageUploading s3IU;
    ImageView serac_image;
    SearchView serach_view;
    private TextView sort_by;
    private TabLayout tabLayout;
    TextView toolbarTitleTV;
    UtkashRoom utkashRoom;
    private ViewPager view_pager;
    boolean updateCourse = true;
    boolean CourseDetailJS = false;
    List<MycourseTable> mycourseTables = new ArrayList();
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    String str_imgTypeClick = "";
    private int imagePicType = 0;
    ArrayList<View> viewArrayList = new ArrayList<>();
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
    private final OnMenuItemClickListener<PowerMenuItem> onIconMenuItemClickListener = new OnMenuItemClickListener<PowerMenuItem>() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.1
        @Override // com.skydoves.powermenu.OnMenuItemClickListener
        public void onItemClick(int position, PowerMenuItem item) {
            item.setIsSelected(true);
            if (MyLibraryActivty.selectedTab.contains(MyLibraryActivty.this.getResources().getString(R.string.paid))) {
                MyLibraryActivty.this.item_select_dialog_paid(item.getTitle().toString());
            } else if (MyLibraryActivty.selectedTab.contains(MyLibraryActivty.this.getResources().getString(R.string.free_))) {
                MyLibraryActivty.this.item_select_dialog_free(item.getTitle().toString());
            } else if (MyLibraryActivty.selectedTab.contains(MyLibraryActivty.this.getResources().getString(R.string.batch))) {
                MyLibraryActivty.this.item_select_dialog_batch(item.getTitle().toString());
            }
            MyLibraryActivty.this.powerMenu.dismiss();
        }
    };
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.7
        /* JADX WARN: Code restructure failed: missing block: B:200:0x03bf, code lost:
        
            continue;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r14) {
            /*
                Method dump skipped, instruction units count: 1054
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.home.Activity.MyLibraryActivty.AnonymousClass7.onClick(android.view.View):void");
        }
    };
    long backPressed = 0;
    private boolean backstatus = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void item_select_dialog_paid(String titile) {
        this.myCourse.setPaid_course(this.myDBClass.getMyCourseDao().getpaidcourse("1"));
        if (titile.equals("Z-A(Title)")) {
            try {
                Collections.sort(this.myCourse.getPaid_course(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda14
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj2).getTitle().toLowerCase().trim().compareTo(((Courselist) obj).getTitle().toLowerCase().trim());
                    }
                });
                this.listner.onTitleClicked(this.myCourse.getPaid_course(), titile);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (titile.equals("A-Z(Title)")) {
            try {
                Collections.sort(this.myCourse.getPaid_course(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda15
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getTitle().toLowerCase().trim().compareTo(((Courselist) obj2).getTitle().toLowerCase().trim());
                    }
                });
                this.listner.onTitleClicked(this.myCourse.getPaid_course(), titile);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (titile.equals(getResources().getString(R.string.date_added))) {
            try {
                Collections.sort(this.myCourse.getPaid_course(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getPurchase_date().compareTo(((Courselist) obj2).getPurchase_date());
                    }
                });
                this.listner.onTitleClicked(this.myCourse.getPaid_course(), titile);
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (titile.equals(getResources().getString(R.string.last_read))) {
            try {
                Collections.sort(this.myCourse.getPaid_course(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda2
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getLastread().compareTo(((Courselist) obj2).getLastread());
                    }
                });
                this.listner.onTitleClicked(this.myCourse.getPaid_course(), titile);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void item_select_dialog_free(String titile) {
        this.myCourse.setFreecourse(this.myDBClass.getMyCourseDao().getFreecourse("0", "0"));
        if (titile.equals("Z-A(Title)")) {
            try {
                Collections.sort(this.myCourse.getFreecourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda10
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj2).getTitle().toLowerCase().trim().compareTo(((Courselist) obj).getTitle().toLowerCase().trim());
                    }
                });
                this.freesortClickListner.onTitleClicked(this.myCourse.getFreecourse(), titile);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (titile.equals("A-Z(Title)")) {
            try {
                Collections.sort(this.myCourse.getFreecourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda11
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getTitle().toLowerCase().trim().compareTo(((Courselist) obj2).getTitle().toLowerCase().trim());
                    }
                });
                this.freesortClickListner.onTitleClicked(this.myCourse.getFreecourse(), titile);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (titile.equals(getResources().getString(R.string.date_added))) {
            try {
                Collections.sort(this.myCourse.getFreecourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda12
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getPurchase_date().compareTo(((Courselist) obj2).getPurchase_date());
                    }
                });
                this.freesortClickListner.onTitleClicked(this.myCourse.getFreecourse(), titile);
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (titile.equals(getResources().getString(R.string.last_read))) {
            try {
                Collections.sort(this.myCourse.getFreecourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda13
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getLastread().compareTo(((Courselist) obj2).getLastread());
                    }
                });
                this.freesortClickListner.onTitleClicked(this.myCourse.getFreecourse(), titile);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void item_select_dialog_batch(String titile) {
        if (titile.equals("Z-A(Title)")) {
            try {
                Collections.sort(this.myCourse.getBatchcourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda7
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj2).getTitle().toLowerCase().trim().compareTo(((Courselist) obj).getTitle().toLowerCase().trim());
                    }
                });
                this.batchsortClickListner.onTitleClicked(this.myCourse.getBatchcourse());
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (titile.equals("A-Z(Title)")) {
            try {
                Collections.sort(this.myCourse.getBatchcourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda8
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getTitle().toLowerCase().trim().compareTo(((Courselist) obj2).getTitle().toLowerCase().trim());
                    }
                });
                this.batchsortClickListner.onTitleClicked(this.myCourse.getBatchcourse());
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (titile.equals(getResources().getString(R.string.date_added))) {
            try {
                Collections.sort(this.myCourse.getBatchcourse(), new Comparator() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda9
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Courselist) obj).getPurchase_date().compareTo(((Courselist) obj2).getPurchase_date());
                    }
                });
                this.batchsortClickListner.onTitleClicked(this.myCourse.getBatchcourse());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        Helper.setSystemBarLight(this);
        setContentView(R.layout.my_library_activty);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        try {
            PaymentViewModel paymentViewModel = (PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class);
            this.paymentViewModel = paymentViewModel;
            paymentViewModel.initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.2
                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                    MyLibraryActivty.this.onSuccessListner.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccess(String posTxnId) {
                    MyLibraryActivty.this.onSuccessListner.onSuccess(posTxnId);
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onFailed(boolean isFailure) {
                    MyLibraryActivty.this.OnPaymentError("i~!@#$%^&s");
                }
            }, "");
            String stringExtra = getIntent().getStringExtra("libraryType");
            this.libraryType = stringExtra;
            if (stringExtra == null) {
                this.libraryType = "";
            }
            String stringExtra2 = getIntent().getStringExtra("toolbarTitle");
            this.view_pager = (ViewPager) findViewById(R.id.view_pager);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.tabLayout = (TabLayout) findViewById(R.id.tabs);
            this.pullToReferesh = (SwipeRefreshLayout) findViewById(R.id.pullto_referesh);
            this.mainCover = (RelativeLayout) findViewById(R.id.mainCover);
            this.serach_view = (SearchView) findViewById(R.id.sv_search);
            this.serac_image = (ImageView) findViewById(R.id.serac_image);
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            this.bottomLL = (LinearLayout) findViewById(R.id.bottomLL);
            this.root_view = (RelativeLayout) findViewById(R.id.root_view);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            this.layout = (RelativeLayout) findViewById(R.id.layout);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            this.myDBClass = UtkashRoom.getAppDatabase(this);
            this.networkCall = new NetworkCall(this, this);
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), this.root_view, toolbar);
            }
            if (stringExtra2 != null && !stringExtra2.equalsIgnoreCase("")) {
                this.toolbarTitleTV.setText(stringExtra2);
            }
            try {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(67108864);
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                if (this.myDBClass.getthemeSettingdao().is_setting_exit()) {
                    this.bottomSetting = (BottomSetting) new Gson().fromJson(this.myDBClass.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                }
                if ("1".equalsIgnoreCase("7") && BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses") && this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                    this.bottomLL.setVisibility(0);
                    this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                    this.bottomLL.removeAllViews();
                    ArrayList<View> arrayList = this.viewArrayList;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    this.bottomMenuTables.clear();
                    this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.userId);
                    for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                        this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "3"));
                    }
                }
                if (this.bottomSetting.getIs_purchase_toolbar().equalsIgnoreCase("1")) {
                    this.tabLayout.setVisibility(0);
                } else {
                    this.tabLayout.setVisibility(8);
                }
                if (this.myDBClass.getMyCourseDao().isRecordExists(MakeMyExam.userId)) {
                    this.mycourseTables = this.myDBClass.getMyCourseDao().getAllUser();
                    this.myCourse = new MyCourse();
                    ArrayList<Courselist> arrayList2 = new ArrayList<>();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList<Courselist> arrayList5 = new ArrayList<>();
                    for (MycourseTable mycourseTable : this.mycourseTables) {
                        Courselist courselist = new Courselist();
                        courselist.setId(mycourseTable.getId());
                        courselist.setTitle(mycourseTable.getTitle());
                        courselist.setBatch_id(mycourseTable.getBatch_id());
                        courselist.setCover_image(mycourseTable.getCover_image());
                        courselist.setDescHeaderImage(mycourseTable.getDescHeaderImage());
                        courselist.setCat_type(mycourseTable.getCat_type());
                        courselist.setExpiry_date(mycourseTable.getExpiry_date());
                        courselist.setIs_activated(mycourseTable.getIs_activated());
                        courselist.setPurchase_date(mycourseTable.getPurchase_date());
                        courselist.setMrp(mycourseTable.getMrp());
                        courselist.setTxn_id(mycourseTable.getTxn_id());
                        courselist.setCombo_course_ids(mycourseTable.getCombo_course_ids());
                        courselist.setContent_type(mycourseTable.getContent_type());
                        courselist.setViewType(mycourseTable.getViewType());
                        if (!TextUtils.isEmpty(courselist.getBatch_id()) && !courselist.getBatch_id().equalsIgnoreCase("0")) {
                            courselist.setPrices(null);
                            courselist.setExpiry_date("0");
                            courselist.setDelete(0);
                            arrayList5.add(courselist);
                        } else if (courselist.getMrp().equalsIgnoreCase("0")) {
                            courselist.setDelete(1);
                            if (mycourseTable.getPrices() != null && mycourseTable.getPrices().size() > 0) {
                                courselist.setPrices(mycourseTable.getPrices());
                            }
                            courselist.setLastread(mycourseTable.getLastread());
                            arrayList4.add(courselist);
                        } else if (Integer.parseInt(courselist.getMrp()) > 0) {
                            courselist.setDelete(0);
                            if (mycourseTable.getPrices() != null && mycourseTable.getPrices().size() > 0) {
                                courselist.setPrices(mycourseTable.getPrices());
                            }
                            courselist.setLastread(mycourseTable.getLastread());
                            arrayList3.add(courselist);
                        }
                        arrayList2.add(courselist);
                    }
                    this.myCourse.setData(arrayList2);
                    this.myCourse.setBatchcourse(arrayList5);
                    this.myCourse.setFreecourse(arrayList4);
                    this.myCourse.setPaid_course(arrayList3);
                    setupViewPager();
                } else {
                    this.networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
                }
                MyCourse myCourse = this.myCourse;
                if (myCourse != null) {
                    if (myCourse.getData() != null && this.myCourse.getData().size() > 0) {
                        this.mainCover.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                    } else {
                        this.mainCover.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.3
                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabReselected(TabLayout.Tab tab) {
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(TabLayout.Tab tab) {
                    MyLibraryActivty.selectedTab = (String) tab.getText();
                }
            });
            this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda3
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    this.f$0.lambda$onCreate$11();
                }
            });
            if (BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses")) {
                this.image_back.setVisibility(8);
            } else {
                this.image_back.setVisibility(0);
            }
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$12();
                }
            }));
            this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$13();
                }
            }));
            this.view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    if (position == 1 && MyLibraryActivty.this.bottomSetting.getIs_free_course().equalsIgnoreCase("1") && MyLibraryActivty.this.freeFragment.paidCourseAdapter != null) {
                        if ("1".equalsIgnoreCase("6")) {
                            ArrayList arrayList6 = new ArrayList();
                            for (Courselist courselist2 : MyLibraryActivty.this.myCourse.getFreecourse()) {
                                if (courselist2.getViewType().equalsIgnoreCase(MyLibraryActivty.this.libraryType)) {
                                    arrayList6.add(courselist2);
                                }
                            }
                            MyLibraryActivty.this.freeFragment.paidCourseAdapter.notifidata(arrayList6);
                            return;
                        }
                        MyLibraryActivty.this.freeFragment.paidCourseAdapter.notifidata(MyLibraryActivty.this.myCourse.getFreecourse());
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                    MyLibraryActivty.this.toggleRefreshing(state == 0);
                }
            });
            this.serac_image.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$15(view);
                }
            });
            this.serach_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.5
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String newText) {
                    BatchFragment batchFragment;
                    FreeFragment freeFragment;
                    PaidFragment paidFragment;
                    BatchFragment batchFragment2;
                    FreeFragment freeFragment2;
                    PaidFragment paidFragment2;
                    BatchFragment batchFragment3;
                    FreeFragment freeFragment3;
                    PaidFragment paidFragment3;
                    BatchFragment batchFragment4;
                    FreeFragment freeFragment4;
                    PaidFragment paidFragment4;
                    BatchFragment batchFragment5;
                    FreeFragment freeFragment5;
                    PaidFragment paidFragment5;
                    BatchFragment batchFragment6;
                    FreeFragment freeFragment6;
                    PaidFragment paidFragment6;
                    if (!newText.equalsIgnoreCase("") && MyLibraryActivty.this.view_pager.getAdapter() != null) {
                        Fragment fragment = (Fragment) MyLibraryActivty.this.view_pager.getAdapter().instantiateItem((ViewGroup) MyLibraryActivty.this.view_pager, MyLibraryActivty.this.view_pager.getCurrentItem());
                        if (fragment == null || !fragment.isAdded()) {
                            return false;
                        }
                        if (MyLibraryActivty.this.view_pager.getCurrentItem() == 0) {
                            if ((fragment instanceof PaidFragment) && (paidFragment6 = (PaidFragment) fragment) != null) {
                                paidFragment6.beginSearch(newText);
                            }
                            if ((fragment instanceof FreeFragment) && (freeFragment6 = (FreeFragment) fragment) != null) {
                                freeFragment6.beginSearch(newText);
                            }
                            if (!(fragment instanceof BatchFragment) || (batchFragment6 = (BatchFragment) fragment) == null) {
                                return false;
                            }
                            batchFragment6.beginSearch(newText);
                            return false;
                        }
                        if (MyLibraryActivty.this.view_pager.getCurrentItem() == 1) {
                            if ((fragment instanceof PaidFragment) && (paidFragment5 = (PaidFragment) fragment) != null) {
                                paidFragment5.beginSearch(newText);
                            }
                            if ((fragment instanceof FreeFragment) && (freeFragment5 = (FreeFragment) fragment) != null) {
                                freeFragment5.beginSearch(newText);
                            }
                            if (!(fragment instanceof BatchFragment) || (batchFragment5 = (BatchFragment) fragment) == null) {
                                return false;
                            }
                            batchFragment5.beginSearch(newText);
                            return false;
                        }
                        if ((fragment instanceof PaidFragment) && (paidFragment4 = (PaidFragment) fragment) != null) {
                            paidFragment4.beginSearch(newText);
                        }
                        if ((fragment instanceof FreeFragment) && (freeFragment4 = (FreeFragment) fragment) != null) {
                            freeFragment4.beginSearch(newText);
                        }
                        if (!(fragment instanceof BatchFragment) || (batchFragment4 = (BatchFragment) fragment) == null) {
                            return false;
                        }
                        batchFragment4.beginSearch(newText);
                        return false;
                    }
                    if (MyLibraryActivty.this.view_pager.getAdapter() != null) {
                        Fragment fragment2 = (Fragment) MyLibraryActivty.this.view_pager.getAdapter().instantiateItem((ViewGroup) MyLibraryActivty.this.view_pager, MyLibraryActivty.this.view_pager.getCurrentItem());
                        if (fragment2 == null || !fragment2.isAdded()) {
                            return false;
                        }
                        if (MyLibraryActivty.this.view_pager.getCurrentItem() == 0) {
                            if ((fragment2 instanceof PaidFragment) && (paidFragment3 = (PaidFragment) fragment2) != null) {
                                paidFragment3.beginSearch(newText);
                            }
                            if ((fragment2 instanceof FreeFragment) && (freeFragment3 = (FreeFragment) fragment2) != null) {
                                freeFragment3.beginSearch(newText);
                            }
                            if (!(fragment2 instanceof BatchFragment) || (batchFragment3 = (BatchFragment) fragment2) == null) {
                                return false;
                            }
                            batchFragment3.beginSearch(newText);
                            return false;
                        }
                        if (MyLibraryActivty.this.view_pager.getCurrentItem() == 1) {
                            if ((fragment2 instanceof PaidFragment) && (paidFragment2 = (PaidFragment) fragment2) != null) {
                                paidFragment2.beginSearch(newText);
                            }
                            if ((fragment2 instanceof FreeFragment) && (freeFragment2 = (FreeFragment) fragment2) != null) {
                                freeFragment2.beginSearch(newText);
                            }
                            if (!(fragment2 instanceof BatchFragment) || (batchFragment2 = (BatchFragment) fragment2) == null) {
                                return false;
                            }
                            batchFragment2.beginSearch(newText);
                            return false;
                        }
                        if ((fragment2 instanceof PaidFragment) && (paidFragment = (PaidFragment) fragment2) != null) {
                            paidFragment.beginSearch(newText);
                        }
                        if ((fragment2 instanceof FreeFragment) && (freeFragment = (FreeFragment) fragment2) != null) {
                            freeFragment.beginSearch(newText);
                        }
                        if (!(fragment2 instanceof BatchFragment) || (batchFragment = (BatchFragment) fragment2) == null) {
                            return false;
                        }
                        batchFragment.beginSearch(newText);
                        return false;
                    }
                    if (MyLibraryActivty.this.paidFragment == null) {
                        return false;
                    }
                    if (MyLibraryActivty.this.bottomSetting.getIs_free_course().equalsIgnoreCase("1") && MyLibraryActivty.this.freeFragment.paidCourseAdapter != null) {
                        if ("1".equalsIgnoreCase("6")) {
                            ArrayList arrayList6 = new ArrayList();
                            for (Courselist courselist2 : MyLibraryActivty.this.myCourse.getFreecourse()) {
                                if (courselist2.getViewType().equalsIgnoreCase(MyLibraryActivty.this.libraryType)) {
                                    arrayList6.add(courselist2);
                                }
                            }
                            MyLibraryActivty.this.freeFragment.paidCourseAdapter.notifidata(arrayList6);
                        } else {
                            MyLibraryActivty.this.freeFragment.paidCourseAdapter.notifidata(MyLibraryActivty.this.myCourse.getFreecourse());
                        }
                    }
                    if (MyLibraryActivty.this.bottomSetting.getBatch_course().equalsIgnoreCase("1") && MyLibraryActivty.this.batchFragment.paidCourseAdapter != null) {
                        MyLibraryActivty.this.batchFragment.paidCourseAdapter.notifidata(MyLibraryActivty.this.myCourse.getBatchcourse());
                    }
                    if (!MyLibraryActivty.this.bottomSetting.getIs_paid_course().equalsIgnoreCase("1") || MyLibraryActivty.this.paidFragment.paidCourseAdapter == null) {
                        return false;
                    }
                    if ("1".equalsIgnoreCase("6")) {
                        ArrayList arrayList7 = new ArrayList();
                        for (Courselist courselist3 : MyLibraryActivty.this.myCourse.getPaid_course()) {
                            if (courselist3.getViewType().equalsIgnoreCase(MyLibraryActivty.this.libraryType)) {
                                arrayList7.add(courselist3);
                            }
                        }
                        MyLibraryActivty.this.paidFragment.paidCourseAdapter.notifidata(arrayList7);
                        return false;
                    }
                    MyLibraryActivty.this.paidFragment.paidCourseAdapter.notifidata(MyLibraryActivty.this.myCourse.getPaid_course());
                    return false;
                }
            });
            this.serach_view.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.6
                @Override // androidx.appcompat.widget.SearchView.OnCloseListener
                public boolean onClose() {
                    return false;
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11() {
        PreferencesUtil.INSTANCE.setStringPreference(this, Const.COURSE_DETAIL_JS, "1");
        APITABLE apitable = this.myDBClass.getapidao().getapidetail("ut_012", MakeMyExam.userId);
        if (apitable != null && !TextUtils.isEmpty(apitable.getTimestamp()) && !TextUtils.isEmpty(apitable.getInterval()) && Long.parseLong(apitable.getTimestamp()) + Long.parseLong(apitable.getInterval()) < MakeMyExam.getTime_server() / 1000) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager.isAcceptingText()) {
                    inputMethodManager.hideSoftInputFromWindow(this.pullToReferesh.getRootView().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.serac_image.setVisibility(0);
            this.layout.setVisibility(8);
            this.toolbarTitleTV.setVisibility(0);
            this.networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
            this.pullToReferesh.setRefreshing(false);
            return;
        }
        if (this.updateCourse) {
            this.networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
            this.updateCourse = false;
        }
        if (this.paidFragment != null) {
            if (this.bottomSetting.getIs_free_course().equalsIgnoreCase("1") && this.freeFragment.paidCourseAdapter != null) {
                if ("1".equalsIgnoreCase("6")) {
                    ArrayList arrayList = new ArrayList();
                    for (Courselist courselist : this.myCourse.getFreecourse()) {
                        if (courselist.getViewType().equalsIgnoreCase(this.libraryType)) {
                            arrayList.add(courselist);
                        }
                    }
                    this.freeFragment.paidCourseAdapter.notifidata(arrayList);
                } else {
                    this.freeFragment.paidCourseAdapter.notifidata(this.myCourse.getFreecourse());
                }
            }
            if (this.bottomSetting.getBatch_course().equalsIgnoreCase("1") && this.batchFragment.paidCourseAdapter != null) {
                this.batchFragment.paidCourseAdapter.notifidata(this.myCourse.getBatchcourse());
            }
            if (this.bottomSetting.getIs_paid_course().equalsIgnoreCase("1") && this.paidFragment.paidCourseAdapter != null) {
                if ("1".equalsIgnoreCase("6")) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Courselist courselist2 : this.myCourse.getPaid_course()) {
                        if (courselist2.getViewType().equalsIgnoreCase(this.libraryType)) {
                            arrayList2.add(courselist2);
                        }
                    }
                    this.paidFragment.paidCourseAdapter.notifidata(arrayList2);
                } else {
                    this.paidFragment.paidCourseAdapter.notifidata(this.myCourse.getPaid_course());
                }
            }
        }
        this.pullToReferesh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$12() {
        Helper.closeKeyboard(this);
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$13() {
        onBackPressed();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        this.serac_image.setVisibility(8);
        this.layout.setVisibility(0);
        this.toolbarTitleTV.setVisibility(8);
        final EditText editText = (EditText) this.serach_view.findViewById(R.id.search_src_text);
        editText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));
        editText.setTextColor(getResources().getColor(R.color.country_code_text_color));
        editText.setHintTextColor(getResources().getColor(R.color.black_lite));
        this.serach_view.setActivated(true);
        this.serach_view.setIconified(false);
        this.serach_view.setIconifiedByDefault(false);
        this.serach_view.setQueryHint("Search");
        this.serach_view.onActionViewExpanded();
        this.serach_view.clearFocus();
        ImageView imageView = (ImageView) this.serach_view.findViewById(R.id.search_mag_icon);
        ImageView imageView2 = (ImageView) this.serach_view.findViewById(R.id.search_close_btn);
        imageView2.setColorFilter(ContextCompat.getColor(this, R.color.country_code_text_color), PorterDuff.Mode.MULTIPLY);
        imageView2.setImageResource(R.drawable.white_cross);
        imageView.setVisibility(8);
        editText.setBackgroundColor(0);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.MyLibraryActivty$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onCreate$14(editText, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$14(EditText editText, View view) {
        BatchFragment batchFragment;
        FreeFragment freeFragment;
        PaidFragment paidFragment;
        BatchFragment batchFragment2;
        FreeFragment freeFragment2;
        PaidFragment paidFragment2;
        BatchFragment batchFragment3;
        FreeFragment freeFragment3;
        PaidFragment paidFragment3;
        editText.setText("");
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        this.serac_image.setVisibility(0);
        this.layout.setVisibility(8);
        this.toolbarTitleTV.setVisibility(0);
        if (this.view_pager.getAdapter() != null) {
            PagerAdapter adapter = this.view_pager.getAdapter();
            ViewPager viewPager = this.view_pager;
            Fragment fragment = (Fragment) adapter.instantiateItem((ViewGroup) viewPager, viewPager.getCurrentItem());
            if (fragment == null || !fragment.isAdded()) {
                return;
            }
            if (this.view_pager.getCurrentItem() == 0) {
                if ((fragment instanceof PaidFragment) && (paidFragment3 = (PaidFragment) fragment) != null) {
                    paidFragment3.beginSearch("");
                }
                if ((fragment instanceof FreeFragment) && (freeFragment3 = (FreeFragment) fragment) != null) {
                    freeFragment3.beginSearch("");
                }
                if (!(fragment instanceof BatchFragment) || (batchFragment3 = (BatchFragment) fragment) == null) {
                    return;
                }
                batchFragment3.beginSearch("");
                return;
            }
            if (this.view_pager.getCurrentItem() == 1) {
                if ((fragment instanceof PaidFragment) && (paidFragment2 = (PaidFragment) fragment) != null) {
                    paidFragment2.beginSearch("");
                }
                if ((fragment instanceof FreeFragment) && (freeFragment2 = (FreeFragment) fragment) != null) {
                    freeFragment2.beginSearch("");
                }
                if (!(fragment instanceof BatchFragment) || (batchFragment2 = (BatchFragment) fragment) == null) {
                    return;
                }
                batchFragment2.beginSearch("");
                return;
            }
            if ((fragment instanceof PaidFragment) && (paidFragment = (PaidFragment) fragment) != null) {
                paidFragment.beginSearch("");
            }
            if ((fragment instanceof FreeFragment) && (freeFragment = (FreeFragment) fragment) != null) {
                freeFragment.beginSearch("");
            }
            if (!(fragment instanceof BatchFragment) || (batchFragment = (BatchFragment) fragment) == null) {
                return;
            }
            batchFragment.beginSearch("");
            return;
        }
        if (this.paidFragment != null) {
            if (this.bottomSetting.getIs_free_course().equalsIgnoreCase("1") && this.freeFragment.paidCourseAdapter != null) {
                if ("1".equalsIgnoreCase("6")) {
                    ArrayList arrayList = new ArrayList();
                    for (Courselist courselist : this.myCourse.getFreecourse()) {
                        if (courselist.getViewType().equalsIgnoreCase(this.libraryType)) {
                            arrayList.add(courselist);
                        }
                    }
                    this.freeFragment.paidCourseAdapter.notifidata(arrayList);
                } else {
                    this.freeFragment.paidCourseAdapter.notifidata(this.myCourse.getFreecourse());
                }
            }
            if (this.bottomSetting.getBatch_course().equalsIgnoreCase("1") && this.batchFragment.paidCourseAdapter != null) {
                this.batchFragment.paidCourseAdapter.notifidata(this.myCourse.getBatchcourse());
            }
            if (!this.bottomSetting.getIs_paid_course().equalsIgnoreCase("1") || this.paidFragment.paidCourseAdapter == null) {
                return;
            }
            if ("1".equalsIgnoreCase("6")) {
                ArrayList arrayList2 = new ArrayList();
                for (Courselist courselist2 : this.myCourse.getPaid_course()) {
                    if (courselist2.getViewType().equalsIgnoreCase(this.libraryType)) {
                        arrayList2.add(courselist2);
                    }
                }
                this.paidFragment.paidCourseAdapter.notifidata(arrayList2);
                return;
            }
            this.paidFragment.paidCourseAdapter.notifidata(this.myCourse.getPaid_course());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Helper.closeKeyboard(this);
        super.onBackPressed();
    }

    public void toggleRefreshing(boolean enabled) {
        SwipeRefreshLayout swipeRefreshLayout = this.pullToReferesh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(enabled);
        }
    }

    public void updatesortlistner(sortClickListner listner) {
        this.listner = listner;
    }

    public void updatesortlistner_free(freesortClickListner freesortClickListner) {
        this.freesortClickListner = freesortClickListner;
    }

    public void updatesortlistner_batch(batchsortClickListner batchsortClickListner) {
        this.batchsortClickListner = batchsortClickListner;
    }

    private void sort_dialog(TextView sort_by) {
        if (!this.myDBClass.getMyCourseDao().isRecordExists(MakeMyExam.userId)) {
            this.networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PowerMenuItem((CharSequence) "A-Z(Title)", false));
        arrayList.add(1, new PowerMenuItem((CharSequence) "Z-A(Title)", false));
        arrayList.add(2, new PowerMenuItem((CharSequence) getResources().getString(R.string.date_added), false));
        if (!selectedTab.contains(getResources().getString(R.string.batch))) {
            arrayList.add(3, new PowerMenuItem((CharSequence) getResources().getString(R.string.last_read), false));
        }
        PowerMenu powerMenuBuild = new PowerMenu.Builder(this).addItemList(arrayList).setAnimation(MenuAnimation.SHOWUP_BOTTOM_RIGHT).setMenuRadius(10.0f).setMenuShadow(10.0f).setWidth(300).setTextColor(getResources().getColor(R.color.country_code_text_color)).setMenuColor(-1).setSelectedTextColor(-1).setSelectedMenuColor(ContextCompat.getColor(this, R.color.theme_and_header_color)).setOnMenuItemClickListener(this.onIconMenuItemClickListener).build();
        this.powerMenu = powerMenuBuild;
        powerMenuBuild.showAsAnchorRightBottom(sort_by);
    }

    private void setupViewPager() {
        try {
            this.adapter = new ViewPagerAdapter(getSupportFragmentManager());
            Bundle bundle = new Bundle();
            bundle.putString("showViewType", this.libraryType);
            if (this.bottomSetting.getIs_paid_course().equalsIgnoreCase("1")) {
                PaidFragment paidFragment = new PaidFragment();
                this.paidFragment = paidFragment;
                paidFragment.setArguments(bundle);
                this.adapter.addFragment(this.paidFragment, getResources().getString(R.string.paid_course));
            }
            if (this.bottomSetting.getIs_free_course().equalsIgnoreCase("1")) {
                FreeFragment freeFragment = new FreeFragment();
                this.freeFragment = freeFragment;
                freeFragment.setArguments(bundle);
                this.adapter.addFragment(this.freeFragment, getResources().getString(R.string.free_course));
            }
            if (this.bottomSetting.getBatch_course().equalsIgnoreCase("1")) {
                BatchFragment batchFragment = new BatchFragment();
                this.batchFragment = batchFragment;
                batchFragment.setArguments(bundle);
                this.adapter.addFragment(this.batchFragment, getResources().getString(R.string.batch_course));
            }
            this.view_pager.setAdapter(this.adapter);
            this.tabLayout.setupWithViewPager(this.view_pager);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_my_courses)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(MakeMyExam.userId);
        return service.get_my_courses(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int i;
        apitype.hashCode();
        if (apitype.equals(API.get_my_courses)) {
            try {
                Helper.dismissProgressDialog();
                int i2 = 0;
                if (jsonstring.optString("status").equals("true")) {
                    if (this.myDBClass.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_012")) {
                        this.myDBClass.getapidao().update_api_version("ut_012", MakeMyExam.userId, String.valueOf(jsonstring.optLong("time")), String.valueOf(jsonstring.optLong("interval")), String.valueOf(jsonstring.optLong("cd_time")));
                    } else {
                        APITABLE apitable = new APITABLE();
                        apitable.setApicode("ut_012");
                        apitable.setApiname("get_my_courses");
                        apitable.setInterval(String.valueOf(jsonstring.optLong("interval")));
                        apitable.setUser_id(MakeMyExam.getUserId());
                        apitable.setTimestamp(String.valueOf(jsonstring.optLong("time")));
                        apitable.setCdtimestamp(String.valueOf(jsonstring.optLong("cd_time")));
                        apitable.setVersion("0.000");
                        this.myDBClass.getapidao().addUser(apitable);
                    }
                    this.mainCover.setVisibility(0);
                    this.no_data_found_RL.setVisibility(8);
                    MyCourse myCourse = (MyCourse) new Gson().fromJson(jsonstring.toString(), MyCourse.class);
                    this.myCourse = myCourse;
                    if (myCourse.getData().size() > 0) {
                        this.pullToReferesh.setEnabled(true);
                        this.myDBClass.getMyCourseDao().deletedata();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<Courselist> arrayList3 = new ArrayList<>();
                        for (Courselist courselist : this.myCourse.getData()) {
                            if (!TextUtils.isEmpty(courselist.getBatch_id()) && !courselist.getBatch_id().equalsIgnoreCase("0")) {
                                if (!this.myDBClass.getMyCourseDao().isRecordExistsUserId(MakeMyExam.userId, "2", courselist.getId())) {
                                    MycourseTable mycourseTable = new MycourseTable();
                                    mycourseTable.setBatch_id(courselist.getBatch_id());
                                    mycourseTable.setBatchtype("2");
                                    mycourseTable.setCover_image(courselist.getCover_image());
                                    mycourseTable.setDescHeaderImage(courselist.getDescHeaderImage());
                                    mycourseTable.setId(courselist.getId());
                                    mycourseTable.setCat_type(courselist.getCat_type());
                                    mycourseTable.setExpiry_date("0");
                                    mycourseTable.setPurchase_date(courselist.getPurchase_date());
                                    i = i2;
                                    mycourseTable.setLastread("" + MakeMyExam.getTime_server());
                                    mycourseTable.setTitle(courselist.getTitle());
                                    mycourseTable.setTxn_id(courselist.getTxn_id());
                                    mycourseTable.setMrp(courselist.getMrp());
                                    mycourseTable.setUserid(MakeMyExam.userId);
                                    mycourseTable.setIs_activated(courselist.getIs_activated());
                                    courselist.setPrices(null);
                                    courselist.setExpiry_date("0");
                                    mycourseTable.setIsExpand(courselist.getCombo_course_ids());
                                    mycourseTable.setCombo_course_ids(courselist.getCombo_course_ids());
                                    mycourseTable.setContent_type(courselist.getContent_type());
                                    mycourseTable.setViewType(courselist.getViewType());
                                    this.myDBClass.getMyCourseDao().addUser(mycourseTable);
                                    arrayList3.add(courselist);
                                } else {
                                    i = i2;
                                    courselist.setPrices(null);
                                    courselist.setExpiry_date("0");
                                    arrayList3.add(courselist);
                                }
                            } else {
                                i = i2;
                                if (courselist.getMrp().equalsIgnoreCase("0")) {
                                    if (!this.myDBClass.getMyCourseDao().isRecordExistsUserId(MakeMyExam.userId, "0", courselist.getId())) {
                                        MycourseTable mycourseTable2 = new MycourseTable();
                                        mycourseTable2.setBatch_id("");
                                        mycourseTable2.setBatchtype("0");
                                        mycourseTable2.setCover_image(courselist.getCover_image());
                                        mycourseTable2.setDescHeaderImage(courselist.getDescHeaderImage());
                                        mycourseTable2.setId(courselist.getId());
                                        mycourseTable2.setCat_type(courselist.getCat_type());
                                        mycourseTable2.setExpiry_date(courselist.getExpiry_date());
                                        mycourseTable2.setPurchase_date(courselist.getPurchase_date());
                                        mycourseTable2.setLastread("" + MakeMyExam.getTime_server());
                                        mycourseTable2.setTitle(courselist.getTitle());
                                        mycourseTable2.setTxn_id(courselist.getTxn_id());
                                        mycourseTable2.setIs_activated(courselist.getIs_activated());
                                        mycourseTable2.setMrp(courselist.getMrp());
                                        mycourseTable2.setUserid(MakeMyExam.userId);
                                        mycourseTable2.setCombo_course_ids(courselist.getCombo_course_ids());
                                        mycourseTable2.setContent_type(courselist.getContent_type());
                                        mycourseTable2.setViewType(courselist.getViewType());
                                        mycourseTable2.setDelete(1);
                                        if (courselist.getPrices() != null && courselist.getPrices().size() > 0) {
                                            mycourseTable2.setPrices(courselist.getPrices());
                                        }
                                        courselist.setDelete(1);
                                        mycourseTable2.setIsExpand(courselist.getCombo_course_ids());
                                        this.myDBClass.getMyCourseDao().addUser(mycourseTable2);
                                        arrayList2.add(courselist);
                                    } else {
                                        courselist.setDelete(1);
                                        courselist.setLastread(this.myDBClass.getMyCourseDao().getuser(MakeMyExam.userId, courselist.getId(), "0").getLastread());
                                        arrayList2.add(courselist);
                                    }
                                } else if (Integer.parseInt(courselist.getMrp()) > 0) {
                                    if (!this.myDBClass.getMyCourseDao().isRecordExistsUserId(MakeMyExam.userId, "1", courselist.getId())) {
                                        MycourseTable mycourseTable3 = new MycourseTable();
                                        mycourseTable3.setBatch_id("");
                                        mycourseTable3.setBatchtype("1");
                                        mycourseTable3.setCover_image(courselist.getCover_image());
                                        mycourseTable3.setDescHeaderImage(courselist.getDescHeaderImage());
                                        mycourseTable3.setCat_type(courselist.getCat_type());
                                        mycourseTable3.setId(courselist.getId());
                                        mycourseTable3.setExpiry_date(courselist.getExpiry_date());
                                        mycourseTable3.setPurchase_date(courselist.getPurchase_date());
                                        mycourseTable3.setLastread("" + MakeMyExam.getTime_server());
                                        mycourseTable3.setIs_activated(courselist.getIs_activated());
                                        mycourseTable3.setTitle(courselist.getTitle());
                                        mycourseTable3.setTxn_id(courselist.getTxn_id());
                                        mycourseTable3.setMrp(courselist.getMrp());
                                        mycourseTable3.setUserid(MakeMyExam.userId);
                                        mycourseTable3.setIsExpand(courselist.getCombo_course_ids());
                                        mycourseTable3.setCombo_course_ids(courselist.getCombo_course_ids());
                                        mycourseTable3.setContent_type(courselist.getContent_type());
                                        mycourseTable3.setViewType(courselist.getViewType());
                                        if (courselist.getPrices() != null && courselist.getPrices().size() > 0) {
                                            mycourseTable3.setPrices(courselist.getPrices());
                                        }
                                        this.myDBClass.getMyCourseDao().addUser(mycourseTable3);
                                        arrayList.add(courselist);
                                    } else {
                                        courselist.setLastread(this.myDBClass.getMyCourseDao().getuser(MakeMyExam.userId, courselist.getId(), "1").getLastread());
                                        arrayList.add(courselist);
                                    }
                                }
                            }
                            i2 = i;
                        }
                        int i3 = i2;
                        this.myCourse.setBatchcourse(arrayList3);
                        this.myCourse.setFreecourse(arrayList2);
                        this.myCourse.setPaid_course(arrayList);
                        if (this.paidFragment != null) {
                            if (this.view_pager.getCurrentItem() == 0) {
                                this.paidFragment.updatedata(arrayList);
                            }
                            if (this.view_pager.getCurrentItem() == 1) {
                                this.freeFragment.updatedata(arrayList2);
                            }
                            if (this.view_pager.getCurrentItem() == 2) {
                                this.batchFragment.updatedata(arrayList3);
                            }
                        } else {
                            setupViewPager();
                        }
                        MyCourse myCourse2 = this.myCourse;
                        if (myCourse2 == null || myCourse2.getData().size() <= 0) {
                            return;
                        }
                        List<String> listCourseids = this.myDBClass.getvideoDownloadao().courseids(MakeMyExam.userId);
                        List<String> listCourseids2 = this.myDBClass.getuserhistorydao().courseids(MakeMyExam.userId);
                        HashSet hashSet = new HashSet();
                        Iterator<String> it = listCourseids2.iterator();
                        while (it.hasNext()) {
                            String[] strArrSplit = it.next().split(MqttTopic.MULTI_LEVEL_WILDCARD);
                            if (strArrSplit.length == 2) {
                                hashSet.add(strArrSplit[1]);
                            } else if (strArrSplit.length > 0) {
                                hashSet.add(strArrSplit[i3]);
                            }
                        }
                        HashSet hashSet2 = new HashSet();
                        Iterator<String> it2 = listCourseids.iterator();
                        while (it2.hasNext()) {
                            String[] strArrSplit2 = it2.next().split(MqttTopic.MULTI_LEVEL_WILDCARD);
                            if (strArrSplit2.length == 2) {
                                hashSet2.add(strArrSplit2[1]);
                            } else if (strArrSplit2.length > 0) {
                                hashSet2.add(strArrSplit2[i3]);
                            }
                        }
                        HashSet hashSet3 = new HashSet();
                        for (int i4 = i3; i4 < this.myCourse.getData().size(); i4++) {
                            hashSet3.add(this.myCourse.getData().get(i4).getId());
                            if (this.myCourse.getData().get(i4).getCombo_course_ids() != null && !this.myCourse.getData().get(i4).getCombo_course_ids().equalsIgnoreCase("")) {
                                List listAsList = Arrays.asList(this.myCourse.getData().get(i4).getCombo_course_ids().split(Constants.SEPARATOR_COMMA));
                                if (listAsList.size() > 0) {
                                    hashSet3.addAll(listAsList);
                                }
                            }
                        }
                        ArrayList<String> arrayList4 = new ArrayList(hashSet2);
                        arrayList4.removeAll(hashSet3);
                        ArrayList<String> arrayList5 = new ArrayList(hashSet);
                        arrayList5.removeAll(hashSet3);
                        if (arrayList5.size() > 0) {
                            for (String str : arrayList5) {
                                this.myDBClass.getuserhistorydao().delete(str + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                                this.myDBClass.getuserhistorydao().delete_right(MqttTopic.MULTI_LEVEL_WILDCARD + str, MakeMyExam.userId);
                            }
                        }
                        if (arrayList4.size() > 0) {
                            for (String str2 : arrayList4) {
                                List<VideosDownload> list = this.myDBClass.getvideoDownloadao().getcourse_expire(MqttTopic.MULTI_LEVEL_WILDCARD + str2, MakeMyExam.userId);
                                if (list != null && list.size() > 0) {
                                    for (VideosDownload videosDownload : list) {
                                        File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                                        File file2 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        this.myDBClass.getvideoDownloadao().delete(videosDownload.getVideo_id(), videosDownload.getCourse_id(), MakeMyExam.userId);
                                    }
                                }
                                List<VideosDownload> list2 = this.myDBClass.getvideoDownloadao().getcourse_expire_left(str2 + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                                if (list2 != null && list2.size() > 0) {
                                    for (VideosDownload videosDownload2 : list2) {
                                        File file3 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload2.getVideo_history() + ".mp4");
                                        File file4 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload2.getVideo_history() + ".mp4");
                                        if (file3.exists()) {
                                            file3.delete();
                                        }
                                        if (file4.exists()) {
                                            file4.delete();
                                        }
                                        this.myDBClass.getvideoDownloadao().delete(videosDownload2.getVideo_id(), videosDownload2.getCourse_id(), MakeMyExam.userId);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.myDBClass.getMyCourseDao().deletedata();
                if (this.myDBClass.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_012")) {
                    this.myDBClass.getapidao().update_api_version("ut_012", MakeMyExam.userId, String.valueOf(jsonstring.optLong("time")), String.valueOf(jsonstring.optLong("interval")), String.valueOf(jsonstring.optLong("cd_time")));
                } else {
                    APITABLE apitable2 = new APITABLE();
                    apitable2.setApicode("ut_012");
                    apitable2.setApiname("get_my_courses");
                    apitable2.setInterval(String.valueOf(jsonstring.optLong("interval")));
                    apitable2.setUser_id(MakeMyExam.getUserId());
                    apitable2.setTimestamp(String.valueOf(jsonstring.optLong("time")));
                    apitable2.setCdtimestamp(String.valueOf(jsonstring.optLong("cd_time")));
                    apitable2.setVersion("0.000");
                    this.myDBClass.getapidao().addUser(apitable2);
                }
                this.mainCover.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                this.pullToReferesh.setEnabled(false);
                if (GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        RelativeLayout relativeLayout = this.mainCover;
        if (relativeLayout == null || this.no_data_found_RL == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        OnPaymentError("" + i + "~!@#$%^&" + s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnPaymentError(String failure) {
        if (this.view_pager.getCurrentItem() == 1) {
            if (this.freeFragment.paidCourseAdapter != null) {
                this.freeFragment.paidCourseAdapter.update_payment(failure);
            }
        } else {
            if (this.view_pager.getCurrentItem() == 0) {
                if (this.paidFragment.paidCourseAdapter != null) {
                    this.paidFragment.paidCourseAdapter.update_payment(failure);
                    return;
                } else {
                    this.paidFragment.setPaidCourseAdapter(this, this.myCourse.getPaid_course(), this.myCourse.getTime());
                    this.paidFragment.paidCourseAdapter.update_payment(failure);
                    return;
                }
            }
            if (this.view_pager.getCurrentItem() != 2 || this.batchFragment.paidCourseAdapter == null) {
                return;
            }
            this.batchFragment.paidCourseAdapter.update_payment(failure);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        try {
            if (this.view_pager.getCurrentItem() == 1) {
                if (this.freeFragment.paidCourseAdapter != null) {
                    this.freeFragment.paidCourseAdapter.update_payment(s);
                }
            } else {
                if (this.view_pager.getCurrentItem() == 0) {
                    if (this.paidFragment.paidCourseAdapter != null) {
                        this.paidFragment.paidCourseAdapter.update_payment(s);
                        return;
                    } else {
                        this.paidFragment.setPaidCourseAdapter(this, this.myCourse.getPaid_course(), this.myCourse.getTime());
                        this.paidFragment.paidCourseAdapter.update_payment(s);
                        return;
                    }
                }
                if (this.view_pager.getCurrentItem() != 2 || this.batchFragment.paidCourseAdapter == null) {
                    return;
                }
                this.batchFragment.paidCourseAdapter.update_payment(s);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;

        public ViewPagerAdapter(FragmentManager fm) {
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.appnew.android.home.Constants.IS_FROM_LIBRARY = false;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if ("1".equalsIgnoreCase("7") && BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses") && this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomLL.setVisibility(0);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            this.bottomLL.removeAllViews();
            ArrayList<View> arrayList = this.viewArrayList;
            if (arrayList != null) {
                arrayList.clear();
            }
            for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "3"));
            }
        }
    }

    public LinearLayout initBottomView(Menu menu, String str) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.home.Activity.MyLibraryActivty.8
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                onResourceReady((Bitmap) resource, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                imageView.setImageBitmap(resource);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        layoutParams.setMargins(0, 10, 0, 0);
        layoutParams.setLayoutDirection(0);
        linearLayout.setLayoutParams(layoutParams);
        textView.setGravity(17);
        linearLayout.setTag(menu);
        this.viewArrayList.add(linearLayout);
        if (menu.getId().equalsIgnoreCase(str)) {
            relativeLayout.setVisibility(0);
        }
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.myDBClass.getMyCourseDao().isRecordExists(MakeMyExam.userId)) {
            this.mycourseTables = this.myDBClass.getMyCourseDao().getAllUser();
            this.myCourse = new MyCourse();
            ArrayList<Courselist> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList<Courselist> arrayList4 = new ArrayList<>();
            for (MycourseTable mycourseTable : this.mycourseTables) {
                Courselist courselist = new Courselist();
                courselist.setId(mycourseTable.getId());
                courselist.setTitle(mycourseTable.getTitle());
                courselist.setBatch_id(mycourseTable.getBatch_id());
                courselist.setCover_image(mycourseTable.getCover_image());
                courselist.setDescHeaderImage(mycourseTable.getDescHeaderImage());
                courselist.setCat_type(mycourseTable.getCat_type());
                courselist.setExpiry_date(mycourseTable.getExpiry_date());
                courselist.setIs_activated(mycourseTable.getIs_activated());
                courselist.setPurchase_date(mycourseTable.getPurchase_date());
                courselist.setMrp(mycourseTable.getMrp());
                courselist.setTxn_id(mycourseTable.getTxn_id());
                courselist.setCombo_course_ids(mycourseTable.getCombo_course_ids());
                courselist.setContent_type(mycourseTable.getContent_type());
                courselist.setViewType(mycourseTable.getViewType());
                if (!TextUtils.isEmpty(courselist.getBatch_id()) && !courselist.getBatch_id().equalsIgnoreCase("0")) {
                    courselist.setPrices(null);
                    courselist.setExpiry_date("0");
                    courselist.setDelete(0);
                    arrayList4.add(courselist);
                } else if (courselist.getMrp().equalsIgnoreCase("0")) {
                    courselist.setDelete(1);
                    if (mycourseTable.getPrices() != null && mycourseTable.getPrices().size() > 0) {
                        courselist.setPrices(mycourseTable.getPrices());
                    }
                    courselist.setLastread(mycourseTable.getLastread());
                    arrayList3.add(courselist);
                } else if (Integer.parseInt(courselist.getMrp()) > 0) {
                    courselist.setDelete(0);
                    if (mycourseTable.getPrices() != null && mycourseTable.getPrices().size() > 0) {
                        courselist.setPrices(mycourseTable.getPrices());
                    }
                    courselist.setLastread(mycourseTable.getLastread());
                    arrayList2.add(courselist);
                }
                arrayList.add(courselist);
            }
            this.myCourse.setData(arrayList);
            this.myCourse.setBatchcourse(arrayList4);
            this.myCourse.setFreecourse(arrayList3);
            this.myCourse.setPaid_course(arrayList2);
            setupViewPager();
        } else {
            this.networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
        }
        MyCourse myCourse = this.myCourse;
        if (myCourse != null) {
            if (myCourse.getData() != null && this.myCourse.getData().size() > 0) {
                this.mainCover.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                return;
            } else {
                this.mainCover.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                return;
            }
        }
        this.networkCall.NetworkAPICall(API.get_my_courses, "", true, false);
    }
}
