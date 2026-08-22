package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.PrizeCourselist;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class OfferedCourseListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    ArrayList<PrizeCourselist> courseDataArrayList;
    String course_id;
    String course_name;
    String course_price;
    String course_quantity;
    boolean isPurchased;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public OfferedCourseListAdapter(Activity activity, ArrayList<PrizeCourselist> courseDataArrayList, String isBook) {
        this.isPurchased = false;
        new ArrayList();
        this.activity = activity;
        this.courseDataArrayList = courseDataArrayList;
        Iterator<PrizeCourselist> it = courseDataArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getIs_purchased().equalsIgnoreCase("1")) {
                this.isPurchased = true;
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHodler(LayoutInflater.from(this.activity).inflate(R.layout.child_qualified_courses, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return "1".equalsIgnoreCase("7") ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHodler) holder).setData(this.courseDataArrayList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseDataArrayList.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.COURSE_ADD_TO_CART)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.course_id);
        encryptionData.setCourse_name(this.course_name);
        encryptionData.setQuantity(this.course_quantity);
        encryptionData.setCourse_price(this.course_price);
        return service.addItemInCart(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.COURSE_ADD_TO_CART)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    return;
                }
                Toast.makeText(this.activity, jsonstring.getString("message"), 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        RelativeLayout rl_main;
        TextView tv_course_title;
        TextView tv_discount_message;
        TextView tv_enroll_now;
        View viewid;

        public MyViewHodler(View itemView) {
            super(itemView);
            this.tv_course_title = (TextView) itemView.findViewById(R.id.tv_course_title);
            this.tv_discount_message = (TextView) itemView.findViewById(R.id.tv_discount_message);
            this.tv_enroll_now = (TextView) itemView.findViewById(R.id.tv_enroll_now);
            this.rl_main = (RelativeLayout) itemView.findViewById(R.id.rl_main);
            this.viewid = itemView.findViewById(R.id.viewid);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:28:0x00d4
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setData(final com.appnew.android.Model.PrizeCourselist r8, int r9) {
            /*
                Method dump skipped, instruction units count: 268
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodule.adapter.OfferedCourseListAdapter.MyViewHodler.setData(com.appnew.android.Model.PrizeCourselist, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(PrizeCourselist prizeCourselist, View view) {
            if (prizeCourselist.getIs_purchased().equalsIgnoreCase("1")) {
                Toast.makeText(OfferedCourseListAdapter.this.activity, "Already enrolled", 0).show();
                return;
            }
            if (Helper.isNetworkConnected(OfferedCourseListAdapter.this.activity)) {
                if (TextUtils.isEmpty(prizeCourselist.getMaintenanceText())) {
                    Intent intent = new Intent(OfferedCourseListAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, prizeCourselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, prizeCourselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, prizeCourselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, prizeCourselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, OfferedCourseListAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(OfferedCourseListAdapter.this.activity, "", prizeCourselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(OfferedCourseListAdapter.this.activity);
        }
    }
}
