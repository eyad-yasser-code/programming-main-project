
// main package
package shop.ui.MainWindow;





// main imports 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import shop.ui.Helper.MyGradient;
import shop.ui.HomeWindow.CategoryPanel;
import shop.ui.HomeWindow.ItemPanel;

import java.awt.*;



public class MiddleView extends JPanel{

    private ItemsHolder itemsHolder;
    private CategoriesHolder categoriesHolder;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private MainWindow mainWindow;


    private  float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
    



    public MiddleView(MainWindow mainWindow){

        this.setLayout(new BorderLayout());
    
        this.mainWindow=mainWindow;        
        this.setOpaque(false);

       
        itemsHolder = new ItemsHolder(0,0,0,getHeight(),degrees,colors,30);
        categoriesHolder = new CategoriesHolder(0,0,0,getHeight(),degrees,colors,30);
      
      
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);



        cardPanel.add(itemsHolder,"itemsHolder");
        cardPanel.add(categoriesHolder, "catigoriesHolder");

        
        
        this.add(cardPanel, BorderLayout.CENTER);
        showCategoriesHolder();


    }

    //appearing 

    public  void showItemsHolder(){
        cardLayout.show(cardPanel,"itemsHolder");
        revalidate();
        repaint();
        
    }
    public void showCategoriesHolder(){
       
        cardLayout.show(cardPanel, "catigoriesHolder");
        revalidate();
        repaint();
    }

    //adding 

    public void addItem(String name, String imageName, String price){
         itemsHolder.add(new ItemPanel(name,imageName,price));
    }

    public void addCategory(String name, String imageName){
        categoriesHolder.add(new CategoryPanel(name,imageName,this.mainWindow));
       
   }

  

}





class ItemsHolder extends MyGradient{

    
    //int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc


    public ItemsHolder(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
       
        super(startX, startY , endX, endY, degrees, colors, arc);
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,105,100,105));
        this.setOpaque(false);
    }

}


class CategoriesHolder extends MyGradient{



    public CategoriesHolder(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
       
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,105,100,105));
        this.setOpaque(false);
      
     
    }


}
