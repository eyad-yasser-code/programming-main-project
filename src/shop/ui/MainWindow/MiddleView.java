
// main package
package shop.ui.MainWindow;





// main imports 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import shop.ui.Helper.MyGradient;
import shop.ui.HomeWindow.CategoryPanel;
import shop.ui.HomeWindow.ItemPanel;
import shop.ui.LogicHelper.Product;

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

       
        itemsHolder = new ItemsHolder(0,0,0,600,degrees,colors,30);
        categoriesHolder = new CategoriesHolder(0,0,0,600,degrees,colors,30);
      
      
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

    public void addItem(Product product){
        
        ItemPanel itemPanel = new ItemPanel(product,this);
        itemsHolder.add(itemPanel);
    }

    public void addCategory(String name, String imageName){
        CategoryPanel categoryPanel = new CategoryPanel(name, imageName, mainWindow);
        categoriesHolder.add(categoryPanel);
       
   }



   //removing main
   public void removeItem(Product product){
    
    Component[] components= itemsHolder.getComponents();

    for(Component comp : components){

        if(comp instanceof ItemPanel){

            ItemPanel itemPanel = (ItemPanel)  comp;
            if(itemPanel.getProduct().equals(product)){
                itemsHolder.remove(itemPanel);
                break;

            }
            

        }

    }

itemsHolder.revalidate();
itemsHolder.repaint();



   }



  //adding reverse 
  public void addCart(Product product){
    mainWindow.addCart(product);
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
