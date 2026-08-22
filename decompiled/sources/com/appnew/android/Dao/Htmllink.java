package com.appnew.android.Dao;

import com.appnew.android.table.HtmlTbale;

/* JADX INFO: loaded from: classes6.dex */
public interface Htmllink {
    long addUser(HtmlTbale htmlTbale);

    int deleteUser(HtmlTbale htmlTbale);

    void delete_viaconceptid(String videoid, String userid);

    void deletedata();

    HtmlTbale getconcept(String userid, String concept_id);

    boolean is_concept_exit(String user_id, String concept_id);

    int updateUser(HtmlTbale htmlTbale);

    void update_highlight(String highight, String userid, String concept_id);
}
