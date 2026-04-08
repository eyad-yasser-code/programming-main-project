
import shop.ui.*;
import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("Shop test");
        frame.setSize(900,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);





       
       
        frame.add(new ShopPanel());
        frame.setVisible(true);

    }
}
