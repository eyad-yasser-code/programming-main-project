



import shop.ui.ShopWindow.ShopWindow;



import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("Shop test");
        frame.setSize(1280,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
       

       
        frame.add(new ShopWindow());
        frame.setVisible(true);

    }
}
