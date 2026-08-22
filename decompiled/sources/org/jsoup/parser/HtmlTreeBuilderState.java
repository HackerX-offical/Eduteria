package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.appnew.android.Utils.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import org.bouncycastle.i18n.ErrorBundle;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.parser.Token;

/* JADX INFO: loaded from: classes10.dex */
enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype doctypeAsDoctype = token.asDoctype();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(doctypeAsDoctype.getName()), doctypeAsDoctype.getPublicIdentifier(), doctypeAsDoctype.getSystemIdentifier());
                documentType.setPubSysKey(doctypeAsDoctype.getPubSysKey());
                htmlTreeBuilder.getDocument().appendChild(documentType);
                htmlTreeBuilder.onNodeInserted(documentType, token);
                if (doctypeAsDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(BeforeHtml);
            } else {
                htmlTreeBuilder.transition(BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (!token.isComment()) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    htmlTreeBuilder.insert(token.asCharacter());
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                    htmlTreeBuilder.insert(token.asStartTag());
                    htmlTreeBuilder.transition(BeforeHead);
                    return true;
                }
                if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            htmlTreeBuilder.insert(token.asComment());
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return InBody.process(token, htmlTreeBuilder);
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("head")) {
                htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                htmlTreeBuilder.transition(InHead);
                return true;
            }
            if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                htmlTreeBuilder.processStartTag("head");
                return htmlTreeBuilder.process(token);
            }
            if (token.isEndTag()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.processStartTag("head");
            return htmlTreeBuilder.process(token);
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass25.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (i == 3) {
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strNormalName = startTagAsStartTag.normalName();
                    if (strNormalName.equals("html")) {
                        return InBody.process(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InHeadEmpty)) {
                        Element elementInsertEmpty = htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        if (strNormalName.equals("base") && elementInsertEmpty.hasAttr("href")) {
                            htmlTreeBuilder.maybeSetBaseUri(elementInsertEmpty);
                        }
                    } else if (strNormalName.equals("meta")) {
                        htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    } else if (strNormalName.equals("title")) {
                        HtmlTreeBuilderState.handleRcData(startTagAsStartTag, htmlTreeBuilder);
                    } else if (StringUtil.inSorted(strNormalName, Constants.InHeadRaw)) {
                        HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    } else if (strNormalName.equals("noscript")) {
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.transition(InHeadNoscript);
                    } else if (strNormalName.equals("script")) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.transition(Text);
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else {
                        if (strNormalName.equals("head")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        if (strNormalName.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                            htmlTreeBuilder.insert(startTagAsStartTag);
                            htmlTreeBuilder.insertMarkerToFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                            htmlTreeBuilder.transition(InTemplate);
                            htmlTreeBuilder.pushTemplateMode(InTemplate);
                        } else {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                    }
                } else if (i == 4) {
                    String strNormalName2 = token.asEndTag().normalName();
                    if (strNormalName2.equals("head")) {
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(AfterHead);
                    } else {
                        if (StringUtil.inSorted(strNormalName2, Constants.InHeadEnd)) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        if (strNormalName2.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                            if (!htmlTreeBuilder.onStack(strNormalName2)) {
                                htmlTreeBuilder.error(this);
                            } else {
                                htmlTreeBuilder.generateImpliedEndTags(true);
                                if (!strNormalName2.equals(htmlTreeBuilder.currentElement().normalName())) {
                                    htmlTreeBuilder.error(this);
                                }
                                htmlTreeBuilder.popStackToClose(strNormalName2);
                                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                                htmlTreeBuilder.popTemplateMode();
                                htmlTreeBuilder.resetInsertionMode();
                            }
                        } else {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                    }
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (!token.isEndTag() || !token.asEndTag().normalName().equals("noscript")) {
                if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoScriptHead))) {
                    return htmlTreeBuilder.process(token, InHead);
                }
                if (token.isEndTag() && token.asEndTag().normalName().equals("br")) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) || token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(InHead);
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            }
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (strNormalName.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (strNormalName.equals("body")) {
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InBody);
                    return true;
                }
                if (strNormalName.equals("frameset")) {
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InBodyStartToHead)) {
                    htmlTreeBuilder.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder.push(headElement);
                    htmlTreeBuilder.process(token, InHead);
                    htmlTreeBuilder.removeFromStack(headElement);
                    return true;
                }
                if (strNormalName.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                anythingElse(token, htmlTreeBuilder);
                return true;
            }
            if (token.isEndTag()) {
                String strNormalName2 = token.asEndTag().normalName();
                if (StringUtil.inSorted(strNormalName2, Constants.AfterHeadBody)) {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
                if (strNormalName2.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                    htmlTreeBuilder.process(token, InHead);
                    return true;
                }
                htmlTreeBuilder.error(this);
                return false;
            }
            anythingElse(token, htmlTreeBuilder);
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        private static final int MaxStackScan = 24;

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass25.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    return inBodyStartTag(token, htmlTreeBuilder);
                case 4:
                    return inBodyEndTag(token, htmlTreeBuilder);
                case 5:
                    Token.Character characterAsCharacter = token.asCharacter();
                    if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.framesetOk() && HtmlTreeBuilderState.isWhitespace(characterAsCharacter)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(characterAsCharacter);
                        return true;
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(characterAsCharacter);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 6:
                    if (htmlTreeBuilder.templateModeSize() > 0) {
                        return htmlTreeBuilder.process(token, InTemplate);
                    }
                    return true;
                default:
                    return true;
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private boolean inBodyStartTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Element fromStack;
            String str;
            FormElement formElement;
            byte b2;
            Token.StartTag startTagAsStartTag = token.asStartTag();
            String strNormalName = startTagAsStartTag.normalName();
            strNormalName.hashCode();
            byte b3 = -1;
            switch (strNormalName.hashCode()) {
                case -1644953643:
                    if (strNormalName.equals("frameset")) {
                        b3 = 0;
                    }
                    break;
                case -1377687758:
                    if (strNormalName.equals("button")) {
                        b3 = 1;
                    }
                    break;
                case -1191214428:
                    if (strNormalName.equals("iframe")) {
                        b3 = 2;
                    }
                    break;
                case -1134665583:
                    if (strNormalName.equals("keygen")) {
                        b2 = 3;
                        b3 = b2;
                    }
                    break;
                case -1010136971:
                    if (strNormalName.equals("option")) {
                        b2 = 4;
                        b3 = b2;
                    }
                    break;
                case -1003243718:
                    if (strNormalName.equals("textarea")) {
                        b2 = 5;
                        b3 = b2;
                    }
                    break;
                case -906021636:
                    if (strNormalName.equals("select")) {
                        b2 = 6;
                        b3 = b2;
                    }
                    break;
                case -891985998:
                    if (strNormalName.equals("strike")) {
                        b2 = 7;
                        b3 = b2;
                    }
                    break;
                case -891980137:
                    if (strNormalName.equals(XHTMLText.STRONG)) {
                        b2 = 8;
                        b3 = b2;
                    }
                    break;
                case -80773204:
                    if (strNormalName.equals("optgroup")) {
                        b2 = 9;
                        b3 = b2;
                    }
                    break;
                case 97:
                    if (strNormalName.equals("a")) {
                        b2 = 10;
                        b3 = b2;
                    }
                    break;
                case 98:
                    if (strNormalName.equals("b")) {
                        b2 = 11;
                        b3 = b2;
                    }
                    break;
                case 105:
                    if (strNormalName.equals(CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT)) {
                        b2 = 12;
                        b3 = b2;
                    }
                    break;
                case 115:
                    if (strNormalName.equals(CmcdData.Factory.STREAMING_FORMAT_SS)) {
                        b2 = 13;
                        b3 = b2;
                    }
                    break;
                case 117:
                    if (strNormalName.equals("u")) {
                        b2 = 14;
                        b3 = b2;
                    }
                    break;
                case 3152:
                    if (strNormalName.equals("br")) {
                        b2 = Ascii.SI;
                        b3 = b2;
                    }
                    break;
                case 3200:
                    if (strNormalName.equals("dd")) {
                        b2 = 16;
                        b3 = b2;
                    }
                    break;
                case 3216:
                    if (strNormalName.equals("dt")) {
                        b2 = 17;
                        b3 = b2;
                    }
                    break;
                case 3240:
                    if (strNormalName.equals("em")) {
                        b2 = Ascii.DC2;
                        b3 = b2;
                    }
                    break;
                case 3273:
                    if (strNormalName.equals("h1")) {
                        b2 = 19;
                        b3 = b2;
                    }
                    break;
                case 3274:
                    if (strNormalName.equals("h2")) {
                        b2 = Ascii.DC4;
                        b3 = b2;
                    }
                    break;
                case 3275:
                    if (strNormalName.equals("h3")) {
                        b2 = Ascii.NAK;
                        b3 = b2;
                    }
                    break;
                case 3276:
                    if (strNormalName.equals("h4")) {
                        b2 = Ascii.SYN;
                        b3 = b2;
                    }
                    break;
                case 3277:
                    if (strNormalName.equals("h5")) {
                        b2 = Ascii.ETB;
                        b3 = b2;
                    }
                    break;
                case 3278:
                    if (strNormalName.equals("h6")) {
                        b3 = Ascii.CAN;
                    }
                    break;
                case 3338:
                    if (strNormalName.equals("hr")) {
                        b3 = 25;
                    }
                    break;
                case 3453:
                    if (strNormalName.equals("li")) {
                        b2 = Ascii.SUB;
                        b3 = b2;
                    }
                    break;
                case 3646:
                    if (strNormalName.equals("rp")) {
                        b2 = Ascii.ESC;
                        b3 = b2;
                    }
                    break;
                case 3650:
                    if (strNormalName.equals("rt")) {
                        b2 = Ascii.FS;
                        b3 = b2;
                    }
                    break;
                case 3712:
                    if (strNormalName.equals("tt")) {
                        b2 = Ascii.GS;
                        b3 = b2;
                    }
                    break;
                case 97536:
                    if (strNormalName.equals("big")) {
                        b2 = Ascii.RS;
                        b3 = b2;
                    }
                    break;
                case 104387:
                    if (strNormalName.equals(XHTMLText.IMG)) {
                        b2 = Ascii.US;
                        b3 = b2;
                    }
                    break;
                case 111267:
                    if (strNormalName.equals("pre")) {
                        b2 = 32;
                        b3 = b2;
                    }
                    break;
                case 114276:
                    if (strNormalName.equals("svg")) {
                        b2 = 33;
                        b3 = b2;
                    }
                    break;
                case 117511:
                    if (strNormalName.equals("wbr")) {
                        b2 = 34;
                        b3 = b2;
                    }
                    break;
                case 118811:
                    if (strNormalName.equals("xmp")) {
                        b2 = 35;
                        b3 = b2;
                    }
                    break;
                case 3002509:
                    if (strNormalName.equals(Const.AREA)) {
                        b2 = 36;
                        b3 = b2;
                    }
                    break;
                case 3029410:
                    if (strNormalName.equals("body")) {
                        b2 = 37;
                        b3 = b2;
                    }
                    break;
                case 3059181:
                    if (strNormalName.equals("code")) {
                        b2 = 38;
                        b3 = b2;
                    }
                    break;
                case 3148879:
                    if (strNormalName.equals("font")) {
                        b2 = 39;
                        b3 = b2;
                    }
                    break;
                case 3148996:
                    if (strNormalName.equals("form")) {
                        b2 = 40;
                        b3 = b2;
                    }
                    break;
                case 3213227:
                    if (strNormalName.equals("html")) {
                        b2 = 41;
                        b3 = b2;
                    }
                    break;
                case 3344136:
                    if (strNormalName.equals("math")) {
                        b2 = 42;
                        b3 = b2;
                    }
                    break;
                case 3386833:
                    if (strNormalName.equals("nobr")) {
                        b2 = 43;
                        b3 = b2;
                    }
                    break;
                case 3536714:
                    if (strNormalName.equals("span")) {
                        b2 = 44;
                        b3 = b2;
                    }
                    break;
                case 96620249:
                    if (strNormalName.equals("embed")) {
                        b2 = 45;
                        b3 = b2;
                    }
                    break;
                case 100313435:
                    if (strNormalName.equals("image")) {
                        b2 = 46;
                        b3 = b2;
                    }
                    break;
                case 100358090:
                    if (strNormalName.equals("input")) {
                        b2 = 47;
                        b3 = b2;
                    }
                    break;
                case 109548807:
                    if (strNormalName.equals("small")) {
                        b2 = 48;
                        b3 = b2;
                    }
                    break;
                case 110115790:
                    if (strNormalName.equals("table")) {
                        b2 = 49;
                        b3 = b2;
                    }
                    break;
                case 181975684:
                    if (strNormalName.equals("listing")) {
                        b2 = 50;
                        b3 = b2;
                    }
                    break;
                case 1973234167:
                    if (strNormalName.equals("plaintext")) {
                        b2 = 51;
                        b3 = b2;
                    }
                    break;
                case 2091304424:
                    if (strNormalName.equals("isindex")) {
                        b2 = 52;
                        b3 = b2;
                    }
                    break;
                case 2115613112:
                    if (strNormalName.equals("noembed")) {
                        b2 = 53;
                        b3 = b2;
                    }
                    break;
            }
            switch (b3) {
                case 0:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    if (stack.size() == 1) {
                        return false;
                    }
                    if ((stack.size() > 2 && !stack.get(1).normalName().equals("body")) || !htmlTreeBuilder.framesetOk()) {
                        return false;
                    }
                    Element element = stack.get(1);
                    if (element.parent() != null) {
                        element.remove();
                    }
                    while (stack.size() > 1) {
                        stack.remove(stack.size() - 1);
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                    return true;
                case 1:
                    if (htmlTreeBuilder.inButtonScope("button")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("button");
                        htmlTreeBuilder.process(startTagAsStartTag);
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.framesetOk(false);
                    }
                    return true;
                case 2:
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    return true;
                case 3:
                case 15:
                case 31:
                case 34:
                case 36:
                case 45:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 4:
                case 9:
                    if (htmlTreeBuilder.currentElementIs("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 5:
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    if (!startTagAsStartTag.isSelfClosing()) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(Text);
                    }
                    return true;
                case 6:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    if (!startTagAsStartTag.selfClosing) {
                        HtmlTreeBuilderState htmlTreeBuilderStateState = htmlTreeBuilder.state();
                        if (htmlTreeBuilderStateState.equals(InTable) || htmlTreeBuilderStateState.equals(InCaption) || htmlTreeBuilderStateState.equals(InTableBody) || htmlTreeBuilderStateState.equals(InRow) || htmlTreeBuilderStateState.equals(InCell)) {
                            htmlTreeBuilder.transition(InSelectInTable);
                        } else {
                            htmlTreeBuilder.transition(InSelect);
                        }
                    }
                    return true;
                case 7:
                case 8:
                case 11:
                case 12:
                case 13:
                case 14:
                case 18:
                case 29:
                case 30:
                case 38:
                case 39:
                case 48:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTagAsStartTag));
                    return true;
                case 10:
                    if (htmlTreeBuilder.getActiveFormattingElement("a") != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("a");
                        Element fromStack2 = htmlTreeBuilder.getFromStack("a");
                        if (fromStack2 != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack2);
                            htmlTreeBuilder.removeFromStack(fromStack2);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTagAsStartTag));
                    return true;
                case 16:
                case 17:
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                    int size = stack2.size();
                    int i = size - 1;
                    int i2 = i >= 24 ? size - 25 : 0;
                    while (true) {
                        if (i >= i2) {
                            Element element2 = stack2.get(i);
                            if (StringUtil.inSorted(element2.normalName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element2.normalName());
                            } else if (!htmlTreeBuilder.isSpecial(element2) || StringUtil.inSorted(element2.normalName(), Constants.InBodyStartLiBreakers)) {
                                i--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.pop();
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 25:
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 26:
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                    int size2 = stack3.size() - 1;
                    while (true) {
                        if (size2 > 0) {
                            Element element3 = stack3.get(size2);
                            if (element3.normalName().equals("li")) {
                                htmlTreeBuilder.processEndTag("li");
                            } else if (!htmlTreeBuilder.isSpecial(element3) || StringUtil.inSorted(element3.normalName(), Constants.InBodyStartLiBreakers)) {
                                size2--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 27:
                case 28:
                    if (htmlTreeBuilder.inScope("ruby")) {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs("ruby")) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.popStackToBefore("ruby");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    }
                    return true;
                case 32:
                case 50:
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.reader.matchConsume("\n");
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 33:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 35:
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    return true;
                case 37:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                    if (stack4.size() == 1) {
                        return false;
                    }
                    if ((stack4.size() > 2 && !stack4.get(1).normalName().equals("body")) || htmlTreeBuilder.onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        return false;
                    }
                    htmlTreeBuilder.framesetOk(false);
                    if (startTagAsStartTag.hasAttributes() && (fromStack = htmlTreeBuilder.getFromStack("body")) != null) {
                        for (Attribute attribute : startTagAsStartTag.attributes) {
                            if (!fromStack.hasAttr(attribute.getKey())) {
                                fromStack.attributes().put(attribute);
                            }
                        }
                    }
                    return true;
                case 40:
                    if (htmlTreeBuilder.getFormElement() != null && !htmlTreeBuilder.onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.closeElement("p");
                    }
                    htmlTreeBuilder.insertForm(startTagAsStartTag, true, true);
                    return true;
                case 41:
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        return false;
                    }
                    if (htmlTreeBuilder.getStack().size() > 0) {
                        Element element4 = htmlTreeBuilder.getStack().get(0);
                        if (startTagAsStartTag.hasAttributes()) {
                            for (Attribute attribute2 : startTagAsStartTag.attributes) {
                                if (!element4.hasAttr(attribute2.getKey())) {
                                    element4.attributes().put(attribute2);
                                }
                            }
                        }
                    }
                    return true;
                case 42:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 43:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.inScope("nobr")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("nobr");
                        htmlTreeBuilder.reconstructFormattingElements();
                    }
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(startTagAsStartTag));
                    return true;
                case 44:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 46:
                    if (htmlTreeBuilder.getFromStack("svg") == null) {
                        return htmlTreeBuilder.process(startTagAsStartTag.name(XHTMLText.IMG));
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    return true;
                case 47:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (!htmlTreeBuilder.insertEmpty(startTagAsStartTag).attr("type").equalsIgnoreCase("hidden")) {
                        htmlTreeBuilder.framesetOk(false);
                    }
                    return true;
                case 49:
                    if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InTable);
                    return true;
                case 51:
                    if (htmlTreeBuilder.inButtonScope("p")) {
                        htmlTreeBuilder.processEndTag("p");
                    }
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    return true;
                case 52:
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.getFormElement() != null) {
                        return false;
                    }
                    htmlTreeBuilder.processStartTag("form");
                    if (startTagAsStartTag.hasAttribute("action") && (formElement = htmlTreeBuilder.getFormElement()) != null && startTagAsStartTag.hasAttribute("action")) {
                        formElement.attributes().put("action", startTagAsStartTag.attributes.get("action"));
                    }
                    htmlTreeBuilder.processStartTag("hr");
                    htmlTreeBuilder.processStartTag("label");
                    if (startTagAsStartTag.hasAttribute("prompt")) {
                        str = startTagAsStartTag.attributes.get("prompt");
                    } else {
                        str = "This is a searchable index. Enter search keywords: ";
                    }
                    htmlTreeBuilder.process(new Token.Character().data(str));
                    Attributes attributes = new Attributes();
                    if (startTagAsStartTag.hasAttributes()) {
                        for (Attribute attribute3 : startTagAsStartTag.attributes) {
                            if (!StringUtil.inSorted(attribute3.getKey(), Constants.InBodyStartInputAttribs)) {
                                attributes.put(attribute3);
                            }
                        }
                    }
                    attributes.put("name", "isindex");
                    htmlTreeBuilder.processStartTag("input", attributes);
                    htmlTreeBuilder.processEndTag("label");
                    htmlTreeBuilder.processStartTag("hr");
                    htmlTreeBuilder.processEndTag("form");
                    return true;
                case 53:
                    HtmlTreeBuilderState.handleRawtext(startTagAsStartTag, htmlTreeBuilder);
                    return true;
                default:
                    if (!Tag.isKnownTag(strNormalName)) {
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else if (StringUtil.inSorted(strNormalName, Constants.InBodyStartPClosers)) {
                        if (htmlTreeBuilder.inButtonScope("p")) {
                            htmlTreeBuilder.processEndTag("p");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else {
                        if (StringUtil.inSorted(strNormalName, Constants.InBodyStartToHead)) {
                            return htmlTreeBuilder.process(token, InHead);
                        }
                        if (StringUtil.inSorted(strNormalName, Constants.InBodyStartApplets)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(startTagAsStartTag);
                            htmlTreeBuilder.insertMarkerToFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                        } else if (StringUtil.inSorted(strNormalName, Constants.InBodyStartMedia)) {
                            htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        } else {
                            if (StringUtil.inSorted(strNormalName, Constants.InBodyStartDrop)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(startTagAsStartTag);
                            return true;
                        }
                    }
                    return true;
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private boolean inBodyEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.EndTag endTagAsEndTag = token.asEndTag();
            String strNormalName = endTagAsEndTag.normalName();
            strNormalName.hashCode();
            byte b2 = -1;
            switch (strNormalName.hashCode()) {
                case -1321546630:
                    if (strNormalName.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        b2 = 0;
                    }
                    break;
                case 112:
                    if (strNormalName.equals("p")) {
                        b2 = 1;
                    }
                    break;
                case 3152:
                    if (strNormalName.equals("br")) {
                        b2 = 2;
                    }
                    break;
                case 3200:
                    if (strNormalName.equals("dd")) {
                        b2 = 3;
                    }
                    break;
                case 3216:
                    if (strNormalName.equals("dt")) {
                        b2 = 4;
                    }
                    break;
                case 3273:
                    if (strNormalName.equals("h1")) {
                        b2 = 5;
                    }
                    break;
                case 3274:
                    if (strNormalName.equals("h2")) {
                        b2 = 6;
                    }
                    break;
                case 3275:
                    if (strNormalName.equals("h3")) {
                        b2 = 7;
                    }
                    break;
                case 3276:
                    if (strNormalName.equals("h4")) {
                        b2 = 8;
                    }
                    break;
                case 3277:
                    if (strNormalName.equals("h5")) {
                        b2 = 9;
                    }
                    break;
                case 3278:
                    if (strNormalName.equals("h6")) {
                        b2 = 10;
                    }
                    break;
                case 3453:
                    if (strNormalName.equals("li")) {
                        b2 = 11;
                    }
                    break;
                case 3029410:
                    if (strNormalName.equals("body")) {
                        b2 = 12;
                    }
                    break;
                case 3148996:
                    if (strNormalName.equals("form")) {
                        b2 = 13;
                    }
                    break;
                case 3213227:
                    if (strNormalName.equals("html")) {
                        b2 = 14;
                    }
                    break;
                case 3536714:
                    if (strNormalName.equals("span")) {
                        b2 = Ascii.SI;
                    }
                    break;
                case 1869063452:
                    if (strNormalName.equals("sarcasm")) {
                        b2 = 16;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    htmlTreeBuilder.process(token, InHead);
                    return true;
                case 1:
                    if (!htmlTreeBuilder.inButtonScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(strNormalName);
                        return htmlTreeBuilder.process(endTagAsEndTag);
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("br");
                    return false;
                case 3:
                case 4:
                    if (!htmlTreeBuilder.inScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    return true;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    if (!htmlTreeBuilder.inScope(Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(Constants.Headings);
                    return true;
                case 11:
                    if (!htmlTreeBuilder.inListItemScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(strNormalName);
                    if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    return true;
                case 12:
                    if (!htmlTreeBuilder.inScope("body")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    anyOtherEndTag(token, htmlTreeBuilder);
                    htmlTreeBuilder.transition(AfterBody);
                    return true;
                case 13:
                    if (!htmlTreeBuilder.onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        FormElement formElement = htmlTreeBuilder.getFormElement();
                        htmlTreeBuilder.setFormElement(null);
                        if (formElement == null || !htmlTreeBuilder.inScope(strNormalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                    } else {
                        if (!htmlTreeBuilder.inScope(strNormalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strNormalName);
                    }
                    return true;
                case 14:
                    if (htmlTreeBuilder.processEndTag("body")) {
                        return htmlTreeBuilder.process(endTagAsEndTag);
                    }
                    return true;
                case 15:
                case 16:
                    return anyOtherEndTag(token, htmlTreeBuilder);
                default:
                    if (StringUtil.inSorted(strNormalName, Constants.InBodyEndAdoptionFormatters)) {
                        return inBodyEndTagAdoption(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InBodyEndClosers)) {
                        if (!htmlTreeBuilder.inScope(strNormalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(strNormalName);
                    } else if (StringUtil.inSorted(strNormalName, Constants.InBodyStartApplets)) {
                        if (!htmlTreeBuilder.inScope("name")) {
                            if (!htmlTreeBuilder.inScope(strNormalName)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                                htmlTreeBuilder.error(this);
                            }
                            htmlTreeBuilder.popStackToClose(strNormalName);
                            htmlTreeBuilder.clearFormattingElementsToLastMarker();
                        }
                    } else {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    return true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean anyOtherEndTag(org.jsoup.parser.Token r7, org.jsoup.parser.HtmlTreeBuilder r8) {
            /*
                r6 = this;
                org.jsoup.parser.Token$EndTag r7 = r7.asEndTag()
                java.lang.String r7 = r7.normalName
                java.util.ArrayList r0 = r8.getStack()
                org.jsoup.nodes.Element r1 = r8.getFromStack(r7)
                r2 = 0
                if (r1 != 0) goto L15
                r8.error(r6)
                return r2
            L15:
                int r1 = r0.size()
                r3 = 1
                int r1 = r1 - r3
            L1b:
                if (r1 < 0) goto L4a
                java.lang.Object r4 = r0.get(r1)
                org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
                java.lang.String r5 = r4.normalName()
                boolean r5 = r5.equals(r7)
                if (r5 == 0) goto L3d
                r8.generateImpliedEndTags(r7)
                boolean r0 = r8.currentElementIs(r7)
                if (r0 != 0) goto L39
                r8.error(r6)
            L39:
                r8.popStackToClose(r7)
                goto L4a
            L3d:
                boolean r4 = r8.isSpecial(r4)
                if (r4 == 0) goto L47
                r8.error(r6)
                return r2
            L47:
                int r1 = r1 + (-1)
                goto L1b
            L4a:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.anyOtherEndTag(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6, types: [int] */
        private boolean inBodyEndTagAdoption(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String strNormalName = token.asEndTag().normalName();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            boolean z = false;
            int i = 0;
            while (i < 8) {
                Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(strNormalName);
                if (activeFormattingElement == null) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                }
                if (!htmlTreeBuilder.inScope(activeFormattingElement.normalName())) {
                    htmlTreeBuilder.error(this);
                    return z;
                }
                if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                    htmlTreeBuilder.error(this);
                }
                int size = stack.size();
                Element element = null;
                int iPositionOfElement = -1;
                boolean z2 = z;
                int i2 = 1;
                Element element2 = null;
                while (true) {
                    if (i2 >= size || i2 >= 64) {
                        break;
                    }
                    Element element3 = stack.get(i2);
                    if (element3 == activeFormattingElement) {
                        element2 = stack.get(i2 - 1);
                        iPositionOfElement = htmlTreeBuilder.positionOfElement(element3);
                        z2 = true;
                    } else if (z2 && htmlTreeBuilder.isSpecial(element3)) {
                        element = element3;
                        break;
                    }
                    i2++;
                }
                if (element == null) {
                    htmlTreeBuilder.popStackToClose(activeFormattingElement.normalName());
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                }
                Element elementAboveOnStack = element;
                Element element4 = elementAboveOnStack;
                for (?? r8 = z; r8 < 3; r8++) {
                    if (htmlTreeBuilder.onStack(elementAboveOnStack)) {
                        elementAboveOnStack = htmlTreeBuilder.aboveOnStack(elementAboveOnStack);
                    }
                    if (!htmlTreeBuilder.isInActiveFormattingElements(elementAboveOnStack)) {
                        htmlTreeBuilder.removeFromStack(elementAboveOnStack);
                    } else {
                        if (elementAboveOnStack == activeFormattingElement) {
                            break;
                        }
                        Element element5 = new Element(htmlTreeBuilder.tagFor(elementAboveOnStack.nodeName(), ParseSettings.preserveCase), htmlTreeBuilder.getBaseUri());
                        htmlTreeBuilder.replaceActiveFormattingElement(elementAboveOnStack, element5);
                        htmlTreeBuilder.replaceOnStack(elementAboveOnStack, element5);
                        if (element4 == element) {
                            iPositionOfElement = htmlTreeBuilder.positionOfElement(element5) + 1;
                        }
                        if (element4.parent() != null) {
                            element4.remove();
                        }
                        element5.appendChild(element4);
                        elementAboveOnStack = element5;
                        element4 = elementAboveOnStack;
                    }
                }
                if (element2 != null) {
                    if (StringUtil.inSorted(element2.normalName(), Constants.InBodyEndTableFosters)) {
                        if (element4.parent() != null) {
                            element4.remove();
                        }
                        htmlTreeBuilder.insertInFosterParent(element4);
                    } else {
                        if (element4.parent() != null) {
                            element4.remove();
                        }
                        element2.appendChild(element4);
                    }
                }
                Element element6 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                element6.attributes().addAll(activeFormattingElement.attributes());
                element6.appendChildren(element.childNodes());
                element.appendChild(element6);
                htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                htmlTreeBuilder.pushWithBookmark(element6, iPositionOfElement);
                htmlTreeBuilder.removeFromStack(activeFormattingElement);
                htmlTreeBuilder.insertOnStackAfter(element, element6);
                i++;
                z = false;
            }
            return true;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            }
            if (!token.isEndTag()) {
                return true;
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return true;
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter() && StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(InTableText);
                return htmlTreeBuilder.process(token);
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (strNormalName.equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(InCaption);
                } else if (strNormalName.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(InColumnGroup);
                } else {
                    if (strNormalName.equals("col")) {
                        htmlTreeBuilder.clearStackToTableContext();
                        htmlTreeBuilder.processStartTag("colgroup");
                        return htmlTreeBuilder.process(token);
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InTableToBody)) {
                        htmlTreeBuilder.clearStackToTableContext();
                        htmlTreeBuilder.insert(startTagAsStartTag);
                        htmlTreeBuilder.transition(InTableBody);
                    } else {
                        if (StringUtil.inSorted(strNormalName, Constants.InTableAddBody)) {
                            htmlTreeBuilder.clearStackToTableContext();
                            htmlTreeBuilder.processStartTag("tbody");
                            return htmlTreeBuilder.process(token);
                        }
                        if (strNormalName.equals("table")) {
                            htmlTreeBuilder.error(this);
                            if (!htmlTreeBuilder.inTableScope(strNormalName)) {
                                return false;
                            }
                            htmlTreeBuilder.popStackToClose(strNormalName);
                            if (!htmlTreeBuilder.resetInsertionMode()) {
                                htmlTreeBuilder.insert(startTagAsStartTag);
                                return true;
                            }
                            return htmlTreeBuilder.process(token);
                        }
                        if (StringUtil.inSorted(strNormalName, Constants.InTableToHead)) {
                            return htmlTreeBuilder.process(token, InHead);
                        }
                        if (strNormalName.equals("input")) {
                            if (!startTagAsStartTag.hasAttributes() || !startTagAsStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                                return anythingElse(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                        } else if (strNormalName.equals("form")) {
                            htmlTreeBuilder.error(this);
                            if (htmlTreeBuilder.getFormElement() != null || htmlTreeBuilder.onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                                return false;
                            }
                            htmlTreeBuilder.insertForm(startTagAsStartTag, false, false);
                        } else {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                    }
                }
                return true;
            }
            if (token.isEndTag()) {
                String strNormalName2 = token.asEndTag().normalName();
                if (strNormalName2.equals("table")) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                } else {
                    if (StringUtil.inSorted(strNormalName2, Constants.InTableEndErr)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (strNormalName2.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        htmlTreeBuilder.process(token, InHead);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
                return true;
            }
            if (token.isEOF()) {
                if (htmlTreeBuilder.currentElementIs("html")) {
                    htmlTreeBuilder.error(this);
                }
                return true;
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.setFosterInserts(true);
            htmlTreeBuilder.process(token, InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return true;
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.type == Token.TokenType.Character) {
                Token.Character characterAsCharacter = token.asCharacter();
                if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(characterAsCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (!HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                        }
                    } else {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().normalName().equals(ShareConstants.FEED_CAPTION_PARAM)) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElementIs(ShareConstants.FEED_CAPTION_PARAM)) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose(ShareConstants.FEED_CAPTION_PARAM);
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(InTable);
                return true;
            }
            if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) || (token.isEndTag() && token.asEndTag().normalName().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag(ShareConstants.FEED_CAPTION_PARAM)) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            }
            if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
                htmlTreeBuilder.error(this);
                return false;
            }
            return htmlTreeBuilder.process(token, InBody);
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.StartTag startTagAsStartTag;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass25.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    htmlTreeBuilder.error(this);
                } else if (i == 3) {
                    startTagAsStartTag = token.asStartTag();
                    String strNormalName = startTagAsStartTag.normalName();
                    strNormalName.hashCode();
                    switch (strNormalName) {
                        case "template":
                            htmlTreeBuilder.process(token, InHead);
                            break;
                        case "col":
                            htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                            break;
                        case "html":
                            return htmlTreeBuilder.process(token, InBody);
                        default:
                            return anythingElse(token, htmlTreeBuilder);
                    }
                } else {
                    if (i != 4) {
                        if (i == 6) {
                            if (htmlTreeBuilder.currentElementIs("html")) {
                                return true;
                            }
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    String strNormalName2 = token.asEndTag().normalName();
                    strNormalName2.hashCode();
                    if (strNormalName2.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        htmlTreeBuilder.process(token, InHead);
                    } else if (strNormalName2.equals("colgroup")) {
                        if (!htmlTreeBuilder.currentElementIs(strNormalName2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(InTable);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
            } else {
                htmlTreeBuilder.insert(token.asComment());
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.currentElementIs("colgroup")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(InTable);
            htmlTreeBuilder.process(token);
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass25.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (strNormalName.equals("tr")) {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(InRow);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InCellNames)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("tr");
                    return htmlTreeBuilder.process(startTagAsStartTag);
                }
                if (StringUtil.inSorted(strNormalName, Constants.InTableBodyExit)) {
                    return exitTableBody(token, htmlTreeBuilder);
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            if (i == 4) {
                String strNormalName2 = token.asEndTag().normalName();
                if (StringUtil.inSorted(strNormalName2, Constants.InTableEndIgnore)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTable);
                    return true;
                }
                if (strNormalName2.equals("table")) {
                    return exitTableBody(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(strNormalName2, Constants.InTableBodyEndIgnore)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
            return htmlTreeBuilder.process(token);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag startTagAsStartTag = token.asStartTag();
                String strNormalName = startTagAsStartTag.normalName();
                if (StringUtil.inSorted(strNormalName, Constants.InCellNames)) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(startTagAsStartTag);
                    htmlTreeBuilder.transition(InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InRowMissing)) {
                    return handleMissingTr(token, htmlTreeBuilder);
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            if (token.isEndTag()) {
                String strNormalName2 = token.asEndTag().normalName();
                if (strNormalName2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                    return true;
                }
                if (strNormalName2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(strNormalName2, Constants.InTableToBody)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName2) || !htmlTreeBuilder.inTableScope("tr")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName2, Constants.InRowIgnore)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String strNormalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(strNormalName, Constants.InCellNames)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElementIs(strNormalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(strNormalName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(InRow);
                    return true;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InCellBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (StringUtil.inSorted(strNormalName, Constants.InCellTable)) {
                    if (!htmlTreeBuilder.inTableScope(strNormalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
                return anythingElse(token, htmlTreeBuilder);
            }
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) {
                if (!htmlTreeBuilder.inTableScope("td") && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                closeCell(htmlTreeBuilder);
                return htmlTreeBuilder.process(token);
            }
            return anythingElse(token, htmlTreeBuilder);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.processEndTag("td");
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String strNormalName;
            switch (AnonymousClass25.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag startTagAsStartTag = token.asStartTag();
                    String strNormalName2 = startTagAsStartTag.normalName();
                    if (strNormalName2.equals("html")) {
                        return htmlTreeBuilder.process(startTagAsStartTag, InBody);
                    }
                    if (strNormalName2.equals("option")) {
                        if (htmlTreeBuilder.currentElementIs("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else if (strNormalName2.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElementIs("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElementIs("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(startTagAsStartTag);
                    } else {
                        if (strNormalName2.equals("select")) {
                            htmlTreeBuilder.error(this);
                            return htmlTreeBuilder.processEndTag("select");
                        }
                        if (StringUtil.inSorted(strNormalName2, Constants.InSelectEnd)) {
                            htmlTreeBuilder.error(this);
                            if (!htmlTreeBuilder.inSelectScope("select")) {
                                return false;
                            }
                            htmlTreeBuilder.processEndTag("select");
                            return htmlTreeBuilder.process(startTagAsStartTag);
                        }
                        if (strNormalName2.equals("script") || strNormalName2.equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                            return htmlTreeBuilder.process(token, InHead);
                        }
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    return true;
                case 4:
                    strNormalName = token.asEndTag().normalName();
                    strNormalName.hashCode();
                    switch (strNormalName) {
                        case "template":
                            return htmlTreeBuilder.process(token, InHead);
                        case "option":
                            if (htmlTreeBuilder.currentElementIs("option")) {
                                htmlTreeBuilder.pop();
                            } else {
                                htmlTreeBuilder.error(this);
                            }
                            return true;
                        case "select":
                            if (!htmlTreeBuilder.inSelectScope(strNormalName)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.popStackToClose(strNormalName);
                            htmlTreeBuilder.resetInsertionMode();
                            return true;
                        case "optgroup":
                            if (htmlTreeBuilder.currentElementIs("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).normalName().equals("optgroup")) {
                                htmlTreeBuilder.processEndTag("option");
                            }
                            if (htmlTreeBuilder.currentElementIs("optgroup")) {
                                htmlTreeBuilder.pop();
                            } else {
                                htmlTreeBuilder.error(this);
                            }
                            return true;
                        default:
                            return anythingElse(token, htmlTreeBuilder);
                    }
                case 5:
                    Token.Character characterAsCharacter = token.asCharacter();
                    if (characterAsCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(characterAsCharacter);
                    return true;
                case 6:
                    if (!htmlTreeBuilder.currentElementIs("html")) {
                        htmlTreeBuilder.error(this);
                    }
                    return true;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InSelectTableEnd)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.popStackToClose("select");
                htmlTreeBuilder.resetInsertionMode();
                return htmlTreeBuilder.process(token);
            }
            if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InSelectTableEnd)) {
                htmlTreeBuilder.error(this);
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    return false;
                }
                htmlTreeBuilder.popStackToClose("select");
                htmlTreeBuilder.resetInsertionMode();
                return htmlTreeBuilder.process(token);
            }
            return htmlTreeBuilder.process(token, InSelect);
        }
    },
    InTemplate { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass25.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                case 2:
                case 5:
                    htmlTreeBuilder.process(token, InBody);
                    return true;
                case 3:
                    String strNormalName = token.asStartTag().normalName();
                    if (StringUtil.inSorted(strNormalName, Constants.InTemplateToHead)) {
                        htmlTreeBuilder.process(token, InHead);
                        return true;
                    }
                    if (StringUtil.inSorted(strNormalName, Constants.InTemplateToTable)) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InTable);
                        htmlTreeBuilder.transition(InTable);
                        return htmlTreeBuilder.process(token);
                    }
                    if (strNormalName.equals("col")) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InColumnGroup);
                        htmlTreeBuilder.transition(InColumnGroup);
                        return htmlTreeBuilder.process(token);
                    }
                    if (strNormalName.equals("tr")) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InTableBody);
                        htmlTreeBuilder.transition(InTableBody);
                        return htmlTreeBuilder.process(token);
                    }
                    if (strNormalName.equals("td") || strNormalName.equals("th")) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InRow);
                        htmlTreeBuilder.transition(InRow);
                        return htmlTreeBuilder.process(token);
                    }
                    htmlTreeBuilder.popTemplateMode();
                    htmlTreeBuilder.pushTemplateMode(InBody);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                case 4:
                    if (token.asEndTag().normalName().equals(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        htmlTreeBuilder.process(token, InHead);
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                case 6:
                    if (!htmlTreeBuilder.onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.popStackToClose(SDKConstants.PARAM_UPDATE_TEMPLATE);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.popTemplateMode();
                    htmlTreeBuilder.resetInsertionMode();
                    if (htmlTreeBuilder.state() == InTemplate || htmlTreeBuilder.templateModeSize() >= 12) {
                        return true;
                    }
                    return htmlTreeBuilder.process(token);
                default:
                    return true;
            }
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (htmlTreeBuilder.onStack("html")) {
                    htmlTreeBuilder.popStackToClose("html");
                }
                htmlTreeBuilder.transition(AfterAfterBody);
                return true;
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.resetBody();
            return htmlTreeBuilder.process(token);
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.StartTag startTagAsStartTag;
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else {
                if (token.isDoctype()) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                if (token.isStartTag()) {
                    startTagAsStartTag = token.asStartTag();
                    String strNormalName = startTagAsStartTag.normalName();
                    strNormalName.hashCode();
                    switch (strNormalName) {
                        case "frameset":
                            htmlTreeBuilder.insert(startTagAsStartTag);
                            break;
                        case "html":
                            return htmlTreeBuilder.process(startTagAsStartTag, InBody);
                        case "frame":
                            htmlTreeBuilder.insertEmpty(startTagAsStartTag);
                            break;
                        case "noframes":
                            return htmlTreeBuilder.process(startTagAsStartTag, InHead);
                        default:
                            htmlTreeBuilder.error(this);
                            return false;
                    }
                } else if (token.isEndTag() && token.asEndTag().normalName().equals("frameset")) {
                    if (htmlTreeBuilder.currentElementIs("html")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.pop();
                    if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElementIs("frameset")) {
                        htmlTreeBuilder.transition(AfterFrameset);
                    }
                } else if (token.isEOF()) {
                    if (!htmlTreeBuilder.currentElementIs("html")) {
                        htmlTreeBuilder.error(this);
                    }
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                htmlTreeBuilder.transition(AfterAfterFrameset);
                return true;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                return htmlTreeBuilder.process(token, InHead);
            }
            if (token.isEOF()) {
                return true;
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (!token.isDoctype() && (!token.isStartTag() || !token.asStartTag().normalName().equals("html"))) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    htmlTreeBuilder.insert(token.asCharacter());
                    return true;
                }
                if (token.isEOF()) {
                    return true;
                }
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.resetBody();
                return htmlTreeBuilder.process(token);
            }
            return htmlTreeBuilder.process(token, InBody);
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
            if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            }
            if (token.isEOF()) {
                return true;
            }
            if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                return htmlTreeBuilder.process(token, InHead);
            }
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.24
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };

    private static final String nullString = String.valueOf((char) 0);

    abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* JADX INFO: renamed from: org.jsoup.parser.HtmlTreeBuilderState$25, reason: invalid class name */
    static /* synthetic */ class AnonymousClass25 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return StringUtil.isBlank(token.asCharacter().getData());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return StringUtil.isBlank(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    static final class Constants {
        static final String[] InHeadEmpty = {"base", "basefont", "bgsound", AdHocCommandData.ELEMENT, "link"};
        static final String[] InHeadRaw = {"noframes", "style"};
        static final String[] InHeadEnd = {"body", "br", "html"};
        static final String[] AfterHeadBody = {"body", "br", "html"};
        static final String[] BeforeHtmlToHead = {"body", "br", "head", "html"};
        static final String[] InHeadNoScriptHead = {"basefont", "bgsound", "link", "meta", "noframes", "style"};
        static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", AdHocCommandData.ELEMENT, "link", "meta", "noframes", "script", "style", SDKConstants.PARAM_UPDATE_TEMPLATE, "title"};
        static final String[] InBodyStartPClosers = {"address", "article", "aside", XHTMLText.BLOCKQUOTE, "center", ErrorBundle.DETAIL_ENTRY, "dir", "div", CmcdConfiguration.KEY_DEADLINE, "fieldset", "figcaption", "figure", "footer", "header", "hgroup", Const.MENU, "nav", XHTMLText.OL, "p", DataLayout.Section.ELEMENT, ErrorBundle.SUMMARY_ENTRY, XHTMLText.UL};
        static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        static final String[] InBodyStartLiBreakers = {"address", "div", "p"};
        static final String[] DdDt = {"dd", "dt"};
        static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        static final String[] InBodyStartMedia = {"param", "source", "track"};
        static final String[] InBodyStartInputAttribs = {"action", "name", "prompt"};
        static final String[] InBodyStartDrop = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", TypedValues.AttributesType.S_FRAME, "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InBodyEndClosers = {"address", "article", "aside", XHTMLText.BLOCKQUOTE, "button", "center", ErrorBundle.DETAIL_ENTRY, "dir", "div", CmcdConfiguration.KEY_DEADLINE, "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", Const.MENU, "nav", XHTMLText.OL, "pre", DataLayout.Section.ELEMENT, ErrorBundle.SUMMARY_ENTRY, XHTMLText.UL};
        static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", "em", "font", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "nobr", CmcdData.Factory.STREAMING_FORMAT_SS, "small", "strike", XHTMLText.STRONG, "tt", "u"};
        static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InTableToBody = {"tbody", "tfoot", "thead"};
        static final String[] InTableAddBody = {"td", "th", "tr"};
        static final String[] InTableToHead = {"script", "style", SDKConstants.PARAM_UPDATE_TEMPLATE};
        static final String[] InCellNames = {"td", "th"};
        static final String[] InCellBody = {"body", ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html"};
        static final String[] InCellTable = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InCellCol = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableEndErr = {"body", ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableFoster = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InTableBodyExit = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "tfoot", "thead"};
        static final String[] InTableBodyEndIgnore = {"body", ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "td", "th", "tr"};
        static final String[] InRowMissing = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        static final String[] InRowIgnore = {"body", ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "td", "th"};
        static final String[] InSelectEnd = {"input", "keygen", "textarea"};
        static final String[] InSelectTableEnd = {ShareConstants.FEED_CAPTION_PARAM, "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableEndIgnore = {"tbody", "tfoot", "thead"};
        static final String[] InHeadNoscriptIgnore = {"head", "noscript"};
        static final String[] InCaptionIgnore = {"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTemplateToHead = {"base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", SDKConstants.PARAM_UPDATE_TEMPLATE, "title"};
        static final String[] InTemplateToTable = {ShareConstants.FEED_CAPTION_PARAM, "colgroup", "tbody", "tfoot", "thead"};

        Constants() {
        }
    }
}
