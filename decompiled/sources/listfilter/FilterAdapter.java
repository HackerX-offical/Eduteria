package listfilter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import listfilter.ListFilter;

/* JADX INFO: loaded from: classes10.dex */
public class FilterAdapter<T extends ListFilter> extends BaseAdapter implements Filterable {
    private Context mContext;
    private int mDropDownResource;
    private FilterAdapter<T>.ArrayFilter mFilter;
    private LayoutInflater mInflater;
    private List<T> mObjects;
    private ArrayList<T> mOriginalValues;
    private int mResource;
    private final Object mLock = new Object();
    private int mFieldId = 0;
    private boolean mNotifyOnChange = true;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public FilterAdapter(Context context, int i) {
        init(context, i, 0, new ArrayList());
    }

    public FilterAdapter(Context context, int i, int i2) {
        init(context, i, i2, new ArrayList());
    }

    public FilterAdapter(Context context, int i, T[] tArr) {
        init(context, i, 0, Arrays.asList(tArr));
    }

    public FilterAdapter(Context context, int i, int i2, T[] tArr) {
        init(context, i, i2, Arrays.asList(tArr));
    }

    public FilterAdapter(Context context, int i, List<T> list) {
        init(context, i, 0, list);
    }

    public FilterAdapter(Context context, int i, int i2, List<T> list) {
        init(context, i, i2, list);
    }

    public void add(T t) {
        if (this.mOriginalValues != null) {
            synchronized (this.mLock) {
                this.mOriginalValues.add(t);
                if (this.mNotifyOnChange) {
                    notifyDataSetChanged();
                }
            }
            return;
        }
        this.mObjects.add(t);
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void addAll(Collection<? extends T> collection) {
        if (this.mOriginalValues != null) {
            synchronized (this.mLock) {
                this.mOriginalValues.addAll(collection);
                if (this.mNotifyOnChange) {
                    notifyDataSetChanged();
                }
            }
            return;
        }
        this.mObjects.addAll(collection);
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void addAll(T... tArr) {
        int i = 0;
        if (this.mOriginalValues != null) {
            synchronized (this.mLock) {
                int length = tArr.length;
                while (i < length) {
                    this.mOriginalValues.add(tArr[i]);
                    i++;
                }
                if (this.mNotifyOnChange) {
                    notifyDataSetChanged();
                }
            }
            return;
        }
        int length2 = tArr.length;
        while (i < length2) {
            this.mObjects.add(tArr[i]);
            i++;
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void insert(T t, int i) {
        if (this.mOriginalValues != null) {
            synchronized (this.mLock) {
                this.mOriginalValues.add(i, t);
                if (this.mNotifyOnChange) {
                    notifyDataSetChanged();
                }
            }
            return;
        }
        this.mObjects.add(i, t);
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void remove(T t) {
        if (this.mOriginalValues != null) {
            synchronized (this.mLock) {
                this.mOriginalValues.remove(t);
            }
        } else {
            this.mObjects.remove(t);
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.mOriginalValues != null) {
            synchronized (this.mLock) {
                this.mOriginalValues.clear();
            }
        } else {
            this.mObjects.clear();
        }
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    public void sort(Comparator<? super T> comparator) {
        Collections.sort(this.mObjects, comparator);
        if (this.mNotifyOnChange) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.mNotifyOnChange = true;
    }

    public void setNotifyOnChange(boolean z) {
        this.mNotifyOnChange = z;
    }

    private void init(Context context, int i, int i2, List<T> list) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mDropDownResource = i;
        this.mResource = i;
        this.mObjects = list;
        this.mFieldId = i2;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mObjects.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.mObjects.get(i);
    }

    public int getPosition(T t) {
        return this.mObjects.indexOf(t);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return createViewFromResource(i, view, viewGroup, this.mResource);
    }

    private View createViewFromResource(int i, View view, ViewGroup viewGroup, int i2) {
        TextView textView;
        if (view == null) {
            view = this.mInflater.inflate(i2, viewGroup, false);
        }
        try {
            int i3 = this.mFieldId;
            if (i3 == 0) {
                textView = (TextView) view;
            } else {
                textView = (TextView) view.findViewById(i3);
            }
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
                return view;
            }
            textView.setText(item.toString());
            return view;
        } catch (ClassCastException e2) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", e2);
        }
    }

    public void setDropDownViewResource(int i) {
        this.mDropDownResource = i;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return createViewFromResource(i, view, viewGroup, this.mDropDownResource);
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mFilter == null) {
            this.mFilter = new ArrayFilter();
        }
        return this.mFilter;
    }

    private class ArrayFilter extends Filter {
        private ArrayFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (FilterAdapter.this.mOriginalValues == null) {
                synchronized (FilterAdapter.this.mLock) {
                    FilterAdapter.this.mOriginalValues = new ArrayList(FilterAdapter.this.mObjects);
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (FilterAdapter.this.mLock) {
                    ArrayList arrayList = new ArrayList(FilterAdapter.this.mOriginalValues);
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
                return filterResults;
            }
            String lowerCase = charSequence.toString().toLowerCase();
            ArrayList arrayList2 = FilterAdapter.this.mOriginalValues;
            int size = arrayList2.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                ListFilter listFilter = (ListFilter) arrayList2.get(i);
                if (listFilter.filterThisListItem(lowerCase)) {
                    arrayList3.add(listFilter);
                }
            }
            filterResults.values = arrayList3;
            filterResults.count = arrayList3.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            FilterAdapter.this.mObjects = (List) filterResults.values;
            if (filterResults.count > 0) {
                FilterAdapter.this.notifyDataSetChanged();
            } else {
                FilterAdapter.this.notifyDataSetInvalidated();
            }
        }
    }
}
