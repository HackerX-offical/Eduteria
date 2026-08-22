package com.appnew.android.CreateTest.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TypeTest implements Serializable {
    String name;
    String type;

    public TypeTest(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
