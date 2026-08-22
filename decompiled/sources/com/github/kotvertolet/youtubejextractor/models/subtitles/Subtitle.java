package com.github.kotvertolet.youtubejextractor.models.subtitles;

/* JADX INFO: loaded from: classes7.dex */
public class Subtitle {
    private String duration;
    private String start;
    private String text;

    public Subtitle(String str, String str2, String str3) {
        this.start = str;
        this.duration = str2;
        this.text = str3;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Subtitle subtitle = (Subtitle) obj;
            String str = this.start;
            if (str == null ? subtitle.start != null : !str.equals(subtitle.start)) {
                return false;
            }
            String str2 = this.duration;
            if (str2 == null ? subtitle.duration != null : !str2.equals(subtitle.duration)) {
                return false;
            }
            String str3 = this.text;
            String str4 = subtitle.text;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.start;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.duration;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Subtitle{start='" + this.start + "', duration='" + this.duration + "', text='" + this.text + "'}";
    }
}
