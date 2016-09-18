package com.zero.mybody.bean;

/**
 * 资讯类目
 * Created by zero on 16-9-18.
 */
public class Category {
    /**
     * 示例
    {
    "description": "食品新闻,食品新闻,食品安全新闻,食品资讯,食品行业新闻,食品资讯,餐饮资讯,提供专业的食品新闻查询,食品新闻网",
    "id": 5,
    "keywords": "食品新闻",
    "name": "食品新闻",
    "seq": 2,
    "title": "食品新闻"
    }
    */

    private int id;
    private String name;
    private String description;
    private String keywords;
    private int seq;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public long getSeq() {
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
}
