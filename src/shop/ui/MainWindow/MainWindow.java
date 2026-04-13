//main package
package shop.ui.MainWindow;


import shop.ui.Helper.MyGradient;
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
        this.setOpaque(false);

        basePanel = new JPanel(new BorderLayout());
        basePanel.setOpaque(false);

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
        
        this.setPreferredSize(new Dimension(0,40));
        this.setBackground(Color.decode("#1a1b1b"));
        this.setOpaque(false);

    }
}

 

class BottomBasePanel extends JPanel{



    private MiddleView middleView;   
    private JScrollPane scrollPane;
       
    
    private float degrees[]={0.0f,0.1f,0.2f,1.0f};
    private Color colors[]={Color.decode("#159069"),Color.decode("#159069"),Color.decode("#23221f"),Color.decode("#23221f")};
    


    public BottomBasePanel(MainWindow mainWindow){
   
          
           this.setLayout(new BorderLayout());
           this.setOpaque(false); 
          
          
           middleView = new MiddleView(mainWindow);
           middleView.showCategoriesHolder();
           middleView.setAlignmentX(Component.CENTER_ALIGNMENT);
           middleView.setOpaque(false); 
           middleView.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));

       
          
           
           BottomPanel bottomPanel = new BottomPanel(0,0,0,getHeight(),degrees,colors,30);
               
              
   
              
   
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
              wrapper.setOpaque(false);
              
   
   
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
   
   class BottomPanel extends MyGradient{
    public BottomPanel(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        super(startX, startY , endX, endY, degrees, colors, arc);

        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(0,400));
        this.setBorder(BorderFactory.createLineBorder( Color.decode("#111111") ,10));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setOpaque(false);


    }
   }