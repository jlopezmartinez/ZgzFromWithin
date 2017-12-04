package es.jesuslopez.zgzfromwithin.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JesusLopez on 11/7/17.
 */

public class PlaceEntity {
    
    @SerializedName("title")
    private String placeName;
    @SerializedName("phone")
    private String placePhone;
    @SerializedName("address")
    private String placeAddress;
    @SerializedName("image")
    private String placeHeaderImage;
    @SerializedName("video")
    private String placeVideo;
    @SerializedName("time")
    private String placeHorary;
    @SerializedName("description")
    private String placeDescription;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public void setPlacePhone(String placePhone) {
        this.placePhone = placePhone;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public String getPlaceHeaderImage() {
        return placeHeaderImage;
    }

    public void setPlaceHeaderImage(String placeHeaderImage) {
        this.placeHeaderImage = placeHeaderImage;
    }

    public String getPlaceVideo() {
        return placeVideo;
    }

    public void setPlaceVideo(String placeVideo) {
        this.placeVideo = placeVideo;
    }

    public String getPlaceHorary() {
        return placeHorary;
    }

    public void setPlaceHorary(String placeHorary) {
        this.placeHorary = placeHorary;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
}
