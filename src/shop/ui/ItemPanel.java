package shop.ui;

import javax.swing.*;
import java.awt.*;



public class ItemPanel extends JPanel{
   
    // private String name;
    // private String imageName;
    // private String price;

    public ItemPanel(String name,String imageName, String price){
    
        // this.name=name;
        // this.imageName=imageName;
        // this.price=price;

        //setting the itemPanel layout
        this.setLayout(new BorderLayout());
        
        this.setPreferredSize(new Dimension(250,280));
       
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    
        


        int imagWidth = 200;
        int imagHeight = 200;

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/"+imageName));
        Image image = icon.getImage().getScaledInstance(imagWidth, imagHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        

        //labels
        JLabel nameLabel = new JLabel(name);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel priceLabel = new JLabel( price + "L.E.");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(nameLabel, BorderLayout.CENTER);
        topPanel.add(imageLabel, BorderLayout.NORTH);


        //buttons
        JButton cartAdd = new JButton("Add to cart");
        cartAdd.addActionListener(e -> {
            System.out.println(name + " added to cart");
        });


        this.add(topPanel, BorderLayout.NORTH);
        this.add(priceLabel, BorderLayout.CENTER);
        this.add(cartAdd, BorderLayout.SOUTH);
    

    }

}
