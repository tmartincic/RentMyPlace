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
                case "id" : this.setId(Integer.parseInt(row.get(attribute))); break;
                case "feature" : this.setFeature(row.get(attribute)); break;
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

    /**
     * Updates Feature table, calls super updateModel() to perform needed task
     *               <column, value>
     * @param row Map<String, String>
     * @return Feature
     */
    public Feature update(Map<String, String> row){
        super.updateModel(row, this.id);
        this.assign(row);
        return this;
    }

    /**
     * Deletes a Feature instance based on the id, calls super deleteModel() to perform needed task
     * @return Feature
     */
    public Feature delete(){
        super.deleteModel(this.id);
        return this;
    }
}