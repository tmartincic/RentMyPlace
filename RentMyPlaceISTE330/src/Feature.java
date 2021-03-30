import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Feature extends Model
{
    private static final String table_name = "feature";

    public int id;
    public String feature;

    public Feature() {
        super(table_name);
        this.id = -1;
        this.feature = null;
    }

    public Feature(int id, String feature) {
        super(table_name);
        this.id = id;
        this.feature = feature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


    @Override
    public String toString() {
        return "Feature{" +
                ", id=" + id +
                ", feature='" + feature + '\'' +
                '}';
    }

    public Feature assign(Map<String, String> row) {
        for (String attribute: row.keySet()) {
            switch (attribute) {
                case "id" -> this.setId(Integer.parseInt(row.get(attribute)));
                case "feature" -> this.setFeature(row.get(attribute));
            }
        }
        return this;
    }
    @Override
    public ArrayList<Feature> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Feature> features = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            Feature feature = new Feature();
            feature.assign(row);
            features.add(feature);
        }
        return features;
    }

    public Feature create(Map<String, String> row) {
        int id = super.createModel(row);
        setId(id);
        this.assign(row);
        return this;
    }
}