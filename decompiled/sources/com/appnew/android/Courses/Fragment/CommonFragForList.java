package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.AllCoursesAdapater;
import com.appnew.android.Courses.Adapter.CommonListAdapter;
import com.appnew.android.Courses.Adapter.IBTPracticeViewAllAdapter;
import com.appnew.android.Courses.Interfaces.OnMyCartItemListener;
import com.appnew.android.Courses.Modal.CartItems;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Basic;
import com.appnew.android.Model.Courses.Course;
import com.appnew.android.Model.Courses.CourseCategory;
import com.appnew.android.Model.Courses.CoursesData;
import com.appnew.android.Model.Courses.FAQ;
import com.appnew.android.Model.Courses.SinglestudyModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Model.PoJoModel.CatDataOnePOJO;
import com.appnew.android.Model.PoJoModel.SingleStudyPOJO;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CommonFragForList extends MainFragment implements OnMyCartItemListener {
    private static final String TAG = "CommonFragForList";
    Activity activity;
    IBTPracticeViewAllAdapter adapter;
    AllCoursesAdapater allCoursesAdapater;
    public String apiType;
    RelativeLayout buttonLow;
    TextView buyNowBtn;
    CommonListAdapter commonListAdapter;
    private RecyclerView commonListRV;
    Course course;
    ArrayList<Course> courseArrayList;
    ArrayList<Courselist> courseArrayLists;
    CourseCategory courseCategory;
    ArrayList<CoursesData> coursesDataArrayList;
    public String emiCourseId;
    private TextView errorTV;
    ArrayList<FAQ> faqArrayList;
    public int firstVisibleItem;
    public String last_category_id;
    public String last_course_id;
    public String last_test_id;
    LinearLayoutManager linearLayoutManager;
    TextView mrpCutTV;
    public int previousTotalItemCount;
    TextView price;
    LinearLayout priceLL;
    ArrayList<ResultTestSeries> resultTestSeriesArrayList;
    ArrayList<Course> searchArrayList;
    private String searchContent;
    public int totalItemCount;
    public int visibleItemCount;
    public String frag_type = "";
    public String errorMessage = "";
    public boolean isSearching = false;
    int isalreadyconnected = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    private String courseIds = "";
    ArrayList<SinglestudyModel> singlestudyModels = new ArrayList<>();

    public static CommonFragForList newInstance(String frag_type, String courseId) {
        CommonFragForList commonFragForList = new CommonFragForList();
        Bundle bundle = new Bundle();
        bundle.putSerializable("course_id", courseId);
        bundle.putString(Const.FRAG_TYPE, frag_type);
        commonFragForList.setArguments(bundle);
        return commonFragForList;
    }

    public static CommonFragForList newInstance(String frag_type, CourseCategory courseCategory) {
        CommonFragForList commonFragForList = new CommonFragForList();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.CATEGORY, courseCategory);
        bundle.putString(Const.FRAG_TYPE, frag_type);
        commonFragForList.setArguments(bundle);
        return commonFragForList;
    }

    public static CommonFragForList newInstance(String frag_type, CourseCategory courseCategory, String searchKeyword) {
        CommonFragForList commonFragForList = new CommonFragForList();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.CATEGORY, courseCategory);
        bundle.putString(Const.FRAG_TYPE, frag_type);
        bundle.putString(Const.SEARCH_CONTENT, searchKeyword);
        commonFragForList.setArguments(bundle);
        return commonFragForList;
    }

    public static CommonFragForList newInstance(String frag_type, Course course) {
        CommonFragForList commonFragForList = new CommonFragForList();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.COURSES, course);
        bundle.putString(Const.FRAG_TYPE, frag_type);
        commonFragForList.setArguments(bundle);
        return commonFragForList;
    }

    public static CommonFragForList newInstance(String frag_type) {
        CommonFragForList commonFragForList = new CommonFragForList();
        Bundle bundle = new Bundle();
        bundle.putString(Const.FRAG_TYPE, frag_type);
        commonFragForList.setArguments(bundle);
        return commonFragForList;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.faqArrayList = new ArrayList<>();
        this.courseArrayList = new ArrayList<>();
        this.courseArrayLists = new ArrayList<>();
        this.searchArrayList = new ArrayList<>();
        this.coursesDataArrayList = new ArrayList<>();
        this.resultTestSeriesArrayList = new ArrayList<>();
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.emiCourseId = getArguments().getString("course_id");
            this.courseCategory = (CourseCategory) getArguments().getSerializable(Const.CATEGORY);
            this.course = (Course) getArguments().getSerializable(Const.COURSES);
            if (getArguments().containsKey(Const.SEARCH_CONTENT)) {
                this.searchContent = getArguments().getString(Const.SEARCH_CONTENT);
            }
        }
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.commonListRV.setLayoutManager(linearLayoutManager);
        if (!this.frag_type.equals(Const.MYCART) || !this.frag_type.equals(Const.MYCART)) {
            getDatas(true);
        }
        this.commonListRV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Courses.Fragment.CommonFragForList.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                CommonFragForList commonFragForList = CommonFragForList.this;
                commonFragForList.visibleItemCount = commonFragForList.linearLayoutManager.getChildCount();
                CommonFragForList commonFragForList2 = CommonFragForList.this;
                commonFragForList2.totalItemCount = commonFragForList2.linearLayoutManager.getItemCount();
                CommonFragForList commonFragForList3 = CommonFragForList.this;
                commonFragForList3.firstVisibleItem = commonFragForList3.linearLayoutManager.findFirstVisibleItemPosition();
                if (CommonFragForList.this.totalItemCount >= 10) {
                    if (CommonFragForList.this.loading && CommonFragForList.this.totalItemCount > CommonFragForList.this.previousTotalItemCount) {
                        CommonFragForList.this.loading = false;
                        CommonFragForList commonFragForList4 = CommonFragForList.this;
                        commonFragForList4.previousTotalItemCount = commonFragForList4.totalItemCount;
                    }
                    if (CommonFragForList.this.loading || CommonFragForList.this.totalItemCount - CommonFragForList.this.visibleItemCount > CommonFragForList.this.firstVisibleItem + CommonFragForList.this.visibleThreshold) {
                        return;
                    }
                    int i = 0;
                    while (i < CommonFragForList.this.totalItemCount) {
                        if (CommonFragForList.this.isSearching) {
                            CommonFragForList commonFragForList5 = CommonFragForList.this;
                            commonFragForList5.last_course_id = commonFragForList5.searchArrayList.get((CommonFragForList.this.totalItemCount - 1) - i).getId();
                        }
                        i = CommonFragForList.this.totalItemCount;
                    }
                    if (CommonFragForList.this.isalreadyconnected == 0 && CommonFragForList.this.isSearching) {
                        CommonFragForList.this.getDatas(false);
                        CommonFragForList.this.isalreadyconnected = 1;
                    }
                    CommonFragForList.this.loading = true;
                }
            }
        });
        this.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CommonFragForList.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                    Toast.makeText(CommonFragForList.this.activity, CommonFragForList.this.activity.getResources().getString(R.string.guest_login_toast), 0).show();
                    return;
                }
                Intent intent = new Intent(CommonFragForList.this.activity, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.COURSE_INVOICE);
                intent.putExtra(Const.EMI_TYPE, Const.EMI_FULL);
                intent.putExtra(Const.SINGLE_STUDY, CommonFragForList.this.singlestudyModels);
                CommonFragForList.this.startActivity(intent);
            }
        });
    }

    public void initButton(ArrayList<Courselist> course) {
        if (course.size() > 0) {
            setBasicData(course);
            if (this.frag_type.equals(Const.MYCART)) {
                this.buttonLow.setVisibility(0);
            } else {
                this.buttonLow.setVisibility(8);
            }
            Iterator<Courselist> it = course.iterator();
            float f2 = 0.0f;
            while (it.hasNext()) {
                f2 += Float.parseFloat(it.next().getCourseSp());
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.priceLL.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.priceLL.setLayoutParams(layoutParams);
            this.buyNowBtn.setText(this.activity.getResources().getString(R.string.checkout_now));
            this.mrpCutTV.setVisibility(8);
            this.price.setText(this.activity.getResources().getString(R.string.total_amount) + Constants.currencyType + "" + f2 + "/-");
            return;
        }
        this.buttonLow.setVisibility(8);
    }

    public void setBasicData(ArrayList<Courselist> course) {
        this.singlestudyModels = new ArrayList<>();
        for (Courselist courselist : course) {
            this.singlestudyModels.add(new SinglestudyModel(new Basic(courselist.getCover_image(), courselist.getId(), courselist.getTitle(), courselist.getCourseSp(), courselist.getDescHeaderImage(), courselist.getCourseAttribute(), courselist.getValidity(), courselist.getPayment_type(), courselist.getColorCode(), "", courselist.getMrp(), courselist.getCourseAttribute(), "", "", courselist.getIs_postal_available(), courselist.getHolderType(), "")));
        }
    }

    public void getDatas(boolean show) {
        if (this.isSearching) {
            NetworkAPICall(API.API_SEARCH_COURSE, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.ALLCOURSES)) {
            NetworkAPICall(API.API_GET_LANDING_PAGE_DATA, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.SEEALL_COURSE)) {
            NetworkAPICall(API.API_GET_ALL_CATEGORY_DATA, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.MYCOURSES)) {
            NetworkAPICall(API.API_GET_MY_COURSE_DATA, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.FAQ)) {
            NetworkAPICall(API.API_GET_FAQ_DATA, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.LEADERBOARD)) {
            NetworkAPICall(API.API_GET_USER_GIVEN_TESTSERIES, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.PRACTICE)) {
            NetworkAPICall(API.API_SEARCH_COURSE, "", show, false, false);
            return;
        }
        if (this.frag_type.equals(Const.SEARCH_COURSE)) {
            NetworkAPICall(API.API_SEARCH_COURSE_EXAM, "", show, false, false);
        } else if (this.frag_type.equals(Const.MYCART)) {
            NetworkAPICall(API.API_CART_COURSE_EXAM, "", show, false, false);
        } else if (this.frag_type.equals(Const.MYEMICOURSES)) {
            NetworkAPICall(API.API_GET_BASIC_COURSE, "", show, false, false);
        }
    }

    private void initViews(View view) {
        this.commonListRV = (RecyclerView) view.findViewById(R.id.courseListRV);
        this.errorTV = (TextView) view.findViewById(R.id.errorTV);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (TextView) view.findViewById(R.id.buyNowBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.activity = getActivity();
        if (this.frag_type.equals(Const.MYCART)) {
            ArrayList<CartItems> myCourseCart = Helper.getMyCourseCart(this.activity);
            ArrayList arrayList = new ArrayList();
            if (myCourseCart.size() >= 1) {
                Iterator<CartItems> it = myCourseCart.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getCourse_id());
                }
                this.courseIds = TextUtils.join(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA, arrayList);
            } else {
                this.courseIds = "";
            }
            getDatas(true);
            if (SharedPreference.getInstance().getBoolean(Const.IS_PAYMENT_DONE)) {
                this.buttonLow.setVisibility(8);
                SharedPreference.getInstance().putBoolean(Const.SINGLE_STUDY, true);
            }
        } else {
            this.buttonLow.setVisibility(8);
        }
        super.onResume();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_multi_courses_by_id":
                return service.cartCourseExam(this.courseIds);
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_landing_page_data":
                return service.getLandingPageData();
            case "https://appapi.videocrypt.in/index.php/data_model/courses/Test_series/get_user_given_test_series":
                return service.getUserGivenTestSeries(SharedPreference.getInstance().getLoggedInUser().getId());
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/search_course":
                return service.searchCourse(this.searchContent, this.last_course_id);
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_faq":
                return service.getFaqData(SharedPreference.getInstance().getLoggedInUser().getId(), this.course.getId());
            case "https://appapi.videocrypt.in/index.php/data_model/courses/exam/get_basic_data":
                return service.getBasicCourse(AES.encrypt(new Gson().toJson(new SingleStudyPOJO(this.emiCourseId, ""))));
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_all_category_data":
                return service.getAllCategoryData(AES.encrypt(new Gson().toJson(new CatDataOnePOJO(this.courseCategory.getId()))));
            case "https://appapi.videocrypt.in/index.php/data_model/courses/my_courses/get_list_of_my_courses":
                return service.getMyCourseData();
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/search_course_exam":
                return service.searchCourseExam(SharedPreference.getInstance().getLoggedInUser().getId(), this.searchContent, this.last_course_id);
            default:
                return null;
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson;
        int i;
        gson = new Gson();
        apitype.hashCode();
        i = 0;
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_multi_courses_by_id":
                this.isalreadyconnected = 0;
                JSONArray jSONArrayOptJSONArray = jsonobject.optJSONArray("data");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    this.courseArrayLists = new ArrayList<>();
                    while (i < jSONArrayOptJSONArray.length()) {
                        this.courseArrayLists.add((Courselist) new Gson().fromJson(jSONArrayOptJSONArray.get(i).toString(), Courselist.class));
                        i++;
                    }
                } else {
                    this.courseArrayLists = new ArrayList<>();
                    this.errorMessage = jsonobject.optString("message");
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitMyCourseAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_landing_page_data":
                if (jsonobject.optString("status").equals("true")) {
                    JSONArray jSONArray = jsonobject.getJSONArray("data");
                    this.coursesDataArrayList = new ArrayList<>();
                    while (i < jSONArray.length()) {
                        this.coursesDataArrayList.add((CoursesData) gson.fromJson(jSONArray.get(i).toString(), CoursesData.class));
                        i++;
                    }
                } else {
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitLandingPageAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/Test_series/get_user_given_test_series":
                this.isalreadyconnected = 0;
                if (jsonobject.optString("status").equals("true")) {
                    JSONArray jSONArray2 = jsonobject.getJSONArray("data");
                    this.resultTestSeriesArrayList = new ArrayList<>();
                    while (i < jSONArray2.length()) {
                        this.resultTestSeriesArrayList.add((ResultTestSeries) gson.fromJson(jSONArray2.getJSONObject(i).toString(), ResultTestSeries.class));
                        i++;
                    }
                } else {
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitMyTestSeriesAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/search_course":
                this.isalreadyconnected = 0;
                if (jsonobject.optString("status").equals("true")) {
                    JSONArray jSONArray3 = jsonobject.getJSONArray("data");
                    if (TextUtils.isEmpty(this.last_course_id)) {
                        this.searchArrayList = new ArrayList<>();
                    }
                    while (i < jSONArray3.length()) {
                        this.searchArrayList.add((Course) gson.fromJson(jSONArray3.get(i).toString(), Course.class));
                        i++;
                    }
                } else {
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitSearchCourseAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_faq":
                if (jsonobject.optString("status").equals("true")) {
                    JSONArray jSONArray4 = jsonobject.getJSONArray("data");
                    this.faqArrayList = new ArrayList<>();
                    while (i < jSONArray4.length()) {
                        this.faqArrayList.add((FAQ) gson.fromJson(jSONArray4.get(i).toString(), FAQ.class));
                        i++;
                    }
                } else {
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitFaqAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/exam/get_basic_data":
                this.isalreadyconnected = 0;
                if (jsonobject.optString("status").equals("true")) {
                    Helper.buyNowCourses(this.activity, (SinglestudyModel) gson.fromJson(jsonobject.optString("data"), SinglestudyModel.class));
                    this.activity.finish();
                    break;
                } else {
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/get_all_category_data":
                this.isalreadyconnected = 0;
                if (jsonobject.optString("status").equals("true")) {
                    JSONArray jSONArray5 = jsonobject.getJSONObject("data").getJSONArray(Const.COURSE_LIST);
                    this.courseArrayList = new ArrayList<>();
                    while (i < jSONArray5.length()) {
                        this.courseArrayList.add((Course) gson.fromJson(jSONArray5.get(i).toString(), Course.class));
                        i++;
                    }
                } else {
                    this.errorMessage = jsonobject.optString("message");
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitMyCourseAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/my_courses/get_list_of_my_courses":
                this.isalreadyconnected = 0;
                if (jsonobject.optString("status").equals("true")) {
                    JSONArray jSONArray6 = jsonobject.getJSONObject("data").getJSONArray(Const.COURSE_LIST);
                    this.courseArrayLists = new ArrayList<>();
                    while (i < jSONArray6.length()) {
                        this.courseArrayLists.add((Courselist) gson.fromJson(jSONArray6.get(i).toString(), Courselist.class));
                        i++;
                    }
                } else {
                    this.errorMessage = jsonobject.optString("message");
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitMyCourseAdapter();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/courses/course/search_course_exam":
                this.isalreadyconnected = 0;
                JSONArray jSONArrayOptJSONArray2 = jsonobject.optJSONArray("data");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    if (TextUtils.isEmpty(this.last_course_id)) {
                        this.courseArrayLists = new ArrayList<>();
                    }
                    while (i < jSONArrayOptJSONArray2.length()) {
                        this.courseArrayLists.add((Courselist) new Gson().fromJson(jSONArrayOptJSONArray2.get(i).toString(), Courselist.class));
                        i++;
                    }
                    ArrayList<Courselist> arrayList = this.courseArrayLists;
                    this.last_course_id = arrayList.get(arrayList.size() - 1).getId();
                } else {
                    this.errorMessage = jsonobject.optString("message");
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                if (jsonobject.optString("auth_code") == null || !jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    InitMyCourseAdapter();
                    break;
                }
                break;
        }
    }

    private void InitFaqAdapter() {
        if (this.faqArrayList.size() > 0) {
            CommonListAdapter commonListAdapter = new CommonListAdapter(this.activity, this.frag_type, this.faqArrayList);
            this.commonListAdapter = commonListAdapter;
            this.commonListRV.setAdapter(commonListAdapter);
            this.errorTV.setVisibility(8);
            this.commonListRV.setVisibility(0);
            return;
        }
        this.errorTV.setText(this.errorMessage);
        this.errorTV.setVisibility(0);
        this.commonListRV.setVisibility(8);
    }

    private void InitLandingPageAdapter() {
        if (this.coursesDataArrayList.size() > 0) {
            AllCoursesAdapater allCoursesAdapater = new AllCoursesAdapater(this.activity, this.coursesDataArrayList, this);
            this.allCoursesAdapater = allCoursesAdapater;
            this.commonListRV.setAdapter(allCoursesAdapater);
            this.errorTV.setVisibility(8);
            this.commonListRV.setVisibility(0);
            return;
        }
        this.errorTV.setText(this.errorMessage);
        this.errorTV.setVisibility(0);
        this.commonListRV.setVisibility(8);
    }

    private void InitMyTestSeriesAdapter() {
        if (TextUtils.isEmpty(this.last_test_id)) {
            if (this.resultTestSeriesArrayList.size() > 0) {
                CommonListAdapter commonListAdapter = new CommonListAdapter(this.activity, this.resultTestSeriesArrayList);
                this.commonListAdapter = commonListAdapter;
                this.commonListRV.setAdapter(commonListAdapter);
                this.errorTV.setVisibility(8);
                this.commonListRV.setVisibility(0);
                return;
            }
            this.errorTV.setText(this.errorMessage);
            this.errorTV.setVisibility(0);
            this.commonListRV.setVisibility(8);
            return;
        }
        this.commonListAdapter.notifyDataSetChanged();
    }

    private void InitMyCourseAdapter() {
        if (this.courseArrayLists.size() > 0) {
            IBTPracticeViewAllAdapter iBTPracticeViewAllAdapter = new IBTPracticeViewAllAdapter(this.activity, this.courseArrayLists, true, false, this.frag_type, this);
            this.adapter = iBTPracticeViewAllAdapter;
            this.commonListRV.setAdapter(iBTPracticeViewAllAdapter);
            this.errorTV.setVisibility(8);
            this.commonListRV.setVisibility(0);
            if (this.frag_type.equals(Const.MYCART)) {
                initButton(this.courseArrayLists);
                return;
            }
            return;
        }
        if (this.frag_type.equals(Const.MYCART)) {
            initButton(this.courseArrayLists);
        }
        if (this.errorMessage.contains("Course not found.")) {
            this.errorTV.setText(this.activity.getResources().getString(R.string.course_not_found));
        } else if (this.errorMessage.contains("Something went wrong")) {
            Toast.makeText(this.activity, this.errorMessage, 0).show();
        } else {
            this.errorTV.setText(this.errorMessage);
        }
        this.errorTV.setVisibility(0);
        this.commonListRV.setVisibility(8);
    }

    private void InitSearchCourseAdapter() {
        if (TextUtils.isEmpty(this.last_course_id)) {
            if (this.searchArrayList.size() > 0) {
                IBTPracticeViewAllAdapter iBTPracticeViewAllAdapter = new IBTPracticeViewAllAdapter(this.activity, this.searchArrayList);
                this.adapter = iBTPracticeViewAllAdapter;
                this.commonListRV.setAdapter(iBTPracticeViewAllAdapter);
                this.errorTV.setVisibility(8);
                this.commonListRV.setVisibility(0);
                return;
            }
            this.errorTV.setText(this.errorMessage);
            this.errorTV.setVisibility(0);
            this.commonListRV.setVisibility(8);
            return;
        }
        this.adapter.notifyDataSetChanged();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        this.errorMessage = jsonstring;
        this.apiType = apitype;
        switch (apitype.hashCode()) {
            case -1638930049:
                if (apitype.equals(API.API_GET_LANDING_PAGE_DATA)) {
                    InitLandingPageAdapter();
                }
                break;
            case -1283238836:
                if (apitype.equals(API.API_GET_USER_GIVEN_TESTSERIES)) {
                    InitMyTestSeriesAdapter();
                }
                break;
            case -1114656888:
                apitype.equals(API.API_SEARCH_COURSE);
                break;
            case -998472669:
                if (apitype.equals(API.API_GET_FAQ_DATA)) {
                    InitFaqAdapter();
                }
                break;
            case -379038086:
                if (apitype.equals(API.API_GET_ALL_CATEGORY_DATA)) {
                    InitMyCourseAdapter();
                }
                break;
            case -351951179:
                if (apitype.equals(API.API_GET_MY_COURSE_DATA)) {
                    InitMyCourseAdapter();
                }
                break;
        }
        try {
            if (jsonstring.equalsIgnoreCase(this.activity.getResources().getString(R.string.internet_error_message))) {
                Activity activity = this.activity;
                Toast.makeText(activity, activity.getResources().getString(R.string.internet_error_message), 0).show();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Courses.Interfaces.OnMyCartItemListener
    public void onMyCartDeleteClick(Courselist courselist) {
        Helper.addToMyCartCourses(this.activity, new CartItems(SharedPreference.getInstance().getLoggedInUser().getId(), courselist.getId()), false, false, null);
        onResume();
    }
}
