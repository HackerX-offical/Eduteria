package com.github.kotvertolet.youtubejextractor.utils;

import com.clevertap.android.sdk.Constants;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.google.code.regexp.Matcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: loaded from: classes7.dex */
public class DecryptionUtils {
    private Context jsContext;
    private String jsDecryptFunction;
    private String jsDecryptFunctionBody;
    private ArrayList<String> jsObjects;
    private String playerJsCode;
    private Scriptable scope;

    public DecryptionUtils(String str, String str2) throws SignatureDecryptionException {
        this.playerJsCode = str;
        Matcher matcherExtractJsFunction = extractJsFunction(str2);
        this.jsDecryptFunction = extractFunctionWithAssignment(matcherExtractJsFunction);
        this.jsDecryptFunctionBody = extractFunctionBody(matcherExtractJsFunction);
        ArrayList<String> arrayListExtractJsObjectsIfAny = extractJsObjectsIfAny(this.jsDecryptFunctionBody, extractFunctionArgs(matcherExtractJsFunction));
        this.jsObjects = arrayListExtractJsObjectsIfAny;
        this.jsContext = prepareJsContext(arrayListExtractJsObjectsIfAny);
    }

    public String decryptSignature(String str) throws SignatureDecryptionException {
        Object objEvaluateString = this.jsContext.evaluateString(this.scope, String.format("%s('%s')", this.jsDecryptFunction, str), "", 0, null);
        if (objEvaluateString instanceof String) {
            return objEvaluateString.toString();
        }
        throw new SignatureDecryptionException("Decryption function returned no result, function was: \n" + this.jsDecryptFunction + "\n parameter was: " + str + "\njs objects were: " + this.jsObjects.toString());
    }

    private Context prepareJsContext(List<String> list) {
        Context contextEnter = Context.enter();
        contextEnter.setOptimizationLevel(-1);
        this.scope = contextEnter.initStandardObjects();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            contextEnter.evaluateString(this.scope, it.next(), "", 0, null);
        }
        return contextEnter;
    }

    private Matcher extractJsFunction(String str) throws SignatureDecryptionException {
        String strEscapeRegExSpecialCharacters = StringUtils.escapeRegExSpecialCharacters(str);
        Matcher matcher = CommonUtils.getMatcher(String.format("(?x)(?:function\\s+%s|[{;,]\\s*%s\\s*=\\s*function|var\\s+%s\\s*=\\s*function)\\s*\\((?<args>[^)]*)\\)\\s*\\{(?<code>[^}]+)\\}", strEscapeRegExSpecialCharacters, strEscapeRegExSpecialCharacters, strEscapeRegExSpecialCharacters), this.playerJsCode);
        if (matcher.find()) {
            return matcher;
        }
        throw new SignatureDecryptionException("Could not find JS function with name " + str);
    }

    private String extractFunctionWithAssignment(Matcher matcher) {
        String strGroup = matcher.group();
        return strGroup.startsWith(";\n") ? strGroup.replace(";\n", "") : strGroup;
    }

    private List<String> extractFunctionArgs(Matcher matcher) {
        return Arrays.asList(matcher.group("args").split(Constants.SEPARATOR_COMMA));
    }

    private String extractFunctionBody(Matcher matcher) {
        return matcher.group("code");
    }

    private ArrayList<String> extractJsObjectsIfAny(String str, List<String> list) throws SignatureDecryptionException {
        String[] strArrSplit = str.split(";");
        HashMap map = new HashMap();
        String str2 = String.format("(?<var>%s)(?:\\.(?<member>[^(]+)|\\[(?<member2>[^]]+)\\])\\s*", "[a-zA-Z_$][a-zA-Z_$0-9]*");
        for (String str3 : strArrSplit) {
            Matcher matcher = CommonUtils.getMatcher(str2, str3);
            if (matcher.find()) {
                String strGroup = matcher.group("var");
                String strGroup2 = matcher.group("member");
                if (strGroup2 == null) {
                    strGroup2 = matcher.group("member2");
                }
                if (!list.contains(strGroup) && !map.containsKey(strGroup2)) {
                    map.putAll(extractJsObject(strGroup));
                }
            }
        }
        return this.jsObjects;
    }

    private HashMap<String, String> extractJsObject(String str) throws SignatureDecryptionException {
        HashMap<String, String> map = new HashMap<>();
        this.jsObjects = new ArrayList<>();
        Matcher matcher = CommonUtils.getMatcher(String.format("(?x)(?<!this\\.)%s\\s*=\\s*\\{\\s*(?<fields>(%s\\s*:\\s*function\\s*(.*?)\\s*\\{.*?\\}(?:,\\s*)?)*)\\}\\s*;", StringUtils.escapeRegExSpecialCharacters(str), "(?:[a-zA-Z$0-9]+|\"[a-zA-Z$0-9]+\"|'[a-zA-Z$0-9]+')"), this.playerJsCode);
        if (matcher.find()) {
            this.jsObjects.add(matcher.group());
            Matcher matcher2 = CommonUtils.getMatcher(String.format("(?x)(?<key>%s)\\s*:\\s*function\\s*\\((?<args>[a-z,]+)\\)\\{(?<code>[^}]+)\\}", "(?:[a-zA-Z$0-9]+|\"[a-zA-Z$0-9]+\"|'[a-zA-Z$0-9]+')"), matcher.group("fields"));
            while (matcher2.find()) {
                map.put(matcher2.group("key"), matcher2.group("code"));
            }
            return map;
        }
        throw new SignatureDecryptionException(String.format("Js object with name '%s' wasn't found", str));
    }
}
