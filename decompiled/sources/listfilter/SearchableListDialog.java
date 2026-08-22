package listfilter;

import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import datamodels.PWEStaticDataModel;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class SearchableListDialog extends DialogFragment implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, Serializable {
    private static final String ITEMS = "items";
    private ListView _listViewItems;
    private DialogInterface.OnClickListener _onClickListener;
    private OnSearchTextChanged _onSearchTextChanged;
    private SearchView _searchView;
    private SearchableItem _searchableItem;
    private String _strPositiveButtonText;
    private String _strTitle;
    private int filterItemCount = 0;
    private PWEGeneralHelper generalHelper;
    private ArrayAdapter listAdapter;
    private TextView tvNoResults;

    public interface OnSearchTextChanged {
        void onSearchTextChanged(String str);
    }

    public interface SearchableItem<T> extends Serializable {
        void onSearchableItemClicked(T t, int i);
    }

    @Override // androidx.appcompat.widget.SearchView.OnCloseListener
    public boolean onClose() {
        return false;
    }

    public static SearchableListDialog newInstance(List list) {
        SearchableListDialog searchableListDialog = new SearchableListDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("items", (Serializable) list);
        searchableListDialog.setArguments(bundle);
        return searchableListDialog;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.generalHelper = new PWEGeneralHelper(getActivity());
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.searchable_list_dialog, viewGroup, false);
        if (bundle != null) {
            this._searchableItem = (SearchableItem) bundle.getSerializable("item");
        }
        setData(viewInflate);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public static DisplayMetrics getDeviceMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("item", this._searchableItem);
        super.onSaveInstanceState(bundle);
    }

    public void setTitle(String str) {
        this._strTitle = str;
    }

    public void setPositiveButton(String str) {
        this._strPositiveButtonText = str;
    }

    public void setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
        this._strPositiveButtonText = str;
        this._onClickListener = onClickListener;
    }

    public void setOnSearchableItemClickListener(SearchableItem searchableItem) {
        this._searchableItem = searchableItem;
    }

    public void setOnSearchTextChangedListener(OnSearchTextChanged onSearchTextChanged) {
        this._onSearchTextChanged = onSearchTextChanged;
    }

    private void setData(View view) {
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(FirebaseAnalytics.Event.SEARCH);
        this._searchView = (SearchView) view.findViewById(R.id.search);
        TextView textView = (TextView) view.findViewById(R.id.txt_no_results_found);
        this.tvNoResults = textView;
        textView.setVisibility(8);
        final EditText editText = (EditText) this._searchView.findViewById(R.id.search_src_text);
        try {
            this.generalHelper.pweDisableCopyAndPaste(editText);
        } catch (Error | Exception unused) {
        }
        editText.setHint("Search");
        editText.setTextColor(getResources().getColor(R.color.pwe_text_color));
        editText.setHintTextColor(getResources().getColor(R.color.pwe_hint_color));
        editText.setMinHeight(50);
        editText.setGravity(17);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: listfilter.SearchableListDialog.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (PWEStaticDataModel.PWE_CURRENT_DEVICE_TYPE.equals("TV")) {
                    if (z) {
                        editText.setBackground(SearchableListDialog.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        editText.setBackground(SearchableListDialog.this.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this._searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        this._searchView.setIconifiedByDefault(false);
        this._searchView.setIconified(false);
        this._searchView.setOnQueryTextListener(this);
        this._searchView.setOnCloseListener(this);
        this._searchView.clearFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInputFromInputMethod(this._searchView.getWindowToken(), 0);
        List list = (List) getArguments().getSerializable("items");
        this._listViewItems = (ListView) view.findViewById(R.id.listItems);
        if (PWEStaticDataModel.PWE_CURRENT_DEVICE_TYPE.equals("TV")) {
            this._listViewItems.setSelector(getResources().getDrawable(R.drawable.pwe_listview_item_selector));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_custom_layout, list);
        this.listAdapter = arrayAdapter;
        this._listViewItems.setAdapter((ListAdapter) arrayAdapter);
        this._listViewItems.setTextFilterEnabled(true);
        this._listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: listfilter.SearchableListDialog.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                SearchableListDialog.this._searchableItem.onSearchableItemClicked(SearchableListDialog.this.listAdapter.getItem(i), i);
                editText.setText("");
                SearchableListDialog.this.getDialog().dismiss();
            }
        });
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        this._searchView.clearFocus();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        if (TextUtils.isEmpty(str)) {
            ((ArrayAdapter) this._listViewItems.getAdapter()).getFilter().filter(null);
        } else {
            ((ArrayAdapter) this._listViewItems.getAdapter()).getFilter().filter(str);
        }
        ((ArrayAdapter) this._listViewItems.getAdapter()).getFilter().filter(str, new Filter.FilterListener() { // from class: listfilter.SearchableListDialog.3
            @Override // android.widget.Filter.FilterListener
            public void onFilterComplete(int i) {
                SearchableListDialog.this.filterItemCount = i;
                SearchableListDialog.this.setSearchLabel();
            }
        });
        OnSearchTextChanged onSearchTextChanged = this._onSearchTextChanged;
        if (onSearchTextChanged != null) {
            onSearchTextChanged.onSearchTextChanged(str);
        }
        setSearchLabel();
        return true;
    }

    public void setSearchLabel() {
        if (this.filterItemCount <= 0) {
            this.tvNoResults.setVisibility(0);
        } else {
            this.tvNoResults.setVisibility(8);
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            getDialog().dismiss();
        } catch (Exception unused) {
        }
    }
}
