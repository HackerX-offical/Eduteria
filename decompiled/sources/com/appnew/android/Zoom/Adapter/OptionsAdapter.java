package com.appnew.android.Zoom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.ZoomModel.OptionsModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.testmodule.mathview.MathView;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: OptionsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/OptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/OptionsAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/OptionsModel;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getdate", "", "timestamp", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private final ArrayList<OptionsModel> data;
    private Integer pos;

    public OptionsAdapter(ArrayList<OptionsModel> data, Context context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = data;
        this.context = context;
        this.pos = 0;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_option_test_view, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.data.get(position).getOption() != null) {
            OptionsModel optionsModel = this.data.get(position);
            Intrinsics.checkNotNullExpressionValue(optionsModel, "get(...)");
            OptionsModel optionsModel2 = optionsModel;
            holder.getOptionIconTV().setText(optionsModel2.getOptionType());
            holder.getOptionTextTV2().setVisibility(8);
            String option = optionsModel2.getOption();
            if (option != null && option.length() != 0) {
                Helper.testOptionFont(holder.getOptionTextTV(), optionsModel2.getOption(), "2");
            } else {
                holder.getOptionTextTV().setVisibility(8);
                holder.getOptionTextTV2().setVisibility(0);
            }
            if (optionsModel2.getAnswer() != null) {
                String answer = optionsModel2.getAnswer();
                Intrinsics.checkNotNullExpressionValue(answer, "getAnswer(...)");
                if (answer.length() == 0) {
                    return;
                }
                ArrayList<Integer> arrayList = new ArrayList();
                String answer2 = optionsModel2.getAnswer();
                Intrinsics.checkNotNullExpressionValue(answer2, "getAnswer(...)");
                for (String str : StringsKt.split$default((CharSequence) answer2, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null)) {
                    int length = str.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    String string = str.subSequence(i, length + 1).toString();
                    if (string.length() != 0) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(string)));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                for (Integer num : arrayList) {
                    int i2 = position + 1;
                    if (num != null && num.intValue() == i2) {
                        holder.getViewLL().setBackgroundResource(com.appnew.android.R.drawable.bg_mcq_selected);
                    } else {
                        holder.getViewLL().setBackgroundResource(R.drawable.background_mcq);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: OptionsAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/OptionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "optionIconTV", "Landroid/widget/TextView;", "getOptionIconTV", "()Landroid/widget/TextView;", "setOptionIconTV", "(Landroid/widget/TextView;)V", "optionTextTV2", "getOptionTextTV2", "setOptionTextTV2", "viewLL", "Landroid/widget/LinearLayout;", "getViewLL", "()Landroid/widget/LinearLayout;", "setViewLL", "(Landroid/widget/LinearLayout;)V", "optionTextTV", "Lcom/appnew/android/testmodule/mathview/MathView;", "getOptionTextTV", "()Lcom/appnew/android/testmodule/mathview/MathView;", "setOptionTextTV", "(Lcom/appnew/android/testmodule/mathview/MathView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView optionIconTV;
        private MathView optionTextTV;
        private TextView optionTextTV2;
        private LinearLayout viewLL;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.optionIconTV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.optionIconTV = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.optionTextTV2);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.optionTextTV2 = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.viewLL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.viewLL = (LinearLayout) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.optionTextTV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.optionTextTV = (MathView) viewFindViewById4;
        }

        public final TextView getOptionIconTV() {
            return this.optionIconTV;
        }

        public final void setOptionIconTV(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.optionIconTV = textView;
        }

        public final TextView getOptionTextTV2() {
            return this.optionTextTV2;
        }

        public final void setOptionTextTV2(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.optionTextTV2 = textView;
        }

        public final LinearLayout getViewLL() {
            return this.viewLL;
        }

        public final void setViewLL(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.viewLL = linearLayout;
        }

        public final MathView getOptionTextTV() {
            return this.optionTextTV;
        }

        public final void setOptionTextTV(MathView mathView) {
            Intrinsics.checkNotNullParameter(mathView, "<set-?>");
            this.optionTextTV = mathView;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }
}
