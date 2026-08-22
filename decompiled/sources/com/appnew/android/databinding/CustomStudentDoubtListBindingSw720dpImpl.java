package com.appnew.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.appnew.android.sme.Doubt;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class CustomStudentDoubtListBindingSw720dpImpl extends CustomStudentDoubtListBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.SmeStudentImage, 6);
    }

    public CustomStudentDoubtListBindingSw720dpImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private CustomStudentDoubtListBindingSw720dpImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[6]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[3];
        this.mboundView3 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[4];
        this.mboundView4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[5];
        this.mboundView5 = textView5;
        textView5.setTag(null);
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
        if (7 != variableId) {
            return false;
        }
        setData((Doubt) variable);
        return true;
    }

    @Override // com.appnew.android.databinding.CustomStudentDoubtListBinding
    public void setData(Doubt Data) {
        this.mData = Data;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String doubtMessage;
        String subjectName;
        String pageNo;
        String date;
        String questionNo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Doubt doubt = this.mData;
        long j2 = j & 3;
        if (j2 == 0 || doubt == null) {
            doubtMessage = null;
            subjectName = null;
            pageNo = null;
            date = null;
            questionNo = null;
        } else {
            doubtMessage = doubt.getDoubtMessage();
            subjectName = doubt.getSubjectName();
            pageNo = doubt.getPageNo();
            questionNo = doubt.getQuestionNo();
            date = doubt.getDate();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, doubtMessage);
            TextViewBindingAdapter.setText(this.mboundView2, date);
            TextViewBindingAdapter.setText(this.mboundView3, subjectName);
            TextViewBindingAdapter.setText(this.mboundView4, pageNo);
            TextViewBindingAdapter.setText(this.mboundView5, questionNo);
        }
    }
}
