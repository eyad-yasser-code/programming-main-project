package shop.ui;

import javax.swing.*;
import java.awt.*;



public class ItemPanel extends JPanel{
   
   
    



    public ItemPanel(String name,String imageName, String price){

       
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        
        this.setPreferredSize(new Dimension(250,280));
       
        //this.setBackground(Color.BLACK);
        //this.setBorder(BorderFactory.createLineBorder(Color.decode("#d8b598"),2));
    
        
        


        int imagWidth = 200;
        int imagHeight = 200;

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/"+imageName));
        Image image = icon.getImage().getScaledInstance(imagWidth, imagHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        


        //labels
        JLabel nameLabel = new JLabel(name);
        //nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        JLabel priceLabel = new JLabel( price + "L.E.");
        // priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        

        //buttons
        JButton cartAdd = new JButton("Add to cart");
        cartAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartAdd.setFocusPainted(false);
        cartAdd.setBorderPainted(false); 
        cartAdd.setOpaque(false);
        //cartAdd.setContentAreaFilled(false);
        cartAdd.setBackground(Color.BLACK);
        cartAdd.setForeground(Color.WHITE);
        cartAdd.addActionListener(e -> {
            System.out.println(name + " added to cart");
        });


        this.add(imageLabel);
        this.add(Box.createRigidArea(new Dimension(10,0)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(10,0)));
        this.add(priceLabel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(cartAdd, BorderLayout.SOUTH);
       
      

    

    }

}
