//main package 
package shop.ui.ShopWindow;

//my imports 

import shop.ui.CartWindow.CartWindow;
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


    private ArrayList<Product> products;
    private ArrayList<Category> categories;
    
    
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

        this.add(cardPanel, BorderLayout.CENTER);
        showHomeWindow();

    }

    //show functions 

    public void showCartWindow(){
        cardLayout.show(cardPanel,"cartWindow");
        cartWindow.defaultCartScroll();
        revalidate();
        repaint();
    }

    public void showHomeWindow(){
        cardLayout.show(cardPanel, "homeWindow");
        homeWindow.panelVisible(false);
        homeWindow.resetSearch();
        revalidate();
        repaint();
    }


    public void showLoginWrapper(){
        cardLayout.show(cardPanel, "loginWrapper");
        loginWrapper.showLoginWindow();
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


}



