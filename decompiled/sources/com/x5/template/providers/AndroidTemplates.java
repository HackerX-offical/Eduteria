package com.x5.template.providers;

import android.content.Context;
import java.io.IOException;
import java.util.Scanner;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class AndroidTemplates extends TemplateProvider {
    private Context context;
    private String themeFolder;

    public AndroidTemplates(Context context) {
        this.themeFolder = "themes";
        this.context = context;
    }

    public AndroidTemplates(Context context, String str) {
        this.context = context;
        this.themeFolder = str;
    }

    @Override // com.x5.template.providers.TemplateProvider, com.x5.template.ContentSource
    public String getProtocol() {
        return "android";
    }

    @Override // com.x5.template.providers.TemplateProvider
    public String loadContainerDoc(String str) throws IOException {
        Scanner scannerUseDelimiter = new Scanner(this.context.getAssets().open(this.themeFolder + MqttTopic.TOPIC_LEVEL_SEPARATOR + str)).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }
}
