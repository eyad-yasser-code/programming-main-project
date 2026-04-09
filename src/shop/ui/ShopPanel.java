package shop.ui;

import javax.swing.*;
import java.awt.*;



class TopPanel extends JPanel{
    

    JButton list = new JButton();
    

    public TopPanel(SidePanel sidePanel){
       
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(0,40));
        this.setBackground(Color.decode("#71625d"));

        
        list.addActionListener(e -> {
            System.out.println("list pressed");
            sidePanel.setVisible(!sidePanel.isVisible());
            sidePanel.getParent().revalidate();
            sidePanel.getParent().repaint();


        });
        list.setPreferredSize(new Dimension(40,30));
        list.setText("☰");
        list.setFocusPainted(false);
     list.setBorderPainted(false);
        list.setBackground(Color.decode("#71625d"));
        list.setForeground(Color.WHITE);
        this.add(list);

    }


}

class SidePanel extends JPanel{

    public SidePanel(){

        this.setPreferredSize(new Dimension(300,0));
        this.setBackground(Color.decode("#d9c7b6"));
        this.setVisible(false);

    }
}

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
          
         SidePanel sidePanel = new SidePanel();
         TopPanel topPanel = new TopPanel(sidePanel);
         //BottomPanel bottomPanel = new BottomPanel();
       

       // mainPanel.add(itemsPanel, BorderLayout.CENTER);
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(topPanel,BorderLayout.NORTH);
        //mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }
}
