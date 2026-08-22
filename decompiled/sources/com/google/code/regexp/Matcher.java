package com.google.code.regexp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class Matcher implements MatchResult {
    private java.util.regex.Matcher matcher;
    private Pattern parentPattern;

    Matcher(Pattern pattern, CharSequence charSequence) {
        this.parentPattern = pattern;
        this.matcher = pattern.pattern().matcher(charSequence);
    }

    Matcher(Pattern pattern, java.util.regex.MatchResult matchResult) {
        this.parentPattern = pattern;
        this.matcher = (java.util.regex.Matcher) matchResult;
    }

    private int groupIndex(String str) {
        int iIndexOf = this.parentPattern.indexOf(str);
        if (iIndexOf > -1) {
            return iIndexOf + 1;
        }
        return -1;
    }

    public Matcher appendReplacement(StringBuffer stringBuffer, String str) {
        this.matcher.appendReplacement(stringBuffer, this.parentPattern.replaceProperties(str));
        return this;
    }

    public StringBuffer appendTail(StringBuffer stringBuffer) {
        return this.matcher.appendTail(stringBuffer);
    }

    @Override // java.util.regex.MatchResult
    public int end() {
        return this.matcher.end();
    }

    @Override // java.util.regex.MatchResult
    public int end(int i) {
        return this.matcher.end(i);
    }

    @Override // com.google.code.regexp.MatchResult
    public int end(String str) {
        return end(groupIndex(str));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Matcher)) {
            return false;
        }
        Matcher matcher = (Matcher) obj;
        if (this.parentPattern.equals(matcher.parentPattern)) {
            return this.matcher.equals(matcher.matcher);
        }
        return false;
    }

    public boolean find() {
        return this.matcher.find();
    }

    public boolean find(int i) {
        return this.matcher.find(i);
    }

    @Override // java.util.regex.MatchResult
    public String group() {
        return this.matcher.group();
    }

    @Override // java.util.regex.MatchResult
    public String group(int i) {
        return this.matcher.group(i);
    }

    @Override // com.google.code.regexp.MatchResult
    public String group(String str) {
        int iGroupIndex = groupIndex(str);
        if (iGroupIndex >= 0) {
            return group(iGroupIndex);
        }
        throw new IndexOutOfBoundsException("No group \"" + str + "\"");
    }

    @Override // java.util.regex.MatchResult
    public int groupCount() {
        return this.matcher.groupCount();
    }

    public boolean hasAnchoringBounds() {
        return this.matcher.hasAnchoringBounds();
    }

    public boolean hasTransparentBounds() {
        return this.matcher.hasTransparentBounds();
    }

    public int hashCode() {
        return this.parentPattern.hashCode() ^ this.matcher.hashCode();
    }

    public boolean hitEnd() {
        return this.matcher.hitEnd();
    }

    public boolean lookingAt() {
        return this.matcher.lookingAt();
    }

    public boolean matches() {
        return this.matcher.matches();
    }

    @Override // com.google.code.regexp.MatchResult
    public List<Map<String, String>> namedGroups() {
        ArrayList arrayList = new ArrayList();
        int iEnd = 0;
        while (this.matcher.find(iEnd)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.parentPattern.groupNames()) {
                linkedHashMap.put(str, this.matcher.group(groupIndex(str)));
                iEnd = this.matcher.end();
            }
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    public Pattern namedPattern() {
        return this.parentPattern;
    }

    @Override // com.google.code.regexp.MatchResult
    public List<String> orderedGroups() {
        int iGroupCount = groupCount();
        ArrayList arrayList = new ArrayList(iGroupCount);
        for (int i = 1; i <= iGroupCount; i++) {
            arrayList.add(group(i));
        }
        return arrayList;
    }

    public Matcher region(int i, int i2) {
        this.matcher.region(i, i2);
        return this;
    }

    public int regionEnd() {
        return this.matcher.regionEnd();
    }

    public int regionStart() {
        return this.matcher.regionStart();
    }

    public String replaceAll(String str) {
        return this.matcher.replaceAll(this.parentPattern.replaceProperties(str));
    }

    public String replaceFirst(String str) {
        return this.matcher.replaceFirst(this.parentPattern.replaceProperties(str));
    }

    public boolean requireEnd() {
        return this.matcher.requireEnd();
    }

    public Matcher reset() {
        this.matcher.reset();
        return this;
    }

    public Matcher reset(CharSequence charSequence) {
        this.matcher.reset(charSequence);
        return this;
    }

    public java.util.regex.Pattern standardPattern() {
        return this.matcher.pattern();
    }

    @Override // java.util.regex.MatchResult
    public int start() {
        return this.matcher.start();
    }

    @Override // java.util.regex.MatchResult
    public int start(int i) {
        return this.matcher.start(i);
    }

    @Override // com.google.code.regexp.MatchResult
    public int start(String str) {
        return start(groupIndex(str));
    }

    public MatchResult toMatchResult() {
        return new Matcher(this.parentPattern, this.matcher.toMatchResult());
    }

    public String toString() {
        return this.matcher.toString();
    }

    public Matcher useAnchoringBounds(boolean z) {
        this.matcher.useAnchoringBounds(z);
        return this;
    }

    public Matcher usePattern(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("newPattern cannot be null");
        }
        this.parentPattern = pattern;
        this.matcher.usePattern(pattern.pattern());
        return this;
    }

    public Matcher useTransparentBounds(boolean z) {
        this.matcher.useTransparentBounds(z);
        return this;
    }
}
