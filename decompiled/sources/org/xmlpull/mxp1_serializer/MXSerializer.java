package org.xmlpull.mxp1_serializer;

import com.amazonaws.services.s3.internal.Constants;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes10.dex */
public class MXSerializer implements XmlSerializer {
    private static final int BUF_LEN;
    protected static final String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
    private static final boolean TRACE_ESCAPING = false;
    private static final boolean TRACE_SIZING = false;
    protected static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    protected static final String XML_URI = "http://www.w3.org/XML/1998/namespace";
    protected static final String[] precomputedPrefixes;
    protected boolean attributeUseApostrophe;
    protected int autoDeclaredPrefixes;
    protected boolean doIndent;
    protected String[] elName;
    protected String[] elNamespace;
    protected int[] elNamespaceCount;
    protected String[] elPrefix;
    protected boolean finished;
    protected char[] indentationBuf;
    protected int indentationJump;
    protected String location;
    protected int maxIndentLevel;
    protected boolean namesInterned;
    protected String[] namespacePrefix;
    protected String[] namespaceUri;
    protected int offsetNewLine;
    protected Writer out;
    protected boolean pastRoot;
    protected boolean seenBracket;
    protected boolean seenBracketBracket;
    protected boolean seenTag;
    protected boolean setPrefixCalled;
    protected boolean startTagIncomplete;
    protected boolean writeIndentation;
    protected boolean writeLineSepartor;
    protected final String FEATURE_SERIALIZER_ATTVALUE_USE_APOSTROPHE = "http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe";
    protected final String FEATURE_NAMES_INTERNED = "http://xmlpull.org/v1/doc/features.html#names-interned";
    protected final String PROPERTY_SERIALIZER_INDENTATION = "http://xmlpull.org/v1/doc/properties.html#serializer-indentation";
    protected final String PROPERTY_SERIALIZER_LINE_SEPARATOR = "http://xmlpull.org/v1/doc/properties.html#serializer-line-separator";
    protected String indentationString = null;
    protected String lineSeparator = "\n";
    protected int depth = 0;
    protected int namespaceEnd = 0;
    protected char[] buf = new char[BUF_LEN];
    private boolean checkNamesInterned = false;

    public MXSerializer() {
        String[] strArr = new String[2];
        this.elNamespace = strArr;
        this.elName = new String[strArr.length];
        this.elPrefix = new String[strArr.length];
        this.elNamespaceCount = new int[strArr.length];
        String[] strArr2 = new String[8];
        this.namespacePrefix = strArr2;
        this.namespaceUri = new String[strArr2.length];
    }

    static {
        BUF_LEN = Runtime.getRuntime().freeMemory() > 1000000 ? 8192 : 256;
        precomputedPrefixes = new String[32];
        int i = 0;
        while (true) {
            String[] strArr = precomputedPrefixes;
            if (i >= strArr.length) {
                return;
            }
            strArr[i] = new StringBuffer(CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY).append(i).toString().intern();
            i++;
        }
    }

    private void checkInterning(String str) {
        if (this.namesInterned && str != str.intern()) {
            throw new IllegalArgumentException("all names passed as arguments must be internedwhen NAMES INTERNED feature is enabled");
        }
    }

    protected void reset() {
        this.location = null;
        this.out = null;
        this.autoDeclaredPrefixes = 0;
        this.depth = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.elNamespaceCount;
            if (i < iArr.length) {
                this.elName[i] = null;
                this.elPrefix[i] = null;
                this.elNamespace[i] = null;
                iArr[i] = 2;
                i++;
            } else {
                this.namespaceEnd = 0;
                String[] strArr = this.namespacePrefix;
                strArr[0] = "xmlns";
                String[] strArr2 = this.namespaceUri;
                strArr2[0] = XMLNS_URI;
                this.namespaceEnd = 1;
                strArr[1] = AbstractHttpOverXmpp.Xml.ELEMENT;
                strArr2[1] = XML_URI;
                this.namespaceEnd = 1 + 1;
                this.finished = false;
                this.pastRoot = false;
                this.setPrefixCalled = false;
                this.startTagIncomplete = false;
                this.seenTag = false;
                this.seenBracket = false;
                this.seenBracketBracket = false;
                return;
            }
        }
    }

    protected void ensureElementsCapacity() {
        String[] strArr = this.elName;
        int length = strArr.length;
        int i = this.depth;
        int i2 = (i >= 7 ? i * 2 : 8) + 2;
        boolean z = length > 0;
        String[] strArr2 = new String[i2];
        if (z) {
            System.arraycopy(strArr, 0, strArr2, 0, length);
        }
        this.elName = strArr2;
        String[] strArr3 = new String[i2];
        if (z) {
            System.arraycopy(this.elPrefix, 0, strArr3, 0, length);
        }
        this.elPrefix = strArr3;
        String[] strArr4 = new String[i2];
        if (z) {
            System.arraycopy(this.elNamespace, 0, strArr4, 0, length);
        }
        this.elNamespace = strArr4;
        int[] iArr = new int[i2];
        if (z) {
            System.arraycopy(this.elNamespaceCount, 0, iArr, 0, length);
        } else {
            iArr[0] = 0;
        }
        this.elNamespaceCount = iArr;
    }

    protected void ensureNamespacesCapacity() {
        int i = this.namespaceEnd;
        int i2 = i > 7 ? i * 2 : 8;
        String[] strArr = new String[i2];
        String[] strArr2 = new String[i2];
        String[] strArr3 = this.namespacePrefix;
        if (strArr3 != null) {
            System.arraycopy(strArr3, 0, strArr, 0, i);
            System.arraycopy(this.namespaceUri, 0, strArr2, 0, this.namespaceEnd);
        }
        this.namespacePrefix = strArr;
        this.namespaceUri = strArr2;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) throws IllegalStateException, IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("feature name can not be null");
        }
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            this.namesInterned = z;
        } else {
            if ("http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe".equals(str)) {
                this.attributeUseApostrophe = z;
                return;
            }
            throw new IllegalStateException(new StringBuffer("unsupported feature ").append(str).toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("feature name can not be null");
        }
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            return this.namesInterned;
        }
        if ("http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe".equals(str)) {
            return this.attributeUseApostrophe;
        }
        return false;
    }

    protected void rebuildIndentationBuf() {
        int length;
        int i;
        if (this.doIndent) {
            this.offsetNewLine = 0;
            if (this.writeLineSepartor) {
                length = this.lineSeparator.length();
                this.offsetNewLine = length;
            } else {
                length = 0;
            }
            this.maxIndentLevel = 0;
            if (this.writeIndentation) {
                int length2 = this.indentationString.length();
                this.indentationJump = length2;
                int i2 = 65 / length2;
                this.maxIndentLevel = i2;
                length += i2 * length2;
            }
            char[] cArr = this.indentationBuf;
            if (cArr == null || cArr.length < length) {
                this.indentationBuf = new char[length + 8];
            }
            if (this.writeLineSepartor) {
                int i3 = 0;
                i = 0;
                while (i3 < this.lineSeparator.length()) {
                    this.indentationBuf[i] = this.lineSeparator.charAt(i3);
                    i3++;
                    i++;
                }
            } else {
                i = 0;
            }
            if (this.writeIndentation) {
                for (int i4 = 0; i4 < this.maxIndentLevel; i4++) {
                    int i5 = 0;
                    while (i5 < this.indentationString.length()) {
                        this.indentationBuf[i] = this.indentationString.charAt(i5);
                        i5++;
                        i++;
                    }
                }
            }
        }
    }

    protected void writeIndent() throws IOException {
        int i = this.writeLineSepartor ? 0 : this.offsetNewLine;
        int i2 = this.depth;
        int i3 = this.maxIndentLevel;
        if (i2 > i3) {
            i2 = i3;
        }
        this.out.write(this.indentationBuf, i, ((i2 - 1) * this.indentationJump) + this.offsetNewLine);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) throws IllegalStateException, IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("property name can not be null");
        }
        if ("http://xmlpull.org/v1/doc/properties.html#serializer-indentation".equals(str)) {
            this.indentationString = (String) obj;
        } else if ("http://xmlpull.org/v1/doc/properties.html#serializer-line-separator".equals(str)) {
            this.lineSeparator = (String) obj;
        } else if (PROPERTY_LOCATION.equals(str)) {
            this.location = (String) obj;
        } else {
            throw new IllegalStateException(new StringBuffer("unsupported property ").append(str).toString());
        }
        String str2 = this.lineSeparator;
        boolean z = true;
        this.writeLineSepartor = str2 != null && str2.length() > 0;
        String str3 = this.indentationString;
        boolean z2 = str3 != null && str3.length() > 0;
        this.writeIndentation = z2;
        if (this.indentationString == null || (!this.writeLineSepartor && !z2)) {
            z = false;
        }
        this.doIndent = z;
        rebuildIndentationBuf();
        this.seenTag = false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("property name can not be null");
        }
        if ("http://xmlpull.org/v1/doc/properties.html#serializer-indentation".equals(str)) {
            return this.indentationString;
        }
        if ("http://xmlpull.org/v1/doc/properties.html#serializer-line-separator".equals(str)) {
            return this.lineSeparator;
        }
        if (PROPERTY_LOCATION.equals(str)) {
            return this.location;
        }
        return null;
    }

    private String getLocation() {
        return this.location != null ? new StringBuffer(" @").append(this.location).toString() : "";
    }

    public Writer getWriter() {
        return this.out;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        reset();
        this.out = writer;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("output stream can not be null");
        }
        reset();
        if (str != null) {
            this.out = new OutputStreamWriter(outputStream, str);
        } else {
            this.out = new OutputStreamWriter(outputStream);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        if (this.attributeUseApostrophe) {
            this.out.write("<?xml version='1.0'");
        } else {
            this.out.write("<?xml version=\"1.0\"");
        }
        if (str != null) {
            this.out.write(" encoding=");
            this.out.write(this.attributeUseApostrophe ? 39 : 34);
            this.out.write(str);
            this.out.write(this.attributeUseApostrophe ? 39 : 34);
        }
        if (bool != null) {
            this.out.write(" standalone=");
            this.out.write(this.attributeUseApostrophe ? 39 : 34);
            if (bool.booleanValue()) {
                this.out.write("yes");
            } else {
                this.out.write("no");
            }
            this.out.write(this.attributeUseApostrophe ? 39 : 34);
        }
        this.out.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        while (true) {
            int i = this.depth;
            if (i > 0) {
                endTag(this.elNamespace[i], this.elName[i]);
            } else {
                this.startTagIncomplete = true;
                this.pastRoot = true;
                this.finished = true;
                this.out.flush();
                return;
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException {
        if (this.startTagIncomplete) {
            closeStartTag();
        }
        if (str == null) {
            str = "";
        }
        if (!this.namesInterned) {
            str = str.intern();
        } else if (this.checkNamesInterned) {
            checkInterning(str);
        } else if (str == null) {
            throw new IllegalArgumentException(new StringBuffer("prefix must be not null").append(getLocation()).toString());
        }
        for (int i = this.elNamespaceCount[this.depth]; i < this.namespaceEnd; i++) {
            if (str == this.namespacePrefix[i]) {
                throw new IllegalStateException(new StringBuffer("duplicated prefix ").append(printable(str)).append(getLocation()).toString());
            }
        }
        if (!this.namesInterned) {
            str2 = str2.intern();
        } else if (this.checkNamesInterned) {
            checkInterning(str2);
        } else if (str2 == null) {
            throw new IllegalArgumentException(new StringBuffer("namespace must be not null").append(getLocation()).toString());
        }
        if (this.namespaceEnd >= this.namespacePrefix.length) {
            ensureNamespacesCapacity();
        }
        String[] strArr = this.namespacePrefix;
        int i2 = this.namespaceEnd;
        strArr[i2] = str;
        this.namespaceUri[i2] = str2;
        this.namespaceEnd = i2 + 1;
        this.setPrefixCalled = true;
    }

    protected String lookupOrDeclarePrefix(String str) {
        return getPrefix(str, true);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        return getPrefix(str, z, false);
    }

    protected String getPrefix(String str, boolean z, boolean z2) {
        if (!this.namesInterned) {
            str = str.intern();
        } else if (this.checkNamesInterned) {
            checkInterning(str);
        }
        if (str == null) {
            throw new IllegalArgumentException(new StringBuffer("namespace must be not null").append(getLocation()).toString());
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException(new StringBuffer("default namespace cannot have prefix").append(getLocation()).toString());
        }
        for (int i = this.namespaceEnd - 1; i >= 0; i--) {
            if (str == this.namespaceUri[i]) {
                String str2 = this.namespacePrefix[i];
                if (!z2 || str2.length() != 0) {
                    for (int i2 = this.namespaceEnd - 1; i2 > i; i2--) {
                        String str3 = this.namespacePrefix[i2];
                    }
                    return str2;
                }
            }
        }
        if (z) {
            return generatePrefix(str);
        }
        return null;
    }

    private String generatePrefix(String str) {
        int i = this.autoDeclaredPrefixes + 1;
        this.autoDeclaredPrefixes = i;
        String[] strArr = precomputedPrefixes;
        String strIntern = i < strArr.length ? strArr[i] : new StringBuffer(CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY).append(this.autoDeclaredPrefixes).toString().intern();
        for (int i2 = this.namespaceEnd - 1; i2 >= 0; i2--) {
            String str2 = this.namespacePrefix[i2];
        }
        if (this.namespaceEnd >= this.namespacePrefix.length) {
            ensureNamespacesCapacity();
        }
        String[] strArr2 = this.namespacePrefix;
        int i3 = this.namespaceEnd;
        strArr2[i3] = strIntern;
        this.namespaceUri[i3] = str;
        this.namespaceEnd = i3 + 1;
        return strIntern;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        return this.elNamespace[this.depth];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        return this.elName[this.depth];
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ef  */
    @Override // org.xmlpull.v1.XmlSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.xmlpull.v1.XmlSerializer startTag(java.lang.String r7, java.lang.String r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.mxp1_serializer.MXSerializer.startTag(java.lang.String, java.lang.String):org.xmlpull.v1.XmlSerializer");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        if (!this.startTagIncomplete) {
            throw new IllegalArgumentException(new StringBuffer("startTag() must be called before attribute()").append(getLocation()).toString());
        }
        this.out.write(32);
        if (str != null && str.length() > 0) {
            if (!this.namesInterned) {
                str = str.intern();
            } else if (this.checkNamesInterned) {
                checkInterning(str);
            }
            String prefix = getPrefix(str, false, true);
            if (prefix == null) {
                prefix = generatePrefix(str);
            }
            this.out.write(prefix);
            this.out.write(58);
        }
        this.out.write(str2);
        this.out.write(61);
        this.out.write(this.attributeUseApostrophe ? 39 : 34);
        writeAttributeValue(str3, this.out);
        this.out.write(this.attributeUseApostrophe ? 39 : 34);
        return this;
    }

    protected void closeStartTag() throws IOException {
        if (this.finished) {
            throw new IllegalArgumentException(new StringBuffer("trying to write past already finished output").append(getLocation()).toString());
        }
        if (this.seenBracket) {
            this.seenBracketBracket = false;
            this.seenBracket = false;
        }
        boolean z = this.startTagIncomplete;
        if (z || this.setPrefixCalled) {
            if (this.setPrefixCalled) {
                throw new IllegalArgumentException(new StringBuffer("startTag() must be called immediately after setPrefix()").append(getLocation()).toString());
            }
            if (!z) {
                throw new IllegalArgumentException(new StringBuffer("trying to close start tag that is not opened").append(getLocation()).toString());
            }
            writeNamespaceDeclarations();
            this.out.write(62);
            this.elNamespaceCount[this.depth] = this.namespaceEnd;
            this.startTagIncomplete = false;
        }
    }

    private void writeNamespaceDeclarations() throws IOException {
        for (int i = this.elNamespaceCount[this.depth - 1]; i < this.namespaceEnd; i++) {
            if (this.doIndent && this.namespaceUri[i].length() > 40) {
                writeIndent();
                this.out.write(" ");
            }
            if (this.namespacePrefix[i] != "") {
                this.out.write(" xmlns:");
                this.out.write(this.namespacePrefix[i]);
                this.out.write(61);
            } else {
                this.out.write(" xmlns=");
            }
            int i2 = 39;
            this.out.write(this.attributeUseApostrophe ? 39 : 34);
            writeAttributeValue(this.namespaceUri[i], this.out);
            Writer writer = this.out;
            if (!this.attributeUseApostrophe) {
                i2 = 34;
            }
            writer.write(i2);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        this.seenBracketBracket = false;
        this.seenBracket = false;
        if (str != null) {
            if (!this.namesInterned) {
                str = str.intern();
            } else if (this.checkNamesInterned) {
                checkInterning(str);
            }
        }
        if (str != this.elNamespace[this.depth]) {
            throw new IllegalArgumentException(new StringBuffer("expected namespace ").append(printable(this.elNamespace[this.depth])).append(" and not ").append(printable(str)).append(getLocation()).toString());
        }
        if (str2 == null) {
            throw new IllegalArgumentException(new StringBuffer("end tag name can not be null").append(getLocation()).toString());
        }
        if (this.checkNamesInterned && this.namesInterned) {
            checkInterning(str2);
        }
        String str3 = this.elName[this.depth];
        if ((!this.namesInterned && !str2.equals(str3)) || (this.namesInterned && str2 != str3)) {
            throw new IllegalArgumentException(new StringBuffer("expected element name ").append(printable(this.elName[this.depth])).append(" and not ").append(printable(str2)).append(getLocation()).toString());
        }
        if (this.startTagIncomplete) {
            writeNamespaceDeclarations();
            this.out.write(" />");
            this.depth--;
        } else {
            if (this.doIndent && this.seenTag) {
                writeIndent();
            }
            this.out.write("</");
            String str4 = this.elPrefix[this.depth];
            if (str4.length() > 0) {
                this.out.write(str4);
                this.out.write(58);
            }
            this.out.write(str2);
            this.out.write(62);
            this.depth--;
        }
        this.namespaceEnd = this.elNamespaceCount[this.depth];
        this.startTagIncomplete = false;
        this.seenTag = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        writeElementContent(str, this.out);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        writeElementContent(cArr, i, i2, this.out);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled || this.seenBracket) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<![CDATA[");
        this.out.write(str);
        this.out.write("]]>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled || this.seenBracket) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write(38);
        this.out.write(str);
        this.out.write(59);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled || this.seenBracket) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<?");
        this.out.write(str);
        this.out.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled || this.seenBracket) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<!--");
        this.out.write(str);
        this.out.write("-->");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled || this.seenBracket) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<!DOCTYPE");
        this.out.write(str);
        this.out.write(">");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled || this.seenBracket) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException(new StringBuffer("empty string is not allowed for ignorable whitespace").append(getLocation()).toString());
        }
        this.out.write(str);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        if (!this.finished && this.startTagIncomplete) {
            closeStartTag();
        }
        this.out.flush();
    }

    protected void writeAttributeValue(String str, Writer writer) throws IOException {
        boolean z = this.attributeUseApostrophe;
        char c2 = z ? '\'' : '\"';
        String str2 = z ? StringUtils.APOS_ENCODE : StringUtils.QUOTE_ENCODE;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '&') {
                if (i2 > i) {
                    writer.write(str.substring(i, i2));
                }
                writer.write(StringUtils.AMP_ENCODE);
                i = i2 + 1;
            }
            if (cCharAt == '<') {
                if (i2 > i) {
                    writer.write(str.substring(i, i2));
                }
                writer.write(StringUtils.LT_ENCODE);
            } else if (cCharAt == c2) {
                if (i2 > i) {
                    writer.write(str.substring(i, i2));
                }
                writer.write(str2);
            } else if (cCharAt >= ' ') {
                continue;
            } else if (cCharAt == '\r' || cCharAt == '\n' || cCharAt == '\t') {
                if (i2 > i) {
                    writer.write(str.substring(i, i2));
                }
                writer.write("&#");
                writer.write(Integer.toString(cCharAt));
                writer.write(59);
            } else {
                throw new IllegalStateException(new StringBuffer("character ").append(printable(cCharAt)).append(" (").append(Integer.toString(cCharAt)).append(") is not allowed in output").append(getLocation()).append(" (attr value=").append(printable(str)).append(")").toString());
            }
            i = i2 + 1;
        }
        if (i > 0) {
            writer.write(str.substring(i));
        } else {
            writer.write(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void writeElementContent(java.lang.String r6, java.io.Writer r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L3:
            int r3 = r6.length()
            if (r1 >= r3) goto Lb6
            char r3 = r6.charAt(r1)
            r4 = 93
            if (r3 != r4) goto L1e
            boolean r3 = r5.seenBracket
            r4 = 1
            if (r3 == 0) goto L1a
            r5.seenBracketBracket = r4
            goto Lb2
        L1a:
            r5.seenBracket = r4
            goto Lb2
        L1e:
            r4 = 38
            if (r3 != r4) goto L34
            if (r1 <= r2) goto L2b
            java.lang.String r2 = r6.substring(r2, r1)
            r7.write(r2)
        L2b:
            java.lang.String r2 = "&amp;"
            r7.write(r2)
        L30:
            int r2 = r1 + 1
            goto Laa
        L34:
            r4 = 60
            if (r3 != r4) goto L47
            if (r1 <= r2) goto L41
            java.lang.String r2 = r6.substring(r2, r1)
            r7.write(r2)
        L41:
            java.lang.String r2 = "&lt;"
            r7.write(r2)
            goto L30
        L47:
            boolean r4 = r5.seenBracketBracket
            if (r4 == 0) goto L5e
            r4 = 62
            if (r3 != r4) goto L5e
            if (r1 <= r2) goto L58
            java.lang.String r2 = r6.substring(r2, r1)
            r7.write(r2)
        L58:
            java.lang.String r2 = "&gt;"
            r7.write(r2)
            goto L30
        L5e:
            r4 = 32
            if (r3 >= r4) goto Laa
            r4 = 9
            if (r3 == r4) goto Laa
            r4 = 10
            if (r3 == r4) goto Laa
            r4 = 13
            if (r3 != r4) goto L6f
            goto Laa
        L6f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            java.lang.String r1 = "character "
            r0.<init>(r1)
            java.lang.String r1 = java.lang.Integer.toString(r3)
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = " is not allowed in output"
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = r5.getLocation()
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = " (text value="
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r6 = printable(r6)
            java.lang.StringBuffer r6 = r0.append(r6)
            java.lang.String r0 = ")"
            java.lang.StringBuffer r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        Laa:
            boolean r3 = r5.seenBracket
            if (r3 == 0) goto Lb2
            r5.seenBracket = r0
            r5.seenBracketBracket = r0
        Lb2:
            int r1 = r1 + 1
            goto L3
        Lb6:
            if (r2 <= 0) goto Lc0
            java.lang.String r6 = r6.substring(r2)
            r7.write(r6)
            return
        Lc0:
            r7.write(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.mxp1_serializer.MXSerializer.writeElementContent(java.lang.String, java.io.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void writeElementContent(char[] r4, int r5, int r6, java.io.Writer r7) throws java.io.IOException {
        /*
            r3 = this;
            int r6 = r6 + r5
            r0 = r5
        L2:
            if (r5 >= r6) goto La3
            char r1 = r4[r5]
            r2 = 93
            if (r1 != r2) goto L17
            boolean r1 = r3.seenBracket
            r2 = 1
            if (r1 == 0) goto L13
            r3.seenBracketBracket = r2
            goto L9f
        L13:
            r3.seenBracket = r2
            goto L9f
        L17:
            r2 = 38
            if (r1 != r2) goto L2a
            if (r5 <= r0) goto L22
            int r1 = r5 - r0
            r7.write(r4, r0, r1)
        L22:
            java.lang.String r0 = "&amp;"
            r7.write(r0)
        L27:
            int r0 = r5 + 1
            goto L96
        L2a:
            r2 = 60
            if (r1 != r2) goto L3b
            if (r5 <= r0) goto L35
            int r1 = r5 - r0
            r7.write(r4, r0, r1)
        L35:
            java.lang.String r0 = "&lt;"
            r7.write(r0)
            goto L27
        L3b:
            boolean r2 = r3.seenBracketBracket
            if (r2 == 0) goto L50
            r2 = 62
            if (r1 != r2) goto L50
            if (r5 <= r0) goto L4a
            int r1 = r5 - r0
            r7.write(r4, r0, r1)
        L4a:
            java.lang.String r0 = "&gt;"
            r7.write(r0)
            goto L27
        L50:
            r2 = 32
            if (r1 >= r2) goto L96
            r2 = 9
            if (r1 == r2) goto L96
            r2 = 10
            if (r1 == r2) goto L96
            r2 = 13
            if (r1 != r2) goto L61
            goto L96
        L61:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            java.lang.String r6 = "character "
            r5.<init>(r6)
            java.lang.String r6 = printable(r1)
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.String r6 = " ("
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.String r6 = java.lang.Integer.toString(r1)
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.String r6 = ") is not allowed in output"
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.String r6 = r3.getLocation()
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L96:
            boolean r1 = r3.seenBracket
            if (r1 == 0) goto L9f
            r1 = 0
            r3.seenBracket = r1
            r3.seenBracketBracket = r1
        L9f:
            int r5 = r5 + 1
            goto L2
        La3:
            if (r6 <= r0) goto La9
            int r6 = r6 - r0
            r7.write(r4, r0, r6)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.mxp1_serializer.MXSerializer.writeElementContent(char[], int, int, java.io.Writer):void");
    }

    protected static final String printable(String str) {
        if (str == null) {
            return Constants.NULL_VERSION_ID;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 16);
        stringBuffer.append("'");
        for (int i = 0; i < str.length(); i++) {
            addPrintable(stringBuffer, str.charAt(i));
        }
        stringBuffer.append("'");
        return stringBuffer.toString();
    }

    protected static final String printable(char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        addPrintable(stringBuffer, c2);
        return stringBuffer.toString();
    }

    private static void addPrintable(StringBuffer stringBuffer, char c2) {
        if (c2 == '\f') {
            stringBuffer.append("\\f");
            return;
        }
        if (c2 == '\r') {
            stringBuffer.append("\\r");
            return;
        }
        if (c2 == '\"') {
            stringBuffer.append("\\\"");
            return;
        }
        if (c2 == '\'') {
            stringBuffer.append("\\'");
            return;
        }
        if (c2 != '\\') {
            switch (c2) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                default:
                    if (c2 < ' ' || c2 > '~') {
                        String string = new StringBuffer("0000").append(Integer.toString(c2, 16)).toString();
                        stringBuffer.append(new StringBuffer("\\u").append(string.substring(string.length() - 4, string.length())).toString());
                    } else {
                        stringBuffer.append(c2);
                    }
                    break;
            }
            return;
        }
        stringBuffer.append("\\\\");
    }
}
