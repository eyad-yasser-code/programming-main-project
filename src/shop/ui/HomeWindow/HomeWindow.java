

//main package
package shop.ui.HomeWindow;



//my packages imports
import shop.ui.MainWindow.*;
import shop.ui.MainWrapper.MainWrapper;
import shop.ui.ShopWindow.ShopWindow;

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
      


        

        //adding items test
        mainWindow.addItem("laptop","laptop.PNG","good laptop","15,000");
        mainWindow.addItem("keyboard","keyboard.PNG","good keyboard","1000");
        mainWindow.addItem("mouse","mouse.PNG","good mouse","500");
        mainWindow.addItem("microphone","microphone.PNG","good mic","1500");
     
        for(int i =0 ; i<0 ; i++){
            mainWindow.addItem("microphone","microphone.PNG","good mic","1500");
        }
        mainWindow.addCategory("keyboards","keyboard.PNG");
        



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

    //main adding 

    public void addItem(String name,String imagename,String description,String price){
        mainWindow.addItem(name,imagename,description,price);
    }

    public void addCategory(String name,String imagename){
        mainWindow.addCategory(name, imagename);
    }

    
    //reverse adding 

    public void addCart(String name, String imagename,String description,String price){
        shopWindow.addCart(name,imagename,description,price);
    }



}
