package com.zero.mybody.jsonResult;

import java.io.Serializable;


/**
 * 详情页
 * Created by zero on 16-9-18.
 */
public class CategoryDetail implements Serializable {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"item":{"content":"　　清晨是剃须的最佳时间，这时的皮肤比较放松","ctime":"2015-07-14 08:22:41.000","id":"gsps:434-20-174218","img":"","intro":"清晨是剃须的最佳时间，这时的皮肤比较放松，剃须也可减少被刮伤的几率。忌讳从不同方向刮胡须，否则会形成倒须。 不要在洗澡前剃须...","keywords":"男人,刮胡子,运动,洗澡,出汗,毛孔","media_name":"重庆晚报","stitle":"两个时间最不该刮胡子","summary":"清晨是剃须的最佳时间，","tid":"570","title":"两个时间最不该刮胡子","tname":"保健","wapurl":"http://health.sina.cn/healthcare/2015-07-14/detail-ifxewnih2259265.d.html"},"ret_code":0}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * item : {"content":"　　清晨是剃须的最佳时间，这时的皮肤比较放松","ctime":"2015-07-14 08:22:41.000","id":"gsps:434-20-174218","img":"","intro":"清晨是剃须的最佳时间，这时的皮肤比较放松，剃须也可减少被刮伤的几率。忌讳从不同方向刮胡须，否则会形成倒须。 不要在洗澡前剃须...","keywords":"男人,刮胡子,运动,洗澡,出汗,毛孔","media_name":"重庆晚报","stitle":"两个时间最不该刮胡子","summary":"清晨是剃须的最佳时间，","tid":"570","title":"两个时间最不该刮胡子","tname":"保健","wapurl":"http://health.sina.cn/healthcare/2015-07-14/detail-ifxewnih2259265.d.html"}
         * ret_code : 0
         */

        private ItemBean item;
        private int ret_code;

        public ItemBean getItem() {
            return item;
        }

        public void setItem(ItemBean item) {
            this.item = item;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public static class ItemBean {
            /**
             * content : 　　清晨是剃须的最佳时间，这时的皮肤比较放松
             * ctime : 2015-07-14 08:22:41.000
             * id : gsps:434-20-174218
             * img :
             * intro : 清晨是剃须的最佳时间，这时的皮肤比较放松，剃须也可减少被刮伤的几率。忌讳从不同方向刮胡须，否则会形成倒须。 不要在洗澡前剃须...
             * keywords : 男人,刮胡子,运动,洗澡,出汗,毛孔
             * media_name : 重庆晚报
             * stitle : 两个时间最不该刮胡子
             * summary : 清晨是剃须的最佳时间，
             * tid : 570
             * title : 两个时间最不该刮胡子
             * tname : 保健
             * wapurl : http://health.sina.cn/healthcare/2015-07-14/detail-ifxewnih2259265.d.html
             */

            private String content;
            private String ctime;
            private String id;
            private String img;
            private String intro;
            private String keywords;
            private String media_name;
            private String stitle;
            private String summary;
            private String tid;
            private String title;
            private String tname;
            private String wapurl;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getMedia_name() {
                return media_name;
            }

            public void setMedia_name(String media_name) {
                this.media_name = media_name;
            }

            public String getStitle() {
                return stitle;
            }

            public void setStitle(String stitle) {
                this.stitle = stitle;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getWapurl() {
                return wapurl;
            }

            public void setWapurl(String wapurl) {
                this.wapurl = wapurl;
            }
        }
    }
}
