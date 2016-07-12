package com.xu.hasee.livewhere.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class AppRecommend {

    /**
     * app_icon : http://app.api.zhuna.cn/images/v20/special/app//list/2014/07/14067969737726.jpg
     * app_name : 友约
     * app_downurl : http://dl.ifaceshow.com/upload/wm/2014/06/30/Weaver_Phone2-1-03-1002-529.apk
     * app_desc : 最好用的视频通话软件
     * agent_id : 608,607,605,157,800,799,797,796,601,790,792,794,791,785,784,782,780,775,194,173,162,770,776,606,609,730
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String app_icon;
        private String app_name;
        private String app_downurl;
        private String app_desc;
        private String agent_id;

        public ResultBean() {
        }

        public ResultBean(String app_icon, String app_name, String app_downurl, String app_desc, String agent_id) {
            this.app_icon = app_icon;
            this.app_name = app_name;
            this.app_downurl = app_downurl;
            this.app_desc = app_desc;
            this.agent_id = agent_id;
        }

        public String getApp_icon() {
            return app_icon;
        }

        public void setApp_icon(String app_icon) {
            this.app_icon = app_icon;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getApp_downurl() {
            return app_downurl;
        }

        public void setApp_downurl(String app_downurl) {
            this.app_downurl = app_downurl;
        }

        public String getApp_desc() {
            return app_desc;
        }

        public void setApp_desc(String app_desc) {
            this.app_desc = app_desc;
        }

        public String getAgent_id() {
            return agent_id;
        }

        public void setAgent_id(String agent_id) {
            this.agent_id = agent_id;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "app_icon='" + app_icon + '\'' +
                    ", app_name='" + app_name + '\'' +
                    ", app_downurl='" + app_downurl + '\'' +
                    ", app_desc='" + app_desc + '\'' +
                    ", agent_id='" + agent_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppRecommend{" +
                "result=" + result +
                '}';
    }
}
