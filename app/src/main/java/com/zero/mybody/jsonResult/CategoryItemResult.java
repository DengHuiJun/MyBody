package com.zero.mybody.jsonResult;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 类目下的子项
 * Created by zero on 16-9-18.
 */
public class CategoryItemResult {


    /**
     * status : true
     * total : 738
     * tngou:[...]
     */

    private boolean status;
    private int total;
    /**
     * count : 272
     * description : 食药监总局：4个医疗器械申请不予注册 按照医疗器械注册有关规定，国家食品药品监督管理总局对上述4个存在真实性问题的注册申请项目不予注册，自不予注册之日起一年内不予再次受理，对涉及的临床试验机构责成相关省市食品药品监督管理局按照《医疗器械监督管理条例》的有关规定调查处理
     * fcount : 2
     * id : 6739
     * img : /info/160909/b8f652fad9e2e9f2eec37c4f3bf7359a.jpg
     * infoclass : 1
     * keywords : 临床试验 注册 医疗器械 受理 性问题
     * rcount : 0
     * time : 1473401396000
     * title : 其中4个存在真实性问题的注册申请项目不予注册
     */

    @SerializedName("tngou")
    private List<CategoryItem> categoryItems;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }

    public static class CategoryItem {
        private int count;
        private String description;
        private int fcount;
        private int id;
        private String img;
        private int infoclass;
        private String keywords;
        private int rcount;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getInfoclass() {
            return infoclass;
        }

        public void setInfoclass(int infoclass) {
            this.infoclass = infoclass;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
