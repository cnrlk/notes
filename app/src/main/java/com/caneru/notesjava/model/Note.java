package com.caneru.notesjava.model;

import androidx.annotation.Nullable;

public class Note {

    private String title;
    private String description;
    private String image;
    private String createDate;
    private String editDate;

    public Note(String title, String description, String url, String createDate, String editDate) {
        this.title = title;
        this.description = description;
        this.image = url;
        this.createDate = createDate;
        this.editDate = editDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Note) {
            return this.createDate.equals(((Note) obj).createDate);
        }
        return false;

    }
}
