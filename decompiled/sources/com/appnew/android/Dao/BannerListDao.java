package com.appnew.android.Dao;

import com.appnew.android.table.BannerListTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface BannerListDao {
    long addBanner(BannerListTable bannerListTable);

    int deleteBanner(BannerListTable bannerListTable);

    void deleteBanners();

    List<BannerListTable> getAllBanners();

    List<BannerListTable> getBanner(String userid);

    int updateBanner(BannerListTable bannerListTable);
}
