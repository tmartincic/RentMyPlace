import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PropertyType extends Model
{
    private static final String table_name = "property_type";

    public int id;
    public String type;

    public PropertyType() {
        super(table_name);
        this.id = -1;
        this.type = null;
    }

    public PropertyType(int id, String type) {
        super(table_name);
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PropertyType{" +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public PropertyType assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "type" -> this.setType(row.get(attribute));
            }
        }
        return this;
    }
    @Override
    public ArrayList<PropertyType> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<PropertyType> propertyTypes = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            PropertyType propertyType = new PropertyType();
            propertyType.assign(row);
            propertyTypes.add(propertyType);
        }
        return propertyTypes;
    }

    public PropertyType create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }
}