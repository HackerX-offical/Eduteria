package com.appnew.android.feeds.adapters;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.feeds.OptionItem;
import com.appnew.android.feeds.dataclass.Json;
import com.appnew.android.feeds.dataclass.Option;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: OptionWebAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001-B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bH\u0016J\u001c\u0010(\u001a\u00020)2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010+\u001a\u00020\u000bH\u0017J\b\u0010,\u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/appnew/android/feeds/adapters/OptionWebAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/feeds/adapters/OptionWebAdapter$OptionHolder;", "context", "Landroid/content/Context;", "optionList", "", "Lcom/appnew/android/feeds/dataclass/Option;", "optionItem", "Lcom/appnew/android/feeds/OptionItem;", "feedlistPos", "", "json", "Lcom/appnew/android/feeds/dataclass/Json;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/feeds/OptionItem;ILcom/appnew/android/feeds/dataclass/Json;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getOptionList", "()Ljava/util/List;", "setOptionList", "(Ljava/util/List;)V", "getOptionItem", "()Lcom/appnew/android/feeds/OptionItem;", "setOptionItem", "(Lcom/appnew/android/feeds/OptionItem;)V", "getFeedlistPos", "()I", "setFeedlistPos", "(I)V", "getJson", "()Lcom/appnew/android/feeds/dataclass/Json;", "setJson", "(Lcom/appnew/android/feeds/dataclass/Json;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "OptionHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionWebAdapter extends RecyclerView.Adapter<OptionHolder> {
    public static final int $stable = 8;
    private Context context;
    private int feedlistPos;
    private Json json;
    private OptionItem optionItem;
    private List<Option> optionList;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final List<Option> getOptionList() {
        return this.optionList;
    }

    public final void setOptionList(List<Option> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.optionList = list;
    }

    public final OptionItem getOptionItem() {
        return this.optionItem;
    }

    public final void setOptionItem(OptionItem optionItem) {
        this.optionItem = optionItem;
    }

    public final int getFeedlistPos() {
        return this.feedlistPos;
    }

    public final void setFeedlistPos(int i) {
        this.feedlistPos = i;
    }

    public final Json getJson() {
        return this.json;
    }

    public final void setJson(Json json) {
        Intrinsics.checkNotNullParameter(json, "<set-?>");
        this.json = json;
    }

    public OptionWebAdapter(Context context, List<Option> optionList, OptionItem optionItem, int i, Json json) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(optionList, "optionList");
        Intrinsics.checkNotNullParameter(json, "json");
        this.context = context;
        this.optionList = optionList;
        this.optionItem = optionItem;
        this.feedlistPos = i;
        this.json = json;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OptionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.option_web_adapter, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new OptionHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OptionHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (TextUtils.isEmpty(this.optionList.get(position).getOption())) {
            holder.getLayout_option().setVisibility(8);
        } else {
            holder.getLayout_option().setVisibility(0);
            if (StringsKt.contains$default((CharSequence) this.optionList.get(position).getOption(), (CharSequence) "<img src=", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.optionList.get(position).getOption(), (CharSequence) "math-tex", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.optionList.get(position).getOption(), (CharSequence) "https://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.optionList.get(position).getOption(), (CharSequence) "http://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.optionList.get(position).getOption(), (CharSequence) "<img style", false, 2, (Object) null)) {
                holder.getOption_txt().setVisibility(8);
                holder.getOptionTextTV().setVisibility(0);
                holder.getOptionTextTV().getSettings().setJavaScriptEnabled(true);
                Helper.TestWebHTMLLoad(holder.getOptionTextTV(), this.optionList.get(position).getOption());
            } else {
                holder.getOption_txt().setVisibility(0);
                holder.getOptionTextTV().setVisibility(8);
                String option = this.optionList.get(position).getOption();
                String str = option;
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "&lt", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "&gt", false, 2, (Object) null)) {
                    option = Html.fromHtml(option).toString();
                }
                Spanned spannedFromHtml = Html.fromHtml(option, 63);
                TextView option_txt = holder.getOption_txt();
                Intrinsics.checkNotNull(spannedFromHtml);
                option_txt.setText(StringsKt.trim(spannedFromHtml));
            }
        }
        if (StringsKt.equals$default(this.json.getAttempt_index(), "0", false, 2, null)) {
            holder.getOption_a().setImageResource(R.drawable.defaultholo);
            holder.getActiveProgress().setVisibility(4);
        } else {
            holder.getActiveProgress().setVisibility(0);
            if (this.json.getRight_ans().equals(this.json.getAttempt_index()) && Integer.parseInt(this.json.getRight_ans()) == position + 1) {
                holder.getActiveProgress().setProgress(100);
                holder.getOption_a().setImageResource(R.drawable.correct);
                holder.getActiveProgress().setProgressDrawable(this.context.getDrawable(R.drawable.progress_right));
            } else {
                String attempt_index = this.json.getAttempt_index();
                Intrinsics.checkNotNull(attempt_index);
                int i = position + 1;
                if (Integer.parseInt(attempt_index) == i) {
                    holder.getActiveProgress().setProgress(100);
                    holder.getActiveProgress().setProgressDrawable(this.context.getDrawable(R.drawable.progress_wrong));
                    holder.getOption_a().setImageResource(R.drawable.wrong);
                } else if (Integer.parseInt(this.json.getRight_ans()) == i) {
                    holder.getActiveProgress().setProgress(100);
                    holder.getOption_a().setImageResource(R.drawable.correct);
                    holder.getActiveProgress().setProgressDrawable(this.context.getDrawable(R.drawable.progress_right));
                } else {
                    holder.getActiveProgress().setVisibility(4);
                    holder.getActiveProgress().setProgress(0);
                    holder.getOption_a().setImageResource(R.drawable.defaultholo);
                }
            }
        }
        holder.getLayout_option().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.OptionWebAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OptionWebAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(OptionWebAdapter optionWebAdapter, int i, View view) {
        if (optionWebAdapter.json.getAttempt_index() == null || StringsKt.equals$default(optionWebAdapter.json.getAttempt_index(), "", false, 2, null) || StringsKt.equals$default(optionWebAdapter.json.getAttempt_index(), "0", false, 2, null)) {
            OptionItem optionItem = optionWebAdapter.optionItem;
            if (optionItem != null) {
                optionItem.itemSelect(optionWebAdapter.optionList.get(i), i, optionWebAdapter.feedlistPos);
                return;
            }
            return;
        }
        Toast.makeText(optionWebAdapter.context, "Already Attempted", 0).show();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.optionList.size();
    }

    /* JADX INFO: compiled from: OptionWebAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/appnew/android/feeds/adapters/OptionWebAdapter$OptionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/feeds/adapters/OptionWebAdapter;Landroid/view/View;)V", "option_a", "Landroid/widget/ImageView;", "getOption_a", "()Landroid/widget/ImageView;", "setOption_a", "(Landroid/widget/ImageView;)V", "option_txt", "Landroid/widget/TextView;", "getOption_txt", "()Landroid/widget/TextView;", "setOption_txt", "(Landroid/widget/TextView;)V", "layout_option", "Landroid/widget/RelativeLayout;", "getLayout_option", "()Landroid/widget/RelativeLayout;", "setLayout_option", "(Landroid/widget/RelativeLayout;)V", "optionTextTV", "Lcom/appnew/android/testmodule/mathview/MathView;", "getOptionTextTV", "()Lcom/appnew/android/testmodule/mathview/MathView;", "setOptionTextTV", "(Lcom/appnew/android/testmodule/mathview/MathView;)V", "activeProgress", "Landroid/widget/ProgressBar;", "getActiveProgress", "()Landroid/widget/ProgressBar;", "setActiveProgress", "(Landroid/widget/ProgressBar;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class OptionHolder extends RecyclerView.ViewHolder {
        private ProgressBar activeProgress;
        private RelativeLayout layout_option;
        private MathView optionTextTV;
        private ImageView option_a;
        private TextView option_txt;
        final /* synthetic */ OptionWebAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OptionHolder(OptionWebAdapter optionWebAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = optionWebAdapter;
            this.option_a = (ImageView) itemView.findViewById(R.id.option_a);
            this.option_txt = (TextView) itemView.findViewById(R.id.optionTextTV2);
            this.layout_option = (RelativeLayout) itemView.findViewById(R.id.layout_option);
            this.optionTextTV = (MathView) itemView.findViewById(R.id.optionTextTV);
            this.activeProgress = (ProgressBar) itemView.findViewById(R.id.activeProgress);
        }

        public final ImageView getOption_a() {
            return this.option_a;
        }

        public final void setOption_a(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.option_a = imageView;
        }

        public final TextView getOption_txt() {
            return this.option_txt;
        }

        public final void setOption_txt(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.option_txt = textView;
        }

        public final RelativeLayout getLayout_option() {
            return this.layout_option;
        }

        public final void setLayout_option(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.layout_option = relativeLayout;
        }

        public final MathView getOptionTextTV() {
            return this.optionTextTV;
        }

        public final void setOptionTextTV(MathView mathView) {
            Intrinsics.checkNotNullParameter(mathView, "<set-?>");
            this.optionTextTV = mathView;
        }

        public final ProgressBar getActiveProgress() {
            return this.activeProgress;
        }

        public final void setActiveProgress(ProgressBar progressBar) {
            Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
            this.activeProgress = progressBar;
        }
    }
}
