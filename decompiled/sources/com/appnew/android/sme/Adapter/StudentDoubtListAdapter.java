package com.appnew.android.sme.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.CustomStudentDoubtListBinding;
import com.appnew.android.sme.Doubt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: StudentDoubtListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u001c\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/sme/Adapter/StudentDoubtListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/sme/Adapter/StudentDoubtListAdapter$ViewHolder;", "context", "Landroid/content/Context;", "data", "", "Lcom/appnew/android/sme/Doubt;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "setData", "", "data1", "onBindViewHolder", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentDoubtListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<Doubt> data;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(View view) {
    }

    public StudentDoubtListAdapter(Context context, List<Doubt> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.data = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CustomStudentDoubtListBinding customStudentDoubtListBindingInflate = CustomStudentDoubtListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(customStudentDoubtListBindingInflate, "inflate(...)");
        return new ViewHolder(this, customStudentDoubtListBindingInflate);
    }

    public final void setData(List<Doubt> data1) {
        this.data = data1;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Doubt doubt;
        Doubt doubt2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CustomStudentDoubtListBinding binding = holder.getBinding();
        List<Doubt> list = this.data;
        String doubtImage = null;
        if (list == null || (doubt = list.get(position)) == null) {
            doubt = null;
        }
        binding.setData(doubt);
        RequestOptions requestOptionsTransforms = new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(16));
        requestOptionsTransforms.placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate();
        RequestManager requestManagerWith = Glide.with(holder.getBinding().SmeStudentImage.getContext());
        List<Doubt> list2 = this.data;
        if (list2 != null && (doubt2 = list2.get(position)) != null) {
            doubtImage = doubt2.getDoubtImage();
        }
        requestManagerWith.load(doubtImage).apply((BaseRequestOptions<?>) requestOptionsTransforms).into(holder.getBinding().SmeStudentImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.StudentDoubtListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudentDoubtListAdapter.onBindViewHolder$lambda$0(view);
            }
        });
        holder.getBinding().SmeStudentImage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.StudentDoubtListAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudentDoubtListAdapter.onBindViewHolder$lambda$2(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(StudentDoubtListAdapter studentDoubtListAdapter, int i, View view) {
        String doubtImage;
        Doubt doubt;
        Doubt doubt2;
        AlertDialog.Builder builder = new AlertDialog.Builder(studentDoubtListAdapter.context);
        Context context = studentDoubtListAdapter.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        String doubtImage2 = null;
        View viewInflate = layoutInflater.inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        List<Doubt> list = studentDoubtListAdapter.data;
        if (list == null || (doubt2 = list.get(i)) == null || (doubtImage = doubt2.getDoubtImage()) == null) {
            doubtImage = "";
        }
        if (!Intrinsics.areEqual(doubtImage, "")) {
            RequestManager requestManagerWith = Glide.with(studentDoubtListAdapter.context.getApplicationContext());
            List<Doubt> list2 = studentDoubtListAdapter.data;
            if (list2 != null && (doubt = list2.get(i)) != null) {
                doubtImage2 = doubt.getDoubtImage();
            }
            Intrinsics.checkNotNull(requestManagerWith.load(doubtImage2).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).into(imageView));
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.StudentDoubtListAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                alertDialogShow.dismiss();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Doubt> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX INFO: compiled from: StudentDoubtListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/appnew/android/sme/Adapter/StudentDoubtListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/CustomStudentDoubtListBinding;", "<init>", "(Lcom/appnew/android/sme/Adapter/StudentDoubtListAdapter;Lcom/appnew/android/databinding/CustomStudentDoubtListBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/CustomStudentDoubtListBinding;", "setBinding", "(Lcom/appnew/android/databinding/CustomStudentDoubtListBinding;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private CustomStudentDoubtListBinding binding;
        final /* synthetic */ StudentDoubtListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(StudentDoubtListAdapter studentDoubtListAdapter, CustomStudentDoubtListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = studentDoubtListAdapter;
            this.binding = binding;
        }

        public final CustomStudentDoubtListBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(CustomStudentDoubtListBinding customStudentDoubtListBinding) {
            Intrinsics.checkNotNullParameter(customStudentDoubtListBinding, "<set-?>");
            this.binding = customStudentDoubtListBinding;
        }
    }
}
