import edu.rit.iste330.team7.RentMyPlace.controller.RentMyPlaceController;
import edu.rit.iste330.team7.RentMyPlace.model.Model;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;

public class Init {
    public static void main(String[] args){
        //initializing the controller
        RentMyPlaceController controller = new RentMyPlaceController(new LoginGUI(), new Model("user"));
    }
}
