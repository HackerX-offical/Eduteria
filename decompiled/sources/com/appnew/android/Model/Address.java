package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/appnew/android/Model/Address;", "", "name", "", "address", "state", "city", "mainMobileNumber", "alternateMobileNumber", "pincode", "orderNotes", "district", "stateId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getAddress", "getState", "getCity", "getMainMobileNumber", "getAlternateMobileNumber", "getPincode", "getOrderNotes", "getDistrict", "getStateId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Address {
    public static final int $stable = 0;
    private final String address;
    private final String alternateMobileNumber;
    private final String city;
    private final String district;
    private final String mainMobileNumber;
    private final String name;
    private final String orderNotes;
    private final String pincode;
    private final String state;
    private final String stateId;

    public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = address.name;
        }
        if ((i & 2) != 0) {
            str2 = address.address;
        }
        if ((i & 4) != 0) {
            str3 = address.state;
        }
        if ((i & 8) != 0) {
            str4 = address.city;
        }
        if ((i & 16) != 0) {
            str5 = address.mainMobileNumber;
        }
        if ((i & 32) != 0) {
            str6 = address.alternateMobileNumber;
        }
        if ((i & 64) != 0) {
            str7 = address.pincode;
        }
        if ((i & 128) != 0) {
            str8 = address.orderNotes;
        }
        if ((i & 256) != 0) {
            str9 = address.district;
        }
        if ((i & 512) != 0) {
            str10 = address.stateId;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        return address.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStateId() {
        return this.stateId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMainMobileNumber() {
        return this.mainMobileNumber;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAlternateMobileNumber() {
        return this.alternateMobileNumber;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPincode() {
        return this.pincode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOrderNotes() {
        return this.orderNotes;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDistrict() {
        return this.district;
    }

    public final Address copy(String name, String address, String state, String city, String mainMobileNumber, String alternateMobileNumber, String pincode, String orderNotes, String district, String stateId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(mainMobileNumber, "mainMobileNumber");
        Intrinsics.checkNotNullParameter(alternateMobileNumber, "alternateMobileNumber");
        Intrinsics.checkNotNullParameter(pincode, "pincode");
        Intrinsics.checkNotNullParameter(orderNotes, "orderNotes");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        return new Address(name, address, state, city, mainMobileNumber, alternateMobileNumber, pincode, orderNotes, district, stateId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address address = (Address) other;
        return Intrinsics.areEqual(this.name, address.name) && Intrinsics.areEqual(this.address, address.address) && Intrinsics.areEqual(this.state, address.state) && Intrinsics.areEqual(this.city, address.city) && Intrinsics.areEqual(this.mainMobileNumber, address.mainMobileNumber) && Intrinsics.areEqual(this.alternateMobileNumber, address.alternateMobileNumber) && Intrinsics.areEqual(this.pincode, address.pincode) && Intrinsics.areEqual(this.orderNotes, address.orderNotes) && Intrinsics.areEqual(this.district, address.district) && Intrinsics.areEqual(this.stateId, address.stateId);
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + this.address.hashCode()) * 31) + this.state.hashCode()) * 31) + this.city.hashCode()) * 31) + this.mainMobileNumber.hashCode()) * 31) + this.alternateMobileNumber.hashCode()) * 31) + this.pincode.hashCode()) * 31) + this.orderNotes.hashCode()) * 31) + this.district.hashCode()) * 31) + this.stateId.hashCode();
    }

    public String toString() {
        return "Address(name=" + this.name + ", address=" + this.address + ", state=" + this.state + ", city=" + this.city + ", mainMobileNumber=" + this.mainMobileNumber + ", alternateMobileNumber=" + this.alternateMobileNumber + ", pincode=" + this.pincode + ", orderNotes=" + this.orderNotes + ", district=" + this.district + ", stateId=" + this.stateId + ")";
    }

    public Address(String name, String address, String state, String city, String mainMobileNumber, String alternateMobileNumber, String pincode, String orderNotes, String district, String stateId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(mainMobileNumber, "mainMobileNumber");
        Intrinsics.checkNotNullParameter(alternateMobileNumber, "alternateMobileNumber");
        Intrinsics.checkNotNullParameter(pincode, "pincode");
        Intrinsics.checkNotNullParameter(orderNotes, "orderNotes");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        this.name = name;
        this.address = address;
        this.state = state;
        this.city = city;
        this.mainMobileNumber = mainMobileNumber;
        this.alternateMobileNumber = alternateMobileNumber;
        this.pincode = pincode;
        this.orderNotes = orderNotes;
        this.district = district;
        this.stateId = stateId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getState() {
        return this.state;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getMainMobileNumber() {
        return this.mainMobileNumber;
    }

    public final String getAlternateMobileNumber() {
        return this.alternateMobileNumber;
    }

    public final String getPincode() {
        return this.pincode;
    }

    public final String getOrderNotes() {
        return this.orderNotes;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getStateId() {
        return this.stateId;
    }
}
