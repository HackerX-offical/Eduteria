package org.mozilla.classfile;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.UintMap;

/* JADX INFO: loaded from: classes10.dex */
public class ClassFileWriter {
    public static final short ACC_ABSTRACT = 1024;
    public static final short ACC_FINAL = 16;
    public static final short ACC_NATIVE = 256;
    public static final short ACC_PRIVATE = 2;
    public static final short ACC_PROTECTED = 4;
    public static final short ACC_PUBLIC = 1;
    public static final short ACC_STATIC = 8;
    public static final short ACC_SUPER = 32;
    public static final short ACC_SYNCHRONIZED = 32;
    public static final short ACC_TRANSIENT = 128;
    public static final short ACC_VOLATILE = 64;
    private static final boolean DEBUGCODE = false;
    private static final boolean DEBUGLABELS = false;
    private static final boolean DEBUGSTACK = false;
    private static final int ExceptionTableSize = 4;
    private static final int FileHeaderConstant = -889275714;
    private static final boolean GenerateStackMap;
    private static final int LineNumberTableSize = 16;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private static final int MajorVersion;
    private static final int MinorVersion;
    private static final int SuperBlockStartsSize = 4;
    private String generatedClassName;
    private ObjArray itsBootstrapMethods;
    private int itsCodeBufferTop;
    private ConstantPool itsConstantPool;
    private ClassFileMethod itsCurrentMethod;
    private ExceptionTableEntry[] itsExceptionTable;
    private int itsExceptionTableTop;
    private long[] itsFixupTable;
    private int itsFixupTableTop;
    private short itsFlags;
    private int[] itsLabelTable;
    private int itsLabelTableTop;
    private int[] itsLineNumberTable;
    private int itsLineNumberTableTop;
    private short itsMaxLocals;
    private short itsMaxStack;
    private short itsSourceFileNameIndex;
    private short itsStackTop;
    private short itsSuperClassIndex;
    private short itsThisClassIndex;
    private ObjArray itsVarDescriptors;
    private int[] itsSuperBlockStarts = null;
    private int itsSuperBlockStartsTop = 0;
    private UintMap itsJumpFroms = null;
    private byte[] itsCodeBuffer = new byte[256];
    private ObjArray itsMethods = new ObjArray();
    private ObjArray itsFields = new ObjArray();
    private ObjArray itsInterfaces = new ObjArray();
    private int itsBootstrapMethodsLength = 0;
    private char[] tmpCharBuffer = new char[64];

    static /* synthetic */ int access$410(ClassFileWriter classFileWriter) {
        int i = classFileWriter.itsExceptionTableTop;
        classFileWriter.itsExceptionTableTop = i - 1;
        return i;
    }

    public static class ClassFileFormatException extends RuntimeException {
        private static final long serialVersionUID = 1263998431033790599L;

        ClassFileFormatException(String str) {
            super(str);
        }
    }

    public ClassFileWriter(String str, String str2, String str3) {
        this.generatedClassName = str;
        ConstantPool constantPool = new ConstantPool(this);
        this.itsConstantPool = constantPool;
        this.itsThisClassIndex = constantPool.addClass(str);
        this.itsSuperClassIndex = this.itsConstantPool.addClass(str2);
        if (str3 != null) {
            this.itsSourceFileNameIndex = this.itsConstantPool.addUtf8(str3);
        }
        this.itsFlags = (short) 33;
    }

    public final String getClassName() {
        return this.generatedClassName;
    }

    public void addInterface(String str) {
        this.itsInterfaces.add(Short.valueOf(this.itsConstantPool.addClass(str)));
    }

    public void setFlags(short s) {
        this.itsFlags = s;
    }

    static String getSlashedForm(String str) {
        return str.replace('.', '/');
    }

    public static String classNameToSignature(String str) {
        int length = str.length();
        int i = length + 1;
        int i2 = length + 2;
        char[] cArr = new char[i2];
        cArr[0] = Matrix.MATRIX_TYPE_RANDOM_LT;
        cArr[i] = ';';
        str.getChars(0, length, cArr, 1);
        for (int i3 = 1; i3 != i; i3++) {
            if (cArr[i3] == '.') {
                cArr[i3] = '/';
            }
        }
        return new String(cArr, 0, i2);
    }

    public void addField(String str, String str2, short s) {
        this.itsFields.add(new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s));
    }

    public void addField(String str, String str2, short s, int i) {
        ClassFileField classFileField = new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s);
        classFileField.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short) 0, (short) 0, this.itsConstantPool.addConstant(i));
        this.itsFields.add(classFileField);
    }

    public void addField(String str, String str2, short s, long j) {
        ClassFileField classFileField = new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s);
        classFileField.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short) 0, (short) 2, this.itsConstantPool.addConstant(j));
        this.itsFields.add(classFileField);
    }

    public void addField(String str, String str2, short s, double d2) {
        ClassFileField classFileField = new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s);
        classFileField.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short) 0, (short) 2, this.itsConstantPool.addConstant(d2));
        this.itsFields.add(classFileField);
    }

    public void addVariableDescriptor(String str, String str2, int i, int i2) {
        int[] iArr = {this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), i, i2};
        if (this.itsVarDescriptors == null) {
            this.itsVarDescriptors = new ObjArray();
        }
        this.itsVarDescriptors.add(iArr);
    }

    public void startMethod(String str, String str2, short s) {
        this.itsCurrentMethod = new ClassFileMethod(str, this.itsConstantPool.addUtf8(str), str2, this.itsConstantPool.addUtf8(str2), s);
        this.itsJumpFroms = new UintMap();
        this.itsMethods.add(this.itsCurrentMethod);
        addSuperBlockStart(0);
    }

    public void stopMethod(short s) {
        StackMapTable stackMapTable;
        int iPutInt16;
        int iComputeWriteSize;
        if (this.itsCurrentMethod == null) {
            throw new IllegalStateException("No method to stop");
        }
        fixLabelGotos();
        this.itsMaxLocals = s;
        if (GenerateStackMap) {
            finalizeSuperBlockStarts();
            stackMapTable = new StackMapTable();
            stackMapTable.generate();
        } else {
            stackMapTable = null;
        }
        int i = this.itsLineNumberTable != null ? (this.itsLineNumberTableTop * 4) + 8 : 0;
        ObjArray objArray = this.itsVarDescriptors;
        int size = objArray != null ? (objArray.size() * 10) + 8 : 0;
        int i2 = (stackMapTable == null || (iComputeWriteSize = stackMapTable.computeWriteSize()) <= 0) ? 0 : iComputeWriteSize + 6;
        int i3 = this.itsCodeBufferTop + 16 + (this.itsExceptionTableTop * 8) + 2 + i + size + i2;
        if (i3 > 65536) {
            throw new ClassFileFormatException("generated bytecode for method exceeds 64K limit.");
        }
        byte[] bArr = new byte[i3];
        int iPutInt32 = putInt32(this.itsCodeBufferTop, bArr, putInt16(this.itsMaxLocals, bArr, putInt16(this.itsMaxStack, bArr, putInt32(i3 - 6, bArr, putInt16(this.itsConstantPool.addUtf8("Code"), bArr, 0)))));
        System.arraycopy(this.itsCodeBuffer, 0, bArr, iPutInt32, this.itsCodeBufferTop);
        int i4 = iPutInt32 + this.itsCodeBufferTop;
        int i5 = this.itsExceptionTableTop;
        if (i5 > 0) {
            iPutInt16 = putInt16(i5, bArr, i4);
            for (int i6 = 0; i6 < this.itsExceptionTableTop; i6++) {
                ExceptionTableEntry exceptionTableEntry = this.itsExceptionTable[i6];
                short labelPC = (short) getLabelPC(exceptionTableEntry.itsStartLabel);
                short labelPC2 = (short) getLabelPC(exceptionTableEntry.itsEndLabel);
                short labelPC3 = (short) getLabelPC(exceptionTableEntry.itsHandlerLabel);
                short s2 = exceptionTableEntry.itsCatchType;
                if (labelPC == -1) {
                    throw new IllegalStateException("start label not defined");
                }
                if (labelPC2 == -1) {
                    throw new IllegalStateException("end label not defined");
                }
                if (labelPC3 == -1) {
                    throw new IllegalStateException("handler label not defined");
                }
                iPutInt16 = putInt16(s2, bArr, putInt16(labelPC3, bArr, putInt16(labelPC2, bArr, putInt16(labelPC, bArr, iPutInt16))));
            }
        } else {
            iPutInt16 = putInt16(0, bArr, i4);
        }
        int i7 = this.itsLineNumberTable != null ? 1 : 0;
        if (this.itsVarDescriptors != null) {
            i7++;
        }
        if (i2 > 0) {
            i7++;
        }
        int iPutInt162 = putInt16(i7, bArr, iPutInt16);
        if (this.itsLineNumberTable != null) {
            iPutInt162 = putInt16(this.itsLineNumberTableTop, bArr, putInt32((this.itsLineNumberTableTop * 4) + 2, bArr, putInt16(this.itsConstantPool.addUtf8("LineNumberTable"), bArr, iPutInt162)));
            for (int i8 = 0; i8 < this.itsLineNumberTableTop; i8++) {
                iPutInt162 = putInt32(this.itsLineNumberTable[i8], bArr, iPutInt162);
            }
        }
        if (this.itsVarDescriptors != null) {
            int iPutInt163 = putInt16(this.itsConstantPool.addUtf8("LocalVariableTable"), bArr, iPutInt162);
            int size2 = this.itsVarDescriptors.size();
            iPutInt162 = putInt16(size2, bArr, putInt32((size2 * 10) + 2, bArr, iPutInt163));
            for (int i9 = 0; i9 < size2; i9++) {
                int[] iArr = (int[]) this.itsVarDescriptors.get(i9);
                int i10 = iArr[0];
                int i11 = iArr[1];
                int i12 = iArr[2];
                iPutInt162 = putInt16(iArr[3], bArr, putInt16(i11, bArr, putInt16(i10, bArr, putInt16(this.itsCodeBufferTop - i12, bArr, putInt16(i12, bArr, iPutInt162)))));
            }
        }
        if (i2 > 0) {
            stackMapTable.write(bArr, putInt16(this.itsConstantPool.addUtf8("StackMapTable"), bArr, iPutInt162));
        }
        this.itsCurrentMethod.setCodeAttribute(bArr);
        this.itsExceptionTable = null;
        this.itsExceptionTableTop = 0;
        this.itsLineNumberTableTop = 0;
        this.itsCodeBufferTop = 0;
        this.itsCurrentMethod = null;
        this.itsMaxStack = (short) 0;
        this.itsStackTop = (short) 0;
        this.itsLabelTableTop = 0;
        this.itsFixupTableTop = 0;
        this.itsVarDescriptors = null;
        this.itsSuperBlockStarts = null;
        this.itsSuperBlockStartsTop = 0;
        this.itsJumpFroms = null;
    }

    public void add(int i) {
        if (opcodeCount(i) != 0) {
            throw new IllegalArgumentException("Unexpected operands");
        }
        int iStackChange = this.itsStackTop + stackChange(i);
        if (iStackChange < 0 || 32767 < iStackChange) {
            badStack(iStackChange);
        }
        addToCodeBuffer(i);
        short s = (short) iStackChange;
        this.itsStackTop = s;
        if (iStackChange > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
        if (i == 191) {
            addSuperBlockStart(this.itsCodeBufferTop);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void add(int r6, int r7) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.add(int, int):void");
    }

    public void addLoadConstant(int i) {
        if (i == 0) {
            add(3);
            return;
        }
        if (i == 1) {
            add(4);
            return;
        }
        if (i == 2) {
            add(5);
            return;
        }
        if (i == 3) {
            add(6);
            return;
        }
        if (i == 4) {
            add(7);
        } else if (i == 5) {
            add(8);
        } else {
            add(18, this.itsConstantPool.addConstant(i));
        }
    }

    public void addLoadConstant(long j) {
        add(20, this.itsConstantPool.addConstant(j));
    }

    public void addLoadConstant(float f2) {
        add(18, this.itsConstantPool.addConstant(f2));
    }

    public void addLoadConstant(double d2) {
        add(20, this.itsConstantPool.addConstant(d2));
    }

    public void addLoadConstant(String str) {
        add(18, this.itsConstantPool.addConstant(str));
    }

    public void add(int i, int i2, int i3) {
        int iStackChange = this.itsStackTop + stackChange(i);
        if (iStackChange < 0 || 32767 < iStackChange) {
            badStack(iStackChange);
        }
        if (i == 132) {
            if (i2 < 0 || i2 >= 65536) {
                throw new ClassFileFormatException("out of range variable");
            }
            if (i3 < 0 || i3 >= 65536) {
                throw new ClassFileFormatException("out of range increment");
            }
            if (i2 > 255 || i3 < -128 || i3 > 127) {
                addToCodeBuffer(ByteCode.WIDE);
                addToCodeBuffer(132);
                addToCodeInt16(i2);
                addToCodeInt16(i3);
            } else {
                addToCodeBuffer(132);
                addToCodeBuffer(i2);
                addToCodeBuffer(i3);
            }
        } else {
            if (i != 197) {
                throw new IllegalArgumentException("Unexpected opcode for 2 operands");
            }
            if (i2 < 0 || i2 >= 65536) {
                throw new IllegalArgumentException("out of range index");
            }
            if (i3 < 0 || i3 >= 256) {
                throw new IllegalArgumentException("out of range dimensions");
            }
            addToCodeBuffer(ByteCode.MULTIANEWARRAY);
            addToCodeInt16(i2);
            addToCodeBuffer(i3);
        }
        short s = (short) iStackChange;
        this.itsStackTop = s;
        if (iStackChange > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    public void add(int i, String str) {
        int iStackChange = this.itsStackTop + stackChange(i);
        if (iStackChange < 0 || 32767 < iStackChange) {
            badStack(iStackChange);
        }
        if (i == 187 || i == 189 || i == 192 || i == 193) {
            short sAddClass = this.itsConstantPool.addClass(str);
            addToCodeBuffer(i);
            addToCodeInt16(sAddClass);
            short s = (short) iStackChange;
            this.itsStackTop = s;
            if (iStackChange > this.itsMaxStack) {
                this.itsMaxStack = s;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("bad opcode for class reference");
    }

    public void add(int i, String str, String str2, String str3) {
        int i2;
        int iStackChange = this.itsStackTop + stackChange(i);
        char cCharAt = str3.charAt(0);
        int i3 = (cCharAt == 'J' || cCharAt == 'D') ? 2 : 1;
        switch (i) {
            case ByteCode.GETSTATIC /* 178 */:
            case 180:
                i2 = iStackChange + i3;
                break;
            case ByteCode.PUTSTATIC /* 179 */:
            case ByteCode.PUTFIELD /* 181 */:
                i2 = iStackChange - i3;
                break;
            default:
                throw new IllegalArgumentException("bad opcode for field reference");
        }
        if (i2 < 0 || 32767 < i2) {
            badStack(i2);
        }
        short sAddFieldRef = this.itsConstantPool.addFieldRef(str, str2, str3);
        addToCodeBuffer(i);
        addToCodeInt16(sAddFieldRef);
        short s = (short) i2;
        this.itsStackTop = s;
        if (i2 > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    public void addInvoke(int i, String str, String str2, String str3) {
        int iSizeOfParameters = sizeOfParameters(str3);
        int i2 = iSizeOfParameters >>> 16;
        int iStackChange = this.itsStackTop + ((short) iSizeOfParameters) + stackChange(i);
        if (iStackChange < 0 || 32767 < iStackChange) {
            badStack(iStackChange);
        }
        switch (i) {
            case ByteCode.INVOKEVIRTUAL /* 182 */:
            case ByteCode.INVOKESPECIAL /* 183 */:
            case ByteCode.INVOKESTATIC /* 184 */:
            case ByteCode.INVOKEINTERFACE /* 185 */:
                addToCodeBuffer(i);
                if (i == 185) {
                    addToCodeInt16(this.itsConstantPool.addInterfaceMethodRef(str, str2, str3));
                    addToCodeBuffer(i2 + 1);
                    addToCodeBuffer(0);
                } else {
                    addToCodeInt16(this.itsConstantPool.addMethodRef(str, str2, str3));
                }
                short s = (short) iStackChange;
                this.itsStackTop = s;
                if (iStackChange > this.itsMaxStack) {
                    this.itsMaxStack = s;
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("bad opcode for method reference");
        }
    }

    public void addInvokeDynamic(String str, String str2, MHandle mHandle, Object... objArr) {
        if (MajorVersion < 51) {
            throw new RuntimeException("Please build and run with JDK 1.7 for invokedynamic support");
        }
        int iSizeOfParameters = this.itsStackTop + ((short) sizeOfParameters(str2));
        if (iSizeOfParameters < 0 || 32767 < iSizeOfParameters) {
            badStack(iSizeOfParameters);
        }
        BootstrapEntry bootstrapEntry = new BootstrapEntry(mHandle, objArr);
        if (this.itsBootstrapMethods == null) {
            this.itsBootstrapMethods = new ObjArray();
        }
        int iIndexOf = this.itsBootstrapMethods.indexOf(bootstrapEntry);
        if (iIndexOf == -1) {
            iIndexOf = this.itsBootstrapMethods.size();
            this.itsBootstrapMethods.add(bootstrapEntry);
            this.itsBootstrapMethodsLength += bootstrapEntry.code.length;
        }
        short sAddInvokeDynamic = this.itsConstantPool.addInvokeDynamic(str, str2, iIndexOf);
        addToCodeBuffer(ByteCode.INVOKEDYNAMIC);
        addToCodeInt16(sAddInvokeDynamic);
        addToCodeInt16(0);
        short s = (short) iSizeOfParameters;
        this.itsStackTop = s;
        if (iSizeOfParameters > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    public void addPush(int i) {
        byte b2 = (byte) i;
        if (b2 != i) {
            short s = (short) i;
            if (s == i) {
                add(17, s);
                return;
            } else {
                addLoadConstant(i);
                return;
            }
        }
        if (i == -1) {
            add(2);
        } else if (i >= 0 && i <= 5) {
            add((byte) (i + 3));
        } else {
            add(16, b2);
        }
    }

    public void addPush(boolean z) {
        add(z ? 4 : 3);
    }

    public void addPush(long j) {
        int i = (int) j;
        if (i == j) {
            addPush(i);
            add(133);
        } else {
            addLoadConstant(j);
        }
    }

    public void addPush(double d2) {
        if (d2 == 0.0d) {
            add(14);
            if (1.0d / d2 < 0.0d) {
                add(119);
                return;
            }
            return;
        }
        if (d2 == 1.0d || d2 == -1.0d) {
            add(15);
            if (d2 < 0.0d) {
                add(119);
                return;
            }
            return;
        }
        addLoadConstant(d2);
    }

    public void addPush(String str) {
        int length = str.length();
        int i = 0;
        int utfEncodingLimit = this.itsConstantPool.getUtfEncodingLimit(str, 0, length);
        if (utfEncodingLimit == length) {
            addLoadConstant(str);
            return;
        }
        add(ByteCode.NEW, "java/lang/StringBuilder");
        add(89);
        addPush(length);
        addInvoke(ByteCode.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(I)V");
        while (true) {
            add(89);
            addLoadConstant(str.substring(i, utfEncodingLimit));
            addInvoke(ByteCode.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            add(87);
            if (utfEncodingLimit == length) {
                addInvoke(ByteCode.INVOKEVIRTUAL, "java/lang/StringBuilder", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;");
                return;
            } else {
                i = utfEncodingLimit;
                utfEncodingLimit = this.itsConstantPool.getUtfEncodingLimit(str, utfEncodingLimit, length);
            }
        }
    }

    public boolean isUnderStringSizeLimit(String str) {
        return this.itsConstantPool.isUnderUtfEncodingLimit(str);
    }

    public void addIStore(int i) {
        xop(59, 54, i);
    }

    public void addLStore(int i) {
        xop(63, 55, i);
    }

    public void addFStore(int i) {
        xop(67, 56, i);
    }

    public void addDStore(int i) {
        xop(71, 57, i);
    }

    public void addAStore(int i) {
        xop(75, 58, i);
    }

    public void addILoad(int i) {
        xop(26, 21, i);
    }

    public void addLLoad(int i) {
        xop(30, 22, i);
    }

    public void addFLoad(int i) {
        xop(34, 23, i);
    }

    public void addDLoad(int i) {
        xop(38, 24, i);
    }

    public void addALoad(int i) {
        xop(42, 25, i);
    }

    public void addLoadThis() {
        add(42);
    }

    private void xop(int i, int i2, int i3) {
        if (i3 == 0) {
            add(i);
            return;
        }
        if (i3 == 1) {
            add(i + 1);
            return;
        }
        if (i3 == 2) {
            add(i + 2);
        } else if (i3 == 3) {
            add(i + 3);
        } else {
            add(i2, i3);
        }
    }

    public int addTableSwitch(int i, int i2) {
        if (i > i2) {
            throw new ClassFileFormatException("Bad bounds: " + i + ' ' + i2);
        }
        int iStackChange = this.itsStackTop + stackChange(170);
        if (iStackChange < 0 || 32767 < iStackChange) {
            badStack(iStackChange);
        }
        int i3 = (~this.itsCodeBufferTop) & 3;
        int iAddReservedCodeSpace = addReservedCodeSpace(i3 + 1 + (((i2 - i) + 4) * 4));
        int i4 = iAddReservedCodeSpace + 1;
        this.itsCodeBuffer[iAddReservedCodeSpace] = -86;
        while (i3 != 0) {
            this.itsCodeBuffer[i4] = 0;
            i3--;
            i4++;
        }
        putInt32(i2, this.itsCodeBuffer, putInt32(i, this.itsCodeBuffer, i4 + 4));
        short s = (short) iStackChange;
        this.itsStackTop = s;
        if (iStackChange > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
        return iAddReservedCodeSpace;
    }

    public final void markTableSwitchDefault(int i) {
        addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, i);
        setTableSwitchJump(i, -1, this.itsCodeBufferTop);
    }

    public final void markTableSwitchCase(int i, int i2) {
        addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, i);
        setTableSwitchJump(i, i2, this.itsCodeBufferTop);
    }

    public final void markTableSwitchCase(int i, int i2, int i3) {
        if (i3 < 0 || i3 > this.itsMaxStack) {
            throw new IllegalArgumentException("Bad stack index: " + i3);
        }
        this.itsStackTop = (short) i3;
        addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, i);
        setTableSwitchJump(i, i2, this.itsCodeBufferTop);
    }

    public void setTableSwitchJump(int i, int i2, int i3) {
        int i4;
        if (i3 < 0 || i3 > (i4 = this.itsCodeBufferTop)) {
            throw new IllegalArgumentException("Bad jump target: " + i3);
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("Bad case index: " + i2);
        }
        int i5 = (~i) & 3;
        int i6 = i2 < 0 ? i + 1 + i5 : i + 1 + i5 + ((i2 + 3) * 4);
        if (i < 0 || i > ((i4 - 16) - i5) - 1) {
            throw new IllegalArgumentException(i + " is outside a possible range of tableswitch in already generated code");
        }
        byte[] bArr = this.itsCodeBuffer;
        if ((bArr[i] & 255) != 170) {
            throw new IllegalArgumentException(i + " is not offset of tableswitch statement");
        }
        if (i6 < 0 || i6 + 4 > i4) {
            throw new ClassFileFormatException("Too big case index: " + i2);
        }
        putInt32(i3 - i, bArr, i6);
    }

    public int acquireLabel() {
        int i = this.itsLabelTableTop;
        int[] iArr = this.itsLabelTable;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.itsLabelTable = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.itsLabelTable = iArr2;
            }
        }
        this.itsLabelTableTop = i + 1;
        this.itsLabelTable[i] = -1;
        return i | Integer.MIN_VALUE;
    }

    public void markLabel(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 > this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        int[] iArr = this.itsLabelTable;
        if (iArr[i2] != -1) {
            throw new IllegalStateException("Can only mark label once");
        }
        iArr[i2] = this.itsCodeBufferTop;
    }

    public void markLabel(int i, short s) {
        markLabel(i);
        this.itsStackTop = s;
    }

    public void markHandler(int i) {
        this.itsStackTop = (short) 1;
        markLabel(i);
    }

    public int getLabelPC(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 >= this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        return this.itsLabelTable[i2];
    }

    private void addLabelFixup(int i, int i2) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i3 = i & Integer.MAX_VALUE;
        if (i3 >= this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        int i4 = this.itsFixupTableTop;
        long[] jArr = this.itsFixupTable;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.itsFixupTable = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.itsFixupTable = jArr2;
            }
        }
        this.itsFixupTableTop = i4 + 1;
        this.itsFixupTable[i4] = ((long) i2) | (((long) i3) << 32);
    }

    private void fixLabelGotos() {
        byte[] bArr = this.itsCodeBuffer;
        for (int i = 0; i < this.itsFixupTableTop; i++) {
            long j = this.itsFixupTable[i];
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            int i4 = this.itsLabelTable[i2];
            if (i4 == -1) {
                throw new RuntimeException();
            }
            addSuperBlockStart(i4);
            int i5 = i3 - 1;
            this.itsJumpFroms.put(i4, i5);
            int i6 = i4 - i5;
            if (((short) i6) != i6) {
                throw new ClassFileFormatException("Program too complex: too big jump offset");
            }
            bArr[i3] = (byte) (i6 >> 8);
            bArr[i3 + 1] = (byte) i6;
        }
        this.itsFixupTableTop = 0;
    }

    public int getCurrentCodeOffset() {
        return this.itsCodeBufferTop;
    }

    public short getStackTop() {
        return this.itsStackTop;
    }

    public void setStackTop(short s) {
        this.itsStackTop = s;
    }

    public void adjustStackTop(int i) {
        int i2 = this.itsStackTop + i;
        if (i2 < 0 || 32767 < i2) {
            badStack(i2);
        }
        short s = (short) i2;
        this.itsStackTop = s;
        if (i2 > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    private void addToCodeBuffer(int i) {
        this.itsCodeBuffer[addReservedCodeSpace(1)] = (byte) i;
    }

    private void addToCodeInt16(int i) {
        putInt16(i, this.itsCodeBuffer, addReservedCodeSpace(2));
    }

    private int addReservedCodeSpace(int i) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalArgumentException("No method to add to");
        }
        int i2 = this.itsCodeBufferTop;
        int i3 = i + i2;
        byte[] bArr = this.itsCodeBuffer;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 > length) {
                length = i3;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.itsCodeBuffer = bArr2;
        }
        this.itsCodeBufferTop = i3;
        return i2;
    }

    public void addExceptionHandler(int i, int i2, int i3, String str) {
        if ((i & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad startLabel");
        }
        if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad endLabel");
        }
        if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad handlerLabel");
        }
        ExceptionTableEntry exceptionTableEntry = new ExceptionTableEntry(i, i2, i3, str == null ? (short) 0 : this.itsConstantPool.addClass(str));
        int i4 = this.itsExceptionTableTop;
        if (i4 == 0) {
            this.itsExceptionTable = new ExceptionTableEntry[4];
        } else {
            ExceptionTableEntry[] exceptionTableEntryArr = this.itsExceptionTable;
            if (i4 == exceptionTableEntryArr.length) {
                ExceptionTableEntry[] exceptionTableEntryArr2 = new ExceptionTableEntry[i4 * 2];
                System.arraycopy(exceptionTableEntryArr, 0, exceptionTableEntryArr2, 0, i4);
                this.itsExceptionTable = exceptionTableEntryArr2;
            }
        }
        this.itsExceptionTable[i4] = exceptionTableEntry;
        this.itsExceptionTableTop = i4 + 1;
    }

    public void addLineNumberEntry(short s) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalArgumentException("No method to stop");
        }
        int i = this.itsLineNumberTableTop;
        if (i == 0) {
            this.itsLineNumberTable = new int[16];
        } else {
            int[] iArr = this.itsLineNumberTable;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.itsLineNumberTable = iArr2;
            }
        }
        this.itsLineNumberTable[i] = (this.itsCodeBufferTop << 16) + s;
        this.itsLineNumberTableTop = i + 1;
    }

    final class StackMapTable {
        static final boolean DEBUGSTACKMAP = false;
        private SuperBlock[] superBlockDeps;
        private SuperBlock[] superBlocks = null;
        private int[] stack = null;
        private int[] locals = null;
        private SuperBlock[] workList = null;
        private byte[] rawStackMap = null;
        private int localsTop = 0;
        private int stackTop = 0;
        private int workListTop = 0;
        private int rawStackMapTop = 0;
        private boolean wide = false;

        private boolean isBranch(int i) {
            switch (i) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case ByteCode.GOTO /* 167 */:
                    return true;
                default:
                    switch (i) {
                        case ByteCode.IFNULL /* 198 */:
                        case ByteCode.IFNONNULL /* 199 */:
                        case 200:
                            return true;
                        default:
                            return false;
                    }
            }
        }

        private boolean isSuperBlockEnd(int i) {
            if (i == 167 || i == 191 || i == 200 || i == 176 || i == 177) {
                return true;
            }
            switch (i) {
                case 170:
                case ByteCode.LOOKUPSWITCH /* 171 */:
                case 172:
                case ByteCode.LRETURN /* 173 */:
                case ByteCode.FRETURN /* 174 */:
                    return true;
                default:
                    return false;
            }
        }

        StackMapTable() {
        }

        void generate() {
            this.superBlocks = new SuperBlock[ClassFileWriter.this.itsSuperBlockStartsTop];
            int[] iArrCreateInitialLocals = ClassFileWriter.this.createInitialLocals();
            int i = 0;
            while (i < ClassFileWriter.this.itsSuperBlockStartsTop) {
                this.superBlocks[i] = new SuperBlock(i, ClassFileWriter.this.itsSuperBlockStarts[i], i == ClassFileWriter.this.itsSuperBlockStartsTop + (-1) ? ClassFileWriter.this.itsCodeBufferTop : ClassFileWriter.this.itsSuperBlockStarts[i + 1], iArrCreateInitialLocals);
                i++;
            }
            this.superBlockDeps = getSuperBlockDependencies();
            verify();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            throw new java.lang.IllegalArgumentException("bad offset: " + r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private org.mozilla.classfile.SuperBlock getSuperBlockFromOffset(int r4) {
            /*
                r3 = this;
                r0 = 0
            L1:
                org.mozilla.classfile.SuperBlock[] r1 = r3.superBlocks
                int r2 = r1.length
                if (r0 >= r2) goto L1a
                r1 = r1[r0]
                if (r1 == 0) goto L1a
                int r2 = r1.getStart()
                if (r4 < r2) goto L17
                int r2 = r1.getEnd()
                if (r4 >= r2) goto L17
                return r1
            L17:
                int r0 = r0 + 1
                goto L1
            L1a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "bad offset: "
                r1.<init>(r2)
                java.lang.StringBuilder r4 = r1.append(r4)
                java.lang.String r4 = r4.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.StackMapTable.getSuperBlockFromOffset(int):org.mozilla.classfile.SuperBlock");
        }

        private SuperBlock[] getSuperBlockDependencies() {
            SuperBlock[] superBlockArr = new SuperBlock[this.superBlocks.length];
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; i++) {
                ExceptionTableEntry exceptionTableEntry = ClassFileWriter.this.itsExceptionTable[i];
                superBlockArr[getSuperBlockFromOffset((short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsHandlerLabel)).getIndex()] = getSuperBlockFromOffset((short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsStartLabel));
            }
            for (int i2 : ClassFileWriter.this.itsJumpFroms.getKeys()) {
                superBlockArr[getSuperBlockFromOffset(i2).getIndex()] = getSuperBlockFromOffset(ClassFileWriter.this.itsJumpFroms.getInt(i2, -1));
            }
            return superBlockArr;
        }

        private SuperBlock getBranchTarget(int i) {
            int operand;
            if ((ClassFileWriter.this.itsCodeBuffer[i] & 255) == 200) {
                operand = getOperand(i + 1, 4);
            } else {
                operand = (short) getOperand(i + 1, 2);
            }
            return getSuperBlockFromOffset(i + operand);
        }

        private int getOperand(int i) {
            return getOperand(i, 1);
        }

        private int getOperand(int i, int i2) {
            if (i2 > 4) {
                throw new IllegalArgumentException("bad operand size");
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = (i3 << 8) | (ClassFileWriter.this.itsCodeBuffer[i + i4] & 255);
            }
            return i3;
        }

        private void verify() {
            int[] iArrCreateInitialLocals = ClassFileWriter.this.createInitialLocals();
            int i = 0;
            this.superBlocks[0].merge(iArrCreateInitialLocals, iArrCreateInitialLocals.length, new int[0], 0, ClassFileWriter.this.itsConstantPool);
            this.workList = new SuperBlock[]{this.superBlocks[0]};
            this.workListTop = 1;
            executeWorkList();
            while (true) {
                SuperBlock[] superBlockArr = this.superBlocks;
                if (i < superBlockArr.length) {
                    SuperBlock superBlock = superBlockArr[i];
                    if (!superBlock.isInitialized()) {
                        killSuperBlock(superBlock);
                    }
                    i++;
                } else {
                    executeWorkList();
                    return;
                }
            }
        }

        private void killSuperBlock(SuperBlock superBlock) {
            int[] locals = new int[0];
            int[] iArr = {TypeInfo.OBJECT("java/lang/Throwable", ClassFileWriter.this.itsConstantPool)};
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; i++) {
                ExceptionTableEntry exceptionTableEntry = ClassFileWriter.this.itsExceptionTable[i];
                int labelPC = ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsStartLabel);
                int labelPC2 = ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsEndLabel);
                SuperBlock superBlockFromOffset = getSuperBlockFromOffset(ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsHandlerLabel));
                if ((superBlock.getStart() > labelPC && superBlock.getStart() < labelPC2) || (labelPC > superBlock.getStart() && labelPC < superBlock.getEnd() && superBlockFromOffset.isInitialized())) {
                    locals = superBlockFromOffset.getLocals();
                    break;
                }
            }
            int[] iArr2 = locals;
            int i2 = 0;
            while (i2 < ClassFileWriter.this.itsExceptionTableTop) {
                if (ClassFileWriter.this.getLabelPC(ClassFileWriter.this.itsExceptionTable[i2].itsStartLabel) == superBlock.getStart()) {
                    for (int i3 = i2 + 1; i3 < ClassFileWriter.this.itsExceptionTableTop; i3++) {
                        ClassFileWriter.this.itsExceptionTable[i3 - 1] = ClassFileWriter.this.itsExceptionTable[i3];
                    }
                    ClassFileWriter.access$410(ClassFileWriter.this);
                    i2--;
                }
                i2++;
            }
            superBlock.merge(iArr2, iArr2.length, iArr, 1, ClassFileWriter.this.itsConstantPool);
            int end = superBlock.getEnd() - 1;
            ClassFileWriter.this.itsCodeBuffer[end] = -65;
            for (int start = superBlock.getStart(); start < end; start++) {
                ClassFileWriter.this.itsCodeBuffer[start] = 0;
            }
        }

        private void executeWorkList() {
            while (true) {
                int i = this.workListTop;
                if (i <= 0) {
                    return;
                }
                SuperBlock[] superBlockArr = this.workList;
                int i2 = i - 1;
                this.workListTop = i2;
                SuperBlock superBlock = superBlockArr[i2];
                superBlock.setInQueue(false);
                this.locals = superBlock.getLocals();
                int[] stack = superBlock.getStack();
                this.stack = stack;
                this.localsTop = this.locals.length;
                this.stackTop = stack.length;
                executeBlock(superBlock);
            }
        }

        private void executeBlock(SuperBlock superBlock) {
            int iOBJECT;
            int start = superBlock.getStart();
            int i = 0;
            while (start < superBlock.getEnd()) {
                i = ClassFileWriter.this.itsCodeBuffer[start] & 255;
                int iExecute = execute(start);
                if (isBranch(i)) {
                    flowInto(getBranchTarget(start));
                } else if (i == 170) {
                    int i2 = start + 1 + ((~start) & 3);
                    flowInto(getSuperBlockFromOffset(getOperand(i2, 4) + start));
                    int operand = (getOperand(i2 + 8, 4) - getOperand(i2 + 4, 4)) + 1;
                    int i3 = i2 + 12;
                    for (int i4 = 0; i4 < operand; i4++) {
                        flowInto(getSuperBlockFromOffset(getOperand((i4 * 4) + i3, 4) + start));
                    }
                }
                for (int i5 = 0; i5 < ClassFileWriter.this.itsExceptionTableTop; i5++) {
                    ExceptionTableEntry exceptionTableEntry = ClassFileWriter.this.itsExceptionTable[i5];
                    short labelPC = (short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsStartLabel);
                    short labelPC2 = (short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsEndLabel);
                    if (start >= labelPC && start < labelPC2) {
                        SuperBlock superBlockFromOffset = getSuperBlockFromOffset((short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsHandlerLabel));
                        if (exceptionTableEntry.itsCatchType == 0) {
                            iOBJECT = TypeInfo.OBJECT(ClassFileWriter.this.itsConstantPool.addClass("java/lang/Throwable"));
                        } else {
                            iOBJECT = TypeInfo.OBJECT(exceptionTableEntry.itsCatchType);
                        }
                        superBlockFromOffset.merge(this.locals, this.localsTop, new int[]{iOBJECT}, 1, ClassFileWriter.this.itsConstantPool);
                        addToWorkList(superBlockFromOffset);
                    }
                }
                start += iExecute;
            }
            if (isSuperBlockEnd(i)) {
                return;
            }
            int index = superBlock.getIndex() + 1;
            SuperBlock[] superBlockArr = this.superBlocks;
            if (index < superBlockArr.length) {
                flowInto(superBlockArr[index]);
            }
        }

        private void flowInto(SuperBlock superBlock) {
            if (superBlock.merge(this.locals, this.localsTop, this.stack, this.stackTop, ClassFileWriter.this.itsConstantPool)) {
                addToWorkList(superBlock);
            }
        }

        private void addToWorkList(SuperBlock superBlock) {
            if (superBlock.isInQueue()) {
                return;
            }
            superBlock.setInQueue(true);
            superBlock.setInitialized(true);
            int i = this.workListTop;
            SuperBlock[] superBlockArr = this.workList;
            if (i == superBlockArr.length) {
                SuperBlock[] superBlockArr2 = new SuperBlock[i * 2];
                System.arraycopy(superBlockArr, 0, superBlockArr2, 0, i);
                this.workList = superBlockArr2;
            }
            SuperBlock[] superBlockArr3 = this.workList;
            int i2 = this.workListTop;
            this.workListTop = i2 + 1;
            superBlockArr3[i2] = superBlock;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:121:0x03a7  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x03b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int execute(int r12) {
            /*
                Method dump skipped, instruction units count: 1358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.StackMapTable.execute(int):int");
        }

        private void executeALoad(int i) {
            int local = getLocal(i);
            int tag = TypeInfo.getTag(local);
            if (tag == 7 || tag == 6 || tag == 8 || tag == 5) {
                push(local);
                return;
            }
            throw new IllegalStateException("bad local variable type: " + local + " at index: " + i);
        }

        private void executeAStore(int i) {
            setLocal(i, pop());
        }

        private void executeStore(int i, int i2) {
            pop();
            setLocal(i, i2);
        }

        private void initializeTypeInfo(int i, int i2) {
            initializeTypeInfo(i, i2, this.locals, this.localsTop);
            initializeTypeInfo(i, i2, this.stack, this.stackTop);
        }

        private void initializeTypeInfo(int i, int i2, int[] iArr, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (iArr[i4] == i) {
                    iArr[i4] = i2;
                }
            }
        }

        private int getLocal(int i) {
            if (i < this.localsTop) {
                return this.locals[i];
            }
            return 0;
        }

        private void setLocal(int i, int i2) {
            int i3 = this.localsTop;
            if (i >= i3) {
                int i4 = i + 1;
                int[] iArr = new int[i4];
                System.arraycopy(this.locals, 0, iArr, 0, i3);
                this.locals = iArr;
                this.localsTop = i4;
            }
            this.locals[i] = i2;
        }

        private void push(int i) {
            int i2 = this.stackTop;
            if (i2 == this.stack.length) {
                int[] iArr = new int[Math.max(i2 * 2, 4)];
                System.arraycopy(this.stack, 0, iArr, 0, this.stackTop);
                this.stack = iArr;
            }
            int[] iArr2 = this.stack;
            int i3 = this.stackTop;
            this.stackTop = i3 + 1;
            iArr2[i3] = i;
        }

        private int pop() {
            int[] iArr = this.stack;
            int i = this.stackTop - 1;
            this.stackTop = i;
            return iArr[i];
        }

        private void push2(long j) {
            push((int) (j & 16777215));
            long j2 = j >>> 32;
            if (j2 != 0) {
                push((int) (j2 & 16777215));
            }
        }

        private long pop2() {
            long jPop = pop();
            return TypeInfo.isTwoWords((int) jPop) ? jPop : (jPop << 32) | ((long) (pop() & 16777215));
        }

        private void clearStack() {
            this.stackTop = 0;
        }

        int computeWriteSize() {
            this.rawStackMap = new byte[getWorstCaseWriteSize()];
            computeRawStackMap();
            return this.rawStackMapTop + 2;
        }

        int write(byte[] bArr, int i) {
            int iPutInt16 = ClassFileWriter.putInt16(this.superBlocks.length - 1, bArr, ClassFileWriter.putInt32(this.rawStackMapTop + 2, bArr, i));
            System.arraycopy(this.rawStackMap, 0, bArr, iPutInt16, this.rawStackMapTop);
            return iPutInt16 + this.rawStackMapTop;
        }

        private void computeRawStackMap() {
            int[] trimmedLocals = this.superBlocks[0].getTrimmedLocals();
            int start = -1;
            int i = 1;
            while (true) {
                SuperBlock[] superBlockArr = this.superBlocks;
                if (i >= superBlockArr.length) {
                    return;
                }
                SuperBlock superBlock = superBlockArr[i];
                int[] trimmedLocals2 = superBlock.getTrimmedLocals();
                int[] stack = superBlock.getStack();
                int start2 = (superBlock.getStart() - start) - 1;
                if (stack.length == 0) {
                    int length = trimmedLocals.length > trimmedLocals2.length ? trimmedLocals2.length : trimmedLocals.length;
                    int iAbs = Math.abs(trimmedLocals.length - trimmedLocals2.length);
                    int i2 = 0;
                    while (i2 < length && trimmedLocals[i2] == trimmedLocals2[i2]) {
                        i2++;
                    }
                    if (i2 == trimmedLocals2.length && iAbs == 0) {
                        writeSameFrame(trimmedLocals2, start2);
                    } else if (i2 == trimmedLocals2.length && iAbs <= 3) {
                        writeChopFrame(iAbs, start2);
                    } else if (i2 == trimmedLocals.length && iAbs <= 3) {
                        writeAppendFrame(trimmedLocals2, iAbs, start2);
                    } else {
                        writeFullFrame(trimmedLocals2, stack, start2);
                    }
                } else if (stack.length == 1) {
                    if (Arrays.equals(trimmedLocals, trimmedLocals2)) {
                        writeSameLocalsOneStackItemFrame(trimmedLocals2, stack, start2);
                    } else {
                        writeFullFrame(trimmedLocals2, stack, start2);
                    }
                } else {
                    writeFullFrame(trimmedLocals2, stack, start2);
                }
                start = superBlock.getStart();
                i++;
                trimmedLocals = trimmedLocals2;
            }
        }

        private int getWorstCaseWriteSize() {
            return (this.superBlocks.length - 1) * ((ClassFileWriter.this.itsMaxLocals * 3) + 7 + (ClassFileWriter.this.itsMaxStack * 3));
        }

        private void writeSameFrame(int[] iArr, int i) {
            if (i <= 63) {
                byte[] bArr = this.rawStackMap;
                int i2 = this.rawStackMapTop;
                this.rawStackMapTop = i2 + 1;
                bArr[i2] = (byte) i;
                return;
            }
            byte[] bArr2 = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr2[i3] = -5;
            this.rawStackMapTop = ClassFileWriter.putInt16(i, bArr2, i4);
        }

        private void writeSameLocalsOneStackItemFrame(int[] iArr, int[] iArr2, int i) {
            if (i <= 63) {
                byte[] bArr = this.rawStackMap;
                int i2 = this.rawStackMapTop;
                this.rawStackMapTop = i2 + 1;
                bArr[i2] = (byte) (i + 64);
            } else {
                byte[] bArr2 = this.rawStackMap;
                int i3 = this.rawStackMapTop;
                int i4 = i3 + 1;
                this.rawStackMapTop = i4;
                bArr2[i3] = -9;
                this.rawStackMapTop = ClassFileWriter.putInt16(i, bArr2, i4);
            }
            writeType(iArr2[0]);
        }

        private void writeFullFrame(int[] iArr, int[] iArr2, int i) {
            byte[] bArr = this.rawStackMap;
            int i2 = this.rawStackMapTop;
            int i3 = i2 + 1;
            this.rawStackMapTop = i3;
            bArr[i2] = -1;
            int iPutInt16 = ClassFileWriter.putInt16(i, bArr, i3);
            this.rawStackMapTop = iPutInt16;
            this.rawStackMapTop = ClassFileWriter.putInt16(iArr.length, this.rawStackMap, iPutInt16);
            int iWriteTypes = writeTypes(iArr);
            this.rawStackMapTop = iWriteTypes;
            this.rawStackMapTop = ClassFileWriter.putInt16(iArr2.length, this.rawStackMap, iWriteTypes);
            this.rawStackMapTop = writeTypes(iArr2);
        }

        private void writeAppendFrame(int[] iArr, int i, int i2) {
            int length = iArr.length - i;
            byte[] bArr = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr[i3] = (byte) (i + 251);
            this.rawStackMapTop = ClassFileWriter.putInt16(i2, bArr, i4);
            this.rawStackMapTop = writeTypes(iArr, length);
        }

        private void writeChopFrame(int i, int i2) {
            byte[] bArr = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr[i3] = (byte) (251 - i);
            this.rawStackMapTop = ClassFileWriter.putInt16(i2, bArr, i4);
        }

        private int writeTypes(int[] iArr) {
            return writeTypes(iArr, 0);
        }

        private int writeTypes(int[] iArr, int i) {
            while (i < iArr.length) {
                this.rawStackMapTop = writeType(iArr[i]);
                i++;
            }
            return this.rawStackMapTop;
        }

        private int writeType(int i) {
            int i2 = i & 255;
            byte[] bArr = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr[i3] = (byte) i2;
            if (i2 == 7 || i2 == 8) {
                this.rawStackMapTop = ClassFileWriter.putInt16(i >>> 8, bArr, i4);
            }
            return this.rawStackMapTop;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char arrayTypeToName(int i) {
        switch (i) {
            case 4:
                return Matrix.MATRIX_TYPE_ZERO;
            case 5:
                return 'C';
            case 6:
                return 'F';
            case 7:
                return 'D';
            case 8:
                return 'B';
            case 9:
                return 'S';
            case 10:
                return 'I';
            case 11:
                return 'J';
            default:
                throw new IllegalArgumentException("bad operand");
        }
    }

    private static String classDescriptorToInternalName(String str) {
        return str.substring(1, str.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String descriptorToInternalName(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return str;
        }
        if (cCharAt == 'L') {
            return classDescriptorToInternalName(str);
        }
        if (cCharAt == 'S' || cCharAt == 'V' || cCharAt == 'I' || cCharAt == 'J' || cCharAt == 'Z' || cCharAt == '[') {
            return str;
        }
        switch (cCharAt) {
            case 'B':
            case 'C':
            case 'D':
                return str;
            default:
                throw new IllegalArgumentException("bad descriptor:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] createInitialLocals() {
        /*
            r10 = this;
            short r0 = r10.itsMaxLocals
            int[] r0 = new int[r0]
            org.mozilla.classfile.ClassFileMethod r1 = r10.itsCurrentMethod
            short r1 = r1.getFlags()
            r1 = r1 & 8
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L2c
            org.mozilla.classfile.ClassFileMethod r1 = r10.itsCurrentMethod
            java.lang.String r1 = r1.getName()
            java.lang.String r4 = "<init>"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L22
            r1 = 6
            r0[r3] = r1
            goto L2a
        L22:
            short r1 = r10.itsThisClassIndex
            int r1 = org.mozilla.classfile.TypeInfo.OBJECT(r1)
            r0[r3] = r1
        L2a:
            r1 = r2
            goto L2d
        L2c:
            r1 = r3
        L2d:
            org.mozilla.classfile.ClassFileMethod r4 = r10.itsCurrentMethod
            java.lang.String r4 = r4.getType()
            r5 = 40
            int r5 = r4.indexOf(r5)
            r6 = 41
            int r6 = r4.indexOf(r6)
            if (r5 != 0) goto Laf
            if (r6 < 0) goto Laf
            int r5 = r5 + r2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L49:
            if (r5 >= r6) goto Lae
            char r8 = r4.charAt(r5)
            r9 = 70
            if (r8 == r9) goto L85
            r9 = 76
            if (r8 == r9) goto L75
            r9 = 83
            if (r8 == r9) goto L85
            r9 = 73
            if (r8 == r9) goto L85
            r9 = 74
            if (r8 == r9) goto L85
            r9 = 90
            if (r8 == r9) goto L85
            r9 = 91
            if (r8 == r9) goto L6f
            switch(r8) {
                case 66: goto L85;
                case 67: goto L85;
                case 68: goto L85;
                default: goto L6e;
            }
        L6e:
            goto L8e
        L6f:
            r7.append(r9)
            int r5 = r5 + 1
            goto L49
        L75:
            r8 = 59
            int r8 = r4.indexOf(r8, r5)
            int r8 = r8 + r2
            java.lang.String r5 = r4.substring(r5, r8)
            r7.append(r5)
            r5 = r8
            goto L8e
        L85:
            char r8 = r4.charAt(r5)
            r7.append(r8)
            int r5 = r5 + 1
        L8e:
            java.lang.String r8 = r7.toString()
            java.lang.String r8 = descriptorToInternalName(r8)
            org.mozilla.classfile.ConstantPool r9 = r10.itsConstantPool
            int r8 = org.mozilla.classfile.TypeInfo.fromType(r8, r9)
            int r9 = r1 + 1
            r0[r1] = r8
            boolean r8 = org.mozilla.classfile.TypeInfo.isTwoWords(r8)
            if (r8 == 0) goto La9
            int r1 = r1 + 2
            goto Laa
        La9:
            r1 = r9
        Laa:
            r7.setLength(r3)
            goto L49
        Lae:
            return r0
        Laf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "bad method type"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.createInitialLocals():int[]");
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    private int getWriteSize() {
        if (this.itsSourceFileNameIndex != 0) {
            this.itsConstantPool.addUtf8("SourceFile");
        }
        int writeSize = this.itsConstantPool.getWriteSize() + 16 + (this.itsInterfaces.size() * 2) + 2;
        for (int i = 0; i < this.itsFields.size(); i++) {
            writeSize += ((ClassFileField) this.itsFields.get(i)).getWriteSize();
        }
        int writeSize2 = writeSize + 2;
        for (int i2 = 0; i2 < this.itsMethods.size(); i2++) {
            writeSize2 += ((ClassFileMethod) this.itsMethods.get(i2)).getWriteSize();
        }
        int i3 = writeSize2 + 2;
        if (this.itsSourceFileNameIndex != 0) {
            i3 = writeSize2 + 10;
        }
        return this.itsBootstrapMethods != null ? i3 + 8 + this.itsBootstrapMethodsLength : i3;
    }

    public byte[] toByteArray() {
        short sAddUtf8;
        int i;
        short sAddUtf82;
        if (this.itsBootstrapMethods != null) {
            sAddUtf8 = this.itsConstantPool.addUtf8("BootstrapMethods");
            i = 1;
        } else {
            sAddUtf8 = 0;
            i = 0;
        }
        if (this.itsSourceFileNameIndex != 0) {
            i++;
            sAddUtf82 = this.itsConstantPool.addUtf8("SourceFile");
        } else {
            sAddUtf82 = 0;
        }
        int writeSize = getWriteSize();
        byte[] bArr = new byte[writeSize];
        int iPutInt16 = putInt16(this.itsInterfaces.size(), bArr, putInt16(this.itsSuperClassIndex, bArr, putInt16(this.itsThisClassIndex, bArr, putInt16(this.itsFlags, bArr, this.itsConstantPool.write(bArr, putInt16(MajorVersion, bArr, putInt16(MinorVersion, bArr, putInt32(FileHeaderConstant, bArr, 0))))))));
        for (int i2 = 0; i2 < this.itsInterfaces.size(); i2++) {
            iPutInt16 = putInt16(((Short) this.itsInterfaces.get(i2)).shortValue(), bArr, iPutInt16);
        }
        int iPutInt162 = putInt16(this.itsFields.size(), bArr, iPutInt16);
        for (int i3 = 0; i3 < this.itsFields.size(); i3++) {
            iPutInt162 = ((ClassFileField) this.itsFields.get(i3)).write(bArr, iPutInt162);
        }
        int iPutInt163 = putInt16(this.itsMethods.size(), bArr, iPutInt162);
        for (int i4 = 0; i4 < this.itsMethods.size(); i4++) {
            iPutInt163 = ((ClassFileMethod) this.itsMethods.get(i4)).write(bArr, iPutInt163);
        }
        int iPutInt164 = putInt16(i, bArr, iPutInt163);
        if (this.itsBootstrapMethods != null) {
            iPutInt164 = putInt16(this.itsBootstrapMethods.size(), bArr, putInt32(this.itsBootstrapMethodsLength + 2, bArr, putInt16(sAddUtf8, bArr, iPutInt164)));
            for (int i5 = 0; i5 < this.itsBootstrapMethods.size(); i5++) {
                BootstrapEntry bootstrapEntry = (BootstrapEntry) this.itsBootstrapMethods.get(i5);
                System.arraycopy(bootstrapEntry.code, 0, bArr, iPutInt164, bootstrapEntry.code.length);
                iPutInt164 += bootstrapEntry.code.length;
            }
        }
        if (this.itsSourceFileNameIndex != 0) {
            iPutInt164 = putInt16(this.itsSourceFileNameIndex, bArr, putInt32(2, bArr, putInt16(sAddUtf82, bArr, iPutInt164)));
        }
        if (iPutInt164 == writeSize) {
            return bArr;
        }
        throw new RuntimeException();
    }

    static int putInt64(long j, byte[] bArr, int i) {
        return putInt32((int) j, bArr, putInt32((int) (j >>> 32), bArr, i));
    }

    private static void badStack(int i) {
        String str;
        if (i < 0) {
            str = "Stack underflow: " + i;
        } else {
            str = "Too big stack: " + i;
        }
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1 A[FALL_THROUGH, PHI: r6
      0x00b1: PHI (r6v3 int) = (r6v2 int), (r6v2 int), (r6v2 int), (r6v2 int), (r6v6 int), (r6v2 int), (r6v2 int), (r6v2 int) binds: [B:47:0x0098, B:48:0x009a, B:49:0x009c, B:52:0x00a2, B:58:0x00af, B:54:0x00a6, B:55:0x00a8, B:56:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1 A[PHI: r6
      0x00b1: PHI (r6v3 int) = (r6v2 int), (r6v2 int), (r6v2 int), (r6v2 int), (r6v6 int), (r6v2 int), (r6v2 int), (r6v2 int) binds: [B:47:0x0098, B:48:0x009a, B:49:0x009c, B:52:0x00a2, B:58:0x00af, B:54:0x00a6, B:55:0x00a8, B:56:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int sizeOfParameters(java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.sizeOfParameters(java.lang.String):int");
    }

    static int putInt16(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        return i2 + 2;
    }

    static int putInt32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        return i2 + 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int opcodeLength(int r3, boolean r4) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.opcodeLength(int, boolean):int");
    }

    private static int opcodeCount(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case ByteCode.LRETURN /* 173 */:
            case ByteCode.FRETURN /* 174 */:
            case ByteCode.DRETURN /* 175 */:
            case ByteCode.ARETURN /* 176 */:
            case ByteCode.RETURN /* 177 */:
                return 0;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case ByteCode.GOTO /* 167 */:
            case 168:
            case ByteCode.RET /* 169 */:
            case ByteCode.GETSTATIC /* 178 */:
            case ByteCode.PUTSTATIC /* 179 */:
            case 180:
            case ByteCode.PUTFIELD /* 181 */:
            case ByteCode.INVOKEVIRTUAL /* 182 */:
            case ByteCode.INVOKESPECIAL /* 183 */:
            case ByteCode.INVOKESTATIC /* 184 */:
            case ByteCode.INVOKEINTERFACE /* 185 */:
                return 1;
            case 132:
                return 2;
            case 170:
            case ByteCode.LOOKUPSWITCH /* 171 */:
                return -1;
            default:
                switch (i) {
                    case ByteCode.NEW /* 187 */:
                    case 188:
                    case 189:
                    case 192:
                    case ByteCode.INSTANCEOF /* 193 */:
                    case ByteCode.IFNULL /* 198 */:
                    case ByteCode.IFNONNULL /* 199 */:
                    case 200:
                    case 201:
                        return 1;
                    case 190:
                    case ByteCode.ATHROW /* 191 */:
                    case ByteCode.MONITORENTER /* 194 */:
                    case ByteCode.MONITOREXIT /* 195 */:
                    case ByteCode.WIDE /* 196 */:
                    case 202:
                        return 0;
                    case ByteCode.MULTIANEWARRAY /* 197 */:
                        return 2;
                    default:
                        throw new IllegalArgumentException("Bad opcode: " + i);
                }
        }
    }

    private static int stackChange(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case 132:
            case 134:
            case 138:
            case 139:
            case 143:
            case 145:
            case 146:
            case 147:
            case ByteCode.GOTO /* 167 */:
            case ByteCode.RET /* 169 */:
            case ByteCode.RETURN /* 177 */:
            case ByteCode.GETSTATIC /* 178 */:
            case ByteCode.PUTSTATIC /* 179 */:
            case ByteCode.INVOKESTATIC /* 184 */:
            case ByteCode.INVOKEDYNAMIC /* 186 */:
            case 188:
            case 189:
            case 190:
            case 192:
            case ByteCode.INSTANCEOF /* 193 */:
            case ByteCode.WIDE /* 196 */:
            case 200:
            case 202:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case 133:
            case 135:
            case 140:
            case 141:
            case 168:
            case ByteCode.NEW /* 187 */:
            case ByteCode.MULTIANEWARRAY /* 197 */:
            case 201:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94:
                return 2;
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 128:
            case 130:
            case 136:
            case 137:
            case 142:
            case 144:
            case 149:
            case 150:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case ByteCode.LOOKUPSWITCH /* 171 */:
            case 172:
            case ByteCode.FRETURN /* 174 */:
            case ByteCode.ARETURN /* 176 */:
            case 180:
            case ByteCode.PUTFIELD /* 181 */:
            case ByteCode.INVOKEVIRTUAL /* 182 */:
            case ByteCode.INVOKESPECIAL /* 183 */:
            case ByteCode.INVOKEINTERFACE /* 185 */:
            case ByteCode.ATHROW /* 191 */:
            case ByteCode.MONITORENTER /* 194 */:
            case ByteCode.MONITOREXIT /* 195 */:
            case ByteCode.IFNULL /* 198 */:
            case ByteCode.IFNONNULL /* 199 */:
                return -1;
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case 129:
            case 131:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case ByteCode.LRETURN /* 173 */:
            case ByteCode.DRETURN /* 175 */:
                return -2;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 148:
            case 151:
            case 152:
                return -3;
            case 80:
            case 82:
                return -4;
            default:
                throw new IllegalArgumentException("Bad opcode: " + i);
        }
    }

    private static String bytecodeStr(int i) {
        return "";
    }

    final char[] getCharBuffer(int i) {
        char[] cArr = this.tmpCharBuffer;
        if (i > cArr.length) {
            int length = cArr.length * 2;
            if (i <= length) {
                i = length;
            }
            this.tmpCharBuffer = new char[i];
        }
        return this.tmpCharBuffer;
    }

    private void addSuperBlockStart(int i) {
        if (GenerateStackMap) {
            int[] iArr = this.itsSuperBlockStarts;
            if (iArr == null) {
                this.itsSuperBlockStarts = new int[4];
            } else {
                int length = iArr.length;
                int i2 = this.itsSuperBlockStartsTop;
                if (length == i2) {
                    int[] iArr2 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.itsSuperBlockStarts = iArr2;
                }
            }
            int[] iArr3 = this.itsSuperBlockStarts;
            int i3 = this.itsSuperBlockStartsTop;
            this.itsSuperBlockStartsTop = i3 + 1;
            iArr3[i3] = i;
        }
    }

    private void finalizeSuperBlockStarts() {
        if (GenerateStackMap) {
            for (int i = 0; i < this.itsExceptionTableTop; i++) {
                addSuperBlockStart((short) getLabelPC(this.itsExceptionTable[i].itsHandlerLabel));
            }
            Arrays.sort(this.itsSuperBlockStarts, 0, this.itsSuperBlockStartsTop);
            int i2 = this.itsSuperBlockStarts[0];
            int i3 = 1;
            for (int i4 = 1; i4 < this.itsSuperBlockStartsTop; i4++) {
                int[] iArr = this.itsSuperBlockStarts;
                int i5 = iArr[i4];
                if (i2 != i5) {
                    if (i3 != i4) {
                        iArr[i3] = i5;
                    }
                    i3++;
                    i2 = i5;
                }
            }
            this.itsSuperBlockStartsTop = i3;
            if (this.itsSuperBlockStarts[i3 - 1] == this.itsCodeBufferTop) {
                this.itsSuperBlockStartsTop = i3 - 1;
            }
        }
    }

    static {
        int i;
        InputStream resourceAsStream = null;
        try {
            try {
                resourceAsStream = ClassFileWriter.class.getResourceAsStream("ClassFileWriter.class");
                if (resourceAsStream == null) {
                    resourceAsStream = ClassLoader.getSystemResourceAsStream("org/mozilla/classfile/ClassFileWriter.class");
                }
                byte[] bArr = new byte[8];
                int i2 = 0;
                while (i2 < 8) {
                    int i3 = resourceAsStream.read(bArr, i2, 8 - i2);
                    if (i3 < 0) {
                        throw new IOException();
                    }
                    i2 += i3;
                }
                i = (bArr[4] << 8) | (bArr[5] & 255);
                try {
                    int i4 = (bArr[7] & 255) | (bArr[6] << 8);
                    MinorVersion = i;
                    MajorVersion = i4;
                    GenerateStackMap = i4 >= 50;
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (Exception unused) {
                    MinorVersion = i;
                    MajorVersion = 48;
                    GenerateStackMap = false;
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    MinorVersion = i;
                    MajorVersion = 48;
                    GenerateStackMap = false;
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (Exception unused4) {
            i = 0;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
    }

    final class BootstrapEntry {
        final byte[] code;

        BootstrapEntry(MHandle mHandle, Object... objArr) {
            byte[] bArr = new byte[(objArr.length * 2) + 4];
            this.code = bArr;
            ClassFileWriter.putInt16(ClassFileWriter.this.itsConstantPool.addMethodHandle(mHandle), bArr, 0);
            ClassFileWriter.putInt16(objArr.length, bArr, 2);
            for (int i = 0; i < objArr.length; i++) {
                ClassFileWriter.putInt16(ClassFileWriter.this.itsConstantPool.addConstant(objArr[i]), this.code, (i * 2) + 4);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof BootstrapEntry) && Arrays.equals(this.code, ((BootstrapEntry) obj).code);
        }

        public int hashCode() {
            return ~Arrays.hashCode(this.code);
        }
    }

    public static final class MHandle {
        final String desc;
        final String name;
        final String owner;
        final byte tag;

        public MHandle(byte b2, String str, String str2, String str3) {
            this.tag = b2;
            this.owner = str;
            this.name = str2;
            this.desc = str3;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MHandle)) {
                return false;
            }
            MHandle mHandle = (MHandle) obj;
            return this.tag == mHandle.tag && this.owner.equals(mHandle.owner) && this.name.equals(mHandle.name) && this.desc.equals(mHandle.desc);
        }

        public int hashCode() {
            return this.tag + (this.owner.hashCode() * this.name.hashCode() * this.desc.hashCode());
        }

        public String toString() {
            return this.owner + '.' + this.name + this.desc + " (" + ((int) this.tag) + ')';
        }
    }
}
