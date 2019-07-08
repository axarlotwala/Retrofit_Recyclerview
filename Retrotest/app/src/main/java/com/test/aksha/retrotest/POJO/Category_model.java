package com.test.aksha.retrotest.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category_model {

    @Expose
    @SerializedName("category")
    private List<Category> category;

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

    @Expose
    @SerializedName("success")
    private int success;

    public static class Category {
        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        @Expose
        @SerializedName("category_name")
        private String category_name;
        @Expose
        @SerializedName("category_id")
        private String category_id;
    }
}
