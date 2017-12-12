package es.jesuslopez.zgzfromwithin.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JesusLopez on 11/7/17.
 */

public class MonumentEntity {
    
    @SerializedName("title")
    private String monumentName;
    @SerializedName("phone")
    private String monumentPhone;
    @SerializedName("address")
    private String monumentAddress;
    @SerializedName("image")
    private String monumentHeaderImage;
    @SerializedName("video")
    private String monumentVideo;
    @SerializedName("time")
    private String monumentHorary;
    @SerializedName("description")
    private String monumentDescription;

    public String getMonumentName() {
        return monumentName;
    }

    public void setmonumentName(String monumentName) {
        this.monumentName = monumentName;
    }

    public String getMonumentPhone() {
        return monumentPhone;
    }

    public void setmonumentPhone(String monumentPhone) {
        this.monumentPhone = monumentPhone;
    }

    public String getMonumentAddress() {
        return monumentAddress;
    }

    public void setmonumentAddress(String monumentAddress) {
        this.monumentAddress = monumentAddress;
    }

    public String getMonumentHeaderImage() {
        return monumentHeaderImage;
    }

    public void setmonumentHeaderImage(String monumentHeaderImage) {
        this.monumentHeaderImage = monumentHeaderImage;
    }

    public String getMonumentVideo() {
        return monumentVideo;
    }

    public void setmonumentVideo(String monumentVideo) {
        this.monumentVideo = monumentVideo;
    }

    public String getMonumentHorary() {
        return monumentHorary;
    }

    public void setmonumentHorary(String monumentHorary) {
        this.monumentHorary = monumentHorary;
    }

    public String getMonumentDescription() {
        return monumentDescription;
    }

    public void setmonumentDescription(String monumentDescription) {
        this.monumentDescription = monumentDescription;
    }
}
