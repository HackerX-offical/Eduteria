package com.github.kotvertolet.youtubejextractor.utils;

import com.amazonaws.regions.ServiceAbbreviations;
import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ExtractionUtils {
    private YoutubePlayerUtils youtubePlayerUtils;

    public ExtractionUtils(YoutubePlayerUtils youtubePlayerUtils) {
        this.youtubePlayerUtils = youtubePlayerUtils;
    }

    public boolean isVideoAgeRestricted(String str) {
        return Pattern.compile("[\"\\']status[\"\\']\\s*:\\s*[\"\\']LOGIN_REQUIRED").matcher(str).find() || str.contains("LOGIN_REQUIRED");
    }

    public String extractStsFromVideoPageHtml(String str) {
        Matcher matcher = Pattern.compile("sts\"\\s*:\\s*(\\d+)").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        CommonUtils.LogI("ExtractionUtils", "Sts param wasn't found in the embedded player webpage code");
        return "";
    }

    public String extractYoutubeVideoPlayerCode(String str) throws YoutubeRequestException, ExtractionException, SignatureDecryptionException {
        String strPreparePlayerUrl = preparePlayerUrl(str);
        Matcher matcher = Pattern.compile("([a-z]+)$").matcher(strPreparePlayerUrl);
        if (!matcher.find()) {
            throw new ExtractionException("Cannot identify player type by url: " + strPreparePlayerUrl);
        }
        String strGroup = matcher.group();
        strGroup.hashCode();
        if (strGroup.equals("js")) {
            return this.youtubePlayerUtils.downloadJsPlayer(strPreparePlayerUrl);
        }
        if (strGroup.equals(ServiceAbbreviations.SimpleWorkflow)) {
            throw new UnsupportedOperationException("Swf player type is not supported");
        }
        throw new UnsupportedOperationException("Invalid player type: " + strGroup);
    }

    public String extractDecryptFunctionName(String str) throws ExtractionException {
        String strMatchWithPatterns = CommonUtils.matchWithPatterns(Arrays.asList(Pattern.compile("\\b\\[cs\\]\\s*&&\\s*[adf]\\.set\\([^,]+\\s*,\\s*encodeURIComponent\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\("), Pattern.compile("\\b[a-zA-Z0-9]+\\s*&&\\s*[a-zA-Z0-9]+\\.set\\([^,]+\\s*,\\s*encodeURIComponent\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\("), Pattern.compile("(?:\\b|[^a-zA-Z0-9$])(?<sig>[a-zA-Z0-9$]{2})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)"), Pattern.compile("(?<sig>[a-zA-Z0-9$]+)\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)"), Pattern.compile("([\"\\'])signature\\1\\s*,\\s*(?<sig>[a-zA-Z0-9$]+)\\("), Pattern.compile("\\.sig\\|\\|(?<sig>[a-zA-Z0-9$]+)\\("), Pattern.compile("yt\\.akamaized\\.net/\\)\\s*\\|\\|\\s*.*?\\s*c\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?(?<sig>[a-zA-Z0-9$]+)\\("), Pattern.compile("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?\\s*(?<sig>[a-zA-Z0-9$]+)\\("), Pattern.compile("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*\\([^)]*\\)\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(")), str);
        if (strMatchWithPatterns != null) {
            return strMatchWithPatterns;
        }
        throw new ExtractionException("Cannot find required JS function in JS video player code");
    }

    private String preparePlayerUrl(String str) throws SignatureDecryptionException {
        if (str.isEmpty()) {
            throw new SignatureDecryptionException("Cannot decrypt signature without player_url!");
        }
        if (str.startsWith("//")) {
            str = "https:" + str;
        }
        if (!Pattern.compile("https?://").matcher(str).matches()) {
            return "https://www.youtube.com" + str;
        }
        throw new SignatureDecryptionException("Cannot create proper player url with url: " + str);
    }
}
