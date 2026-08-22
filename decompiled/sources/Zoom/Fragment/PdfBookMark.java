package Zoom.Fragment;

import Zoom.Adapter.BookMarkListAdapter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.ZoomModel.PdfData;
import com.appnew.android.Model.ZoomModel.PdfDetail;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.FragmentPdfBookMarkBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: PdfBookMark.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u001a\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020H2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J.\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010&2\b\u0010R\u001a\u0004\u0018\u00010&2\u0006\u0010S\u001a\u00020TH\u0016J,\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020W2\b\u0010Q\u001a\u0004\u0018\u00010&2\b\u0010R\u001a\u0004\u0018\u00010&2\u0006\u0010X\u001a\u00020\u0011H\u0016J&\u0010Y\u001a\u00020D2\b\u0010V\u001a\u0004\u0018\u00010&2\b\u0010Q\u001a\u0004\u0018\u00010&2\b\u0010R\u001a\u0004\u0018\u00010&H\u0016J \u0010Z\u001a\u00020D2\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#H\u0002J\b\u0010\\\u001a\u00020DH\u0016J\u000e\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020&J\u0006\u0010_\u001a\u00020DR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006`"}, d2 = {"LZoom/Fragment/PdfBookMark;", "Landroidx/fragment/app/Fragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentPdfBookMarkBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentPdfBookMarkBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentPdfBookMarkBinding;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "bookMarkListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "LZoom/Adapter/BookMarkListAdapter$ViewHolder;", "isPaginationAvailable", "", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "pdfDetail", "Lcom/appnew/android/Model/ZoomModel/PdfDetail;", "pdfArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/PdfData;", "Lkotlin/collections/ArrayList;", "pdfArrayListSearch", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "status", "getStatus", "()Z", "setStatus", "(Z)V", "time", "", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "setAdapter", "pdfData", "onResume", "searchQuery", "query", "refreshPage", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PdfBookMark extends Fragment implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public FragmentPdfBookMarkBinding binding;
    private RecyclerView.Adapter<BookMarkListAdapter.ViewHolder> bookMarkListAdapter;
    public SharedPreferences.Editor editor;
    private RecyclerView.LayoutManager layoutManager;
    private NetworkCall networkCall;
    private ProgressBar paginationLoader;
    private PdfDetail pdfDetail;
    public SharedPreferences preferences;
    private boolean status;
    private Long time;
    private String type;
    private boolean isPaginationAvailable = true;
    private ArrayList<PdfData> pdfArrayList = new ArrayList<>();
    private ArrayList<PdfData> pdfArrayListSearch = new ArrayList<>();

    public final FragmentPdfBookMarkBinding getBinding() {
        FragmentPdfBookMarkBinding fragmentPdfBookMarkBinding = this.binding;
        if (fragmentPdfBookMarkBinding != null) {
            return fragmentPdfBookMarkBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentPdfBookMarkBinding fragmentPdfBookMarkBinding) {
        Intrinsics.checkNotNullParameter(fragmentPdfBookMarkBinding, "<set-?>");
        this.binding = fragmentPdfBookMarkBinding;
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

    public final SharedPreferences getPreferences() {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preferences");
        return null;
    }

    public final void setPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.preferences = sharedPreferences;
    }

    public final SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            return editor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editor");
        return null;
    }

    public final void setEditor(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "<set-?>");
        this.editor = editor;
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentPdfBookMarkBinding.inflate(inflater, container, false));
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.pdfArrayList = new ArrayList<>();
        this.pdfArrayListSearch = new ArrayList<>();
        this.networkCall = new NetworkCall(this, getContext());
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = getBinding().pdfBookmarkListRecycler;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(this.layoutManager);
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        Helper.showProgressDialog(getActivity());
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_GET_BOOKMARK_LIST)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setContent_type("1");
        return service.getBookmarkList(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_BOOKMARK_LIST)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    this.status = true;
                    this.pdfArrayList.clear();
                    this.pdfArrayListSearch.clear();
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
                        PdfDetail pdfDetail = (PdfDetail) new Gson().fromJson(jsonstring.toString(), PdfDetail.class);
                        this.pdfDetail = pdfDetail;
                        Intrinsics.checkNotNull(pdfDetail);
                        if (pdfDetail.getData() != null) {
                            ArrayList<PdfData> arrayList = this.pdfArrayList;
                            PdfDetail pdfDetail2 = this.pdfDetail;
                            Intrinsics.checkNotNull(pdfDetail2);
                            arrayList.addAll(pdfDetail2.getData());
                            ArrayList<PdfData> arrayList2 = this.pdfArrayListSearch;
                            PdfDetail pdfDetail3 = this.pdfDetail;
                            Intrinsics.checkNotNull(pdfDetail3);
                            arrayList2.addAll(pdfDetail3.getData());
                            setAdapter(this.pdfArrayList);
                            return;
                        }
                        return;
                    }
                    getBinding().noDataFoundRL.setVisibility(0);
                    getBinding().pdfBookmarkListRecycler.setVisibility(8);
                    return;
                }
                getBinding().noDataFoundRL.setVisibility(0);
                getBinding().pdfBookmarkListRecycler.setVisibility(8);
            } catch (Exception e2) {
                e2.printStackTrace();
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
            if (getBinding().noDataFoundRL != null) {
                getBinding().noDataFoundRL.setVisibility(0);
                getBinding().pdfBookmarkListRecycler.setVisibility(8);
            }
        }
    }

    private final void setAdapter(ArrayList<PdfData> pdfData) {
        this.type = "PDF";
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        String str = this.type;
        Intrinsics.checkNotNull(str);
        this.bookMarkListAdapter = new BookMarkListAdapter(pdfData, fragmentActivityRequireActivity, str);
        getBinding().pdfBookmarkListRecycler.setAdapter(this.bookMarkListAdapter);
        RecyclerView.Adapter<BookMarkListAdapter.ViewHolder> adapter = this.bookMarkListAdapter;
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
        this.pdfArrayListSearch.clear();
        String str = query;
        if (str.length() == 0) {
            setAdapter(this.pdfArrayList);
            return;
        }
        for (PdfData pdfData : this.pdfArrayList) {
            String title = pdfData.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = title.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains((CharSequence) lowerCase, (CharSequence) str, true)) {
                this.pdfArrayListSearch.add(pdfData);
            }
        }
        setAdapter(this.pdfArrayListSearch);
    }

    public final void refreshPage() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_BOOKMARK_LIST, "", false, false);
        }
    }
}
