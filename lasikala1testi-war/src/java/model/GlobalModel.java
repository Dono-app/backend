/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author iosdev
 */
public class GlobalModel {

    private final List<Listing> listi = new ArrayList();
    
    
    
    private GlobalModel() {

    }

    public String getListSize() {
        String listSize = String.valueOf(listi.size() + 1);
        return listSize;
    }

    public void addListing(Listing newListing) {
        this.listi.add(newListing);
    }

    public static GlobalModel getInstance() {
        return GlobalModelHolder.INSTANCE;
    }
    

    public String getAllListings() {

        JSONArray jsonArray = new JSONArray();

        for (Listing l : this.listi) {

            JSONObject obj = new JSONObject();
            String base64Image = Base64.getEncoder().encodeToString(l.getImg());
            obj.put("imageName", l.getImageName());
            obj.put("img", base64Image);
            obj.put("categoryId", l.getCategoryId());
            obj.put("listingName", l.getListingName());
            //obj.put("userId", l.getUserId());
            //obj.put("listingId", l.getListingId());
            //obj.put("image", l.getImage());   
            obj.put("location", l.getLocation());
            obj.put("rating", l.getRating());
            obj.put("email", l.getEmail());
            obj.put("description", l.getDescription());

            jsonArray.add(obj);

        }
        return jsonArray.toJSONString();
    }

    private static class GlobalModelHolder {

        private static final GlobalModel INSTANCE = new GlobalModel();
    }
}
