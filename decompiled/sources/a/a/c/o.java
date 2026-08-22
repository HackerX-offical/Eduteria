package a.a.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.billdesk.sdk.TenureFragment;

/* JADX INFO: loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TenureFragment f172a;

    public o(TenureFragment tenureFragment) {
        this.f172a = tenureFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < this.f172a.f453b.getChildCount(); i++) {
            try {
                View childAt = this.f172a.f453b.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) childAt).getChildCount(); i2++) {
                        View childAt2 = ((ViewGroup) childAt).getChildAt(i2);
                        if (childAt2 instanceof ViewGroup) {
                            for (int i3 = 0; i3 < ((ViewGroup) childAt2).getChildCount(); i3++) {
                                View childAt3 = ((ViewGroup) childAt2).getChildAt(i3);
                                if (childAt3 instanceof ViewGroup) {
                                    for (int i4 = 0; i4 < ((ViewGroup) childAt3).getChildCount(); i4++) {
                                        View childAt4 = ((ViewGroup) childAt3).getChildAt(i4);
                                        if (childAt4 instanceof RadioButton) {
                                            ((RadioButton) childAt4).setChecked(false);
                                        }
                                    }
                                } else if (childAt3 instanceof RadioButton) {
                                    ((RadioButton) childAt3).setChecked(false);
                                }
                            }
                        } else if (childAt2 instanceof RadioButton) {
                            ((RadioButton) childAt2).setChecked(false);
                        }
                    }
                } else if (childAt instanceof RadioButton) {
                    ((RadioButton) childAt).setChecked(false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        LinearLayout linearLayout = (LinearLayout) view;
        for (int i5 = 0; i5 < linearLayout.getChildCount(); i5++) {
            if (linearLayout.getChildAt(i5) instanceof LinearLayout) {
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.getChildAt(i5);
                for (int i6 = 0; i6 < linearLayout2.getChildCount(); i6++) {
                    if (linearLayout2.getChildAt(i6) instanceof RadioButton) {
                        ((RadioButton) linearLayout2.getChildAt(i6)).setChecked(true);
                    }
                }
            }
        }
        this.f172a.f457f = (a.a.b.b) linearLayout.getTag();
    }
}
