//main package
package shop.ui.MainWindow;


//my imports 
import shop.ui.Helper.PressableButton;
//import shop.ui.ShopWindow.*;

//main imports 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;








public class MainWindow extends JPanel{

private BottomBasePanel bottomBasePanel;
private TopBasePanel topBasePanel;
private JPanel basePanel;



public MainWindow(){

this.setLayout(new BorderLayout());

basePanel = new JPanel(new BorderLayout());
topBasePanel = new TopBasePanel();
bottomBasePanel = new BottomBasePanel(this);



basePanel.add(topBasePanel, BorderLayout.NORTH);
basePanel.add(bottomBasePanel, BorderLayout.CENTER);




this.add(basePanel, BorderLayout.CENTER);

}



//adding functions main

public  void addItem( String name, String imagName, String price) {
    bottomBasePanel.addItem(name,imagName,price);
}

public void addCategory(String name, String imagName){
    bottomBasePanel.addCategory(name,imagName);


}

//showing functions

public void showCategoriesHolder(){
    bottomBasePanel.showCatigoriesHolder();
}
public void showItemsHolder(){
    bottomBasePanel.showItemsHolder();
}

//scroll

public void defaultScroll(){
    bottomBasePanel.defaultScroll();
}





}

class TopBasePanel extends JPanel{
    public TopBasePanel(){
        
        this.setPreferredSize(new Dimension(0,30));
        this.setBackground(Color.decode("#1a1b1b"));


    }
}

 

class BottomBasePanel extends JPanel{



    private MiddleView middleView;   
    private JScrollPane scrollPane;
       
    
    public BottomBasePanel(MainWindow mainWindow){
   
          
           this.setLayout(new BorderLayout());
   
          
          
           middleView = new MiddleView(mainWindow);
           middleView.showCategoriesHolder();
           middleView.setAlignmentX(Component.CENTER_ALIGNMENT);
   
           
           
           
           JPanel bottomPanel = new JPanel(){
               
               float values[]={0.0f,0.1f,0.2f,1.0f};
               Color colors[]={Color.decode("#159069"),Color.decode("#159069"),Color.decode("#23221f"),Color.decode("#23221f")};
   
               @Override
               protected void paintComponent(Graphics g){
                   super.paintComponent(g);
                   Graphics2D g2D = (Graphics2D)g;
   
                   LinearGradientPaint linerG = new LinearGradientPaint(0,0 , 0,  getHeight() ,values ,colors);
   
                   g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
   
                   g2D.setPaint(linerG);
                   g2D.fillRect(0, 0, getWidth(), getHeight());
                   
               }
   
   
           };
   
               
               bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
               bottomPanel.setPreferredSize(new Dimension(0,400));
               bottomPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
               bottomPanel.setOpaque(false);
   
               //information panels
   
               JPanel inforamtionWrapPanel = new JPanel();
               inforamtionWrapPanel.setOpaque(false);
               inforamtionWrapPanel.setBorder(new EmptyBorder(50,40,50,40));
           
   
               //buttons 
               PressableButton backToTop = new PressableButton("#159069","#56b798",0);
               backToTop.setText("Back To Top");
               backToTop.setPreferredSize(new Dimension(Integer.MAX_VALUE,40));
               backToTop.setMaximumSize(new Dimension(Integer.MAX_VALUE,100));
               backToTop.setAlignmentX(Component.CENTER_ALIGNMENT);
   
               backToTop.setFont(new Font("Arial",Font.BOLD,14));
   
   
   
               bottomPanel.add(backToTop);
               bottomPanel.add(inforamtionWrapPanel);
   
   
              
             // wrapper for bottom and other panel
              JPanel wrapper = new JPanel();
              wrapper.setLayout(new BoxLayout (wrapper,BoxLayout.Y_AXIS));
              wrapper.add(middleView);
              wrapper.add(bottomPanel);
              
   
   
                scrollPane = new JScrollPane(wrapper);
                scrollPane.setWheelScrollingEnabled(true);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setBorder(null);
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
              
   
   
               backToTop.addActionListener(e -> {
                  
                   defaultScroll();
               
               });
   
   
   
               this.add(scrollPane, BorderLayout.CENTER);
               
       }
   
       //adding
       public void addItem(String name, String imagName, String price){
         middleView.addItem(name, imagName, price);
         
       }
   
   
       public void addCategory(String name, String imagName){
            middleView.addCategory(name, imagName);
   
       }
   

       //showing 
       public void showCatigoriesHolder(){
        middleView.showCategoriesHolder();
       }
       public void showItemsHolder(){
        middleView.showItemsHolder();
       }

       //scrollpane

       public void defaultScroll(){
        this.scrollPane.getVerticalScrollBar().setValue(0);
       }

   }
   
   