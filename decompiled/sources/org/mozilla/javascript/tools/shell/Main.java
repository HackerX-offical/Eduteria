package org.mozilla.javascript.tools.shell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.util.StringUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.commonjs.module.ModuleScope;
import org.mozilla.javascript.commonjs.module.Require;
import org.mozilla.javascript.tools.SourceReader;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* JADX INFO: loaded from: classes10.dex */
public class Main {
    private static final int EXITCODE_FILE_NOT_FOUND = 4;
    private static final int EXITCODE_RUNTIME_ERROR = 3;
    protected static ToolErrorReporter errorReporter;
    static String mainModule;
    static List<String> modulePath;
    static Require require;
    private static SecurityProxy securityImpl;
    public static ShellContextFactory shellContextFactory = new ShellContextFactory();
    public static Global global = new Global();
    protected static int exitCode = 0;
    static boolean processStdin = true;
    static List<String> fileList = new ArrayList();
    static boolean sandboxed = false;
    static boolean useRequire = false;
    private static final ScriptCache scriptCache = new ScriptCache(32);

    static {
        global.initQuitAction(new IProxy(3));
    }

    private static class IProxy implements ContextAction, QuitAction {
        private static final int EVAL_INLINE_SCRIPT = 2;
        private static final int PROCESS_FILES = 1;
        private static final int SYSTEM_EXIT = 3;
        String[] args;
        String scriptText;
        private int type;

        IProxy(int i) {
            this.type = i;
        }

        @Override // org.mozilla.javascript.ContextAction
        public Object run(Context context) throws Throwable {
            if (Main.useRequire) {
                Main.require = Main.global.installRequire(context, Main.modulePath, Main.sandboxed);
            }
            int i = this.type;
            if (i == 1) {
                Main.processFiles(context, this.args);
                return null;
            }
            if (i == 2) {
                Main.evalInlineScript(context, this.scriptText);
                return null;
            }
            throw Kit.codeBug();
        }

        @Override // org.mozilla.javascript.tools.shell.QuitAction
        public void quit(Context context, int i) {
            if (this.type == 3) {
                System.exit(i);
                return;
            }
            throw Kit.codeBug();
        }
    }

    public static void main(String[] strArr) {
        try {
            if (Boolean.getBoolean("rhino.use_java_policy_security")) {
                initJavaPolicySecuritySupport();
            }
        } catch (SecurityException e2) {
            e2.printStackTrace(System.err);
        }
        int iExec = exec(strArr);
        if (iExec != 0) {
            System.exit(iExec);
        }
    }

    public static int exec(String[] strArr) {
        ToolErrorReporter toolErrorReporter = new ToolErrorReporter(false, global.getErr());
        errorReporter = toolErrorReporter;
        shellContextFactory.setErrorReporter(toolErrorReporter);
        String[] strArrProcessOptions = processOptions(strArr);
        int i = exitCode;
        if (i > 0) {
            return i;
        }
        if (processStdin) {
            fileList.add(null);
        }
        if (!global.initialized) {
            global.init(shellContextFactory);
        }
        IProxy iProxy = new IProxy(1);
        iProxy.args = strArrProcessOptions;
        shellContextFactory.call(iProxy);
        return exitCode;
    }

    static void processFiles(Context context, String[] strArr) throws Throwable {
        Object[] objArr = new Object[strArr.length];
        System.arraycopy(strArr, 0, objArr, 0, strArr.length);
        global.defineProperty("arguments", context.newArray(global, objArr), 2);
        for (String str : fileList) {
            try {
                processSource(context, str);
            } catch (IOException e2) {
                Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", str, e2.getMessage()));
                exitCode = 4;
            } catch (VirtualMachineError e3) {
                e3.printStackTrace();
                Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e3.toString()));
                exitCode = 3;
            } catch (RhinoException e4) {
                ToolErrorReporter.reportException(context.getErrorReporter(), e4);
                exitCode = 3;
            }
        }
    }

    static void evalInlineScript(Context context, String str) {
        try {
            Script scriptCompileString = context.compileString(str, "<command>", 1, null);
            if (scriptCompileString != null) {
                scriptCompileString.exec(context, getShellScope());
            }
        } catch (VirtualMachineError e2) {
            e2.printStackTrace();
            Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            exitCode = 3;
        } catch (RhinoException e3) {
            ToolErrorReporter.reportException(context.getErrorReporter(), e3);
            exitCode = 3;
        }
    }

    public static Global getGlobal() {
        return global;
    }

    static Scriptable getShellScope() {
        return getScope(null);
    }

    static Scriptable getScope(String str) {
        URI uri;
        if (useRequire) {
            if (str == null) {
                uri = new File(System.getProperty("user.dir")).toURI();
            } else if (SourceReader.toUrl(str) != null) {
                try {
                    uri = new URI(str);
                } catch (URISyntaxException unused) {
                    uri = new File(str).toURI();
                }
            } else {
                uri = new File(str).toURI();
            }
            return new ModuleScope(global, uri, null);
        }
        return global;
    }

    public static String[] processOptions(String[] strArr) {
        int i = 0;
        while (i != strArr.length) {
            String str = strArr[i];
            if (!str.startsWith("-")) {
                processStdin = false;
                fileList.add(str);
                mainModule = str;
                String[] strArr2 = new String[(strArr.length - i) - 1];
                System.arraycopy(strArr, i + 1, strArr2, 0, (strArr.length - i) - 1);
                return strArr2;
            }
            if (str.equals("-version")) {
                i++;
                if (i != strArr.length) {
                    try {
                        int i2 = Integer.parseInt(strArr[i]);
                        if (!Context.isValidLanguageVersion(i2)) {
                            str = strArr[i];
                        } else {
                            shellContextFactory.setLanguageVersion(i2);
                            i++;
                        }
                    } catch (NumberFormatException unused) {
                        str = strArr[i];
                    }
                }
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                exitCode = 1;
                return null;
            }
            if (str.equals("-opt") || str.equals("-O")) {
                i++;
                if (i != strArr.length) {
                    try {
                        int i3 = Integer.parseInt(strArr[i]);
                        if (i3 == -2) {
                            i3 = -1;
                        } else if (!Context.isValidOptimizationLevel(i3)) {
                            str = strArr[i];
                        }
                        shellContextFactory.setOptimizationLevel(i3);
                        i++;
                    } catch (NumberFormatException unused2) {
                        str = strArr[i];
                    }
                }
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                exitCode = 1;
                return null;
            }
            if (str.equals("-encoding")) {
                i++;
                if (i != strArr.length) {
                    shellContextFactory.setCharacterEncoding(strArr[i]);
                    i++;
                } else {
                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                    exitCode = 1;
                    return null;
                }
            } else {
                if (str.equals("-strict")) {
                    shellContextFactory.setStrictMode(true);
                    shellContextFactory.setAllowReservedKeywords(false);
                    errorReporter.setIsReportingWarnings(true);
                } else if (str.equals("-fatal-warnings")) {
                    shellContextFactory.setWarningAsError(true);
                } else if (str.equals("-e")) {
                    processStdin = false;
                    i++;
                    if (i != strArr.length) {
                        if (!global.initialized) {
                            global.init(shellContextFactory);
                        }
                        IProxy iProxy = new IProxy(2);
                        iProxy.scriptText = strArr[i];
                        shellContextFactory.call(iProxy);
                    } else {
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                        exitCode = 1;
                        return null;
                    }
                } else if (str.equals("-require")) {
                    useRequire = true;
                } else if (str.equals("-sandbox")) {
                    sandboxed = true;
                    useRequire = true;
                } else if (str.equals("-modules")) {
                    i++;
                    if (i != strArr.length) {
                        if (modulePath == null) {
                            modulePath = new ArrayList();
                        }
                        modulePath.add(strArr[i]);
                        useRequire = true;
                    } else {
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                        exitCode = 1;
                        return null;
                    }
                } else if (str.equals("-w")) {
                    errorReporter.setIsReportingWarnings(true);
                } else if (str.equals("-f")) {
                    processStdin = false;
                    i++;
                    if (i != strArr.length) {
                        if (strArr[i].equals("-")) {
                            fileList.add(null);
                        } else {
                            fileList.add(strArr[i]);
                            mainModule = strArr[i];
                        }
                    } else {
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                        exitCode = 1;
                        return null;
                    }
                } else if (str.equals("-sealedlib")) {
                    global.setSealedStdLib(true);
                } else if (str.equals("-debug")) {
                    shellContextFactory.setGeneratingDebug(true);
                } else {
                    if (str.equals("-?") || str.equals("-help")) {
                        global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                        exitCode = 1;
                        return null;
                    }
                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.invalid", str));
                    global.getOut().println(ToolErrorReporter.getMessage("msg.shell.usage", Main.class.getName()));
                    exitCode = 1;
                    return null;
                }
                i++;
            }
        }
        return new String[0];
    }

    private static void initJavaPolicySecuritySupport() {
        try {
            SecurityProxy securityProxy = (SecurityProxy) Class.forName("org.mozilla.javascript.tools.shell.JavaPolicySecurity").newInstance();
            securityImpl = securityProxy;
            SecurityController.initGlobal(securityProxy);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | LinkageError e2) {
            throw Kit.initCause(new IllegalStateException("Can not load security support: " + e2), e2);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void processSource(Context context, String str) throws Throwable {
        Charset charsetDefaultCharset;
        if (str == null || str.equals("-")) {
            Scriptable shellScope = getShellScope();
            String characterEncoding = shellContextFactory.getCharacterEncoding();
            if (characterEncoding != null) {
                charsetDefaultCharset = Charset.forName(characterEncoding);
            } else {
                charsetDefaultCharset = Charset.defaultCharset();
            }
            ShellConsole console = global.getConsole(charsetDefaultCharset);
            if (str == null) {
                console.println(context.getImplementationVersion());
            }
            boolean z = false;
            int i = 1;
            while (!z) {
                String[] prompts = global.getPrompts(context);
                String str2 = str == null ? prompts[0] : null;
                console.flush();
                String str3 = "";
                while (true) {
                    try {
                        String line = console.readLine(str2);
                        if (line == null) {
                            z = true;
                            break;
                        }
                        str3 = str3 + line + "\n";
                        i++;
                        if (context.stringIsCompilableUnit(str3)) {
                            break;
                        } else {
                            str2 = prompts[1];
                        }
                    } catch (IOException e2) {
                        console.println(e2.toString());
                    }
                }
                try {
                    try {
                        Script scriptCompileString = context.compileString(str3, "<stdin>", i, null);
                        if (scriptCompileString != null) {
                            Object objExec = scriptCompileString.exec(context, shellScope);
                            if (objExec != Context.getUndefinedValue() && (!(objExec instanceof Function) || !str3.trim().startsWith("function"))) {
                                try {
                                    console.println(Context.toString(objExec));
                                } catch (RhinoException e3) {
                                    ToolErrorReporter.reportException(context.getErrorReporter(), e3);
                                }
                            }
                            NativeArray nativeArray = global.history;
                            nativeArray.put((int) nativeArray.getLength(), nativeArray, str3);
                        }
                    } catch (RhinoException e4) {
                        ToolErrorReporter.reportException(context.getErrorReporter(), e4);
                        exitCode = 3;
                    }
                } catch (VirtualMachineError e5) {
                    e5.printStackTrace();
                    Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e5.toString()));
                    exitCode = 3;
                }
            }
            console.println();
            console.flush();
            return;
        }
        if (useRequire && str.equals(mainModule)) {
            require.requireMain(context, str);
        } else {
            processFile(context, getScope(str), str);
        }
    }

    public static void processFileNoThrow(Context context, Scriptable scriptable, String str) {
        try {
            processFile(context, scriptable, str);
        } catch (IOException e2) {
            Context.reportError(ToolErrorReporter.getMessage("msg.couldnt.read.source", str, e2.getMessage()));
            exitCode = 4;
        } catch (VirtualMachineError e3) {
            e3.printStackTrace();
            Context.reportError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e3.toString()));
            exitCode = 3;
        } catch (RhinoException e4) {
            ToolErrorReporter.reportException(context.getErrorReporter(), e4);
            exitCode = 3;
        }
    }

    public static void processFile(Context context, Scriptable scriptable, String str) throws IOException {
        SecurityProxy securityProxy = securityImpl;
        if (securityProxy == null) {
            processFileSecure(context, scriptable, str, null);
        } else {
            securityProxy.callProcessFileSecure(context, scriptable, str);
        }
    }

    static void processFileSecure(Context context, Scriptable scriptable, String str, Object obj) throws IOException {
        Script scriptCompileString;
        boolean zEndsWith = str.endsWith(".class");
        Object fileOrUrl = readFileOrUrl(str, !zEndsWith);
        byte[] digest = getDigest(fileOrUrl);
        String str2 = str + "_" + context.getOptimizationLevel();
        ScriptReference scriptReference = scriptCache.get(str2, digest);
        Script script = scriptReference != null ? scriptReference.get() : null;
        if (script == null) {
            if (zEndsWith) {
                scriptCompileString = loadCompiledScript(context, str, (byte[]) fileOrUrl, obj);
            } else {
                String strSubstring = (String) fileOrUrl;
                if (strSubstring.length() > 0 && strSubstring.charAt(0) == '#') {
                    for (int i = 1; i != strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (cCharAt == '\n' || cCharAt == '\r') {
                            strSubstring = strSubstring.substring(i);
                            break;
                        }
                    }
                }
                scriptCompileString = context.compileString(strSubstring, str, 1, obj);
            }
            script = scriptCompileString;
            scriptCache.put(str2, digest, script);
        }
        if (script != null) {
            script.exec(context, scriptable);
        }
    }

    private static byte[] getDigest(Object obj) {
        byte[] bytes;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                bytes = ((String) obj).getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bytes = ((String) obj).getBytes();
            }
        } else {
            bytes = (byte[]) obj;
        }
        try {
            return MessageDigest.getInstance(StringUtils.MD5).digest(bytes);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Script loadCompiledScript(Context context, String str, byte[] bArr, Object obj) throws FileNotFoundException {
        if (bArr == null) {
            throw new FileNotFoundException(str);
        }
        int iLastIndexOf = str.lastIndexOf(47);
        int i = iLastIndexOf < 0 ? 0 : iLastIndexOf + 1;
        int iLastIndexOf2 = str.lastIndexOf(46);
        if (iLastIndexOf2 < i) {
            iLastIndexOf2 = str.length();
        }
        String strSubstring = str.substring(i, iLastIndexOf2);
        try {
            GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(context.getApplicationClassLoader(), obj);
            Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(strSubstring, bArr);
            generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
            if (!Script.class.isAssignableFrom(clsDefineClass)) {
                throw Context.reportRuntimeError("msg.must.implement.Script");
            }
            return (Script) clsDefineClass.newInstance();
        } catch (IllegalAccessException e2) {
            Context.reportError(e2.toString());
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            Context.reportError(e3.toString());
            throw new RuntimeException(e3);
        }
    }

    public static InputStream getIn() {
        return getGlobal().getIn();
    }

    public static void setIn(InputStream inputStream) {
        getGlobal().setIn(inputStream);
    }

    public static PrintStream getOut() {
        return getGlobal().getOut();
    }

    public static void setOut(PrintStream printStream) {
        getGlobal().setOut(printStream);
    }

    public static PrintStream getErr() {
        return getGlobal().getErr();
    }

    public static void setErr(PrintStream printStream) {
        getGlobal().setErr(printStream);
    }

    private static Object readFileOrUrl(String str, boolean z) throws IOException {
        return SourceReader.readFileOrUrl(str, z, shellContextFactory.getCharacterEncoding());
    }

    static class ScriptReference extends SoftReference<Script> {
        byte[] digest;
        String path;

        ScriptReference(String str, byte[] bArr, Script script, ReferenceQueue<Script> referenceQueue) {
            super(script, referenceQueue);
            this.path = str;
            this.digest = bArr;
        }
    }

    static class ScriptCache extends LinkedHashMap<String, ScriptReference> {
        int capacity;
        ReferenceQueue<Script> queue;

        ScriptCache(int i) {
            super(i + 1, 2.0f, true);
            this.capacity = i;
            this.queue = new ReferenceQueue<>();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, ScriptReference> entry) {
            return size() > this.capacity;
        }

        ScriptReference get(String str, byte[] bArr) {
            while (true) {
                ScriptReference scriptReference = (ScriptReference) this.queue.poll();
                if (scriptReference == null) {
                    break;
                }
                remove(scriptReference.path);
            }
            ScriptReference scriptReference2 = get(str);
            if (scriptReference2 == null || Arrays.equals(bArr, scriptReference2.digest)) {
                return scriptReference2;
            }
            remove(scriptReference2.path);
            return null;
        }

        void put(String str, byte[] bArr, Script script) {
            put(str, new ScriptReference(str, bArr, script, this.queue));
        }
    }
}
