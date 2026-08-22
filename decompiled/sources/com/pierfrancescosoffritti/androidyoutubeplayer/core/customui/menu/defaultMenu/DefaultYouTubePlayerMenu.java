package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.defaultMenu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.MenuItem;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultYouTubePlayerMenu.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/defaultMenu/DefaultYouTubePlayerMenu;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/YouTubePlayerMenu;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemCount", "", "getItemCount", "()I", "menuItems", "Ljava/util/ArrayList;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/MenuItem;", "Lkotlin/collections/ArrayList;", "popupWindow", "Landroid/widget/PopupWindow;", "addItem", "menuItem", "createPopupWindow", "dismiss", "", "removeItem", "itemIndex", "show", "anchorView", "Landroid/view/View;", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultYouTubePlayerMenu implements YouTubePlayerMenu {
    private final Context context;
    private final ArrayList<MenuItem> menuItems;
    private PopupWindow popupWindow;

    public DefaultYouTubePlayerMenu(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.menuItems = new ArrayList<>();
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu
    public int getItemCount() {
        return this.menuItems.size();
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu
    public void show(View anchorView) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        PopupWindow popupWindowCreatePopupWindow = createPopupWindow();
        this.popupWindow = popupWindowCreatePopupWindow;
        if (popupWindowCreatePopupWindow != null) {
            popupWindowCreatePopupWindow.showAsDropDown(anchorView, (-this.context.getResources().getDimensionPixelSize(R.dimen.ayp_8dp)) * 12, (-this.context.getResources().getDimensionPixelSize(R.dimen.ayp_8dp)) * 12);
        }
        if (this.menuItems.size() == 0) {
            Log.e(YouTubePlayerMenu.class.getName(), "The menu is empty");
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu
    public void dismiss() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu
    public YouTubePlayerMenu addItem(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        this.menuItems.add(menuItem);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu
    public YouTubePlayerMenu removeItem(int itemIndex) {
        this.menuItems.remove(itemIndex);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu
    public YouTubePlayerMenu removeItem(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        this.menuItems.remove(menuItem);
        return this;
    }

    private final PopupWindow createPopupWindow() {
        Object systemService = this.context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.ayp_player_menu, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        recyclerView.setAdapter(new MenuAdapter(this.context, this.menuItems));
        recyclerView.setHasFixedSize(true);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setContentView(viewInflate);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        return popupWindow;
    }
}
