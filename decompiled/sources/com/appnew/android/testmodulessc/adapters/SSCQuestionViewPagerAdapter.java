package com.appnew.android.testmodulessc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ItemSscPatternQuestionViewpagerBinding;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.appnew.android.testmodulessc.models.SSCQuestion;
import com.appnew.android.testmodulessc.models.SSCTestOption;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX INFO: compiled from: SSCQuestionViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014Bª\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J&\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020\tH\u0016J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*H\u0002J \u0010+\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0002J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0/2\u0006\u00100\u001a\u00020\bH\u0002J\u001e\u00101\u001a\u00020\u000f2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030!2\u0006\u0010%\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCQuestionViewPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/testmodulessc/adapters/SSCQuestionViewPagerAdapter$VH;", "questions", "", "Lcom/appnew/android/testmodulessc/models/SSCQuestion;", "sectionStartIndex", "", "", "", "onAnswerChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "questionPos", "", "isQuestionReported", "", "isReportDisabled", "Lkotlin/Function0;", "onBookmarkClicked", "onMarkForReviewClicked", "onReportErrorClicked", "<init>", "(Ljava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", Const.POSITION, "payloads", "", "", "getItemCount", "updateQuestionNumberUI", XHTMLText.Q, "updateMarkForReviewUI", "isMarked", "updateBookmarkUI", Const.QUESTION, "Lcom/appnew/android/testmodule/model/Question;", "updateReportErrorUI", "isReported", "isDisabled", "formatFIBQuestion", "Lkotlin/Pair;", "html", "restoreSelection", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/appnew/android/testmodulessc/models/SSCTestOption;", "VH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCQuestionViewPagerAdapter extends RecyclerView.Adapter<VH> {
    public static final int $stable = 8;
    private final Function1<SSCQuestion, Boolean> isQuestionReported;
    private final Function0<Boolean> isReportDisabled;
    private final Function1<Integer, Unit> onAnswerChanged;
    private final Function1<SSCQuestion, Unit> onBookmarkClicked;
    private final Function1<SSCQuestion, Unit> onMarkForReviewClicked;
    private final Function1<SSCQuestion, Unit> onReportErrorClicked;
    private final List<SSCQuestion> questions;
    private final Map<String, Integer> sectionStartIndex;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((VH) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSCQuestionViewPagerAdapter(List<SSCQuestion> questions, Map<String, Integer> sectionStartIndex, Function1<? super Integer, Unit> onAnswerChanged, Function1<? super SSCQuestion, Boolean> isQuestionReported, Function0<Boolean> isReportDisabled, Function1<? super SSCQuestion, Unit> onBookmarkClicked, Function1<? super SSCQuestion, Unit> onMarkForReviewClicked, Function1<? super SSCQuestion, Unit> onReportErrorClicked) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        Intrinsics.checkNotNullParameter(sectionStartIndex, "sectionStartIndex");
        Intrinsics.checkNotNullParameter(onAnswerChanged, "onAnswerChanged");
        Intrinsics.checkNotNullParameter(isQuestionReported, "isQuestionReported");
        Intrinsics.checkNotNullParameter(isReportDisabled, "isReportDisabled");
        Intrinsics.checkNotNullParameter(onBookmarkClicked, "onBookmarkClicked");
        Intrinsics.checkNotNullParameter(onMarkForReviewClicked, "onMarkForReviewClicked");
        Intrinsics.checkNotNullParameter(onReportErrorClicked, "onReportErrorClicked");
        this.questions = questions;
        this.sectionStartIndex = sectionStartIndex;
        this.onAnswerChanged = onAnswerChanged;
        this.isQuestionReported = isQuestionReported;
        this.isReportDisabled = isReportDisabled;
        this.onBookmarkClicked = onBookmarkClicked;
        this.onMarkForReviewClicked = onMarkForReviewClicked;
        this.onReportErrorClicked = onReportErrorClicked;
    }

    /* JADX INFO: compiled from: SSCQuestionViewPagerAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCQuestionViewPagerAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemSscPatternQuestionViewpagerBinding;", "<init>", "(Lcom/appnew/android/databinding/ItemSscPatternQuestionViewpagerBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemSscPatternQuestionViewpagerBinding;", "optionAdapter", "Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter;", "getOptionAdapter", "()Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter;", "setOptionAdapter", "(Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter;)V", "boundQuestionId", "", "getBoundQuestionId", "()Ljava/lang/String;", "setBoundQuestionId", "(Ljava/lang/String;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VH extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ItemSscPatternQuestionViewpagerBinding binding;
        private String boundQuestionId;
        private SSCTestOptionAdapter optionAdapter;

        public final ItemSscPatternQuestionViewpagerBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemSscPatternQuestionViewpagerBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final SSCTestOptionAdapter getOptionAdapter() {
            return this.optionAdapter;
        }

        public final void setOptionAdapter(SSCTestOptionAdapter sSCTestOptionAdapter) {
            this.optionAdapter = sSCTestOptionAdapter;
        }

        public final String getBoundQuestionId() {
            return this.boundQuestionId;
        }

        public final void setBoundQuestionId(String str) {
            this.boundQuestionId = str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSscPatternQuestionViewpagerBinding itemSscPatternQuestionViewpagerBindingInflate = ItemSscPatternQuestionViewpagerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSscPatternQuestionViewpagerBindingInflate, "inflate(...)");
        return new VH(itemSscPatternQuestionViewpagerBindingInflate);
    }

    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            SSCQuestion sSCQuestion = this.questions.get(position);
            for (Object obj : payloads) {
                if (Intrinsics.areEqual(obj, SSCQuestionViewPagerAdapterKt.PAYLOAD_TIMER)) {
                    TextView textView = holder.getBinding().tvTimer;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(sSCQuestion.getOriginal().getTotalTimeSpent() / 60), Integer.valueOf(sSCQuestion.getOriginal().getTotalTimeSpent() % 60)}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    textView.setText(str);
                } else if (Intrinsics.areEqual(obj, SSCQuestionViewPagerAdapterKt.PAYLOAD_REVIEW) || Intrinsics.areEqual(obj, SSCQuestionViewPagerAdapterKt.PAYLOAD_ANSWER)) {
                    updateMarkForReviewUI(holder, sSCQuestion.getOriginal().isMarkForReview());
                    updateQuestionNumberUI(holder, sSCQuestion);
                    updateReportErrorUI(holder, this.isQuestionReported.invoke(sSCQuestion).booleanValue(), this.isReportDisabled.invoke().booleanValue());
                } else if (Intrinsics.areEqual(obj, SSCQuestionViewPagerAdapterKt.PAYLOAD_BOOKMARK)) {
                    updateBookmarkUI(holder, sSCQuestion.getOriginal());
                } else if (Intrinsics.areEqual(obj, SSCQuestionViewPagerAdapterKt.PAYLOAD_LANGUAGE)) {
                    if (StringsKt.equals(sSCQuestion.getQuestionType(), "FIB", true)) {
                        String strComponent1 = formatFIBQuestion(sSCQuestion.getQuestionHtml()).component1();
                        if (!Intrinsics.areEqual(holder.getBinding().tvQuestionText.getTag(), strComponent1)) {
                            holder.getBinding().tvQuestionText.setTag(strComponent1);
                            String font_type = sSCQuestion.getOriginal().getFont_type();
                            if (Intrinsics.areEqual(font_type, "1") || Intrinsics.areEqual(font_type, "2")) {
                                Helper.testOptionFont(holder.getBinding().tvQuestionText, strComponent1, font_type);
                            } else {
                                Helper.TestWebHTMLLoad(holder.getBinding().tvQuestionText, Helper.getHTMLWidthForImage(strComponent1));
                            }
                        }
                    } else if (!Intrinsics.areEqual(holder.getBinding().tvQuestionText.getTag(), sSCQuestion.getQuestionHtml())) {
                        holder.getBinding().tvQuestionText.setTag(sSCQuestion.getQuestionHtml());
                        String font_type2 = sSCQuestion.getOriginal().getFont_type();
                        if (Intrinsics.areEqual(font_type2, "1") || Intrinsics.areEqual(font_type2, "2")) {
                            Helper.testOptionFont(holder.getBinding().tvQuestionText, sSCQuestion.getQuestionHtml(), font_type2);
                        } else {
                            Helper.TestWebHTMLLoad(holder.getBinding().tvQuestionText, Helper.getHTMLWidthForImage(sSCQuestion.getQuestionHtml()));
                        }
                    }
                    SSCTestOptionAdapter optionAdapter = holder.getOptionAdapter();
                    if (optionAdapter != null) {
                        optionAdapter.notifyItemRangeChanged(0, sSCQuestion.getOptions().size(), SSCTestOptionAdapterKt.PAYLOAD_OPTION_TEXT);
                    }
                } else if (Intrinsics.areEqual(obj, SSCQuestionViewPagerAdapterKt.PAYLOAD_REPORT)) {
                    updateReportErrorUI(holder, this.isQuestionReported.invoke(sSCQuestion).booleanValue(), this.isReportDisabled.invoke().booleanValue());
                }
            }
            return;
        }
        onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final SSCQuestion sSCQuestion = this.questions.get(position);
        Question original = sSCQuestion.getOriginal();
        Integer num = this.sectionStartIndex.get(sSCQuestion.getSectionId());
        holder.getBinding().tvQNumber.setText(holder.itemView.getContext().getString(R.string.question_number, Integer.valueOf((position - (num != null ? num.intValue() : 0)) + 1)));
        updateQuestionNumberUI(holder, sSCQuestion);
        updateReportErrorUI(holder, this.isQuestionReported.invoke(sSCQuestion).booleanValue(), this.isReportDisabled.invoke().booleanValue());
        TextView pgText = holder.getBinding().pgText;
        Intrinsics.checkNotNullExpressionValue(pgText, "pgText");
        if (StringsKt.equals(sSCQuestion.getQuestionType(), "PG", true)) {
            pgText.setVisibility(0);
        } else {
            pgText.setVisibility(8);
        }
        if (StringsKt.equals(sSCQuestion.getQuestionType(), "FIB", true)) {
            String strComponent1 = formatFIBQuestion(sSCQuestion.getQuestionHtml()).component1();
            if (!Intrinsics.areEqual(holder.getBinding().tvQuestionText.getTag(), strComponent1)) {
                holder.getBinding().tvQuestionText.setTag(strComponent1);
                String font_type = sSCQuestion.getOriginal().getFont_type();
                if (Intrinsics.areEqual(font_type, "1") || Intrinsics.areEqual(font_type, "2")) {
                    Helper.testOptionFont(holder.getBinding().tvQuestionText, strComponent1, font_type);
                } else {
                    Helper.TestWebHTMLLoad(holder.getBinding().tvQuestionText, Helper.getHTMLWidthForImage(strComponent1));
                }
            }
        } else if (!Intrinsics.areEqual(holder.getBinding().tvQuestionText.getTag(), sSCQuestion.getQuestionHtml())) {
            holder.getBinding().tvQuestionText.setTag(sSCQuestion.getQuestionHtml());
            String font_type2 = sSCQuestion.getOriginal().getFont_type();
            if (Intrinsics.areEqual(font_type2, "1") || Intrinsics.areEqual(font_type2, "2")) {
                Helper.testOptionFont(holder.getBinding().tvQuestionText, sSCQuestion.getQuestionHtml(), font_type2);
            } else {
                Helper.TestWebHTMLLoad(holder.getBinding().tvQuestionText, Helper.getHTMLWidthForImage(sSCQuestion.getQuestionHtml()));
            }
        }
        TextView textView = holder.getBinding().tvTimer;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(original.getTotalTimeSpent() / 60), Integer.valueOf(original.getTotalTimeSpent() % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        textView.setText(str);
        if (original.getPosMarks() == null || original.getNegMarks() == null) {
            holder.getBinding().positiveText.setVisibility(8);
            holder.getBinding().negativeText.setVisibility(8);
        } else {
            holder.getBinding().positiveText.setVisibility(0);
            holder.getBinding().negativeText.setVisibility(0);
            holder.getBinding().positiveText.setText(holder.itemView.getContext().getString(R.string.plus_marks, original.getPosMarks()));
            holder.getBinding().negativeText.setText(holder.itemView.getContext().getString(R.string.minus_marks, original.getNegMarks()));
        }
        TextView mandatoryText = holder.getBinding().mandatoryText;
        Intrinsics.checkNotNullExpressionValue(mandatoryText, "mandatoryText");
        String section_question_behaviour = original.getSection_question_behaviour();
        String str2 = section_question_behaviour;
        if (str2 != null && str2.length() != 0) {
            mandatoryText.setVisibility(0);
            if (StringsKt.equals(section_question_behaviour, "1", true)) {
                mandatoryText.setText(holder.itemView.getContext().getString(R.string.mandatory_txt));
            } else {
                mandatoryText.setText(holder.itemView.getContext().getString(R.string.optional_txt));
            }
        } else {
            mandatoryText.setVisibility(8);
        }
        updateMarkForReviewUI(holder, original.isMarkForReview());
        holder.getBinding().markForReview.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCQuestionViewPagerAdapter.onBindViewHolder$lambda$1(this.f$0, sSCQuestion, view);
            }
        });
        holder.getBinding().tvReportError.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCQuestionViewPagerAdapter.onBindViewHolder$lambda$2(this.f$0, holder, sSCQuestion, view);
            }
        });
        updateBookmarkUI(holder, original);
        holder.getBinding().imgBookmark.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCQuestionViewPagerAdapter.onBindViewHolder$lambda$3(this.f$0, sSCQuestion, view);
            }
        });
        restoreSelection(sSCQuestion.getOptions(), sSCQuestion);
        if (!Intrinsics.areEqual(holder.getBoundQuestionId(), sSCQuestion.getId())) {
            holder.setBoundQuestionId(sSCQuestion.getId());
            holder.setOptionAdapter(new SSCTestOptionAdapter(sSCQuestion.getOptions(), sSCQuestion, new Function0() { // from class: com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SSCQuestionViewPagerAdapter.onBindViewHolder$lambda$4(this.f$0, holder);
                }
            }, new Function1() { // from class: com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SSCQuestionViewPagerAdapter.onBindViewHolder$lambda$5(holder, (SSCQuestion) obj));
                }
            }));
            RecyclerView recyclerView = holder.getBinding().rvOptions;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(holder.getOptionAdapter());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setHasFixedSize(true);
            return;
        }
        SSCTestOptionAdapter optionAdapter = holder.getOptionAdapter();
        if (optionAdapter != null) {
            optionAdapter.notifyItemRangeChanged(0, sSCQuestion.getOptions().size(), SSCTestOptionAdapterKt.PAYLOAD_SELECTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter, SSCQuestion sSCQuestion, View view) {
        sSCQuestionViewPagerAdapter.onMarkForReviewClicked.invoke(sSCQuestion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter, VH vh, SSCQuestion sSCQuestion, View view) {
        if (sSCQuestionViewPagerAdapter.isReportDisabled.invoke().booleanValue()) {
            Toast.makeText(vh.itemView.getContext(), "Reporting disabled after submit", 0).show();
        } else if (sSCQuestionViewPagerAdapter.isQuestionReported.invoke(sSCQuestion).booleanValue()) {
            sSCQuestionViewPagerAdapter.onReportErrorClicked.invoke(sSCQuestion);
        } else {
            sSCQuestionViewPagerAdapter.onReportErrorClicked.invoke(sSCQuestion);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter, SSCQuestion sSCQuestion, View view) {
        sSCQuestionViewPagerAdapter.onBookmarkClicked.invoke(sSCQuestion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$4(SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter, VH vh) {
        sSCQuestionViewPagerAdapter.onAnswerChanged.invoke(Integer.valueOf(vh.getBindingAdapterPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$5(VH vh, SSCQuestion sscQ) {
        Intrinsics.checkNotNullParameter(sscQ, "sscQ");
        Context context = vh.itemView.getContext();
        TestBaseActivitySSCPattern testBaseActivitySSCPattern = context instanceof TestBaseActivitySSCPattern ? (TestBaseActivitySSCPattern) context : null;
        if (testBaseActivitySSCPattern != null) {
            return testBaseActivitySSCPattern.canAttemptQuestionInSection(sscQ);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.questions.size();
    }

    private final void updateQuestionNumberUI(VH holder, SSCQuestion q) {
        int i;
        TextView textView = holder.getBinding().tvQNumber;
        if (q.getOriginal().isMarkForReview() && q.getOriginal().isanswer()) {
            i = R.drawable.shape_rect_yellow_solid;
        } else if (!q.getOriginal().isMarkForReview() || q.getOriginal().isanswer()) {
            i = q.getOriginal().isanswer() ? R.drawable.shape_rect_green_solid : R.drawable.shape_rect_blue_solid;
        } else {
            i = R.drawable.shape_rect_red_solid;
        }
        textView.setBackgroundResource(i);
    }

    private final void updateMarkForReviewUI(VH holder, boolean isMarked) {
        holder.getBinding().markForReview.setImageResource(isMarked ? R.drawable.ic_star_filled : R.drawable.ic_star_outline);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateBookmarkUI(com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter.VH r5, com.appnew.android.testmodule.model.Question r6) {
        /*
            r4 = this;
            com.appnew.android.Utils.SharedPreference r0 = com.appnew.android.Utils.SharedPreference.getInstance()
            java.lang.String r1 = "book_mark"
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "1"
            r2 = 0
            if (r0 == 0) goto L17
            r3 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r3)
            if (r0 != r3) goto L17
            goto L18
        L17:
            r3 = r2
        L18:
            com.appnew.android.databinding.ItemSscPatternQuestionViewpagerBinding r0 = r5.getBinding()
            android.widget.ImageView r0 = r0.imgBookmark
            if (r3 == 0) goto L21
            goto L23
        L21:
            r2 = 8
        L23:
            r0.setVisibility(r2)
            com.appnew.android.databinding.ItemSscPatternQuestionViewpagerBinding r5 = r5.getBinding()
            android.widget.ImageView r5 = r5.imgBookmark
            java.lang.String r6 = r6.getIs_bookmarked()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r6 == 0) goto L3a
            r6 = 2131231671(0x7f0803b7, float:1.807943E38)
            goto L3d
        L3a:
            r6 = 2131231670(0x7f0803b6, float:1.8079428E38)
        L3d:
            r5.setImageResource(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter.updateBookmarkUI(com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter$VH, com.appnew.android.testmodule.model.Question):void");
    }

    private final void updateReportErrorUI(VH holder, boolean isReported, boolean isDisabled) {
        Context context = holder.itemView.getContext();
        if (isDisabled) {
            holder.getBinding().tvReportError.setImageTintList(ContextCompat.getColorStateList(context, R.color.ssc_gray_light));
            holder.getBinding().tvReportError.setAlpha(0.4f);
        } else if (isReported) {
            holder.getBinding().tvReportError.setImageTintList(ContextCompat.getColorStateList(context, R.color.red_500));
            holder.getBinding().tvReportError.setAlpha(1.0f);
        } else {
            holder.getBinding().tvReportError.setImageTintList(ContextCompat.getColorStateList(context, R.color.ssc_gray_dark));
            holder.getBinding().tvReportError.setAlpha(1.0f);
        }
    }

    private final Pair<String, Integer> formatFIBQuestion(String html) {
        Regex regex = new Regex("\\bFIB\\b");
        String str = html;
        return TuplesKt.to(regex.replace(str, "____"), Integer.valueOf(SequencesKt.count(Regex.findAll$default(regex, str, 0, 2, null))));
    }

    private final void restoreSelection(List<SSCTestOption> options, SSCQuestion q) {
        int i;
        List<SSCTestOption> list = options;
        Iterator<T> it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            } else {
                ((SSCTestOption) it.next()).setSelected(false);
            }
        }
        if (q.getOriginal().isanswer()) {
            if (StringsKt.equals(q.getQuestionType(), "MC", true)) {
                ArrayList<Integer> selectedValue = q.getOriginal().getSelectedValue();
                Intrinsics.checkNotNullExpressionValue(selectedValue, "getSelectedValue(...)");
                Iterator<T> it2 = selectedValue.iterator();
                while (it2.hasNext()) {
                    int iIntValue = ((Integer) it2.next()).intValue() - 1;
                    if (iIntValue >= 0 && iIntValue < options.size()) {
                        options.get(iIntValue).setSelected(true);
                    }
                }
                return;
            }
            if (StringsKt.equals(q.getQuestionType(), "PG", true)) {
                if (q.isMultiPG()) {
                    ArrayList<Integer> selectedValue2 = q.getOriginal().getSelectedValue();
                    Intrinsics.checkNotNullExpressionValue(selectedValue2, "getSelectedValue(...)");
                    Iterator<T> it3 = selectedValue2.iterator();
                    while (it3.hasNext()) {
                        int iIntValue2 = ((Integer) it3.next()).intValue() - 1;
                        if (iIntValue2 >= 0 && iIntValue2 < options.size()) {
                            options.get(iIntValue2).setSelected(true);
                        }
                    }
                    return;
                }
                int answerPosition = q.getOriginal().getAnswerPosition() - 1;
                if (answerPosition < 0 || answerPosition >= options.size()) {
                    return;
                }
                options.get(answerPosition).setSelected(true);
                return;
            }
            if (!StringsKt.equals(q.getQuestionType(), "FIB", true)) {
                int answerPosition2 = q.getOriginal().getAnswerPosition() - 1;
                if (answerPosition2 < 0 || answerPosition2 >= options.size()) {
                    return;
                }
                options.get(answerPosition2).setSelected(true);
                return;
            }
            Iterator<T> it4 = list.iterator();
            while (it4.hasNext()) {
                ((SSCTestOption) it4.next()).setSelected(false);
            }
            ArrayList<String> answers = q.getOriginal().getAnswers();
            Intrinsics.checkNotNullExpressionValue(answers, "getAnswers(...)");
            for (Object obj : answers) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                if (i >= 0 && i < options.size()) {
                    options.get(i).setFibAnswer(str);
                }
                i = i2;
            }
        }
    }
}
