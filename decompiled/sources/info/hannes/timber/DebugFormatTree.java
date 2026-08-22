package info.hannes.timber;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: compiled from: DebugFormatTree.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0014J,\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Linfo/hannes/timber/DebugFormatTree;", "Ltimber/log/Timber$DebugTree;", "newLogcat", "", "<init>", "(Z)V", "codeIdentifier", "", FirebaseAnalytics.Param.METHOD, "createStackElementTag", "element", "Ljava/lang/StackTraceElement;", "log", "", "priority", "", "tag", "message", "t", "", "LogcatCore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class DebugFormatTree extends Timber.DebugTree {
    private String codeIdentifier;
    private String method;
    private final boolean newLogcat;

    public DebugFormatTree() {
        this(false, 1, null);
    }

    public DebugFormatTree(boolean z) {
        this.newLogcat = z;
        this.codeIdentifier = "";
        this.method = "";
    }

    public /* synthetic */ DebugFormatTree(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    @Override // timber.log.Timber.DebugTree
    protected String createStackElementTag(StackTraceElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        String strReplaceFirst$default = null;
        if (this.newLogcat) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strCreateStackElementTag = super.createStackElementTag(element);
            if (strCreateStackElementTag != null) {
                String fileName = element.getFileName();
                Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                int length = fileName.length();
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (fileName.charAt(i) == '.') {
                            fileName = fileName.substring(0, i);
                            Intrinsics.checkNotNullExpressionValue(fileName, "substring(...)");
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                strReplaceFirst$default = StringsKt.replaceFirst$default(strCreateStackElementTag, fileName, "", false, 4, (Object) null);
            }
            String str = String.format("%s.%s()", Arrays.copyOf(new Object[]{strReplaceFirst$default, element.getMethodName()}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.method = str;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("(%s:%d)", Arrays.copyOf(new Object[]{element.getFileName(), Integer.valueOf(element.getLineNumber())}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            this.codeIdentifier = str2;
            return "(" + element.getFileName() + ":" + element.getLineNumber() + ")";
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String fileName2 = element.getFileName();
        Integer numValueOf = Integer.valueOf(element.getLineNumber());
        String strCreateStackElementTag2 = super.createStackElementTag(element);
        if (strCreateStackElementTag2 != null) {
            String fileName3 = element.getFileName();
            Intrinsics.checkNotNullExpressionValue(fileName3, "getFileName(...)");
            int length2 = fileName3.length();
            int i2 = 0;
            while (true) {
                if (i2 < length2) {
                    if (fileName3.charAt(i2) == '.') {
                        fileName3 = fileName3.substring(0, i2);
                        Intrinsics.checkNotNullExpressionValue(fileName3, "substring(...)");
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            strReplaceFirst$default = StringsKt.replaceFirst$default(strCreateStackElementTag2, fileName3, "", false, 4, (Object) null);
        }
        String str3 = String.format("(%s:%d) %s.%s()", Arrays.copyOf(new Object[]{fileName2, numValueOf, strReplaceFirst$default, element.getMethodName()}, 4));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        return str3;
    }

    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    protected void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        String string = StringsKt.trim((CharSequence) message).toString();
        if (StringsKt.startsWith$default(string, "{", false, 2, (Object) null) && StringsKt.endsWith$default(string, "}", false, 2, (Object) null)) {
            try {
                string = new JSONObject(message).toString(3);
            } catch (JSONException unused) {
            }
        }
        super.log(priority, tag, this.method + ": " + string, t);
    }
}
