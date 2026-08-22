package com.appnew.android.testmodulessc.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ItemSscPatternOptionBinding;
import com.appnew.android.databinding.SscEnterFibDialogBinding;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodulessc.models.SSCQuestion;
import com.appnew.android.testmodulessc.models.SSCTestOption;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import com.eduteria.app.app.R;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONObject;

/* JADX INFO: compiled from: SSCTestOptionAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J&\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter$VH;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "Lcom/appnew/android/testmodulessc/models/SSCTestOption;", Const.QUESTION, "Lcom/appnew/android/testmodulessc/models/SSCQuestion;", "onAnswerChanged", "Lkotlin/Function0;", "", "canAttemptQuestion", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Lcom/appnew/android/testmodulessc/models/SSCQuestion;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getItemId", "", Const.POSITION, "", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "payloads", "", "bindMCPG", "bindFIB", "showFibDialog", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "applyInputRules", "dialogBinding", "Lcom/appnew/android/databinding/SscEnterFibDialogBinding;", "updateFIBState", "handleSelection", "clickedPos", "parseFIBRule", "Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter$FIBRule;", "raw", "", "VH", "FIBRule", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCTestOptionAdapter extends RecyclerView.Adapter<VH> {
    public static final int $stable = 8;
    private final Function1<SSCQuestion, Boolean> canAttemptQuestion;
    private final Function0<Unit> onAnswerChanged;
    private final List<SSCTestOption> options;
    private final SSCQuestion question;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((VH) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSCTestOptionAdapter(List<SSCTestOption> options, SSCQuestion question, Function0<Unit> onAnswerChanged, Function1<? super SSCQuestion, Boolean> canAttemptQuestion) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(onAnswerChanged, "onAnswerChanged");
        Intrinsics.checkNotNullParameter(canAttemptQuestion, "canAttemptQuestion");
        this.options = options;
        this.question = question;
        this.onAnswerChanged = onAnswerChanged;
        this.canAttemptQuestion = canAttemptQuestion;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.options.get(position).getIndex();
    }

    /* JADX INFO: compiled from: SSCTestOptionAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemSscPatternOptionBinding;", "<init>", "(Lcom/appnew/android/databinding/ItemSscPatternOptionBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemSscPatternOptionBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VH extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ItemSscPatternOptionBinding binding;

        public final ItemSscPatternOptionBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemSscPatternOptionBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSscPatternOptionBinding itemSscPatternOptionBindingInflate = ItemSscPatternOptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSscPatternOptionBindingInflate, "inflate(...)");
        return new VH(itemSscPatternOptionBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.options.size();
    }

    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            SSCTestOption sSCTestOption = this.options.get(position);
            for (Object obj : payloads) {
                boolean zAreEqual = Intrinsics.areEqual(obj, SSCTestOptionAdapterKt.PAYLOAD_SELECTION);
                int i = R.drawable.bg_option_card_select;
                if (zAreEqual) {
                    LinearLayout linearLayout = holder.getBinding().optionRoot;
                    if (!sSCTestOption.isSelected()) {
                        i = R.drawable.bg_option_card_default;
                    }
                    linearLayout.setBackgroundResource(i);
                } else if (Intrinsics.areEqual(obj, SSCTestOptionAdapterKt.PAYLOAD_FIB_TEXT)) {
                    TextView textView = holder.getBinding().optionTextFIB;
                    String fibAnswer = sSCTestOption.getFibAnswer();
                    if (fibAnswer != null) {
                        str = fibAnswer;
                    } else {
                        String string = holder.itemView.getContext().getString(R.string.tap_to_enter_answer);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        str = string;
                    }
                    textView.setText(str);
                    LinearLayout linearLayout2 = holder.getBinding().optionRoot;
                    String fibAnswer2 = sSCTestOption.getFibAnswer();
                    if (fibAnswer2 == null || fibAnswer2.length() == 0) {
                        i = R.drawable.bg_option_card_default;
                    }
                    linearLayout2.setBackgroundResource(i);
                } else if (Intrinsics.areEqual(obj, SSCTestOptionAdapterKt.PAYLOAD_OPTION_TEXT) && !StringsKt.equals(this.question.getQuestionType(), "FIB", true) && !Intrinsics.areEqual(holder.getBinding().tvOptionText.getTag(), sSCTestOption.getText())) {
                    holder.getBinding().tvOptionText.setTag(sSCTestOption.getText());
                    String font_type = this.question.getOriginal().getFont_type();
                    if (Intrinsics.areEqual(font_type, "1") || Intrinsics.areEqual(font_type, "2")) {
                        Helper.testOptionFont(holder.getBinding().tvOptionText, sSCTestOption.getText(), font_type);
                    } else {
                        Helper.TestWebHTMLLoad(holder.getBinding().tvOptionText, Helper.getHTMLWidthForImage(sSCTestOption.getText()));
                    }
                }
            }
            return;
        }
        onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().optionIconTV.setText(holder.itemView.getContext().getString(R.string.option_number_format, Integer.valueOf(position + 1)));
        if (StringsKt.equals(this.question.getQuestionType(), "FIB", true)) {
            bindFIB(holder, position);
        } else {
            bindMCPG(holder, position);
        }
    }

    private final void bindMCPG(final VH holder, int position) {
        SSCTestOption sSCTestOption = this.options.get(position);
        holder.getBinding().tvOptionText.setVisibility(0);
        holder.getBinding().optionTextFIB.setVisibility(8);
        if (!Intrinsics.areEqual(holder.getBinding().tvOptionText.getTag(), sSCTestOption.getText())) {
            holder.getBinding().tvOptionText.setTag(sSCTestOption.getText());
            String font_type = this.question.getOriginal().getFont_type();
            if (Intrinsics.areEqual(font_type, "1") || Intrinsics.areEqual(font_type, "2")) {
                Helper.testOptionFont(holder.getBinding().tvOptionText, sSCTestOption.getText(), font_type);
            } else {
                Helper.TestWebHTMLLoad(holder.getBinding().tvOptionText, Helper.getHTMLWidthForImage(sSCTestOption.getText()));
            }
        }
        holder.getBinding().optionRoot.setBackgroundResource(sSCTestOption.isSelected() ? R.drawable.bg_option_card_select : R.drawable.bg_option_card_default);
        holder.getBinding().optionRoot.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCTestOptionAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCTestOptionAdapter.bindMCPG$lambda$2(holder, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindMCPG$lambda$2(VH vh, SSCTestOptionAdapter sSCTestOptionAdapter, View view) {
        int bindingAdapterPosition = vh.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        if (sSCTestOptionAdapter.question.getOriginal().isanswer() || sSCTestOptionAdapter.canAttemptQuestion.invoke(sSCTestOptionAdapter.question).booleanValue()) {
            Iterator<SSCTestOption> it = sSCTestOptionAdapter.options.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().isSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            sSCTestOptionAdapter.handleSelection(bindingAdapterPosition);
            sSCTestOptionAdapter.notifyItemChanged(bindingAdapterPosition, SSCTestOptionAdapterKt.PAYLOAD_SELECTION);
            if (i != -1 && i != bindingAdapterPosition) {
                sSCTestOptionAdapter.notifyItemChanged(i, SSCTestOptionAdapterKt.PAYLOAD_SELECTION);
            }
            sSCTestOptionAdapter.onAnswerChanged.invoke();
        }
    }

    private final void bindFIB(final VH holder, final int position) {
        String str;
        SSCTestOption sSCTestOption = this.options.get(position);
        holder.getBinding().tvOptionText.setVisibility(8);
        holder.getBinding().optionTextFIB.setVisibility(0);
        TextView textView = holder.getBinding().optionTextFIB;
        String fibAnswer = sSCTestOption.getFibAnswer();
        if (fibAnswer != null) {
            str = fibAnswer;
        } else {
            String string = holder.itemView.getContext().getString(R.string.tap_to_enter_answer);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        }
        textView.setText(str);
        LinearLayout linearLayout = holder.getBinding().optionRoot;
        String fibAnswer2 = sSCTestOption.getFibAnswer();
        linearLayout.setBackgroundResource((fibAnswer2 == null || fibAnswer2.length() == 0) ? R.drawable.bg_option_card_default : R.drawable.bg_option_card_select);
        holder.getBinding().optionRoot.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCTestOptionAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCTestOptionAdapter.bindFIB$lambda$3(this.f$0, holder, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindFIB$lambda$3(SSCTestOptionAdapter sSCTestOptionAdapter, VH vh, int i, View view) {
        if (sSCTestOptionAdapter.question.getOriginal().isanswer() || sSCTestOptionAdapter.canAttemptQuestion.invoke(sSCTestOptionAdapter.question).booleanValue()) {
            sSCTestOptionAdapter.showFibDialog(vh, i);
        }
    }

    private final void showFibDialog(VH holder, final int position) {
        Context context = holder.getBinding().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final Activity activityFindActivity = findActivity(context);
        if (activityFindActivity == null) {
            return;
        }
        Activity activity = activityFindActivity;
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        final SscEnterFibDialogBinding sscEnterFibDialogBindingInflate = SscEnterFibDialogBinding.inflate(LayoutInflater.from(activity));
        Intrinsics.checkNotNullExpressionValue(sscEnterFibDialogBindingInflate, "inflate(...)");
        dialog.setContentView(sscEnterFibDialogBindingInflate.getRoot());
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            window.clearFlags(8);
            window.setSoftInputMode(5);
        }
        applyInputRules(sscEnterFibDialogBindingInflate);
        EditText editText = sscEnterFibDialogBindingInflate.message;
        String fibAnswer = this.options.get(position).getFibAnswer();
        if (fibAnswer == null) {
            fibAnswer = "";
        }
        editText.setText(fibAnswer);
        EditText editText2 = sscEnterFibDialogBindingInflate.message;
        Editable text = sscEnterFibDialogBindingInflate.message.getText();
        editText2.setSelection(text != null ? text.length() : 0);
        sscEnterFibDialogBindingInflate.btnSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCTestOptionAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCTestOptionAdapter.showFibDialog$lambda$5(sscEnterFibDialogBindingInflate, activityFindActivity, this, position, dialog, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCTestOptionAdapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SSCTestOptionAdapter.showFibDialog$hideKeyboard(activityFindActivity, sscEnterFibDialogBindingInflate);
            }
        });
        dialog.show();
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -2);
        }
        final EditText editText3 = sscEnterFibDialogBindingInflate.message;
        editText3.setFocusableInTouchMode(true);
        editText3.requestFocus();
        editText3.post(new Runnable() { // from class: com.appnew.android.testmodulessc.adapters.SSCTestOptionAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SSCTestOptionAdapter.showFibDialog$lambda$8$lambda$7(activityFindActivity, editText3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFibDialog$hideKeyboard(Activity activity, SscEnterFibDialogBinding sscEnterFibDialogBinding) {
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(sscEnterFibDialogBinding.message.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFibDialog$lambda$5(SscEnterFibDialogBinding sscEnterFibDialogBinding, Activity activity, SSCTestOptionAdapter sSCTestOptionAdapter, int i, Dialog dialog, View view) {
        String string;
        Editable text = sscEnterFibDialogBinding.message.getText();
        String string2 = (text == null || (string = text.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            sscEnterFibDialogBinding.message.setError(activity.getString(R.string.enter_answer_error));
            return;
        }
        sSCTestOptionAdapter.options.get(i).setFibAnswer(string2);
        sSCTestOptionAdapter.updateFIBState();
        sSCTestOptionAdapter.notifyItemChanged(i, SSCTestOptionAdapterKt.PAYLOAD_FIB_TEXT);
        sSCTestOptionAdapter.onAnswerChanged.invoke();
        showFibDialog$hideKeyboard(activity, sscEnterFibDialogBinding);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFibDialog$lambda$8$lambda$7(Activity activity, EditText editText) {
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    private final Activity findActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private final void applyInputRules(SscEnterFibDialogBinding dialogBinding) {
        String str;
        FIBRule fIBRule = parseFIBRule(this.question.getOriginal().getOption1());
        EditText editText = dialogBinding.message;
        String type = fIBRule != null ? fIBRule.getType() : null;
        int i = 1;
        if (type != null) {
            int iHashCode = type.hashCode();
            if (iHashCode == -1412808770) {
                str = Const.ANSWER;
            } else if (iHashCode != -1034364087) {
                if (iHashCode == 1564195625) {
                    str = FirebaseAnalytics.Param.CHARACTER;
                }
            } else if (type.equals(CTVariableUtils.NUMBER)) {
                i = 2;
            }
            type.equals(str);
        }
        editText.setInputType(i);
        dialogBinding.message.setTextColor(ContextCompat.getColor(dialogBinding.getRoot().getContext(), android.R.color.black));
        dialogBinding.message.setHintTextColor(ContextCompat.getColor(dialogBinding.getRoot().getContext(), android.R.color.darker_gray));
    }

    private final void updateFIBState() {
        boolean z;
        Question original = this.question.getOriginal();
        List<SSCTestOption> list = this.options;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String fibAnswer = ((SSCTestOption) it.next()).getFibAnswer();
            String string = fibAnswer != null ? StringsKt.trim((CharSequence) fibAnswer).toString() : null;
            if (string == null) {
                string = "";
            }
            arrayList.add(string);
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
            z = true;
        } else {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                if (((String) it2.next()).length() <= 0) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        ArrayList arrayList4 = arrayList2;
        original.setAnswers(new ArrayList<>(arrayList4));
        if (z) {
            original.setSelectedString(new ArrayList<>(arrayList4));
            original.setIsanswer(true, 1);
        } else {
            original.setIsanswer(false, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    private final void handleSelection(int clickedPos) {
        Question original = this.question.getOriginal();
        ?? r3 = 1;
        r3 = 1;
        int i = 0;
        if (StringsKt.equals(this.question.getQuestionType(), "MC", true)) {
            this.options.get(clickedPos).setSelected(!this.options.get(clickedPos).isSelected());
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.options) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((SSCTestOption) obj).isSelected()) {
                    arrayList.add(Integer.valueOf(i2));
                }
                i = i2;
            }
            original.setSelectedValue(arrayList);
            original.setIsanswer(!arrayList.isEmpty(), 1);
            return;
        }
        if (StringsKt.equals(this.question.getQuestionType(), "PG", true)) {
            if (this.question.isMultiPG()) {
                this.options.get(clickedPos).setSelected(!this.options.get(clickedPos).isSelected());
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : this.options) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (((SSCTestOption) obj2).isSelected()) {
                        arrayList2.add(Integer.valueOf(i3));
                    }
                    i = i3;
                }
                original.setSelectedValue(arrayList2);
                original.setIsanswer(!arrayList2.isEmpty(), 1);
                return;
            }
            boolean zIsSelected = this.options.get(clickedPos).isSelected();
            Iterator<T> it = this.options.iterator();
            while (it.hasNext()) {
                ((SSCTestOption) it.next()).setSelected(false);
            }
            if (!zIsSelected) {
                this.options.get(clickedPos).setSelected(true);
                int i4 = clickedPos + 1;
                original.setSelectedValue(CollectionsKt.arrayListOf(Integer.valueOf(i4)));
                original.setIsanswer(true, i4);
                return;
            }
            original.setSelectedValue(new ArrayList());
            original.setIsanswer(false, 0);
            return;
        }
        if (!StringsKt.equals(this.question.getQuestionType(), "FIB", true)) {
            boolean zIsSelected2 = this.options.get(clickedPos).isSelected();
            Iterator<T> it2 = this.options.iterator();
            while (it2.hasNext()) {
                ((SSCTestOption) it2.next()).setSelected(false);
            }
            original.setSelectedValue(new ArrayList());
            if (!zIsSelected2) {
                this.options.get(clickedPos).setSelected(true);
                original.setIsanswer(true, clickedPos + 1);
                return;
            } else {
                original.setIsanswer(false, 0);
                return;
            }
        }
        Iterator<T> it3 = this.options.iterator();
        while (it3.hasNext()) {
            ((SSCTestOption) it3.next()).setSelected(false);
        }
        original.setSelectedValue(new ArrayList());
        original.setAnswerPosition(0);
        ArrayList<String> answers = original.getAnswers();
        ArrayList<String> arrayList3 = answers;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            r3 = 0;
            break;
        }
        ArrayList<String> arrayList4 = answers;
        if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
            for (String str : arrayList4) {
                Intrinsics.checkNotNull(str);
                if (StringsKt.isBlank(str)) {
                    r3 = 0;
                    break;
                }
            }
        }
        original.setIsanswer(r3, r3);
    }

    /* JADX INFO: compiled from: SSCTestOptionAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCTestOptionAdapter$FIBRule;", "", "type", "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class FIBRule {
        public static final int $stable = 0;
        private final String type;

        public static /* synthetic */ FIBRule copy$default(FIBRule fIBRule, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fIBRule.type;
            }
            return fIBRule.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final FIBRule copy(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new FIBRule(type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FIBRule) && Intrinsics.areEqual(this.type, ((FIBRule) other).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "FIBRule(type=" + this.type + ")";
        }

        public FIBRule(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final String getType() {
            return this.type;
        }
    }

    private final FIBRule parseFIBRule(String raw) {
        String str = raw;
        if (str != null && !StringsKt.isBlank(str)) {
            try {
                String strOptString = new JSONObject(raw).optString("type");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                return new FIBRule(strOptString);
            } catch (Exception e2) {
                Log.e("SSC_SUBMIT", "parseFIBRule: " + e2);
            }
        }
        return null;
    }
}
