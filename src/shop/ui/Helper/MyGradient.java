


package shop.ui.Helper;

import javax.swing.*;
import java.awt.*;


public class MyGradient extends JPanel{


    private Color[] colors;
    private float[] degrees;
    int startX, startY, endX, endY , arc;
  

    public MyGradient(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
      
       
       this.startX=startX;
       this.startY=startY;
       this.endX=endX;
       this.endY=endY;
       this.arc=arc;
       
       this.degrees=degrees;
       this.colors=colors;
       
   
        this.setOpaque(false);

    }


    
    @Override
    protected void paintComponent(Graphics graphics) {
 
        
        super.paintComponent(graphics); 
        Graphics2D graphics2d = (Graphics2D) graphics;
       
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
       
       
        LinearGradientPaint linerG = new LinearGradientPaint(startX,startY, endX,getHeight(), degrees, colors);
        


        graphics2d.setPaint(linerG);
        graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(),arc,arc);

    }




}