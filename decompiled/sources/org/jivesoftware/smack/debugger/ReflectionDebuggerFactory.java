package org.jivesoftware.smack.debugger;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;

/* JADX INFO: loaded from: classes10.dex */
public final class ReflectionDebuggerFactory implements SmackDebuggerFactory {
    private static final String DEBUGGER_CLASS_PROPERTY_NAME = "smack.debuggerClass";
    private static final Logger LOGGER = Logger.getLogger(ReflectionDebuggerFactory.class.getName());
    public static final ReflectionDebuggerFactory INSTANCE = new ReflectionDebuggerFactory();
    private static final String[] DEFAULT_DEBUGGERS = {"org.jivesoftware.smackx.debugger.EnhancedDebugger", "org.jivesoftware.smackx.debugger.android.AndroidDebugger", "org.jivesoftware.smack.debugger.ConsoleDebugger", "org.jivesoftware.smack.debugger.LiteDebugger", "org.jivesoftware.smack.debugger.JulDebugger"};

    private ReflectionDebuggerFactory() {
    }

    public static void setDebuggerClass(Class<? extends SmackDebugger> cls) {
        if (cls != null) {
            System.setProperty(DEBUGGER_CLASS_PROPERTY_NAME, cls.getCanonicalName());
        } else {
            System.clearProperty(DEBUGGER_CLASS_PROPERTY_NAME);
        }
    }

    public static Class<SmackDebugger> getDebuggerClass() {
        String customDebuggerClassName = getCustomDebuggerClassName();
        if (customDebuggerClassName == null) {
            return getOneOfDefaultDebuggerClasses();
        }
        try {
            return Class.forName(customDebuggerClassName);
        } catch (Exception e2) {
            LOGGER.log(Level.WARNING, "Unable to instantiate debugger class " + customDebuggerClassName, (Throwable) e2);
            return null;
        }
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebuggerFactory
    public SmackDebugger create(XMPPConnection xMPPConnection) throws IllegalArgumentException {
        Class<SmackDebugger> debuggerClass = getDebuggerClass();
        if (debuggerClass == null) {
            return null;
        }
        try {
            return debuggerClass.getConstructor(XMPPConnection.class).newInstance(xMPPConnection);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
        }
    }

    private static String getCustomDebuggerClassName() {
        try {
            return System.getProperty(DEBUGGER_CLASS_PROPERTY_NAME);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<SmackDebugger> getOneOfDefaultDebuggerClasses() {
        String[] strArr = DEFAULT_DEBUGGERS;
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (!SmackConfiguration.isDisabledSmackClass(str)) {
                try {
                    return Class.forName(str);
                } catch (ClassCastException unused) {
                    LOGGER.warning("Found debugger class that does not appears to implement SmackDebugger interface");
                } catch (ClassNotFoundException unused2) {
                    LOGGER.fine("Did not find debugger class '" + str + "'");
                } catch (Exception unused3) {
                    LOGGER.warning("Unable to instantiate either Smack debugger class");
                }
            }
        }
        return null;
    }
}
