package com.google.firebase.database;

import com.google.firebase.database.snapshot.Node;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class Transaction {

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public static class Result {
        private Node data;
        private boolean success;

        private Result(boolean z, Node node) {
            this.success = z;
            this.data = node;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public Node getNode() {
            return this.data;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Result abort() {
        return new Result(false, null);
    }

    public static Result success(MutableData mutableData) {
        return new Result(true, mutableData.getNode());
    }
}
