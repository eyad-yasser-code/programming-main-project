//main package 
package shop.ui.ShopWindow;

//my imports 

import shop.ui.CartWindow.CartWindow;
import shop.ui.HomeWindow.HomeWindow;
import shop.ui.LogicHelper.Product;
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
    
    
    //constructor
    
    public ShopWindow(){

        this.setLayout(new BorderLayout());

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);
        


       

        products = new ArrayList<Product>();

        this.loginWrapper = new LoginWrapperWindow(this);
        this.homeWindow = new HomeWindow(this);
        this.cartWindow = new CartWindow(this);
      





      
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

    
    public void addItem(String name,String imagename,String description,String price){
       
        homeWindow.addItem(name,imagename,description,price);

    }

    public void addCategory(String name,String imagename){

        homeWindow.addCategory(name, imagename);

    }

    public void addCart(String name, String imagename,String description,String price){
   
      cartWindow.addItem(name,imagename,description,price);

    }



}



