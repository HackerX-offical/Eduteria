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
public class VideoPostBindingSw600dpImpl extends VideoPostBinding {
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
        sparseIntArray.put(R.id.play_video, 11);
        sparseIntArray.put(R.id.video_text, 12);
        sparseIntArray.put(R.id.read_more, 13);
        sparseIntArray.put(R.id.like_comment_count_layout, 14);
        sparseIntArray.put(R.id.view_comment, 15);
        sparseIntArray.put(R.id.view, 16);
        sparseIntArray.put(R.id.like_comment_layout, 17);
        sparseIntArray.put(R.id.post_comment, 18);
        sparseIntArray.put(R.id.whatsapp_share, 19);
        sparseIntArray.put(R.id.shareImage, 20);
        sparseIntArray.put(R.id.postShare, 21);
        sparseIntArray.put(R.id.view1, 22);
    }

    public VideoPostBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private VideoPostBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[10], (TextView) bindings[8], (LinearLayout) bindings[14], (LinearLayout) bindings[17], (ImageView) bindings[3], (ImageView) bindings[11], (TextView) bindings[18], (TextView) bindings[7], (TextView) bindings[6], (TextView) bindings[21], (TextView) bindings[9], (TextView) bindings[4], (CircleImageView) bindings[1], (TextView) bindings[13], (ImageView) bindings[20], (TextView) bindings[2], (TextView) bindings[12], (ImageView) bindings[5], (View) bindings[16], (View) bindings[22], (View) bindings[15], (LinearLayout) bindings[19]);
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
        this.videoThumbnail.setTag(null);
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
        if (27 != variableId) {
            return false;
        }
        setVideopostbind((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.VideoPostBinding
    public void setVideopostbind(Data Videopostbind) {
        this.mVideopostbind = Videopostbind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
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
        String thumbnail;
        String str5;
        String my_like;
        String profile_picture;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mVideopostbind;
        long j3 = j & 3;
        int i = 0;
        String str6 = null;
        if (j3 != 0) {
            if (data != null) {
                String name = data.getName();
                String total_likes = data.getTotal_likes();
                String total_comments = data.getTotal_comments();
                schedule_date = data.getSchedule_date();
                my_like = data.getMy_like();
                thumbnail = data.getThumbnail();
                String my_pinned = data.getMy_pinned();
                profile_picture = data.getProfile_picture();
                str5 = my_pinned;
                str3 = name;
                str6 = total_comments;
                str4 = total_likes;
            } else {
                str5 = null;
                str3 = null;
                str4 = null;
                schedule_date = null;
                my_like = null;
                thumbnail = null;
                profile_picture = null;
            }
            j2 = 0;
            String str7 = str6 + " Comment";
            boolean zEquals = str5 != null ? str5.equals("1") : false;
            if (j3 != 0) {
                j |= zEquals ? 8L : 4L;
            }
            i = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            str = str7;
            str6 = my_like;
            str2 = profile_picture;
        } else {
            j2 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            schedule_date = null;
            thumbnail = null;
        }
        if ((j & 3) != j2) {
            DataKt.viewlike(this.like, str6);
            this.pinIV.setImageResource(i);
            TextViewBindingAdapter.setText(this.postCommentCount, str);
            ExtensionFucationKt.like(this.postLikeCount, str4);
            DataKt.loadImage(this.postTime, schedule_date);
            DataKt.loadImage(this.profileImage, str2);
            TextViewBindingAdapter.setText(this.userName, str3);
            DataKt.imagepost(this.videoThumbnail, thumbnail);
        }
    }
}
