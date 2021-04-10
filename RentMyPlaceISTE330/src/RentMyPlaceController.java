import javax.swing.*;
import java.util.ArrayList;

public class RentMyPlaceController {
    /*LoginGUI gui;
    Model model;
    public RentMyPlaceController(LoginGUI gui, Model model){
        this.gui = gui;
        this.model = model;
    }*/

    public RentMyPlaceController(){}

    public boolean checkUser(String userName, String password){
        boolean authenticated = false;
        ArrayList<User> all_users = new User()
                .select(new String[]{"id", "username", "password"})
                .get();
        for (User user : all_users) {
            if(user.authenticate(userName, password)) {
                System.out.println("User found: " + user.toString());
                authenticated = true;
                break;
            }
        }
        return authenticated;
    }
}
