package com.x5.template;

import com.x5.template.filters.ChunkFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class ThemeConfig {
    public static final String CACHE_MINUTES = "cache_minutes";
    public static final String DEFAULT_EXT = "default_extension";
    public static final String ENCODING = "encoding";
    public static final String ERROR_LOG = "error_log";
    public static final String FILTERS = "filters";
    public static final String HIDE_ERRORS = "hide_errors";
    public static final String LAYER_NAMES = "layers";
    public static final String LOCALE = "locale";
    public static final String STD_ERR = "stderr";
    public static final String THEME_PATH = "theme_path";
    private int cacheMinutes;
    private String defaultExtension;
    private String encoding;
    private PrintStream errorLog;
    private ChunkFilter[] filters;
    private boolean hideErrors;
    private String layerNames;
    private String locale;
    private String themePath;

    public ThemeConfig(Map<String, String> map) {
        PrintStream printStreamOpenForAppend = null;
        this.themePath = null;
        this.layerNames = null;
        this.defaultExtension = null;
        this.cacheMinutes = 0;
        this.locale = null;
        this.encoding = null;
        this.hideErrors = false;
        this.errorLog = null;
        this.filters = null;
        if (map == null) {
            return;
        }
        this.themePath = getParam(map, THEME_PATH);
        this.layerNames = getParam(map, LAYER_NAMES);
        this.defaultExtension = getParam(map, DEFAULT_EXT);
        if (map.containsKey(CACHE_MINUTES)) {
            try {
                this.cacheMinutes = Integer.parseInt(map.get(CACHE_MINUTES));
            } catch (NumberFormatException unused) {
                System.err.println("Chunk Theme config error: cache_minutes must be a number.");
            }
        }
        this.locale = getParam(map, LOCALE);
        this.encoding = getParam(map, ENCODING);
        String param = getParam(map, HIDE_ERRORS);
        if (param != null && !param.equalsIgnoreCase("FALSE")) {
            this.hideErrors = true;
            if (map.containsKey(ERROR_LOG)) {
                String param2 = getParam(map, ERROR_LOG);
                if (!param2.equalsIgnoreCase(STD_ERR)) {
                    printStreamOpenForAppend = openForAppend(param2);
                }
            }
            this.errorLog = printStreamOpenForAppend == null ? System.err : printStreamOpenForAppend;
        }
        String param3 = getParam(map, "filters");
        if (param3 != null) {
            this.filters = parseFilters(param3);
        }
    }

    private String getParam(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        String strTrim = map.get(str);
        if (strTrim != null) {
            strTrim = strTrim.trim();
            if (strTrim.length() == 0) {
                return null;
            }
        }
        return strTrim;
    }

    private PrintStream openForAppend(String str) {
        try {
            return new PrintStream(new FileOutputStream(new File(str), true));
        } catch (FileNotFoundException unused) {
            System.err.println("Can not open error log file '" + str + "' for append.");
            return null;
        }
    }

    private ChunkFilter[] parseFilters(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("[\\s,]+")) {
            ChunkFilter chunkFilterCreateFilterFromClassName = createFilterFromClassName(str2);
            if (chunkFilterCreateFilterFromClassName != null) {
                arrayList.add(chunkFilterCreateFilterFromClassName);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (ChunkFilter[]) arrayList.toArray(new ChunkFilter[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.x5.template.filters.ChunkFilter createFilterFromClassName(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            java.lang.Class r1 = java.lang.Class.forName(r8)     // Catch: java.lang.ClassNotFoundException -> Ld java.lang.IllegalAccessException -> L28 java.lang.InstantiationException -> L44
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.InstantiationException -> Lb java.lang.ClassNotFoundException -> Ld java.lang.IllegalAccessException -> L28
            goto L8f
        Lb:
            r2 = move-exception
            goto L46
        Ld:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Filter class not found: "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.err
            r1.printStackTrace(r2)
            goto L42
        L28:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Permission denied adding user-contributed filter: "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.err
            r1.printStackTrace(r2)
        L42:
            r1 = r0
            goto L8f
        L44:
            r2 = move-exception
            r1 = r0
        L46:
            java.lang.String r3 = "$"
            boolean r3 = r8.contains(r3)
            if (r3 == 0) goto L73
            r3 = 36
            int r3 = r8.indexOf(r3)     // Catch: java.lang.Throwable -> L73
            r4 = 0
            java.lang.String r3 = r8.substring(r4, r3)     // Catch: java.lang.Throwable -> L73
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L73
            java.lang.Object r5 = r3.newInstance()     // Catch: java.lang.Throwable -> L73
            r6 = 1
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> L73
            r6[r4] = r3     // Catch: java.lang.Throwable -> L73
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r6)     // Catch: java.lang.Throwable -> L73
            java.lang.Object[] r3 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L73
            java.lang.Object r1 = r1.newInstance(r3)     // Catch: java.lang.Throwable -> L73
            goto L74
        L73:
            r1 = r0
        L74:
            if (r1 != 0) goto L8f
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Could not call constructor for filter: "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
        L8f:
            com.x5.template.filters.ChunkFilter r1 = (com.x5.template.filters.ChunkFilter) r1     // Catch: java.lang.ClassCastException -> L93
            r0 = r1
            goto Lad
        L93:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "User-contributed filter rejected; must implement ChunkFilter: "
            r3.<init>(r4)
            java.lang.StringBuilder r8 = r3.append(r8)
            java.lang.String r8 = r8.toString()
            r2.println(r8)
            java.io.PrintStream r8 = java.lang.System.err
            r1.printStackTrace(r8)
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.x5.template.ThemeConfig.createFilterFromClassName(java.lang.String):com.x5.template.filters.ChunkFilter");
    }

    public String getThemeFolder() {
        return this.themePath;
    }

    public String getLayerNames() {
        return this.layerNames;
    }

    public String getDefaultExtension() {
        return this.defaultExtension;
    }

    public int getCacheMinutes() {
        return this.cacheMinutes;
    }

    public String getLocaleCode() {
        return this.locale;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean hideErrors() {
        return this.hideErrors;
    }

    public PrintStream getErrorLog() {
        return this.errorLog;
    }

    public ChunkFilter[] getFilters() {
        return this.filters;
    }
}
