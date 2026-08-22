package fr.maxcom.os.storage;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import fr.maxcom.libmedia.a;
import fr.maxcom.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* JADX INFO: loaded from: classes9.dex */
public class Volume implements Comparable<Volume> {
    public static final String EMULATED_STORAGE = "emulated_storage";
    public static final String STORAGE = "storage";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f1293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final DocumentFile f86a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f87a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final boolean f88a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1296d;
    public String description;

    Volume(File file) {
        String name = file.getName();
        this.f1295c = name;
        String strA = a(file);
        this.f1294b = strA;
        if (strA == null || strA.isEmpty()) {
            this.f1294b = name;
        }
        this.f86a = DocumentFile.fromFile(file);
        this.f1296d = EMULATED_STORAGE;
        this.f88a = false;
    }

    private static String a(File file) {
        File file2 = new File(file, ".libmedia");
        if (!file2.canRead()) {
            return null;
        }
        try {
            return a(new FileReader(file2));
        } catch (FileNotFoundException unused) {
            Log.e("Volume", "File not found");
            return null;
        }
    }

    public boolean deleteLabelFile() {
        DocumentFile documentFileA = a();
        if (documentFileA == null || !documentFileA.delete()) {
            return false;
        }
        String str = this.f87a;
        this.f1294b = str;
        if (str != null && !str.isEmpty()) {
            return true;
        }
        this.f1294b = this.f1295c;
        return true;
    }

    public String getLabel() {
        return this.f1294b;
    }

    public String getName() {
        return this.f1295c;
    }

    public DocumentFile getRoot() {
        return this.f86a;
    }

    public String getType() {
        return this.f1296d;
    }

    public boolean hasLabelFile() {
        return a() != null;
    }

    public boolean isForgettable() {
        return this.f88a;
    }

    public String toString() {
        return this.f1294b;
    }

    public boolean writeLabelFile(String str) {
        DocumentFile documentFileA = a();
        if (documentFileA == null) {
            documentFileA = this.f86a.createFile(null, ".libmedia");
        }
        if (documentFileA == null || !documentFileA.canWrite()) {
            return false;
        }
        try {
            OutputStream outputStreamOpenOutputStream = a.f1292a.getContentResolver().openOutputStream(documentFileA.getUri());
            if (outputStreamOpenOutputStream == null) {
                return false;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStreamOpenOutputStream));
            try {
                bufferedWriter.write(str);
                this.f1294b = str;
                try {
                    return true;
                } catch (Exception e2) {
                    return true;
                }
            } finally {
                try {
                    bufferedWriter.close();
                } catch (Exception e22) {
                    Log.e("Volume", "Close error: " + e22.getMessage());
                }
            }
        } catch (FileNotFoundException unused) {
            Log.e("Volume", "File not found");
            return false;
        } catch (IOException e3) {
            Log.e("Volume", "IO error: " + e3.getMessage());
            return false;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Volume volume) {
        int iCompareTo;
        if (getRoot().getUri().equals(volume.getRoot().getUri())) {
            return 0;
        }
        if (getLabel() == null) {
            return 1;
        }
        if (volume.getLabel() == null || (iCompareTo = getLabel().compareTo(volume.getLabel())) == 0) {
            return -1;
        }
        return iCompareTo;
    }

    public boolean forget() {
        if (!this.f88a) {
            return false;
        }
        try {
            a.f1292a.getContentResolver().releasePersistableUriPermission(this.f1293a, 3);
            return true;
        } catch (SecurityException e2) {
            Log.e("Volume", "Error: " + e2.getMessage());
            return false;
        }
    }

    private static String a(DocumentFile documentFile) {
        DocumentFile documentFileFindFile = documentFile.findFile(".libmedia");
        if (documentFileFindFile == null || !documentFileFindFile.canRead()) {
            return null;
        }
        try {
            InputStream inputStreamOpenInputStream = a.f1292a.getContentResolver().openInputStream(documentFileFindFile.getUri());
            if (inputStreamOpenInputStream != null) {
                return a(new InputStreamReader(inputStreamOpenInputStream));
            }
            return null;
        } catch (FileNotFoundException unused) {
            Log.e("Volume", "File not found");
            return null;
        }
    }

    Volume(File file, String str) {
        String name = file.getName();
        this.f1295c = name;
        this.f87a = str;
        String strA = a(file);
        this.f1294b = strA;
        if (strA == null || strA.isEmpty()) {
            this.f1294b = str;
            if (str == null || str.isEmpty()) {
                this.f1294b = name;
            }
        }
        this.f86a = DocumentFile.fromFile(file);
        this.f1296d = "storage";
        this.f88a = false;
    }

    private static String a(Reader reader) {
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            try {
                line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (Exception e2) {
                    Log.e("Volume", "Close error: " + e2.getMessage());
                }
            } finally {
            }
        } catch (IOException e3) {
            Log.e("Volume", "IO error: " + e3.getMessage());
        }
        return line;
    }

    Volume(DocumentFile documentFile, Uri uri) {
        String name = documentFile.getName();
        this.f1295c = name;
        String strA = a(documentFile);
        this.f1294b = strA;
        if (strA == null || strA.isEmpty()) {
            this.f1294b = name;
        }
        this.f1293a = uri;
        this.f86a = documentFile;
        this.f1296d = "storage";
        this.f88a = true;
    }

    private DocumentFile a() {
        return this.f86a.findFile(".libmedia");
    }
}
