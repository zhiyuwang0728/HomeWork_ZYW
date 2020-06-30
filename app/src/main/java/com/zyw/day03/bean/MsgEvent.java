package com.zyw.day03.bean;

public class MsgEvent {

    int progress;
    long contentLength;
    int flag;

    public MsgEvent(int progress, long contentLength, int flag) {
        this.progress = progress;
        this.contentLength = contentLength;
        this.flag = flag;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
