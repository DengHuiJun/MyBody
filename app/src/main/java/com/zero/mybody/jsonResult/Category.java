package com.zero.mybody.jsonResult;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by allen on 2017/7/20.
 */

public class Category implements Parcelable {
    private String description;
    private int id;
    private String keywords;
    private String name;
    private int seq;
    private String title;

    public Category() {}

    private Category(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {

        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(keywords);
        dest.writeInt(seq);
        dest.writeString(title);
    }

    public void readFromParcel(Parcel in) {
        description = in.readString();
        id = in.readInt();
        name = in.readString();
        keywords = in.readString();
        seq = in.readInt();
        title = in.readString();
    }
}
