package custom_ui_components.loader;

/* JADX INFO: loaded from: classes9.dex */
public class PWELoaderFactory {
    public static PWELoaderAnimation create(String str) {
        str.hashCode();
        switch (str) {
            case "THREE_BOUNCE":
                return new PWEThreeBounce();
            case "PULSE":
                return new PWEPulse();
            case "ROTATING_CIRCLE":
                return new PWERotatingCircle();
            default:
                return null;
        }
    }
}
