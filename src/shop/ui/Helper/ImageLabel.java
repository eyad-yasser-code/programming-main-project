//main package
package shop.ui.Helper;

//my packages imports


// main imports
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;




public class ImageLabel extends JLabel{

    private Image image;

    public ImageLabel(String dir,String imagName){
       
        ImageIcon icon = new ImageIcon(getClass().getResource(dir + imagName)); //dir -> ex: /images/
        this.image= icon.getImage();
        this.setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        
        
        
        //smother scalling
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      

        Shape clip = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),30,30);
        Shape oldClip = g2D.getClip();

        g2D.setClip(clip);
        g2D.setColor(Color.WHITE);
        g2D.fillRoundRect(0,0, getWidth(),getHeight(), 30, 30);
       
       
        
       
  

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
       
       
       
        g2D.setClip(oldClip);
       
      

       // g2D.drawImage(image,xPos,yPos,newWidth,newHeight,this);

    }

    



}
