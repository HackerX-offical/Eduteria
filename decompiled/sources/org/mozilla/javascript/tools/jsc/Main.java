package org.mozilla.javascript.tools.jsc;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.clevertap.android.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.optimizer.ClassCompiler;
import org.mozilla.javascript.tools.SourceReader;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* JADX INFO: loaded from: classes10.dex */
public class Main {
    private String characterEncoding;
    private ClassCompiler compiler;
    private CompilerEnvirons compilerEnv;
    private String destinationDir;
    private boolean printHelp;
    private ToolErrorReporter reporter = new ToolErrorReporter(true);
    private String targetName;
    private String targetPackage;

    public static void main(String[] strArr) {
        Main main = new Main();
        String[] strArrProcessOptions = main.processOptions(strArr);
        if (strArrProcessOptions == null) {
            if (main.printHelp) {
                System.out.println(ToolErrorReporter.getMessage("msg.jsc.usage", Main.class.getName()));
                System.exit(0);
            }
            System.exit(1);
        }
        if (main.reporter.hasReportedError()) {
            return;
        }
        main.processSource(strArrProcessOptions);
    }

    public Main() {
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        this.compilerEnv = compilerEnvirons;
        compilerEnvirons.setErrorReporter(this.reporter);
        this.compiler = new ClassCompiler(this.compilerEnv);
    }

    public String[] processOptions(String[] strArr) {
        this.targetPackage = "";
        this.compilerEnv.setGenerateDebugInfo(false);
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            if (!str.startsWith("-")) {
                int length = strArr.length - i;
                String str2 = this.targetName;
                if (str2 != null && length > 1) {
                    addError("msg.multiple.js.to.file", str2);
                    return null;
                }
                String[] strArr2 = new String[length];
                for (int i2 = 0; i2 != length; i2++) {
                    strArr2[i2] = strArr[i + i2];
                }
                return strArr2;
            }
            if (str.equals("-help") || str.equals("-h") || str.equals("--help")) {
                this.printHelp = true;
                return null;
            }
            try {
                if (str.equals("-version") && (i = i + 1) < strArr.length) {
                    this.compilerEnv.setLanguageVersion(Integer.parseInt(strArr[i]));
                } else if ((str.equals("-opt") || str.equals("-O")) && (i = i + 1) < strArr.length) {
                    this.compilerEnv.setOptimizationLevel(Integer.parseInt(strArr[i]));
                } else if (str.equals("-nosource")) {
                    this.compilerEnv.setGeneratingSource(false);
                } else if (str.equals("-debug") || str.equals("-g")) {
                    this.compilerEnv.setGenerateDebugInfo(true);
                } else if (str.equals("-main-method-class") && (i = i + 1) < strArr.length) {
                    this.compiler.setMainMethodClass(strArr[i]);
                } else if (str.equals("-encoding") && (i = i + 1) < strArr.length) {
                    this.characterEncoding = strArr[i];
                } else if (str.equals("-o") && (i = i + 1) < strArr.length) {
                    String strSubstring = strArr[i];
                    int length2 = strSubstring.length();
                    if (length2 == 0 || !Character.isJavaIdentifierStart(strSubstring.charAt(0))) {
                        addError("msg.invalid.classfile.name", strSubstring);
                    } else {
                        int i3 = 1;
                        while (true) {
                            if (i3 >= length2) {
                                break;
                            }
                            char cCharAt = strSubstring.charAt(i3);
                            if (Character.isJavaIdentifierPart(cCharAt)) {
                                i3++;
                            } else if (cCharAt == '.' && i3 == length2 - 6 && strSubstring.endsWith(".class")) {
                                strSubstring = strSubstring.substring(0, i3);
                            } else {
                                addError("msg.invalid.classfile.name", strSubstring);
                            }
                        }
                        this.targetName = strSubstring;
                    }
                } else {
                    if (str.equals("-observe-instruction-count")) {
                        this.compilerEnv.setGenerateObserverCount(true);
                    }
                    if (str.equals("-package") && (i = i + 1) < strArr.length) {
                        String str3 = strArr[i];
                        int length3 = str3.length();
                        int i4 = 0;
                        while (i4 != length3) {
                            char cCharAt2 = str3.charAt(i4);
                            if (Character.isJavaIdentifierStart(cCharAt2)) {
                                do {
                                    i4++;
                                    if (i4 == length3) {
                                        break;
                                    }
                                    cCharAt2 = str3.charAt(i4);
                                } while (Character.isJavaIdentifierPart(cCharAt2));
                                if (i4 == length3) {
                                    break;
                                }
                                if (cCharAt2 == '.' && i4 != length3 - 1) {
                                    i4++;
                                }
                            }
                            addError("msg.package.name", this.targetPackage);
                            return null;
                        }
                        this.targetPackage = str3;
                    } else if (str.equals("-extends") && (i = i + 1) < strArr.length) {
                        try {
                            this.compiler.setTargetExtends(Class.forName(strArr[i]));
                        } catch (ClassNotFoundException e2) {
                            throw new Error(e2.toString());
                        }
                    } else if (str.equals("-implements") && (i = i + 1) < strArr.length) {
                        StringTokenizer stringTokenizer = new StringTokenizer(strArr[i], Constants.SEPARATOR_COMMA);
                        ArrayList arrayList = new ArrayList();
                        while (stringTokenizer.hasMoreTokens()) {
                            try {
                                arrayList.add(Class.forName(stringTokenizer.nextToken()));
                            } catch (ClassNotFoundException e3) {
                                throw new Error(e3.toString());
                            }
                        }
                        this.compiler.setTargetImplements((Class[]) arrayList.toArray(new Class[arrayList.size()]));
                    } else if (str.equals("-d") && (i = i + 1) < strArr.length) {
                        this.destinationDir = strArr[i];
                    } else {
                        badUsage(str);
                        return null;
                    }
                }
                i++;
            } catch (NumberFormatException unused) {
                badUsage(strArr[i]);
                return null;
            }
        }
        p(ToolErrorReporter.getMessage("msg.no.file"));
        return null;
    }

    private static void badUsage(String str) {
        System.err.println(ToolErrorReporter.getMessage("msg.jsc.bad.usage", Main.class.getName(), str));
    }

    public void processSource(String[] strArr) {
        File file;
        for (int i = 0; i != strArr.length; i++) {
            String str = strArr[i];
            if (!str.endsWith(".js")) {
                addError("msg.extension.not.js", str);
                return;
            }
            File file2 = new File(str);
            String source = readSource(file2);
            if (source == null) {
                return;
            }
            String className = this.targetName;
            if (className == null) {
                className = getClassName(file2.getName().substring(0, r5.length() - 3));
            }
            if (this.targetPackage.length() != 0) {
                className = this.targetPackage + InstructionFileId.DOT + className;
            }
            Object[] objArrCompileToClassFiles = this.compiler.compileToClassFiles(source, str, 1, className);
            if (objArrCompileToClassFiles == null || objArrCompileToClassFiles.length == 0) {
                return;
            }
            if (this.destinationDir != null) {
                file = new File(this.destinationDir);
            } else {
                String parent = file2.getParent();
                file = parent != null ? new File(parent) : null;
            }
            for (int i2 = 0; i2 != objArrCompileToClassFiles.length; i2 += 2) {
                String str2 = (String) objArrCompileToClassFiles[i2];
                byte[] bArr = (byte[]) objArrCompileToClassFiles[i2 + 1];
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(getOutputFile(file, str2));
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (IOException e2) {
                    addFormatedError(e2.toString());
                }
            }
        }
    }

    private String readSource(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!file.isFile()) {
            addError("msg.jsfile.not.found", absolutePath);
            return null;
        }
        try {
            return (String) SourceReader.readFileOrUrl(absolutePath, true, this.characterEncoding);
        } catch (FileNotFoundException unused) {
            addError("msg.couldnt.open", absolutePath);
            return null;
        } catch (IOException e2) {
            addFormatedError(e2.toString());
            return null;
        }
    }

    private File getOutputFile(File file, String str) {
        File file2 = new File(file, str.replace('.', File.separatorChar).concat(".class"));
        String parent = file2.getParent();
        if (parent != null) {
            File file3 = new File(parent);
            if (!file3.exists()) {
                file3.mkdirs();
            }
        }
        return file2;
    }

    String getClassName(String str) {
        int i = 1;
        char[] cArr = new char[str.length() + 1];
        int i2 = 0;
        if (Character.isJavaIdentifierStart(str.charAt(0))) {
            i = 0;
        } else {
            cArr[0] = '_';
        }
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (Character.isJavaIdentifierPart(cCharAt)) {
                cArr[i] = cCharAt;
            } else {
                cArr[i] = '_';
            }
            i2++;
            i++;
        }
        return new String(cArr).trim();
    }

    private static void p(String str) {
        System.out.println(str);
    }

    private void addError(String str, String str2) {
        String message;
        if (str2 == null) {
            message = ToolErrorReporter.getMessage(str);
        } else {
            message = ToolErrorReporter.getMessage(str, str2);
        }
        addFormatedError(message);
    }

    private void addFormatedError(String str) {
        this.reporter.error(str, null, -1, null, -1);
    }
}
