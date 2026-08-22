package com.appnew.android.Login.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CourseDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    BottomSetting bottomSetting;
    ArrayList<Courselist> courseDataArrayList;
    String course_id;
    String course_name;
    String course_price;
    String course_quantity;
    String course_tex;
    String isBook;
    ItemClicked itemClicked;
    NetworkCall networkCall;
    private MyViewHodler oldHolder;
    private int posOld;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    public interface ItemClicked {
        void onItemClicked(String course_id);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    public CourseDataAdapter(Activity activity, ArrayList<Courselist> courseDataArrayList, String isBook, ItemClicked itemClicked) {
        this.activity = activity;
        this.courseDataArrayList = courseDataArrayList;
        this.isBook = isBook;
        this.itemClicked = itemClicked;
        this.networkCall = new NetworkCall(this, activity);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHodler(LayoutInflater.from(this.activity).inflate(R.layout.choose_course_item_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHodler myViewHodler = (MyViewHodler) holder;
        myViewHodler.setData(this.courseDataArrayList.get(position), myViewHodler, position);
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
                    Toast.makeText(this.activity, "" + jsonstring.getString("message"), 0).show();
                } else {
                    Toast.makeText(this.activity, jsonstring.getString("message"), 0).show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        ImageView iv_check;
        LinearLayout llmain;
        TextView tv_title;

        public MyViewHodler(View itemView) {
            super(itemView);
            this.llmain = (LinearLayout) itemView.findViewById(R.id.ll_main);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.iv_check = (ImageView) itemView.findViewById(R.id.iv_check);
        }

        public void setData(final Courselist course, final MyViewHodler hodler, final int pos) {
            this.tv_title.setText(course.getTitle());
            if (course.getViewType().equalsIgnoreCase("0")) {
                hodler.llmain.setBackground(CourseDataAdapter.this.activity.getDrawable(R.drawable.gray_stroke_bg));
                hodler.iv_check.setImageResource(R.drawable.gray_img);
            } else {
                CourseDataAdapter.this.oldHolder = hodler;
                CourseDataAdapter.this.posOld = pos;
                hodler.llmain.setBackground(CourseDataAdapter.this.activity.getDrawable(R.drawable.primary_stroke_bg));
                hodler.iv_check.setImageResource(R.drawable.primary_check_img);
            }
            this.llmain.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Adapter.CourseDataAdapter$MyViewHodler$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(hodler, pos, course, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(MyViewHodler myViewHodler, int i, Courselist courselist, View view) {
            if (Helper.isNetworkConnected(CourseDataAdapter.this.activity)) {
                if (CourseDataAdapter.this.oldHolder != null) {
                    CourseDataAdapter.this.oldHolder.llmain.setBackground(CourseDataAdapter.this.activity.getDrawable(R.drawable.gray_stroke_bg));
                    CourseDataAdapter.this.oldHolder.iv_check.setImageResource(R.drawable.gray_img);
                    CourseDataAdapter.this.courseDataArrayList.get(CourseDataAdapter.this.posOld).setViewType("0");
                }
                CourseDataAdapter.this.oldHolder = myViewHodler;
                CourseDataAdapter.this.posOld = i;
                CourseDataAdapter.this.courseDataArrayList.get(i).setViewType("1");
                myViewHodler.llmain.setBackground(CourseDataAdapter.this.activity.getDrawable(R.drawable.primary_stroke_bg));
                myViewHodler.iv_check.setImageResource(R.drawable.primary_check_img);
                CourseDataAdapter.this.itemClicked.onItemClicked(courselist.getId());
                return;
            }
            Helper.showInternetToast(CourseDataAdapter.this.activity);
        }
    }
}
