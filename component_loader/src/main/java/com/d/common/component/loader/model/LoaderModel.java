package com.d.common.component.loader.model;

import com.d.lib.common.module.mvp.model.BaseModel;

import java.util.List;

/**
 * Loader
 * Created by D on 2018/3/3.
 */
public class LoaderModel extends BaseModel {
    public RatingBean rating;
    public String title;
    public int collect_count;
    public String original_title;
    public String subtype;
    public String year;
    public ImagesBean images;
    public String alt;
    public String id;
    public List<String> genres;
    public List<CastsBean> casts;
    public List<DirectorsBean> directors;

    public static class RatingBean {
        public int max;
        public double average;
        public String stars;
        public int min;
    }

    public static class ImagesBean {
        public String small;
        public String large;
        public String medium;
    }

    public static class CastsBean {
        public String alt;
        public AvatarsBean avatars;
        public String name;
        public String id;

        public static class AvatarsBean {
            public String small;
            public String large;
            public String medium;
        }
    }

    public static class DirectorsBean {
        public String alt;
        public AvatarsBeanX avatars;
        public String name;
        public String id;

        public static class AvatarsBeanX {
            public String small;
            public String large;
            public String medium;
        }
    }

    /**
     * 获取星级
     */
    public static String getRating(LoaderModel item) {
        if (item.rating == null) {
            return "?";
        }
        if (item.rating.average >= 8) {
            return "⭐⭐⭐⭐⭐ " + item.rating.average;
        } else if (item.rating.average >= 6) {
            return "⭐⭐⭐⭐ " + item.rating.average;
        } else if (item.rating.average >= 4) {
            return "⭐⭐⭐ " + item.rating.average;
        } else if (item.rating.average >= 2) {
            return "⭐⭐ " + item.rating.average;
        } else {
            return "⭐ " + item.rating.average;
        }
    }

    /**
     * 获取导演列表
     */
    public static String getDirectors(List<LoaderModel.DirectorsBean> directors) {
        if (directors == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < directors.size(); i++) {
            sb.append(directors.get(i).name);
            if (i >= 2) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 获取演员表
     */
    public static String getCasts(List<LoaderModel.CastsBean> casts) {
        if (casts == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < casts.size(); i++) {
            sb.append(casts.get(i).name);
            if (i >= 2) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
