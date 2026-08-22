package io.socket.client;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import cz.msebera.android.httpclient.HttpHost;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class Url {
    private static Pattern PATTERN_AUTHORITY = Pattern.compile("^(.*@)?([^:]+)(:\\d+)?$");

    private Url() {
    }

    static class ParsedURI {
        public final String id;
        public final URI uri;

        public ParsedURI(URI uri, String str) {
            this.uri = uri;
            this.id = str;
        }
    }

    public static ParsedURI parse(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = TournamentShareDialogURIBuilder.scheme;
        }
        int port = uri.getPort();
        if (port == -1) {
            if (HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || "ws".equals(scheme)) {
                port = 80;
            } else if (TournamentShareDialogURIBuilder.scheme.equals(scheme) || "wss".equals(scheme)) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        String host = uri.getHost();
        if (host == null) {
            host = extractHostFromAuthorityPart(uri.getRawAuthority());
        }
        return new ParsedURI(URI.create(scheme + "://" + (rawUserInfo != null ? rawUserInfo + "@" : "") + host + (port != -1 ? ":" + port : "") + rawPath + (rawQuery != null ? "?" + rawQuery : "") + (rawFragment != null ? MqttTopic.MULTI_LEVEL_WILDCARD + rawFragment : "")), scheme + "://" + host + ":" + port);
    }

    private static String extractHostFromAuthorityPart(String str) {
        if (str == null) {
            throw new RuntimeException("unable to parse the host from the authority");
        }
        Matcher matcher = PATTERN_AUTHORITY.matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException("unable to parse the host from the authority");
        }
        return matcher.group(2);
    }
}
