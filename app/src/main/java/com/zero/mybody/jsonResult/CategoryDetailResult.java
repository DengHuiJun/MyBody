package com.zero.mybody.jsonResult;

/**
 * 详情页
 * Created by zero on 16-9-18.
 */
public class CategoryDetailResult {
/*
 *{
    "count": 59,
    "description": "国家卫计委公布第二批医养结合试点单位 第二批国家级医养结合试点单位包括北京市朝阳区，天津市南开区、津南区、北辰区，河北省邢台市、保定市，山西省吕梁市，内蒙古自治区乌海市，辽宁省辽阳市，吉林省长春市、公主岭市、梅河口市，黑龙江省伊春市，上海市松江区，江苏省南京市，浙江省温州市，安徽省合肥市，福建省漳州市，江西省抚州市，山东省威海市，河南省濮阳市，湖南省岳阳市，广东省广州市、深圳市，广西壮族自治区百色市，海南省海口市、三亚市、儋州市，重庆市沙坪坝区，四川省德阳市、广元市，",
    "fcount": 0,
    "id": 6760,
    "img": "/info/160923/3f1b359fbab2c3d790e931478f319342.jpg",
    "infoclass": 2,
    "keywords": "北京市 试点单位 江苏省 卫生 河北省 ",
    "message": "<p><img alt=\"国家卫计委公布第二批医养结合试点单位 \" src=\"http://tnfs.tngou.net/img/info/160923/3f1b359fbab2c3d790e931478f319342.jpg\"></p>\n<p>记者9月22日从国家卫生计生委网站获悉，经各省（区、市）卫生计生和民政部门推荐，北京市朝阳区等40个市（区）被确定为第二批国家级医养结合试点单位。</p>\n<p>第二批国家级医养结合试点单位包括北京市朝阳区，天津市南开区、津南区、北辰区，河北省邢台市、保定市，山西省吕梁市，内蒙古自治区乌海市，辽宁省辽阳市，吉林省长春市、公主岭市、梅河口市，黑龙江省伊春市，上海市松江区，江苏省南京市，浙江省温州市，安徽省合肥市，福建省漳州市，江西省抚州市，山东省威海市，河南省濮阳市，湖南省岳阳市，广东省广州市、深圳市，广西壮族自治区百色市，海南省海口市、三亚市、儋州市，重庆市沙坪坝区，四川省德阳市、广元市，贵州省遵义市，云南省昆明市、曲靖市、西双版纳州，陕西省西安市，甘肃省陇南市，青海省海南州，宁夏回族自治区银川市，新疆维吾尔自治区巴音郭楞蒙古自治州。</p>\n<p>国家卫生计生委要求，各试点单位要结合实际，统筹各方资源，全面落实医养结合工作重点任务；在各省级卫生计生和民政部门的指导下，制订年度工作计划，建立部门协作、经费保障和人员保障机制，确保试点取得积极进展，收到良好效果。据悉，国家卫生计生委和民政部将会同相关部门适时组织督导调研。</p>",
    "rcount": 0,
    "status": true,
    "time": 1474600870000,
    "title": "第二批国家级医养结合试点单位包括北京市朝阳区",
    "url": "http://www.tngou.net/info/show/6760"
}
 */

    private int count;
    private String description;
    private int fcount;
    private int id;
    private String img;
    private int infoclass;
    private String keywords;
    private String message;
    private int rcount;
    private boolean status;
    private long time;
    private String title;
    private String url;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
