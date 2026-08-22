package com.appnew.android.feeds.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.NewTestResultAdapterBinding;
import com.appnew.android.feeds.dataclass.TestResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: NewTestResultAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0017J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u001e\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/appnew/android/feeds/adapters/NewTestResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/feeds/adapters/NewTestResultAdapter$NewCourseVH;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "testResult", "", "Lcom/appnew/android/feeds/dataclass/TestResult;", "getTestResult", "()Ljava/util/List;", "setTestResult", "(Ljava/util/List;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "updateItems", "testResultlist", "ctx", "NewCourseVH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewTestResultAdapter extends RecyclerView.Adapter<NewCourseVH> {
    public static final int $stable = 8;
    private Context context;
    private List<TestResult> testResult = CollectionsKt.emptyList();

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final List<TestResult> getTestResult() {
        return this.testResult;
    }

    public final void setTestResult(List<TestResult> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.testResult = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NewCourseVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        NewTestResultAdapterBinding newTestResultAdapterBindingInflate = NewTestResultAdapterBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(newTestResultAdapterBindingInflate, "inflate(...)");
        return new NewCourseVH(this, newTestResultAdapterBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NewCourseVH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.testResult.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.testResult.size();
    }

    public final void updateItems(List<TestResult> testResultlist, Context ctx) {
        Intrinsics.checkNotNullParameter(testResultlist, "testResultlist");
        this.testResult = testResultlist;
        this.context = ctx;
    }

    /* JADX INFO: compiled from: NewTestResultAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/NewTestResultAdapter$NewCourseVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "newTestResultAdapterBinding", "Lcom/appnew/android/databinding/NewTestResultAdapterBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/NewTestResultAdapter;Lcom/appnew/android/databinding/NewTestResultAdapterBinding;)V", Bind.ELEMENT, "", "testResultdata", "Lcom/appnew/android/feeds/dataclass/TestResult;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NewCourseVH extends RecyclerView.ViewHolder {
        private final NewTestResultAdapterBinding newTestResultAdapterBinding;
        final /* synthetic */ NewTestResultAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewCourseVH(NewTestResultAdapter newTestResultAdapter, NewTestResultAdapterBinding newTestResultAdapterBinding) {
            super(newTestResultAdapterBinding.getRoot());
            Intrinsics.checkNotNullParameter(newTestResultAdapterBinding, "newTestResultAdapterBinding");
            this.this$0 = newTestResultAdapter;
            this.newTestResultAdapterBinding = newTestResultAdapterBinding;
        }

        public final void bind(TestResult testResultdata) {
            Intrinsics.checkNotNullParameter(testResultdata, "testResultdata");
            this.newTestResultAdapterBinding.setLivetestresult(testResultdata);
        }
    }
}
