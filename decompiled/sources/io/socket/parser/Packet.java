package io.socket.parser;

/* JADX INFO: loaded from: classes9.dex */
public class Packet<T> {
    public int attachments;
    public T data;
    public int id;
    public String nsp;
    public int type;

    public Packet() {
        this.type = -1;
        this.id = -1;
    }

    public Packet(int i) {
        this.id = -1;
        this.type = i;
    }

    public Packet(int i, T t) {
        this.id = -1;
        this.type = i;
        this.data = t;
    }
}
