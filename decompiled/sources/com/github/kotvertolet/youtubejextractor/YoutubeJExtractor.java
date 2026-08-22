package com.github.kotvertolet.youtubejextractor;

import android.util.Log;
import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.VideoIsUnavailable;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveVideoStream;
import com.github.kotvertolet.youtubejextractor.models.newModels.AdaptiveFormatsItem;
import com.github.kotvertolet.youtubejextractor.models.newModels.PlayabilityStatus;
import com.github.kotvertolet.youtubejextractor.models.newModels.VideoPlayerConfig;
import com.github.kotvertolet.youtubejextractor.models.subtitles.Subtitle;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.StreamingData;
import com.github.kotvertolet.youtubejextractor.network.GoogleVideoNetwork;
import com.github.kotvertolet.youtubejextractor.network.YoutubeNetwork;
import com.github.kotvertolet.youtubejextractor.utils.CommonUtils;
import com.github.kotvertolet.youtubejextractor.utils.DecryptionUtils;
import com.github.kotvertolet.youtubejextractor.utils.ExtractionUtils;
import com.github.kotvertolet.youtubejextractor.utils.StringUtils;
import com.github.kotvertolet.youtubejextractor.utils.YoutubePlayerUtils;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import retrofit2.Response;

/* JADX INFO: loaded from: classes7.dex */
public class YoutubeJExtractor {
    private final String TAG = getClass().getSimpleName();
    private final ExtractionUtils extractionUtils;
    private final Gson gson;
    private String videoPageHtml;
    private final YoutubeNetwork youtubeNetwork;
    private final YoutubePlayerUtils youtubePlayerUtils;

    public YoutubeJExtractor() {
        Gson gsonInitGson = new IGsonFactoryImpl().initGson();
        this.gson = gsonInitGson;
        YoutubeNetwork youtubeNetwork = new YoutubeNetwork(gsonInitGson);
        this.youtubeNetwork = youtubeNetwork;
        YoutubePlayerUtils youtubePlayerUtils = new YoutubePlayerUtils(youtubeNetwork);
        this.youtubePlayerUtils = youtubePlayerUtils;
        this.extractionUtils = new ExtractionUtils(youtubePlayerUtils);
    }

    public YoutubeJExtractor(OkHttpClient okHttpClient) {
        Gson gsonInitGson = new IGsonFactoryImpl().initGson();
        this.gson = gsonInitGson;
        YoutubeNetwork youtubeNetwork = new YoutubeNetwork(gsonInitGson, okHttpClient);
        this.youtubeNetwork = youtubeNetwork;
        YoutubePlayerUtils youtubePlayerUtils = new YoutubePlayerUtils(youtubeNetwork);
        this.youtubePlayerUtils = youtubePlayerUtils;
        this.extractionUtils = new ExtractionUtils(youtubePlayerUtils);
    }

    public VideoPlayerConfig extract(String str) throws YoutubeRequestException, ExtractionException, VideoIsUnavailable {
        try {
            CommonUtils.LogI(this.TAG, "Extracting video data from youtube page");
            VideoPlayerConfig videoPlayerConfigExtractVideoData = extractVideoData(str);
            if (isVideoUnavailable(videoPlayerConfigExtractVideoData)) {
                throw new VideoIsUnavailable("This video is unavailable, reason: " + videoPlayerConfigExtractVideoData.getPlayabilityStatus().getErrorScreen().getPlayerErrorMessageRenderer().getReason().getSimpleText());
            }
            if (streamsAreCiphered(videoPlayerConfigExtractVideoData)) {
                CommonUtils.LogI(this.TAG, "Streams are ciphered, decrypting");
                decryptYoutubeStreams(videoPlayerConfigExtractVideoData);
            } else {
                CommonUtils.LogI(this.TAG, "Streams are not encrypted");
            }
            sortAdaptiveStreamsByType(videoPlayerConfigExtractVideoData.getStreamingData());
            return videoPlayerConfigExtractVideoData;
        } catch (SignatureDecryptionException e2) {
            throw new ExtractionException(e2);
        }
    }

    private boolean isVideoUnavailable(VideoPlayerConfig videoPlayerConfig) {
        PlayabilityStatus playabilityStatus = videoPlayerConfig.getPlayabilityStatus();
        if (playabilityStatus.getReason() != null) {
            return playabilityStatus.getStatus().equals("ERROR") || playabilityStatus.getReason().equals("Video unavailable");
        }
        return false;
    }

    public void sortAdaptiveStreamsByType(StreamingData streamingData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdaptiveFormatsItem adaptiveFormatsItem : streamingData.getAdaptiveFormats()) {
            String mimeType = adaptiveFormatsItem.getMimeType();
            if (adaptiveFormatsItem.getApproxDurationMs() != null) {
                if (mimeType.contains("audio")) {
                    arrayList2.add(new AdaptiveAudioStream(adaptiveFormatsItem));
                } else if (mimeType.contains("video")) {
                    arrayList.add(new AdaptiveVideoStream(adaptiveFormatsItem));
                } else {
                    CommonUtils.LogE(getClass().getSimpleName(), "Unknown stream type found: " + mimeType);
                }
            }
        }
        streamingData.setAdaptiveAudioStreams(arrayList2);
        streamingData.setAdaptiveVideoStreams(arrayList);
    }

    public void extract(String str, JExtractorCallback jExtractorCallback) {
        try {
            jExtractorCallback.onSuccess(extractVideoData(str));
        } catch (ExtractionException e2) {
            e = e2;
            jExtractorCallback.onError(e);
        } catch (SignatureDecryptionException e3) {
            e = e3;
            jExtractorCallback.onError(e);
        } catch (YoutubeRequestException e4) {
            jExtractorCallback.onNetworkException(e4);
        }
    }

    public Map<String, ArrayList<Subtitle>> extractSubtitles(String str) {
        GoogleVideoNetwork googleVideoNetwork = new GoogleVideoNetwork(this.gson);
        try {
            Response<ResponseBody> subtitlesList = googleVideoNetwork.getSubtitlesList(str);
            DocumentBuilder documentBuilderNewDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            NodeList childNodes = documentBuilderNewDocumentBuilder.parse(subtitlesList.body().byteStream()).getDocumentElement().getChildNodes();
            if (childNodes.getLength() > 0) {
                ArrayList<String> arrayList = new ArrayList();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    arrayList.add(childNodes.item(i).getAttributes().getNamedItem("lang_code").getNodeValue());
                }
                HashMap map = new HashMap();
                for (String str2 : arrayList) {
                    NodeList childNodes2 = documentBuilderNewDocumentBuilder.parse(googleVideoNetwork.getSubtitles(str, str2).body().byteStream()).getDocumentElement().getChildNodes();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node nodeItem = childNodes2.item(i2);
                        arrayList2.add(new Subtitle(nodeItem.getAttributes().getNamedItem("start").getNodeValue(), nodeItem.getAttributes().getNamedItem("dur").getNodeValue(), nodeItem.getTextContent()));
                    }
                    map.put(str2, arrayList2);
                }
                return map;
            }
            CommonUtils.LogI(this.TAG, "Subtitles not found");
            return Collections.emptyMap();
        } catch (IOException | ParserConfigurationException | SAXException e2) {
            e2.printStackTrace();
            return Collections.emptyMap();
        }
    }

    private VideoPlayerConfig extractVideoData(String str) throws YoutubeRequestException, ExtractionException, SignatureDecryptionException {
        CommonUtils.LogI(this.TAG, "Extracting video data from youtube page");
        return extractYoutubeVideoData(str);
    }

    private VideoPlayerConfig extractYoutubeVideoData(String str) throws YoutubeRequestException, ExtractionException {
        try {
            String strString = this.youtubeNetwork.getYoutubeVideoPage(str).body().string();
            this.videoPageHtml = strString;
            if (this.extractionUtils.isVideoAgeRestricted(strString)) {
                CommonUtils.LogI(this.TAG, "Age restricted video detected, getting video data from google apis");
                String str2 = StringUtils.splitUrlParams(new URL("http://youtube.con/v?" + getVideoInfoForAgeRestrictedVideo(str))).get("player_response");
                if (str2 == null || str2.isEmpty()) {
                    throw new ExtractionException("Player response extracted from video info was null or empty");
                }
                return (VideoPlayerConfig) this.gson.fromJson(str2, VideoPlayerConfig.class);
            }
            CommonUtils.LogI(this.TAG, "Video is not age restricted, extracting youtube video player config");
            return extractYoutubePlayerConfig(str);
        } catch (IOException e2) {
            throw new ExtractionException(e2);
        }
    }

    private VideoPlayerConfig extractYoutubePlayerConfig(String str) throws ExtractionException {
        String strMatchWithPatterns = CommonUtils.matchWithPatterns(Arrays.asList(Pattern.compile("ytInitialPlayerResponse\\s*=\\s*(\\{.+?\\})\\s*;"), Pattern.compile(";ytplayer\\.config\\s*=\\s*(\\{.+?\\});ytplayer"), Pattern.compile(";ytplayer\\.config\\s*=\\s*(\\{.+?\\});")), this.videoPageHtml);
        if (strMatchWithPatterns != null) {
            return (VideoPlayerConfig) this.gson.fromJson(strMatchWithPatterns, VideoPlayerConfig.class);
        }
        Matcher matcher = Pattern.compile("<h1\\sid=\"unavailable-message\"\\sclass=\"message\">\\n\\s+(.+?)\\n\\s+<\\/h1>").matcher(this.videoPageHtml);
        if (matcher.find()) {
            throw new ExtractionException(String.format("Cannot extract youtube player config, videoId was: %s, reason: %s", str, matcher.group(1)));
        }
        throw new ExtractionException("Cannot extract youtube player config, videoId was: " + str);
    }

    private String getVideoInfoForAgeRestrictedVideo(String str) throws ExtractionException {
        try {
            String strString = this.youtubeNetwork.getYoutubeEmbeddedVideoPage(str).body().string();
            this.videoPageHtml = strString;
            Response<ResponseBody> youtubeVideoInfo = this.youtubeNetwork.getYoutubeVideoInfo(str, String.format("https://youtube.googleapis.com/v/%s&sts=%s", str, this.extractionUtils.extractStsFromVideoPageHtml(strString)));
            if (youtubeVideoInfo.body() != null) {
                String strString2 = youtubeVideoInfo.body().string();
                if (strString2.isEmpty()) {
                    throw new ExtractionException("Video info was empty");
                }
                return strString2;
            }
            throw new ExtractionException("Video info response body was null or empty");
        } catch (YoutubeRequestException | IOException | NullPointerException e2) {
            throw new ExtractionException(e2);
        }
    }

    private boolean streamsAreCiphered(VideoPlayerConfig videoPlayerConfig) throws ExtractionException {
        StreamingData streamingData = videoPlayerConfig.getStreamingData();
        if (streamingData != null) {
            List<AdaptiveFormatsItem> adaptiveFormats = streamingData.getAdaptiveFormats();
            if (videoPlayerConfig.getVideoDetails().getIsLiveContent()) {
                Log.i(this.TAG, "Requested content is live stream");
                if (adaptiveFormats == null || adaptiveFormats.size() == 0) {
                    Log.i(this.TAG, "Requested content is a live stream and doesn't contain adaptive streams, use DASH or HLS manifests. If the content is not a live stream or it was but has ended, just wait some time, youtube usually needs a couple of hours to prepare adaptive streams");
                    return false;
                }
            }
            if (adaptiveFormats == null || adaptiveFormats.size() <= 0) {
                throw new ExtractionException("AdaptiveFormatItem list was null or empty");
            }
            return adaptiveFormats.get(0).getCipher() != null;
        }
        throw new ExtractionException("RawStreamingData object was null");
    }

    private void decryptYoutubeStreams(VideoPlayerConfig videoPlayerConfig) throws YoutubeRequestException, ExtractionException, SignatureDecryptionException {
        List<AdaptiveFormatsItem> adaptiveFormats = videoPlayerConfig.getStreamingData().getAdaptiveFormats();
        List<MuxedStream> muxedStreams = videoPlayerConfig.getStreamingData().getMuxedStreams();
        String strExtractYoutubeVideoPlayerCode = this.extractionUtils.extractYoutubeVideoPlayerCode(this.youtubePlayerUtils.getJsPlayerUrl(this.videoPageHtml));
        DecryptionUtils decryptionUtils = new DecryptionUtils(strExtractYoutubeVideoPlayerCode, this.extractionUtils.extractDecryptFunctionName(strExtractYoutubeVideoPlayerCode));
        for (int i = 0; i < adaptiveFormats.size(); i++) {
            AdaptiveFormatsItem adaptiveFormatsItem = adaptiveFormats.get(i);
            adaptiveFormatsItem.getCipher().setS(decryptionUtils.decryptSignature(adaptiveFormatsItem.getCipher().getS()));
        }
        for (int i2 = 0; i2 < muxedStreams.size(); i2++) {
            MuxedStream muxedStream = muxedStreams.get(i2);
            muxedStream.getCipher().setS(decryptionUtils.decryptSignature(muxedStream.getCipher().getS()));
        }
    }
}
