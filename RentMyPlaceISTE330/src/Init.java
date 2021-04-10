import com.mysql.cj.protocol.Message;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Init {
    public static void main(String[] args){

        //Create new property and persist in database
       /* new Property().create(Map.ofEntries(
                //Map.entry(KEY, VALUE), //both key and value are String
                Map.entry("userId", "1"),
                Map.entry("locationId", "5"),
                Map.entry("description", "Kumlerovi dvori, just above Zagreb."),
                Map.entry("propertyTypeId", "5"),
                Map.entry("imagePath", "https://picsum.photos/200/300.jpg"),
                Map.entry("bedrooms", "15"),
                Map.entry("size", "500"),
                Map.entry("pricePerNight", "1099")
        ));*/

        //Create new property, persist in database and assign to variable
       /*Property createdProperty = new Property().create(Map.ofEntries(
                //Map.entry(KEY, VALUE), //both key and value are String
                Map.entry("userId", "2"),
                Map.entry("locationId", "9"),
                Map.entry("description", "A hotel."),
                Map.entry("propertyTypeId", "2"),
                Map.entry("imagePath", "https://picsum.photos/200/500.jpg"),
                Map.entry("bedrooms", "150"),
                Map.entry("size", "5000"),
                Map.entry("pricePerNight", "799.99")
        ));*/
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
       /* System.out.println(new Property().create(Map.ofEntries(
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
        //new Property().get() to retrieve all properties from table "properties"
        /*System.out.println("\n### SELECT: ");
        ArrayList<Property> properties_from_labin = new Property()
                .select(new String[]{"id", "description", "pricePerNight", "size", "bedrooms"})
                .where("pricePerNight", "<", "800")
                .orWhere("propertyTypeId", "=", "1")
                .orderBy(new String[]{"pricePerNight", "size"}, "ASC")
                .get();
        for (Property property : properties_from_labin) {
            System.out.println(property.toString());
        }*/

        //TESTING DELETE METHOD
        /*System.out.println("\n### SELECT: ");
        ArrayList<Feature> features_to_delete = new Feature()
                .select(new String[]{"id", "feature"})
                .where("id", "=", "2")
                .get();
        for (Feature feature : features_to_delete) {
            System.out.println("Deleting: " + feature.toString());
            feature.delete();
        }*/

        //ADDING NEW USER TESTING
        Scanner sc = new Scanner(System.in);
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
        )).toString());


       //RentMyPlaceController controller = new RentMyPlaceController(new LoginGUI(), new Model());

    }
}
