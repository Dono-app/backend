/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author iosdev
 */
public class Listing {

    private byte[] img;
    private String imageName;
    private String listingName;
    private String listingId;
    private String image;
    private String categoryId;
    private String location;
    private String rating;
    private String email;
    private String tel;
    private String description;

    /**
     * @return the listingId
     */
    public Listing() {

    }

    public Listing(String name, byte[] img, String categoryId, String listingName,
            String location, String rating, String email, String description) {

        this.imageName = name;
        this.img = img;
        this.listingName = listingName;       
        this.categoryId = categoryId;
        this.location = location;
        this.rating = rating;
        this.email = email;
        this.description = description;

    }

    Listing(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the img
     */
    public byte[] getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(byte[] img) {
        this.img = img;
    }

    /**
     * @return the imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @param imageName the imageName to set
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    /**
     * @return the listingName
     */
    public String getListingName() {
        return listingName;
    }

    /**
     * @param listingName the listingName to set
     */
    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public String getId() {
        return getListingId();
    }

    /**
     * @param id the listingId to set
     */
    public void setId(String id) {
        this.setListingId(id);
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the listingId
     */
    public String getListingId() {
        return listingId;
    }

    /**
     * @param listingId the listingId to set
     */
    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    void setName(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
