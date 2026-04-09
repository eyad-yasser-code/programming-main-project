package shop.ui;

import javax.swing.*;
import java.awt.*;




public class ShopPanel extends JPanel {

    public ShopPanel(){
       
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(1,1));
        mainPanel.setBackground(Color.decode("#E5E1DA"));


        ItemWindow itemWindow = new ItemWindow();
        mainPanel.add(itemWindow, BorderLayout.CENTER);
        
      
       
        
            itemWindow.add("laptop","laptop.PNG","15,000");
            itemWindow.add("keyboard","keyboard.PNG","1000");
            itemWindow.add("mouse","mouse.PNG","500");
            itemWindow.add("microphone","microphone.PNG","1500");
         
         for(int i =0 ; i<10 ; i++){
            itemWindow.add("microphone","microphone.PNG","1500");
         }
          
        
           


        
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(200,0));
        sidePanel.setBackground(Color.decode("#B4D4FF"));


       
       
       
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(0,30));
        topPanel.setBackground(Color.decode("#176B87"));

        
        
        
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(0,200));
        bottomPanel.setBackground(Color.decode("#213C51"));

       // mainPanel.add(itemsPanel, BorderLayout.CENTER);
        mainPanel.add(sidePanel, BorderLayout.EAST);
        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }
}
