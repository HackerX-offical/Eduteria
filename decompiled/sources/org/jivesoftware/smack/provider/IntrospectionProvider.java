package org.jivesoftware.smack.provider;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class IntrospectionProvider {

    public static abstract class IQIntrospectionProvider<I extends IQ> extends IQProvider<I> {
        private final Class<I> elementClass;

        protected IQIntrospectionProvider(Class<I> cls) {
            this.elementClass = cls;
        }

        @Override // org.jivesoftware.smack.provider.IQProvider
        public I parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            try {
                return (I) IntrospectionProvider.parseWithIntrospection(this.elementClass, xmlPullParser, i);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
                throw new IOException(e2);
            }
        }
    }

    public static abstract class PacketExtensionIntrospectionProvider<PE extends ExtensionElement> extends ExtensionElementProvider<PE> {
        private final Class<PE> elementClass;

        protected PacketExtensionIntrospectionProvider(Class<PE> cls) {
            this.elementClass = cls;
        }

        @Override // org.jivesoftware.smack.provider.Provider
        public PE parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            try {
                return (PE) IntrospectionProvider.parseWithIntrospection(this.elementClass, xmlPullParser, i);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
                throw new IOException(e2);
            }
        }
    }

    public static Object parseWithIntrospection(Class<?> cls, XmlPullParser xmlPullParser, int i) throws IllegalAccessException, XmlPullParserException, NoSuchMethodException, InstantiationException, IOException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        Object objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                String strNextText = xmlPullParser.nextText();
                Class<?> returnType = objNewInstance.getClass().getMethod("get" + Character.toUpperCase(name.charAt(0)) + name.substring(1), new Class[0]).getReturnType();
                objNewInstance.getClass().getMethod("set" + Character.toUpperCase(name.charAt(0)) + name.substring(1), returnType).invoke(objNewInstance, decode(returnType, strNextText));
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return objNewInstance;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.provider.IntrospectionProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static Object decode(Class<?> cls, String str) throws ClassNotFoundException {
        String name = cls.getName();
        name.hashCode();
        switch (name) {
            case "double":
                return Double.valueOf(str);
            case "java.lang.Class":
                return Class.forName(str);
            case "int":
                return Integer.valueOf(str);
            case "byte":
                return Byte.valueOf(str);
            case "long":
                return Long.valueOf(str);
            case "boolean":
                return Boolean.valueOf(str);
            case "float":
                return Float.valueOf(str);
            case "short":
                return Short.valueOf(str);
            case "java.lang.String":
                return str;
            default:
                return null;
        }
    }
}
