package shop.ui.ShopWindow;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import shop.ui.AdminWrapper.AdminWrapper;
import shop.ui.CartWindow.CartWindow;
import shop.ui.CartWindow.CheckoutWindow;
import shop.ui.Data.ApiService;
import shop.ui.Data.User;
import shop.ui.Data.UsersDataBase;
import shop.ui.HomeWindow.HomeWindow;
import shop.ui.LogicHelper.*;
import shop.ui.loginWindow.CustomDialog;
import shop.ui.loginWindow.LoginWrapperWindow;


public class ShopWindow extends JPanel{

   
   
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private CartWindow cartWindow;
    private HomeWindow homeWindow;
    private LoginWrapperWindow loginWrapper;
    private CheckoutWindow checkoutWindow;
    private AdminWrapper adminWrapper;

    private ArrayList<Product> products;
    private ArrayList<Category> categories;
    

    private boolean isLogged = false;
    
    private User user= new User("Guest","","","");; // holde info for the current user, help in greetings
    
    //constructor
    
    public ShopWindow(){

        this.setLayout(new BorderLayout());

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);
        


       

        this.products = new ArrayList<Product>();
        this.categories = new ArrayList<Category>();

      


        this.loginWrapper = new LoginWrapperWindow(this);
        this.homeWindow = new HomeWindow(this);
        this.cartWindow = new CartWindow(this,checkoutWindow);
        this.checkoutWindow = new CheckoutWindow(this,cartWindow);
        this.adminWrapper = new AdminWrapper(this);
        
       

        
        UsersDataBase.addUser(user);


        File[] images = {
            new File("programming-main-project/src/images/laptop.PNG"),
            new File("programming-main-project/src/images/mouse.PNG"),
            new File("programming-main-project/src/images/microphone.PNG"),
            new File("programming-main-project/src/images/keyboard.PNG")
        };
File basePath = new File("programming-main-project/src/images");

ArrayList<String> products = ApiService.getProducts();

for (String p : products) {


    String[] parts = p.split(" - ");

    if (parts.length < 5) {
        continue; 
    }

    String id = parts[0];
    String name = parts[1];
    String description = parts[2];
    String price = parts[3];
    String image = parts[4];
    String categoryId = parts[5];


    int safeId = Integer.parseInt(id);
    double safePrice = Double.parseDouble(price);
    int safeCategory = Integer.parseInt(categoryId);


    File imgFile = new File(basePath, image);

    
    addItem(
            safeId,
            name,
            new File[]{imgFile},
            description,
            safePrice,
            safeCategory
    );
}

        //Categpry

        ArrayList<String> category = ApiService.getcategory();

        for (String p : category) {


            String[] parts = p.split(" - ");

            if (parts.length < 4) {
                continue;
            }

            String id = parts[0];
            String name = parts[1];
            String image = parts[2];
            String categoryId = parts[3];




            int safeid = Integer.parseInt(id);


            File imgFile = new File(basePath, image);


            addCategory(
                    safeid,
                    name,
                    imgFile


            );
        }

      
         
        cardPanel.add(homeWindow,"homeWindow");
        cardPanel.add(cartWindow, "cartWindow");
        cardPanel.add(loginWrapper, "loginWrapper");
        cardPanel.add(checkoutWindow, "checkoutWindow");
        cardPanel.add(adminWrapper, "adminWrapper");


        this.add(cardPanel, BorderLayout.CENTER);
       showHomeWindow();

    }

    //show functions 

    public void showCartWindow(){
        cardLayout.show(cardPanel,"cartWindow");
        cartWindow.defaultCartScroll();
        cartWindow.updateCheckoutButton(this);
        revalidate();
        repaint();
    }

    public void showHomeWindow(){
        cardLayout.show(cardPanel, "homeWindow");
        homeWindow.panelVisible(false);
        homeWindow.resetSearch();
        homeWindow.greetingLabel();
        revalidate();
        repaint();
    }


    public void showLoginWrapper(){
        cardLayout.show(cardPanel, "loginWrapper");
        loginWrapper.showLoginWindow();
        revalidate();
        repaint();
    }

    public void showCheckoutWindow(){
        cardLayout.show(cardPanel, "checkoutWindow");
        checkoutWindow.loadCheckout(cartWindow.getCart());
        

        revalidate();
        repaint();
    }

    public void showAdminWrapper(){
        cardLayout.show(cardPanel, "adminWrapper");
        adminWrapper.showAdminConfirmation();

        revalidate();
        repaint();

    }





    //add functions
 
    public void addItem(int id, String name,File[] selectedFiles,String description,double price, int categoryId){
       
       
        Product product = new Product(id,name,selectedFiles,description,price,categoryId);
        products.add(product);

        homeWindow.addItem(product);

    }

    public void addCategory(int id, String name, File selectedFile){

       
       Category category = new Category(id, name, selectedFile);
       categories.add(category);
       
        homeWindow.addCategory(category);

    }



    
    public void addToCart(Product product)
    {
      cartWindow.addToCart(product);
    }

    
    //remove functions
    public void removeItem(int id){
       
       Product removable=null;
       
        for(Product product : products){
        if(product.getId()==id){
            removable=product;
        }
       
        }
       
       if(removable != null) {
        products.remove(removable); // logic
        homeWindow.removeItem(removable); // ui 
       }
    }

   
   
    public void removeCategory(int id){

        Category removable = null;


        for(Category category : categories){
            if(category.getId()==id){
                removable = category;
            }
        }

        if(removable != null){
            categories.remove(removable); // logic
            homeWindow.removeCategory(removable); // ui
        }

    }

    public void removeFromCart(int id){
   
      cartWindow.removeFromCart(id);

    }

   

    //search in all products 
    public ArrayList<Product> searchProducts(String text){

        ArrayList<Product> foundList = new ArrayList<>();

        for(Product test : products){

            if(test.getName().toLowerCase().contains(text.toLowerCase())){
                foundList.add(test);
            }

        }

        return foundList;
    }


    //setters 
    public void setIsLogged(boolean isLogged){this.isLogged=isLogged;}//to check for button and text change 
   
    public void setUser(String firstName, String LastName, String email, String password){
        user.setFirstName(firstName);
        user.setLastName(LastName);
        user.setEmail(email);
        user.setPassword(password);

    }

    //getters

    public boolean getIsLogged(){return isLogged;}
    public User getUser(){return user;}
    //shopWindow -> homeWindow -> mainWindow -> catgoryPanel (search that category id with all products and add it to filtered)
    public ArrayList<Product> getAllProducts(){return products;}//used in filtering items with its category id's
    public ArrayList<Category> getAllCategories(){return categories;}//used in adding category in admin

    public HomeWindow getHomeWindow(){return homeWindow;} //used in search as showing categories from homeWindow


    public void deleteAccount(User user) {

        if (user == null) return;
    

        //My addition 
       String deleteemail = user.getEmail();
       String deletepassword = user.getPassword();
      int response =  ApiService.deleteUser(deleteemail, deletepassword);
    
       if(response == 404)
         {
           CustomDialog.showMessage(this, "User not found");
         }
         else
         {
            CustomDialog.showMessage(this, "Account deleted successfully");
         }
         //
       
         
        UsersDataBase.removeUser(user);
        isLogged = false;
    
        user = new User("Guest", "", "", "");
        
        showHomeWindow();
    }


    public void refreshUI(){
        homeWindow.refreshUI();
    }


    public void showDelete(boolean bool){
        homeWindow.showDelete(bool);
    }

}
