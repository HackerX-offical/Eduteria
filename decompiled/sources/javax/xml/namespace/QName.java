package javax.xml.namespace;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class QName implements Serializable {
    private static final String emptyString = "".intern();
    private String localPart;
    private String namespaceURI;
    private String prefix;

    /* JADX WARN: Illegal instructions before constructor call */
    public QName(String str) {
        String str2 = emptyString;
        this(str2, str, str2);
    }

    public QName(String str, String str2) {
        this(str, str2, emptyString);
    }

    public QName(String str, String str2, String str3) {
        this.namespaceURI = str == null ? emptyString : str.intern();
        if (str2 == null) {
            throw new IllegalArgumentException("invalid QName local part");
        }
        this.localPart = str2.intern();
        if (str3 == null) {
            throw new IllegalArgumentException("invalid QName prefix");
        }
        this.prefix = str3.intern();
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String toString() {
        return this.namespaceURI == emptyString ? this.localPart : new StringBuffer("{").append(this.namespaceURI).append('}').append(this.localPart).toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QName)) {
            return false;
        }
        QName qName = (QName) obj;
        return this.namespaceURI == qName.namespaceURI && this.localPart == qName.localPart;
    }

    public static QName valueOf(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        if (str.charAt(0) == '{') {
            int iIndexOf = str.indexOf(125);
            if (iIndexOf == -1) {
                throw new IllegalArgumentException("invalid QName literal");
            }
            if (iIndexOf == str.length() - 1) {
                throw new IllegalArgumentException("invalid QName literal");
            }
            return new QName(str.substring(1, iIndexOf), str.substring(iIndexOf + 1));
        }
        return new QName(str);
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.namespaceURI = this.namespaceURI.intern();
        this.localPart = this.localPart.intern();
        this.prefix = this.prefix.intern();
    }
}
