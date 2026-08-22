package org.jivesoftware.smackx.bob;

import org.jivesoftware.smack.util.stringencoder.Base64;

/* JADX INFO: loaded from: classes10.dex */
public class BoBData {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] contentBinary;
    private String contentString;
    private final Integer maxAge;
    private final String type;

    private BoBData(String str, Integer num) {
        this.type = str;
        this.maxAge = num;
    }

    public BoBData(String str, byte[] bArr) {
        this(str, bArr, (Integer) null);
    }

    public BoBData(String str, byte[] bArr, Integer num) {
        this(str, num);
        this.contentBinary = bArr;
    }

    public BoBData(String str, String str2) {
        this(str, str2, (Integer) null);
    }

    public BoBData(String str, String str2, Integer num) {
        this(str, num);
        this.contentString = str2;
    }

    public Integer getMaxAge() {
        return this.maxAge;
    }

    public String getType() {
        return this.type;
    }

    private void setContentBinaryIfRequired() {
        if (this.contentBinary == null) {
            this.contentBinary = Base64.decode(this.contentString);
        }
    }

    public byte[] getContent() {
        setContentBinaryIfRequired();
        return (byte[]) this.contentBinary.clone();
    }

    public String getContentBase64Encoded() {
        if (this.contentString == null) {
            this.contentString = Base64.encodeToString(getContent());
        }
        return this.contentString;
    }

    public boolean isOfReasonableSize() {
        setContentBinaryIfRequired();
        return this.contentBinary.length <= 8192;
    }
}
