package com.appnew.android.feeds.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: MainCatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0006j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0006j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/feeds/adapters/MainCatAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/appnew/android/table/MasteAllCatTable;", "context", "Landroid/content/Context;", "selected_master_cat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "masterCatList", "Lcom/appnew/android/table/MasterCat;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getMasterCatList", "()Ljava/util/ArrayList;", "getSelected_master_cat", "setSelected_master_cat", "(Ljava/util/ArrayList;)V", "getView", "Landroid/view/View;", Const.POSITION, "", "convertView", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainCatAdapter extends ArrayAdapter<MasteAllCatTable> {
    public static final int $stable = 8;
    private final ArrayList<MasterCat> masterCatList;
    private ArrayList<MasteAllCatTable> selected_master_cat;

    public final ArrayList<MasterCat> getMasterCatList() {
        return this.masterCatList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainCatAdapter(Context context, ArrayList<MasteAllCatTable> selected_master_cat, ArrayList<MasterCat> masterCatList) {
        super(context, 0, selected_master_cat);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selected_master_cat, "selected_master_cat");
        Intrinsics.checkNotNullParameter(masterCatList, "masterCatList");
        this.masterCatList = masterCatList;
        new ArrayList();
        this.selected_master_cat = selected_master_cat;
    }

    public final ArrayList<MasteAllCatTable> getSelected_master_cat() {
        return this.selected_master_cat;
    }

    public final void setSelected_master_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selected_master_cat = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_part, parent, false);
        }
        Intrinsics.checkNotNull(convertView);
        View viewFindViewById = convertView.findViewById(R.id.tvName);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        if (StringsKt.equals(Const.THEME, "7", true)) {
            Iterator<MasterCat> it = this.masterCatList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MasterCat next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasterCat masterCat = next;
                if (StringsKt.equals(masterCat.getId(), this.selected_master_cat.get(position).getMaster_type(), true)) {
                    textView.setText(masterCat.getCat());
                    break;
                }
            }
            return convertView;
        }
        textView.setText(this.selected_master_cat.get(position).getName());
        return convertView;
    }
}
