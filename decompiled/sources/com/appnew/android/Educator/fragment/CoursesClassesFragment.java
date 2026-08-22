package com.appnew.android.Educator.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Educator.adpter.EduCCAdapter;
import com.appnew.android.Educator.adpter.EducatorCourseListAdapter;
import com.appnew.android.Educator.model.EduClassCourseItem;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Educator.FreeLiveClasses;
import com.appnew.android.Model.Educator.PaidLiveClasses;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.imagecropper.RotateBitmap;
import com.appnew.android.home.liveclasses.Datum;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CoursesClassesFragment extends Fragment implements NetworkCall.MyNetworkCallBack {
    private static final String TYPES = "";
    private static int page = 1;
    ArrayList<Courselist> courseList;
    private EduCCAdapter eduCCAdapter;
    private EducatorCourseListAdapter educatorCourseListAdapter;
    private String educatorId;
    private RecyclerView educatorRecyclerView1;
    private TextView filterText_name;
    private ImageView filterVideo;
    ArrayList<Datum> freeClassList;
    FreeLiveClasses freeLiveClasses;
    private boolean isLiveClass;
    private String listType;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    RelativeLayout noDataFound;
    ArrayList<Datum> oldArrayList;
    private ProgressBar paginationLoader;
    PaidLiveClasses paidLiveClasses;
    private ArrayList<EduClassCourseItem> eduClassCourseItemsList = new ArrayList<>();
    private String classType = "";
    private boolean isPaginationAvailable = true;
    boolean paginationStatus = false;
    boolean isApiHitForUpdatingTheData = false;
    int oldArraySize = 0;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.listType = getArguments().getString("");
            this.educatorId = getArguments().getString("educatorId");
            this.freeClassList = (ArrayList) getArguments().getSerializable("DataList");
            this.courseList = (ArrayList) getArguments().getSerializable("CourseList");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_courses_classes, container, false);
        this.educatorRecyclerView1 = (RecyclerView) viewInflate.findViewById(R.id.educatorRecyclerView1);
        this.filterVideo = (ImageView) viewInflate.findViewById(R.id.filterVideo);
        this.filterText_name = (TextView) viewInflate.findViewById(R.id.filterText_name);
        this.noDataFound = (RelativeLayout) viewInflate.findViewById(R.id.no_data_found_RL);
        this.nestedScrollView = (NestedScrollView) viewInflate.findViewById(R.id.nested_scroll_educator);
        this.paginationLoader = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
        this.networkCall = new NetworkCall(this, getContext());
        setDataList(viewInflate);
        OnScrollPage();
        Helper.applyPrimaryColorLight(getActivity(), this.filterText_name, 17.5f, R.drawable.tab_bg_select);
        return viewInflate;
    }

    private void OnScrollPage() {
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Educator.fragment.CoursesClassesFragment$$ExternalSyntheticLambda0
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                this.f$0.lambda$OnScrollPage$0(nestedScrollView, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$OnScrollPage$0(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        ProgressBar progressBar;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || (progressBar = this.paginationLoader) == null || progressBar.isShown() || !this.isPaginationAvailable || this.listType.equalsIgnoreCase("courses")) {
            return;
        }
        this.isApiHitForUpdatingTheData = true;
        this.paginationLoader.setVisibility(0);
        page++;
        this.paginationStatus = true;
        this.networkCall.NetworkAPICall(API.get_educators_list, "", false, false);
    }

    private void setDataList(View view) {
        ArrayList<Courselist> arrayList;
        if (this.listType.equalsIgnoreCase("free_classes") || this.listType.equalsIgnoreCase("live_classes")) {
            ArrayList<Datum> arrayList2 = this.freeClassList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.educatorRecyclerView1.setVisibility(0);
                this.filterText_name.setVisibility(0);
                this.filterText_name.setText("Live Classes");
                this.filterVideo.setVisibility(0);
                EduCCAdapter eduCCAdapter = new EduCCAdapter(getActivity(), this.freeClassList, this.listType);
                this.eduCCAdapter = eduCCAdapter;
                this.educatorRecyclerView1.setAdapter(eduCCAdapter);
                this.educatorRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
                this.eduCCAdapter.notifyDataSetChanged();
            } else {
                this.educatorRecyclerView1.setVisibility(8);
                this.noDataFound.setVisibility(0);
                this.filterVideo.setVisibility(0);
                this.filterText_name.setVisibility(0);
                this.filterText_name.setText("Live Classes");
            }
        } else if (this.listType.equalsIgnoreCase("courses") && (arrayList = this.courseList) != null && arrayList.size() > 0) {
            this.educatorRecyclerView1.setVisibility(0);
            EducatorCourseListAdapter educatorCourseListAdapter = new EducatorCourseListAdapter(getActivity(), this.courseList, this.listType);
            this.educatorCourseListAdapter = educatorCourseListAdapter;
            this.educatorRecyclerView1.setAdapter(educatorCourseListAdapter);
            this.educatorRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
            this.educatorCourseListAdapter.notifyDataSetChanged();
        } else {
            this.educatorRecyclerView1.setVisibility(8);
            this.noDataFound.setVisibility(0);
        }
        this.filterVideo.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.fragment.CoursesClassesFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PopupMenu popupMenu = new PopupMenu(CoursesClassesFragment.this.getActivity(), CoursesClassesFragment.this.filterVideo);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Educator.fragment.CoursesClassesFragment.1.1
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        CoursesClassesFragment.this.filterText_name.setVisibility(0);
                        if (menuItem.getTitle().equals("Live Classes")) {
                            CoursesClassesFragment.this.filterText_name.setText(menuItem.getTitle());
                            CoursesClassesFragment.this.classType = "0";
                        } else if (menuItem.getTitle().equals("Upcoming Classes")) {
                            CoursesClassesFragment.this.filterText_name.setText(menuItem.getTitle());
                            CoursesClassesFragment.this.classType = "1";
                        } else if (menuItem.getTitle().equals("Completed Classes")) {
                            CoursesClassesFragment.this.filterText_name.setText(menuItem.getTitle());
                            CoursesClassesFragment.this.classType = "2";
                        } else {
                            CoursesClassesFragment.this.filterText_name.setVisibility(8);
                            CoursesClassesFragment.this.classType = "";
                        }
                        CoursesClassesFragment.this.networkCall.NetworkAPICall(API.get_educators_list, "", true, false);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    public static CoursesClassesFragment newInstance(String types, ArrayList<Datum> freeClassList, ArrayList<Courselist> courseList, String educatorId) {
        CoursesClassesFragment coursesClassesFragment = new CoursesClassesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("", types);
        bundle.putSerializable("DataList", freeClassList);
        bundle.putSerializable("CourseList", courseList);
        bundle.putSerializable("educatorId", educatorId);
        coursesClassesFragment.setArguments(bundle);
        return coursesClassesFragment;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_educators_list)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setEducator_id(this.educatorId);
        encryptionData.setCourse_type(this.listType.equalsIgnoreCase("free_classes") ? "0" : "1");
        encryptionData.setType(this.classType);
        encryptionData.setPage(String.valueOf(page));
        return service.getEducatorDetails(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_educators_list)) {
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null && progressBar.isShown()) {
                this.paginationLoader.setVisibility(8);
            }
            if (jsonObject.optString("status").equals("true")) {
                if (this.listType.equalsIgnoreCase("live_classes")) {
                    PaidLiveClasses paidLiveClasses = (PaidLiveClasses) new Gson().fromJson(jsonObject.optJSONObject("data").optString("paid_live_classes"), PaidLiveClasses.class);
                    this.paidLiveClasses = paidLiveClasses;
                    setPaidClassList(paidLiveClasses.getData());
                    return;
                } else {
                    FreeLiveClasses freeLiveClasses = (FreeLiveClasses) new Gson().fromJson(jsonObject.optJSONObject("data").optString("free_live_classes"), FreeLiveClasses.class);
                    this.freeLiveClasses = freeLiveClasses;
                    setPaidClassList(freeLiveClasses.getData());
                    return;
                }
            }
            this.educatorRecyclerView1.setVisibility(8);
            this.noDataFound.setVisibility(0);
        }
    }

    private void setPaidClassList(ArrayList<Datum> liveClass) {
        if (liveClass != null && liveClass.size() > 0) {
            if (this.paginationStatus) {
                this.oldArraySize = liveClass.size();
                this.oldArrayList.addAll(liveClass);
                this.educatorRecyclerView1.setVisibility(0);
                this.noDataFound.setVisibility(8);
                this.filterVideo.setVisibility(0);
                this.eduCCAdapter = new EduCCAdapter(getActivity(), checkArrayList(this.oldArrayList), this.listType);
                this.educatorRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
                this.educatorRecyclerView1.setItemAnimator(new DefaultItemAnimator());
                this.educatorRecyclerView1.setAdapter(this.eduCCAdapter);
                try {
                    EduCCAdapter eduCCAdapter = this.eduCCAdapter;
                    if (eduCCAdapter != null) {
                        eduCCAdapter.notifyItemRangeInserted(this.oldArrayList.size() - 1, this.oldArrayList.size() - this.oldArraySize);
                        return;
                    }
                    return;
                } catch (IndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            this.oldArrayList = liveClass;
            this.educatorRecyclerView1.setVisibility(0);
            this.noDataFound.setVisibility(8);
            this.filterVideo.setVisibility(0);
            EduCCAdapter eduCCAdapter2 = new EduCCAdapter(getActivity(), liveClass, this.listType);
            this.eduCCAdapter = eduCCAdapter2;
            this.educatorRecyclerView1.setAdapter(eduCCAdapter2);
            this.educatorRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
            this.eduCCAdapter.notifyDataSetChanged();
            return;
        }
        this.educatorRecyclerView1.setVisibility(8);
        this.noDataFound.setVisibility(0);
    }

    private static ArrayList<Datum> checkArrayList(ArrayList<Datum> videoArrayList) {
        if (videoArrayList.size() > 40) {
            for (int i = 0; i < videoArrayList.size(); i++) {
                if (videoArrayList.size() > 40) {
                    videoArrayList.remove(0);
                }
            }
        }
        return videoArrayList;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        apitype.hashCode();
        if (apitype.equals(API.get_educators_list)) {
            Log.e(RotateBitmap.TAG, "ErrorCallBack: " + jsonstring);
        }
    }
}
