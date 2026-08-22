package com.google.firebase.database;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface ChildEventListener {
    void onCancelled(DatabaseError databaseError);

    void onChildAdded(DataSnapshot dataSnapshot, String str);

    void onChildChanged(DataSnapshot dataSnapshot, String str);

    void onChildMoved(DataSnapshot dataSnapshot, String str);

    void onChildRemoved(DataSnapshot dataSnapshot);
}
