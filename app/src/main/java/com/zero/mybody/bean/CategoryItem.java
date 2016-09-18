package com.zero.mybody.bean;

/**
 * 类目下的子项
 * Created by zero on 16-9-18.
 */
public class CategoryItem {
    /**
     *{
     "count": 203,
     "description": "应对生育小高潮：取消特需病房增加产床 耿玉田强调，严格执行孕妇分级建档，构建和推进孕产妇分级诊疗，引导具有一般高危因素的孕妇在二级及以上助产机构进行建档及产前保健；具有严重高危因素的孕妇在区级抢救指定医院或三级助产机构进行建档及产前保健；具有极严重高危因素和不宜妊娠的孕妇必须在市级抢救指定医院进行建档及产前保健",
     "fcount": 1,
     "id": 6740,
     "img": "/info/160909/012c38378d3c534ebcde720aaa250150.jpg",
     "infoclass": 2,
     "keywords": "北京市 建档 孕产妇 助产 服务 ",
     "rcount": 0,
     "time": 1473401396000,
     "title": "生育小高潮：取消特需病房增加产床"
     },
     */

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
