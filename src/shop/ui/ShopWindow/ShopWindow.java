//main package 
package shop.ui.ShopWindow;

//my imports 

import shop.ui.CartWindow.CartWindow;
import shop.ui.HomeWindow.HomeWindow;


//main imports 
import javax.swing.*;



import java.awt.*;


public class ShopWindow extends JPanel{

    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private CartWindow cartWindow;
    private HomeWindow homeWindow;

    public ShopWindow(){

        this.setLayout(new BorderLayout());

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);
        
        this.homeWindow = new HomeWindow(this);
        this.cartWindow = new CartWindow(this,homeWindow);

      
        cardPanel.add(homeWindow,"homeWindow");
        cardPanel.add(cartWindow, "cartWindow");

        this.add(cardPanel, BorderLayout.CENTER);
        showCartWindow();

    }

    //show functions 

    public void showCartWindow(){
        cardLayout.show(cardPanel,"cartWindow");
        revalidate();
        repaint();
    }

    public void showHomeWindow(){
        cardLayout.show(cardPanel, "homeWindow");
        revalidate();
        repaint();
    }


}