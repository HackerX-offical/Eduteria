package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.DataKt;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class ArticleVmBindingSw600dpImpl extends ArticleVmBinding {
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
        sparseIntArray.put(R.id.post_subject, 8);
        sparseIntArray.put(R.id.article_txt_top, 9);
        sparseIntArray.put(R.id.article_txt, 10);
        sparseIntArray.put(R.id.read_more, 11);
        sparseIntArray.put(R.id.like_comment_count_layout, 12);
        sparseIntArray.put(R.id.view_comment, 13);
        sparseIntArray.put(R.id.view, 14);
        sparseIntArray.put(R.id.like_comment_layout, 15);
        sparseIntArray.put(R.id.post_comment, 16);
        sparseIntArray.put(R.id.whatsapp_share, 17);
        sparseIntArray.put(R.id.shareImage, 18);
        sparseIntArray.put(R.id.postShare, 19);
        sparseIntArray.put(R.id.view1, 20);
    }

    public ArticleVmBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private ArticleVmBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[7], (LinearLayout) bindings[12], (LinearLayout) bindings[15], (ImageView) bindings[4], (TextView) bindings[16], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[19], (TextView) bindings[8], (TextView) bindings[3], (CircleImageView) bindings[1], (TextView) bindings[11], (ImageView) bindings[18], (TextView) bindings[2], (View) bindings[14], (View) bindings[20], (View) bindings[13], (LinearLayout) bindings[17]);
        this.mDirtyFlags = -1L;
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
        if (1 != variableId) {
            return false;
        }
        setArticlebind((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.ArticleVmBinding
    public void setArticlebind(Data Articlebind) {
        this.mArticlebind = Articlebind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String schedule_date;
        String name;
        String total_likes;
        String str3;
        String my_like;
        String total_comments;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mArticlebind;
        long j2 = j & 3;
        int i = 0;
        String str4 = null;
        if (j2 != 0) {
            if (data != null) {
                String profile_picture = data.getProfile_picture();
                my_like = data.getMy_like();
                schedule_date = data.getSchedule_date();
                String my_pinned = data.getMy_pinned();
                total_likes = data.getTotal_likes();
                total_comments = data.getTotal_comments();
                name = data.getName();
                str3 = profile_picture;
                str4 = my_pinned;
            } else {
                str3 = null;
                my_like = null;
                schedule_date = null;
                name = null;
                total_likes = null;
                total_comments = null;
            }
            boolean zEquals = str4 != null ? str4.equals("1") : false;
            if (j2 != 0) {
                j |= zEquals ? 8L : 4L;
            }
            String str5 = total_comments + " Comment";
            i = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            str2 = str3;
            str = str5;
            str4 = my_like;
        } else {
            str = null;
            str2 = null;
            schedule_date = null;
            name = null;
            total_likes = null;
        }
        if ((j & 3) != 0) {
            DataKt.viewlike(this.like, str4);
            this.pinIV.setImageResource(i);
            TextViewBindingAdapter.setText(this.postCommentCount, str);
            ExtensionFucationKt.like(this.postLikeCount, total_likes);
            DataKt.loadImage(this.postTime, schedule_date);
            DataKt.loadImage(this.profileImage, str2);
            TextViewBindingAdapter.setText(this.userName, name);
        }
    }
}
