package com.x5.template;

import com.amazonaws.services.s3.model.InstructionFileId;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class TemplateSetSlice extends TemplateSet {
    private String context;
    private String extension;
    private TemplateSet parent;

    public TemplateSetSlice(TemplateSet templateSet, String str) {
        this.extension = null;
        this.parent = templateSet;
        this.context = str;
    }

    public TemplateSetSlice(TemplateSet templateSet, String str, String str2) {
        this.parent = templateSet;
        this.context = str;
        this.extension = str2;
    }

    @Override // com.x5.template.TemplateSet, com.x5.template.ContentSource
    public Snippet getSnippet(String str) {
        String strPutInContext = putInContext(str);
        String str2 = this.extension;
        if (str2 == null) {
            return this.parent.getSnippet(strPutInContext);
        }
        return this.parent.getSnippet(strPutInContext, str2);
    }

    private String putInContext(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            return this.context + InstructionFileId.DOT + str.substring(1);
        }
        return this.context + InstructionFileId.DOT + str;
    }

    @Override // com.x5.template.TemplateSet, com.x5.template.ChunkFactory
    public Chunk makeChunk() {
        return this.parent.makeChunk();
    }

    @Override // com.x5.template.TemplateSet, com.x5.template.ChunkFactory
    public Chunk makeChunk(String str) {
        if (this.extension == null) {
            return this.parent.makeChunk(putInContext(str));
        }
        return this.parent.makeChunk(putInContext(str), this.extension);
    }
}
