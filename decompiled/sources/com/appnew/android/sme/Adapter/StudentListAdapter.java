package com.appnew.android.sme.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.CustomSmeStudentlistBinding;
import com.appnew.android.sme.SmeStudentModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: StudentListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\b2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/sme/Adapter/StudentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/sme/Adapter/StudentListAdapter$ViewHolder;", "data", "", "Lcom/appnew/android/sme/SmeStudentModel;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getListener", "()Lkotlin/jvm/functions/Function0;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final List<SmeStudentModel> data;
    private final Function0<Unit> listener;

    public final Function0<Unit> getListener() {
        return this.listener;
    }

    public StudentListAdapter(List<SmeStudentModel> data, Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.data = data;
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CustomSmeStudentlistBinding customSmeStudentlistBindingInflate = CustomSmeStudentlistBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(customSmeStudentlistBindingInflate, "inflate(...)");
        return new ViewHolder(this, customSmeStudentlistBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().setData(this.data.get(position));
        Glide.with(holder.getBinding().SmeStudentImage.getContext()).setDefaultRequestOptions(new RequestOptions().circleCrop()).load(this.data.get(position).getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.default_pic)).into(holder.getBinding().SmeStudentImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.StudentListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudentListAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(StudentListAdapter studentListAdapter, int i, View view) {
        studentListAdapter.listener.invoke();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", studentListAdapter.data.get(i).getUserId());
        Intrinsics.checkNotNull(view);
        Navigation.findNavController(view).navigate(R.id.action_studentListFragment_to_studentDoubtListFragment, bundle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: StudentListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/appnew/android/sme/Adapter/StudentListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/CustomSmeStudentlistBinding;", "<init>", "(Lcom/appnew/android/sme/Adapter/StudentListAdapter;Lcom/appnew/android/databinding/CustomSmeStudentlistBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/CustomSmeStudentlistBinding;", "setBinding", "(Lcom/appnew/android/databinding/CustomSmeStudentlistBinding;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private CustomSmeStudentlistBinding binding;
        final /* synthetic */ StudentListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(StudentListAdapter studentListAdapter, CustomSmeStudentlistBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = studentListAdapter;
            this.binding = binding;
        }

        public final CustomSmeStudentlistBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(CustomSmeStudentlistBinding customSmeStudentlistBinding) {
            Intrinsics.checkNotNullParameter(customSmeStudentlistBinding, "<set-?>");
            this.binding = customSmeStudentlistBinding;
        }
    }
}
