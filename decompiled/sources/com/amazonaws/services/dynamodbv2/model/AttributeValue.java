package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AttributeValue implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f303b;
    private Boolean bOOL;
    private List<ByteBuffer> bS;
    private List<AttributeValue> l;
    private Map<String, AttributeValue> m;
    private String n;
    private List<String> nS;
    private Boolean nULL;
    private String s;
    private List<String> sS;

    public AttributeValue() {
    }

    public AttributeValue(String str) {
        setS(str);
    }

    public AttributeValue(List<String> list) {
        setSS(list);
    }

    public String getS() {
        return this.s;
    }

    public void setS(String str) {
        this.s = str;
    }

    public AttributeValue withS(String str) {
        this.s = str;
        return this;
    }

    public String getN() {
        return this.n;
    }

    public void setN(String str) {
        this.n = str;
    }

    public AttributeValue withN(String str) {
        this.n = str;
        return this;
    }

    public ByteBuffer getB() {
        return this.f303b;
    }

    public void setB(ByteBuffer byteBuffer) {
        this.f303b = byteBuffer;
    }

    public AttributeValue withB(ByteBuffer byteBuffer) {
        this.f303b = byteBuffer;
        return this;
    }

    public List<String> getSS() {
        return this.sS;
    }

    public void setSS(Collection<String> collection) {
        if (collection == null) {
            this.sS = null;
        } else {
            this.sS = new ArrayList(collection);
        }
    }

    public AttributeValue withSS(String... strArr) {
        if (getSS() == null) {
            this.sS = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.sS.add(str);
        }
        return this;
    }

    public AttributeValue withSS(Collection<String> collection) {
        setSS(collection);
        return this;
    }

    public List<String> getNS() {
        return this.nS;
    }

    public void setNS(Collection<String> collection) {
        if (collection == null) {
            this.nS = null;
        } else {
            this.nS = new ArrayList(collection);
        }
    }

    public AttributeValue withNS(String... strArr) {
        if (getNS() == null) {
            this.nS = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.nS.add(str);
        }
        return this;
    }

    public AttributeValue withNS(Collection<String> collection) {
        setNS(collection);
        return this;
    }

    public List<ByteBuffer> getBS() {
        return this.bS;
    }

    public void setBS(Collection<ByteBuffer> collection) {
        if (collection == null) {
            this.bS = null;
        } else {
            this.bS = new ArrayList(collection);
        }
    }

    public AttributeValue withBS(ByteBuffer... byteBufferArr) {
        if (getBS() == null) {
            this.bS = new ArrayList(byteBufferArr.length);
        }
        for (ByteBuffer byteBuffer : byteBufferArr) {
            this.bS.add(byteBuffer);
        }
        return this;
    }

    public AttributeValue withBS(Collection<ByteBuffer> collection) {
        setBS(collection);
        return this;
    }

    public Map<String, AttributeValue> getM() {
        return this.m;
    }

    public void setM(Map<String, AttributeValue> map) {
        this.m = map;
    }

    public AttributeValue withM(Map<String, AttributeValue> map) {
        this.m = map;
        return this;
    }

    public AttributeValue addMEntry(String str, AttributeValue attributeValue) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        if (this.m.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.m.put(str, attributeValue);
        return this;
    }

    public AttributeValue clearMEntries() {
        this.m = null;
        return this;
    }

    public List<AttributeValue> getL() {
        return this.l;
    }

    public void setL(Collection<AttributeValue> collection) {
        if (collection == null) {
            this.l = null;
        } else {
            this.l = new ArrayList(collection);
        }
    }

    public AttributeValue withL(AttributeValue... attributeValueArr) {
        if (getL() == null) {
            this.l = new ArrayList(attributeValueArr.length);
        }
        for (AttributeValue attributeValue : attributeValueArr) {
            this.l.add(attributeValue);
        }
        return this;
    }

    public AttributeValue withL(Collection<AttributeValue> collection) {
        setL(collection);
        return this;
    }

    public Boolean isNULL() {
        return this.nULL;
    }

    public Boolean getNULL() {
        return this.nULL;
    }

    public void setNULL(Boolean bool) {
        this.nULL = bool;
    }

    public AttributeValue withNULL(Boolean bool) {
        this.nULL = bool;
        return this;
    }

    public Boolean isBOOL() {
        return this.bOOL;
    }

    public Boolean getBOOL() {
        return this.bOOL;
    }

    public void setBOOL(Boolean bool) {
        this.bOOL = bool;
    }

    public AttributeValue withBOOL(Boolean bool) {
        this.bOOL = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getS() != null) {
            sb.append("S: " + getS() + Constants.SEPARATOR_COMMA);
        }
        if (getN() != null) {
            sb.append("N: " + getN() + Constants.SEPARATOR_COMMA);
        }
        if (getB() != null) {
            sb.append("B: " + getB() + Constants.SEPARATOR_COMMA);
        }
        if (getSS() != null) {
            sb.append("SS: " + getSS() + Constants.SEPARATOR_COMMA);
        }
        if (getNS() != null) {
            sb.append("NS: " + getNS() + Constants.SEPARATOR_COMMA);
        }
        if (getBS() != null) {
            sb.append("BS: " + getBS() + Constants.SEPARATOR_COMMA);
        }
        if (getM() != null) {
            sb.append("M: " + getM() + Constants.SEPARATOR_COMMA);
        }
        if (getL() != null) {
            sb.append("L: " + getL() + Constants.SEPARATOR_COMMA);
        }
        if (getNULL() != null) {
            sb.append("NULL: " + getNULL() + Constants.SEPARATOR_COMMA);
        }
        if (getBOOL() != null) {
            sb.append("BOOL: " + getBOOL());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((getS() == null ? 0 : getS().hashCode()) + 31) * 31) + (getN() == null ? 0 : getN().hashCode())) * 31) + (getB() == null ? 0 : getB().hashCode())) * 31) + (getSS() == null ? 0 : getSS().hashCode())) * 31) + (getNS() == null ? 0 : getNS().hashCode())) * 31) + (getBS() == null ? 0 : getBS().hashCode())) * 31) + (getM() == null ? 0 : getM().hashCode())) * 31) + (getL() == null ? 0 : getL().hashCode())) * 31) + (getNULL() == null ? 0 : getNULL().hashCode())) * 31) + (getBOOL() != null ? getBOOL().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttributeValue)) {
            return false;
        }
        AttributeValue attributeValue = (AttributeValue) obj;
        if ((attributeValue.getS() == null) ^ (getS() == null)) {
            return false;
        }
        if (attributeValue.getS() != null && !attributeValue.getS().equals(getS())) {
            return false;
        }
        if ((attributeValue.getN() == null) ^ (getN() == null)) {
            return false;
        }
        if (attributeValue.getN() != null && !attributeValue.getN().equals(getN())) {
            return false;
        }
        if ((attributeValue.getB() == null) ^ (getB() == null)) {
            return false;
        }
        if (attributeValue.getB() != null && !attributeValue.getB().equals(getB())) {
            return false;
        }
        if ((attributeValue.getSS() == null) ^ (getSS() == null)) {
            return false;
        }
        if (attributeValue.getSS() != null && !attributeValue.getSS().equals(getSS())) {
            return false;
        }
        if ((attributeValue.getNS() == null) ^ (getNS() == null)) {
            return false;
        }
        if (attributeValue.getNS() != null && !attributeValue.getNS().equals(getNS())) {
            return false;
        }
        if ((attributeValue.getBS() == null) ^ (getBS() == null)) {
            return false;
        }
        if (attributeValue.getBS() != null && !attributeValue.getBS().equals(getBS())) {
            return false;
        }
        if ((attributeValue.getM() == null) ^ (getM() == null)) {
            return false;
        }
        if (attributeValue.getM() != null && !attributeValue.getM().equals(getM())) {
            return false;
        }
        if ((attributeValue.getL() == null) ^ (getL() == null)) {
            return false;
        }
        if (attributeValue.getL() != null && !attributeValue.getL().equals(getL())) {
            return false;
        }
        if ((attributeValue.getNULL() == null) ^ (getNULL() == null)) {
            return false;
        }
        if (attributeValue.getNULL() != null && !attributeValue.getNULL().equals(getNULL())) {
            return false;
        }
        if ((attributeValue.getBOOL() == null) ^ (getBOOL() == null)) {
            return false;
        }
        return attributeValue.getBOOL() == null || attributeValue.getBOOL().equals(getBOOL());
    }
}
