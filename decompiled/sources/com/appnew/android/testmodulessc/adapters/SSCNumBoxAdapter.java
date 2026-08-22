package com.appnew.android.testmodulessc.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.ItemSscPatternNumBoxBinding;
import com.appnew.android.testmodulessc.models.SSCQuestion;
import com.appnew.android.testmodulessc.models.SSCTestSection;
import com.eduteria.app.app.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SSCNumBoxAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(Bo\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J(\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!H\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0006\u0010&\u001a\u00020'R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCNumBoxAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/testmodulessc/adapters/SSCNumBoxAdapter$VH;", "questions", "", "Lcom/appnew/android/testmodulessc/models/SSCQuestion;", "sections", "Lcom/appnew/android/testmodulessc/models/SSCTestSection;", "sectionStartIndex", "", "", "", "getCurrentIndex", "Lkotlin/Function0;", "getCurrentSectionIndex", "sectionSwitchAllowed", "", "onClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function1;)V", "getItemId", "", Const.POSITION, "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "payloads", "", "", "updateUI", "adapterPosition", "getActualPosition", "getSectionRange", "Lkotlin/ranges/IntRange;", "VH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCNumBoxAdapter extends RecyclerView.Adapter<VH> {
    public static final int $stable = 8;
    private final Function0<Integer> getCurrentIndex;
    private final Function0<Integer> getCurrentSectionIndex;
    private final Function1<Integer, Unit> onClick;
    private final List<SSCQuestion> questions;
    private final Map<String, Integer> sectionStartIndex;
    private final boolean sectionSwitchAllowed;
    private final List<SSCTestSection> sections;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((VH) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSCNumBoxAdapter(List<SSCQuestion> questions, List<SSCTestSection> sections, Map<String, Integer> sectionStartIndex, Function0<Integer> getCurrentIndex, Function0<Integer> getCurrentSectionIndex, boolean z, Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(sectionStartIndex, "sectionStartIndex");
        Intrinsics.checkNotNullParameter(getCurrentIndex, "getCurrentIndex");
        Intrinsics.checkNotNullParameter(getCurrentSectionIndex, "getCurrentSectionIndex");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.questions = questions;
        this.sections = sections;
        this.sectionStartIndex = sectionStartIndex;
        this.getCurrentIndex = getCurrentIndex;
        this.getCurrentSectionIndex = getCurrentSectionIndex;
        this.sectionSwitchAllowed = z;
        this.onClick = onClick;
        setHasStableIds(true);
    }

    /* JADX INFO: compiled from: SSCNumBoxAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCNumBoxAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemSscPatternNumBoxBinding;", "<init>", "(Lcom/appnew/android/databinding/ItemSscPatternNumBoxBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemSscPatternNumBoxBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VH extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ItemSscPatternNumBoxBinding binding;

        public final ItemSscPatternNumBoxBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemSscPatternNumBoxBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.questions.get(getActualPosition(position)).getId().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSscPatternNumBoxBinding itemSscPatternNumBoxBindingInflate = ItemSscPatternNumBoxBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSscPatternNumBoxBindingInflate, "inflate(...)");
        return new VH(itemSscPatternNumBoxBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return CollectionsKt.count(getSectionRange());
    }

    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            updateUI(holder, position);
        } else {
            onBindViewHolder(holder, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final int actualPosition = getActualPosition(position);
        TextView tvGridNumber = holder.getBinding().tvGridNumber;
        Intrinsics.checkNotNullExpressionValue(tvGridNumber, "tvGridNumber");
        tvGridNumber.setText(holder.getBinding().getRoot().getContext().getString(R.string.question_number, Integer.valueOf(position + 1)));
        updateUI(holder, position);
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCNumBoxAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCNumBoxAdapter.onBindViewHolder$lambda$0(this.f$0, actualPosition, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SSCNumBoxAdapter sSCNumBoxAdapter, int i, View view) {
        sSCNumBoxAdapter.onClick.invoke(Integer.valueOf(i));
    }

    private final void updateUI(VH holder, int adapterPosition) {
        int i;
        int color;
        int actualPosition = getActualPosition(adapterPosition);
        SSCQuestion sSCQuestion = this.questions.get(actualPosition);
        int iIntValue = this.getCurrentIndex.invoke().intValue();
        TextView tvGridNumber = holder.getBinding().tvGridNumber;
        Intrinsics.checkNotNullExpressionValue(tvGridNumber, "tvGridNumber");
        boolean z = actualPosition == iIntValue;
        if (z) {
            i = R.drawable.btn_outline_blue;
        } else if (sSCQuestion.getOriginal().isMarkForReview() && sSCQuestion.getOriginal().isanswer()) {
            i = R.drawable.shape_rect_yellow_solid;
        } else if (!sSCQuestion.getOriginal().isMarkForReview() || sSCQuestion.getOriginal().isanswer()) {
            i = sSCQuestion.getOriginal().isanswer() ? R.drawable.shape_rect_green_solid : R.drawable.shape_rect_blue_solid;
        } else {
            i = R.drawable.shape_rect_red_solid;
        }
        tvGridNumber.setBackgroundResource(i);
        if (z) {
            color = holder.getBinding().getRoot().getContext().getColor(R.color.ssc_blue);
        } else {
            color = holder.getBinding().getRoot().getContext().getColor(R.color.white);
        }
        tvGridNumber.setTextColor(color);
    }

    private final int getActualPosition(int adapterPosition) {
        return getSectionRange().getFirst() + adapterPosition;
    }

    public final IntRange getSectionRange() {
        int iIntValue;
        if (this.sectionSwitchAllowed) {
            return RangesKt.until(0, this.questions.size());
        }
        int iIntValue2 = this.getCurrentSectionIndex.invoke().intValue();
        SSCTestSection sSCTestSection = (SSCTestSection) CollectionsKt.getOrNull(this.sections, iIntValue2);
        if (sSCTestSection == null) {
            return RangesKt.until(0, this.questions.size());
        }
        Integer num = this.sectionStartIndex.get(sSCTestSection.getId());
        int iIntValue3 = num != null ? num.intValue() : 0;
        if (iIntValue2 == CollectionsKt.getLastIndex(this.sections)) {
            iIntValue = this.questions.size();
        } else {
            Integer num2 = this.sectionStartIndex.get(this.sections.get(iIntValue2 + 1).getId());
            iIntValue = num2 != null ? num2.intValue() : this.questions.size();
        }
        return RangesKt.until(iIntValue3, iIntValue);
    }
}
