package org.jsoup.parser;

import androidx.work.WorkInfo;
import com.csvreader.CsvReader;
import java.util.Arrays;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* JADX INFO: loaded from: classes10.dex */
final class Tokeniser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int Unset = -1;
    private static final char[] notCharRefCharsSorted;
    static final char replacementChar = 65533;
    static final int[] win1252Extensions;
    static final int win1252ExtensionsStart = 128;
    private final ParseErrorList errors;

    @Nullable
    private String lastStartCloseSeq;

    @Nullable
    private String lastStartTag;
    private int markupStartPos;
    private final CharacterReader reader;
    private TokeniserState state = TokeniserState.Data;

    @Nullable
    private Token emitPending = null;
    private boolean isEmitPending = false;

    @Nullable
    private String charsString = null;
    private final StringBuilder charsBuilder = new StringBuilder(1024);
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.StartTag startPending = new Token.StartTag();
    Token.EndTag endPending = new Token.EndTag();
    Token.Tag tagPending = this.startPending;
    Token.Character charPending = new Token.Character();
    Token.Doctype doctypePending = new Token.Doctype();
    Token.Comment commentPending = new Token.Comment();
    private int charStartPos = -1;
    private final int[] codepointHolder = new int[1];
    private final int[] multipointHolder = new int[2];

    boolean currentNodeInHtmlNS() {
        return true;
    }

    static {
        char[] cArr = {'\t', '\n', '\r', CsvReader.Letters.FORM_FEED, ' ', Typography.less, Typography.amp};
        notCharRefCharsSorted = cArr;
        win1252Extensions = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArr);
    }

    Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    Token read() {
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        StringBuilder sb = this.charsBuilder;
        if (sb.length() != 0) {
            String string = sb.toString();
            sb.delete(0, sb.length());
            Token.Character characterData = this.charPending.data(string);
            this.charsString = null;
            return characterData;
        }
        String str = this.charsString;
        if (str != null) {
            Token.Character characterData2 = this.charPending.data(str);
            this.charsString = null;
            return characterData2;
        }
        this.isEmitPending = false;
        return this.emitPending;
    }

    void emit(Token token) {
        Validate.isFalse(this.isEmitPending);
        this.emitPending = token;
        this.isEmitPending = true;
        token.startPos(this.markupStartPos);
        token.endPos(this.reader.pos());
        this.charStartPos = -1;
        if (token.type == Token.TokenType.StartTag) {
            this.lastStartTag = ((Token.StartTag) token).tagName;
            this.lastStartCloseSeq = null;
        } else if (token.type == Token.TokenType.EndTag) {
            Token.EndTag endTag = (Token.EndTag) token;
            if (endTag.hasAttributes()) {
                error("Attributes incorrectly present on end tag [/%s]", endTag.normalName());
            }
        }
    }

    void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
        } else {
            if (this.charsBuilder.length() == 0) {
                this.charsBuilder.append(this.charsString);
            }
            this.charsBuilder.append(str);
        }
        this.charPending.startPos(this.charStartPos);
        this.charPending.endPos(this.reader.pos());
    }

    void emit(StringBuilder sb) {
        if (this.charsString == null) {
            this.charsString = sb.toString();
        } else {
            if (this.charsBuilder.length() == 0) {
                this.charsBuilder.append(this.charsString);
            }
            this.charsBuilder.append((CharSequence) sb);
        }
        this.charPending.startPos(this.charStartPos);
        this.charPending.endPos(this.reader.pos());
    }

    void emit(char c2) {
        if (this.charsString == null) {
            this.charsString = String.valueOf(c2);
        } else {
            if (this.charsBuilder.length() == 0) {
                this.charsBuilder.append(this.charsString);
            }
            this.charsBuilder.append(c2);
        }
        this.charPending.startPos(this.charStartPos);
        this.charPending.endPos(this.reader.pos());
    }

    void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    void emit(int[] iArr) {
        emit(new String(iArr, 0, iArr.length));
    }

    TokeniserState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: org.jsoup.parser.Tokeniser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$TokeniserState;

        static {
            int[] iArr = new int[TokeniserState.values().length];
            $SwitchMap$org$jsoup$parser$TokeniserState = iArr;
            try {
                iArr[TokeniserState.TagOpen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$TokeniserState[TokeniserState.Data.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    void transition(TokeniserState tokeniserState) {
        int i = AnonymousClass1.$SwitchMap$org$jsoup$parser$TokeniserState[tokeniserState.ordinal()];
        if (i == 1) {
            this.markupStartPos = this.reader.pos();
        } else if (i == 2 && this.charStartPos == -1) {
            this.charStartPos = this.reader.pos();
        }
        this.state = tokeniserState;
    }

    void advanceTransition(TokeniserState tokeniserState) {
        transition(tokeniserState);
        this.reader.advance();
    }

    @Nullable
    int[] consumeCharacterReference(@Nullable Character ch, boolean z) {
        int iIntValue;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        int[] iArr = this.codepointHolder;
        this.reader.mark();
        if (this.reader.matchConsume(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            boolean zMatchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
            CharacterReader characterReader = this.reader;
            String strConsumeHexSequence = zMatchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
            if (strConsumeHexSequence.length() == 0) {
                characterReferenceError("numeric reference with no numerals", new Object[0]);
                this.reader.rewindToMark();
                return null;
            }
            this.reader.unmark();
            if (!this.reader.matchConsume(";")) {
                characterReferenceError("missing semicolon on [&#%s]", strConsumeHexSequence);
            }
            try {
                iIntValue = Integer.valueOf(strConsumeHexSequence, zMatchConsumeIgnoreCase ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue == -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
                characterReferenceError("character [%s] outside of valid range", Integer.valueOf(iIntValue));
                iArr[0] = 65533;
            } else {
                if (iIntValue >= 128) {
                    int[] iArr2 = win1252Extensions;
                    if (iIntValue < iArr2.length + 128) {
                        characterReferenceError("character [%s] is not a valid unicode code point", Integer.valueOf(iIntValue));
                        iIntValue = iArr2[iIntValue + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT];
                    }
                }
                iArr[0] = iIntValue;
            }
            return iArr;
        }
        String strConsumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
        boolean zMatches = this.reader.matches(';');
        if (!Entities.isBaseNamedEntity(strConsumeLetterThenDigitSequence) && (!Entities.isNamedEntity(strConsumeLetterThenDigitSequence) || !zMatches)) {
            this.reader.rewindToMark();
            if (zMatches) {
                characterReferenceError("invalid named reference [%s]", strConsumeLetterThenDigitSequence);
            }
            return null;
        }
        if (z && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny('=', '-', '_'))) {
            this.reader.rewindToMark();
            return null;
        }
        this.reader.unmark();
        if (!this.reader.matchConsume(";")) {
            characterReferenceError("missing semicolon on [&%s]", strConsumeLetterThenDigitSequence);
        }
        int iCodepointsForName = Entities.codepointsForName(strConsumeLetterThenDigitSequence, this.multipointHolder);
        if (iCodepointsForName == 1) {
            iArr[0] = this.multipointHolder[0];
            return iArr;
        }
        if (iCodepointsForName == 2) {
            return this.multipointHolder;
        }
        Validate.fail("Unexpected characters returned for " + strConsumeLetterThenDigitSequence);
        return this.multipointHolder;
    }

    Token.Tag createTagPending(boolean z) {
        Token.Tag tagReset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = tagReset;
        return tagReset;
    }

    void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    void createCommentPending() {
        this.commentPending.reset();
    }

    void emitCommentPending() {
        emit(this.commentPending);
    }

    void createBogusCommentPending() {
        this.commentPending.reset();
        this.commentPending.bogus = true;
    }

    void createDoctypePending() {
        this.doctypePending.reset();
    }

    void emitDoctypePending() {
        emit(this.doctypePending);
    }

    void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag);
    }

    @Nullable
    String appropriateEndTagName() {
        return this.lastStartTag;
    }

    String appropriateEndTagSeq() {
        if (this.lastStartCloseSeq == null) {
            this.lastStartCloseSeq = "</" + this.lastStartTag;
        }
        return this.lastStartCloseSeq;
    }

    void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            ParseErrorList parseErrorList = this.errors;
            CharacterReader characterReader = this.reader;
            parseErrorList.add(new ParseError(characterReader, "Unexpected character '%s' in input state [%s]", Character.valueOf(characterReader.current()), tokeniserState));
        }
    }

    void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    private void characterReferenceError(String str, Object... objArr) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, String.format("Invalid character reference: " + str, objArr)));
        }
    }

    void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, str));
        }
    }

    void error(String str, Object... objArr) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader, str, objArr));
        }
    }

    String unescapeEntities(boolean z) {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        while (!this.reader.isEmpty()) {
            sbBorrowBuilder.append(this.reader.consumeTo(Typography.amp));
            if (this.reader.matches(Typography.amp)) {
                this.reader.consume();
                int[] iArrConsumeCharacterReference = consumeCharacterReference(null, z);
                if (iArrConsumeCharacterReference == null || iArrConsumeCharacterReference.length == 0) {
                    sbBorrowBuilder.append(Typography.amp);
                } else {
                    sbBorrowBuilder.appendCodePoint(iArrConsumeCharacterReference[0]);
                    if (iArrConsumeCharacterReference.length == 2) {
                        sbBorrowBuilder.appendCodePoint(iArrConsumeCharacterReference[1]);
                    }
                }
            }
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }
}
