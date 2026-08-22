package com.appnew.android.feeds.activity;

import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.android.feeds.dataclass.TestResult;
import com.appnew.android.table.PostDataTable;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: FeedsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$setObservers$5$5", f = "FeedsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedsActivity$setObservers$5$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONArray $dataJsonObject;
    int label;
    final /* synthetic */ FeedsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedsActivity$setObservers$5$5(FeedsActivity feedsActivity, JSONArray jSONArray, Continuation<? super FeedsActivity$setObservers$5$5> continuation) {
        super(2, continuation);
        this.this$0 = feedsActivity;
        this.$dataJsonObject = jSONArray;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedsActivity$setObservers$5$5(this.this$0, this.$dataJsonObject, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedsActivity$setObservers$5$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!this.this$0.getIs_filterbutton()) {
            int length = this.$dataJsonObject.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = this.$dataJsonObject.optJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                Data data = (Data) new Gson().fromJson(jSONObjectOptJSONObject.toString(), Data.class);
                PostDataTable postDataTable = new PostDataTable();
                postDataTable.setCreated(data.getCreated());
                postDataTable.setId(data.getId());
                postDataTable.setJson(new Gson().toJson(data.getJson()));
                postDataTable.setMeta_url(data.getMeta_url());
                postDataTable.setLink_type(data.getLink_type());
                postDataTable.setThumbnail(data.getThumbnail());
                String url = data.getUrl();
                if (url == null) {
                    url = "";
                }
                postDataTable.setUrl(url);
                postDataTable.setModified(data.getModified());
                postDataTable.setMy_like(data.getMy_like());
                String name = data.getName();
                if (name == null) {
                    name = "";
                }
                postDataTable.setName(name);
                postDataTable.setPost_type(data.getPost_type());
                String profile_picture = data.getProfile_picture();
                postDataTable.setProfile_picture(profile_picture != null ? profile_picture : "");
                postDataTable.setStatus(data.getStatus());
                postDataTable.setText(data.getText());
                postDataTable.setTotal_comments(data.getTotal_comments());
                postDataTable.setTotal_likes(data.getTotal_likes());
                postDataTable.setUser_id(data.getUser_id());
                postDataTable.setParentId(this.this$0.getMaster_cat());
                postDataTable.setMasterCat(this.this$0.getMain_cat());
                postDataTable.setSub_cat_id(this.this$0.getSub_cat());
                postDataTable.setSchedule_date(data.getSchedule_date());
                Gson gson = new Gson();
                List<NewCourseData> newCourseData = data.getNewCourseData();
                if (newCourseData == null) {
                    newCourseData = CollectionsKt.emptyList();
                }
                postDataTable.setNewCourseData(gson.toJson(newCourseData));
                postDataTable.setLivetest(new Gson().toJson(data.getLivetest()));
                postDataTable.setLiveclass(new Gson().toJson(data.getLiveclass()));
                Gson gson2 = new Gson();
                List<TestResult> testResult = data.getTestResult();
                if (testResult == null) {
                    testResult = CollectionsKt.emptyList();
                }
                postDataTable.setTestResult(gson2.toJson(testResult));
                Gson gson3 = new Gson();
                List<BannerData> bannerlist = data.getBannerlist();
                if (bannerlist == null) {
                    bannerlist = CollectionsKt.emptyList();
                }
                postDataTable.setBannerlist(gson3.toJson(bannerlist));
                postDataTable.setLiveClassStatus("0");
                postDataTable.setLiveTestStatus("0");
                postDataTable.setPage(String.valueOf(this.this$0.getPage()));
                postDataTable.setIscommentenable(data.getIs_comment_enable());
                postDataTable.setLimit(String.valueOf(this.this$0.getLimitdata()));
                postDataTable.setMy_pinned(data.getMy_pinned());
                postDataTable.setDescription(data.getDescription());
                this.this$0.getUtkashRoom().getFeedDao().insertPost(postDataTable);
            }
        }
        return Unit.INSTANCE;
    }
}
