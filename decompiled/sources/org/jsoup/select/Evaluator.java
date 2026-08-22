package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.PseudoTextElement;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Evaluator {
    public abstract boolean matches(Element element, Element element2);

    protected Evaluator() {
    }

    public static final class Tag extends Evaluator {
        private final String tagName;

        public Tag(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.normalName().equals(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    public static final class TagEndsWith extends Evaluator {
        private final String tagName;

        public TagEndsWith(String str) {
            this.tagName = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.normalName().endsWith(this.tagName);
        }

        public String toString() {
            return String.format("%s", this.tagName);
        }
    }

    public static final class Id extends Evaluator {
        private final String id;

        public Id(String str) {
            this.id = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.id.equals(element2.id());
        }

        public String toString() {
            return String.format("#%s", this.id);
        }
    }

    public static final class Class extends Evaluator {
        private final String className;

        public Class(String str) {
            this.className = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasClass(this.className);
        }

        public String toString() {
            return String.format(".%s", this.className);
        }
    }

    public static final class Attribute extends Evaluator {
        private final String key;

        public Attribute(String str) {
            this.key = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key);
        }

        public String toString() {
            return String.format("[%s]", this.key);
        }
    }

    public static final class AttributeStarting extends Evaluator {
        private final String keyPrefix;

        public AttributeStarting(String str) {
            Validate.notEmpty(str);
            this.keyPrefix = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Iterator<org.jsoup.nodes.Attribute> it = element2.attributes().asList().iterator();
            while (it.hasNext()) {
                if (Normalizer.lowerCase(it.next().getKey()).startsWith(this.keyPrefix)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.keyPrefix);
        }
    }

    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.value.equalsIgnoreCase(element2.attr(this.key).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.key, this.value);
        }
    }

    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return !this.value.equalsIgnoreCase(element2.attr(this.key));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.key, this.value);
        }
    }

    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2, false);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).startsWith(this.value);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.key, this.value);
        }
    }

    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2, false);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).endsWith(this.value);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.key, this.value);
        }
    }

    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && Normalizer.lowerCase(element2.attr(this.key)).contains(this.value);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.key, this.value);
        }
    }

    public static final class AttributeWithValueMatching extends Evaluator {
        String key;
        Pattern pattern;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.key = Normalizer.normalize(str);
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.hasAttr(this.key) && this.pattern.matcher(element2.attr(this.key)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.key, this.pattern.toString());
        }
    }

    public static abstract class AttributeKeyPair extends Evaluator {
        String key;
        String value;

        public AttributeKeyPair(String str, String str2) {
            this(str, str2, true);
        }

        public AttributeKeyPair(String str, String str2, boolean z) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            this.key = Normalizer.normalize(str);
            boolean z2 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
            str2 = z2 ? str2.substring(1, str2.length() - 1) : str2;
            this.value = z ? Normalizer.normalize(str2) : Normalizer.normalize(str2, z2);
        }
    }

    public static final class AllElements extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element != element2 && element2.elementSiblingIndex() < this.index;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.index));
        }
    }

    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() > this.index;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.index));
        }
    }

    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i) {
            super(i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.elementSiblingIndex() == this.index;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.index));
        }
    }

    public static final class IsLastChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            return (elementParent == null || (elementParent instanceof Document) || element2.elementSiblingIndex() != elementParent.children().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        public String toString() {
            return ":last-of-type";
        }
    }

    public static abstract class CssNthEvaluator extends Evaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final int f1502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f1503b;

        protected abstract int calculatePosition(Element element, Element element2);

        protected abstract String getPseudoClass();

        public CssNthEvaluator(int i, int i2) {
            this.f1502a = i;
            this.f1503b = i2;
        }

        public CssNthEvaluator(int i) {
            this(0, i);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            if (elementParent != null && !(elementParent instanceof Document)) {
                int iCalculatePosition = calculatePosition(element, element2);
                int i = this.f1502a;
                if (i == 0) {
                    return iCalculatePosition == this.f1503b;
                }
                int i2 = this.f1503b;
                if ((iCalculatePosition - i2) * i >= 0 && (iCalculatePosition - i2) % i == 0) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            if (this.f1502a == 0) {
                return String.format(":%s(%d)", getPseudoClass(), Integer.valueOf(this.f1503b));
            }
            if (this.f1503b == 0) {
                return String.format(":%s(%dn)", getPseudoClass(), Integer.valueOf(this.f1502a));
            }
            return String.format(":%s(%dn%+d)", getPseudoClass(), Integer.valueOf(this.f1502a), Integer.valueOf(this.f1503b));
        }
    }

    public static final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            return element2.elementSiblingIndex() + 1;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-child";
        }
    }

    public static final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            if (element2.parent() == null) {
                return 0;
            }
            return element2.parent().children().size() - element2.elementSiblingIndex();
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-last-child";
        }
    }

    public static class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            int i = 0;
            if (element2.parent() == null) {
                return 0;
            }
            for (Element element3 : element2.parent().children()) {
                if (element3.tag().equals(element2.tag())) {
                    i++;
                }
                if (element3 == element2) {
                    break;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-of-type";
        }
    }

    public static class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected int calculatePosition(Element element, Element element2) {
            int i = 0;
            if (element2.parent() == null) {
                return 0;
            }
            Elements elementsChildren = element2.parent().children();
            for (int iElementSiblingIndex = element2.elementSiblingIndex(); iElementSiblingIndex < elementsChildren.size(); iElementSiblingIndex++) {
                if (elementsChildren.get(iElementSiblingIndex).tag().equals(element2.tag())) {
                    i++;
                }
            }
            return i;
        }

        @Override // org.jsoup.select.Evaluator.CssNthEvaluator
        protected String getPseudoClass() {
            return "nth-last-of-type";
        }
    }

    public static final class IsFirstChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            return (elementParent == null || (elementParent instanceof Document) || element2.elementSiblingIndex() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class IsRoot extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.child(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class IsOnlyChild extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            return (elementParent == null || (elementParent instanceof Document) || !element2.siblingElements().isEmpty()) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class IsOnlyOfType extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element elementParent = element2.parent();
            if (elementParent != null && !(elementParent instanceof Document)) {
                Iterator<Element> it = elementParent.children().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().tag().equals(element2.tag())) {
                        i++;
                    }
                }
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class IsEmpty extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (Node node : element2.childNodes()) {
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && !(node instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static abstract class IndexEvaluator extends Evaluator {
        int index;

        public IndexEvaluator(int i) {
            this.index = i;
        }
    }

    public static final class ContainsText extends Evaluator {
        private final String searchText;

        public ContainsText(String str) {
            this.searchText = Normalizer.lowerCase(StringUtil.normaliseWhitespace(str));
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.text()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":contains(%s)", this.searchText);
        }
    }

    public static final class ContainsWholeText extends Evaluator {
        private final String searchText;

        public ContainsWholeText(String str) {
            this.searchText = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.wholeText().contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsWholeText(%s)", this.searchText);
        }
    }

    public static final class ContainsWholeOwnText extends Evaluator {
        private final String searchText;

        public ContainsWholeOwnText(String str) {
            this.searchText = str;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element2.wholeOwnText().contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsWholeOwnText(%s)", this.searchText);
        }
    }

    public static final class ContainsData extends Evaluator {
        private final String searchText;

        public ContainsData(String str) {
            this.searchText = Normalizer.lowerCase(str);
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.data()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.searchText);
        }
    }

    public static final class ContainsOwnText extends Evaluator {
        private final String searchText;

        public ContainsOwnText(String str) {
            this.searchText = Normalizer.lowerCase(StringUtil.normaliseWhitespace(str));
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return Normalizer.lowerCase(element2.ownText()).contains(this.searchText);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.searchText);
        }
    }

    public static final class Matches extends Evaluator {
        private final Pattern pattern;

        public Matches(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.text()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.pattern);
        }
    }

    public static final class MatchesOwn extends Evaluator {
        private final Pattern pattern;

        public MatchesOwn(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.ownText()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.pattern);
        }
    }

    public static final class MatchesWholeText extends Evaluator {
        private final Pattern pattern;

        public MatchesWholeText(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.wholeText()).find();
        }

        public String toString() {
            return String.format(":matchesWholeText(%s)", this.pattern);
        }
    }

    public static final class MatchesWholeOwnText extends Evaluator {
        private final Pattern pattern;

        public MatchesWholeOwnText(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return this.pattern.matcher(element2.wholeOwnText()).find();
        }

        public String toString() {
            return String.format(":matchesWholeOwnText(%s)", this.pattern);
        }
    }

    public static final class MatchText extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element2 instanceof PseudoTextElement) {
                return true;
            }
            for (TextNode textNode : element2.textNodes()) {
                PseudoTextElement pseudoTextElement = new PseudoTextElement(org.jsoup.parser.Tag.valueOf(element2.tagName()), element2.baseUri(), element2.attributes());
                textNode.replaceWith(pseudoTextElement);
                pseudoTextElement.appendChild(textNode);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }
}
