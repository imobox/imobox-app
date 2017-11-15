package br.imobox.com.imobox.model;

/**
 * Created by Wilder on 15/11/17.
 */

public class Message {
    boolean me;
    String message;

    public Message(boolean me, String message) {
        this.me = me;
        this.message = message;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
