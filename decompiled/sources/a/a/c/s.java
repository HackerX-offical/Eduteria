package a.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.billdesk.sdk.UpiActivity;

/* JADX INFO: loaded from: classes.dex */
public class s extends ArrayAdapter<String> {
    public s(UpiActivity upiActivity, Context context, int i, String[] strArr) {
        super(context, i, strArr);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        return textView;
    }
}
