package Zoom.Fragment;

import Zoom.Adapter.QuestionBookMarkListAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.ZoomModel.QuestionData;
import com.appnew.android.Model.ZoomModel.QuestionDetail;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.Interface.BookmarkItem;
import com.appnew.android.Zoom.ItemClickListener;
import com.appnew.android.databinding.FragmentQuestionBookMarkBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: QuestionBookMark.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J$\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020P2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J.\u0010W\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u0001012\b\u0010Z\u001a\u0004\u0018\u0001012\u0006\u0010[\u001a\u00020\\H\u0016J,\u0010]\u001a\u00020L2\u0006\u0010^\u001a\u00020_2\b\u0010Y\u001a\u0004\u0018\u0001012\b\u0010Z\u001a\u0004\u0018\u0001012\u0006\u0010`\u001a\u00020\u001cH\u0016J&\u0010a\u001a\u00020L2\b\u0010^\u001a\u0004\u0018\u0001012\b\u0010Y\u001a\u0004\u0018\u0001012\b\u0010Z\u001a\u0004\u0018\u000101H\u0016J \u0010\u0019\u001a\u00020L2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.H\u0002J\b\u0010b\u001a\u00020LH\u0016J\u000e\u0010c\u001a\u00020L2\u0006\u0010d\u001a\u000201J\u0006\u0010e\u001a\u00020LJ\u0018\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u0002012\u0006\u0010h\u001a\u000201H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001a\u00109\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006i"}, d2 = {"LZoom/Fragment/QuestionBookMark;", "Landroidx/fragment/app/Fragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/Zoom/Interface/BookmarkItem;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentQuestionBookMarkBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentQuestionBookMarkBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentQuestionBookMarkBinding;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "QuebookMarkListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "LZoom/Adapter/QuestionBookMarkListAdapter$ViewHolder;", "getQuebookMarkListAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setQuebookMarkListAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "adapter", "LZoom/Adapter/QuestionBookMarkListAdapter;", "getAdapter", "()LZoom/Adapter/QuestionBookMarkListAdapter;", "setAdapter", "(LZoom/Adapter/QuestionBookMarkListAdapter;)V", "isPaginationAvailable", "", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "questionDetail", "Lcom/appnew/android/Model/ZoomModel/QuestionDetail;", "QuestionArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/QuestionData;", "Lkotlin/collections/ArrayList;", "QuestionArrayListSearch", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", Const.CONFIG_ID, "getConfig_id", "setConfig_id", "status", "getStatus", "()Z", "setStatus", "(Z)V", "time", "", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "itemClickListener", "Lcom/appnew/android/Zoom/ItemClickListener;", "getItemClickListener", "()Lcom/appnew/android/Zoom/ItemClickListener;", "setItemClickListener", "(Lcom/appnew/android/Zoom/ItemClickListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "onResume", "searchQuery", "query", "refreshPage", "onClick", "question_config_id", "possition", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuestionBookMark extends Fragment implements NetworkCall.MyNetworkCallBack, BookmarkItem {
    public static final int $stable = 8;
    private RecyclerView.Adapter<QuestionBookMarkListAdapter.ViewHolder> QuebookMarkListAdapter;
    private QuestionBookMarkListAdapter adapter;
    public FragmentQuestionBookMarkBinding binding;
    private String config_id;
    private ItemClickListener itemClickListener;
    private RecyclerView.LayoutManager layoutManager;
    private NetworkCall networkCall;
    private ProgressBar paginationLoader;
    private QuestionDetail questionDetail;
    private boolean status;
    private Long time;
    private String type;
    private boolean isPaginationAvailable = true;
    private ArrayList<QuestionData> QuestionArrayList = new ArrayList<>();
    private ArrayList<QuestionData> QuestionArrayListSearch = new ArrayList<>();

    public final FragmentQuestionBookMarkBinding getBinding() {
        FragmentQuestionBookMarkBinding fragmentQuestionBookMarkBinding = this.binding;
        if (fragmentQuestionBookMarkBinding != null) {
            return fragmentQuestionBookMarkBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentQuestionBookMarkBinding fragmentQuestionBookMarkBinding) {
        Intrinsics.checkNotNullParameter(fragmentQuestionBookMarkBinding, "<set-?>");
        this.binding = fragmentQuestionBookMarkBinding;
    }

    public final RecyclerView.Adapter<QuestionBookMarkListAdapter.ViewHolder> getQuebookMarkListAdapter() {
        return this.QuebookMarkListAdapter;
    }

    public final void setQuebookMarkListAdapter(RecyclerView.Adapter<QuestionBookMarkListAdapter.ViewHolder> adapter) {
        this.QuebookMarkListAdapter = adapter;
    }

    public final QuestionBookMarkListAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(QuestionBookMarkListAdapter questionBookMarkListAdapter) {
        this.adapter = questionBookMarkListAdapter;
    }

    public final ProgressBar getPaginationLoader() {
        return this.paginationLoader;
    }

    public final void setPaginationLoader(ProgressBar progressBar) {
        this.paginationLoader = progressBar;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getConfig_id() {
        return this.config_id;
    }

    public final void setConfig_id(String str) {
        this.config_id = str;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final ItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentQuestionBookMarkBinding.inflate(inflater, container, false));
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.QuestionArrayList = new ArrayList<>();
        this.QuestionArrayListSearch = new ArrayList<>();
        this.networkCall = new NetworkCall(this, getContext());
        this.layoutManager = new LinearLayoutManager(getContext());
        getBinding().queBookmarklistRecycler.setLayoutManager(this.layoutManager);
        Helper.showProgressDialog(getActivity());
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_GET_BOOKMARK_LIST)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setContent_type("0");
            return service.getBookmarkList(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.API_ADD_TO_BOOKMARK)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setContent_type("0");
        encryptionData2.setContent_id(this.config_id);
        encryptionData2.setIs_unbookmarked("1");
        return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_BOOKMARK_LIST)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    this.status = true;
                    this.QuestionArrayList.clear();
                    this.QuestionArrayListSearch.clear();
                    this.time = Long.valueOf(jsonstring.optLong("time"));
                    this.isPaginationAvailable = true;
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar != null) {
                        Intrinsics.checkNotNull(progressBar);
                        if (progressBar.isShown()) {
                            ProgressBar progressBar2 = this.paginationLoader;
                            Intrinsics.checkNotNull(progressBar2);
                            progressBar2.setVisibility(8);
                        }
                    }
                    if (this.status) {
                        QuestionDetail questionDetail = (QuestionDetail) new Gson().fromJson(jsonstring.toString(), QuestionDetail.class);
                        this.questionDetail = questionDetail;
                        Intrinsics.checkNotNull(questionDetail);
                        if (questionDetail.getData() != null) {
                            ArrayList<QuestionData> arrayList = this.QuestionArrayList;
                            QuestionDetail questionDetail2 = this.questionDetail;
                            Intrinsics.checkNotNull(questionDetail2);
                            arrayList.addAll(questionDetail2.getData());
                            ArrayList<QuestionData> arrayList2 = this.QuestionArrayListSearch;
                            QuestionDetail questionDetail3 = this.questionDetail;
                            Intrinsics.checkNotNull(questionDetail3);
                            arrayList2.addAll(questionDetail3.getData());
                            setAdapter(this.QuestionArrayList);
                            return;
                        }
                        return;
                    }
                    getBinding().questionBookmarkRL.setVisibility(0);
                    getBinding().queBookmarklistRecycler.setVisibility(8);
                    return;
                }
                getBinding().questionBookmarkRL.setVisibility(0);
                getBinding().queBookmarklistRecycler.setVisibility(8);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.API_ADD_TO_BOOKMARK)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    Toast.makeText(getActivity(), jsonstring.optString("message"), 0).show();
                } else {
                    Toast.makeText(getActivity(), jsonstring.optString("message"), 0).show();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (Intrinsics.areEqual(apitype, API.API_GET_BOOKMARK_LIST)) {
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null) {
                Intrinsics.checkNotNull(progressBar);
                if (progressBar.isShown()) {
                    ProgressBar progressBar2 = this.paginationLoader;
                    Intrinsics.checkNotNull(progressBar2);
                    progressBar2.setVisibility(8);
                }
            }
            if (getBinding().questionBookmarkRL != null) {
                getBinding().questionBookmarkRL.setVisibility(0);
                getBinding().queBookmarklistRecycler.setVisibility(8);
            }
        }
    }

    private final void setAdapter(ArrayList<QuestionData> QuestionArrayList) {
        this.type = "Question";
        ArrayList<QuestionData> arrayList = QuestionArrayList;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        String str = this.type;
        Intrinsics.checkNotNull(str);
        QuestionBookMark questionBookMark = this;
        this.QuebookMarkListAdapter = new QuestionBookMarkListAdapter(arrayList, fragmentActivityRequireActivity, str, questionBookMark);
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
        String str2 = this.type;
        Intrinsics.checkNotNull(str2);
        this.adapter = new QuestionBookMarkListAdapter(arrayList, fragmentActivityRequireActivity2, str2, questionBookMark);
        getBinding().queBookmarklistRecycler.setAdapter(this.QuebookMarkListAdapter);
        RecyclerView.Adapter<QuestionBookMarkListAdapter.ViewHolder> adapter = this.QuebookMarkListAdapter;
        Intrinsics.checkNotNull(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_BOOKMARK_LIST, "", false, false);
        }
    }

    public final void searchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.QuestionArrayListSearch.clear();
        String str = query;
        if (str.length() == 0) {
            setAdapter(this.QuestionArrayList);
            return;
        }
        for (QuestionData questionData : this.QuestionArrayList) {
            String question = questionData.getQuestion();
            Intrinsics.checkNotNullExpressionValue(question, "getQuestion(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = question.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains((CharSequence) lowerCase, (CharSequence) str, true)) {
                this.QuestionArrayListSearch.add(questionData);
            }
        }
        setAdapter(this.QuestionArrayListSearch);
    }

    public final void refreshPage() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_BOOKMARK_LIST, "", false, false);
        }
    }

    @Override // com.appnew.android.Zoom.Interface.BookmarkItem
    public void onClick(String question_config_id, String possition) {
        Intrinsics.checkNotNullParameter(question_config_id, "question_config_id");
        Intrinsics.checkNotNullParameter(possition, "possition");
        this.config_id = question_config_id;
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
    }
}
