package fr.maxcom.os.storage;

import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.IBinder;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import fr.maxcom.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;

/* JADX INFO: loaded from: classes9.dex */
public class VolumeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1297a = 21;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f89a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Method f90a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final List<File> f91a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f1298b;

    class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1299a;

        a(VolumeManager volumeManager, String str) {
            this.f1299a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return this.f1299a == null || file.getName().startsWith(this.f1299a);
            }
            return false;
        }
    }

    public VolumeManager() {
        try {
            Object objInvoke = Class.forName("android.os.storage.IMountService$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "mount"));
            this.f89a = objInvoke;
            if (objInvoke == null) {
                Log.e("VolumeManager", "Unable to connect to mount service");
            }
        } catch (Exception e2) {
            Log.e("VolumeManager", "Error: " + e2.getMessage());
        }
        this.f90a = a("getVolumeState");
        this.f1298b = a("getVolumeLabel");
        fr.maxcom.libmedia.a.m12381a();
    }

    private Method a(String str) {
        Object obj = this.f89a;
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod(str, String.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private void b(ArrayList<String> arrayList, File file) {
        Method method;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                c(arrayList, file2);
                if (file2.getName().startsWith("UsbDrive") | file2.getName().equals("extSdCard") | file2.getName().equals("sdcard") | file2.getName().equals("sdcard0") | file2.getName().equals("USB") | file2.getName().contains("-")) {
                    if (file2.canRead()) {
                        a(arrayList, file2);
                    }
                    String path = file2.getPath();
                    Method method2 = this.f90a;
                    if (method2 != null) {
                        try {
                            String str = (String) method2.invoke(this.f89a, path);
                            arrayList.add("s: " + str);
                            if ("mounted".equals(str) && (method = this.f1298b) != null) {
                                arrayList.add("l: " + ((String) method.invoke(this.f89a, path)));
                            }
                        } catch (Exception e2) {
                            arrayList.add(e2.getClass().getName() + ": " + e2.getMessage());
                        }
                    }
                }
            }
        }
    }

    private static void c(ArrayList<String> arrayList, File file) {
        try {
            arrayList.add(file.getPath() + " " + file.getCanonicalPath() + (file.exists() ? " exists" : " e-----") + (file.isDirectory() ? " dir" : " d--") + (file.isFile() ? " file" : " f---") + (file.canRead() ? " read" : " r---") + (file.canWrite() ? " write" : " w----"));
        } catch (IOException e2) {
            arrayList.add(e2.getMessage());
        }
    }

    public static Intent getStorageAccessIntent() {
        if (Build.VERSION.SDK_INT >= f1297a) {
            return new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        }
        return null;
    }

    public static void onStorageAccessResult(Intent intent) {
        if (intent != null) {
            fr.maxcom.libmedia.a.f1292a.getContentResolver().takePersistableUriPermission(intent.getData(), intent.getFlags() & 3);
        }
    }

    public static void postponeStorageAccessFrameworkUntilMarshmallow() {
        f1297a = 23;
    }

    public boolean addEmulatedStorageContainer(String str) {
        return addEmulatedStorageContainer(new File(str));
    }

    public String[] getDebugReport() {
        ArrayList<String> arrayList = new ArrayList<>();
        File[] fileArrListRoots = File.listRoots();
        if (fileArrListRoots != null) {
            for (File file : fileArrListRoots) {
                arrayList.add("r " + file.getPath());
            }
        }
        a(arrayList);
        File fileA = a();
        if (fileA != null) {
            c(arrayList, fileA);
            b(arrayList, fileA);
        } else {
            arrayList.add("!msd");
        }
        c(arrayList, new File("/storage/emulated/legacy"));
        File file2 = new File("/storage");
        c(arrayList, file2);
        b(arrayList, file2);
        File file3 = new File("/mnt");
        c(arrayList, file3);
        b(arrayList, file3);
        try {
            arrayList.add("sd " + ((File) Class.forName("android.os.Environment").getMethod("getStorageDirectory", null).invoke(null, null)).getAbsolutePath());
        } catch (NoSuchMethodException e2) {
            arrayList.add("NoSuchMethod: " + e2.getMessage());
        } catch (Exception e3) {
            arrayList.add("Error: " + e3.getMessage());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<fr.maxcom.os.storage.Volume> getVolumes() {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.maxcom.os.storage.VolumeManager.getVolumes():java.util.List");
    }

    public void logDebugReport() {
        for (String str : getDebugReport()) {
            Log.d("VolumeManager", str);
        }
    }

    public boolean addEmulatedStorageContainer(File file) {
        if (!file.isDirectory()) {
            return false;
        }
        if (this.f91a.contains(file)) {
            return true;
        }
        this.f91a.add(file);
        return true;
    }

    private static File a() {
        try {
            return (File) Class.forName("android.os.Environment").getMethod("getMediaStorageDirectory", null).invoke(null, null);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e2) {
            Log.e("VolumeManager", "Error: " + e2.getMessage());
            return null;
        }
    }

    private void a(Set<Volume> set, boolean z, File file, String str, boolean z2) {
        File[] fileArrListFiles = file.listFiles(new a(this, str));
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (z2) {
                    if (z || fr.maxcom.libmedia.a.b() != 1) {
                        set.add(new Volume(file2));
                    }
                } else if (this.f90a != null) {
                    String name = file2.getName();
                    if (!"asec".equalsIgnoreCase(name) && !"media_rw".equalsIgnoreCase(name) && !"obb".equalsIgnoreCase(name) && !"sdcard".equalsIgnoreCase(name) && !ClientCookie.SECURE_ATTR.equalsIgnoreCase(name) && !FasteningElement.ATTR_SHELL.equalsIgnoreCase(name) && !"idd".equalsIgnoreCase(name) && !"shared".equalsIgnoreCase(name)) {
                        try {
                            String canonicalPath = file2.getCanonicalPath();
                            if ("mounted".equals((String) this.f90a.invoke(this.f89a, canonicalPath))) {
                                Method method = this.f1298b;
                                String str2 = method != null ? (String) method.invoke(this.f89a, canonicalPath) : null;
                                if (z || fr.maxcom.libmedia.a.b() != 2) {
                                    set.add(new Volume(file2, str2));
                                }
                            }
                        } catch (IOException e2) {
                            Log.e("VolumeManager", "Error: " + e2.getMessage());
                        } catch (IllegalAccessException e3) {
                            e = e3;
                            Log.e("VolumeManager", e.getClass().getName() + ": " + e.getMessage());
                        } catch (IllegalArgumentException e4) {
                            e = e4;
                            Log.e("VolumeManager", e.getClass().getName() + ": " + e.getMessage());
                        } catch (InvocationTargetException unused) {
                        }
                    }
                }
            }
        }
    }

    private static void a(ArrayList<String> arrayList) {
        Iterator<UsbDevice> it = ((UsbManager) fr.maxcom.libmedia.a.f1292a.getSystemService("usb")).getDeviceList().values().iterator();
        while (it.hasNext()) {
            arrayList.add("USB device: " + it.next().toString());
        }
    }

    private static void a(ArrayList<String> arrayList, File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            arrayList.add("n: " + fileArrListFiles.length);
            int i = 0;
            for (File file2 : fileArrListFiles) {
                c(arrayList, file2);
                i++;
                if (i == 3) {
                    return;
                }
            }
        }
    }
}
