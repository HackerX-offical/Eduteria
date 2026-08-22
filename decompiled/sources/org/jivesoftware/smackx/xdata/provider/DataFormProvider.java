package org.jivesoftware.smackx.xdata.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.BooleanFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdata.FormFieldWithOptions;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class DataFormProvider extends ExtensionElementProvider<DataForm> {
    private static final Logger LOGGER = Logger.getLogger(DataFormProvider.class.getName());
    public static final DataFormProvider INSTANCE = new DataFormProvider();

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0012, code lost:
    
        continue;
     */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.jivesoftware.smackx.xdata.packet.DataForm parse(org.jivesoftware.smack.xml.XmlPullParser r11, int r12, org.jivesoftware.smack.packet.XmlEnvironment r13) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdata.provider.DataFormProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.xdata.packet.DataForm");
    }

    private static FormField parseField(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str) throws XmlPullParserException, IOException, SmackParsingException {
        return parseField(xmlPullParser, xmlEnvironment, str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [org.jivesoftware.smackx.xdata.AbstractMultiFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v13, types: [org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v15, types: [org.jivesoftware.smackx.xdata.AbstractMultiFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v17, types: [org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v18, types: [org.jivesoftware.smackx.xdata.FormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v22, types: [org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.jivesoftware.smackx.xdata.FormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v7, types: [org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v8, types: [org.jivesoftware.smackx.xdata.JidMultiFormField$Builder] */
    /* JADX WARN: Type inference failed for: r0v9, types: [org.jivesoftware.smackx.xdata.JidSingleFormField$Builder] */
    private static FormField parseField(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str, DataForm.ReportedData reportedData) throws XmlPullParserException, SmackParsingException, IOException {
        ?? booleanFormField;
        FormField field;
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue("var");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "label");
        String attributeValue3 = xmlPullParser.getAttributeValue("type");
        FormField.Type typeFromString = attributeValue3 != null ? FormField.Type.fromString(attributeValue3) : null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i == 1) {
                QName qName = xmlPullParser.getQName();
                if (qName.equals(FormField.Value.QNAME)) {
                    arrayList.add(parseValue(xmlPullParser));
                } else if (qName.equals(FormField.Option.QNAME)) {
                    arrayList2.add(parseOption(xmlPullParser));
                } else if (qName.equals(FormField.Required.QNAME)) {
                    z = true;
                } else {
                    FormFieldChildElementProvider<?> formFieldChildElementProvider = FormFieldChildElementProviderManager.getFormFieldChildElementProvider(qName);
                    if (formFieldChildElementProvider == null) {
                        LOGGER.warning("Unknown form field child element " + qName + " ignored");
                    } else {
                        arrayList3.add((FormFieldChildElement) formFieldChildElementProvider.parse(xmlPullParser, XmlEnvironment.from(xmlPullParser, xmlEnvironment)));
                    }
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                break;
            }
        }
        if (typeFromString == null && reportedData != null && (field = reportedData.getField(attributeValue)) != null) {
            typeFromString = field.getType();
        }
        if (typeFromString == null) {
            if (attributeValue.equals(FormField.FORM_TYPE)) {
                typeFromString = FormField.Type.hidden;
            } else {
                typeFromString = FormFieldRegistry.lookup(str, attributeValue);
                if (typeFromString == null) {
                    LOGGER.warning("The Field '" + attributeValue + "' from FORM_TYPE '" + str + "' is not registered. Field type is unknown, assuming text-single.");
                    typeFromString = FormField.Type.text_single;
                }
            }
        }
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[typeFromString.ordinal()]) {
            case 1:
                booleanFormField = parseBooleanFormField(attributeValue, arrayList);
                break;
            case 2:
                booleanFormField = parseSingleKindFormField(FormField.fixedBuilder(attributeValue), arrayList);
                break;
            case 3:
                booleanFormField = parseSingleKindFormField(FormField.hiddenBuilder(attributeValue), arrayList);
                break;
            case 4:
                booleanFormField = FormField.jidMultiBuilder(attributeValue);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    booleanFormField.addValue((FormField.Value) it.next());
                }
                break;
            case 5:
                ensureAtMostSingleValue(typeFromString, arrayList);
                booleanFormField = FormField.jidSingleBuilder(attributeValue);
                if (!arrayList.isEmpty()) {
                    booleanFormField.setValue((FormField.Value) arrayList.get(0));
                }
                break;
            case 6:
                ListMultiFormField.Builder builderListMultiBuilder = FormField.listMultiBuilder(attributeValue);
                addOptionsToBuilder(arrayList2, builderListMultiBuilder);
                booleanFormField = parseMultiKindFormField(builderListMultiBuilder, arrayList);
                break;
            case 7:
                ListSingleFormField.Builder builderListSingleBuilder = FormField.listSingleBuilder(attributeValue);
                addOptionsToBuilder(arrayList2, builderListSingleBuilder);
                booleanFormField = parseSingleKindFormField(builderListSingleBuilder, arrayList);
                break;
            case 8:
                booleanFormField = parseMultiKindFormField(FormField.textMultiBuilder(attributeValue), arrayList);
                break;
            case 9:
                booleanFormField = parseSingleKindFormField(FormField.textPrivateBuilder(attributeValue), arrayList);
                break;
            case 10:
                booleanFormField = parseSingleKindFormField(FormField.textSingleBuilder(attributeValue), arrayList);
                break;
            default:
                throw new AssertionError("Unknown type " + typeFromString);
        }
        int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[typeFromString.ordinal()];
        if (i2 != 6 && i2 != 7 && !arrayList2.isEmpty()) {
            throw new SmackParsingException("Form fields of type " + typeFromString + " must not have options. This one had " + arrayList2.size());
        }
        if (attributeValue2 != null) {
            booleanFormField.setLabel(attributeValue2);
        }
        booleanFormField.setRequired(z);
        booleanFormField.addFormFieldChildElements(arrayList3);
        return booleanFormField.build();
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.xdata.provider.DataFormProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[FormField.Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[FormField.Type.bool.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.fixed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_multi.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_single.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_multi.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_single.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_multi.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_private.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_single.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[XmlPullParser.TagEvent.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = iArr2;
            try {
                iArr2[XmlPullParser.TagEvent.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[XmlPullParser.TagEvent.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr3;
            try {
                iArr3[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private static FormField.Builder<?, ?> parseBooleanFormField(String str, List<FormField.Value> list) throws SmackParsingException {
        BooleanFormField.Builder builderBooleanBuilder = FormField.booleanBuilder(str);
        ensureAtMostSingleValue(builderBooleanBuilder.getType(), list);
        if (list.size() == 1) {
            builderBooleanBuilder.setValue(list.get(0));
        }
        return builderBooleanBuilder;
    }

    private static AbstractSingleStringValueFormField.Builder<?, ?> parseSingleKindFormField(AbstractSingleStringValueFormField.Builder<?, ?> builder, List<FormField.Value> list) throws SmackParsingException {
        ensureAtMostSingleValue(builder.getType(), list);
        if (list.size() == 1) {
            builder.setValue(list.get(0).getValue().toString());
        }
        return builder;
    }

    private static AbstractMultiFormField.Builder<?, ?> parseMultiKindFormField(AbstractMultiFormField.Builder<?, ?> builder, List<FormField.Value> list) {
        Iterator<FormField.Value> it = list.iterator();
        while (it.hasNext()) {
            builder.addValue(it.next().getValue());
        }
        return builder;
    }

    private static DataForm.Item parseItem(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str, DataForm.ReportedData reportedData) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.ELEMENT)) {
                    arrayList.add(parseField(xmlPullParser, XmlEnvironment.from(xmlPullParser, xmlEnvironment), str, reportedData));
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new DataForm.Item(arrayList);
            }
        }
    }

    private static DataForm.ReportedData parseReported(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, String str) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.ELEMENT)) {
                    arrayList.add(parseField(xmlPullParser, XmlEnvironment.from(xmlPullParser, xmlEnvironment), str));
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new DataForm.ReportedData(arrayList);
            }
        }
    }

    public static FormField.Value parseValue(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return new FormField.Value(xmlPullParser.nextText());
    }

    public static FormField.Option parseOption(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue("", "label");
        FormField.Option option = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("value")) {
                    option = new FormField.Option(attributeValue, xmlPullParser.nextText());
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return option;
            }
        }
    }

    private static void ensureAtMostSingleValue(FormField.Type type, List<FormField.Value> list) throws SmackParsingException {
        if (list.size() > 1) {
            throw new SmackParsingException(type + " fields can have at most one value, this one had " + list.size());
        }
    }

    private static void addOptionsToBuilder(Collection<FormField.Option> collection, FormFieldWithOptions.Builder<?> builder) {
        Iterator<FormField.Option> it = collection.iterator();
        while (it.hasNext()) {
            builder.addOption(it.next());
        }
    }
}
