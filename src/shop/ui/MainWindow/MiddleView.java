
// main package
package shop.ui.MainWindow;





// main imports 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import shop.ui.HomeWindow.CategoryPanel;
import shop.ui.HomeWindow.ItemPanel;

import java.awt.*;



public class MiddleView extends JPanel{

    private ItemsHolder itemsHolder;
    private CategoriesHolder categoriesHolder;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private MainWindow mainWindow;






    public MiddleView(MainWindow mainWindow){

        this.setLayout(new BorderLayout());
    
        this.mainWindow=mainWindow;        


        itemsHolder = new ItemsHolder();
        categoriesHolder = new CategoriesHolder();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);




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





class ItemsHolder extends JPanel{

    
    
    
     @Override
    protected void paintComponent(Graphics graphics) {
       
        Color colors[]={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        float degree[]={0.0f, 0.7f, 1.0f};

        super.paintComponent(graphics); //remove color of panel
        Graphics2D graphics2d = (Graphics2D) graphics;
        LinearGradientPaint linerG = new LinearGradientPaint(0,0, 0,getHeight(),degree,colors);
       
        graphics2d.setPaint(linerG);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public ItemsHolder(){
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,105,100,105));
     
    }

}


class CategoriesHolder extends JPanel{


    @Override
    protected void paintComponent(Graphics graphics) {
       
        Color colors[]={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        float degree[]={0.0f, 0.7f, 1.0f};

        super.paintComponent(graphics); //remove color of panel
        Graphics2D graphics2d = (Graphics2D) graphics;
        LinearGradientPaint linerG = new LinearGradientPaint(0,0, 0,getHeight(),degree,colors);
       
        graphics2d.setPaint(linerG);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public CategoriesHolder(){
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,105,100,105));
     
    }


}
