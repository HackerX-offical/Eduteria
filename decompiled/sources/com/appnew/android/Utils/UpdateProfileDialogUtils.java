package com.appnew.android.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Address;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class UpdateProfileDialogUtils {
    public static String SelectedCityid = "";
    public static String SelectedStateid = "";
    public static Address address = null;
    public static String addressJson = null;
    public static StatesCities cities = null;
    public static String cityindex = "";
    public static String clicktype = "";
    public static TextView districtTV = null;
    public static EditText etSearch = null;
    public static ImageView ivClearSearch = null;
    public static LeftMenu leftMenu = null;
    public static long mLastClickTime = 0;
    public static RecyclerView searchRecyclerview = null;
    public static StateCityAdapter stateCityAdapter = null;
    public static TextView stateSpinner = null;
    public static String stateindex = "";
    public static StatesCities states = null;
    public static TextView statesTV = null;
    public static String submitType = "0";
    public static UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    public static ArrayList<StatesCitiesData> statesCitiesArrayList = new ArrayList<>();

    public interface onDialogUtilsOkClick {
        void onOKClick(Dialog dialog, String submitType, String stateId, String districtId, String addressJson);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void makeDialogForStateUpdate(final android.content.Context r22, boolean r23, final com.appnew.android.Utils.UpdateProfileDialogUtils.onDialogUtilsOkClick r24) {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.UpdateProfileDialogUtils.makeDialogForStateUpdate(android.content.Context, boolean, com.appnew.android.Utils.UpdateProfileDialogUtils$onDialogUtilsOkClick):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void performSubmitClick(Dialog dialog, onDialogUtilsOkClick okClick, String submitType2, String stateId, String districtId, String addressJson2) {
        if (okClick != null) {
            okClick.onOKClick(dialog, submitType2, stateId, districtId, addressJson2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchStates(Context context) {
        StatesCities statesCities = states;
        if (statesCities != null && statesCities.getData() != null && !states.getData().isEmpty()) {
            clicktype = "1";
            filterList(context, "1", states);
        } else {
            callStateCityAPI(context, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchCities(Context context) {
        if (TextUtils.isEmpty(SelectedStateid)) {
            Toast.makeText(context, context.getResources().getString(R.string.please_select_state_first), 0).show();
        } else {
            callStateCityAPI(context, false);
        }
    }

    public static boolean isUserStateFound() {
        return (SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getState() == null || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getState())) ? false : true;
    }

    public static void filterList(Context context, String searchType, StatesCities states2) {
        try {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.state_city_dialog);
            dialog.setCancelable(true);
            dialog.getWindow().setSoftInputMode(16);
            etSearch = (EditText) dialog.findViewById(R.id.et_search);
            if (searchType.equalsIgnoreCase("1")) {
                etSearch.setHint(context.getResources().getString(R.string.search_state));
            } else if (searchType.equalsIgnoreCase("2")) {
                etSearch.setHint(context.getResources().getString(R.string.search_district));
            } else if (searchType.equalsIgnoreCase("3")) {
                etSearch.setHint(context.getResources().getString(R.string.search_country));
            }
            ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
            TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
            ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.UpdateProfileDialogUtils$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpdateProfileDialogUtils.etSearch.setText("");
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.UpdateProfileDialogUtils$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
            searchRecyclerview = recyclerView;
            recyclerView.setHasFixedSize(true);
            searchRecyclerview.setLayoutManager(new LinearLayoutManager(context));
            StateCityAdapter stateCityAdapter2 = new StateCityAdapter(context, states2, searchType, dialog);
            stateCityAdapter = stateCityAdapter2;
            searchRecyclerview.setAdapter(stateCityAdapter2);
            textWatcher(searchType);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            dialog.show();
        } catch (Exception e2) {
            Log.d("Dialog", "filterList: " + e2.getMessage());
        }
    }

    public static void textWatcher(final String searchType) {
        etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Utils.UpdateProfileDialogUtils.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    UpdateProfileDialogUtils.ivClearSearch.setVisibility(0);
                } else {
                    UpdateProfileDialogUtils.ivClearSearch.setVisibility(8);
                }
                UpdateProfileDialogUtils.filter(editable.toString(), searchType);
            }
        });
    }

    public static void filter(String text, String searchType) {
        statesCitiesArrayList.clear();
        if (searchType.equalsIgnoreCase("1")) {
            for (StatesCitiesData statesCitiesData : states.getData()) {
                if (statesCitiesData.getName().toLowerCase().contains(text.toLowerCase())) {
                    statesCitiesArrayList.add(statesCitiesData);
                }
            }
        } else if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData2 : cities.getData()) {
                if (statesCitiesData2.getName().toLowerCase().contains(text.toLowerCase())) {
                    statesCitiesArrayList.add(statesCitiesData2);
                }
            }
        }
        if (!statesCitiesArrayList.isEmpty()) {
            searchRecyclerview.setVisibility(0);
            stateCityAdapter.filterCountryList(statesCitiesArrayList);
        } else {
            searchRecyclerview.setVisibility(4);
        }
    }

    public static class StateCityAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        List<StatesCitiesData> countryArrayList;
        Dialog searchDialog;
        String searchType;
        TextView stateSpinner;
        StatesCities states;

        public StateCityAdapter(Context context, StatesCities states, String searchType, Dialog searchDialog) {
            this.context = context;
            this.states = states;
            this.countryArrayList = states.getData();
            this.searchType = searchType;
            this.searchDialog = searchDialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.state_city_dialog_adapter_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
            final StatesCitiesData statesCitiesData = this.countryArrayList.get(i);
            myViewHolder.tvName.setText(statesCitiesData.getName());
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.UpdateProfileDialogUtils$StateCityAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(statesCitiesData, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(StatesCitiesData statesCitiesData, View view) {
            Dialog dialog = this.searchDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            String str = this.searchType;
            str.hashCode();
            switch (str) {
                case "1":
                    UpdateProfileDialogUtils.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "2":
                    UpdateProfileDialogUtils.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "3":
                    UpdateProfileDialogUtils.onStateCityClick(this.searchType, statesCitiesData);
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.countryArrayList.size();
        }

        public void filterCountryList(List<StatesCitiesData> newCountryArrayList) {
            this.countryArrayList = newCountryArrayList;
            notifyDataSetChanged();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvName;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.tvName = (TextView) itemView.findViewById(R.id.nameTv);
            }
        }
    }

    public static void onStateCityClick(String searchType, StatesCitiesData country) {
        if (searchType.equalsIgnoreCase("1")) {
            for (StatesCitiesData statesCitiesData : states.getData()) {
                if (statesCitiesData.getName().equals(country.getName())) {
                    stateindex = country.getName();
                    SelectedStateid = statesCitiesData.getId();
                    stateSpinner.setText(country.getName());
                    statesTV.setText(country.getName());
                    districtTV.setText("");
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData2 : cities.getData()) {
                if (statesCitiesData2.getName().equals(country.getName())) {
                    cityindex = country.getName();
                    SelectedCityid = statesCitiesData2.getId();
                    districtTV.setText(country.getName());
                    return;
                }
            }
        }
    }

    public static void callStateCityAPI(final Context context, final Boolean isState) {
        try {
            final Progress progress = new Progress(context);
            progress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            if (!isState.booleanValue()) {
                encryptionData.setState_id(SelectedStateid);
            } else {
                encryptionData.setCountry_id("");
            }
            ((Call) Objects.requireNonNull(isState.booleanValue() ? aPIInterface.GetState(AES.encrypt(new Gson().toJson(encryptionData))) : aPIInterface.GetCity(AES.encrypt(new Gson().toJson(encryptionData))))).enqueue(new Callback<String>() { // from class: com.appnew.android.Utils.UpdateProfileDialogUtils.4
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    try {
                        progress.dismiss();
                        if (response.body() != null) {
                            StatesCities statesCities = (StatesCities) new Gson().fromJson(new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI())).toString(), StatesCities.class);
                            if (statesCities != null && statesCities.getData() != null && !statesCities.getData().isEmpty()) {
                                if (isState.booleanValue()) {
                                    UpdateProfileDialogUtils.states = statesCities;
                                    UpdateProfileDialogUtils.clicktype = "1";
                                    UpdateProfileDialogUtils.filterList(context, UpdateProfileDialogUtils.clicktype, UpdateProfileDialogUtils.states);
                                    return;
                                } else {
                                    UpdateProfileDialogUtils.cities = statesCities;
                                    UpdateProfileDialogUtils.clicktype = "2";
                                    UpdateProfileDialogUtils.filterList(context, UpdateProfileDialogUtils.clicktype, UpdateProfileDialogUtils.cities);
                                    return;
                                }
                            }
                            Context context2 = context;
                            Toast.makeText(context2, context2.getResources().getString(R.string.no_data_found), 1).show();
                            return;
                        }
                        Context context3 = context;
                        Toast.makeText(context3, context3.getResources().getString(R.string.no_data_found), 1).show();
                    } catch (Exception unused) {
                        Context context4 = context;
                        Toast.makeText(context4, context4.getResources().getString(R.string.something_went_wrong), 1).show();
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    progress.dismiss();
                    Context context2 = context;
                    Toast.makeText(context2, context2.getResources().getString(R.string.something_went_wrong), 1).show();
                }
            });
        } catch (Exception e2) {
            Log.d("Dialog", "callStateCityAPI: " + e2.getMessage());
        }
    }

    public static boolean numberValidation(Context context, EditText mobileNumberEditText) {
        String strTrim = mobileNumberEditText.getText().toString().trim();
        if (!TextUtils.isDigitsOnly(strTrim)) {
            return true;
        }
        if (TextUtils.isEmpty(strTrim)) {
            return Helper.DataNotValid(mobileNumberEditText, context);
        }
        if (!Patterns.PHONE.matcher(strTrim).matches() || strTrim.length() != 10) {
            return Helper.DataNotValid(mobileNumberEditText, 2, context);
        }
        if (Helper.isInValidIndianMobile(strTrim)) {
            return Helper.DataNotValid(mobileNumberEditText, 2, context);
        }
        return true;
    }
}
