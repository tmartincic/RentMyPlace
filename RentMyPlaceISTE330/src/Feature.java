public class Feature
{
    public int id;
    public String feature;

    public Feature() {
        this.id = -1;
        this.feature = null;
    }

    public Feature(int id, String feature) {
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
}