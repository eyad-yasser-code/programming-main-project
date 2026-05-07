
//main package 
package shop.ui.loginWindow;


//my imports
import java.awt.*;
import javax.swing.*;
import shop.ui.ShopWindow.ShopWindow;




public class LoginWrapperWindow extends JPanel{

    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private LoginWindow loginWindow;
    private SignInWindow signInWindow;
    
  
    public LoginWrapperWindow(ShopWindow shopWindow){

    this.setLayout(new BorderLayout());

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);
        
        this.loginWindow = new LoginWindow(shopWindow, this);
        this.signInWindow = new SignInWindow(shopWindow, this);
        

      
        cardPanel.add(loginWindow,"loginWindow");
        cardPanel.add(signInWindow, "signInWindow");

        this.add(cardPanel, BorderLayout.CENTER);
        showLoginWindow();



    }


    //show functions 

    public void showLoginWindow(){
        cardLayout.show(cardPanel,"loginWindow");
        loginWindow.resetText();

        revalidate();
        repaint();
    }

    public void showSignInWindow(){
        cardLayout.show(cardPanel, "signInWindow");
        signInWindow.resetText();

        revalidate();
        repaint();
    }




}


