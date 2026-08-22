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
public class AudioPostBindingSw720dpImpl extends AudioPostBinding {
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
        sparseIntArray.put(R.id.auido_layout, 9);
        sparseIntArray.put(R.id.play_icon, 10);
        sparseIntArray.put(R.id.audio_text, 11);
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

    public AudioPostBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private AudioPostBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[11], (RelativeLayout) bindings[9], (TextView) bindings[7], (LinearLayout) bindings[13], (LinearLayout) bindings[16], (ImageView) bindings[3], (ImageView) bindings[10], (TextView) bindings[17], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[20], (TextView) bindings[8], (TextView) bindings[4], (CircleImageView) bindings[1], (TextView) bindings[12], (ImageView) bindings[19], (TextView) bindings[2], (View) bindings[15], (View) bindings[21], (View) bindings[14], (LinearLayout) bindings[18]);
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
        if (2 != variableId) {
            return false;
        }
        setAudiobind((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.AudioPostBinding
    public void setAudiobind(Data Audiobind) {
        this.mAudiobind = Audiobind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String name;
        String schedule_date;
        String profile_picture;
        String total_likes;
        String my_like;
        String my_pinned;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mAudiobind;
        long j3 = j & 3;
        int i = 0;
        String total_comments = null;
        if (j3 != 0) {
            if (data != null) {
                total_comments = data.getTotal_comments();
                name = data.getName();
                my_like = data.getMy_like();
                my_pinned = data.getMy_pinned();
                schedule_date = data.getSchedule_date();
                profile_picture = data.getProfile_picture();
                total_likes = data.getTotal_likes();
            } else {
                total_likes = null;
                name = null;
                my_like = null;
                my_pinned = null;
                schedule_date = null;
                profile_picture = null;
            }
            j2 = 0;
            String str3 = total_comments + " Comment";
            boolean zEquals = my_pinned != null ? my_pinned.equals("1") : false;
            if (j3 != 0) {
                j |= zEquals ? 8L : 4L;
            }
            i = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            str2 = total_likes;
            str = str3;
            total_comments = my_like;
        } else {
            j2 = 0;
            str = null;
            str2 = null;
            name = null;
            schedule_date = null;
            profile_picture = null;
        }
        if ((j & 3) != j2) {
            DataKt.viewlike(this.like, total_comments);
            this.pinIV.setImageResource(i);
            TextViewBindingAdapter.setText(this.postCommentCount, str);
            ExtensionFucationKt.like(this.postLikeCount, str2);
            DataKt.loadImage(this.postTime, schedule_date);
            DataKt.loadImage(this.profileImage, profile_picture);
            TextViewBindingAdapter.setText(this.userName, name);
        }
    }
}
