package org.xmlpull.mxp1;

import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class MXParserCachingStrings extends MXParser implements Cloneable {
    protected static final int CACHE_LOAD = 77;
    protected static final boolean CACHE_STATISTICS = false;
    protected static final int INITIAL_CAPACITY = 13;
    protected static final boolean TRACE_SIZING = false;
    protected int cacheEntriesCount;
    protected int cacheEntriesThreshold;
    protected int cacheStatCalls;
    protected int cacheStatRehash;
    protected int cacheStatResets;
    protected int cacheStatWalks;
    protected char[][] keys;
    protected String[] values;

    public void finalize() {
    }

    public Object clone() throws CloneNotSupportedException {
        if (this.reader != null && !(this.reader instanceof Cloneable)) {
            throw new CloneNotSupportedException("reader used in parser must implement Cloneable!");
        }
        MXParserCachingStrings mXParserCachingStrings = (MXParserCachingStrings) super.clone();
        if (this.reader != null) {
            try {
                mXParserCachingStrings.reader = (Reader) this.reader.getClass().getMethod("clone", null).invoke(this.reader, null);
            } catch (Exception e2) {
                CloneNotSupportedException cloneNotSupportedException = new CloneNotSupportedException(new StringBuffer("failed to call clone() on reader ").append(this.reader).append(":").append(e2).toString());
                cloneNotSupportedException.initCause(e2);
                throw cloneNotSupportedException;
            }
        }
        char[][] cArr = this.keys;
        if (cArr != null) {
            mXParserCachingStrings.keys = (char[][]) cArr.clone();
        }
        String[] strArr = this.values;
        if (strArr != null) {
            mXParserCachingStrings.values = (String[]) strArr.clone();
        }
        if (this.elRawName != null) {
            mXParserCachingStrings.elRawName = cloneCCArr(this.elRawName);
        }
        if (this.elRawNameEnd != null) {
            mXParserCachingStrings.elRawNameEnd = (int[]) this.elRawNameEnd.clone();
        }
        if (this.elRawNameLine != null) {
            mXParserCachingStrings.elRawNameLine = (int[]) this.elRawNameLine.clone();
        }
        if (this.elName != null) {
            mXParserCachingStrings.elName = (String[]) this.elName.clone();
        }
        if (this.elPrefix != null) {
            mXParserCachingStrings.elPrefix = (String[]) this.elPrefix.clone();
        }
        if (this.elUri != null) {
            mXParserCachingStrings.elUri = (String[]) this.elUri.clone();
        }
        if (this.elNamespaceCount != null) {
            mXParserCachingStrings.elNamespaceCount = (int[]) this.elNamespaceCount.clone();
        }
        if (this.attributeName != null) {
            mXParserCachingStrings.attributeName = (String[]) this.attributeName.clone();
        }
        if (this.attributeNameHash != null) {
            mXParserCachingStrings.attributeNameHash = (int[]) this.attributeNameHash.clone();
        }
        if (this.attributePrefix != null) {
            mXParserCachingStrings.attributePrefix = (String[]) this.attributePrefix.clone();
        }
        if (this.attributeUri != null) {
            mXParserCachingStrings.attributeUri = (String[]) this.attributeUri.clone();
        }
        if (this.attributeValue != null) {
            mXParserCachingStrings.attributeValue = (String[]) this.attributeValue.clone();
        }
        if (this.namespacePrefix != null) {
            mXParserCachingStrings.namespacePrefix = (String[]) this.namespacePrefix.clone();
        }
        if (this.namespacePrefixHash != null) {
            mXParserCachingStrings.namespacePrefixHash = (int[]) this.namespacePrefixHash.clone();
        }
        if (this.namespaceUri != null) {
            mXParserCachingStrings.namespaceUri = (String[]) this.namespaceUri.clone();
        }
        if (this.entityName != null) {
            mXParserCachingStrings.entityName = (String[]) this.entityName.clone();
        }
        if (this.entityNameBuf != null) {
            mXParserCachingStrings.entityNameBuf = cloneCCArr(this.entityNameBuf);
        }
        if (this.entityNameHash != null) {
            mXParserCachingStrings.entityNameHash = (int[]) this.entityNameHash.clone();
        }
        if (this.entityReplacementBuf != null) {
            mXParserCachingStrings.entityReplacementBuf = cloneCCArr(this.entityReplacementBuf);
        }
        if (this.entityReplacement != null) {
            mXParserCachingStrings.entityReplacement = (String[]) this.entityReplacement.clone();
        }
        if (this.buf != null) {
            mXParserCachingStrings.buf = (char[]) this.buf.clone();
        }
        if (this.pc != null) {
            mXParserCachingStrings.pc = (char[]) this.pc.clone();
        }
        if (this.charRefOneCharBuf != null) {
            mXParserCachingStrings.charRefOneCharBuf = (char[]) this.charRefOneCharBuf.clone();
        }
        return mXParserCachingStrings;
    }

    private char[][] cloneCCArr(char[][] cArr) {
        char[][] cArr2 = (char[][]) cArr.clone();
        for (int i = 0; i < cArr2.length; i++) {
            char[] cArr3 = cArr2[i];
            if (cArr3 != null) {
                cArr2[i] = (char[]) cArr3.clone();
            }
        }
        return cArr2;
    }

    public MXParserCachingStrings() {
        this.allStringsInterned = true;
        initStringCache();
    }

    @Override // org.xmlpull.mxp1.MXParser, org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            if (this.eventType != 0) {
                throw new XmlPullParserException("interning names feature can only be changed before parsing", this, null);
            }
            this.allStringsInterned = z;
            if (z || this.keys == null) {
                return;
            }
            resetStringCache();
            return;
        }
        super.setFeature(str, z);
    }

    @Override // org.xmlpull.mxp1.MXParser, org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            return this.allStringsInterned;
        }
        return super.getFeature(str);
    }

    @Override // org.xmlpull.mxp1.MXParser
    protected String newString(char[] cArr, int i, int i2) {
        if (this.allStringsInterned) {
            return newStringIntern(cArr, i, i2);
        }
        return super.newString(cArr, i, i2);
    }

    @Override // org.xmlpull.mxp1.MXParser
    protected String newStringIntern(char[] cArr, int i, int i2) {
        char[] cArr2;
        char[] cArr3;
        int i3;
        int i4;
        if (this.cacheEntriesCount >= this.cacheEntriesThreshold) {
            rehash();
        }
        int iFastHash = MXParser.fastHash(cArr, i, i2) % this.keys.length;
        while (true) {
            cArr2 = this.keys[iFastHash];
            if (cArr2 == null) {
                cArr3 = cArr;
                i3 = i;
                i4 = i2;
                break;
            }
            cArr3 = cArr;
            i3 = i;
            i4 = i2;
            if (keysAreEqual(cArr2, 0, cArr2.length, cArr3, i3, i4)) {
                break;
            }
            iFastHash = (iFastHash + 1) % this.keys.length;
            cArr = cArr3;
            i = i3;
            i2 = i4;
        }
        if (cArr2 != null) {
            return this.values[iFastHash];
        }
        char[] cArr4 = new char[i4];
        System.arraycopy(cArr3, i3, cArr4, 0, i4);
        String strIntern = new String(cArr4).intern();
        this.keys[iFastHash] = cArr4;
        this.values[iFastHash] = strIntern;
        this.cacheEntriesCount++;
        return strIntern;
    }

    protected void initStringCache() {
        if (this.keys == null) {
            this.cacheEntriesThreshold = 10;
            this.keys = new char[13][];
            this.values = new String[13];
            this.cacheEntriesCount = 0;
        }
    }

    @Override // org.xmlpull.mxp1.MXParser
    protected void resetStringCache() {
        initStringCache();
    }

    private void rehash() {
        int length = (this.keys.length * 2) + 1;
        int i = (length * 77) / 100;
        this.cacheEntriesThreshold = i;
        if (i >= length) {
            throw new RuntimeException(new StringBuffer("internal error: threshold must be less than capacity: ").append(length).toString());
        }
        char[][] cArr = new char[length][];
        String[] strArr = new String[length];
        int i2 = 0;
        while (true) {
            char[][] cArr2 = this.keys;
            if (i2 < cArr2.length) {
                char[] cArr3 = cArr2[i2];
                cArr2[i2] = null;
                String[] strArr2 = this.values;
                String str = strArr2[i2];
                strArr2[i2] = null;
                if (cArr3 != null) {
                    int iFastHash = MXParser.fastHash(cArr3, 0, cArr3.length);
                    while (true) {
                        int i3 = iFastHash % length;
                        char[] cArr4 = cArr[i3];
                        if (cArr4 != null) {
                            if (keysAreEqual(cArr4, 0, cArr4.length, cArr3, 0, cArr3.length)) {
                                throw new RuntimeException(new StringBuffer("internal cache error: duplicated keys: ").append(new String(cArr4)).append(" and ").append(new String(cArr3)).toString());
                            }
                            iFastHash = i3 + 1;
                        } else {
                            cArr[i3] = cArr3;
                            strArr[i3] = str;
                            break;
                        }
                    }
                }
                i2++;
            } else {
                this.keys = cArr;
                this.values = strArr;
                return;
            }
        }
    }

    private static final boolean keysAreEqual(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
        if (i2 != i4) {
            return false;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            if (cArr[i + i5] != cArr2[i3 + i5]) {
                return false;
            }
        }
        return true;
    }
}
