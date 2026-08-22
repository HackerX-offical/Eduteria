package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.Utils.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.bouncycastle.i18n.ErrorBundle;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.HtmlTreeBuilderState;
import org.jsoup.parser.Token;

/* JADX INFO: loaded from: classes10.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MaxScopeSearchDepth = 100;
    private static final int maxQueueDepth = 256;
    private static final int maxUsedFormattingElements = 12;
    private boolean baseUriSetFromDoc;

    @Nullable
    private Element contextElement;
    private Token.EndTag emptyEnd;

    @Nullable
    private FormElement formElement;
    private ArrayList<Element> formattingElements;
    private boolean fosterInserts;
    private boolean fragmentParsing;
    private boolean framesetOk;

    @Nullable
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private List<String> pendingTableCharacters;
    private String[] specificScopeTarget = {null};
    private HtmlTreeBuilderState state;
    private ArrayList<HtmlTreeBuilderState> tmplInsertMode;
    static final String[] TagsSearchInScope = {"applet", ShareConstants.FEED_CAPTION_PARAM, "html", "marquee", "object", "table", "td", "th"};
    static final String[] TagSearchList = {XHTMLText.OL, XHTMLText.UL};
    static final String[] TagSearchButton = {"button"};
    static final String[] TagSearchTableScope = {"html", "table"};
    static final String[] TagSearchSelectScope = {"optgroup", "option"};
    static final String[] TagSearchEndTags = {"dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc"};
    static final String[] TagThoroughSearchEndTags = {ShareConstants.FEED_CAPTION_PARAM, "colgroup", "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
    static final String[] TagSearchSpecial = {"address", "applet", Const.AREA, "article", "aside", "base", "basefont", "bgsound", XHTMLText.BLOCKQUOTE, "body", "br", "button", ShareConstants.FEED_CAPTION_PARAM, "center", "col", "colgroup", AdHocCommandData.ELEMENT, "dd", ErrorBundle.DETAIL_ENTRY, "dir", "div", CmcdConfiguration.KEY_DEADLINE, "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TypedValues.AttributesType.S_FRAME, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", XHTMLText.IMG, "input", "isindex", "li", "link", "listing", "marquee", Const.MENU, "meta", "nav", "noembed", "noframes", "noscript", "object", XHTMLText.OL, "p", "param", "plaintext", "pre", "script", DataLayout.Section.ELEMENT, "select", "style", ErrorBundle.SUMMARY_ENTRY, "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", XHTMLText.UL, "wbr", "xmp"};

    @Override // org.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    @Override // org.jsoup.parser.TreeBuilder
    ParseSettings defaultSettings() {
        return ParseSettings.htmlDefault;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.parser.TreeBuilder
    public HtmlTreeBuilder newInstance() {
        return new HtmlTreeBuilder();
    }

    @Override // org.jsoup.parser.TreeBuilder
    @ParametersAreNonnullByDefault
    protected void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.state = HtmlTreeBuilderState.Initial;
        this.originalState = null;
        this.baseUriSetFromDoc = false;
        this.headElement = null;
        this.formElement = null;
        this.contextElement = null;
        this.formattingElements = new ArrayList<>();
        this.tmplInsertMode = new ArrayList<>();
        this.pendingTableCharacters = new ArrayList();
        this.emptyEnd = new Token.EndTag();
        this.framesetOk = true;
        this.fosterInserts = false;
        this.fragmentParsing = false;
    }

    @Override // org.jsoup.parser.TreeBuilder
    List<Node> parseFragment(String str, @Nullable Element element, String str2, Parser parser) {
        Element element2;
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(new StringReader(str), str2, parser);
        this.contextElement = element;
        this.fragmentParsing = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String strNormalName = element.normalName();
            strNormalName.hashCode();
            switch (strNormalName) {
                case "template":
                    this.tokeniser.transition(TokeniserState.Data);
                    pushTemplateMode(HtmlTreeBuilderState.InTemplate);
                    break;
                case "iframe":
                case "xml":
                case "style":
                case "noframes":
                case "noembed":
                    this.tokeniser.transition(TokeniserState.Rawtext);
                    break;
                case "textarea":
                case "title":
                    this.tokeniser.transition(TokeniserState.Rcdata);
                    break;
                case "script":
                    this.tokeniser.transition(TokeniserState.ScriptData);
                    break;
                case "noscript":
                    this.tokeniser.transition(TokeniserState.Data);
                    break;
                case "plaintext":
                    this.tokeniser.transition(TokeniserState.PLAINTEXT);
                    break;
                default:
                    this.tokeniser.transition(TokeniserState.Data);
                    break;
            }
            element2 = new Element(tagFor(strNormalName, this.settings), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            resetInsertionMode();
            Element elementParent = element;
            while (true) {
                if (elementParent != null) {
                    if (elementParent instanceof FormElement) {
                        this.formElement = (FormElement) elementParent;
                    } else {
                        elementParent = elementParent.parent();
                    }
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        if (element != null) {
            List<Node> listSiblingNodes = element2.siblingNodes();
            if (!listSiblingNodes.isEmpty()) {
                element2.insertChildren(-1, listSiblingNodes);
            }
            return element2.childNodes();
        }
        return this.doc.childNodes();
    }

    @Override // org.jsoup.parser.TreeBuilder
    protected boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    HtmlTreeBuilderState state() {
        return this.state;
    }

    void markInsertionMode() {
        this.originalState = this.state;
    }

    HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    boolean framesetOk() {
        return this.framesetOk;
    }

    Document getDocument() {
        return this.doc;
    }

    String getBaseUri() {
        return this.baseUri;
    }

    void maybeSetBaseUri(Element element) {
        if (this.baseUriSetFromDoc) {
            return;
        }
        String strAbsUrl = element.absUrl("href");
        if (strAbsUrl.length() != 0) {
            this.baseUri = strAbsUrl;
            this.baseUriSetFromDoc = true;
            this.doc.setBaseUri(strAbsUrl);
        }
    }

    boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.parser.getErrors().canAddError()) {
            this.parser.getErrors().add(new ParseError(this.reader, "Unexpected %s token [%s] when in state [%s]", this.currentToken.tokenType(), this.currentToken, htmlTreeBuilderState));
        }
    }

    Element insert(Token.StartTag startTag) {
        if (startTag.hasAttributes() && !startTag.attributes.isEmpty() && startTag.attributes.deduplicate(this.settings) > 0) {
            error("Dropped duplicate attribute(s) in tag [%s]", startTag.normalName);
        }
        if (startTag.isSelfClosing()) {
            Element elementInsertEmpty = insertEmpty(startTag);
            this.stack.add(elementInsertEmpty);
            this.tokeniser.transition(TokeniserState.Data);
            this.tokeniser.emit(this.emptyEnd.reset().name(elementInsertEmpty.tagName()));
            return elementInsertEmpty;
        }
        Element element = new Element(tagFor(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        insert(element, startTag);
        return element;
    }

    Element insertStartTag(String str) {
        Element element = new Element(tagFor(str, this.settings), null);
        insert(element);
        return element;
    }

    void insert(Element element) {
        insertNode(element, null);
        this.stack.add(element);
    }

    private void insert(Element element, @Nullable Token token) {
        insertNode(element, token);
        this.stack.add(element);
    }

    Element insertEmpty(Token.StartTag startTag) {
        Tag tagTagFor = tagFor(startTag.name(), this.settings);
        Element element = new Element(tagTagFor, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element, startTag);
        if (startTag.isSelfClosing()) {
            if (tagTagFor.isKnownTag()) {
                if (!tagTagFor.isEmpty()) {
                    this.tokeniser.error("Tag [%s] cannot be self closing; not a void tag", tagTagFor.normalName());
                    return element;
                }
            } else {
                tagTagFor.setSelfClosing();
            }
        }
        return element;
    }

    FormElement insertForm(Token.StartTag startTag, boolean z, boolean z2) {
        FormElement formElement = new FormElement(tagFor(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        if (!z2 || !onStack(SDKConstants.PARAM_UPDATE_TEMPLATE)) {
            setFormElement(formElement);
        }
        insertNode(formElement, startTag);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData()), comment);
    }

    void insert(Token.Character character) {
        Node textNode;
        Element elementCurrentElement = currentElement();
        String strNormalName = elementCurrentElement.normalName();
        String data = character.getData();
        if (character.isCData()) {
            textNode = new CDataNode(data);
        } else if (isContentForTagData(strNormalName)) {
            textNode = new DataNode(data);
        } else {
            textNode = new TextNode(data);
        }
        elementCurrentElement.appendChild(textNode);
        onNodeInserted(textNode, character);
    }

    private void insertNode(Node node, @Nullable Token token) {
        FormElement formElement;
        if (this.stack.isEmpty()) {
            this.doc.appendChild(node);
        } else if (isFosterInserts() && StringUtil.inSorted(currentElement().normalName(), HtmlTreeBuilderState.Constants.InTableFoster)) {
            insertInFosterParent(node);
        } else {
            currentElement().appendChild(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (element.tag().isFormListed() && (formElement = this.formElement) != null) {
                formElement.addElement(element);
            }
        }
        onNodeInserted(node, token);
    }

    Element pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    void push(Element element) {
        this.stack.add(element);
    }

    ArrayList<Element> getStack() {
        return this.stack;
    }

    boolean onStack(Element element) {
        return onStack(this.stack, element);
    }

    boolean onStack(String str) {
        return getFromStack(str) != null;
    }

    private static boolean onStack(ArrayList<Element> arrayList, Element element) {
        int size = arrayList.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        while (i >= i2) {
            if (arrayList.get(i) == element) {
                return true;
            }
            i--;
        }
        return false;
    }

    @Nullable
    Element getFromStack(String str) {
        int size = this.stack.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        while (i >= i2) {
            Element element = this.stack.get(i);
            if (element.normalName().equals(str)) {
                return element;
            }
            i--;
        }
        return null;
    }

    boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    @Nullable
    Element popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (element.normalName().equals(str)) {
                if (this.currentToken instanceof Token.EndTag) {
                    onNodeClosed(element, this.currentToken);
                }
                return element;
            }
        }
        return null;
    }

    void popStackToClose(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (StringUtil.inSorted(element.normalName(), strArr)) {
                return;
            }
        }
    }

    void popStackToBefore(String str) {
        for (int size = this.stack.size() - 1; size >= 0 && !this.stack.get(size).normalName().equals(str); size--) {
            this.stack.remove(size);
        }
    }

    void clearStackToTableContext() {
        clearStackToContext("table", SDKConstants.PARAM_UPDATE_TEMPLATE);
    }

    void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead", SDKConstants.PARAM_UPDATE_TEMPLATE);
    }

    void clearStackToTableRowContext() {
        clearStackToContext("tr", SDKConstants.PARAM_UPDATE_TEMPLATE);
    }

    private void clearStackToContext(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (StringUtil.in(element.normalName(), strArr) || element.normalName().equals("html")) {
                return;
            }
            this.stack.remove(size);
        }
    }

    @Nullable
    Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                return this.stack.get(size - 1);
            }
        }
        return null;
    }

    void insertOnStackAfter(Element element, Element element2) {
        int iLastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(iLastIndexOf != -1);
        this.stack.add(iLastIndexOf + 1, element2);
    }

    void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    private void replaceInQueue(ArrayList<Element> arrayList, Element element, Element element2) {
        int iLastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(iLastIndexOf != -1);
        arrayList.set(iLastIndexOf, element2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean resetInsertionMode() {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.resetInsertionMode():boolean");
    }

    void resetBody() {
        if (!onStack("body")) {
            this.stack.add(this.doc.body());
        }
        transition(HtmlTreeBuilderState.InBody);
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.stack.size();
        int i = size - 1;
        int i2 = i > 100 ? size + VideoDownloadService.VIDEO_FILE_EXIST : 0;
        while (i >= i2) {
            String strNormalName = this.stack.get(i).normalName();
            if (StringUtil.inSorted(strNormalName, strArr)) {
                return true;
            }
            if (StringUtil.inSorted(strNormalName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.inSorted(strNormalName, strArr3)) {
                return false;
            }
            i--;
        }
        return false;
    }

    boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    boolean inScope(String str) {
        return inScope(str, null);
    }

    boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String strNormalName = this.stack.get(size).normalName();
            if (strNormalName.equals(str)) {
                return true;
            }
            if (!StringUtil.inSorted(strNormalName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    void setHeadElement(Element element) {
        this.headElement = element;
    }

    Element getHeadElement() {
        return this.headElement;
    }

    boolean isFosterInserts() {
        return this.fosterInserts;
    }

    void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    @Nullable
    FormElement getFormElement() {
        return this.formElement;
    }

    void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    List<String> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    void generateImpliedEndTags(String str) {
        while (StringUtil.inSorted(currentElement().normalName(), TagSearchEndTags)) {
            if (str != null && currentElementIs(str)) {
                return;
            } else {
                pop();
            }
        }
    }

    void generateImpliedEndTags() {
        generateImpliedEndTags(false);
    }

    void generateImpliedEndTags(boolean z) {
        String[] strArr = z ? TagThoroughSearchEndTags : TagSearchEndTags;
        while (StringUtil.inSorted(currentElement().normalName(), strArr)) {
            pop();
        }
    }

    void closeElement(String str) {
        generateImpliedEndTags(str);
        if (!str.equals(currentElement().normalName())) {
            error(state());
        }
        popStackToClose(str);
    }

    boolean isSpecial(Element element) {
        return StringUtil.inSorted(element.normalName(), TagSearchSpecial);
    }

    Element lastFormattingElement() {
        if (this.formattingElements.size() <= 0) {
            return null;
        }
        return this.formattingElements.get(r0.size() - 1);
    }

    int positionOfElement(Element element) {
        for (int i = 0; i < this.formattingElements.size(); i++) {
            if (element == this.formattingElements.get(i)) {
                return i;
            }
        }
        return -1;
    }

    Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return this.formattingElements.remove(size - 1);
        }
        return null;
    }

    void pushActiveFormattingElements(Element element) {
        checkActiveFormattingElements(element);
        this.formattingElements.add(element);
    }

    void pushWithBookmark(Element element, int i) {
        checkActiveFormattingElements(element);
        try {
            this.formattingElements.add(i, element);
        } catch (IndexOutOfBoundsException unused) {
            this.formattingElements.add(element);
        }
    }

    void checkActiveFormattingElements(Element element) {
        int size = this.formattingElements.size();
        int i = size - 13;
        int i2 = 0;
        if (i < 0) {
            i = 0;
        }
        for (int i3 = size - 1; i3 >= i; i3--) {
            Element element2 = this.formattingElements.get(i3);
            if (element2 == null) {
                return;
            }
            if (isSameFormattingElement(element, element2)) {
                i2++;
            }
            if (i2 == 3) {
                this.formattingElements.remove(i3);
                return;
            }
        }
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.normalName().equals(element2.normalName()) && element.attributes().equals(element2.attributes());
    }

    void reconstructFormattingElements() {
        Element elementLastFormattingElement;
        if (this.stack.size() > 256 || (elementLastFormattingElement = lastFormattingElement()) == null || onStack(elementLastFormattingElement)) {
            return;
        }
        int size = this.formattingElements.size();
        int i = size - 12;
        if (i < 0) {
            i = 0;
        }
        boolean z = true;
        int i2 = size - 1;
        int i3 = i2;
        while (i3 != i) {
            i3--;
            elementLastFormattingElement = this.formattingElements.get(i3);
            if (elementLastFormattingElement == null || onStack(elementLastFormattingElement)) {
                z = false;
                break;
            }
        }
        while (true) {
            if (!z) {
                i3++;
                elementLastFormattingElement = this.formattingElements.get(i3);
            }
            Validate.notNull(elementLastFormattingElement);
            Element element = new Element(tagFor(elementLastFormattingElement.normalName(), this.settings), null, elementLastFormattingElement.attributes().clone());
            insert(element);
            this.formattingElements.set(i3, element);
            if (i3 == i2) {
                return;
            } else {
                z = false;
            }
        }
    }

    void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty() && removeLastFormattingElement() != null) {
        }
    }

    void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (this.formattingElements.get(size) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    boolean isInActiveFormattingElements(Element element) {
        return onStack(this.formattingElements, element);
    }

    Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    void insertInFosterParent(Node node) {
        Element elementAboveOnStack;
        Element fromStack = getFromStack("table");
        boolean z = false;
        if (fromStack != null) {
            if (fromStack.parent() != null) {
                elementAboveOnStack = fromStack.parent();
                z = true;
            } else {
                elementAboveOnStack = aboveOnStack(fromStack);
            }
        } else {
            elementAboveOnStack = this.stack.get(0);
        }
        if (z) {
            Validate.notNull(fromStack);
            fromStack.before(node);
        } else {
            elementAboveOnStack.appendChild(node);
        }
    }

    void pushTemplateMode(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.tmplInsertMode.add(htmlTreeBuilderState);
    }

    @Nullable
    HtmlTreeBuilderState popTemplateMode() {
        if (this.tmplInsertMode.size() <= 0) {
            return null;
        }
        return this.tmplInsertMode.remove(r0.size() - 1);
    }

    int templateModeSize() {
        return this.tmplInsertMode.size();
    }

    @Nullable
    HtmlTreeBuilderState currentTemplateMode() {
        if (this.tmplInsertMode.size() <= 0) {
            return null;
        }
        return this.tmplInsertMode.get(r0.size() - 1);
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }

    @Override // org.jsoup.parser.TreeBuilder
    protected boolean isContentForTagData(String str) {
        return str.equals("script") || str.equals("style");
    }
}
