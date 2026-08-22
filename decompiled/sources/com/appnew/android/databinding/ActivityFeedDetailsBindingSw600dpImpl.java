package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.dataclass.DataKt;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.android.feeds.viewmodel.FeedDetailViewModel;
import com.appnew.android.table.PostDataTable;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ActivityFeedDetailsBindingSw600dpImpl extends ActivityFeedDetailsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final NoDataFoundBinding mboundView01;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.feeds_toolbar, 14);
        sparseIntArray.put(R.id.image_back, 15);
        sparseIntArray.put(R.id.scroll_nested, 16);
        sparseIntArray.put(R.id.post_subject, 17);
        sparseIntArray.put(R.id.view_layout, 18);
        sparseIntArray.put(R.id.article_layout, 19);
        sparseIntArray.put(R.id.article_txt_top, 20);
        sparseIntArray.put(R.id.article_txt, 21);
        sparseIntArray.put(R.id.read_more, 22);
        sparseIntArray.put(R.id.image_layout, 23);
        sparseIntArray.put(R.id.image_constraint_layout, 24);
        sparseIntArray.put(R.id.image_text, 25);
        sparseIntArray.put(R.id.image_read_more, 26);
        sparseIntArray.put(R.id.video_layout, 27);
        sparseIntArray.put(R.id.audio_constraint_layout, 28);
        sparseIntArray.put(R.id.play_video, 29);
        sparseIntArray.put(R.id.video_text, 30);
        sparseIntArray.put(R.id.video_read_more, 31);
        sparseIntArray.put(R.id.audio_layout, 32);
        sparseIntArray.put(R.id.auido_layout, 33);
        sparseIntArray.put(R.id.play_icon, 34);
        sparseIntArray.put(R.id.audio_text, 35);
        sparseIntArray.put(R.id.link_layout, 36);
        sparseIntArray.put(R.id.constraint_link_image, 37);
        sparseIntArray.put(R.id.link_txt, 38);
        sparseIntArray.put(R.id.question_layout, 39);
        sparseIntArray.put(R.id.recyercler_view, 40);
        sparseIntArray.put(R.id.quiz_layout, 41);
        sparseIntArray.put(R.id.img, 42);
        sparseIntArray.put(R.id.test_name, 43);
        sparseIntArray.put(R.id.test_info, 44);
        sparseIntArray.put(R.id.total_question, 45);
        sparseIntArray.put(R.id.total_min, 46);
        sparseIntArray.put(R.id.start_quiz, 47);
        sparseIntArray.put(R.id.like_comment_count_layout, 48);
        sparseIntArray.put(R.id.post_attempt, 49);
        sparseIntArray.put(R.id.view_comment, 50);
        sparseIntArray.put(R.id.view, 51);
        sparseIntArray.put(R.id.like_comment_layout, 52);
        sparseIntArray.put(R.id.post_comment, 53);
        sparseIntArray.put(R.id.whatsapp_share, 54);
        sparseIntArray.put(R.id.postShare, 55);
        sparseIntArray.put(R.id.view1, 56);
        sparseIntArray.put(R.id.realted, 57);
    }

    public ActivityFeedDetailsBindingSw600dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 58, sIncludes, sViewsWithIds));
    }

    private ActivityFeedDetailsBindingSw600dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RelativeLayout) bindings[19], (TextView) bindings[21], (TextView) bindings[20], (ConstraintLayout) bindings[28], (RelativeLayout) bindings[32], (TextView) bindings[35], (RelativeLayout) bindings[33], (ConstraintLayout) bindings[37], (Toolbar) bindings[14], (ImageView) bindings[15], (ConstraintLayout) bindings[24], (RelativeLayout) bindings[23], (TextView) bindings[26], (TextView) bindings[25], (ImageView) bindings[42], (ImageView) bindings[5], (TextView) bindings[11], (LinearLayout) bindings[48], (LinearLayout) bindings[52], (ImageView) bindings[7], (RelativeLayout) bindings[36], (TextView) bindings[38], (RecyclerView) bindings[12], (ImageView) bindings[3], (ImageView) bindings[34], (ImageView) bindings[29], (TextView) bindings[49], (TextView) bindings[53], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[55], (TextView) bindings[17], (TextView) bindings[4], (CircleImageView) bindings[1], (RelativeLayout) bindings[39], (ClickableWebView) bindings[8], (RelativeLayout) bindings[41], (TextView) bindings[22], (TextView) bindings[57], (RecyclerView) bindings[40], (NestedScrollView) bindings[16], (Button) bindings[47], (LinearLayout) bindings[44], (TextView) bindings[43], (TextView) bindings[46], (TextView) bindings[45], (TextView) bindings[2], (RelativeLayout) bindings[27], (TextView) bindings[31], (TextView) bindings[30], (ImageView) bindings[6], (View) bindings[51], (View) bindings[56], (View) bindings[50], (RelativeLayout) bindings[18], (LinearLayout) bindings[54]);
        this.mDirtyFlags = -1L;
        this.imgeView.setTag(null);
        this.like.setTag(null);
        this.linkImage.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        Object obj = bindings[13];
        this.mboundView01 = obj != null ? NoDataFoundBinding.bind((View) obj) : null;
        this.newCourseRecycler.setTag(null);
        this.pinIV.setTag(null);
        this.postCommentCount.setTag(null);
        this.postLikeCount.setTag(null);
        this.postTime.setTag(null);
        this.profileImage.setTag(null);
        this.questionTxt.setTag(null);
        this.userName.setTag(null);
        this.videoThumbnail.setTag(null);
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
        if (11 == variableId) {
            setFeeddetailVm((FeedDetailViewModel) variable);
            return true;
        }
        if (10 != variableId) {
            return false;
        }
        setFeeddatatable((PostDataTable) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.ActivityFeedDetailsBinding
    public void setFeeddetailVm(FeedDetailViewModel FeeddetailVm) {
        this.mFeeddetailVm = FeeddetailVm;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // com.appnew.android.databinding.ActivityFeedDetailsBinding
    public void setFeeddatatable(PostDataTable Feeddatatable) {
        this.mFeeddatatable = Feeddatatable;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeFeeddetailVmRelatedCourse((LiveData) object, fieldId);
    }

    private boolean onChangeFeeddetailVmRelatedCourse(LiveData<List<NewCourseData>> FeeddetailVmRelatedCourse, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        List<NewCourseData> value;
        long j2;
        long j3;
        int i2;
        int i3;
        long j4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String meta_url;
        String str8;
        long j5;
        String str9;
        String str10;
        String thumbnail;
        String name;
        String created;
        String profile_picture;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FeedDetailViewModel feedDetailViewModel = this.mFeeddetailVm;
        PostDataTable postDataTable = this.mFeeddatatable;
        long j6 = j & 11;
        boolean z = false;
        if (j6 != 0) {
            LiveData<List<NewCourseData>> relatedCourse = feedDetailViewModel != null ? feedDetailViewModel.getRelatedCourse() : null;
            updateLiveDataRegistration(0, relatedCourse);
            value = relatedCourse != null ? relatedCourse.getValue() : null;
            boolean z2 = value == null;
            if (j6 != 0) {
                j |= z2 ? 512L : 256L;
            }
            i = z2 ? 8 : 0;
        } else {
            i = 0;
            value = null;
        }
        long j7 = j & 12;
        if (j7 != 0) {
            if (postDataTable != null) {
                String total_comments = postDataTable.getTotal_comments();
                String my_like = postDataTable.getMy_like();
                thumbnail = postDataTable.getThumbnail();
                name = postDataTable.getName();
                created = postDataTable.getCreated();
                profile_picture = postDataTable.getProfile_picture();
                String my_pinned = postDataTable.getMy_pinned();
                String total_likes = postDataTable.getTotal_likes();
                meta_url = postDataTable.getMeta_url();
                str9 = total_comments;
                str2 = my_like;
                j2 = 0;
                str10 = my_pinned;
                str3 = total_likes;
                j3 = 11;
            } else {
                j2 = 0;
                j3 = 11;
                str9 = null;
                str2 = null;
                str10 = null;
                str3 = null;
                thumbnail = null;
                name = null;
                created = null;
                profile_picture = null;
                meta_url = null;
            }
            str = str9 + " Comment";
            boolean z3 = meta_url != null;
            if (j7 != 0) {
                j |= z3 ? 128L : 64L;
            }
            boolean zEquals = str10 != null ? str10.equals("1") : false;
            if ((j & 12) != j2) {
                j |= zEquals ? 32L : 16L;
            }
            boolean zIsEmpty = meta_url != null ? meta_url.isEmpty() : false;
            if ((j & 12) != j2) {
                j |= zIsEmpty ? 2048L : 1024L;
            }
            i2 = zEquals ? R.mipmap.pinned : R.mipmap.unpinned;
            i3 = zIsEmpty ? 8 : 0;
            z = z3;
            str4 = thumbnail;
            str5 = name;
            j4 = 12;
            str6 = created;
            str7 = profile_picture;
        } else {
            j2 = 0;
            j3 = 11;
            i2 = 0;
            i3 = 0;
            j4 = 12;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            meta_url = null;
        }
        long j8 = j & j4;
        if (j8 != j2) {
            if (!z) {
                meta_url = "";
            }
            str8 = meta_url;
        } else {
            str8 = null;
        }
        if (j8 != j2) {
            j5 = j;
            DataKt.imagedetailsfeedPost(this.imgeView, postDataTable);
            DataKt.viewlike(this.like, str2);
            DataKt.imagepost(this.linkImage, str4);
            this.pinIV.setImageResource(i2);
            TextViewBindingAdapter.setText(this.postCommentCount, str);
            ExtensionFucationKt.like(this.postLikeCount, str3);
            DataKt.loadImage(this.postTime, str6);
            DataKt.loadImage(this.profileImage, str7);
            this.questionTxt.setVisibility(i3);
            ExtensionFucationKt.setwebview(this.questionTxt, str8);
            TextViewBindingAdapter.setText(this.userName, str5);
            DataKt.imagepost(this.videoThumbnail, str4);
        } else {
            j5 = j;
        }
        if ((j5 & j3) != j2) {
            this.newCourseRecycler.setVisibility(i);
            ExtensionFucationKt.courseadapter(this.newCourseRecycler, value);
        }
    }
}
