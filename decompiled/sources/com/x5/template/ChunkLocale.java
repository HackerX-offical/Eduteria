package com.x5.template;

import com.csvreader.CsvReader;
import com.x5.util.JarResource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: loaded from: classes9.dex */
public class ChunkLocale {
    private static HashMap<String, ChunkLocale> locales = new HashMap<>();
    private String localeCode;
    private HashMap<String, String> translations;

    public static ChunkLocale getInstance(String str, Chunk chunk) {
        ChunkLocale chunkLocale = locales.get(str);
        if (chunkLocale != null) {
            return chunkLocale;
        }
        ChunkLocale chunkLocale2 = new ChunkLocale(str, chunk);
        locales.put(str, chunkLocale2);
        return chunkLocale2;
    }

    public static void registerLocale(String str, String[] strArr) {
        locales.put(str, new ChunkLocale(str, strArr));
    }

    private ChunkLocale(String str, Chunk chunk) {
        this.localeCode = str;
        loadTranslations(chunk);
    }

    private ChunkLocale(String str, String[] strArr) {
        this.localeCode = str;
        if (strArr == null || strArr.length <= 1) {
            return;
        }
        this.translations = new HashMap<>();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= strArr.length) {
                return;
            }
            this.translations.put(strArr[i], strArr[i2]);
            i = i2;
        }
    }

    private void loadTranslations(Chunk chunk) {
        String str;
        String str2;
        try {
            InputStream inputStreamLocateLocaleDB = locateLocaleDB(chunk);
            if (inputStreamLocateLocaleDB == null) {
                return;
            }
            CsvReader csvReader = new CsvReader(inputStreamLocateLocaleDB, grokLocaleDBCharset());
            csvReader.setUseComments(true);
            this.translations = new HashMap<>();
            while (csvReader.readRecord()) {
                String[] values = csvReader.getValues();
                if (values != null && values.length > 1 && (str = values[0]) != null && (str2 = values[1]) != null) {
                    this.translations.put(str, str2);
                }
            }
        } catch (IOException e2) {
            System.err.println("ERROR loading locale DB: " + this.localeCode);
            e2.printStackTrace(System.err);
        }
    }

    private Charset grokLocaleDBCharset() {
        Charset charsetForName;
        String property = System.getProperty("chunk.localedb.charset");
        if (property != null) {
            try {
                charsetForName = Charset.forName(property);
            } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
                charsetForName = null;
            }
            if (charsetForName != null) {
                return charsetForName;
            }
        }
        try {
            return Charset.forName("UTF-8");
        } catch (Exception unused2) {
            return Charset.defaultCharset();
        }
    }

    private InputStream locateLocaleDB(Chunk chunk) throws IOException {
        String[] strArrSplit;
        InputStream inputStreamPeekInsideJar;
        InputStream resourceAsStream;
        String property = System.getProperty("chunk.localedb.path");
        if (property != null) {
            File file = new File(property);
            if (file.exists()) {
                File file2 = new File(file, this.localeCode + "/translate.csv");
                if (file2.exists()) {
                    return new FileInputStream(file2);
                }
            }
        }
        String str = "/locale/" + this.localeCode + "/translate.csv";
        InputStream resourceAsStream2 = getClass().getResourceAsStream(str);
        if (resourceAsStream2 != null) {
            return resourceAsStream2;
        }
        Class<?> clsGrokCallerClass = TemplateSet.grokCallerClass();
        if (clsGrokCallerClass != null && (resourceAsStream = clsGrokCallerClass.getResourceAsStream(str)) != null) {
            return resourceAsStream;
        }
        String property2 = System.getProperty("java.class.path");
        if (property2 == null || (strArrSplit = property2.split(":")) == null) {
            return null;
        }
        for (String str2 : strArrSplit) {
            if (str2.endsWith(".jar") && (inputStreamPeekInsideJar = JarResource.peekInsideJar("jar:file:" + str2, str)) != null) {
                return inputStreamPeekInsideJar;
            }
        }
        return null;
    }

    public String translate(String str, String[] strArr, Chunk chunk) {
        return processFormatString(str, strArr, chunk, this.translations);
    }

    public static String processFormatString(String str, String[] strArr, Chunk chunk) {
        return processFormatString(str, strArr, chunk, null);
    }

    public static String processFormatString(String str, String[] strArr, Chunk chunk, HashMap<String, String> map) {
        if (str == null) {
            return null;
        }
        if (map != null && map.containsKey(str)) {
            str = map.get(str);
        }
        if (strArr == null || chunk == null || !str.contains("%s")) {
            return str;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str2.startsWith("~") || str2.startsWith("$")) {
                Object obj = chunk.get(str2.substring(1));
                strArr2[i] = obj == null ? "" : obj.toString();
            } else {
                strArr2[i] = str2;
            }
        }
        try {
            return String.format(str, strArr2);
        } catch (IllegalFormatException unused) {
            return str;
        }
    }

    public Locale getJavaLocale() {
        String str = this.localeCode;
        if (str == null || !str.contains("_")) {
            return null;
        }
        String[] strArrSplit = this.localeCode.split("_");
        if (strArrSplit.length <= 1) {
            return null;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        if (str2 == null || str2.trim().length() <= 0 || str3 == null || str3.trim().length() <= 0) {
            return null;
        }
        Locale locale = new Locale(str2, str3);
        try {
            if (locale.getISO3Country() == null) {
                return null;
            }
            if (locale.getISO3Language() != null) {
                return locale;
            }
            return null;
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public String toString() {
        return this.localeCode;
    }
}
