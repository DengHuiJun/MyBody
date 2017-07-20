package com.zero.mybody.jsonResult;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zero on 16-9-18.
 */
public class CategoryResult {

    /**
     * status : true
     * tngou : [...]
     */

    private boolean status;
    /**
     * description : 社会热点，健康资讯，综合健康资讯,生活热点新闻,社会热点新闻,社会热点查询,提供最新的健康资讯,社会热点新闻网
     * id : 6
     * keywords : 社会热点
     * name : 社会热点
     * seq : 1
     * title : 社会热点
     */
    @SerializedName("tngou")
    private List<Category> categories;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static class Category implements Parcelable {
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

        public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {

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
}
