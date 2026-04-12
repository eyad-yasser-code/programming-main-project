//main package 
package shop.ui.CartWindow;

import java.awt.*;
import javax.swing.*;

public class CartWindow extends JPanel{
    




    public CartWindow(){

        this.setBackground(Color.BLACK);



        



    }

    
    @Override
   protected void paintComponent(Graphics graphics) {
      
       Color colors[]={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
       float degree[]={0.0f, 0.7f, 1.0f};

       super.paintComponent(graphics); //remove color of panel
       Graphics2D graphics2d = (Graphics2D) graphics;
       LinearGradientPaint linerG = new LinearGradientPaint(0,0, 0,getHeight(),degree,colors);
      
       graphics2d.setPaint(linerG);
       graphics2d.fillRect(0, 0, getWidth(), getHeight());
   }

}