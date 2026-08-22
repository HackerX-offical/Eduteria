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
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.adapters.OptionAdapter;
import com.appnew.android.feeds.adapters.OptionWebAdapter;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.Json;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionViewBindingImpl extends QuestionViewBinding {
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
        sparseIntArray.put(R.id.post_subject, 12);
        sparseIntArray.put(R.id.constraint, 13);
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

    public QuestionViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private QuestionViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[13], (TextView) bindings[11], (LinearLayout) bindings[14], (LinearLayout) bindings[17], (ImageView) bindings[3], (TextView) bindings[8], (TextView) bindings[18], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[21], (TextView) bindings[12], (TextView) bindings[4], (CircleImageView) bindings[1], (ClickableWebView) bindings[5], (RecyclerView) bindings[6], (RecyclerView) bindings[7], (ImageView) bindings[20], (TextView) bindings[2], (View) bindings[16], (View) bindings[22], (View) bindings[15], (LinearLayout) bindings[19]);
        this.mDirtyFlags = -1L;
        this.like.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.pinIV.setTag(null);
        this.postAttempt.setTag(null);
        this.postCommentCount.setTag(null);
        this.postLikeCount.setTag(null);
        this.postTime.setTag(null);
        this.profileImage.setTag(null);
        this.questionTxt.setTag(null);
        this.recyerclerView.setTag(null);
        this.recyerclerViewWebview.setTag(null);
        this.userName.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        if (24 == variableId) {
            setQuestionbind((Data) variable);
            return true;
        }
        if (23 == variableId) {
            setOptionwebadapter((OptionWebAdapter) variable);
            return true;
        }
        if (22 != variableId) {
            return false;
        }
        setOptionadapter((OptionAdapter) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.QuestionViewBinding
    public void setQuestionbind(Data Questionbind) {
        this.mQuestionbind = Questionbind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // com.appnew.android.databinding.QuestionViewBinding
    public void setOptionwebadapter(OptionWebAdapter Optionwebadapter) {
        this.mOptionwebadapter = Optionwebadapter;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // com.appnew.android.databinding.QuestionViewBinding
    public void setOptionadapter(OptionAdapter Optionadapter) {
        this.mOptionadapter = Optionadapter;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String name;
        String meta_url;
        String schedule_date;
        String str6;
        String str7;
        String total_comments;
        Json json;
        String profile_picture;
        String total_likes;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mQuestionbind;
        OptionWebAdapter optionWebAdapter = this.mOptionwebadapter;
        OptionAdapter optionAdapter = this.mOptionadapter;
        long j4 = j & 9;
        if (j4 != 0) {
            if (data != null) {
                name = data.getName();
                total_comments = data.getTotal_comments();
                meta_url = data.getMeta_url();
                json = data.getJson();
                String my_pinned = data.getMy_pinned();
                String my_like = data.getMy_like();
                profile_picture = data.getProfile_picture();
                total_likes = data.getTotal_likes();
                schedule_date = data.getSchedule_date();
                str6 = my_pinned;
                str7 = my_like;
                j2 = 0;
            } else {
                j2 = 0;
                schedule_date = null;
                str6 = null;
                str7 = null;
                name = null;
                total_comments = null;
                meta_url = null;
                json = null;
                profile_picture = null;
                total_likes = null;
            }
            j3 = 9;
            str3 = total_comments + " Comment";
            boolean zIsEmpty = meta_url != null ? meta_url.isEmpty() : false;
            if (j4 != 0) {
                j |= zIsEmpty ? 32L : 16L;
            }
            total_attempt = json != null ? json.getTotal_attempt() : null;
            boolean zEquals = str6 != null ? str6.equals("1") : false;
            if ((j & 9) != j2) {
                j |= zEquals ? 128L : 64L;
            }
            i = zIsEmpty ? 8 : 0;
            str4 = schedule_date;
            i = i;
            str5 = profile_picture;
            i = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            str = total_attempt;
            total_attempt = str7;
            str2 = total_likes;
        } else {
            j2 = 0;
            j3 = 9;
            i = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            name = null;
            meta_url = null;
        }
        long j5 = j & 10;
        long j6 = j & 12;
        if ((j & j3) != j2) {
            DataKt.viewlike(this.like, total_attempt);
            this.pinIV.setImageResource(i);
            ExtensionFucationKt.attempts(this.postAttempt, str);
            TextViewBindingAdapter.setText(this.postCommentCount, str3);
            ExtensionFucationKt.like(this.postLikeCount, str2);
            DataKt.loadImage(this.postTime, str4);
            DataKt.loadImage(this.profileImage, str5);
            this.questionTxt.setVisibility(i);
            ExtensionFucationKt.setwebview(this.questionTxt, meta_url);
            TextViewBindingAdapter.setText(this.userName, name);
        }
        if (j6 != j2) {
            DataKt.setAdapter(this.recyerclerView, optionAdapter);
        }
        if (j5 != j2) {
            DataKt.setAdapter(this.recyerclerViewWebview, optionWebAdapter);
        }
    }
}
