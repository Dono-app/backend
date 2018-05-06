/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restapi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.GlobalModel;
import model.Listing;

@Path("/upload")
public class ImageUploadREST {


    String image = "";
    String output = "";
    final String directory = "/Users/iosdev/Documents/pix/";
    public int newString = 0;
    Random rnd = new Random();
    String name = "";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postImage(JsonObject jsonObject) {

        name = jsonObject.getString("imageName");
        String base64Image = jsonObject.getString("img");
        String categoryId = jsonObject.getString("categoryId");
        String listingName = jsonObject.getString("listingName");
        String location = jsonObject.getString("location");
        String rating = jsonObject.getString("rating");
        String email = jsonObject.getString("email");
        String description = jsonObject.getString("description");

        System.out.print(name);
        byte[] img = Base64.getDecoder().decode(base64Image);

        Listing newListing = new Listing(name, img, categoryId, listingName,
                location, rating, email, description);
        GlobalModel.getInstance().addListing(newListing);

        String imgPath = directory + name + ".png";

        try (FileOutputStream out = new FileOutputStream(imgPath)) {

            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            out.write(imageByteArray);

        } catch (IOException e) {
            System.out.println("not working" + e);
        }

        return "This image has been posted: " + name;
    }
}
