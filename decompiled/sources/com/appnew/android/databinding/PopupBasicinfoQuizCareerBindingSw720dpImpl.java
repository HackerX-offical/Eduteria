package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class PopupBasicinfoQuizCareerBindingSw720dpImpl extends PopupBasicinfoQuizCareerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.quizImageIV, 1);
        sparseIntArray.put(R.id.quizTitleTV, 2);
        sparseIntArray.put(R.id.numQuesValueTV, 3);
        sparseIntArray.put(R.id.quizTimeValueTV, 4);
        sparseIntArray.put(R.id.marksTextValueTV, 5);
        sparseIntArray.put(R.id.sectionValueTV, 6);
        sparseIntArray.put(R.id.marksCorrectValueTV, 7);
        sparseIntArray.put(R.id.marksWrongValueTV, 8);
        sparseIntArray.put(R.id.secNameTV, 9);
        sparseIntArray.put(R.id.totQuesTV, 10);
        sparseIntArray.put(R.id.totNoAttmtsTV, 11);
        sparseIntArray.put(R.id.negMarkPerQuesTV, 12);
        sparseIntArray.put(R.id.maxMarksTV, 13);
        sparseIntArray.put(R.id.markPerQuesTV, 14);
        sparseIntArray.put(R.id.section_time, 15);
        sparseIntArray.put(R.id.totTimeTV, 16);
        sparseIntArray.put(R.id.sectionListLL, 17);
        sparseIntArray.put(R.id.general_layout, 18);
        sparseIntArray.put(R.id.gerneral_txt, 19);
        sparseIntArray.put(R.id.generalInstrValueTV, 20);
        sparseIntArray.put(R.id.languageRecycler, 21);
        sparseIntArray.put(R.id.languageL_layout, 22);
        sparseIntArray.put(R.id.languageSpinnerTV, 23);
        sparseIntArray.put(R.id.check_box, 24);
        sparseIntArray.put(R.id.remarksTV, 25);
        sparseIntArray.put(R.id.startQuizBtn, 26);
    }

    public PopupBasicinfoQuizCareerBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }

    private PopupBasicinfoQuizCareerBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RelativeLayout) bindings[0], (CheckBox) bindings[24], (TextView) bindings[20], (LinearLayout) bindings[18], (TextView) bindings[19], (LinearLayout) bindings[22], (RecyclerView) bindings[21], (TextView) bindings[23], (TextView) bindings[14], (TextView) bindings[7], (TextView) bindings[5], (TextView) bindings[8], (TextView) bindings[13], (TextView) bindings[12], (TextView) bindings[3], (ImageView) bindings[1], (TextView) bindings[4], (TextView) bindings[2], (TextView) bindings[25], (TextView) bindings[9], (LinearLayout) bindings[17], (LinearLayout) bindings[15], (TextView) bindings[6], (Button) bindings[26], (TextView) bindings[11], (TextView) bindings[10], (TextView) bindings[16]);
        this.mDirtyFlags = -1L;
        this.basicInfoDialogLL.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
