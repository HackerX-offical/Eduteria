package com.appnew.android.feeds.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: NewCourseAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0017J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u001e\u0010\u001c\u001a\u00020\u00182\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/appnew/android/feeds/adapters/NewCourseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/feeds/adapters/NewCourseAdapter$NewCourseVH;", "<init>", "()V", "new_course_data", "", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "getNew_course_data", "()Ljava/util/List;", "setNew_course_data", "(Ljava/util/List;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "updateItems", "data", "contxt", "NewCourseVH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewCourseAdapter extends RecyclerView.Adapter<NewCourseVH> {
    public static final int $stable = 8;
    private Context context;
    private List<NewCourseData> new_course_data = CollectionsKt.emptyList();

    public final List<NewCourseData> getNew_course_data() {
        return this.new_course_data;
    }

    public final void setNew_course_data(List<NewCourseData> list) {
        this.new_course_data = list;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NewCourseVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.new_course_adapter, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new NewCourseVH(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NewCourseVH holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<NewCourseData> list = this.new_course_data;
        Intrinsics.checkNotNull(list);
        NewCourseData newCourseData = list.get(position);
        if (!TextUtils.isEmpty(newCourseData.getCover_image())) {
            Context context = this.context;
            String cover_image = newCourseData.getCover_image();
            Context context2 = this.context;
            Intrinsics.checkNotNull(context2);
            Helper.setThumbnailImage(context, cover_image, context2.getResources().getDrawable(R.mipmap.book_placeholder), holder.getCourse_thumbnail());
        } else {
            holder.getCourse_thumbnail().setImageResource(R.mipmap.book_placeholder);
        }
        holder.getCourse_name().setText(newCourseData.getTitle());
        if (StringsKt.equals(newCourseData.getValidity(), "0", true)) {
            holder.getValidityTextTV().setVisibility(8);
        } else {
            holder.getValidityTextTV().setVisibility(0);
        }
        holder.getParent_layout().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.NewCourseAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewCourseAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
        if (StringsKt.equals(newCourseData.getCourse_sp(), "0", true)) {
            TextView price = holder.getPrice();
            Context context3 = this.context;
            Intrinsics.checkNotNull(context3);
            price.setText(context3.getResources().getString(R.string.free));
            holder.getPrice().setTextAlignment(2);
            TextView validityTextTV = holder.getValidityTextTV();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Context context4 = this.context;
            Intrinsics.checkNotNull(context4);
            String str = String.format("%s %s", Arrays.copyOf(new Object[]{context4.getResources().getString(R.string.validity), newCourseData.getValidity()}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            validityTextTV.setText(str);
            holder.getMrpCutTV().setVisibility(8);
            return;
        }
        if (StringsKt.equals(newCourseData.getCourse_sp(), newCourseData.getMrp(), true)) {
            holder.getMrpCutTV().setVisibility(8);
            TextView validityTextTV2 = holder.getValidityTextTV();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Context context5 = this.context;
            Intrinsics.checkNotNull(context5);
            String str2 = String.format("%s %s", Arrays.copyOf(new Object[]{context5.getResources().getString(R.string.validity), newCourseData.getValidity(), Boolean.valueOf(StringsKt.equals(newCourseData.getValidity(), "0", true))}, 3));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            validityTextTV2.setText(str2);
            TextView price2 = holder.getPrice();
            Context context6 = this.context;
            Intrinsics.checkNotNull(context6);
            price2.setText(context6.getResources().getString(R.string.rs) + newCourseData.getMrp() + "/-");
            return;
        }
        TextView price3 = holder.getPrice();
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        Context context7 = this.context;
        Intrinsics.checkNotNull(context7);
        String str3 = String.format("%s %s %s", Arrays.copyOf(new Object[]{context7.getResources().getString(R.string.rs), newCourseData.getCourse_sp(), "/-"}, 3));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        price3.setText(str3);
        TextView mrpCutTV = holder.getMrpCutTV();
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        Context context8 = this.context;
        Intrinsics.checkNotNull(context8);
        String str4 = String.format("%s %s %s", Arrays.copyOf(new Object[]{context8.getResources().getString(R.string.rs), newCourseData.getMrp(), "/-"}, 3));
        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
        mrpCutTV.setText(str4, TextView.BufferType.SPANNABLE);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        CharSequence text = holder.getMrpCutTV().getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
        holder.getMrpCutTV().setVisibility(0);
        ((Spannable) text).setSpan(strikethroughSpan, 2, newCourseData.getMrp().length() + 2, 33);
        TextView validityTextTV3 = holder.getValidityTextTV();
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        Context context9 = this.context;
        Intrinsics.checkNotNull(context9);
        String str5 = String.format("%s %s", Arrays.copyOf(new Object[]{context9.getResources().getString(R.string.validity), newCourseData.getValidity(), Boolean.valueOf(StringsKt.equals(newCourseData.getValidity(), "0", true))}, 3));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        validityTextTV3.setText(str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(NewCourseAdapter newCourseAdapter, int i, View view) {
        List<NewCourseData> list = newCourseAdapter.new_course_data;
        Intrinsics.checkNotNull(list);
        NewCourseData newCourseData = list.get(i);
        Intent intent = new Intent(newCourseAdapter.context, (Class<?>) CourseActivity.class);
        if (StringsKt.equals("1", "6", true)) {
            intent.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
        } else {
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        }
        intent.putExtra(Const.COURSE_ID_MAIN, newCourseData.getId());
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, newCourseData.getTitle());
        Context context = newCourseAdapter.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Helper.gotoActivity(intent, (Activity) context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<NewCourseData> list = this.new_course_data;
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    public final void updateItems(List<NewCourseData> data, Context contxt) {
        Intrinsics.checkNotNullParameter(contxt, "contxt");
        this.new_course_data = data;
        this.context = contxt;
    }

    /* JADX INFO: compiled from: NewCourseAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/appnew/android/feeds/adapters/NewCourseAdapter$NewCourseVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/feeds/adapters/NewCourseAdapter;Landroid/view/View;)V", "course_thumbnail", "Lcom/makeramen/roundedimageview/RoundedImageView;", "getCourse_thumbnail", "()Lcom/makeramen/roundedimageview/RoundedImageView;", "setCourse_thumbnail", "(Lcom/makeramen/roundedimageview/RoundedImageView;)V", "validityTextTV", "Landroid/widget/TextView;", "getValidityTextTV", "()Landroid/widget/TextView;", "setValidityTextTV", "(Landroid/widget/TextView;)V", FirebaseAnalytics.Param.PRICE, "getPrice", "setPrice", "mrpCutTV", "getMrpCutTV", "setMrpCutTV", AnalyticsConstants.course_name, "getCourse_name", "setCourse_name", "parent_layout", "Landroid/widget/RelativeLayout;", "getParent_layout", "()Landroid/widget/RelativeLayout;", "setParent_layout", "(Landroid/widget/RelativeLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NewCourseVH extends RecyclerView.ViewHolder {
        private TextView course_name;
        private RoundedImageView course_thumbnail;
        private TextView mrpCutTV;
        private RelativeLayout parent_layout;
        private TextView price;
        final /* synthetic */ NewCourseAdapter this$0;
        private TextView validityTextTV;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewCourseVH(NewCourseAdapter newCourseAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = newCourseAdapter;
            this.course_thumbnail = (RoundedImageView) itemView.findViewById(R.id.course_thumbnail);
            this.validityTextTV = (TextView) itemView.findViewById(R.id.course_validty);
            this.parent_layout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
            this.course_name = (TextView) itemView.findViewById(R.id.course_name);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
        }

        public final RoundedImageView getCourse_thumbnail() {
            return this.course_thumbnail;
        }

        public final void setCourse_thumbnail(RoundedImageView roundedImageView) {
            Intrinsics.checkNotNullParameter(roundedImageView, "<set-?>");
            this.course_thumbnail = roundedImageView;
        }

        public final TextView getValidityTextTV() {
            return this.validityTextTV;
        }

        public final void setValidityTextTV(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.validityTextTV = textView;
        }

        public final TextView getPrice() {
            return this.price;
        }

        public final void setPrice(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.price = textView;
        }

        public final TextView getMrpCutTV() {
            return this.mrpCutTV;
        }

        public final void setMrpCutTV(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mrpCutTV = textView;
        }

        public final TextView getCourse_name() {
            return this.course_name;
        }

        public final void setCourse_name(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.course_name = textView;
        }

        public final RelativeLayout getParent_layout() {
            return this.parent_layout;
        }

        public final void setParent_layout(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.parent_layout = relativeLayout;
        }
    }
}
