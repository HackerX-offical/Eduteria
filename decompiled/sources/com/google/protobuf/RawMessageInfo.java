package com.google.protobuf;

/* JADX INFO: loaded from: classes9.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private final MessageLite defaultInstance;
    private final int flags;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private final String f650info;
    private final Object[] objects;

    RawMessageInfo(MessageLite defaultInstance, String info2, Object[] objects) {
        this.defaultInstance = defaultInstance;
        this.f650info = info2;
        this.objects = objects;
        char cCharAt = info2.charAt(0);
        if (cCharAt < 55296) {
            this.flags = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = info2.charAt(i3);
            if (cCharAt2 < 55296) {
                this.flags = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    String getStringInfo() {
        return this.f650info;
    }

    Object[] getObjects() {
        return this.objects;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return (this.flags & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return (this.flags & 2) == 2;
    }
}
