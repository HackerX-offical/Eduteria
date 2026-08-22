package info.mqtt.android.service;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: compiled from: ParcelableMqttMessage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Linfo/mqtt/android/service/ParcelableMqttMessage;", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "Landroid/os/Parcelable;", "original", "<init>", "(Lorg/eclipse/paho/client/mqttv3/MqttMessage;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "messageId", "", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParcelableMqttMessage extends MqttMessage implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String messageId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParcelableMqttMessage(MqttMessage original) {
        super(original.getPayload());
        Intrinsics.checkNotNullParameter(original, "original");
        setQos(original.getQos());
        setRetained(original.isRetained());
        setDuplicate(original.isDuplicate());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParcelableMqttMessage(Parcel parcel) {
        super(parcel.createByteArray());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        setQos(parcel.readInt());
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        Intrinsics.checkNotNull(zArrCreateBooleanArray);
        setRetained(zArrCreateBooleanArray[0]);
        setDuplicate(zArrCreateBooleanArray[1]);
        this.messageId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByteArray(getPayload());
        parcel.writeInt(getQos());
        parcel.writeBooleanArray(new boolean[]{isRetained(), isDuplicate()});
        parcel.writeString(this.messageId);
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.ParcelableMqttMessage$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ParcelableMqttMessage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Linfo/mqtt/android/service/ParcelableMqttMessage$CREATOR;", "Landroid/os/Parcelable$Creator;", "Linfo/mqtt/android/service/ParcelableMqttMessage;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Linfo/mqtt/android/service/ParcelableMqttMessage;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<ParcelableMqttMessage> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMqttMessage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ParcelableMqttMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMqttMessage[] newArray(int size) {
            return new ParcelableMqttMessage[size];
        }
    }
}
