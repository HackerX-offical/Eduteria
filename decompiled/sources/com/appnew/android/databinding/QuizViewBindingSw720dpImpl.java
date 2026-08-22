package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
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
import com.appnew.android.feeds.dataclass.Json;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public class QuizViewBindingSw720dpImpl extends QuizViewBinding {
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
        sparseIntArray.put(R.id.quiz_layout, 13);
        sparseIntArray.put(R.id.img, 14);
        sparseIntArray.put(R.id.test_info, 15);
        sparseIntArray.put(R.id.like_comment_count_layout, 16);
        sparseIntArray.put(R.id.view_comment, 17);
        sparseIntArray.put(R.id.view, 18);
        sparseIntArray.put(R.id.like_comment_layout, 19);
        sparseIntArray.put(R.id.post_comment, 20);
        sparseIntArray.put(R.id.whatsapp_share, 21);
        sparseIntArray.put(R.id.shareImage, 22);
        sparseIntArray.put(R.id.postShare, 23);
        sparseIntArray.put(R.id.view1, 24);
    }

    public QuizViewBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }

    private QuizViewBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[14], (TextView) bindings[11], (LinearLayout) bindings[16], (LinearLayout) bindings[19], (ImageView) bindings[3], (TextView) bindings[20], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[23], (TextView) bindings[12], (TextView) bindings[4], (CircleImageView) bindings[1], (RelativeLayout) bindings[13], (ImageView) bindings[22], (Button) bindings[8], (LinearLayout) bindings[15], (TextView) bindings[5], (TextView) bindings[7], (TextView) bindings[6], (TextView) bindings[2], (View) bindings[18], (View) bindings[24], (View) bindings[17], (LinearLayout) bindings[21]);
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
        this.startQuiz.setTag(null);
        this.testName.setTag(null);
        this.totalMin.setTag(null);
        this.totalQuestion.setTag(null);
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
        if (25 != variableId) {
            return false;
        }
        setQuizbind((Data) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.QuizViewBinding
    public void setQuizbind(Data Quizbind) {
        this.mQuizbind = Quizbind;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
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
        String test_series_name;
        String str5;
        String str6;
        String str7;
        String total_likes;
        String schedule_date;
        String name;
        String total_comments;
        String my_like;
        String my_pinned;
        String profile_picture;
        Json json;
        String time_in_mins;
        String state;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Data data = this.mQuizbind;
        long j4 = j & 3;
        String total_questions = null;
        if (j4 != 0) {
            if (data != null) {
                name = data.getName();
                total_comments = data.getTotal_comments();
                my_like = data.getMy_like();
                my_pinned = data.getMy_pinned();
                total_likes = data.getTotal_likes();
                profile_picture = data.getProfile_picture();
                json = data.getJson();
                schedule_date = data.getSchedule_date();
            } else {
                schedule_date = null;
                name = null;
                total_comments = null;
                my_like = null;
                my_pinned = null;
                total_likes = null;
                profile_picture = null;
                json = null;
            }
            j2 = 0;
            str = total_comments + " Comment";
            boolean zEquals = my_pinned != null ? my_pinned.equals("1") : false;
            if (j4 != 0) {
                j |= zEquals ? 32L : 16L;
            }
            if (json != null) {
                total_questions = json.getTotal_questions();
                test_series_name = json.getTest_series_name();
                time_in_mins = json.getTime_in_mins();
                state = json.getState();
            } else {
                test_series_name = null;
                time_in_mins = null;
                state = null;
            }
            int i2 = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            j3 = 3;
            String str8 = total_questions + " Questions";
            String str9 = time_in_mins + " Minutes";
            boolean zIsEmpty = test_series_name != null ? test_series_name.isEmpty() : false;
            if ((j & 3) != 0) {
                j |= zIsEmpty ? 128L : 64L;
            }
            boolean zEqualsIgnoreCase = state != null ? state.equalsIgnoreCase("1") : false;
            if ((j & 3) != 0) {
                j |= zEqualsIgnoreCase ? 8L : 4L;
            }
            i = zIsEmpty ? 8 : 0;
            str4 = zEqualsIgnoreCase ? "View Result" : "Start QUIZ";
            int i3 = i2;
            str2 = schedule_date;
            i = i;
            i = i3;
            str6 = str8;
            total_questions = my_like;
            str7 = name;
            str5 = str9;
            str3 = profile_picture;
        } else {
            j2 = 0;
            j3 = 3;
            i = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            test_series_name = null;
            str5 = null;
            str6 = null;
            str7 = null;
            total_likes = null;
        }
        if ((j & j3) != j2) {
            DataKt.viewlike(this.like, total_questions);
            this.pinIV.setImageResource(i);
            TextViewBindingAdapter.setText(this.postCommentCount, str);
            ExtensionFucationKt.like(this.postLikeCount, total_likes);
            DataKt.loadImage(this.postTime, str2);
            DataKt.loadImage(this.profileImage, str3);
            TextViewBindingAdapter.setText(this.startQuiz, str4);
            TextViewBindingAdapter.setText(this.testName, test_series_name);
            this.testName.setVisibility(i);
            TextViewBindingAdapter.setText(this.totalMin, str5);
            TextViewBindingAdapter.setText(this.totalQuestion, str6);
            TextViewBindingAdapter.setText(this.userName, str7);
        }
    }
}
