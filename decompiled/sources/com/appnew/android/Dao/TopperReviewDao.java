package com.appnew.android.Dao;

import com.appnew.android.table.TopperReviewTable;

/* JADX INFO: loaded from: classes6.dex */
public interface TopperReviewDao {
    long addTopperReview(TopperReviewTable topperReviewTable);

    void deleteTopperReview();

    int deleteopperReview(TopperReviewTable topperReviewTable);

    TopperReviewTable getTopperReview();

    TopperReviewTable getTopperReview(String videoid);

    int updateopperReview(TopperReviewTable topperReviewTable);
}
