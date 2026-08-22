package org.minidns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class MiniDnsInitialization {
    private static final Logger LOGGER;
    static final String VERSION;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Class, java.lang.Class<org.minidns.MiniDnsInitialization>] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8 */
    static {
        BufferedReader bufferedReader;
        ?? r1 = MiniDnsInitialization.class;
        LOGGER = Logger.getLogger(r1.getName());
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(r1.getClassLoader().getResourceAsStream("org.minidns/version"), StandardCharsets.UTF_8));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            LOGGER.log(Level.WARNING, "IOException closing stream", (Throwable) e3);
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            r1 = line;
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = bufferedReader;
            LOGGER.log(Level.SEVERE, "Could not determine MiniDNS version", (Throwable) e);
            r1 = "unkown";
            if (bufferedReader2 != null) {
                bufferedReader2.close();
                r1 = r1;
            }
            VERSION = r1;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    LOGGER.log(Level.WARNING, "IOException closing stream", (Throwable) e5);
                }
            }
            throw th;
        }
        VERSION = r1;
    }
}
