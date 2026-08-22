package androidx.media3.session.legacy;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;

/* JADX INFO: loaded from: classes4.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: androidx.media3.session.legacy.MediaDescriptionCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return (MediaDescriptionCompat) Assertions.checkNotNull(MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel)));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private static final String TAG = "MediaDescriptionCompat";
    private final CharSequence mDescription;
    private MediaDescription mDescriptionFwk;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.mIcon = (Bitmap) parcel.readParcelable(classLoader);
        this.mIconUri = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri) parcel.readParcelable(classLoader);
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((MediaDescription) getMediaDescription()).writeToParcel(parcel, i);
    }

    public String toString() {
        return ((Object) this.mTitle) + ", " + ((Object) this.mSubtitle) + ", " + ((Object) this.mDescription);
    }

    public Object getMediaDescription() {
        MediaDescription mediaDescription = this.mDescriptionFwk;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builderCreateBuilder = Api21Impl.createBuilder();
        Api21Impl.setMediaId(builderCreateBuilder, this.mMediaId);
        Api21Impl.setTitle(builderCreateBuilder, this.mTitle);
        Api21Impl.setSubtitle(builderCreateBuilder, this.mSubtitle);
        Api21Impl.setDescription(builderCreateBuilder, this.mDescription);
        Api21Impl.setIconBitmap(builderCreateBuilder, this.mIcon);
        Api21Impl.setIconUri(builderCreateBuilder, this.mIconUri);
        Api21Impl.setExtras(builderCreateBuilder, this.mExtras);
        Api23Impl.setMediaUri(builderCreateBuilder, this.mMediaUri);
        MediaDescription mediaDescriptionBuild = Api21Impl.build(builderCreateBuilder);
        this.mDescriptionFwk = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.session.legacy.MediaDescriptionCompat fromMediaDescription(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L7f
            androidx.media3.session.legacy.MediaDescriptionCompat$Builder r1 = new androidx.media3.session.legacy.MediaDescriptionCompat$Builder
            r1.<init>()
            android.media.MediaDescription r8 = (android.media.MediaDescription) r8
            java.lang.String r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getMediaId(r8)
            r1.setMediaId(r2)
            java.lang.CharSequence r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getTitle(r8)
            r1.setTitle(r2)
            java.lang.CharSequence r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getSubtitle(r8)
            r1.setSubtitle(r2)
            java.lang.CharSequence r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getDescription(r8)
            r1.setDescription(r2)
            android.graphics.Bitmap r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getIconBitmap(r8)
            r1.setIconBitmap(r2)
            android.net.Uri r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getIconUri(r8)
            r1.setIconUri(r2)
            android.os.Bundle r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.getExtras(r8)
            android.os.Bundle r2 = androidx.media3.session.legacy.MediaSessionCompat.unparcelWithClassLoader(r2)
            if (r2 == 0) goto L44
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>(r2)
            r2 = r3
        L44:
            if (r2 == 0) goto L67
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            if (r4 == 0) goto L68
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L60
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L60
            goto L69
        L60:
            r2.remove(r3)
            r2.remove(r5)
            goto L68
        L67:
            r4 = r0
        L68:
            r0 = r2
        L69:
            r1.setExtras(r0)
            if (r4 == 0) goto L72
            r1.setMediaUri(r4)
            goto L79
        L72:
            android.net.Uri r0 = androidx.media3.session.legacy.MediaDescriptionCompat.Api23Impl.getMediaUri(r8)
            r1.setMediaUri(r0)
        L79:
            androidx.media3.session.legacy.MediaDescriptionCompat r0 = r1.build()
            r0.mDescriptionFwk = r8
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.legacy.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):androidx.media3.session.legacy.MediaDescriptionCompat");
    }

    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder setMediaId(String str) {
            this.mMediaId = str;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static MediaDescription.Builder createBuilder() {
            return new MediaDescription.Builder();
        }

        static void setMediaId(MediaDescription.Builder builder, String str) {
            builder.setMediaId(str);
        }

        static void setTitle(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }

        static void setSubtitle(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        static void setDescription(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        static void setIconBitmap(MediaDescription.Builder builder, Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        static void setIconUri(MediaDescription.Builder builder, Uri uri) {
            builder.setIconUri(uri);
        }

        static void setExtras(MediaDescription.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        static MediaDescription build(MediaDescription.Builder builder) {
            return builder.build();
        }

        static String getMediaId(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        static CharSequence getTitle(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        static CharSequence getSubtitle(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        static CharSequence getDescription(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        static Bitmap getIconBitmap(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        static Uri getIconUri(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        static Bundle getExtras(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static void setMediaUri(MediaDescription.Builder builder, Uri uri) {
            builder.setMediaUri(uri);
        }

        static Uri getMediaUri(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }
    }
}
