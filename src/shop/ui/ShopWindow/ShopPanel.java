

//main package
package shop.ui.ShopWindow;


//my packages imports
import shop.ui.Helper.PressableButton;
import shop.ui.MainWindow.*;


// main imports
import javax.swing.*;
import java.awt.*;






class TopPanel extends JPanel{
    

    PressableButton list = new PressableButton("#159069","#56b798",10);
    

    public TopPanel(SidePanel sidePanel){
       
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(0,40));
        this.setBackground(Color.decode("#30302f"));

       
       //list button 

        list.setPreferredSize(new Dimension(40,30));
        list.setText("list");
        list.addActionListener(e -> {
            System.out.println("list pressed");
            // sidePanel.setVisible(!sidePanel.isVisible());
            if(sidePanel.getPreferredSize().width==0){
                sidePanel.setPreferredSize(new Dimension(300,0));

            }
            else sidePanel.setPreferredSize(new Dimension(0 , 0 ));

            sidePanel.revalidate();
            sidePanel.repaint();

        });
        
       
        this.add(list);

    }


}

class SidePanel extends JPanel{

    public SidePanel(){

        this.setPreferredSize(new Dimension(0,0));
        this.setBackground(Color.decode("#4e4e4e"));
        

    }
}

public class ShopPanel extends JPanel {

    public ShopPanel(){
        
        this.setLayout(new BorderLayout());   
        
       

        
        //SidePanel listPanel = new SidePanel();
        
        //TopPanel topPanel = new TopPanel(listPanel);
        





        JPanel mainPanel = new JPanel(new BorderLayout(0,0));
    



      


        MainWindow mainWindow = new MainWindow();
       
       
      

            //adding items test
            mainWindow.addItem("laptop","laptop.PNG","15,000");
            mainWindow.addItem("keyboard","keyboard.PNG","1000");
            mainWindow.addItem("mouse","mouse.PNG","500");
            mainWindow.addItem("microphone","microphone.PNG","1500");
         
            for(int i =0 ; i<6 ; i++){
                mainWindow.addItem("microphone","microphone.PNG","1500");
            }
          
            
      
            mainWindow.addCategory("keyboards","keyboard.PNG");
      
         
         

       
       // mainPanel.add(sidePanel, BorderLayout.WEST);
       // mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(mainWindow, BorderLayout.CENTER);

       


        this.add(mainPanel, BorderLayout.CENTER);
    }
}
