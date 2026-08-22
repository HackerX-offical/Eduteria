package com.clevertap.android.sdk.db.dao;

import com.clevertap.android.sdk.inbox.CTMessageDAO;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: InboxMessageDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH'J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/InboxMessageDAO;", "", "getMessages", "Lkotlin/collections/ArrayList;", "Lcom/clevertap/android/sdk/inbox/CTMessageDAO;", "Ljava/util/ArrayList;", "userId", "", "(Ljava/lang/String;)Ljava/util/ArrayList;", "upsertMessages", "", "inboxMessages", "", "deleteMessage", "", "messageId", "deleteMessages", "messageIds", "markMessageAsRead", "markMessagesAsRead", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InboxMessageDAO {
    boolean deleteMessage(String messageId, String userId);

    boolean deleteMessages(List<String> messageIds, String userId);

    ArrayList<CTMessageDAO> getMessages(String userId);

    boolean markMessageAsRead(String messageId, String userId);

    boolean markMessagesAsRead(List<String> messageIds, String userId);

    void upsertMessages(List<? extends CTMessageDAO> inboxMessages);
}
