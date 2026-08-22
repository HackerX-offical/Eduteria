package org.jsoup.parser;

import javax.annotation.Nullable;
import okio.Utf8;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;

/* JADX INFO: loaded from: classes10.dex */
abstract class Token {
    static final int Unset = -1;
    private int endPos;
    private int startPos;
    TokenType type;

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    private Token() {
        this.endPos = -1;
    }

    String tokenType() {
        return getClass().getSimpleName();
    }

    Token reset() {
        this.startPos = -1;
        this.endPos = -1;
        return this;
    }

    int startPos() {
        return this.startPos;
    }

    void startPos(int i) {
        this.startPos = i;
    }

    int endPos() {
        return this.endPos;
    }

    void endPos(int i) {
        this.endPos = i;
    }

    static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    static final class Doctype extends Token {
        boolean forceQuirks;
        final StringBuilder name;
        String pubSysKey;
        final StringBuilder publicIdentifier;
        final StringBuilder systemIdentifier;

        Doctype() {
            super();
            this.name = new StringBuilder();
            this.pubSysKey = null;
            this.publicIdentifier = new StringBuilder();
            this.systemIdentifier = new StringBuilder();
            this.forceQuirks = false;
            this.type = TokenType.Doctype;
        }

        @Override // org.jsoup.parser.Token
        Token reset() {
            super.reset();
            reset(this.name);
            this.pubSysKey = null;
            reset(this.publicIdentifier);
            reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }

        String getName() {
            return this.name.toString();
        }

        String getPubSysKey() {
            return this.pubSysKey;
        }

        String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }

        public String toString() {
            return "<!doctype " + getName() + ">";
        }
    }

    static abstract class Tag extends Token {
        private static final int MaxAttributes = 512;
        private final StringBuilder attrName;

        @Nullable
        private String attrNameS;
        private final StringBuilder attrValue;

        @Nullable
        private String attrValueS;

        @Nullable
        Attributes attributes;
        private boolean hasAttrName;
        private boolean hasAttrValue;
        private boolean hasEmptyAttrValue;

        @Nullable
        protected String normalName;
        boolean selfClosing;

        @Nullable
        protected String tagName;

        public abstract String toString();

        Tag() {
            super();
            this.attrName = new StringBuilder();
            this.hasAttrName = false;
            this.attrValue = new StringBuilder();
            this.hasAttrValue = false;
            this.hasEmptyAttrValue = false;
            this.selfClosing = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.tagName = null;
            this.normalName = null;
            reset(this.attrName);
            this.attrNameS = null;
            this.hasAttrName = false;
            reset(this.attrValue);
            this.attrValueS = null;
            this.hasEmptyAttrValue = false;
            this.hasAttrValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        final void newAttribute() {
            String string;
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            if (this.hasAttrName && this.attributes.size() < 512) {
                String strTrim = (this.attrName.length() > 0 ? this.attrName.toString() : this.attrNameS).trim();
                if (strTrim.length() > 0) {
                    if (this.hasAttrValue) {
                        string = this.attrValue.length() > 0 ? this.attrValue.toString() : this.attrValueS;
                    } else {
                        string = this.hasEmptyAttrValue ? "" : null;
                    }
                    this.attributes.add(strTrim, string);
                }
            }
            reset(this.attrName);
            this.attrNameS = null;
            this.hasAttrName = false;
            reset(this.attrValue);
            this.attrValueS = null;
            this.hasAttrValue = false;
            this.hasEmptyAttrValue = false;
        }

        final boolean hasAttributes() {
            return this.attributes != null;
        }

        final boolean hasAttribute(String str) {
            Attributes attributes = this.attributes;
            return attributes != null && attributes.hasKey(str);
        }

        final void finaliseTag() {
            if (this.hasAttrName) {
                newAttribute();
            }
        }

        final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        final String normalName() {
            return this.normalName;
        }

        final String toStringName() {
            String str = this.tagName;
            return str != null ? str : "[unset]";
        }

        final Tag name(String str) {
            this.tagName = str;
            this.normalName = ParseSettings.normalName(str);
            return this;
        }

        final boolean isSelfClosing() {
            return this.selfClosing;
        }

        final void appendTagName(String str) {
            String strReplace = str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER);
            String str2 = this.tagName;
            if (str2 != null) {
                strReplace = str2.concat(strReplace);
            }
            this.tagName = strReplace;
            this.normalName = ParseSettings.normalName(strReplace);
        }

        final void appendTagName(char c2) {
            appendTagName(String.valueOf(c2));
        }

        final void appendAttributeName(String str) {
            String strReplace = str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER);
            ensureAttrName();
            if (this.attrName.length() == 0) {
                this.attrNameS = strReplace;
            } else {
                this.attrName.append(strReplace);
            }
        }

        final void appendAttributeName(char c2) {
            ensureAttrName();
            this.attrName.append(c2);
        }

        final void appendAttributeValue(String str) {
            ensureAttrValue();
            if (this.attrValue.length() == 0) {
                this.attrValueS = str;
            } else {
                this.attrValue.append(str);
            }
        }

        final void appendAttributeValue(char c2) {
            ensureAttrValue();
            this.attrValue.append(c2);
        }

        final void appendAttributeValue(char[] cArr) {
            ensureAttrValue();
            this.attrValue.append(cArr);
        }

        final void appendAttributeValue(int[] iArr) {
            ensureAttrValue();
            for (int i : iArr) {
                this.attrValue.appendCodePoint(i);
            }
        }

        final void setEmptyAttributeValue() {
            this.hasEmptyAttrValue = true;
        }

        private void ensureAttrName() {
            this.hasAttrName = true;
            String str = this.attrNameS;
            if (str != null) {
                this.attrName.append(str);
                this.attrNameS = null;
            }
        }

        private void ensureAttrValue() {
            this.hasAttrValue = true;
            String str = this.attrValueS;
            if (str != null) {
                this.attrValue.append(str);
                this.attrValueS = null;
            }
        }
    }

    static final class StartTag extends Tag {
        StartTag() {
            this.type = TokenType.StartTag;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token.Tag, org.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.attributes = null;
            return this;
        }

        StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            this.normalName = ParseSettings.normalName(this.tagName);
            return this;
        }

        @Override // org.jsoup.parser.Token.Tag
        public String toString() {
            if (hasAttributes() && this.attributes.size() > 0) {
                return "<" + toStringName() + " " + this.attributes.toString() + ">";
            }
            return "<" + toStringName() + ">";
        }
    }

    static final class EndTag extends Tag {
        EndTag() {
            this.type = TokenType.EndTag;
        }

        @Override // org.jsoup.parser.Token.Tag
        public String toString() {
            return "</" + toStringName() + ">";
        }
    }

    static final class Comment extends Token {
        boolean bogus;
        private final StringBuilder data;
        private String dataS;

        @Override // org.jsoup.parser.Token
        Token reset() {
            super.reset();
            reset(this.data);
            this.dataS = null;
            this.bogus = false;
            return this;
        }

        Comment() {
            super();
            this.data = new StringBuilder();
            this.bogus = false;
            this.type = TokenType.Comment;
        }

        String getData() {
            String str = this.dataS;
            return str != null ? str : this.data.toString();
        }

        final Comment append(String str) {
            ensureData();
            if (this.data.length() == 0) {
                this.dataS = str;
                return this;
            }
            this.data.append(str);
            return this;
        }

        final Comment append(char c2) {
            ensureData();
            this.data.append(c2);
            return this;
        }

        private void ensureData() {
            String str = this.dataS;
            if (str != null) {
                this.data.append(str);
                this.dataS = null;
            }
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    static class Character extends Token {
        private String data;

        Character() {
            super();
            this.type = TokenType.Character;
        }

        @Override // org.jsoup.parser.Token
        Token reset() {
            super.reset();
            this.data = null;
            return this;
        }

        Character data(String str) {
            this.data = str;
            return this;
        }

        String getData() {
            return this.data;
        }

        public String toString() {
            return getData();
        }
    }

    static final class CData extends Character {
        CData(String str) {
            data(str);
        }

        @Override // org.jsoup.parser.Token.Character
        public String toString() {
            return "<![CDATA[" + getData() + "]]>";
        }
    }

    static final class EOF extends Token {
        EOF() {
            super();
            this.type = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        Token reset() {
            super.reset();
            return this;
        }

        public String toString() {
            return "";
        }
    }

    final boolean isDoctype() {
        return this.type == TokenType.Doctype;
    }

    final Doctype asDoctype() {
        return (Doctype) this;
    }

    final boolean isStartTag() {
        return this.type == TokenType.StartTag;
    }

    final StartTag asStartTag() {
        return (StartTag) this;
    }

    final boolean isEndTag() {
        return this.type == TokenType.EndTag;
    }

    final EndTag asEndTag() {
        return (EndTag) this;
    }

    final boolean isComment() {
        return this.type == TokenType.Comment;
    }

    final Comment asComment() {
        return (Comment) this;
    }

    final boolean isCharacter() {
        return this.type == TokenType.Character;
    }

    final boolean isCData() {
        return this instanceof CData;
    }

    final Character asCharacter() {
        return (Character) this;
    }

    final boolean isEOF() {
        return this.type == TokenType.EOF;
    }
}
