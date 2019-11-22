package com.atchaya.notes.models;

import androidx.annotation.NonNull;

public class note {

    private String title;
    private String content;
    private String timestamp;

    public  note(String title,String content,String timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public  Note() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String SetString(){
        return "Notes{" +
                "titles=' " + title + '\'' +
                ", content=' " + content + '\'' +
                ", timestamp='" + timestamp +'\''
                '}';


    }
}






