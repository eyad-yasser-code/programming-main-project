


package shop.ui.AdminWrapper;




//my imports
import java.awt.*;
import javax.swing.*;
import shop.ui.ShopWindow.ShopWindow;




public class AdminWrapper extends JPanel{

    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private AdminConfirmation adminConfirmation;
    private AdminSelection adminSelection;
    private AdminAddItem adminAddItem;
    private AdminRemoveItem adminRemoveItem;
    private AdminAddCategory adminAddCategory;
    private AdminRemoveCategory adminRemoveCategory;
    
  
    public AdminWrapper(ShopWindow shopWindow){

    this.setLayout(new BorderLayout());

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);
        
        this.adminConfirmation = new AdminConfirmation(shopWindow, this);
        this.adminSelection = new AdminSelection(shopWindow, this);
        this.adminAddItem = new AdminAddItem(shopWindow, this);
        this.adminRemoveItem = new AdminRemoveItem(shopWindow, this);
        this.adminAddCategory =new AdminAddCategory(shopWindow,this);
        this.adminRemoveCategory= new AdminRemoveCategory(shopWindow, this);
        

        cardPanel.add(adminConfirmation, "adminConfirmation");
        cardPanel.add(adminSelection, "adminSelection");
        cardPanel.add(adminAddItem, "adminAddItem");
        cardPanel.add(adminRemoveItem,"adminRemoveItem");
        cardPanel.add(adminAddCategory,"adminAddCategory");
        cardPanel.add(adminRemoveCategory,"adminRemoveCategory");

        this.add(cardPanel, BorderLayout.CENTER);
        showAdminConfirmation();



    }


    //show functions 

    public void showAdminConfirmation(){
        cardLayout.show(cardPanel,"adminConfirmation");
        adminConfirmation.resetText();

        revalidate();
        repaint();
    }

   
    public void showAdminSelection(){
        cardLayout.show(cardPanel, "adminSelection");
        adminAddItem.resetText();

        revalidate();
        repaint();  
    }

    public void showAdminAddItem(){
        cardLayout.show(cardPanel, "adminAddItem");
        adminAddItem.resetText();

        revalidate();
        repaint();  
    }


    public void showAdminRemoveItem(){
        cardLayout.show(cardPanel, "adminRemoveItem");
        adminAddItem.resetText();

        revalidate();
        repaint();  
    }


    public void showAdminAddCategory(){
        cardLayout.show(cardPanel, "adminAddCategory");
        adminAddItem.resetText();

        revalidate();
        repaint();  
    }


    public void showAdminRemoveCategory(){
        cardLayout.show(cardPanel, "adminRemoveCategory");
        adminAddItem.resetText();

        revalidate();
        repaint();  
    }



}


