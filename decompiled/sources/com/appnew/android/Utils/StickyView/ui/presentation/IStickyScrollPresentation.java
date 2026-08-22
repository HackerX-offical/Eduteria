package com.appnew.android.Utils.StickyView.ui.presentation;

/* JADX INFO: loaded from: classes6.dex */
public interface IStickyScrollPresentation {
    void freeFooter();

    void freeHeader();

    int getCurrentScrollYPos();

    void initFooterView(int id);

    void initHeaderView(int id);

    void stickFooter(int translationY);

    void stickHeader(int translationY);
}
