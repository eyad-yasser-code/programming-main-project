package shop.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.geom.*;


class ImageLabel extends JLabel{

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


public class ItemPanel extends JPanel{
   
  
   
   float fractions[]={0.0f,0.4f,1.0f};
   Color colors[]={Color.decode("#1d1f1d"),Color.decode("#1d1f1d"), Color.decode("#373737")};
   
   @Override
   protected void paintComponent(Graphics g){
        
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D)g;
    LinearGradientPaint linerG = new LinearGradientPaint(0,0,getWidth(),getHeight(), fractions,colors);

    g2D.setPaint(linerG);
    g2D.fillRoundRect(0 , 0 , getWidth(),getHeight(),30,30);
    
    }



    public ItemPanel(String name,String imageName, String price){

       
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200,350));
        this.setOpaque(false);
        
    
        //image section

        JPanel imagPanel = new JPanel(new BorderLayout()){
            
            @Override 
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D)g;

                g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                Shape clip = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),30,30);
                g2D.setClip(clip);

                g2D.setColor(getBackground());
                g2D.fillRoundRect(0,0, getWidth(),getHeight(), 30, 30);

               
            }

        };
        imagPanel.setOpaque(false);
        imagPanel.setPreferredSize(new Dimension(0,300));
        imagPanel.setBackground(Color.WHITE);
  
  
        ImageLabel imagLabel = new ImageLabel("/images/",imageName);
        imagLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    

        imagPanel.add(imagLabel, BorderLayout.CENTER);

     
        
        //text section
        
        
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(new EmptyBorder(5,20,0,0));



        JPanel textPanel = new JPanel();
      
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        
        

        
      
       

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial",Font.PLAIN,12));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
       

      
      
      
        JLabel priceLabel = new JLabel( price + "L.E.");
        priceLabel.setFont(new Font("Arial",Font.BOLD,14));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

       



        textPanel.add(nameLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0 , 10)));
        textPanel.add(priceLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0 , 10)));

        wrapper.add(textPanel, BorderLayout.WEST);
   
        //buttons section


        JButton cartAdd = new JButton("Add to cart");
        cartAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartAdd.setFocusPainted(false);
        cartAdd.setBorderPainted(false); 
        cartAdd.setOpaque(false);
        cartAdd.setBackground(Color.BLACK);
        cartAdd.setForeground(Color.WHITE);
        cartAdd.addActionListener(e -> {
            System.out.println(name + " added to cart");
        });




       
        this.add(imagPanel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(wrapper);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(cartAdd);
       
      

    

    }

}
