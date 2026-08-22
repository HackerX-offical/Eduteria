package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.DataKt;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class PostImageBindingImpl extends PostImageBinding {
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
        sparseIntArray.put(R.id.post_subject, 9);
        sparseIntArray.put(R.id.image_constraint_layout, 10);
        sparseIntArray.put(R.id.image_text, 11);
        sparseIntArray.put(R.id.read_more, 12);
        sparseIntArray.put(R.id.like_comment_count_layout, 13);
        sparseIntArray.put(R.id.view_comment, 14);
        sparseIntArray.put(R.id.view, 15);
        sparseIntArray.put(R.id.like_comment_layout, 16);
        sparseIntArray.put(R.id.post_comment, 17);
        sparseIntArray.put(R.id.whatsapp_share, 18);
        sparseIntArray.put(R.id.shareImage, 19);
        sparseIntArray.put(R.id.postShare, 20);
        sparseIntArray.put(R.id.view1, 21);
    }

    public PostImageBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private PostImageBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[10], (TextView) bindings[11], (ImageView) bindings[5], (TextView) bindings[8], (LinearLayout) bindings[13], (LinearLayout) bindings[16], (ImageView) bindings[3], (TextView) bindings[17], (TextView) bindings[7], (TextView) bindings[6], (TextView) bindings[20], (TextView) bindings[9], (TextView) bindings[4], (CircleImageView) bindings[1], (TextView) bindings[12], (ImageView) bindings[19], (TextView) bindings[2], (View) bindings[15], (View) bindings[21], (View) bindings[14], (LinearLayout) bindings[18]);
        this.mDirtyFlags = -1L;
        this.imgeView.setTag(null);
        this.like.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.pinIV.setTag(null);
        this.postCommentCount.setTag(null);
        this.postLikeCount.setTag(null);
        this.postTime.setTag(null);
        this.profileImage.setTag(null);
        this.userName.setTag(null);
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
        if (12 != variableId) {
            return false;
        }
        setImagebind((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.PostImageBinding
    public void setImagebind(Data Imagebind) {
        this.mImagebind = Imagebind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String schedule_date;
        String str4;
        String str5;
        String total_comments;
        String my_like;
        String total_likes;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mImagebind;
        long j2 = j & 3;
        int i = 0;
        String str6 = null;
        if (j2 != 0) {
            if (data != null) {
                String name = data.getName();
                String profile_picture = data.getProfile_picture();
                String my_pinned = data.getMy_pinned();
                schedule_date = data.getSchedule_date();
                total_comments = data.getTotal_comments();
                my_like = data.getMy_like();
                total_likes = data.getTotal_likes();
                str5 = name;
                str6 = my_pinned;
                str3 = profile_picture;
            } else {
                str5 = null;
                str3 = null;
                schedule_date = null;
                total_comments = null;
                my_like = null;
                total_likes = null;
            }
            boolean zEquals = str6 != null ? str6.equals("1") : false;
            if (j2 != 0) {
                j |= zEquals ? 8L : 4L;
            }
            String str7 = total_comments + " Comment";
            i = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            str = str7;
            str4 = str5;
            str6 = my_like;
            str2 = total_likes;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            schedule_date = null;
            str4 = null;
        }
        if ((j & 3) != 0) {
            DataKt.imagefeedPost(this.imgeView, data);
            DataKt.viewlike(this.like, str6);
            this.pinIV.setImageResource(i);
            TextViewBindingAdapter.setText(this.postCommentCount, str);
            ExtensionFucationKt.like(this.postLikeCount, str2);
            DataKt.loadImage(this.postTime, schedule_date);
            DataKt.loadImage(this.profileImage, str3);
            TextViewBindingAdapter.setText(this.userName, str4);
        }
    }
}
