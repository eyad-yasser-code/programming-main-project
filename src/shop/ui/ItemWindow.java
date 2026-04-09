package shop.ui;

import javax.swing.*;
import java.awt.*;

class ItemPanelHolder extends JPanel{


    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#a56ed9"), 0, getHeight(), Color.decode("#80a4c9"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    public ItemPanelHolder(){
       
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
       // this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        //this.setPreferredSize(new Dimension(800 ,0));
       // this.setBackground(Color.decode("#fffdf1"));
        //this.setBorder(BorderFactory.createEmptyBorder(50, 70,150,70));
        this.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

    }


}

class BottomPanel extends JPanel{
    
    public BottomPanel(){
        this.setPreferredSize(new Dimension(0,400));
        this.setBackground(Color.decode("#23221f"));
    }

}


class MiddleView extends JPanel{

    private ItemPanelHolder itemHolder;
    private BottomPanel bottomPanel;

    public MiddleView(){
        
        this.setLayout(new BorderLayout());
        
        itemHolder = new ItemPanelHolder();
        bottomPanel = new BottomPanel();
        
        this.add(itemHolder, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);


    }

    public void add(String name, String imagName, String price){
        itemHolder.add(new ItemPanel(name,imagName,price));
        itemHolder.revalidate();
        itemHolder.repaint();
    }

}

class ScrollPane extends JScrollPane{

    private MiddleView middleView;
    
    public ScrollPane(){
        this(new MiddleView());
    }

    private ScrollPane(MiddleView panel){
        super(panel);
        this.middleView = panel;
       
        this.setWheelScrollingEnabled(true);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public void add(String name, String imagName, String price){
        middleView.add(name,imagName,price);
        
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
