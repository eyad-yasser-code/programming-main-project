package shop.ui.HomeWindow;

import shop.ui.MainWindow.*;
import shop.ui.MainWrapper.MainWrapper;
import shop.ui.ShopWindow.ShopWindow;
import shop.ui.LogicHelper.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeWindow extends JPanel {

    private MainWindow  mainWindow;
    private MainWrapper mainWrapper;
    private ShopWindow  shopWindow;

    public HomeWindow(ShopWindow shopWindow) {

        this.shopWindow = shopWindow;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#141414")); 

       
       //decleration of mainWindow and MainWrapper
       
       
        mainWindow  = new MainWindow(this);
        mainWindow.setOpaque(false);

        mainWrapper = new MainWrapper(mainWindow, shopWindow);
        mainWrapper.setOpaque(false);





        //layeredPane for stacking mainWrapper on mainWindow
        JLayeredPane layeredPane = new JLayeredPane() {
            @Override
            public void doLayout() {
               
               
               // setBounds as layeredPane sets layout to null
                int w = getWidth(), h = getHeight();
                mainWindow.setBounds(0, 0, w, h);
                mainWrapper.setBounds(0, 0, w, h);
            }
        };

        //second parameter is the placement hint 
        layeredPane.add(mainWindow,  JLayeredPane.DEFAULT_LAYER);//this is the base
        layeredPane.add(mainWrapper, JLayeredPane.PALETTE_LAYER);//this sets on top
        layeredPane.setOpaque(false);

      
        this.add(layeredPane, BorderLayout.CENTER);
    
    
    }





    //Helpers
    //================

    //mainWrapper -> homeWindow 
    //these help with: when changing windows hide sidepanel, reset search, change greeting 
   
    public void panelVisible(boolean bool) { mainWrapper.panelVisible(bool); } //my click remove side panel
   
    public void resetSearch(){ mainWrapper.resetSearch(); } //exiting homeWindow will remove what is typed 
    
    public void greetingLabel(){ mainWrapper.updateGreeting(); }//change from login to greeting

   
    public void refreshUI(){mainWrapper.refreshUI();}
   
   
    //Adding (main)
    //==========================

    // going from (shopWindow) -> homeWindow -> mainWindow ->itemHOlder/categoryHolder(UI) the logic is added or removed in shopWindow array

    public void addItem(Product product){ mainWindow.addItem(product); } // adding item to UI (from top,shop to bottom,itemHolder)
    public void addCategory(Category category) { mainWindow.addCategory(category); } // adding category to UI (from top,shop to bottom,categoryHolder)

   
   
   
    //Adding (reverse)
    //============================

    // going from itemHolder -> mainWindow -> homeWindow -> (shopWindow) -> cartWindow  

    public void addToCart(Product product) { shopWindow.addToCart(product); }




    //Removing
    //========================

    // going from (shopWindow) -> homeWindow -> mainWindow ->itemHOlder/categoryHolder(UI) the logic is added or removed in shopWindow array
    public void removeItem(Product product){ mainWindow.removeItem(product); }
    public void removeCategory(Category removable){ mainWindow.removeCategory(removable); }






    //Showing
    //===================== 


   
    public void showAllProducts() {
       
        mainWindow.showItemsHolder();
        mainWindow.showSearchedProducts(getAllProducts());
    }

    public void showCategories() {
        mainWindow.showCategoriesHolder();
        mainWindow.defaultScroll();
    }


    //form mainWrapper entered text -> shopWindow search products gives filtered -> homeWindow,here -> mainWindow - > itemHolder 
    public void showSearchedProducts(ArrayList<Product> searchedProducts) {
        mainWindow.showSearchedProducts(searchedProducts);
    }




    //getters
    //============
    public ArrayList<Product> getAllProducts() { return shopWindow.getAllProducts(); }






    public void refreshUI1(){
        mainWrapper.refreshUI();

    }
}
