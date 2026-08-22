package org.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import com.x5.template.MacroTag;
import java.util.HashMap;
import java.util.List;
import org.mozilla.classfile.ByteCode;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: loaded from: classes10.dex */
public class Codegen implements Evaluator {
    static final String DEFAULT_MAIN_METHOD_CLASS = "org.mozilla.javascript.optimizer.OptRuntime";
    static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    static final String ID_FIELD_NAME = "_id";
    static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    private static final String SUPER_CLASS_NAME = "org.mozilla.javascript.NativeFunction";
    private static final Object globalLock = new Object();
    private static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private ObjArray directCallTargets;
    private double[] itsConstantList;
    private int itsConstantListSize;
    String mainClassName;
    String mainClassSignature;
    private String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    private ObjToIntMap scriptOrFnIndexes;
    ScriptNode[] scriptOrFnNodes;

    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i;
        synchronized (globalLock) {
            i = globalSerialClassCounter + 1;
            globalSerialClassCounter = i;
        }
        String strReplaceAll = "c";
        if (scriptNode.getSourceName().length() > 0) {
            strReplaceAll = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(strReplaceAll.charAt(0))) {
                strReplaceAll = "_" + strReplaceAll;
            }
        }
        String str2 = "org.mozilla.javascript.gen." + strReplaceAll + "_" + i;
        return new Object[]{str2, compileToClassFile(compilerEnvirons, str2, scriptNode, str, z)};
    }

    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e2.toString());
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e2.toString());
        }
    }

    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(getClass().getClassLoader(), obj2);
        try {
            Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(str, bArr);
            generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
            return clsDefineClass;
        } catch (IllegalArgumentException | SecurityException e2) {
            throw new RuntimeException("Malformed optimizer package " + e2);
        }
    }

    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        this.mainClassSignature = ClassFileWriter.classNameToSignature(str);
        try {
            return generateCode(str2);
        } catch (ClassFileWriter.ClassFileFormatException e2) {
            throw reportClassFileFormatException(scriptNode, e2.getMessage());
        }
    }

    private RuntimeException reportClassFileFormatException(ScriptNode scriptNode, String str) {
        String message1;
        if (scriptNode instanceof FunctionNode) {
            message1 = ScriptRuntime.getMessage2("msg.while.compiling.fn", ((FunctionNode) scriptNode).getFunctionName(), str);
        } else {
            message1 = ScriptRuntime.getMessage1("msg.while.compiling.script", str);
        }
        return Context.reportRuntimeError(message1, scriptNode.getSourceName(), scriptNode.getLineno(), null, 0);
    }

    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        int optimizationLevel = this.compilerEnv.getOptimizationLevel();
        HashMap map = null;
        if (optimizationLevel > 0 && scriptNode.getType() == 137) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i = 0; i != functionCount; i++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (map != null) {
            this.directCallTargets = new ObjArray();
        }
        new OptTransformer(map, this.directCallTargets).transform(scriptNode, this.compilerEnv);
        if (optimizationLevel > 0) {
            new Optimizer().optimize(scriptNode);
        }
    }

    private static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    private void initScriptNodesData(ScriptNode scriptNode) {
        ObjArray objArray = new ObjArray();
        collectScriptNodes_r(scriptNode, objArray);
        int size = objArray.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        objArray.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new ObjToIntMap(size);
        for (int i = 0; i != size; i++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i], i);
        }
    }

    private static void collectScriptNodes_r(ScriptNode scriptNode, ObjArray objArray) {
        objArray.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i), objArray);
        }
    }

    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 137;
        ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
        if (scriptNodeArr.length <= 1 && z2) {
            z = false;
        }
        boolean zIsInStrictMode = scriptNodeArr[0].isInStrictMode();
        ClassFileWriter classFileWriter = new ClassFileWriter(this.mainClassName, SUPER_CLASS_NAME, this.compilerEnv.isGenerateDebugInfo() ? this.scriptOrFnNodes[0].getSourceName() : null);
        classFileWriter.addField("_id", "I", (short) 2);
        if (z) {
            generateFunctionConstructor(classFileWriter);
        }
        if (z2) {
            classFileWriter.addInterface("org/mozilla/javascript/Script");
            generateScriptCtor(classFileWriter);
            generateMain(classFileWriter);
            generateExecute(classFileWriter);
        }
        generateCallMethod(classFileWriter, zIsInStrictMode);
        generateResumeGenerator(classFileWriter);
        generateNativeFunctionOverrides(classFileWriter, str);
        int length = this.scriptOrFnNodes.length;
        for (int i = 0; i != length; i++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = classFileWriter;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i;
            try {
                bodyCodegen.generateBodyCode();
                if (scriptNode.getType() == 110) {
                    OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                    generateFunctionInit(classFileWriter, optFunctionNode);
                    if (optFunctionNode.isTargetOfDirectCall()) {
                        emitDirectConstructor(classFileWriter, optFunctionNode);
                    }
                }
            } catch (ClassFileWriter.ClassFileFormatException e2) {
                throw reportClassFileFormatException(scriptNode, e2.getMessage());
            }
        }
        emitRegExpInit(classFileWriter);
        emitConstantDudeInitializers(classFileWriter);
        return classFileWriter.toByteArray();
    }

    private void emitDirectConstructor(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.startMethod(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i = paramCount * 3;
        int i2 = i + 4;
        int i3 = i + 5;
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addInvoke(ByteCode.INVOKEVIRTUAL, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.addAStore(i3);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(i3);
        for (int i4 = 0; i4 < paramCount; i4++) {
            int i5 = i4 * 3;
            classFileWriter.addALoad(i5 + 4);
            classFileWriter.addDLoad(i5 + 5);
        }
        classFileWriter.addALoad(i2);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int iAcquireLabel = classFileWriter.acquireLabel();
        classFileWriter.add(89);
        classFileWriter.add(ByteCode.INSTANCEOF, "org/mozilla/javascript/Scriptable");
        classFileWriter.add(153, iAcquireLabel);
        classFileWriter.add(192, "org/mozilla/javascript/Scriptable");
        classFileWriter.add(ByteCode.ARETURN);
        classFileWriter.markLabel(iAcquireLabel);
        classFileWriter.addALoad(i3);
        classFileWriter.add(ByteCode.ARETURN);
        classFileWriter.stopMethod((short) (i + 6));
    }

    static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator();
    }

    private void generateResumeGenerator(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 >= scriptNodeArr.length) {
                break;
            }
            if (isGenerator(scriptNodeArr[i2])) {
                z = true;
            }
            i2++;
        }
        if (!z) {
            return;
        }
        classFileWriter.startMethod("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(4);
        classFileWriter.addALoad(5);
        classFileWriter.addILoad(3);
        classFileWriter.addLoadThis();
        classFileWriter.add(180, classFileWriter.getClassName(), "_id", "I");
        int iAddTableSwitch = classFileWriter.addTableSwitch(0, this.scriptOrFnNodes.length - 1);
        classFileWriter.markTableSwitchDefault(iAddTableSwitch);
        int iAcquireLabel = classFileWriter.acquireLabel();
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i < scriptNodeArr2.length) {
                ScriptNode scriptNode = scriptNodeArr2[i];
                classFileWriter.markTableSwitchCase(iAddTableSwitch, i, 6);
                if (isGenerator(scriptNode)) {
                    classFileWriter.addInvoke(ByteCode.INVOKESTATIC, this.mainClassName, getBodyMethodName(scriptNode) + "_gen", "(" + this.mainClassSignature + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                    classFileWriter.add(ByteCode.ARETURN);
                } else {
                    classFileWriter.add(ByteCode.GOTO, iAcquireLabel);
                }
                i++;
            } else {
                classFileWriter.markLabel(iAcquireLabel);
                pushUndefined(classFileWriter);
                classFileWriter.add(ByteCode.ARETURN);
                classFileWriter.stopMethod((short) 6);
                return;
            }
        }
    }

    private void generateCallMethod(ClassFileWriter classFileWriter, boolean z) {
        int iAddTableSwitch;
        int paramCount;
        classFileWriter.startMethod(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int iAcquireLabel = classFileWriter.acquireLabel();
        classFileWriter.addALoad(1);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        classFileWriter.add(154, iAcquireLabel);
        int i = 0;
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(3);
        classFileWriter.addALoad(4);
        classFileWriter.addPush(z);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        classFileWriter.add(ByteCode.ARETURN);
        classFileWriter.markLabel(iAcquireLabel);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(3);
        classFileWriter.addALoad(4);
        int length = this.scriptOrFnNodes.length;
        boolean z2 = 2 <= length;
        if (z2) {
            classFileWriter.addLoadThis();
            classFileWriter.add(180, classFileWriter.getClassName(), "_id", "I");
            iAddTableSwitch = classFileWriter.addTableSwitch(1, length - 1);
        } else {
            iAddTableSwitch = 0;
        }
        int i2 = 0;
        short stackTop = 0;
        while (i2 != length) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            if (z2) {
                if (i2 == 0) {
                    classFileWriter.markTableSwitchDefault(iAddTableSwitch);
                    stackTop = classFileWriter.getStackTop();
                } else {
                    classFileWriter.markTableSwitchCase(iAddTableSwitch, i2 - 1, stackTop);
                }
            }
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i3 = i; i3 != paramCount; i3++) {
                        classFileWriter.add(190);
                        classFileWriter.addPush(i3);
                        int iAcquireLabel2 = classFileWriter.acquireLabel();
                        int iAcquireLabel3 = classFileWriter.acquireLabel();
                        classFileWriter.add(164, iAcquireLabel2);
                        classFileWriter.addALoad(4);
                        classFileWriter.addPush(i3);
                        classFileWriter.add(50);
                        classFileWriter.add(ByteCode.GOTO, iAcquireLabel3);
                        classFileWriter.markLabel(iAcquireLabel2);
                        pushUndefined(classFileWriter);
                        classFileWriter.markLabel(iAcquireLabel3);
                        classFileWriter.adjustStackTop(-1);
                        classFileWriter.addPush(0.0d);
                        classFileWriter.addALoad(4);
                    }
                }
            }
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            classFileWriter.add(ByteCode.ARETURN);
            i2++;
            i = 0;
        }
        classFileWriter.stopMethod((short) 5);
    }

    private void generateMain(ClassFileWriter classFileWriter) {
        classFileWriter.startMethod("main", "([Ljava/lang/String;)V", (short) 9);
        classFileWriter.add(ByteCode.NEW, classFileWriter.getClassName());
        classFileWriter.add(89);
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, classFileWriter.getClassName(), "<init>", "()V");
        classFileWriter.add(42);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, this.mainMethodClass, "main", "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod((short) 1);
    }

    private void generateExecute(ClassFileWriter classFileWriter) {
        classFileWriter.startMethod(MacroTag.MACRO_MARKER, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        classFileWriter.addLoadThis();
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.add(89);
        classFileWriter.add(1);
        classFileWriter.addInvoke(ByteCode.INVOKEVIRTUAL, classFileWriter.getClassName(), NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        classFileWriter.add(ByteCode.ARETURN);
        classFileWriter.stopMethod((short) 3);
    }

    private void generateScriptCtor(ClassFileWriter classFileWriter) {
        classFileWriter.startMethod("<init>", "()V", (short) 1);
        classFileWriter.addLoadThis();
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, SUPER_CLASS_NAME, "<init>", "()V");
        classFileWriter.addLoadThis();
        classFileWriter.addPush(0);
        classFileWriter.add(ByteCode.PUTFIELD, classFileWriter.getClassName(), "_id", "I");
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod((short) 1);
    }

    private void generateFunctionConstructor(ClassFileWriter classFileWriter) {
        int iAddTableSwitch;
        classFileWriter.startMethod("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        short stackTop = 0;
        classFileWriter.addALoad(0);
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, SUPER_CLASS_NAME, "<init>", "()V");
        classFileWriter.addLoadThis();
        classFileWriter.addILoad(3);
        classFileWriter.add(ByteCode.PUTFIELD, classFileWriter.getClassName(), "_id", "I");
        classFileWriter.addLoadThis();
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(1);
        int i = this.scriptOrFnNodes[0].getType() == 137 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i == length) {
            throw badTree();
        }
        boolean z = 2 <= length - i;
        if (z) {
            classFileWriter.addILoad(3);
            iAddTableSwitch = classFileWriter.addTableSwitch(i + 1, length - 1);
        } else {
            iAddTableSwitch = 0;
        }
        for (int i2 = i; i2 != length; i2++) {
            if (z) {
                if (i2 == i) {
                    classFileWriter.markTableSwitchDefault(iAddTableSwitch);
                    stackTop = classFileWriter.getStackTop();
                } else {
                    classFileWriter.markTableSwitchCase(iAddTableSwitch, (i2 - 1) - i, stackTop);
                }
            }
            classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i2])), FUNCTION_INIT_SIGNATURE);
            classFileWriter.add(ByteCode.RETURN);
        }
        classFileWriter.stopMethod((short) 4);
    }

    private void generateFunctionInit(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.startMethod(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        classFileWriter.addLoadThis();
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addInvoke(ByteCode.INVOKEVIRTUAL, "org/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            classFileWriter.addALoad(1);
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod((short) 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void generateNativeFunctionOverrides(org.mozilla.classfile.ClassFileWriter r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.Codegen.generateNativeFunctionOverrides(org.mozilla.classfile.ClassFileWriter, java.lang.String):void");
    }

    private void emitRegExpInit(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        int regexpCount = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 == scriptNodeArr.length) {
                break;
            }
            regexpCount += scriptNodeArr[i2].getRegexpCount();
            i2++;
        }
        if (regexpCount == 0) {
            return;
        }
        short s = 10;
        classFileWriter.startMethod(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        classFileWriter.addField("_reInitDone", "Z", (short) 74);
        classFileWriter.add(ByteCode.GETSTATIC, this.mainClassName, "_reInitDone", "Z");
        int iAcquireLabel = classFileWriter.acquireLabel();
        classFileWriter.add(153, iAcquireLabel);
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.markLabel(iAcquireLabel);
        classFileWriter.addALoad(0);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        classFileWriter.addAStore(1);
        int i3 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i3 != scriptNodeArr2.length) {
                ScriptNode scriptNode = scriptNodeArr2[i3];
                int regexpCount2 = scriptNode.getRegexpCount();
                int i4 = i;
                while (i4 != regexpCount2) {
                    String compiledRegexpName = getCompiledRegexpName(scriptNode, i4);
                    String regexpString = scriptNode.getRegexpString(i4);
                    String regexpFlags = scriptNode.getRegexpFlags(i4);
                    classFileWriter.addField(compiledRegexpName, "Ljava/lang/Object;", s);
                    classFileWriter.addALoad(1);
                    classFileWriter.addALoad(i);
                    classFileWriter.addPush(regexpString);
                    if (regexpFlags == null) {
                        classFileWriter.add(1);
                    } else {
                        classFileWriter.addPush(regexpFlags);
                    }
                    classFileWriter.addInvoke(ByteCode.INVOKEINTERFACE, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                    classFileWriter.add(ByteCode.PUTSTATIC, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                    i4++;
                    i = 0;
                    s = 10;
                }
                i3++;
                i = 0;
                s = 10;
            } else {
                classFileWriter.addPush(1);
                classFileWriter.add(ByteCode.PUTSTATIC, this.mainClassName, "_reInitDone", "Z");
                classFileWriter.add(ByteCode.RETURN);
                classFileWriter.stopMethod((short) 2);
                return;
            }
        }
    }

    private void emitConstantDudeInitializers(ClassFileWriter classFileWriter) {
        int i = this.itsConstantListSize;
        if (i == 0) {
            return;
        }
        classFileWriter.startMethod("<clinit>", "()V", (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i2 = 0; i2 != i; i2++) {
            double d2 = dArr[i2];
            String str = "_k" + i2;
            String staticConstantWrapperType = getStaticConstantWrapperType(d2);
            classFileWriter.addField(str, staticConstantWrapperType, (short) 10);
            int i3 = (int) d2;
            if (i3 == d2) {
                classFileWriter.addPush(i3);
                classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                classFileWriter.addPush(d2);
                addDoubleWrap(classFileWriter);
            }
            classFileWriter.add(ByteCode.PUTSTATIC, this.mainClassName, str, staticConstantWrapperType);
        }
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod((short) 0);
    }

    void pushNumberAsObject(ClassFileWriter classFileWriter, double d2) {
        if (d2 == 0.0d) {
            if (1.0d / d2 > 0.0d) {
                classFileWriter.add(ByteCode.GETSTATIC, "org/mozilla/javascript/optimizer/OptRuntime", "zeroObj", "Ljava/lang/Double;");
                return;
            } else {
                classFileWriter.addPush(d2);
                addDoubleWrap(classFileWriter);
                return;
            }
        }
        if (d2 == 1.0d) {
            classFileWriter.add(ByteCode.GETSTATIC, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
            return;
        }
        if (d2 == -1.0d) {
            classFileWriter.add(ByteCode.GETSTATIC, "org/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
            return;
        }
        if (d2 != d2) {
            classFileWriter.add(ByteCode.GETSTATIC, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
            return;
        }
        int i = this.itsConstantListSize;
        if (i >= 2000) {
            classFileWriter.addPush(d2);
            addDoubleWrap(classFileWriter);
            return;
        }
        int i2 = 0;
        if (i == 0) {
            this.itsConstantList = new double[64];
        } else {
            double[] dArr = this.itsConstantList;
            int i3 = 0;
            while (i3 != i && dArr[i3] != d2) {
                i3++;
            }
            if (i == dArr.length) {
                double[] dArr2 = new double[i * 2];
                System.arraycopy(this.itsConstantList, 0, dArr2, 0, i);
                this.itsConstantList = dArr2;
            }
            i2 = i3;
        }
        if (i2 == i) {
            this.itsConstantList[i] = d2;
            this.itsConstantListSize = i + 1;
        }
        classFileWriter.add(ByteCode.GETSTATIC, this.mainClassName, "_k" + i2, getStaticConstantWrapperType(d2));
    }

    private static void addDoubleWrap(ClassFileWriter classFileWriter) {
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    private static String getStaticConstantWrapperType(double d2) {
        if (((int) d2) == d2) {
            return "Ljava/lang/Integer;";
        }
        return "Ljava/lang/Double;";
    }

    static void pushUndefined(ClassFileWriter classFileWriter) {
        classFileWriter.add(ByteCode.GETSTATIC, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }

    int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.getExisting(scriptNode);
    }

    String getDirectCtorName(ScriptNode scriptNode) {
        return "_n" + getIndex(scriptNode);
    }

    String getBodyMethodName(ScriptNode scriptNode) {
        return "_c_" + cleanName(scriptNode) + "_" + getIndex(scriptNode);
    }

    String cleanName(ScriptNode scriptNode) {
        if (scriptNode instanceof FunctionNode) {
            Name functionName = ((FunctionNode) scriptNode).getFunctionName();
            if (functionName == null) {
                return "anonymous";
            }
            return functionName.getIdentifier();
        }
        return "script";
    }

    String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.mainClassSignature);
        sb.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i = 0; i != paramCount; i++) {
                    sb.append("Ljava/lang/Object;D");
                }
            }
        }
        sb.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return sb.toString();
    }

    String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        return "_i" + getIndex(optFunctionNode.fnode);
    }

    String getCompiledRegexpName(ScriptNode scriptNode, int i) {
        return "_re" + getIndex(scriptNode) + "_" + i;
    }

    static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
