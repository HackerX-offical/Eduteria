package com.clevertap.android.sdk.network;

import com.clevertap.android.sdk.events.EventGroup;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NetworkHeadersListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/network/EndpointId;", "", "identifier", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "ENDPOINT_SPIKY", "ENDPOINT_A1", "ENDPOINT_HELLO", "ENDPOINT_DEFINE_VARS", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EndpointId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EndpointId[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String identifier;
    public static final EndpointId ENDPOINT_SPIKY = new EndpointId("ENDPOINT_SPIKY", 0, "-spiky");
    public static final EndpointId ENDPOINT_A1 = new EndpointId("ENDPOINT_A1", 1, "/a1");
    public static final EndpointId ENDPOINT_HELLO = new EndpointId("ENDPOINT_HELLO", 2, "/hello");
    public static final EndpointId ENDPOINT_DEFINE_VARS = new EndpointId("ENDPOINT_DEFINE_VARS", 3, "/defineVars");

    private static final /* synthetic */ EndpointId[] $values() {
        return new EndpointId[]{ENDPOINT_SPIKY, ENDPOINT_A1, ENDPOINT_HELLO, ENDPOINT_DEFINE_VARS};
    }

    @JvmStatic
    public static final EndpointId fromEventGroup(EventGroup eventGroup) {
        return INSTANCE.fromEventGroup(eventGroup);
    }

    @JvmStatic
    public static final EndpointId fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<EndpointId> getEntries() {
        return $ENTRIES;
    }

    private EndpointId(String str, int i, String str2) {
        this.identifier = str2;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    static {
        EndpointId[] endpointIdArr$values = $values();
        $VALUES = endpointIdArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(endpointIdArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: NetworkHeadersListener.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/clevertap/android/sdk/network/EndpointId$Companion;", "", "<init>", "()V", "fromString", "Lcom/clevertap/android/sdk/network/EndpointId;", "identifier", "", "fromEventGroup", "eventGroup", "Lcom/clevertap/android/sdk/events/EventGroup;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: NetworkHeadersListener.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[EventGroup.values().length];
                try {
                    iArr[EventGroup.PUSH_NOTIFICATION_VIEWED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EventGroup.REGULAR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EventGroup.VARIABLES.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final EndpointId fromString(String identifier) {
            EndpointId endpointId;
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            EndpointId[] endpointIdArrValues = EndpointId.values();
            int length = endpointIdArrValues.length;
            int i = 0;
            while (true) {
                endpointId = null;
                if (i >= length) {
                    break;
                }
                EndpointId endpointId2 = endpointIdArrValues[i];
                if (StringsKt.contains$default((CharSequence) identifier, (CharSequence) endpointId2.getIdentifier(), false, 2, (Object) null)) {
                    endpointId = endpointId2;
                    break;
                }
                i++;
            }
            return endpointId == null ? EndpointId.ENDPOINT_A1 : endpointId;
        }

        @JvmStatic
        public final EndpointId fromEventGroup(EventGroup eventGroup) {
            Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
            int i = WhenMappings.$EnumSwitchMapping$0[eventGroup.ordinal()];
            if (i == 1) {
                return EndpointId.ENDPOINT_SPIKY;
            }
            if (i == 2) {
                return EndpointId.ENDPOINT_A1;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return EndpointId.ENDPOINT_DEFINE_VARS;
        }
    }

    public static EndpointId valueOf(String str) {
        return (EndpointId) Enum.valueOf(EndpointId.class, str);
    }

    public static EndpointId[] values() {
        return (EndpointId[]) $VALUES.clone();
    }
}
