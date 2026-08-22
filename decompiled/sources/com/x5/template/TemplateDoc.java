package com.x5.template;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jsoup.nodes.DocumentType;

/* JADX INFO: loaded from: classes9.dex */
public class TemplateDoc implements Iterator<Doclet>, Iterable<Doclet> {
    private static final String COMMENT_END = "--}";
    private static final String COMMENT_START = "{!--";
    public static final String LITERAL_END = "{^}";
    public static final String LITERAL_END_LONGHAND = "{/literal}";
    public static final String LITERAL_SHORTHAND = "{^^}";
    public static final String LITERAL_START = "{^literal}";
    public static final String LITERAL_START2 = "{.literal}";
    public static final String MACRO_END = "{*}";
    public static final String MACRO_LET = "{=";
    public static final String MACRO_LET_END = "}";
    public static final String MACRO_NAME_END = "}";
    public static final String MACRO_START = "{*";
    private static final String SKIP_BLANK_LINE = "";
    private static final String SUB_END = "{#}";
    private static final String SUB_NAME_END = "}";
    private static final String SUB_START = "{#";
    private BufferedReader brTemp;
    private InputStream in;
    private String stub;
    private static final Pattern SUPER_TAG = Pattern.compile("\\{\\% *super *\\%?\\}");
    private static final Pattern LITERAL_OPEN_HERE = Pattern.compile("\\G(\\{\\^\\^\\}|\\{[\\.\\^]literal\\}|\\{\\% *literal *\\%?\\})");
    private static final String LITERAL_OPEN = "(\\{\\^\\^\\}|\\{[\\.\\^]literal\\}|\\{\\% *literal *\\%?\\})";
    private static final Pattern LITERAL_OPEN_ANYWHERE = Pattern.compile(LITERAL_OPEN);
    private static final Pattern LITERAL_CLOSE = Pattern.compile("(\\{\\^\\}|\\{/literal\\}|\\{\\% *endliteral *\\%?\\})");
    private String encoding = getDefaultEncoding();
    private Doclet queued = null;
    private StringBuilder rootTemplate = new StringBuilder();
    private String line = null;
    private ArrayList<String> lineStack = new ArrayList<>();
    private ArrayList<String> nameStack = new ArrayList<>();
    private ArrayList<StringBuilder> bufferStack = new ArrayList<>();

    @Override // java.lang.Iterable
    public Iterator<Doclet> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public void remove() {
    }

    public TemplateDoc(String str, String str2) {
        this.stub = truncateNameToStub(str);
        try {
            this.in = new ByteArrayInputStream(str2.getBytes(this.encoding));
        } catch (UnsupportedEncodingException unused) {
            this.in = new ByteArrayInputStream(str2.getBytes());
        }
    }

    public TemplateDoc(String str, InputStream inputStream) {
        this.stub = truncateNameToStub(str);
        this.in = inputStream;
    }

    public Iterable<Doclet> parseTemplates(String str) throws IOException {
        this.encoding = str;
        this.brTemp = new BufferedReader(new InputStreamReader(this.in, str));
        return this;
    }

    public class Doclet {
        private String name;
        private String origin;
        private String rawTemplate;

        public Doclet(String str, String str2, String str3) {
            this.name = str;
            this.rawTemplate = str2;
            this.origin = str3;
        }

        public String getName() {
            return this.name;
        }

        public String getTemplate() {
            return this.rawTemplate;
        }

        public String getOrigin() {
            return this.origin;
        }

        public Snippet getSnippet() {
            return Snippet.getSnippet(this.rawTemplate, this.origin);
        }
    }

    static String truncateNameToStub(String str) {
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf < -1) {
            iLastIndexOf = str.lastIndexOf(92);
        }
        if (iLastIndexOf > -1) {
            int i = iLastIndexOf + 1;
            strSubstring = str.substring(0, i);
            str = str.substring(i);
        } else {
            strSubstring = null;
        }
        int iIndexOf = str.indexOf(MqttTopic.MULTI_LEVEL_WILDCARD);
        if (iIndexOf > -1) {
            str = str.substring(0, iIndexOf);
        }
        if (iLastIndexOf <= -1) {
            return str;
        }
        char cCharAt = System.getProperty("file.separator").charAt(0);
        strSubstring.replace('\\', cCharAt);
        strSubstring.replace('/', cCharAt);
        return strSubstring + str;
    }

    protected Doclet nextTemplate() throws IOException {
        boolean z;
        Doclet docletNextSubtemplate;
        int iIndexOf;
        Doclet docletNextSubtemplate2;
        if (this.rootTemplate == null) {
            return null;
        }
        if (this.bufferStack.size() > 0 && (docletNextSubtemplate2 = nextSubtemplate(popNameFromStack(), "")) != null) {
            return docletNextSubtemplate2;
        }
        while (this.brTemp.ready()) {
            String line = this.brTemp.readLine();
            this.line = line;
            if (line == null) {
                break;
            }
            int iIndexOf2 = line.indexOf(COMMENT_START);
            int iIndexOf3 = this.line.indexOf(SUB_START);
            while (true) {
                z = false;
                if (iIndexOf2 <= -1 || (iIndexOf3 >= 0 && iIndexOf3 <= iIndexOf2)) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                String strSkipComment = skipComment(iIndexOf2, this.line, this.brTemp, sb);
                this.line = strSkipComment;
                String strSubstring = strSkipComment.substring(0, iIndexOf2);
                String strSubstring2 = this.line.substring(iIndexOf2);
                this.rootTemplate.append(strSubstring);
                this.rootTemplate.append((CharSequence) sb);
                this.line = strSubstring2;
                iIndexOf2 = strSubstring2.indexOf(COMMENT_START);
                iIndexOf3 = this.line.indexOf(SUB_START);
            }
            if (iIndexOf3 <= -1 || this.line.indexOf(SUB_END) == iIndexOf3 || (iIndexOf = this.line.indexOf("}", SUB_START.length() + iIndexOf3)) <= -1) {
                z = true;
                docletNextSubtemplate = null;
            } else {
                this.rootTemplate.append(this.line.substring(0, iIndexOf3));
                docletNextSubtemplate = nextSubtemplate(this.stub + MqttTopic.MULTI_LEVEL_WILDCARD + this.line.substring(iIndexOf3 + SUB_START.length(), iIndexOf), this.line.substring(iIndexOf + "}".length()));
                if (this.line.length() >= 1) {
                    z = true;
                }
            }
            if (z) {
                this.rootTemplate.append(this.line);
                this.rootTemplate.append("\n");
            }
            if (docletNextSubtemplate != null) {
                return docletNextSubtemplate;
            }
        }
        String string = this.rootTemplate.toString();
        this.rootTemplate = null;
        String str = this.stub;
        return new Doclet(str, string, str);
    }

    private String getCommentLines(int i, String str, BufferedReader bufferedReader, StringBuilder sb) throws IOException {
        String line;
        int iIndexOf = str.indexOf(COMMENT_END, i + 2);
        int length = COMMENT_END.length();
        if (iIndexOf > -1) {
            int i2 = iIndexOf + length;
            sb.append(str.substring(0, i2));
            return str.substring(i2);
        }
        sb.append(str);
        sb.append("\n");
        while (bufferedReader.ready() && (line = bufferedReader.readLine()) != null) {
            int iIndexOf2 = line.indexOf(COMMENT_END);
            if (iIndexOf2 > -1) {
                int i3 = iIndexOf2 + length;
                sb.append(line.substring(0, i3));
                return line.substring(i3);
            }
            sb.append(line);
            sb.append("\n");
        }
        return "";
    }

    private String getLiteralLines(int i, String str, BufferedReader bufferedReader, StringBuilder sb) throws IOException {
        String line;
        Matcher matcher = LITERAL_CLOSE.matcher(str);
        if (matcher.find(i + 2)) {
            int iEnd = matcher.end();
            sb.append(str.substring(0, iEnd));
            return str.substring(iEnd);
        }
        sb.append(str);
        sb.append("\n");
        while (bufferedReader.ready() && (line = bufferedReader.readLine()) != null) {
            matcher.reset(line);
            if (matcher.find()) {
                int iEnd2 = matcher.end();
                sb.append(line.substring(0, iEnd2));
                return line.substring(iEnd2);
            }
            sb.append(line);
            sb.append("\n");
        }
        return "";
    }

    private String skipComment(int i, String str, BufferedReader bufferedReader, StringBuilder sb) throws IOException {
        String line;
        String strSubstring = str.substring(0, i);
        int iIndexOf = str.indexOf(COMMENT_END);
        if (iIndexOf > -1) {
            int length = iIndexOf + COMMENT_END.length();
            sb.append(str.substring(i, length));
            return strSubstring + str.substring(length);
        }
        sb.append(str.substring(i));
        sb.append("\n");
        while (bufferedReader.ready() && (line = bufferedReader.readLine()) != null) {
            int iIndexOf2 = line.indexOf(COMMENT_END);
            if (iIndexOf2 > -1) {
                int length2 = iIndexOf2 + COMMENT_END.length();
                sb.append(line.substring(0, length2));
                return strSubstring + line.substring(length2);
            }
            sb.append(line);
            sb.append("\n");
        }
        return strSubstring;
    }

    private String stripComment(int i, String str, BufferedReader bufferedReader) throws IOException {
        String line;
        String strSubstring = str.substring(0, i);
        int iIndexOf = str.indexOf(COMMENT_END);
        if (iIndexOf > -1) {
            return strSubstring + str.substring(iIndexOf + COMMENT_END.length());
        }
        while (bufferedReader.ready() && (line = bufferedReader.readLine()) != null) {
            int iIndexOf2 = line.indexOf(COMMENT_END);
            if (iIndexOf2 > -1) {
                return strSubstring + line.substring(iIndexOf2 + COMMENT_END.length());
            }
        }
        return strSubstring;
    }

    public static int findLiteralMarker(String str) {
        return findLiteralMarker(str, 0);
    }

    public static int findLiteralMarker(String str, int i) {
        Matcher matcher = LITERAL_OPEN_ANYWHERE.matcher(str);
        if (matcher.find(i)) {
            return matcher.start();
        }
        return -1;
    }

    private Doclet nextSubtemplate(String str, String str2) throws IOException {
        StringBuilder sb;
        if (this.bufferStack.size() > 0) {
            sb = popBufferFromStack();
        } else {
            sb = new StringBuilder();
        }
        int iIndexOf = str2.indexOf(SUB_END);
        int iIndexOf2 = str2.indexOf(COMMENT_START);
        int iFindLiteralMarker = findLiteralMarker(str2);
        boolean z = false;
        while (true) {
            if ((iFindLiteralMarker <= -1 && iIndexOf2 <= -1) || (iIndexOf > -1 && ((iFindLiteralMarker < 0 || iIndexOf < iFindLiteralMarker) && (iIndexOf2 < 0 || iIndexOf < iIndexOf2)))) {
                break;
            }
            while (iFindLiteralMarker > -1 && ((iIndexOf2 < 0 || iIndexOf2 > iFindLiteralMarker) && (iIndexOf < 0 || iIndexOf > iFindLiteralMarker))) {
                str2 = getLiteralLines(iFindLiteralMarker, str2, this.brTemp, sb);
                iIndexOf2 = str2.indexOf(COMMENT_START);
                iIndexOf = str2.indexOf(SUB_END);
                iFindLiteralMarker = findLiteralMarker(str2);
            }
            while (iIndexOf2 > -1 && ((iIndexOf < 0 || iIndexOf > iIndexOf2) && (iFindLiteralMarker < 0 || iFindLiteralMarker > iIndexOf2))) {
                int length = str2.length();
                str2 = stripComment(iIndexOf2, str2, this.brTemp);
                if (length != str2.length() && str2.trim().length() == 0) {
                    z = true;
                }
                iIndexOf2 = str2.indexOf(COMMENT_START);
                iIndexOf = str2.indexOf(SUB_END);
                iFindLiteralMarker = findLiteralMarker(str2);
            }
        }
        if (iIndexOf > -1) {
            sb.append(str2.substring(0, iIndexOf));
            this.line = str2.substring(iIndexOf + SUB_END.length());
            return new Doclet(str, sb.toString(), this.stub);
        }
        if (!z) {
            sb.append(str2);
            if (this.brTemp.ready() && str2.length() > 0) {
                sb.append("\n");
            }
        }
        while (this.brTemp.ready()) {
            try {
                Doclet nestedTemplate = getNestedTemplate(str, sb);
                if (nestedTemplate != null) {
                    return nestedTemplate;
                }
                String strPopLineFromStack = popLineFromStack();
                if (strPopLineFromStack == null) {
                    break;
                }
                if (strPopLineFromStack != "") {
                    sb.append(strPopLineFromStack);
                    if (this.brTemp.ready()) {
                        sb.append("\n");
                    }
                }
            } catch (EndOfSnippetException e2) {
                this.line = e2.getRestOfLine();
                return new Doclet(str, sb.toString(), this.stub);
            }
        }
        this.line = "";
        return new Doclet(str, sb.toString(), this.stub);
    }

    private StringBuilder popBufferFromStack() {
        if (this.bufferStack.size() <= 0) {
            return null;
        }
        return this.bufferStack.remove(r0.size() - 1);
    }

    private String popLineFromStack() {
        return popStringFromStack(this.lineStack);
    }

    private String popNameFromStack() {
        return popStringFromStack(this.nameStack);
    }

    private String popStringFromStack(ArrayList<String> arrayList) {
        if (arrayList.size() > 0) {
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    private Doclet getNestedTemplate(String str, StringBuilder sb) throws EndOfSnippetException, IOException {
        int iIndexOf;
        String line = this.brTemp.readLine();
        if (line == null) {
            this.lineStack.add(null);
            return null;
        }
        int iIndexOf2 = line.indexOf(COMMENT_START);
        int iIndexOf3 = line.indexOf(SUB_START);
        int iIndexOf4 = line.indexOf(SUB_END);
        int iFindLiteralMarker = findLiteralMarker(line);
        while (true) {
            if ((iFindLiteralMarker <= -1 && iIndexOf2 <= -1) || ((iIndexOf4 > -1 && ((iFindLiteralMarker < 0 || iIndexOf4 < iFindLiteralMarker) && (iIndexOf2 < 0 || iIndexOf2 < iIndexOf4))) || (iIndexOf3 > -1 && ((iFindLiteralMarker < 0 || iIndexOf3 < iFindLiteralMarker) && (iIndexOf2 < 0 || iIndexOf2 < iIndexOf3))))) {
                break;
            }
            while (iFindLiteralMarker > -1 && ((iIndexOf2 < 0 || iIndexOf2 > iFindLiteralMarker) && (iIndexOf4 < 0 || iIndexOf4 > iFindLiteralMarker))) {
                line = getLiteralLines(iFindLiteralMarker, line, this.brTemp, sb);
                iIndexOf2 = line.indexOf(COMMENT_START);
                iIndexOf3 = line.indexOf(SUB_START);
                iIndexOf4 = line.indexOf(SUB_END);
                iFindLiteralMarker = findLiteralMarker(line);
            }
            while (iIndexOf2 > -1 && ((iIndexOf3 < 0 || iIndexOf3 > iIndexOf2) && ((iIndexOf4 < 0 || iIndexOf4 > iIndexOf2) && (iFindLiteralMarker < 0 || iFindLiteralMarker > iIndexOf2)))) {
                line = getCommentLines(iIndexOf2, line, this.brTemp, sb);
                iIndexOf2 = line.indexOf(COMMENT_START);
                iIndexOf3 = line.indexOf(SUB_START);
                iIndexOf4 = line.indexOf(SUB_END);
                iFindLiteralMarker = findLiteralMarker(line);
            }
        }
        if (iIndexOf3 > -1 || iIndexOf4 > -1) {
            if (iIndexOf4 > -1 && (iIndexOf3 == -1 || iIndexOf4 <= iIndexOf3)) {
                sb.append(line.substring(0, iIndexOf4));
                throw new EndOfSnippetException(line.substring(iIndexOf4 + SUB_END.length()));
            }
            if (iIndexOf3 > -1 && (iIndexOf = line.indexOf("}", SUB_START.length() + iIndexOf3)) > -1) {
                sb.append(line.substring(0, iIndexOf3));
                String strSubstring = line.substring(iIndexOf3 + SUB_START.length(), iIndexOf);
                String strSubstring2 = line.substring(iIndexOf + "}".length());
                this.bufferStack.add(sb);
                this.nameStack.add(str);
                Doclet docletNextSubtemplate = nextSubtemplate(str + MqttTopic.MULTI_LEVEL_WILDCARD + strSubstring, strSubstring2);
                if (line.length() < 1) {
                    this.lineStack.add("");
                }
                return docletNextSubtemplate;
            }
        }
        this.lineStack.add(line);
        return null;
    }

    public static StringBuilder expandShorthand(String str, StringBuilder sb) {
        if (sb.indexOf("{^super}") > -1 || sb.indexOf("{.super}") > -1 || SUPER_TAG.matcher(sb).find()) {
            return null;
        }
        int iIndexOf = sb.indexOf("{");
        while (iIndexOf > -1) {
            int i = iIndexOf + 1;
            if (sb.length() == i) {
                break;
            }
            char cCharAt = sb.charAt(i);
            if (cCharAt == '^' || cCharAt == '.' || cCharAt == '%') {
                int iSkipLiterals = skipLiterals(sb, iIndexOf);
                if (iSkipLiterals != iIndexOf) {
                    iIndexOf = iSkipLiterals;
                } else {
                    if (cCharAt != '%') {
                        sb.replace(i, iIndexOf + 2, "~.");
                    } else {
                        int i2 = iIndexOf + 2;
                        while (i2 < sb.length() && Character.isWhitespace(sb.charAt(i2))) {
                            i2++;
                        }
                        if (Snippet.MAGIC_CHARS.indexOf(sb.charAt(i2)) < 0) {
                            sb.replace(i2, i2, "~.");
                        }
                    }
                    iIndexOf += 2;
                }
            } else if (cCharAt == '/') {
                sb.replace(i, iIndexOf + 2, "~./");
            } else {
                iIndexOf += 2;
            }
            if (iIndexOf > -1) {
                iIndexOf = sb.indexOf("{", iIndexOf);
            }
        }
        return sb;
    }

    private static int skipLiterals(StringBuilder sb, int i) {
        Matcher matcher = LITERAL_OPEN_HERE.matcher(sb);
        int iEnd = matcher.find(i) ? matcher.end() : i;
        if (iEnd <= i) {
            return i;
        }
        Matcher matcher2 = LITERAL_CLOSE.matcher(sb);
        if (matcher2.find(iEnd)) {
            return matcher2.end();
        }
        return sb.length();
    }

    public static int nextUnescapedDelim(String str, StringBuilder sb, int i) {
        int iIndexOf = sb.indexOf(str, i);
        boolean z = false;
        while (!z) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                int i4 = iIndexOf - i3;
                if (i4 < i || sb.charAt(i4) != '\\') {
                    break;
                }
                i2 = i3;
            }
            if (i2 % 2 == 0) {
                z = true;
            } else {
                iIndexOf = sb.indexOf(str, iIndexOf + 1);
                if (iIndexOf < 0) {
                    return -1;
                }
            }
        }
        return iIndexOf;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.queued != null) {
            return true;
        }
        try {
            this.queued = nextTemplate();
        } catch (IOException e2) {
            e2.printStackTrace(System.err);
        }
        return this.queued != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Doclet next() {
        Doclet doclet = this.queued;
        if (doclet != null) {
            this.queued = null;
            return doclet;
        }
        try {
            return nextTemplate();
        } catch (IOException e2) {
            e2.printStackTrace(System.err);
            return null;
        }
    }

    static String getDefaultEncoding() {
        String property = System.getProperty("chunk.template.charset");
        if (property != null) {
            return property.equalsIgnoreCase(DocumentType.SYSTEM_KEY) ? Charset.defaultCharset().toString() : property;
        }
        return "UTF-8";
    }
}
