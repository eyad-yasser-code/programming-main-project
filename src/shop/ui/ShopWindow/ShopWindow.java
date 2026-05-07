package shop.ui.ShopWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.*;
import shop.ui.CartWindow.CartWindow;
import shop.ui.CartWindow.CheckoutWindow;
import shop.ui.Data.User;
import shop.ui.Helper.PressableButton;
import shop.ui.HomeWindow.HomeWindow;
import shop.ui.LogicHelper.*;
import shop.ui.loginWindow.LoginWrapperWindow;

public class ShopWindow extends JFrame {

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

    // ================= RESIZE =================

    private int resizeMargin = 5;

    private boolean resizing = false;

    private int resizeDirection = 0;

    private Point clickPoint;

    public ShopWindow() {

        setLayout(new BorderLayout());

        // ================= WINDOW =================

        setUndecorated(true);

        // ================= TOP BAR =================

        JPanel topBar = new JPanel(new BorderLayout());

        topBar.setBackground(Color.decode("#1e2020"));

        topBar.setPreferredSize(new Dimension(0, 40));

        // ================= TITLE =================

        JLabel title = new JLabel("  AMAZON SHOP");

        title.setForeground(Color.WHITE);

        title.setFont(new Font("Arial", Font.BOLD, 15));

        topBar.add(title, BorderLayout.WEST);

        // ================= BUTTONS PANEL =================

        JPanel buttonsPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                5,
                                5
                        )
                );

        buttonsPanel.setOpaque(false);

        // ================= MINIMIZE =================

        PressableButton minimize =
                new PressableButton(
                        "#1e2020",
                        "#101312",
                        10
                );

        minimize.setText("\u2014");
        minimize.setFont(new Font ("PLAIN",Font.BOLD,10));

        minimize.setForeground(Color.WHITE);

        minimize.setPreferredSize(
                new Dimension(45, 25)
        );

        minimize.addActionListener(
                e -> setState(JFrame.ICONIFIED)
        );

        // ================= MAXIMIZE =================

        PressableButton maximize =
                new PressableButton(
                        "#1e2020",
                        "#101312",
                        10
                );

        maximize.setText("□");

        maximize.setForeground(Color.WHITE);

        maximize.setPreferredSize(
                new Dimension(45, 25)
        );

        maximize.addActionListener(e -> {

            if (getExtendedState()
                    != JFrame.MAXIMIZED_BOTH) {

                setExtendedState(
                        JFrame.MAXIMIZED_BOTH
                );

            } else {

                setExtendedState(
                        JFrame.NORMAL
                );
            }
        });

        // ================= CLOSE =================

        PressableButton close =
                new PressableButton(
                        "#1e2020",
                        "#ef4444",
                        10
                );

        close.setText("X");

        close.setForeground(Color.WHITE);

        close.setPreferredSize(
                new Dimension(45, 25)
        );

        close.addActionListener(
                e -> System.exit(0)
        );

        // ================= ADD BUTTONS =================

        buttonsPanel.add(minimize);

        buttonsPanel.add(maximize);

        buttonsPanel.add(close);

        topBar.add(
                buttonsPanel,
                BorderLayout.EAST
        );

        add(topBar, BorderLayout.NORTH);

        // ================= DRAG WINDOW =================

        final Point[] mousePoint = {null};

        topBar.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mousePressed(
                            MouseEvent e
                    ) {

                        mousePoint[0] =
                                e.getPoint();
                    }

                    @Override
                    public void mouseClicked(
                            MouseEvent e
                    ) {

                        if (e.getClickCount() == 2) {

                            if (getExtendedState()
                                    != JFrame.MAXIMIZED_BOTH) {

                                setExtendedState(
                                        JFrame.MAXIMIZED_BOTH
                                );

                            } else {

                                setExtendedState(
                                        JFrame.NORMAL
                                );
                            }
                        }
                    }
                });

        topBar.addMouseMotionListener(
                new MouseMotionAdapter() {

                    @Override
                    public void mouseDragged(
                            MouseEvent e
                    ) {

                        if (getExtendedState()
                                == JFrame.MAXIMIZED_BOTH) {
                            return;
                        }

                        Point current =
                                e.getLocationOnScreen();

                        setLocation(
                                current.x
                                        - mousePoint[0].x,

                                current.y
                                        - mousePoint[0].y
                        );
                    }
                });

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

        // ================= APP SETTINGS =================

        showHomeWindow();

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource(
                                "/images/logo.png"
                        )
                );

        setIconImage(icon.getImage());

        setTitle("AMAZON SHOP");

        setSize(1200, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        // ================= ENABLE RESIZE =================

        enableWindowResize();

        setVisible(true);
    }

    // ================= RESIZE FUNCTION =================

    private void enableWindowResize() {

        MouseAdapter resizeListener = new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {

                Point p = e.getPoint();

                int width = getWidth();

                int height = getHeight();

                boolean left   = p.x < resizeMargin;
                boolean right  = p.x > width - resizeMargin;
                boolean top    = p.y < resizeMargin;
                boolean bottom = p.y > height - resizeMargin;

                // ===== CORNERS =====

                if (top && left) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.NW_RESIZE_CURSOR));

                    resizeDirection = 1;
                }

                else if (top && right) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.NE_RESIZE_CURSOR));

                    resizeDirection = 2;
                }

                else if (bottom && left) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.SW_RESIZE_CURSOR));

                    resizeDirection = 3;
                }

                else if (bottom && right) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.SE_RESIZE_CURSOR));

                    resizeDirection = 4;
                }

                // ===== SIDES =====

                else if (left) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.W_RESIZE_CURSOR));

                    resizeDirection = 5;
                }

                else if (right) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.E_RESIZE_CURSOR));

                    resizeDirection = 6;
                }

                else if (top) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.N_RESIZE_CURSOR));

                    resizeDirection = 7;
                }

                else if (bottom) {

                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.S_RESIZE_CURSOR));

                    resizeDirection = 8;
                }

                else {

                    setCursor(Cursor.getDefaultCursor());

                    resizeDirection = 0;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

                clickPoint = e.getLocationOnScreen();

                resizing = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                resizing = false;
            }

            @Override
            public void mouseDragged(MouseEvent e) {

                if (getExtendedState()
                        == JFrame.MAXIMIZED_BOTH) {
                    return;
                }

                if (!resizing) return;

                Point dragPoint =
                        e.getLocationOnScreen();

                Rectangle bounds =
                        getBounds();

                int dx = dragPoint.x - clickPoint.x;

                int dy = dragPoint.y - clickPoint.y;

                switch (resizeDirection) {

                    // TOP LEFT
                    case 1:

                        setBounds(
                                bounds.x + dx,
                                bounds.y + dy,
                                bounds.width - dx,
                                bounds.height - dy
                        );

                        break;

                    // TOP RIGHT
                    case 2:

                        setBounds(
                                bounds.x,
                                bounds.y + dy,
                                bounds.width + dx,
                                bounds.height - dy
                        );

                        break;

                    // BOTTOM LEFT
                    case 3:

                        setBounds(
                                bounds.x + dx,
                                bounds.y,
                                bounds.width - dx,
                                bounds.height + dy
                        );

                        break;

                    // BOTTOM RIGHT
                    case 4:

                        setSize(
                                bounds.width + dx,
                                bounds.height + dy
                        );

                        break;

                    // LEFT
                    case 5:

                        setBounds(
                                bounds.x + dx,
                                bounds.y,
                                bounds.width - dx,
                                bounds.height
                        );

                        break;

                    // RIGHT
                    case 6:

                        setSize(
                                bounds.width + dx,
                                bounds.height
                        );

                        break;

                    // TOP
                    case 7:

                        setBounds(
                                bounds.x,
                                bounds.y + dy,
                                bounds.width,
                                bounds.height - dy
                        );

                        break;

                    // BOTTOM
                    case 8:

                        setSize(
                                bounds.width,
                                bounds.height + dy
                        );

                        break;
                }

                clickPoint = dragPoint;
            }
        };

        getContentPane().addMouseListener(
                resizeListener
        );

        getContentPane().addMouseMotionListener(
                resizeListener
        );
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