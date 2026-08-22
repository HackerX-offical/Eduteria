package com.skydoves.powermenu;

import android.widget.ListView;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
interface IMenuItem<T> {
    void addItem(int i, T t);

    void addItem(T t);

    void addItemList(List<T> list);

    void clearItems();

    int getContentViewHeight();

    List<T> getItemList();

    ListView getListView();

    int getSelectedPosition();

    void removeItem(int i);

    void removeItem(T t);

    void setListView(ListView listView);

    void setSelectedPosition(int i);
}
