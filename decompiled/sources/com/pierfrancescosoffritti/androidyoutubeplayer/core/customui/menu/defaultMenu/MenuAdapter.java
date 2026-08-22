package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.defaultMenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.MenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: MenuAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/defaultMenu/MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/defaultMenu/MenuAdapter$ViewHolder;", "context", "Landroid/content/Context;", "menuItems", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/MenuItem;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", Const.POSITION, "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final List<MenuItem> menuItems;

    public MenuAdapter(Context context, List<MenuItem> menuItems) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ayp_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ViewHolder(this, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getRoot().setOnClickListener(this.menuItems.get(position).getOnClickListener());
        holder.getTextView().setText(this.menuItems.get(position).getText());
        Integer icon = this.menuItems.get(position).getIcon();
        if (icon != null) {
            holder.getTextView().setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this.context, icon.intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.menuItems.size();
    }

    /* JADX INFO: compiled from: MenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/defaultMenu/MenuAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/defaultMenu/MenuAdapter;Landroid/view/View;)V", "getRoot", "()Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final View root;
        private final TextView textView;
        final /* synthetic */ MenuAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MenuAdapter menuAdapter, View root) {
            super(root);
            Intrinsics.checkNotNullParameter(root, "root");
            this.this$0 = menuAdapter;
            this.root = root;
            View viewFindViewById = root.findViewById(R.id.text);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "root.findViewById(R.id.text)");
            this.textView = (TextView) viewFindViewById;
        }

        public final View getRoot() {
            return this.root;
        }

        public final TextView getTextView() {
            return this.textView;
        }
    }
}
