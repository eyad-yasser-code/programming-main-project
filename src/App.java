





import java.util.ArrayList;
import shop.ui.Data.ApiService;
import shop.ui.ShopWindow.*;

public class App {
    public static void main(String[] args) throws Exception {
        
       new ShopMainFrame(); 

       
 ArrayList<String> products = ApiService.getProducts();
  System.out.println("SIZE = " + products.size());
    for (String p : products) 
        {

    System.out.println(p);
   }

        ArrayList<String> category = ApiService.getcategory();
        System.out.println("SIZE = " + category.size());
        for (String c : category)
        {

            System.out.println(c);
        }
}

}
