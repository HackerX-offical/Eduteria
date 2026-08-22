package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpContentElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public abstract class OpenPgpContentElementProvider<O extends OpenPgpContentElement> extends ExtensionElementProvider<O> {
    private static final Logger LOGGER = Logger.getLogger(OpenPgpContentElementProvider.class.getName());

    @Override // org.jivesoftware.smack.provider.Provider
    public abstract O parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public static OpenPgpContentElement parseOpenPgpContentElement(String str) throws XmlPullParserException, IOException {
        return parseOpenPgpContentElement(PacketParserUtils.getParserFor(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static OpenPgpContentElement parseOpenPgpContentElement(XmlPullParser xmlPullParser) throws XmlPullParserException {
        try {
            String name = xmlPullParser.getName();
            int iHashCode = name.hashCode();
            if (iHashCode != 3530173) {
                if (iHashCode != 94944622) {
                    if (iHashCode == 1075375569 && name.equals(SigncryptElement.ELEMENT)) {
                        return (OpenPgpContentElement) SigncryptElementProvider.INSTANCE.parse(xmlPullParser);
                    }
                } else if (name.equals(CryptElement.ELEMENT)) {
                    return (OpenPgpContentElement) CryptElementProvider.INSTANCE.parse(xmlPullParser);
                }
            } else if (name.equals(SignElement.ELEMENT)) {
                return (OpenPgpContentElement) SignElementProvider.INSTANCE.parse(xmlPullParser);
            }
            throw new XmlPullParserException("Expected <crypt/>, <sign/> or <signcrypt/> element, but got neither of them.");
        } catch (Exception e2) {
            throw new XmlPullParserException(e2.getMessage());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected static OpenPgpContentElementData parseOpenPgpContentElementData(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException, SmackParsingException {
        HashSet hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        Date dateFromXep82String = null;
        String strNextText = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next.ordinal()];
            if (i2 == 1) {
                name.hashCode();
                switch (name) {
                    case "payload":
                        while (true) {
                            XmlPullParser.Event next2 = xmlPullParser.next();
                            String name2 = xmlPullParser.getName();
                            String namespace = xmlPullParser.getNamespace();
                            int i3 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next2.ordinal()];
                            if (i3 == 1) {
                                ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(name2, namespace);
                                if (extensionProvider == null) {
                                    LOGGER.log(Level.INFO, "No provider found for " + name2 + " " + namespace);
                                } else {
                                    linkedList.add(extensionProvider.parse(xmlPullParser));
                                }
                            } else if (i3 != 2) {
                            }
                        }
                        break;
                    case "to":
                        hashSet.add(JidCreate.bareFrom(xmlPullParser.getAttributeValue("", "jid")));
                        break;
                    case "rpad":
                        strNextText = xmlPullParser.nextText();
                        break;
                    case "time":
                        dateFromXep82String = ParserUtils.getDateFromXep82String(xmlPullParser.getAttributeValue("", "stamp"));
                        break;
                }
            } else {
                if (i2 == 2) {
                    name.hashCode();
                    switch (name.hashCode()) {
                        case 3530173:
                            if (!name.equals(SignElement.ELEMENT)) {
                            }
                            break;
                        case 94944622:
                            if (!name.equals(CryptElement.ELEMENT)) {
                            }
                            break;
                        case 1075375569:
                            if (!name.equals(SigncryptElement.ELEMENT)) {
                            }
                            break;
                        default:
                            break;
                    }
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Switch insn not found in header
                        	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                        */
                    /*
                        Method dump skipped, instruction units count: 314
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider.parseOpenPgpContentElementData(org.jivesoftware.smack.xml.XmlPullParser, int):org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider$OpenPgpContentElementData");
                }

                /* JADX INFO: renamed from: org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider$1, reason: invalid class name */
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

                protected static final class OpenPgpContentElementData {
                    protected final List<ExtensionElement> payload;
                    protected final String rpad;
                    protected final Date timestamp;
                    protected final Set<Jid> to;

                    /* synthetic */ OpenPgpContentElementData(Set set, Date date, String str, List list, AnonymousClass1 anonymousClass1) {
                        this(set, date, str, list);
                    }

                    private OpenPgpContentElementData(Set<Jid> set, Date date, String str, List<ExtensionElement> list) {
                        this.to = set;
                        this.timestamp = date;
                        this.rpad = str;
                        this.payload = list;
                    }
                }
            }
