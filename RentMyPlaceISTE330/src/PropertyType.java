public class PropertyType
{
    public int id;
    public String type;

    public PropertyType() {
        this.id = -1;
        this.type = null;
    }

    public PropertyType(int id, String type) {
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
}