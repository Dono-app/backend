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
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import model.GlobalModel;
import model.Listing;

@Path("/upload")
public class ImageUploadREST {

    private UriInfo uriInfo;

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

    @Path("{name}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public Response createItem(Listing listing, @PathParam("imageName") String name) {
        if (GlobalModel.getInstance().itemExists(name)) {
            return Response.noContent()
                    .build();
        } else {
            GlobalModel.getInstance().editListing(listing, name);
            //status code 201
            return Response.created(uriInfo.getAbsolutePath())
                    .build();
        }
    }

    @Path("{image}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteOrderById(@PathParam("imageName") String name) {
        return "listing deleted";
    }

}
