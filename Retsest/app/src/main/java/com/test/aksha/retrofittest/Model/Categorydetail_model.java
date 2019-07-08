package com.test.aksha.retrofittest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categorydetail_model {


    @Expose
    @SerializedName("category")
    private List<Category> category;
    @Expose
    @SerializedName("success")
    private int success;

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public static class Category {
        @Expose
        @SerializedName("playstore_link")
        private String playstore_link;
        @Expose
        @SerializedName("site_url")
        private String site_url;
        @Expose
        @SerializedName("site_name")
        private String site_name;
        @Expose
        @SerializedName("site_icon")
        private String site_icon;
        @Expose
        @SerializedName("category_id")
        private String category_id;

        public String getPlaystore_link() {
            return playstore_link;
        }

        public void setPlaystore_link(String playstore_link) {
            this.playstore_link = playstore_link;
        }

        public String getSite_url() {
            return site_url;
        }

        public void setSite_url(String site_url) {
            this.site_url = site_url;
        }

        public String getSite_name() {
            return site_name;
        }

        public void setSite_name(String site_name) {
            this.site_name = site_name;
        }

        public String getSite_icon() {
            return site_icon;
        }

        public void setSite_icon(String site_icon) {
            this.site_icon = site_icon;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }
    }
}
