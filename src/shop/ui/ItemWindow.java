package shop.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

class ItemPanelHolder extends JPanel{

    // @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); //remove color of panel
        Graphics2D graphics2d = (Graphics2D) graphics;
        GradientPaint gradientPaint = new GradientPaint(0, getHeight()*0.6f, Color.decode("#424242"), 0, getHeight(), Color.decode("#1c1c1c"));
        graphics2d.setPaint(gradientPaint);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public ItemPanelHolder(){
       
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,100,100,100));
     
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
        
        this.add(itemHolder, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);


    }

    public void addItem(String name, String imagName, String price){
        itemHolder.add(new ItemPanel(name,imagName,price));
        itemHolder.revalidate();
        itemHolder.repaint();
    }

}

class ScrollPane extends JScrollPane{

    private MiddleView middleView;
    
    //must create an object of middleView first before putting in ScrollPane
    public ScrollPane(){
        this(new MiddleView());
    }

    private ScrollPane(MiddleView panel){
        super(panel);
        this.middleView = panel;
       
        this.setWheelScrollingEnabled(true);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setBorder(null);
    }
    
    public void addItem(String name, String imagName, String price){
        middleView.addItem(name,imagName,price);
        
    }
}



public class ItemWindow extends JPanel{

private ScrollPane scrollPane;

    public ItemWindow(){
       this.setLayout(new BorderLayout());
       
        
       scrollPane=new ScrollPane(); 
       this.add(scrollPane,BorderLayout.CENTER);

    }

    public void addItem(String name, String imagName, String price){
        scrollPane.addItem(name,imagName,price);
    }
    
}
