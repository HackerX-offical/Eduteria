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
import com.makeramen.roundedimageview.RoundedImageView;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class LinkViewBindingImpl extends LinkViewBinding {
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
        sparseIntArray.put(R.id.post_subject, 10);
        sparseIntArray.put(R.id.rl_link, 11);
        sparseIntArray.put(R.id.image_constraint_layout, 12);
        sparseIntArray.put(R.id.play_link, 13);
        sparseIntArray.put(R.id.link_txt, 14);
        sparseIntArray.put(R.id.like_comment_count_layout, 15);
        sparseIntArray.put(R.id.view_comment, 16);
        sparseIntArray.put(R.id.view, 17);
        sparseIntArray.put(R.id.like_comment_layout, 18);
        sparseIntArray.put(R.id.post_comment, 19);
        sparseIntArray.put(R.id.whatsapp_share, 20);
        sparseIntArray.put(R.id.shareImage, 21);
        sparseIntArray.put(R.id.postShare, 22);
        sparseIntArray.put(R.id.view1, 23);
    }

    public LinkViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private LinkViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[12], (TextView) bindings[9], (LinearLayout) bindings[15], (LinearLayout) bindings[18], (RoundedImageView) bindings[6], (TextView) bindings[14], (ImageView) bindings[5], (ImageView) bindings[3], (ImageView) bindings[13], (TextView) bindings[19], (TextView) bindings[8], (TextView) bindings[7], (TextView) bindings[22], (TextView) bindings[10], (TextView) bindings[4], (CircleImageView) bindings[1], (RelativeLayout) bindings[11], (ImageView) bindings[21], (TextView) bindings[2], (View) bindings[17], (View) bindings[23], (View) bindings[16], (LinearLayout) bindings[20]);
        this.mDirtyFlags = -1L;
        this.like.setTag(null);
        this.linkImage.setTag(null);
        this.linkYoutubeThumbnail.setTag(null);
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
        if (13 != variableId) {
            return false;
        }
        setLinkbind((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.LinkViewBinding
    public void setLinkbind(Data Linkbind) {
        this.mLinkbind = Linkbind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String schedule_date;
        String name;
        String str5;
        String str6;
        String thumbnail;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mLinkbind;
        long j3 = j & 3;
        int i = 0;
        String str7 = null;
        if (j3 != 0) {
            if (data != null) {
                String my_like = data.getMy_like();
                String profile_picture = data.getProfile_picture();
                String total_likes = data.getTotal_likes();
                String total_comments = data.getTotal_comments();
                schedule_date = data.getSchedule_date();
                name = data.getName();
                String my_pinned = data.getMy_pinned();
                thumbnail = data.getThumbnail();
                str5 = my_pinned;
                str6 = my_like;
                str7 = total_comments;
                str4 = total_likes;
                str3 = profile_picture;
            } else {
                str5 = null;
                str6 = null;
                str3 = null;
                str4 = null;
                schedule_date = null;
                name = null;
                thumbnail = null;
            }
            j2 = 0;
            String str8 = str7 + " Comment";
            boolean zEquals = str5 != null ? str5.equals("1") : false;
            if (j3 != 0) {
                j |= zEquals ? 8L : 4L;
            }
            i = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            str2 = str8;
            str7 = str6;
            str = thumbnail;
        } else {
            j2 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            schedule_date = null;
            name = null;
        }
        if ((j & 3) != j2) {
            DataKt.viewlike(this.like, str7);
            DataKt.loadImage(this.linkImage, str);
            DataKt.imagepost(this.linkYoutubeThumbnail, str);
            this.pinIV.setImageResource(i);
            TextViewBindingAdapter.setText(this.postCommentCount, str2);
            ExtensionFucationKt.like(this.postLikeCount, str4);
            DataKt.loadImage(this.postTime, schedule_date);
            DataKt.loadImage(this.profileImage, str3);
            TextViewBindingAdapter.setText(this.userName, name);
        }
    }
}
