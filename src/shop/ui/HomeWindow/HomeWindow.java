

//main package
package shop.ui.HomeWindow;




//my packages imports
import shop.ui.MainWindow.*;
import shop.ui.MainWrapper.MainWrapper;
import shop.ui.ShopWindow.ShopWindow;
import shop.ui.LogicHelper.*;
// main imports
import javax.swing.*;
import java.awt.*;







public class HomeWindow extends JPanel {


    
    private MainWindow mainWindow;
    private MainWrapper mainWrapper;

    private ShopWindow shopWindow;


    public HomeWindow(ShopWindow shopWindow){
        

        this.shopWindow = shopWindow;
       
        this.setLayout(new BorderLayout());   
        this.setBackground(Color.decode("#1b1b1b"));      
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));

       


        mainWindow = new MainWindow(this);
        mainWindow.setOpaque(false);
        mainWrapper = new MainWrapper(mainWindow, shopWindow);
        mainWrapper.setOpaque(false);
      


      


        JLayeredPane layeredPane = new JLayeredPane(){
            @Override
            public void doLayout(){
                int width = this.getWidth();
                int height = this.getHeight();

                mainWindow.setBounds(0,0, width , height);
                mainWrapper.setBounds(0,0,width,height);
            }
        };
        
        
        layeredPane.add(mainWindow , JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(mainWrapper, JLayeredPane.PALETTE_LAYER);
        layeredPane.setOpaque(false);

        
      
          this.add(layeredPane, BorderLayout.CENTER);
           
      

    }

    //helping methods

    
   
    public void panelVisible(boolean bool){
       mainWrapper.panelVisible(bool);
    }
   
    public void resetSearch(){
        mainWrapper.resetSearch();
    }

    public void greetingLabel(){
        mainWrapper.greetingLabel();
    }


    //main adding 

    public void addItem(Product product){
        mainWindow.addItem(product);
    }

    public void addCategory(Category category){
       mainWindow.addCategory(category);
    }

    
    //reverse adding 

    public void addToCart(Product product){
        shopWindow.addToCart(product);
    }

    

    //main removing

    public void removeItem(Product product){
        mainWindow.removeItem(product);
    }

    public void removeCategory(Category removable){
            mainWindow.removeCategory(removable);
        }


}
