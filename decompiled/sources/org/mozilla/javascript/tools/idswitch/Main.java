package org.mozilla.javascript.tools.idswitch;

import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.tools.ToolErrorReporter;

/* JADX INFO: loaded from: classes10.dex */
public class Main {
    private static final int GENERATED_TAG = 2;
    private static final String GENERATED_TAG_STR = "generated";
    private static final int NORMAL_LINE = 0;
    private static final int STRING_TAG = 3;
    private static final String STRING_TAG_STR = "string";
    private static final int SWITCH_TAG = 1;
    private static final String SWITCH_TAG_STR = "string_id_map";
    private CodePrinter P;
    private ToolErrorReporter R;
    private final List<IdValuePair> all_pairs = new ArrayList();
    private FileBody body;
    private String source_file;
    private int tag_definition_end;
    private int tag_value_end;
    private int tag_value_start;

    private static boolean is_value_type(int i) {
        return i == 3;
    }

    private static boolean is_white_space(int i) {
        return i == 32 || i == 9;
    }

    private static String tag_name(int i) {
        if (i == -2) {
            return "/generated";
        }
        if (i == -1) {
            return "/string_id_map";
        }
        if (i == 1) {
            return SWITCH_TAG_STR;
        }
        if (i == 2) {
            return GENERATED_TAG_STR;
        }
        return "";
    }

    void process_file(String str) throws IOException {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        this.source_file = str;
        this.body = new FileBody();
        if (str.equals("-")) {
            fileInputStream = System.in;
        } else {
            fileInputStream = new FileInputStream(str);
        }
        try {
            this.body.readData(new InputStreamReader(fileInputStream, HTTP.ASCII));
            fileInputStream.close();
            process_file();
            if (this.body.wasModified()) {
                if (str.equals("-")) {
                    fileOutputStream = System.out;
                } else {
                    fileOutputStream = new FileOutputStream(str);
                }
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    this.body.writeData(outputStreamWriter);
                    outputStreamWriter.flush();
                } finally {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0092 A[PHI: r3 r4 r5
      0x0092: PHI (r3v4 int) = (r3v1 int), (r3v5 int), (r3v1 int), (r3v1 int), (r3v1 int), (r3v1 int) binds: [B:39:0x008f, B:38:0x008d, B:23:0x004d, B:20:0x0046, B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r4v4 int) = (r4v1 int), (r4v5 int), (r4v1 int), (r4v1 int), (r4v1 int), (r4v1 int) binds: [B:39:0x008f, B:38:0x008d, B:23:0x004d, B:20:0x0046, B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r5v3 int) = (r5v1 int), (r5v4 int), (r5v1 int), (r5v1 int), (r5v1 int), (r5v1 int) binds: [B:39:0x008f, B:38:0x008d, B:23:0x004d, B:20:0x0046, B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void process_file() {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.process_file():void");
    }

    private String get_time_stamp() {
        return new SimpleDateFormat(" 'Last update:' yyyy-MM-dd HH:mm:ss z").format(new Date());
    }

    private void generate_java_code() {
        this.P.clear();
        IdValuePair[] idValuePairArr = new IdValuePair[this.all_pairs.size()];
        this.all_pairs.toArray(idValuePairArr);
        SwitchGenerator switchGenerator = new SwitchGenerator();
        switchGenerator.char_tail_test_threshold = 2;
        switchGenerator.setReporter(this.R);
        switchGenerator.setCodePrinter(this.P);
        switchGenerator.generateSwitch(idValuePairArr, "0");
    }

    private int extract_line_tag_id(char[] cArr, int i, int i2) {
        boolean z;
        int iSkip_white_space;
        char c2;
        char c3;
        int iSkip_white_space2 = skip_white_space(cArr, i, i2);
        int iLook_for_slash_slash = look_for_slash_slash(cArr, iSkip_white_space2, i2);
        if (iLook_for_slash_slash != i2) {
            boolean z2 = iSkip_white_space2 + 2 == iLook_for_slash_slash;
            int iSkip_white_space3 = skip_white_space(cArr, iLook_for_slash_slash, i2);
            if (iSkip_white_space3 != i2 && cArr[iSkip_white_space3] == '#') {
                int i3 = iSkip_white_space3 + 1;
                if (i3 == i2 || cArr[i3] != '/') {
                    z = false;
                } else {
                    i3 = iSkip_white_space3 + 2;
                    z = true;
                }
                int i4 = i3;
                while (i4 != i2 && (c3 = cArr[i4]) != '#' && c3 != '=' && !is_white_space(c3)) {
                    i4++;
                }
                if (i4 != i2 && (iSkip_white_space = skip_white_space(cArr, i4, i2)) != i2 && ((c2 = cArr[iSkip_white_space]) == '=' || c2 == '#')) {
                    int iExtract_tag_value = get_tag_id(cArr, i3, i4, z2);
                    if (iExtract_tag_value == 0) {
                        return iExtract_tag_value;
                    }
                    String str = null;
                    if (c2 == '#') {
                        if (z) {
                            iExtract_tag_value = -iExtract_tag_value;
                            if (is_value_type(iExtract_tag_value)) {
                                str = "msg.idswitch.no_end_usage";
                            }
                        }
                        this.tag_definition_end = iSkip_white_space + 1;
                    } else {
                        if (z) {
                            str = "msg.idswitch.no_end_with_value";
                        } else if (!is_value_type(iExtract_tag_value)) {
                            str = "msg.idswitch.no_value_allowed";
                        }
                        iExtract_tag_value = extract_tag_value(cArr, iSkip_white_space + 1, i2, iExtract_tag_value);
                    }
                    if (str == null) {
                        return iExtract_tag_value;
                    }
                    throw this.R.runtimeError(ToolErrorReporter.getMessage(str, tag_name(iExtract_tag_value)), this.source_file, this.body.getLineNumber(), null, 0);
                }
            }
        }
        return 0;
    }

    private int look_for_slash_slash(char[] cArr, int i, int i2) {
        while (i + 2 <= i2) {
            int i3 = i + 1;
            if (cArr[i] == '/') {
                i += 2;
                if (cArr[i3] == '/') {
                    return i;
                }
            } else {
                i = i3;
            }
        }
        return i2;
    }

    private int extract_tag_value(char[] cArr, int i, int i2, int i3) {
        int i4;
        int iSkip_white_space = skip_white_space(cArr, i, i2);
        if (iSkip_white_space == i2) {
            return 0;
        }
        int i5 = iSkip_white_space;
        while (true) {
            if (i5 == i2) {
                i4 = iSkip_white_space;
                break;
            }
            char c2 = cArr[i5];
            if (is_white_space(c2)) {
                int iSkip_white_space2 = skip_white_space(cArr, i5 + 1, i2);
                if (iSkip_white_space2 != i2 && cArr[iSkip_white_space2] == '#') {
                    i4 = i5;
                    i5 = iSkip_white_space2;
                    break;
                }
                i5 = iSkip_white_space2 + 1;
            } else {
                if (c2 == '#') {
                    i4 = i5;
                    break;
                }
                i5++;
            }
        }
        if (i5 == i2) {
            return 0;
        }
        this.tag_value_start = iSkip_white_space;
        this.tag_value_end = i4;
        this.tag_definition_end = i5 + 1;
        return i3;
    }

    private int get_tag_id(char[] cArr, int i, int i2, boolean z) {
        if (z) {
            if (equals(SWITCH_TAG_STR, cArr, i, i2)) {
                return 1;
            }
            if (equals(GENERATED_TAG_STR, cArr, i, i2)) {
                return 2;
            }
        }
        return equals("string", cArr, i, i2) ? 3 : 0;
    }

    private void look_for_id_definitions(char[] cArr, int i, int i2, boolean z) {
        int iSkip_name_char;
        int iSkip_white_space;
        int i3;
        int iSkip_white_space2 = skip_white_space(cArr, i, i2);
        int iSkip_matched_prefix = skip_matched_prefix("Id_", cArr, iSkip_white_space2, i2);
        if (iSkip_matched_prefix < 0 || iSkip_matched_prefix == (iSkip_name_char = skip_name_char(cArr, iSkip_matched_prefix, i2)) || (iSkip_white_space = skip_white_space(cArr, iSkip_name_char, i2)) == i2 || cArr[iSkip_white_space] != '=') {
            return;
        }
        if (z) {
            iSkip_matched_prefix = this.tag_value_start;
            i3 = this.tag_value_end;
        } else {
            i3 = iSkip_name_char;
        }
        add_id(cArr, iSkip_white_space2, iSkip_name_char, iSkip_matched_prefix, i3);
    }

    private void add_id(char[] cArr, int i, int i2, int i3, int i4) {
        IdValuePair idValuePair = new IdValuePair(new String(cArr, i3, i4 - i3), new String(cArr, i, i2 - i));
        idValuePair.setLineNumber(this.body.getLineNumber());
        this.all_pairs.add(idValuePair);
    }

    private static int skip_white_space(char[] cArr, int i, int i2) {
        while (i != i2 && is_white_space(cArr[i])) {
            i++;
        }
        return i;
    }

    private static int skip_matched_prefix(String str, char[] cArr, int i, int i2) {
        int length = str.length();
        if (length > i2 - i) {
            return -1;
        }
        int i3 = 0;
        while (i3 != length) {
            if (str.charAt(i3) != cArr[i]) {
                return -1;
            }
            i3++;
            i++;
        }
        return i;
    }

    private static boolean equals(String str, char[] cArr, int i, int i2) {
        if (str.length() != i2 - i) {
            return false;
        }
        int i3 = 0;
        while (i != i2) {
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i++;
            i3++;
        }
        return true;
    }

    private static int skip_name_char(char[] cArr, int i, int i2) {
        while (i != i2) {
            char c2 = cArr[i];
            if (('a' > c2 || c2 > 'z') && (('A' > c2 || c2 > 'Z') && (('0' > c2 || c2 > '9') && c2 != '_'))) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] strArr) {
        System.exit(new Main().exec(strArr));
    }

    private int exec(String[] strArr) {
        this.R = new ToolErrorReporter(true, System.err);
        int iProcess_options = process_options(strArr);
        if (iProcess_options == 0) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.no_file_argument"));
            return -1;
        }
        if (iProcess_options > 1) {
            option_error(ToolErrorReporter.getMessage("msg.idswitch.too_many_arguments"));
            return -1;
        }
        CodePrinter codePrinter = new CodePrinter();
        this.P = codePrinter;
        codePrinter.setIndentStep(4);
        this.P.setIndentTabSize(0);
        try {
            process_file(strArr[0]);
            return 0;
        } catch (IOException e2) {
            print_error(ToolErrorReporter.getMessage("msg.idswitch.io_error", e2.toString()));
            return -1;
        } catch (EvaluatorException unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[PHI: r11
      0x0075: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:29:0x0067, B:32:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int process_options(java.lang.String[] r14) {
        /*
            r13 = this;
            int r0 = r14.length
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L5:
            r5 = 1
            if (r2 == r0) goto L66
            r6 = r14[r2]
            int r7 = r6.length()
            r8 = 2
            if (r7 < r8) goto L63
            char r9 = r6.charAt(r1)
            r10 = 45
            if (r9 != r10) goto L63
            char r9 = r6.charAt(r5)
            r11 = -1
            r12 = 0
            if (r9 != r10) goto L44
            if (r7 != r8) goto L26
            r14[r2] = r12
            goto L66
        L26:
            java.lang.String r7 = "--help"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L30
            r3 = r5
            goto L61
        L30:
            java.lang.String r7 = "--version"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L3a
            r4 = r5
            goto L61
        L3a:
            java.lang.String r0 = "msg.idswitch.bad_option"
            java.lang.String r0 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r0, r6)
            r13.option_error(r0)
            goto L67
        L44:
            r8 = r5
        L45:
            if (r8 == r7) goto L61
            char r9 = r6.charAt(r8)
            r10 = 104(0x68, float:1.46E-43)
            if (r9 == r10) goto L5d
            java.lang.String r0 = "msg.idswitch.bad_option_char"
            java.lang.String r2 = java.lang.String.valueOf(r9)
            java.lang.String r0 = org.mozilla.javascript.tools.ToolErrorReporter.getMessage(r0, r2)
            r13.option_error(r0)
            goto L67
        L5d:
            int r8 = r8 + 1
            r3 = r5
            goto L45
        L61:
            r14[r2] = r12
        L63:
            int r2 = r2 + 1
            goto L5
        L66:
            r11 = r5
        L67:
            if (r11 != r5) goto L75
            if (r3 == 0) goto L6f
            r13.show_usage()
            r11 = r1
        L6f:
            if (r4 == 0) goto L75
            r13.show_version()
            goto L76
        L75:
            r1 = r11
        L76:
            if (r1 == r5) goto L7b
            java.lang.System.exit(r1)
        L7b:
            int r14 = r13.remove_nulls(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.idswitch.Main.process_options(java.lang.String[]):int");
    }

    private void show_usage() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.usage"));
        System.out.println();
    }

    private void show_version() {
        System.out.println(ToolErrorReporter.getMessage("msg.idswitch.version"));
    }

    private void option_error(String str) {
        print_error(ToolErrorReporter.getMessage("msg.idswitch.bad_invocation", str));
    }

    private void print_error(String str) {
        System.err.println(str);
    }

    private int remove_nulls(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (i != length && strArr[i] != null) {
            i++;
        }
        if (i != length) {
            for (int i2 = i + 1; i2 != length; i2++) {
                String str = strArr[i2];
                if (str != null) {
                    strArr[i] = str;
                    i++;
                }
            }
        }
        return i;
    }
}
