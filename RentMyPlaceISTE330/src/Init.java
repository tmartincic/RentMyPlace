import java.util.ArrayList;

public class Init {
    public static void main(String[] args){
//        This is intended so methods can be chained as in example below of
//        selecting name, price, location_id of properties from labin,
//        where price is less then 500 and results ordered by ascending price and
//

        //Each query line can be comented out (EXCEPT get(), get() is manditory) and the querry will still perform,
        //try commenting .select() and you will get all properties instead of selected ones, if orWhere is commented
        //we won't return apartment with size exactly 55. OrderBy can be commented out and we wont get any order.
        //All of these functions can be chained in any order, they can be chained as much as needed or as simply as
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
