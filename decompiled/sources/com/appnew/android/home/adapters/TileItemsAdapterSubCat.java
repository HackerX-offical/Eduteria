package com.appnew.android.home.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
import com.appnew.android.table.CourseTypeMasterTable;
import com.appnew.android.table.MasteAllCatTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class TileItemsAdapterSubCat extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<CourseTypeMasterTable> courseTypeMasterTables;
    DashboardTabAdapter.addDashboardItemClicked dashboardClicked;
    List<MasteAllCatTable> masteAllCatTables;

    public TileItemsAdapterSubCat(Context context, List<CourseTypeMasterTable> courseTypeMasterTables, DashboardTabAdapter.addDashboardItemClicked dashboardClicked) {
        this.courseTypeMasterTables = courseTypeMasterTables;
        this.context = context;
        this.dashboardClicked = dashboardClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holderMain, final int position) {
        CourseTypeMasterTable courseTypeMasterTable = this.courseTypeMasterTables.get(position);
        MyViewSubTileHolder myViewSubTileHolder = (MyViewSubTileHolder) holderMain;
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(this.context).load(!TextUtils.isEmpty(courseTypeMasterTable.getIcon()) ? courseTypeMasterTable.getIcon() : "");
        RequestOptions requestOptions = new RequestOptions();
        int i = R.mipmap.ic_launcher;
        RequestOptions requestOptionsError = requestOptions.error(R.mipmap.ic_launcher);
        if (courseTypeMasterTable.getId().equalsIgnoreCase("0010")) {
            i = R.mipmap.current_affairs;
        }
        requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptionsError.placeholder(i)).into(myViewSubTileHolder.tabIV1);
        ArrayList arrayList = new ArrayList();
        arrayList.add("#538C75");
        arrayList.add("#0CC292");
        arrayList.add("#FF3CBAEC");
        arrayList.add("#FF9C7BF1");
        arrayList.add("#C99ADD");
        arrayList.add("#DF61CA");
        arrayList.add("#FFE4E1");
        arrayList.add("#FFFFF0");
        arrayList.add("#538C75");
        arrayList.add("#0CC292");
        arrayList.add("#FF3CBAEC");
        arrayList.add("#FF9C7BF1");
        arrayList.add("#C99ADD");
        arrayList.add("#DF61CA");
        arrayList.add("#FFE4E1");
        arrayList.add("#FFFFF0");
        new Random().nextInt(11);
        myViewSubTileHolder.tabTitle1.setText(courseTypeMasterTable.getName());
        if (courseTypeMasterTable.getFont_color().equalsIgnoreCase("") || courseTypeMasterTable.getFont_color().equalsIgnoreCase(Constants.NULL_VERSION_ID)) {
            myViewSubTileHolder.tabTitle1.setTextColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
        } else {
            myViewSubTileHolder.tabTitle1.setTextColor(Color.parseColor(courseTypeMasterTable.getFont_color()));
        }
        if (courseTypeMasterTable.getBg_color().equalsIgnoreCase("") || courseTypeMasterTable.getBg_color().equalsIgnoreCase(Constants.NULL_VERSION_ID)) {
            myViewSubTileHolder.subTileItemCard.setCardBackgroundColor(Color.parseColor((String) arrayList.get(position)));
        } else {
            myViewSubTileHolder.subTileItemCard.setCardBackgroundColor(Color.parseColor(courseTypeMasterTable.getBg_color()));
        }
        myViewSubTileHolder.subTileItemCard.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileItemsAdapterSubCat.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        myViewSubTileHolder.subTileItemCard.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileItemsAdapterSubCat.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TileItemsAdapterSubCat.this.dashboardClicked.onDashboardItemClicked(position, TileItemsAdapterSubCat.this.courseTypeMasterTables.get(position).getId());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewSubTileHolder(LayoutInflater.from(this.context).inflate(R.layout.sub_tile_item_tabs, parent, false));
    }

    public class MyViewSubTileHolder extends RecyclerView.ViewHolder {
        RelativeLayout parentRL1;
        CardView subTileItemCard;
        ImageView tabIV1;
        TextView tabTitle1;

        public MyViewSubTileHolder(View view) {
            super(view);
            this.parentRL1 = (RelativeLayout) this.itemView.findViewById(R.id.parentRL1);
            this.tabIV1 = (ImageView) this.itemView.findViewById(R.id.tabIV1);
            this.tabTitle1 = (TextView) this.itemView.findViewById(R.id.tabTitle1);
            this.subTileItemCard = (CardView) this.itemView.findViewById(R.id.subTileItemCard);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }
}
