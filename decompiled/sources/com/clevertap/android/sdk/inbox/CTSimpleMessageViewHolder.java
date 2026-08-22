package com.clevertap.android.sdk.inbox;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
class CTSimpleMessageViewHolder extends CTInboxBaseMessageViewHolder {
    private final Button cta1;
    private final Button cta2;
    private final Button cta3;
    private final TextView message;
    private final TextView timestamp;
    private final TextView title;

    CTSimpleMessageViewHolder(View view) {
        super(view);
        view.setTag(this);
        this.title = (TextView) view.findViewById(R.id.messageTitle);
        this.message = (TextView) view.findViewById(R.id.messageText);
        this.timestamp = (TextView) view.findViewById(R.id.timestamp);
        this.cta1 = (Button) view.findViewById(R.id.cta_button_1);
        this.cta2 = (Button) view.findViewById(R.id.cta_button_2);
        this.cta3 = (Button) view.findViewById(R.id.cta_button_3);
        this.mediaImage = (ImageView) view.findViewById(R.id.media_image);
        this.relativeLayout = (RelativeLayout) view.findViewById(R.id.simple_message_relative_layout);
        this.frameLayout = (FrameLayout) view.findViewById(R.id.simple_message_frame_layout);
        this.squareImage = (ImageView) view.findViewById(R.id.square_media_image);
        this.clickLayout = (RelativeLayout) view.findViewById(R.id.click_relative_layout);
        this.ctaLinearLayout = (LinearLayout) view.findViewById(R.id.cta_linear_layout);
        this.bodyRelativeLayout = (LinearLayout) view.findViewById(R.id.body_linear_layout);
        this.progressBarFrameLayout = (FrameLayout) view.findViewById(R.id.simple_progress_frame_layout);
        this.mediaLayout = (RelativeLayout) view.findViewById(R.id.media_layout);
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder
    void configureWithMessage(CTInboxMessage cTInboxMessage, CTInboxListViewFragment cTInboxListViewFragment, int i) {
        int i2;
        int iRound;
        super.configureWithMessage(cTInboxMessage, cTInboxListViewFragment, i);
        CTInboxListViewFragment parent = getParent();
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.getInboxMessageContents().get(0);
        this.title.setText(cTInboxMessageContent.getTitle());
        this.title.setTextColor(Color.parseColor(cTInboxMessageContent.getTitleColor()));
        this.message.setText(cTInboxMessageContent.getMessage());
        this.message.setTextColor(Color.parseColor(cTInboxMessageContent.getMessageColor()));
        this.bodyRelativeLayout.setBackgroundColor(Color.parseColor(cTInboxMessage.getBgColor()));
        this.timestamp.setText(calculateDisplayTimestamp(cTInboxMessage.getDate()));
        this.timestamp.setTextColor(Color.parseColor(cTInboxMessageContent.getTitleColor()));
        if (cTInboxMessage.isRead()) {
            this.readDot.setVisibility(8);
        } else {
            this.readDot.setVisibility(0);
        }
        this.frameLayout.setVisibility(8);
        JSONArray links = cTInboxMessageContent.getLinks();
        if (links != null) {
            this.ctaLinearLayout.setVisibility(0);
            int length = links.length();
            try {
                if (length == 1) {
                    JSONObject jSONObject = links.getJSONObject(0);
                    this.cta1.setVisibility(0);
                    this.cta1.setText(cTInboxMessageContent.getLinkText(jSONObject));
                    this.cta1.setTextColor(Color.parseColor(cTInboxMessageContent.getLinkColor(jSONObject)));
                    this.cta1.setBackgroundColor(Color.parseColor(cTInboxMessageContent.getLinkBGColor(jSONObject)));
                    hideTwoButtons(this.cta1, this.cta2, this.cta3);
                    if (parent != null) {
                        this.cta1.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, this.cta1.getText().toString(), jSONObject, parent, false, 0));
                    }
                } else if (length == 2) {
                    JSONObject jSONObject2 = links.getJSONObject(0);
                    this.cta1.setVisibility(0);
                    this.cta1.setText(cTInboxMessageContent.getLinkText(jSONObject2));
                    this.cta1.setTextColor(Color.parseColor(cTInboxMessageContent.getLinkColor(jSONObject2)));
                    this.cta1.setBackgroundColor(Color.parseColor(cTInboxMessageContent.getLinkBGColor(jSONObject2)));
                    JSONObject jSONObject3 = links.getJSONObject(1);
                    this.cta2.setVisibility(0);
                    this.cta2.setText(cTInboxMessageContent.getLinkText(jSONObject3));
                    this.cta2.setTextColor(Color.parseColor(cTInboxMessageContent.getLinkColor(jSONObject3)));
                    this.cta2.setBackgroundColor(Color.parseColor(cTInboxMessageContent.getLinkBGColor(jSONObject3)));
                    hideOneButton(this.cta1, this.cta2, this.cta3);
                    if (parent != null) {
                        this.cta1.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, this.cta1.getText().toString(), jSONObject2, parent, false, 0));
                        this.cta2.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, this.cta2.getText().toString(), jSONObject3, parent, false, 1));
                    }
                } else if (length == 3) {
                    JSONObject jSONObject4 = links.getJSONObject(0);
                    this.cta1.setVisibility(0);
                    this.cta1.setText(cTInboxMessageContent.getLinkText(jSONObject4));
                    this.cta1.setTextColor(Color.parseColor(cTInboxMessageContent.getLinkColor(jSONObject4)));
                    this.cta1.setBackgroundColor(Color.parseColor(cTInboxMessageContent.getLinkBGColor(jSONObject4)));
                    JSONObject jSONObject5 = links.getJSONObject(1);
                    this.cta2.setVisibility(0);
                    this.cta2.setText(cTInboxMessageContent.getLinkText(jSONObject5));
                    this.cta2.setTextColor(Color.parseColor(cTInboxMessageContent.getLinkColor(jSONObject5)));
                    this.cta2.setBackgroundColor(Color.parseColor(cTInboxMessageContent.getLinkBGColor(jSONObject5)));
                    JSONObject jSONObject6 = links.getJSONObject(2);
                    this.cta3.setVisibility(0);
                    this.cta3.setText(cTInboxMessageContent.getLinkText(jSONObject6));
                    this.cta3.setTextColor(Color.parseColor(cTInboxMessageContent.getLinkColor(jSONObject6)));
                    this.cta3.setBackgroundColor(Color.parseColor(cTInboxMessageContent.getLinkBGColor(jSONObject6)));
                    if (parent != null) {
                        this.cta1.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, this.cta1.getText().toString(), jSONObject4, parent, false, 0));
                        this.cta2.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, this.cta2.getText().toString(), jSONObject5, parent, false, 1));
                        this.cta3.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, this.cta3.getText().toString(), jSONObject6, parent, false, 2));
                    }
                }
            } catch (JSONException e2) {
                Logger.d("Error parsing CTA JSON - " + e2.getLocalizedMessage());
            }
        } else {
            this.ctaLinearLayout.setVisibility(8);
        }
        this.mediaImage.setVisibility(8);
        this.mediaImage.setBackgroundColor(Color.parseColor(cTInboxMessage.getBgColor()));
        this.squareImage.setVisibility(8);
        this.squareImage.setBackgroundColor(Color.parseColor(cTInboxMessage.getBgColor()));
        this.mediaLayout.setVisibility(8);
        this.progressBarFrameLayout.setVisibility(8);
        try {
            String orientation = cTInboxMessage.getOrientation();
            int iHashCode = orientation.hashCode();
            if (iHashCode != 108) {
                if (iHashCode == 112 && orientation.equals("p")) {
                    if (!TextUtils.isEmpty(cTInboxMessageContent.getMediaContentDescription())) {
                        this.squareImage.setContentDescription(cTInboxMessageContent.getMediaContentDescription());
                    }
                    if (cTInboxMessageContent.mediaIsImage()) {
                        this.mediaLayout.setVisibility(0);
                        this.squareImage.setVisibility(0);
                        this.squareImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        try {
                            Glide.with(this.squareImage.getContext()).load(cTInboxMessageContent.getMedia()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER)).error(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER))).into(this.squareImage);
                        } catch (NoSuchMethodError unused) {
                            Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
                            Glide.with(this.squareImage.getContext()).load(cTInboxMessageContent.getMedia()).into(this.squareImage);
                        }
                    } else if (cTInboxMessageContent.mediaIsGIF()) {
                        this.mediaLayout.setVisibility(0);
                        this.squareImage.setVisibility(0);
                        this.squareImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        try {
                            Glide.with(this.squareImage.getContext()).asGif().load(cTInboxMessageContent.getMedia()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER)).error(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER))).into(this.squareImage);
                        } catch (NoSuchMethodError unused2) {
                            Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
                            Glide.with(this.squareImage.getContext()).asGif().load(cTInboxMessageContent.getMedia()).into(this.squareImage);
                        }
                    } else if (cTInboxMessageContent.mediaIsVideo()) {
                        if (!cTInboxMessageContent.getPosterUrl().isEmpty()) {
                            this.mediaLayout.setVisibility(0);
                            this.squareImage.setVisibility(0);
                            if (CTInboxActivity.orientation == 2) {
                                this.squareImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            } else {
                                this.squareImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            }
                            try {
                                Glide.with(this.squareImage.getContext()).load(cTInboxMessageContent.getPosterUrl()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, Constants.VIDEO_THUMBNAIL)).error(Utils.getThumbnailImage(this.context, Constants.VIDEO_THUMBNAIL))).into(this.squareImage);
                            } catch (NoSuchMethodError unused3) {
                                Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
                                Glide.with(this.squareImage.getContext()).load(cTInboxMessageContent.getPosterUrl()).into(this.squareImage);
                            }
                        } else {
                            this.mediaLayout.setVisibility(0);
                            this.squareImage.setVisibility(0);
                            if (CTInboxActivity.orientation == 2) {
                                this.squareImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            } else {
                                this.squareImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            }
                            int thumbnailImage = Utils.getThumbnailImage(this.context, Constants.VIDEO_THUMBNAIL);
                            if (thumbnailImage != -1) {
                                Glide.with(this.squareImage.getContext()).load(Integer.valueOf(thumbnailImage)).into(this.squareImage);
                            }
                        }
                    } else if (cTInboxMessageContent.mediaIsAudio()) {
                        this.mediaLayout.setVisibility(0);
                        this.squareImage.setVisibility(0);
                        this.squareImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        this.squareImage.setBackgroundColor(getImageBackgroundColor());
                        int thumbnailImage2 = Utils.getThumbnailImage(this.context, Constants.AUDIO_THUMBNAIL);
                        if (thumbnailImage2 != -1) {
                            Glide.with(this.squareImage.getContext()).load(Integer.valueOf(thumbnailImage2)).into(this.squareImage);
                        }
                    }
                }
            } else if (orientation.equals(CmcdData.Factory.STREAM_TYPE_LIVE)) {
                if (!TextUtils.isEmpty(cTInboxMessageContent.getMediaContentDescription())) {
                    this.mediaImage.setContentDescription(cTInboxMessageContent.getMediaContentDescription());
                }
                if (cTInboxMessageContent.mediaIsImage()) {
                    this.mediaLayout.setVisibility(0);
                    this.mediaImage.setVisibility(0);
                    this.mediaImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    try {
                        Glide.with(this.mediaImage.getContext()).load(cTInboxMessageContent.getMedia()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER)).error(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER))).into(this.mediaImage);
                    } catch (NoSuchMethodError unused4) {
                        Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
                        Glide.with(this.mediaImage.getContext()).load(cTInboxMessageContent.getMedia()).into(this.mediaImage);
                    }
                } else if (cTInboxMessageContent.mediaIsGIF()) {
                    this.mediaLayout.setVisibility(0);
                    this.mediaImage.setVisibility(0);
                    this.mediaImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    try {
                        Glide.with(this.mediaImage.getContext()).asGif().load(cTInboxMessageContent.getMedia()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER)).error(Utils.getThumbnailImage(this.context, Constants.IMAGE_PLACEHOLDER))).into(this.mediaImage);
                    } catch (NoSuchMethodError unused5) {
                        Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
                        Glide.with(this.mediaImage.getContext()).asGif().load(cTInboxMessageContent.getMedia()).into(this.mediaImage);
                    }
                } else if (cTInboxMessageContent.mediaIsVideo()) {
                    if (!cTInboxMessageContent.getPosterUrl().isEmpty()) {
                        this.mediaLayout.setVisibility(0);
                        this.mediaImage.setVisibility(0);
                        this.mediaImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        try {
                            Glide.with(this.mediaImage.getContext()).load(cTInboxMessageContent.getPosterUrl()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, Constants.VIDEO_THUMBNAIL)).error(Utils.getThumbnailImage(this.context, Constants.VIDEO_THUMBNAIL))).into(this.mediaImage);
                        } catch (NoSuchMethodError unused6) {
                            Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
                            Glide.with(this.mediaImage.getContext()).load(cTInboxMessageContent.getPosterUrl()).into(this.mediaImage);
                        }
                    } else {
                        this.mediaLayout.setVisibility(0);
                        this.mediaImage.setVisibility(0);
                        this.mediaImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        int thumbnailImage3 = Utils.getThumbnailImage(this.context, Constants.VIDEO_THUMBNAIL);
                        if (thumbnailImage3 != -1) {
                            Glide.with(this.mediaImage.getContext()).load(Integer.valueOf(thumbnailImage3)).into(this.mediaImage);
                        }
                    }
                } else if (cTInboxMessageContent.mediaIsAudio()) {
                    this.mediaLayout.setVisibility(0);
                    this.mediaImage.setVisibility(0);
                    this.mediaImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.mediaImage.setBackgroundColor(getImageBackgroundColor());
                    int thumbnailImage4 = Utils.getThumbnailImage(this.context, Constants.AUDIO_THUMBNAIL);
                    if (thumbnailImage4 != -1) {
                        Glide.with(this.mediaImage.getContext()).load(Integer.valueOf(thumbnailImage4)).into(this.mediaImage);
                    }
                }
            }
        } catch (NoClassDefFoundError unused7) {
            Logger.d("CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info");
        }
        Resources resources = this.context.getResources();
        if (CTInboxActivity.orientation == 2) {
            iRound = resources.getDisplayMetrics().heightPixels / 2;
            i2 = resources.getDisplayMetrics().widthPixels / 2;
        } else {
            i2 = resources.getDisplayMetrics().widthPixels;
            iRound = cTInboxMessage.getOrientation().equalsIgnoreCase(CmcdData.Factory.STREAM_TYPE_LIVE) ? Math.round(i2 * 0.5625f) : i2;
        }
        this.progressBarFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(i2, iRound));
        markItemAsRead(cTInboxMessage, i);
        if (parent != null) {
            this.clickLayout.setOnClickListener(new CTInboxButtonClickListener(i, cTInboxMessage, (String) null, (JSONObject) null, parent, true, -1));
        }
    }
}
