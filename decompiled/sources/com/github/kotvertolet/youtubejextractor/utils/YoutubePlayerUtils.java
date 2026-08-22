package com.github.kotvertolet.youtubejextractor.utils;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.network.YoutubeNetwork;
import com.google.code.regexp.Pattern;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class YoutubePlayerUtils {
    private YoutubeNetwork youtubeNetwork;

    public YoutubePlayerUtils(YoutubeNetwork youtubeNetwork) {
        this.youtubeNetwork = youtubeNetwork;
    }

    public String getJsPlayerUrl(String str) throws ExtractionException {
        String strMatchWithPatterns = CommonUtils.matchWithPatterns(Arrays.asList(Pattern.compile("<script[^>]+\\bsrc=(\"[^\"]+\")[^>]+\\bname=[\"']player_ias/base"), Pattern.compile("\"jsUrl\"\\s*:\\s*(\"[^\"]+\")"), Pattern.compile("\"assets\":.+?\"js\":\\s*(\"[^\"]+\")")), str);
        if (strMatchWithPatterns != null) {
            return strMatchWithPatterns.replaceAll("\\\\", "").replaceAll("^\"|\"$", "");
        }
        throw new ExtractionException("No js video player url found");
    }

    public String downloadJsPlayer(String str) throws YoutubeRequestException {
        try {
            return this.youtubeNetwork.downloadWebpage(str).body().string();
        } catch (IOException | NullPointerException e2) {
            throw new YoutubeRequestException("Error while downloading youtube js video player", e2);
        }
    }
}
