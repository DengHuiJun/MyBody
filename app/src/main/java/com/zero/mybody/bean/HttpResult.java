package com.zero.mybody.bean;

import java.util.List;

/**
 * Created by zero on 16-9-18.
 */
public class HttpResult {


    /**
     * status : true
     * tngou : [{"description":"社会热点，健康资讯，综合健康资讯,生活热点新闻,社会热点新闻,社会热点查询,提供最新的健康资讯,社会热点新闻网","id":6,"keywords":"社会热点","name":"社会热点","seq":1,"title":"社会热点"},{"description":"食品新闻,食品新闻,食品安全新闻,食品资讯,食品行业新闻,食品资讯,餐饮资讯,提供专业的食品新闻查询,食品新闻网","id":5,"keywords":"食品新闻","name":"食品新闻","seq":2,"title":"食品新闻"},{"description":"疾病快讯,疾病资讯,疾病新闻,提供专业 最新的疾病信息,疾病信息查询,了解最新的疾病资讯,疾病快讯网","id":7,"keywords":"疾病快讯","name":"疾病快讯","seq":2,"title":"疾病快讯"},{"description":"药品新闻 ,是发布中国有关药品,医疗器械,保健药品等专业医药资讯,提供最新的药品新闻资讯,药品新闻网","id":4,"keywords":"药品新闻","name":"药品新闻","seq":3,"title":"药品新闻"},{"description":"生活贴士,提供专门的健康生活贴士,解决健康生活问题,如何健康生活,健康生活提示,提供最新的健康生活新闻资讯,生活贴士网","id":3,"keywords":"生活贴士","name":"生活贴士","seq":4,"title":"生活贴士"},{"description":"医疗新闻,医院最新资讯,医疗事故,医疗技术,最权威的医院,医疗技术,医疗信息分享平台,提供专业医疗新闻资讯查询,医疗新闻网","id":2,"keywords":"医疗新闻","name":"医疗新闻","seq":5,"title":"医疗新闻"},{"description":"企业要闻,医药企业最新动态,最新资讯和新闻,带来最快最全的企业新闻资讯,为人们提供专业的健康,医药公司企业要闻查询,医药企业网","id":1,"keywords":"企业要闻","name":"企业要闻","seq":6,"title":"企业要闻"}]
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

    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        private String description;
        private int id;
        private String keywords;
        private String name;
        private int seq;
        private String title;

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
    }
}
