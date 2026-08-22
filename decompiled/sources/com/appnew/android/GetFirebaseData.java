package com.appnew.android;

import android.content.Context;
import android.util.Log;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.SharedPreference;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: GetFirebaseData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/GetFirebaseData;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "removeNameFromRoom", "", "unpublishList", "", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetFirebaseData {
    public static final int $stable = 8;
    private final Context context;

    public GetFirebaseData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/courses/");
        Intrinsics.checkNotNullExpressionValue(databaseReferenceChild, "child(...)");
        databaseReferenceChild.addChildEventListener(new ChildEventListener() { // from class: com.appnew.android.GetFirebaseData.1
            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildRemoved(DataSnapshot snapshot) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                ArrayList arrayList = new ArrayList();
                Iterator<DataSnapshot> it = snapshot.getChildren().iterator();
                while (it.hasNext()) {
                    String str = (String) it.next().getValue(String.class);
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
                filterCourseList(arrayList);
            }

            private final void filterCourseList(List<String> newList) {
                LinkedHashSet linkedHashSet;
                Set<String> stringSet = SharedPreference.getInstance().getStringSet("unpublish_list");
                if (stringSet == null || (linkedHashSet = CollectionsKt.toMutableSet(stringSet)) == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                List<String> list = newList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!linkedHashSet.contains((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                List listAsMutableList = TypeIntrinsics.asMutableList(arrayList);
                List list2 = listAsMutableList;
                if (!list2.isEmpty()) {
                    GetFirebaseData.this.removeNameFromRoom(listAsMutableList);
                    linkedHashSet.addAll(list2);
                    SharedPreference.getInstance().putStringSet("unpublish_list", CollectionsKt.toSet(linkedHashSet));
                    return;
                }
                SharedPreference.getInstance().putStringSet("unpublish_list", CollectionsKt.toSet(list));
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onCancelled(DatabaseError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Log.e("Firebase", "Error: " + error.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeNameFromRoom(List<String> unpublishList) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.context);
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05351(unpublishList, 900, appDatabase, null), 3, null);
    }

    /* JADX INFO: renamed from: com.appnew.android.GetFirebaseData$removeNameFromRoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GetFirebaseData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.GetFirebaseData$removeNameFromRoom$1", f = "GetFirebaseData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $chunkSize;
        final /* synthetic */ UtkashRoom $myDBClass;
        final /* synthetic */ List<String> $unpublishList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05351(List<String> list, int i, UtkashRoom utkashRoom, Continuation<? super C05351> continuation) {
            super(2, continuation);
            this.$unpublishList = list;
            this.$chunkSize = i;
            this.$myDBClass = utkashRoom;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05351(this.$unpublishList, this.$chunkSize, this.$myDBClass, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<List<String>> listChunked = CollectionsKt.chunked(this.$unpublishList, this.$chunkSize);
            UtkashRoom utkashRoom = this.$myDBClass;
            for (List<String> list : listChunked) {
                Log.d("shivam", "removeNameFromRoom:" + list.size());
                utkashRoom.getCoursedata().deleteMultipleId(list);
            }
            return Unit.INSTANCE;
        }
    }
}
