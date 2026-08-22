package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.comment.Data;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class CommentAdapterBindingSw720dpImpl extends CommentAdapterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cvrRight, 6);
    }

    public CommentAdapterBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private CommentAdapterBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[4], (RelativeLayout) bindings[6], (CircleImageView) bindings[5], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.approval.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.profileImage2.setTag(null);
        this.rightmessage.setTag(null);
        this.righttexttime.setTag(null);
        this.userNameright.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (5 != variableId) {
            return false;
        }
        setCommentdata((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.CommentAdapterBinding
    public void setCommentdata(Data Commentdata) {
        this.mCommentdata = Commentdata;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String profile_picture;
        String name;
        String comment;
        String created;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mCommentdata;
        long j2 = j & 3;
        if (j2 == 0 || data == null) {
            profile_picture = null;
            name = null;
            comment = null;
            created = null;
        } else {
            profile_picture = data.getProfile_picture();
            name = data.getName();
            comment = data.getComment();
            created = data.getCreated();
        }
        if (j2 != 0) {
            ExtensionFucationKt.viewVisible(this.approval, data);
            DataKt.loadImage(this.profileImage2, profile_picture);
            TextViewBindingAdapter.setText(this.rightmessage, comment);
            ExtensionFucationKt.date(this.righttexttime, created);
            TextViewBindingAdapter.setText(this.userNameright, name);
        }
    }
}
