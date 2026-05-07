package shop.ui.ShopWindow;


//main imports 
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;




//my imports
import shop.ui.CartWindow.CartWindow;
import shop.ui.CartWindow.CheckoutWindow;
import shop.ui.Data.User;

import shop.ui.HomeWindow.HomeWindow;
import shop.ui.LogicHelper.*;
import shop.ui.loginWindow.LoginWrapperWindow;

public class ShopWindow extends JPanel {









    private CardLayout cardLayout;
    private JPanel cardPanel;

 
 
    private CartWindow cartWindow;
    private HomeWindow homeWindow;
    private LoginWrapperWindow loginWrapper;
    private CheckoutWindow checkoutWindow;



    private ArrayList<Product> products;
    private ArrayList<Category> categories;

  
  
    private boolean isLogged = false;

    private User user;

   
   
    public ShopWindow() {

        setLayout(new BorderLayout());
        

        // ================= CARD LAYOUT =================

        this.cardLayout = new CardLayout();

        this.cardPanel =
                new JPanel(cardLayout);

        cardPanel.setOpaque(false);

        this.products =
                new ArrayList<>();

        this.categories =
                new ArrayList<>();

        this.loginWrapper =
                new LoginWrapperWindow(this);

        this.homeWindow =
                new HomeWindow(this);

        this.cartWindow =
                new CartWindow(this);

        this.checkoutWindow =
                new CheckoutWindow(
                        this,
                        cartWindow
                );

        this.user =
                new User(
                        "",
                        "",
                        "",
                        ""
                );

        // ================= PRODUCTS =================

        addItem(
                1,
                "Laptop",
                "laptop.PNG",
                "Powerful performance for work and play.",
                20000,
                1
        );

        addItem(
                2,
                "Microphone",
                "microphone.PNG",
                "Studio-quality sound at your fingertips.",
                800,
                2
        );

        addItem(
                3,
                "Mouse",
                "mouse.PNG",
                "Ergonomic design for all-day comfort.",
                500,
                2
        );

        addItem(
                4,
                "Keyboard",
                "keyboard.PNG",
                "Mechanical keys with satisfying tactile feedback.",
                1000,
                2
        );

        addItem(
                5,
                "Monitor",
                "laptop.PNG",
                "Crisp 4K display for an immersive experience.",
                8000,
                1
        );

        addItem(
                6,
                "Headset",
                "microphone.PNG",
                "Crystal-clear audio with noise cancellation.",
                1500,
                2
        );

        // ================= CATEGORIES =================

        addCategory(
                1,
                "Electronics",
                "laptop.PNG"
        );

        addCategory(
                2,
                "Accessories",
                "keyboard.PNG"
        );

        // ================= WINDOWS =================

        cardPanel.add(
                homeWindow,
                "homeWindow"
        );

        cardPanel.add(
                cartWindow,
                "cartWindow"
        );

        cardPanel.add(
                loginWrapper,
                "loginWrapper"
        );

        cardPanel.add(
                checkoutWindow,
                "checkoutWindow"
        );

        add(cardPanel, BorderLayout.CENTER);

       

        showHomeWindow();
   
}
    
    // ================= SHOW FUNCTIONS =================

    public void showCartWindow() {

        cardLayout.show(
                cardPanel,
                "cartWindow"
        );

        cartWindow.defaultCartScroll();

        cartWindow.updateCheckoutButton(this);

        revalidate();

        repaint();
    }

    public void showHomeWindow() {

        cardLayout.show(
                cardPanel,
                "homeWindow"
        );

        homeWindow.panelVisible(false);

        homeWindow.resetSearch();

        homeWindow.greetingLabel();

        revalidate();

        repaint();
    }

    public void showLoginWrapper() {

        cardLayout.show(
                cardPanel,
                "loginWrapper"
        );

        loginWrapper.showLoginWindow();

        revalidate();

        repaint();
    }

    public void showCheckoutWindow() {

        cardLayout.show(
                cardPanel,
                "checkoutWindow"
        );

        checkoutWindow.loadCheckout(
                cartWindow.getCart()
        );

        revalidate();

        repaint();
    }

    // ================= ADD FUNCTIONS =================

    public void addItem(
            int id,
            String name,
            String imageName,
            String description,
            double price,
            int categoryId
    ) {

        Product product =
                new Product(
                        id,
                        name,
                        imageName,
                        description,
                        price,
                        categoryId
                );

        products.add(product);

        homeWindow.addItem(product);
    }

    public void addCategory(
            int id,
            String name,
            String imageName
    ) {

        Category category =
                new Category(
                        id,
                        name,
                        imageName
                );

        categories.add(category);

        homeWindow.addCategory(category);
    }

    public void addToCart(Product product) {

        cartWindow.addToCart(product);
    }

    // ================= REMOVE FUNCTIONS =================

    public void removeItem(int id) {

        Product removable = null;

        for (Product p : products) {

            if (p.getId() == id) {

                removable = p;

                break;
            }
        }

        if (removable != null) {

            products.remove(removable);

            homeWindow.removeItem(removable);
        }
    }

    public void removeCategory(int id) {

        Category removable = null;

        for (Category c : categories) {

            if (c.getId() == id) {

                removable = c;

                break;
            }
        }

        if (removable != null) {

            categories.remove(removable);

            homeWindow.removeCategory(removable);
        }
    }

    public void removeFromCart(int id) {

        cartWindow.removeFromCart(id);
    }

    // ================= SEARCH =================

    public ArrayList<Product> searchProducts(
            String text
    ) {

        ArrayList<Product> found =
                new ArrayList<>();

        for (Product p : products) {

            if (p.getName()
                    .toLowerCase()
                    .contains(
                            text.toLowerCase()
                    )) {

                found.add(p);
            }
        }

        return found;
    }

    // ================= SETTERS =================

    public void setIsLogged(
            boolean isLogged
    ) {

        this.isLogged = isLogged;
    }

    public void setUser(
            String firstName,
            String lastName,
            String email,
            String password
    ) {

        user.setFirstName(firstName);

        user.setLastName(lastName);

        user.setEmail(email);

        user.setPassword(password);
    }

    // ================= GETTERS =================

    public boolean getIsLogged() {

        return isLogged;
    }

    public User getUser() {

        return user;
    }

    public ArrayList<Product> getAllProducts() {

        return products;
    }

    public HomeWindow getHomeWindow() {

        return homeWindow;
    }
}