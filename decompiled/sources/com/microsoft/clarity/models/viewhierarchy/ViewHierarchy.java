package com.microsoft.clarity.models.viewhierarchy;

import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ViewHierarchy;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\b\u0010\u001d\u001a\u00020\u0002H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$ViewHierarchy;", "timestamp", "", "root", "Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "visibleFragments", "", "", "activityName", "activityHashCode", "", "webViewsData", "", "Lcom/microsoft/clarity/models/viewhierarchy/WebViewData;", "(JLcom/microsoft/clarity/models/viewhierarchy/ViewNode;Ljava/util/Set;Ljava/lang/String;ILjava/util/List;)V", "getActivityHashCode", "()I", "getActivityName", "()Ljava/lang/String;", "getRoot", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewNode;", "getTimestamp", "()J", "getVisibleFragments", "()Ljava/util/Set;", "getWebViewsData", "()Ljava/util/List;", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewHierarchy implements IProtoModel<MutationPayload$ViewHierarchy> {
    private final transient int activityHashCode;
    private final transient String activityName;
    private final ViewNode root;
    private final long timestamp;
    private final Set<String> visibleFragments;
    private final transient List<WebViewData> webViewsData;

    public ViewHierarchy(long j, ViewNode root, Set<String> visibleFragments, String activityName, int i, List<WebViewData> webViewsData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(visibleFragments, "visibleFragments");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(webViewsData, "webViewsData");
        this.timestamp = j;
        this.root = root;
        this.visibleFragments = visibleFragments;
        this.activityName = activityName;
        this.activityHashCode = i;
        this.webViewsData = webViewsData;
    }

    public /* synthetic */ ViewHierarchy(long j, ViewNode viewNode, Set set, String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, viewNode, set, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final int getActivityHashCode() {
        return this.activityHashCode;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final ViewNode getRoot() {
        return this.root;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Set<String> getVisibleFragments() {
        return this.visibleFragments;
    }

    public final List<WebViewData> getWebViewsData() {
        return this.webViewsData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$ViewHierarchy toProtobufInstance() {
        MutationPayload$ViewHierarchy mutationPayload$ViewHierarchyBuild = MutationPayload$ViewHierarchy.newBuilder().a(this.root.toProtobufInstance()).a(this.timestamp).a(this.visibleFragments).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$ViewHierarchyBuild, "newBuilder()\n           …nts)\n            .build()");
        return mutationPayload$ViewHierarchyBuild;
    }
}
