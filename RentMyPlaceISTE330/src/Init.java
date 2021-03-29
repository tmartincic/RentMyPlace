import java.util.ArrayList;

public class Init {
    public static void main(String[] args){

        //Each query line can be comented out (EXCEPT get(), get() is manditory) and the query will still perform,
        //try commenting .select() and you will get all properties instead of selected ones, if orWhere is commented
        //we won't return apartment with size exactly 55. OrderBy can be commented out and we wont get any order.
        //All of these functions can be chained in ANY order and NONE ARE MANDITORY. It can be as simply as
        //new Property().get() to retrieve all properties from table "properties"
        ArrayList<Property> properties_from_labin = new Property()
                .select(new String[]{"id", "description", "pricePerNight", "size", "bedrooms"})
                .where("pricePerNight", "<", "150")
                .orWhere("size", "=", "55")
                .orderBy(new String[]{"pricePerNight", "size"}, "ASC")
                .get();

        System.out.println("size: " + properties_from_labin.size());
        for (Property property : properties_from_labin) {
            System.out.println(property.toString());
        }
    }
}
