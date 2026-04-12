package shop.ui.ShopWindow;

import javax.swing.*;
import java.awt.*;



class TopPanel extends JPanel{
    

    JButton list = new JButton();
    

    public TopPanel(SidePanel sidePanel){
       
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(0,40));
        this.setBackground(Color.decode("#30302f"));

       
       //list button look & function
        list.setPreferredSize(new Dimension(40,30));
        list.setText("list");
        list.setFocusPainted(false);
        list.setBorderPainted(false);
        list.setOpaque(false);
        list.setBackground(Color.BLACK);
        list.setForeground(Color.WHITE);
        list.addActionListener(e -> {
            System.out.println("list pressed");
            // sidePanel.setVisible(!sidePanel.isVisible());
            if(sidePanel.getPreferredSize().width==0){
                sidePanel.setPreferredSize(new Dimension(300,0));

            }
            else sidePanel.setPreferredSize(new Dimension(0 , 0 ));

            sidePanel.revalidate();
            sidePanel.repaint();

        });
        
       
        this.add(list);

    }


}

class SidePanel extends JPanel{

    public SidePanel(){

        this.setPreferredSize(new Dimension(0,0));
        this.setBackground(Color.decode("#4e4e4e"));
        

    }
}

public class ShopPanel extends JPanel {

    public ShopPanel(){
        
        this.setLayout(new BorderLayout());   
        
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0,0));
        mainPanel.setBackground(Color.decode("#ffffff"));


        ItemWindow itemWindow = new ItemWindow();
        
        
      

            //adding items test
            itemWindow.addItem("laptop","laptop.PNG","15,000");
            itemWindow.addItem("keyboard","keyboard.PNG","1000");
            itemWindow.addItem("mouse","mouse.PNG","500");
            itemWindow.addItem("microphone","microphone.PNG","1500");
         
            for(int i =0 ; i<10 ; i++){
                itemWindow.addItem("microphone","microphone.PNG","1500");
            }
          
      
      
      
      
         SidePanel sidePanel = new SidePanel();
        
         TopPanel topPanel = new TopPanel(sidePanel);
        
       

       
        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(itemWindow, BorderLayout.CENTER);

       
        this.add(mainPanel, BorderLayout.CENTER);
    }
}
