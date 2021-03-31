import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Favorite extends Model
{
    private static final String table_name= "favorite";

    public int userId;
    public int propertyId;

    public Favorite() {
        super(table_name);
        this.userId = -1;
        this.propertyId = -1;
    }

    public Favorite(int userId, int propertyId) {
        super(table_name);
        this.userId = userId;
        this.propertyId = propertyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String toString(){
        return "Favorite{" +
                ", userId=" + userId +
                ", propertyId=" + propertyId +
                '}';
    }

    public Favorite assign(Map<String, String> row){
        for(String attribute : row.keySet()) {
            switch(attribute) {
                case "userId" -> setUserId(Integer.parseInt(attribute));
                case "propertyId" -> setPropertyId(Integer.parseInt(attribute));
            }
        }
        return this;
    }
    @Override
    public ArrayList<Favorite> get(){
        ArrayList<HashMap<String, String>> list_of_rows = super.getData();
        ArrayList<Favorite> favorites = new ArrayList<>();

        for(HashMap< String, String> row : list_of_rows){
            Favorite favorite = new Favorite();
            favorite.assign(row);
            favorites.add(favorite);
        }
        return favorites;
    }

    public Favorite create(Map<String, String> row) {
        int id = super.createModel(row);
        setUserId(id);
        this.assign(row);
        return this;
    }
}