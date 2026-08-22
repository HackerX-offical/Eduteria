package com.appnew.android.folder.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.ItemFolderTypeBinding;
import com.appnew.android.folder.activity.FolderActivity;
import com.appnew.android.folder.fragments.FolderFragment;
import com.appnew.android.folder.model.FolderModel;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: FolderAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001&Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/appnew/android/folder/adapter/FolderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/folder/adapter/FolderAdapter$ViewHolder;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "folderList", "", "Lcom/appnew/android/folder/model/FolderModel;", "singleStudyModel", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "examPrepItem", "Lcom/appnew/android/Model/Courses/ExamPrepItem;", "lists", "Lcom/appnew/android/Model/Courses/Lists;", "isCombo", "", "title", "", "content_type", "tileIdAPI", "tileTypeAPI", "revertAPI", "<init>", "(Landroid/content/Context;Landroid/app/Activity;Ljava/util/List;Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;Lcom/appnew/android/Model/Courses/ExamPrepItem;Lcom/appnew/android/Model/Courses/Lists;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "revertApiManage", "model", "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity activity;
    private final String content_type;
    private final Context context;
    private final ExamPrepItem examPrepItem;
    private final List<FolderModel> folderList;
    private final boolean isCombo;
    private final Lists lists;
    private final String revertAPI;
    private final CourseDetail singleStudyModel;
    private final String tileIdAPI;
    private final String tileTypeAPI;
    private final String title;

    /* JADX INFO: compiled from: FolderAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/folder/adapter/FolderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemFolderTypeBinding;", "<init>", "(Lcom/appnew/android/folder/adapter/FolderAdapter;Lcom/appnew/android/databinding/ItemFolderTypeBinding;)V", "getBinding$app_EDUTERIARelease", "()Lcom/appnew/android/databinding/ItemFolderTypeBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemFolderTypeBinding binding;
        final /* synthetic */ FolderAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(FolderAdapter folderAdapter, ItemFolderTypeBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = folderAdapter;
            this.binding = binding;
        }

        /* JADX INFO: renamed from: getBinding$app_EDUTERIARelease, reason: from getter */
        public final ItemFolderTypeBinding getBinding() {
            return this.binding;
        }
    }

    public FolderAdapter(Context context, Activity activity, List<FolderModel> folderList, CourseDetail singleStudyModel, ExamPrepItem examPrepItem, Lists lists, boolean z, String title, String content_type, String tileIdAPI, String tileTypeAPI, String revertAPI) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(folderList, "folderList");
        Intrinsics.checkNotNullParameter(singleStudyModel, "singleStudyModel");
        Intrinsics.checkNotNullParameter(examPrepItem, "examPrepItem");
        Intrinsics.checkNotNullParameter(lists, "lists");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content_type, "content_type");
        Intrinsics.checkNotNullParameter(tileIdAPI, "tileIdAPI");
        Intrinsics.checkNotNullParameter(tileTypeAPI, "tileTypeAPI");
        Intrinsics.checkNotNullParameter(revertAPI, "revertAPI");
        this.context = context;
        this.activity = activity;
        this.folderList = folderList;
        this.singleStudyModel = singleStudyModel;
        this.examPrepItem = examPrepItem;
        this.lists = lists;
        this.isCombo = z;
        this.title = title;
        this.content_type = content_type;
        this.tileIdAPI = tileIdAPI;
        this.tileTypeAPI = tileTypeAPI;
        this.revertAPI = revertAPI;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemFolderTypeBinding itemFolderTypeBindingInflate = ItemFolderTypeBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemFolderTypeBindingInflate, "inflate(...)");
        return new ViewHolder(this, itemFolderTypeBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemFolderTypeBinding binding = holder.getBinding();
        binding.folderTitle.setText(this.folderList.get(position).getTitle());
        Glide.with(this.context).load(this.folderList.get(position).getImage_icon()).placeholder(R.mipmap.folder).error(R.mipmap.folder).dontAnimate().into(binding.icon);
        binding.mainRl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.folder.adapter.FolderAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(FolderAdapter folderAdapter, int i, View view) {
        Activity activity = folderAdapter.activity;
        if (activity instanceof FolderActivity) {
            ((FolderActivity) activity).setHitCount(((FolderActivity) activity).getHitCount() + 1);
            ((FolderActivity) folderAdapter.activity).replaceFragment(FolderFragment.INSTANCE.newInstance(folderAdapter.isCombo, folderAdapter.folderList.get(i).getTitle(), folderAdapter.content_type, folderAdapter.tileIdAPI, folderAdapter.tileTypeAPI, folderAdapter.revertApiManage(folderAdapter.revertAPI, folderAdapter.folderList.get(i)), folderAdapter.folderList.get(i).getId(), false), true);
        }
    }

    private final String revertApiManage(String revertAPI, FolderModel model) {
        List mutableList = CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) revertAPI, new String[]{MqttTopic.MULTI_LEVEL_WILDCARD}, false, 0, 6, (Object) null));
        mutableList.set(2, model.getData_order());
        return CollectionsKt.joinToString$default(mutableList, MqttTopic.MULTI_LEVEL_WILDCARD, null, null, 0, null, null, 62, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.folderList.size();
    }
}
