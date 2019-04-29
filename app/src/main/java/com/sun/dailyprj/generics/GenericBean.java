package com.sun.dailyprj.generics;

/*
 * =====================================================================================
 * Summary:
 *
 * File: GenericBean.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/26 17:18
 * =====================================================================================
 */
public class GenericBean{
    public String title;
    public String url;

    public GenericBean(String title,String url){
        this.title = title;
        this.url = url;
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

    @Override
    public String toString() {
        return "GenericBean{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
