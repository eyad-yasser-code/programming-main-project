//main package
package shop.ui.Helper;

//my packages imports


// main imports
import javax.swing.*;
import java.awt.*;




public class ImageLabel extends JLabel{

    private Image image;

    public ImageLabel(String dir,String imagName){
        ImageIcon icon = new ImageIcon(getClass().getResource(dir + imagName)); //dir -> ex: /images/
        this.image= icon.getImage();

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;



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

        //smother scalling
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  RenderingHints.VALUE_INTERPOLATION_BILINEAR);


        g2D.drawImage(image,xPos,yPos,newWidth,newHeight,this);

    }

    



}
