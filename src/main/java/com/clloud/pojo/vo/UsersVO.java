package com.clloud.pojo.vo;

import javax.persistence.Column;
import javax.persistence.Id;

public class UsersVO {
    private String id;
    private String username;
    private String faceImage;
    private String faceImageBig;
    private String nickname;
    private String qrcode;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public String getFaceImageBig() {
        return faceImageBig;
    }

    public String getNickname() {
        return nickname;
    }

    public String getQrcode() {
        return qrcode;
    }
}