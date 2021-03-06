package com.magicweight.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import java.io.Serializable;

/**
 * Entity mapped to table "ARTICLES_CONTENTS".
 */
public class ArticlesContents implements Serializable{

    private Long id;
    private String url;
    private String type;
    private String name;
    private String image;
    private String isSee;
    private String isDo;
    private String delsign;

    public ArticlesContents() {
    }

    public ArticlesContents(Long id) {
        this.id = id;
    }

    public ArticlesContents(Long id, String url, String type, String name, String image, String isSee, String isDo, String delsign) {
        this.id = id;
        this.url = url;
        this.type = type;
        this.name = name;
        this.image = image;
        this.isSee = isSee;
        this.isDo = isDo;
        this.delsign = delsign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsSee() {
        return isSee;
    }

    public void setIsSee(String isSee) {
        this.isSee = isSee;
    }

    public String getIsDo() {
        return isDo;
    }

    public void setIsDo(String isDo) {
        this.isDo = isDo;
    }

    public String getDelsign() {
        return delsign;
    }

    public void setDelsign(String delsign) {
        this.delsign = delsign;
    }

}
