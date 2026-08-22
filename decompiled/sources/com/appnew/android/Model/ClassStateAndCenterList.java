package com.appnew.android.Model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ClassStateAndCenterList {
    ArrayList<CityAndCenter> city;
    String id;
    String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CityAndCenter> getCity() {
        return this.city;
    }

    public void setCity(ArrayList<CityAndCenter> city) {
        this.city = city;
    }

    public String toString() {
        return "ClassStateAndCenterList{id='" + this.id + "', name='" + this.name + "', city=" + this.city + '}';
    }

    public class CityAndCenter {
        ArrayList<CentersData> centers;
        String id;
        String name;

        public CityAndCenter() {
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<CentersData> getCenters() {
            return this.centers;
        }

        public void setCenters(ArrayList<CentersData> centers) {
            this.centers = centers;
        }

        public String toString() {
            return "CityAndCenter{id='" + this.id + "', name='" + this.name + "', centers=" + this.centers + '}';
        }
    }
}
