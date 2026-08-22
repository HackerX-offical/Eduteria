package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: YouTubePlayerMenu.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/YouTubePlayerMenu;", "", "itemCount", "", "getItemCount", "()I", "addItem", "menuItem", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/MenuItem;", "dismiss", "", "removeItem", "itemIndex", "show", "anchorView", "Landroid/view/View;", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface YouTubePlayerMenu {
    YouTubePlayerMenu addItem(MenuItem menuItem);

    void dismiss();

    int getItemCount();

    YouTubePlayerMenu removeItem(int itemIndex);

    YouTubePlayerMenu removeItem(MenuItem menuItem);

    void show(View anchorView);
}
