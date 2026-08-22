package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.SocialIconModel;
import com.appnew.android.databinding.CustomSocialIconsBinding;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SocialIconAdapter extends RecyclerView.Adapter<ViewHolder> {
    CustomSocialIconsBinding binding;
    private Context context;
    private ArrayList<SocialIconModel> socialIconModel;

    public SocialIconAdapter(Context context, ArrayList<SocialIconModel> socialIconModel) {
        this.context = context;
        this.socialIconModel = socialIconModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.binding = CustomSocialIconsBinding.inflate(LayoutInflater.from(this.context), parent, false);
        return new ViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(this.socialIconModel.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.socialIconModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final CustomSocialIconsBinding binding;

        public ViewHolder(CustomSocialIconsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SocialIconModel socialIcon) {
            this.binding.socialIcons.setImageResource(socialIcon.getSocial_icon());
        }
    }
}
