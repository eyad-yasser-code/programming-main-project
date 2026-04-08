package shop.ui;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {

    public ShopPanel(){
       
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(1,1));
        mainPanel.setBackground(Color.decode("#E5E1DA"));

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(0, 3, 10, 10));
        itemsPanel.setBackground(Color.decode("#EEF5FF"));
    
            itemsPanel.add(new ItemPanel("laptop","laptop.PNG","15,000"));
            itemsPanel.add(new ItemPanel("keyboard","keyboard.PNG","1000"));
            itemsPanel.add(new ItemPanel("mouse","mouse.PNG","500"));
            itemsPanel.add(new ItemPanel("microphone","microphone.PNG","1500"));

        
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(200,0));
        sidePanel.setBackground(Color.decode("#B4D4FF"));


        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(0,30));
        topPanel.setBackground(Color.decode("#176B87"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(0,200));
        bottomPanel.setBackground(Color.decode("#213C51"));

        mainPanel.add(itemsPanel, BorderLayout.CENTER);
        mainPanel.add(sidePanel, BorderLayout.EAST);
        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }
}
