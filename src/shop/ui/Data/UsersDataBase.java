
package shop.ui.Data;




//main imports 
import java.util.ArrayList;




public class UsersDataBase{


    public  static ArrayList<User> users = new ArrayList<>();
    

    public static void addUser(User user){users.add(user);}


    public static void removeUser(User user) {

        users.remove(user);
       
    }


}