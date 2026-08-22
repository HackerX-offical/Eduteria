package org.jivesoftware.smack.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes10.dex */
public final class FileUtils {
    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    public static InputStream getInputStreamForClasspathFile(String str) {
        return getInputStreamForClasspathFile(str, null);
    }

    public static InputStream getInputStreamForClasspathFile(String str, ClassLoader classLoader) {
        try {
            return getStreamForClasspathFile(str, classLoader);
        } catch (IOException e2) {
            LOGGER.log(Level.FINE, "Suppressed IOException in getInputStreamForClasspathFile", (Throwable) e2);
            return null;
        }
    }

    public static InputStream getStreamForClasspathFile(String str, ClassLoader classLoader) throws IOException {
        List<ClassLoader> classLoaders = getClassLoaders();
        if (classLoader != null) {
            classLoaders.add(0, classLoader);
        }
        Iterator<ClassLoader> it = classLoaders.iterator();
        while (it.hasNext()) {
            InputStream resourceAsStream = it.next().getResourceAsStream(str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
        }
        throw new IOException("Unable to get '" + str + "' from classpath. Tried ClassLoaders:" + classLoaders);
    }

    public static InputStream getStreamForUri(URI uri, ClassLoader classLoader) throws IOException {
        if (uri.getScheme().equals("classpath")) {
            return getStreamForClasspathFile(uri.getSchemeSpecificPart(), classLoader);
        }
        return uri.toURL().openStream();
    }

    public static List<ClassLoader> getClassLoaders() {
        ClassLoader[] classLoaderArr = {FileUtils.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return arrayList;
    }

    public static boolean addLines(String str, Set<String> set) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getStreamForUri(URI.create(str), null), StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    set.add(line);
                } else {
                    bufferedReader.close();
                    return true;
                }
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        }
    }

    public static String readFileOrThrow(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            char[] cArr = new char[8192];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = fileReader.read(cArr);
                if (i >= 0) {
                    sb.append(cArr, 0, i);
                } else {
                    String string = sb.toString();
                    fileReader.close();
                    return string;
                }
            }
        } catch (Throwable th) {
            try {
                fileReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String readFile(File file) {
        try {
            return readFileOrThrow(file);
        } catch (FileNotFoundException e2) {
            LOGGER.log(Level.FINE, "readFile", (Throwable) e2);
            return null;
        } catch (IOException e3) {
            LOGGER.log(Level.WARNING, "readFile", (Throwable) e3);
            return null;
        }
    }

    public static void writeFileOrThrow(File file, CharSequence charSequence) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        try {
            fileWriter.write(charSequence.toString());
        } finally {
            fileWriter.close();
        }
    }

    public static boolean writeFile(File file, CharSequence charSequence) {
        try {
            writeFileOrThrow(file, charSequence);
            return true;
        } catch (IOException e2) {
            LOGGER.log(Level.WARNING, "writeFile", (Throwable) e2);
            return false;
        }
    }

    public static FileOutputStream prepareFileOutputStream(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create directory " + parentFile.getAbsolutePath());
            }
            if (!file.createNewFile()) {
                throw new IOException("Cannot create file " + file.getAbsolutePath());
            }
        }
        if (file.isDirectory()) {
            throw new AssertionError("File " + file.getAbsolutePath() + " is not a file!");
        }
        return new FileOutputStream(file);
    }

    public static FileInputStream prepareFileInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isFile()) {
                return new FileInputStream(file);
            }
            throw new IOException("File " + file.getAbsolutePath() + " is not a file!");
        }
        throw new FileNotFoundException("File " + file.getAbsolutePath() + " not found.");
    }

    public static void maybeDeleteFileOrThrow(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static void maybeCreateFileWithParentDirectories(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create directory " + parentFile);
        }
        if (file.isFile()) {
            return;
        }
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Cannot create file " + file);
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File " + file + " exists, but is a directory.");
            }
            throw new IOException("File " + file + " exists, but is neither a file nor a directory");
        }
    }
}
