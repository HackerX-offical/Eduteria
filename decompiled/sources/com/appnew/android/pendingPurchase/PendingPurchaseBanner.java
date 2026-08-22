package com.appnew.android.pendingPurchase;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.PendingPurchaseBannerLayoutBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.pendingPurchase.PendingPurchaseAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;

/* JADX INFO: compiled from: PendingPurchaseBanner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001f\u001a\u00020 J0\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\u00122\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J.\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\u00122\u0006\u0010*\u001a\u00020+H\u0016J&\u0010,\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002J\r\u0010/\u001a\u0004\u0018\u00010+¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020 J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/appnew/android/pendingPurchase/PendingPurchaseBanner;", "Landroid/widget/FrameLayout;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/appnew/android/databinding/PendingPurchaseBannerLayoutBinding;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "pendingPurchaseList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/Courselist;", "Lkotlin/collections/ArrayList;", "selectedCourseId", "", "selectedItemPosition", "", "Ljava/lang/Integer;", "pendingPurchaseAdapter", "Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter;", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "parentCourseId", "content_type", "mainCourseId", "cousedetail", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "setImageList", "", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "handleBuyNowClick", "courseDetail", "setUIOfBanner", "()Ljava/lang/Boolean;", "callApiToAddBanner", "isNetworkConnected", "updatePaddingAndTransformer", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PendingPurchaseBanner extends FrameLayout implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private final PendingPurchaseBannerLayoutBinding binding;
    private String content_type;
    private CourseDetail cousedetail;
    private String mainCourseId;
    private NetworkCall networkCall;
    private String parentCourseId;
    private PendingPurchaseAdapter pendingPurchaseAdapter;
    private ArrayList<Courselist> pendingPurchaseList;
    private String selectedCourseId;
    private Integer selectedItemPosition;
    private UtkashRoom utkashRoom;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PendingPurchaseBanner(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PendingPurchaseBanner(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingPurchaseBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        PendingPurchaseBannerLayoutBinding pendingPurchaseBannerLayoutBindingInflate = PendingPurchaseBannerLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(pendingPurchaseBannerLayoutBindingInflate, "inflate(...)");
        this.binding = pendingPurchaseBannerLayoutBindingInflate;
        this.parentCourseId = "";
        this.content_type = "";
        this.mainCourseId = "";
        if (Helper.isPendingPurchaseBanner()) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
            this.networkCall = new NetworkCall(this, context);
            callApiToAddBanner();
        }
        pendingPurchaseBannerLayoutBindingInflate.sliderRoot.setVisibility(8);
    }

    public final void setImageList() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.pendingPurchaseAdapter = new PendingPurchaseAdapter(context, this.pendingPurchaseList, new PendingPurchaseAdapter.BuyNowClickListener() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseBanner.setImageList.1
            @Override // com.appnew.android.pendingPurchase.PendingPurchaseAdapter.BuyNowClickListener
            public void onBuyNow(Courselist pendingPurchaseData) {
                Intrinsics.checkNotNullParameter(pendingPurchaseData, "pendingPurchaseData");
                if (SystemClock.elapsedRealtime() - Constants.mLastClickTime < 1000) {
                    return;
                }
                Constants.mLastClickTime = SystemClock.elapsedRealtime();
                PendingPurchaseBanner.this.isNetworkConnected();
                PendingPurchaseBanner.this.mainCourseId = pendingPurchaseData.getId();
                PendingPurchaseBanner.this.parentCourseId = "";
                String combo_course_ids = pendingPurchaseData.getCombo_course_ids();
                if (combo_course_ids != null && combo_course_ids.length() == 0) {
                    PendingPurchaseBanner pendingPurchaseBanner = PendingPurchaseBanner.this;
                    pendingPurchaseBanner.parentCourseId = pendingPurchaseBanner.mainCourseId;
                }
                NetworkCall networkCall = PendingPurchaseBanner.this.networkCall;
                if (networkCall != null) {
                    networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
                }
            }
        }, new PendingPurchaseAdapter.CloseClickListener() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseBanner.setImageList.2
            @Override // com.appnew.android.pendingPurchase.PendingPurchaseAdapter.CloseClickListener
            public void onCloseClick(Courselist pendingPurchaseData, int position) {
                Intrinsics.checkNotNullParameter(pendingPurchaseData, "pendingPurchaseData");
                PendingPurchaseBanner.this.selectedCourseId = pendingPurchaseData.getId();
                PendingPurchaseBanner.this.selectedItemPosition = Integer.valueOf(position);
                PendingPurchaseBanner.this.isNetworkConnected();
                NetworkCall networkCall = PendingPurchaseBanner.this.networkCall;
                Intrinsics.checkNotNull(networkCall);
                networkCall.NetworkAPICall(API.DELETE_PENDING_PURCHASE_BANNER, "", true, false);
            }
        });
        PendingPurchaseBannerLayoutBinding pendingPurchaseBannerLayoutBinding = this.binding;
        ViewPager2 viewPager2 = pendingPurchaseBannerLayoutBinding.sliderViewPager;
        PendingPurchaseAdapter pendingPurchaseAdapter = this.pendingPurchaseAdapter;
        if (pendingPurchaseAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingPurchaseAdapter");
            pendingPurchaseAdapter = null;
        }
        viewPager2.setAdapter(pendingPurchaseAdapter);
        pendingPurchaseBannerLayoutBinding.sliderViewPager.setVisibility(0);
        pendingPurchaseBannerLayoutBinding.sliderRoot.setVisibility(0);
        updatePaddingAndTransformer();
        this.binding.sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseBanner.setImageList.4
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                PendingPurchaseBanner.this.updatePaddingAndTransformer();
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (apitype != null) {
            int iHashCode = apitype.hashCode();
            if (iHashCode != -1459074889) {
                if (iHashCode != 750643905) {
                    if (iHashCode == 1107650750 && apitype.equals(API.PENDING_PURCHASE_BANNER)) {
                        EncryptionData encryptionData = new EncryptionData();
                        encryptionData.setAppId("166");
                        encryptionData.setUser_id(MakeMyExam.getUserId());
                        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
                        if (service != null) {
                            return service.getPendingPurchaseBanner(strEncrypt);
                        }
                        return null;
                    }
                } else if (apitype.equals(API.CourseDetail_JS)) {
                    EncryptionData encryptionData2 = new EncryptionData();
                    encryptionData2.setCourse_id(this.mainCourseId);
                    encryptionData2.setParent_id(this.parentCourseId);
                    String strEncrypt2 = AES.encrypt(new Gson().toJson(encryptionData2));
                    if (service != null) {
                        return service.getCourseData(strEncrypt2);
                    }
                    return null;
                }
            } else if (apitype.equals(API.DELETE_PENDING_PURCHASE_BANNER)) {
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setCourse_id(this.selectedCourseId);
                String strEncrypt3 = AES.encrypt(new Gson().toJson(encryptionData3));
                if (service != null) {
                    return service.deletePendingPurchaseBanner(strEncrypt3);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0d01  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0d30  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0d38  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0d3d  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x1464  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x1499  */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r32, java.lang.String r33, java.lang.String r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 6028
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.pendingPurchase.PendingPurchaseBanner.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(getContext(), jsonstring, 0).show();
    }

    private final void handleBuyNowClick(final CourseDetail courseDetail) {
        Context context = getContext();
        final Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseBanner$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PendingPurchaseBanner.handleBuyNowClick$lambda$9(courseDetail, activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void handleBuyNowClick$lambda$9(com.appnew.android.Model.COURSEDETAIL.CourseDetail r5, android.app.Activity r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L14
            com.appnew.android.Model.COURSEDETAIL.Data r1 = r5.getData()     // Catch: java.lang.IllegalStateException -> L61
            if (r1 == 0) goto L14
            com.appnew.android.Model.COURSEDETAIL.CourseDetailData r1 = r1.getCourseDetail()     // Catch: java.lang.IllegalStateException -> L61
            if (r1 == 0) goto L14
            java.lang.String r1 = r1.getCat_type()     // Catch: java.lang.IllegalStateException -> L61
            goto L15
        L14:
            r1 = r0
        L15:
            if (r5 == 0) goto L27
            com.appnew.android.Model.COURSEDETAIL.Data r2 = r5.getData()     // Catch: java.lang.IllegalStateException -> L61
            if (r2 == 0) goto L27
            com.appnew.android.Model.COURSEDETAIL.CourseDetailData r2 = r2.getCourseDetail()     // Catch: java.lang.IllegalStateException -> L61
            if (r2 == 0) goto L27
            java.lang.String r0 = r2.getDelivery_charge()     // Catch: java.lang.IllegalStateException -> L61
        L27:
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.IllegalStateException -> L61
            r3 = r6
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.IllegalStateException -> L61
            java.lang.Class<com.appnew.android.Payment.PurchaseActivity> r4 = com.appnew.android.Payment.PurchaseActivity.class
            r2.<init>(r3, r4)     // Catch: java.lang.IllegalStateException -> L61
            java.lang.String r3 = "single_study"
            java.io.Serializable r5 = (java.io.Serializable) r5     // Catch: java.lang.IllegalStateException -> L61
            r2.putExtra(r3, r5)     // Catch: java.lang.IllegalStateException -> L61
            java.lang.String r5 = "is_book"
            r2.putExtra(r5, r1)     // Catch: java.lang.IllegalStateException -> L61
            java.lang.String r5 = "delivery_charge"
            r2.putExtra(r5, r0)     // Catch: java.lang.IllegalStateException -> L61
            java.lang.String r5 = "5"
            r0 = 1
            boolean r5 = kotlin.text.StringsKt.equals(r1, r5, r0)     // Catch: java.lang.IllegalStateException -> L61
            java.lang.String r0 = ""
            java.lang.String r1 = "test_id"
            if (r5 == 0) goto L5a
            java.lang.String r5 = "test_data"
            r2.putExtra(r5, r0)     // Catch: java.lang.IllegalStateException -> L61
            java.lang.String r5 = "0"
            r2.putExtra(r1, r5)     // Catch: java.lang.IllegalStateException -> L61
            goto L5d
        L5a:
            r2.putExtra(r1, r0)     // Catch: java.lang.IllegalStateException -> L61
        L5d:
            com.appnew.android.Utils.Helper.gotoActivity(r2, r6)     // Catch: java.lang.IllegalStateException -> L61
            return
        L61:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            if (r5 != 0) goto L6a
            java.lang.String r5 = "Unknown error"
        L6a:
            java.lang.String r6 = "handleBuyNowClick"
            android.util.Log.e(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.pendingPurchase.PendingPurchaseBanner.handleBuyNowClick$lambda$9(com.appnew.android.Model.COURSEDETAIL.CourseDetail, android.app.Activity):void");
    }

    public final Boolean setUIOfBanner() {
        if (this.pendingPurchaseList != null) {
            return Boolean.valueOf(!r0.isEmpty());
        }
        return null;
    }

    public final void callApiToAddBanner() {
        isNetworkConnected();
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.PENDING_PURCHASE_BANNER, "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void isNetworkConnected() {
        if (Helper.isConnected(getContext())) {
            return;
        }
        Helper.showInternetToast(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePaddingAndTransformer() {
        PendingPurchaseAdapter pendingPurchaseAdapter = this.pendingPurchaseAdapter;
        if (pendingPurchaseAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingPurchaseAdapter");
            pendingPurchaseAdapter = null;
        }
        int itemCount = pendingPurchaseAdapter.getItemCount();
        ViewPager2 viewPager2 = this.binding.sliderViewPager;
        if (itemCount <= 1) {
            viewPager2.setPadding(0, 0, 0, 0);
        } else if (viewPager2.getCurrentItem() == itemCount - 1) {
            viewPager2.setPadding(60, 0, 0, 0);
        } else {
            viewPager2.setPadding(0, 0, 60, 0);
        }
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        View childAt = viewPager2.getChildAt(0);
        if (childAt != null) {
            childAt.setOverScrollMode(2);
        }
        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseBanner$$ExternalSyntheticLambda1
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void transformPage(View view, float f2) {
                PendingPurchaseBanner.updatePaddingAndTransformer$lambda$11$lambda$10(view, f2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePaddingAndTransformer$lambda$11$lambda$10(View page, float f2) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f3 = 1;
        float fAbs = ((f3 - Math.abs(f2)) * 0.15f) + 0.85f;
        page.setScaleX(fAbs);
        page.setScaleY(fAbs);
        page.setAlpha(((f3 - Math.abs(f2)) * 0.5f) + 0.5f);
        page.setTranslationX((-f2) * page.getWidth() * 0.1f);
    }
}
