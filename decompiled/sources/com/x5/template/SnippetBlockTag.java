package com.x5.template;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class SnippetBlockTag extends SnippetTag {
    private Snippet body;
    private BlockTag renderer;
    private SnippetTag tagClose;
    private SnippetTag tagOpen;

    public SnippetBlockTag(SnippetTag snippetTag, List<SnippetPart> list, SnippetTag snippetTag2, String str) {
        super(snippetTag.snippetText, snippetTag.tag);
        this.tagOpen = snippetTag;
        this.tagClose = snippetTag2;
        Snippet snippet = new Snippet(list);
        this.body = snippet;
        snippet.setOrigin(str);
        initBlockTag();
    }

    private void initBlockTag() {
        String str = this.tagOpen.tag;
        if (str.startsWith(".loop")) {
            this.renderer = new LoopTag(str, this.body);
            return;
        }
        if (str.startsWith(".if")) {
            this.renderer = new IfTag(str, this.body);
        } else if (str.startsWith(".loc")) {
            this.renderer = new LocaleTag(str, this.body);
        } else if (str.startsWith(".exec")) {
            this.renderer = new MacroTag(str, this.body);
        }
    }

    @Override // com.x5.template.SnippetTag, com.x5.template.SnippetPart
    public void render(Writer writer, Chunk chunk, String str, int i) throws IOException {
        BlockTag blockTag;
        if (depthCheckFails(i, writer) || (blockTag = this.renderer) == null) {
            return;
        }
        blockTag.renderBlock(writer, chunk, str, i);
    }

    @Override // com.x5.template.SnippetPart
    public String toString() {
        return this.snippetText + this.body.toString() + this.tagClose.toString();
    }

    public SnippetTag getOpenTag() {
        return this.tagOpen;
    }

    public Snippet getBody() {
        return this.body;
    }

    public SnippetTag getCloseTag() {
        return this.tagClose;
    }

    public boolean doSmartTrimAroundBlock() {
        BlockTag blockTag = this.renderer;
        return blockTag != null && blockTag.doSmartTrimAroundBlock();
    }
}
