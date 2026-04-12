

//import shop.ui.MainWindow.MainWindow;
import shop.ui.ShopWindow.ShopPanel;

import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("Shop test");
        frame.setSize(1200,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        


       
        frame.add(new ShopPanel());
        frame.setVisible(true);

    }
}
