package com.appnew.android.Model.CartModel;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class RewardModel {

    public class Data {
        public RewardTotal reward_total;
        public ArrayList<RewardTxn> reward_txn;

        public Data() {
        }
    }

    public class RewardTotal {
        public String count;

        public RewardTotal() {
        }
    }

    public class RewardTxn {
        public String area;
        public String creation_time;
        public String id;
        public String reward;
        public String txn_type;
        public String user_id;

        public RewardTxn() {
        }
    }

    public class Root {
        public long cd_time;
        public Data data;
        public int interval;
        public int limit;
        public String message;
        public boolean status;
        public int time;

        public Root() {
        }
    }
}
