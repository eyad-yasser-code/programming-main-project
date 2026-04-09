package shop.ui;

import javax.swing.*;
import java.awt.*;

class ItemPanelHolder extends JPanel{

    public ItemPanelHolder(){
       
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        //this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
       // this.setPreferredSize(new Dimension(800,1200));
        this.setBackground(Color.decode("#EEF5FF"));
        this.setBorder(BorderFactory.createEmptyBorder(50, 70,150,70));


    }


}
class ScrollPane extends JScrollPane{

    private ItemPanelHolder itemPanelHolder;
    
    public ScrollPane(){
        this(new ItemPanelHolder());
    }

    private ScrollPane(ItemPanelHolder panel){
        super(panel);
        this.itemPanelHolder = panel;
       
        this.setWheelScrollingEnabled(true);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public void add(String name, String imagName, String price){
        itemPanelHolder.add(new ItemPanel(name,imagName,price));
        itemPanelHolder.revalidate();
        itemPanelHolder.repaint();
    }
}



public class ItemWindow extends JPanel{

private ScrollPane scrollPane;

    public ItemWindow(){
       this.setLayout(new BorderLayout());
       
        
       scrollPane=new ScrollPane(); 
       this.add(scrollPane,BorderLayout.CENTER);

    }

    public void add(String name, String imagName, String price){
        scrollPane.add(name,imagName,price);
    }
    
}
