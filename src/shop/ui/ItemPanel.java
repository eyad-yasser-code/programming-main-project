package shop.ui;

import javax.swing.*;
import java.awt.*;




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

        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  RenderingHints.VALUE_INTERPOLATION_BILINEAR);

       
        g2D.drawImage(image,0,0,getWidth(),getHeight(),this);

    }

    



}


public class ItemPanel extends JPanel{
   
  
   
   float fractions[]={0.0f,0.4f,1.0f};
   Color colors[]={Color.decode("#1d1f1d"),Color.decode("#1d1f1d"), Color.decode("#373737")};
   @Override
   protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D)graphics;

      // GradientPaint gradientPaint = new GradientPaint(0 , 0 , Color.decode("#8fee8a"), 0 , getHeight(), Color.decode("#504f4c"));
        LinearGradientPaint lGradientPaint = new LinearGradientPaint(0,0,getWidth(),getHeight(), fractions,colors);

        graphics2d.setPaint(lGradientPaint);
        graphics2d.fillRoundRect(0 , 0 , getWidth(),getHeight(),30,40);
    }



    public ItemPanel(String name,String imageName, String price){

       
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200,350));
        this.setOpaque(false);
        
    
        
        int imagWidth = 600;
        int imagHeight = 210;

        ImageLabel imageLabel = new ImageLabel("/images/",imageName);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setPreferredSize(new Dimension(imagWidth,imagHeight));
        imageLabel.setMaximumSize(new Dimension(imagWidth,imagHeight));
        imageLabel.setMinimumSize(new Dimension(imagWidth,imagHeight));



        //labels
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial",Font.PLAIN,12));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        

        JLabel priceLabel = new JLabel( price + "L.E.");
        priceLabel.setFont(new Font("Arial",Font.BOLD,14));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
 
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(nameLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0 , 10)));
        textPanel.add(priceLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0 , 10)));



        //buttons
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




       // this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(imageLabel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(textPanel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(cartAdd);
       
      

    

    }

}
