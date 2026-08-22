package a.a.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.billdesk.sdk.BankList;
import com.billdesk.sdk.R;
import com.billdesk.utils.Helper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends ArrayAdapter<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BankList f143a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BankList bankList, Context context, int i, List list) {
        super(context, i, list);
        this.f143a = bankList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        Helper.a(textView, false, (Activity) this.f143a);
        textView.setTextSize(2, this.f143a.getResources().getDimension(R.dimen.list_font_size) / this.f143a.getResources().getDisplayMetrics().density);
        textView.setWidth(viewGroup.getWidth());
        return textView;
    }
}
