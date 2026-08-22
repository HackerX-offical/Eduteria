package org.mozilla.javascript;

import com.amazonaws.services.s3.internal.Constants;
import com.csvreader.CsvReader;
import java.io.CharArrayWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public abstract class RhinoException extends RuntimeException {
    private static final Pattern JAVA_STACK_PATTERN = Pattern.compile("_c_(.*)_\\d+");
    static final long serialVersionUID = 1883500631321581169L;
    private static StackStyle stackStyle;
    private int columnNumber;
    int[] interpreterLineData;
    Object interpreterStackInfo;
    private int lineNumber;
    private String lineSource;
    private String sourceName;

    static {
        stackStyle = StackStyle.RHINO;
        String property = System.getProperty("rhino.stack.style");
        if (property != null) {
            if ("Rhino".equalsIgnoreCase(property)) {
                stackStyle = StackStyle.RHINO;
            } else if ("Mozilla".equalsIgnoreCase(property)) {
                stackStyle = StackStyle.MOZILLA;
            } else if ("V8".equalsIgnoreCase(property)) {
                stackStyle = StackStyle.V8;
            }
        }
    }

    RhinoException() {
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            evaluatorCreateInterpreter.captureStackInfo(this);
        }
    }

    RhinoException(String str) {
        super(str);
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            evaluatorCreateInterpreter.captureStackInfo(this);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String strDetails = details();
        if (this.sourceName == null || this.lineNumber <= 0) {
            return strDetails;
        }
        StringBuilder sb = new StringBuilder(strDetails);
        sb.append(" (");
        String str = this.sourceName;
        if (str != null) {
            sb.append(str);
        }
        if (this.lineNumber > 0) {
            sb.append(CsvReader.Letters.POUND);
            sb.append(this.lineNumber);
        }
        sb.append(')');
        return sb.toString();
    }

    public String details() {
        return super.getMessage();
    }

    public final String sourceName() {
        return this.sourceName;
    }

    public final void initSourceName(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.sourceName != null) {
            throw new IllegalStateException();
        }
        this.sourceName = str;
    }

    public final int lineNumber() {
        return this.lineNumber;
    }

    public final void initLineNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.lineNumber > 0) {
            throw new IllegalStateException();
        }
        this.lineNumber = i;
    }

    public final int columnNumber() {
        return this.columnNumber;
    }

    public final void initColumnNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.columnNumber > 0) {
            throw new IllegalStateException();
        }
        this.columnNumber = i;
    }

    public final String lineSource() {
        return this.lineSource;
    }

    public final void initLineSource(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.lineSource != null) {
            throw new IllegalStateException();
        }
        this.lineSource = str;
    }

    final void recordErrorOrigin(String str, int i, String str2, int i2) {
        if (i == -1) {
            i = 0;
        }
        if (str != null) {
            initSourceName(str);
        }
        if (i != 0) {
            initLineNumber(i);
        }
        if (str2 != null) {
            initLineSource(str2);
        }
        if (i2 != 0) {
            initColumnNumber(i2);
        }
    }

    private String generateStackTrace() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(charArrayWriter));
        String string = charArrayWriter.toString();
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            return evaluatorCreateInterpreter.getPatchedStack(this, string);
        }
        return null;
    }

    public String getScriptStackTrace() {
        return getScriptStackTrace(-1, null);
    }

    public String getScriptStackTrace(int i, String str) {
        return formatStackTrace(getScriptStack(i, str), details());
    }

    static String formatStackTrace(ScriptStackElement[] scriptStackElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        if (stackStyle == StackStyle.V8 && !Constants.NULL_VERSION_ID.equals(str)) {
            sb.append(str);
            sb.append(systemProperty);
        }
        for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
            int i = AnonymousClass1.$SwitchMap$org$mozilla$javascript$StackStyle[stackStyle.ordinal()];
            if (i == 1) {
                scriptStackElement.renderMozillaStyle(sb);
            } else if (i == 2) {
                scriptStackElement.renderV8Style(sb);
            } else if (i == 3) {
                scriptStackElement.renderJavaStyle(sb);
            }
            sb.append(systemProperty);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: org.mozilla.javascript.RhinoException$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$StackStyle;

        static {
            int[] iArr = new int[StackStyle.values().length];
            $SwitchMap$org$mozilla$javascript$StackStyle = iArr;
            try {
                iArr[StackStyle.MOZILLA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$StackStyle[StackStyle.V8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$StackStyle[StackStyle.RHINO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Deprecated
    public String getScriptStackTrace(FilenameFilter filenameFilter) {
        return getScriptStackTrace();
    }

    public ScriptStackElement[] getScriptStack() {
        return getScriptStack(-1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mozilla.javascript.ScriptStackElement[] getScriptStack(int r17, java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.RhinoException.getScriptStack(int, java.lang.String):org.mozilla.javascript.ScriptStackElement[]");
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.print(generateStackTrace());
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.print(generateStackTrace());
        }
    }

    public static boolean usesMozillaStackStyle() {
        return stackStyle == StackStyle.MOZILLA;
    }

    public static void useMozillaStackStyle(boolean z) {
        stackStyle = z ? StackStyle.MOZILLA : StackStyle.RHINO;
    }

    public static void setStackStyle(StackStyle stackStyle2) {
        stackStyle = stackStyle2;
    }

    public static StackStyle getStackStyle() {
        return stackStyle;
    }
}
