

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

    public HomeWindow(ShopWindow shopWindow){
        
        this.setLayout(new BorderLayout());   
        

       

        MainWindow mainWindow = new MainWindow();
        MainWrapper mainWrapper = new MainWrapper(mainWindow, shopWindow);
        mainWrapper.setOpaque(false);
      


        

        //adding items test
        mainWindow.addItem("laptop","laptop.PNG","15,000");
        mainWindow.addItem("keyboard","keyboard.PNG","1000");
        mainWindow.addItem("mouse","mouse.PNG","500");
        mainWindow.addItem("microphone","microphone.PNG","1500");
     
        for(int i =0 ; i<0 ; i++){
            mainWindow.addItem("microphone","microphone.PNG","1500");
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

        
      
          this.add(layeredPane, BorderLayout.CENTER);
           
      

    }
}
