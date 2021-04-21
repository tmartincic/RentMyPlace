import edu.rit.iste330.team7.RentMyPlace.controller.Authentication;
import edu.rit.iste330.team7.RentMyPlace.controller.RentMyPlaceController;
import edu.rit.iste330.team7.RentMyPlace.model.Feature;
import edu.rit.iste330.team7.RentMyPlace.model.Model;
import edu.rit.iste330.team7.RentMyPlace.model.User;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;

import java.util.*;
import java.util.Scanner;

public class Init {
    public static void main(String[] args){

        //Create new property and persist in database
//        new edu.rit.iste330.team7.RentMyPlace.model.Property().create(Map.ofEntries(
//                //Map.entry(KEY, VALUE), //both key and value are String
//                Map.entry("userId", "1"),
//                Map.entry("locationId", "5"),
//                Map.entry("description", "Kumlerovi dvori, just above Zagreb."),
//                Map.entry("propertyTypeId", "5"),
//                Map.entry("imagePath", "https://picsum.photos/200/300.jpg"),
//                Map.entry("bedrooms", "15"),
//                Map.entry("size", "500"),
//                Map.entry("pricePerNight", "1099")
//        ));
//
//        //Create new property, persist in database and assign to variable
//       edu.rit.iste330.team7.RentMyPlace.model.Property createdProperty = new edu.rit.iste330.team7.RentMyPlace.model.Property().create(Map.ofEntries(
//                //Map.entry(KEY, VALUE), //both key and value are String
//                Map.entry("userId", "2"),
//                Map.entry("locationId", "9"),
//                Map.entry("description", "A hotel. '; DROP TABLE user; --"),
//                Map.entry("propertyTypeId", "2"),
//                Map.entry("imagePath", "https://picsum.photos/200/500.jpg"),
//                Map.entry("bedrooms", "150"),
//                Map.entry("size", "5000"),
//                Map.entry("pricePerNight", "799.99")
//        ));
//
//        System.out.println("\n### SELECT: ");
//        ArrayList<edu.rit.iste330.team7.RentMyPlace.model.Property> properties_from_labin = new edu.rit.iste330.team7.RentMyPlace.model.Property()
//                .where("id", "<", "25")
//                .get();
//
//        properties_from_labin.get(1).update(Map.ofEntries(
//                Map.entry("userId", "2"),
//                Map.entry("locationId", "9"),
//                Map.entry("description", "A TEEEHEEEEEEEEEEE"),
//                Map.entry("propertyTypeId", "2"),
//                Map.entry("imagePath", "https://picsum.photos/250/500.jpg"),
//                Map.entry("bedrooms", "20"),
//                Map.entry("size", "500"),
//                Map.entry("pricePerNight", "123")
//        ));
//        properties_from_labin.get(0).delete();

       /*System.out.println(createdProperty.updateModel(Map.ofEntries(
                //Map.entry(KEY, VALUE), //both key and value are String
                Map.entry("userId", "3"),
                Map.entry("locationId", "9"),
                Map.entry("description", "Updated hotel."),
                Map.entry("propertyTypeId", "5"),
                Map.entry("imagePath", "https://picsum.photos/200/500.jpg"),
                Map.entry("bedrooms", "150"),
                Map.entry("size", "5000"),
                Map.entry("pricePerNight", "799.99")
        ), createdProperty.getId()));*/

       /*System.out.println(createdProperty.update(Map.ofEntries(
                //Map.entry(KEY, VALUE), //both key and value are String
                Map.entry("userId", "3"),
                Map.entry("locationId", "7"),
                Map.entry("description", "A hotel updated."),
                Map.entry("propertyTypeId", "5"),
                Map.entry("imagePath", "https://picsum.photos/200/500.jpg"),
                Map.entry("bedrooms", "150"),
                Map.entry("size", "5000"),
                Map.entry("pricePerNight", "799.99")
        )));*/
        //createdProperty.delete();
        //System.out.println("Updated property id: " + createdProperty.getId() + ", new description is " + createdProperty.getDescription());

        //System.out.println("deleting property: " + createdProperty.toString() + createdProperty.delete());

        //Create new property and persist in database and print the model
       /* System.out.println(new edu.rit.iste330.team7.RentMyPlace.model.Property().create(Map.ofEntries(
                //Map.entry(KEY, VALUE), //both key and value are String
                Map.entry("userId", "1"),
                Map.entry("locationId", "2"),
                Map.entry("description", "Sheraton Hotel, fancy shmancy  hotel, again, like a glass wall."),
                Map.entry("propertyTypeId", "2"),
                Map.entry("imagePath", "https://picsum.photos/100/600.jpg"),
                Map.entry("bedrooms", "120"),
                Map.entry("size", "250"),
                Map.entry("pricePerNight", "599.99")
        )).toString());
        */
        //Each query line can be comented out (EXCEPT get(), get() is manditory) and the query will still perform,
        //try commenting .select() and you will get all properties instead of selected ones, if orWhere is commented
        //we won't return apartment with size exactly 55. OrderBy can be commented out and we wont get any order.
        //All of these functions can be chained in ANY order and NONE ARE MANDITORY. It can be as simply as
        //new edu.rit.iste330.team7.RentMyPlace.model.Property().get() to retrieve all properties from table "properties"


        //TESTING DELETE METHOD
        /*System.out.println("\n### SELECT: ");
        ArrayList<edu.rit.iste330.team7.RentMyPlace.model.Feature> features_to_delete = new edu.rit.iste330.team7.RentMyPlace.model.Feature()
                .select(new String[]{"id", "feature"})
                .where("id", "=", "2")
                .get();
        for (edu.rit.iste330.team7.RentMyPlace.model.Feature feature : features_to_delete) {
            System.out.println("Deleting: " + feature.toString());
            feature.delete();
        }*/

        //ADDING NEW USER TESTING
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

       String convPass = Authentication.convert(pass);
       System.out.println(new User().create(Map.ofEntries(
                //Map.entry(KEY, VALUE), //both key and value are String
                Map.entry("username", username),
                Map.entry("password", convPass),
                Map.entry("userType", "g"),
                Map.entry("contactId", "2"),
                Map.entry("billingId", "2")
        )).toString());*/
        System.out.println(new Feature().select(new String[]{"id"}).where("feature", "LIKE", "Parking").get().get(0).toString());

        RentMyPlaceController controller = new RentMyPlaceController(new LoginGUI(), new Model("user"));
    }
}
