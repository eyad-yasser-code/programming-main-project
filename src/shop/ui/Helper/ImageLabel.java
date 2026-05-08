//main package
package shop.ui.Helper;

//my packages imports


// main imports
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

import javax.swing.*;




public class ImageLabel extends JLabel{

    private Image image;

    public ImageLabel(File file) {

        if (file != null && file.exists()) {
            this.image = new ImageIcon(file.getAbsolutePath()).getImage();
        }

        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g.create();
        
        
        
        //smother scalling
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      

        Shape clip = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),30,30);
       // Shape oldClip = g2D.getClip();

        g2D.setClip(clip);
        g2D.setColor(Color.WHITE);
        g2D.fillRoundRect(0,0, getWidth(),getHeight(), 30, 30);
       
       
        
       
  
        if (image != null) {

        int imagWidth = image.getWidth(this);
        int imagHeight = image.getHeight(this);

        int panelWidth = getWidth();
        int panelHeight = getHeight();



        //I want:  imageSize * scale = panelSize  
        double scaleX = (double)panelWidth / imagWidth; //how much image width change when changing panel width
        double scaleY = (double)panelHeight / imagHeight;

        double scale = Math.min(scaleX,scaleY); // get smaller one, make sure the image fit in both width and hight to not overflow

        int newWidth = (int)(imagWidth*scale);
        int newHeight = (int)(imagHeight*scale);

        int xPos = (panelWidth - newWidth)/2;
        int yPos = (panelHeight - newHeight)/2;


        g2D.drawImage(image, xPos, yPos, newWidth, newHeight, this);
       
       
        }
        //g2D.setClip(oldClip);
       
        g2D.dispose();

       // g2D.drawImage(image,xPos,yPos,newWidth,newHeight,this);

    }

    
    public void setImage(File file){

        
        if (file != null && file.exists()) {
            this.image = new ImageIcon(file.getAbsolutePath()).getImage();
        }

        repaint();
    }


}
