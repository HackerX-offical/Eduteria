package com.appnew.android.Dao;

import com.appnew.android.table.PostDataTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface FeedsDao {
    void deletePost(String mainCat, String subcat);

    void deletePosts();

    void deletePosts_via_id(String mainCat);

    void deletePosts_via_post_type(String mainCat, String liveclassposttype, String livetestposttype);

    void deleteSubCatFeed(String mainCat, String subcat, String liveclassposttype, String livetestposttype);

    void deletedata();

    void deletepost_without_liveclass(String mainCat, String liveclassposttype, String livetestposttype);

    void insertPost(PostDataTable post);

    boolean isFeedExist(String postid);

    boolean isFeedExistviamaincat(String posttype, String subcat);

    boolean isliveclassExist(String posttype, String maincat);

    PostDataTable postData(String postid);

    List<PostDataTable> retrievePostData(String mainCat);

    List<PostDataTable> retrievePostData(String parentId, String main, String subcat);

    List<PostDataTable> retrievePostData_viaposttype(String parentId, String main, String subcat, String posttype);

    List<PostDataTable> retrievePostData_viaposttype_withoutsubcat(String parentId, String main, String posttype);

    List<PostDataTable> retrievePostData_withoutsubcat(String parentId, String main);

    PostDataTable retriveObject(String mainCat, String postid);

    void updateMyLike(String post_id, String myLike, String totalike);

    void updateMyjson(String post_id, String json);

    void updatePinnedPost(String pinnedPost, String post_id);

    void update_result(String json, String post_id, String mainid);
}
