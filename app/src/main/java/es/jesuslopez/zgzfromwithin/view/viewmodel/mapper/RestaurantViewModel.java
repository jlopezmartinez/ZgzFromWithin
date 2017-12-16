package es.jesuslopez.zgzfromwithin.view.viewmodel.mapper;

import es.jesuslopez.zgzfromwithin.domain.model.Geometry;
import es.jesuslopez.zgzfromwithin.domain.model.Tel;

/**
 * Created by JesusLopez on 7/7/17.
 */

public class RestaurantViewModel {
    private String name;
    private Tel phone;
    private String address;
    private String postalCode;
    private String locality;
    private String email;
    private String webPage;
    private String image;
    private String logo;
    private String forks;
    private String capacity;
    private Geometry geometry;
    private String accesibility;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tel getPhone() {
        return phone;
    }

    public void setPhone(Tel phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getAccesibility() {
        return accesibility;
    }

    public void setAccesibility(String accesibility) {
        this.accesibility = accesibility;
    }
}
