import java.util.ArrayList;

public class Init {
    public static void main(String[] args){
//        This is intended so methods can be chained as in example below of
//        selecting name, price, location_id of properties from labin,
//        where price is less then 500 and results ordered by ascending price and
//
        ArrayList<Property> properties_from_labin = new Property()
                .select(new String[]{"name", "price", "created_at"})
                .where("price", "<", "20")
                .where("is_pommes", "=", "0")
                .orderBy(new String[]{"price", "created_at"}, "ASC")
                .get();
    }
}
