package com.x5.template.providers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* JADX INFO: loaded from: classes9.dex */
public class NetTemplates extends TemplateProvider {
    private String baseURL;

    public NetTemplates(String str) {
        this.baseURL = str;
    }

    @Override // com.x5.template.providers.TemplateProvider
    public String loadContainerDoc(String str) throws IOException {
        return getUrlContents(this.baseURL + str);
    }

    @Override // com.x5.template.providers.TemplateProvider, com.x5.template.ContentSource
    public String getProtocol() {
        return "net";
    }

    private static String getUrlContents(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openConnection().getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line + "\n");
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }
}
