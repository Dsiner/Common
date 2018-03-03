package com.d.commonapp.model;

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
}
