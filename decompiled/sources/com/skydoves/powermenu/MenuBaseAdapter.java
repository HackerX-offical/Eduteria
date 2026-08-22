package com.skydoves.powermenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class MenuBaseAdapter<T> extends BaseAdapter implements IMenuItem<T> {
    private ListView listView;
    private String preferenceName;
    private int selectedPosition = -1;
    private final List<T> itemList = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MenuBaseAdapter() {
    }

    public MenuBaseAdapter(ListView listView) {
        this.listView = listView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.itemList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.itemList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ListView listView;
        if (view != null && (listView = this.listView) != null && listView.getOnItemClickListener() != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.skydoves.powermenu.MenuBaseAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m12361lambda$getView$0$comskydovespowermenuMenuBaseAdapter(i, view2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: renamed from: lambda$getView$0$com-skydoves-powermenu-MenuBaseAdapter, reason: not valid java name */
    /* synthetic */ void m12361lambda$getView$0$comskydovespowermenuMenuBaseAdapter(int i, View view) {
        AdapterView.OnItemClickListener onItemClickListener = this.listView.getOnItemClickListener();
        ListView listView = this.listView;
        onItemClickListener.onItemClick(listView, view, i + listView.getHeaderViewsCount(), getItemId(i));
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void addItem(T t) {
        this.itemList.add(t);
        notifyDataSetChanged();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void addItem(int i, T t) {
        this.itemList.add(i, t);
        notifyDataSetChanged();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void addItemList(List<T> list) {
        this.itemList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void setSelectedPosition(int i) {
        String str;
        this.selectedPosition = i;
        MenuPreferenceManager menuPreferenceManager = MenuPreferenceManager.getInstance();
        if (menuPreferenceManager == null || (str = this.preferenceName) == null) {
            return;
        }
        menuPreferenceManager.setPosition(str, i);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public ListView getListView() {
        return this.listView;
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void setListView(ListView listView) {
        this.listView = listView;
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void removeItem(T t) {
        this.itemList.remove(t);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void removeItem(int i) {
        this.itemList.remove(i);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void clearItems() {
        this.itemList.clear();
        notifyDataSetChanged();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public List<T> getItemList() {
        return this.itemList;
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public int getContentViewHeight() {
        int measuredHeight = 0;
        for (int i = 0; i < getCount(); i++) {
            View view = getView(i, null, getListView());
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += view.getMeasuredHeight();
        }
        int dividerHeight = measuredHeight + (getListView().getDividerHeight() * (getCount() - 1));
        ViewGroup.LayoutParams layoutParams = getListView().getLayoutParams();
        layoutParams.height = dividerHeight;
        getListView().setLayoutParams(layoutParams);
        return dividerHeight;
    }

    public void setPreference(String str) {
        this.preferenceName = str;
    }

    public String getPreferenceName() {
        return this.preferenceName;
    }
}
