//main package 
package shop.ui.ShopWindow;

//my imports 

import shop.ui.CartWindow.CartWindow;
import shop.ui.CartWindow.CheckoutWindow;
import shop.ui.Data.User;
import shop.ui.HomeWindow.HomeWindow;

import shop.ui.LogicHelper.*;


import shop.ui.loginWindow.LoginWrapperWindow;

//main imports 
import javax.swing.*;



import java.awt.*;
import java.util.ArrayList;


public class ShopWindow extends JPanel{

   
   
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private CartWindow cartWindow;
    private HomeWindow homeWindow;
    private LoginWrapperWindow loginWrapper;
    private CheckoutWindow checkoutWindow;


    private ArrayList<Product> products;
    private ArrayList<Category> categories;
    

    private boolean isLogged = false;
    private User user;
    
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
        this.cartWindow = new CartWindow(this);
        this.checkoutWindow = new CheckoutWindow(this,cartWindow);
       

        this.user= new User("","","","");


       
       
        addItem(1,"laptop","laptop.PNG","good laptop\n best laptop ever, you must but this laptop or you will regret it all you life.\nTHAT's AN ORDERRRRR!!!;",20000);
        addItem(2,"microphone","microphone.PNG","good mic",800);
        addItem(3,"mouse","mouse.PNG","good mouse",500);
        addItem(4,"keyboard","keyboard.PNG","good keyboard",1000);

        addCategory(11,"Electronics","laptop.PNG");
        addCategory(12,"Accessories","keyboard.PNG");


       // removeItem(1);
        //removeCategory(11);

      
       
       
       
        cardPanel.add(homeWindow,"homeWindow");
        cardPanel.add(cartWindow, "cartWindow");
        cardPanel.add(loginWrapper, "loginWrapper");
        cardPanel.add(checkoutWindow, "checkoutWindow");


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


    //add functions

    
    public void addItem(int id, String name,String imageName,String description,double price){
       
       
        Product product = new Product(id,name,imageName,description,price);
        products.add(product);

        homeWindow.addItem(product);

    }

    public void addCategory(int id, String name, String imagename){

       
       Category category = new Category(id, name, imagename);
       categories.add(category);
       
        homeWindow.addCategory(category);

    }

    public void addToCart(Product product){
   
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
        products.remove(removable);
        homeWindow.removeItem(removable);
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
            categories.remove(removable);
            homeWindow.removeCategory(removable);
        }

    }

    public void removeFromCart(int id){
   
      cartWindow.removeFromCart(id);

    }

   



    //setters 

    public void setIsLogged(boolean isLogged){this.isLogged=isLogged;}
   
    public void setUser(String firstName, String LastName, String email, String password){
        user.setFirstName(firstName);
        user.setLastName(LastName);
        user.setEmail(email);
        user.setPassword(password);

    }

    //getters

    public boolean getIsLogged(){return isLogged;}
    public User getUser(){return user;}

}



