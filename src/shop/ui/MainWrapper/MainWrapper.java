package shop.ui.MainWrapper;



// main imports
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



//my imports 
import shop.ui.Helper.*;
import shop.ui.LogicHelper.Product;
import shop.ui.MainWindow.MainWindow;
import shop.ui.ShopWindow.ShopWindow;




public class MainWrapper extends JPanel {

    
    
    
    private WrapperSide   wrapperSide; // this is the side has more buttons
    private WrapperCenter wrapperCenter; //this one is the shadow 
    private JPanel        wrapperBottom;// this has both side and center merged to one panel 

    private WrapperTop    wrapperTop; // for search and other


    private ShopWindow shopWindow; // for some uses below
    


    private JLabel  userGreetingLabel; // change with changing login state



    //constructor
    public MainWrapper(MainWindow mainWindow, ShopWindow shopWindow) 
    {


        this.shopWindow   = shopWindow;

        this.setLayout(new BorderLayout());
        this.setOpaque(false);
       // this.setBorder(BorderFactory.createLineBorder( Color.decode("#141414") ,10));



       
        userGreetingLabel = new JLabel();


        wrapperBottom = new JPanel(new BorderLayout());

        wrapperTop = new WrapperTop(wrapperBottom, shopWindow, this);
       
        wrapperSide   = new WrapperSide(mainWindow, this, shopWindow);
        wrapperCenter = new WrapperCenter(this);
       
       
        wrapperBottom.add(wrapperSide,   BorderLayout.WEST);
        wrapperBottom.add(wrapperCenter, BorderLayout.CENTER);
        wrapperBottom.setOpaque(false);
        wrapperBottom.setVisible(false);
       
   

        //mainWrapper consists of two panels top and bottom and the bottom has 2 others 
        this.add(wrapperTop,    BorderLayout.NORTH);
        this.add(wrapperBottom, BorderLayout.CENTER);




        greetingLabel();//changing text
        //anytime mainWrapper shown or at construction I check if logged 
    }

    //  Helpers
    //=====================


        //mainWrapper -> homeWindow 
        //click to hide
        public void panelVisible(boolean bool) { wrapperBottom.setVisible(bool); }
        
        
        public void resetSearch(){ wrapperTop.resetSearch(); }

    
    
    
        // change greeting text
        public void greetingLabel() {
            userGreetingLabel.setOpaque(false);
            userGreetingLabel.setForeground(Color.WHITE);
            userGreetingLabel.setFont(new Font("SansSerif", Font.BOLD, 12));

            if (shopWindow.getIsLogged())
                userGreetingLabel.setText("Hello, " + shopWindow.getUser().getFirstName() + " 👋");
            else
                userGreetingLabel.setText("Please log in");
        }




    //  Getters
    //=========================

    public JLabel getUserGreetingLabel() { return userGreetingLabel; }
}






class WrapperTop extends JPanel
 {

    private final float[] searchFloats = {0.0f, 1.0f};
    private final Color[] searchColors = {Color.decode("#1a1a1a"), Color.decode("#1a1a1a")};



    private MyText searchField;     //help in searching logic


    //panel for wrapperBottom for sidePanel
    //shopWindow for :-> homeWindow -> showcategorie
            //search in product with search text
            //show loginWrapper
            //show cartWindow
    //mainWrapper for getting userLabel after check

    public WrapperTop(JPanel panel, ShopWindow shopWindow, MainWrapper mainWrapper) 
    {




        this.setLayout(new GridLayout(1, 3, 0, 0));
        this.setPreferredSize(new Dimension(0, 46));
        this.setBackground(Color.decode("#0e0e0e"));





        JPanel leftPanel   = new JPanel(new FlowLayout(FlowLayout.LEFT,  8, 7));//for list 
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 7));//for search
        JPanel rightPanel  = new JPanel(new FlowLayout(FlowLayout.RIGHT,  8, 7));//for cart, login, greeting

        leftPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        rightPanel.setOpaque(false);




        //middlePanel
        //===============

        searchField = new MyText(0, 0, 0, getHeight(), searchFloats, searchColors, 20,"Search products…", false);
        searchField.setPreferredSize(new Dimension(300, 32));
        searchField.setMaximumSize(new Dimension(300, 32));
        searchField.setMinimumSize(new Dimension(300, 32));
       
    
    
        
            searchField.addTextListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e)  { update(); } //if user added text 
                public void removeUpdate(DocumentEvent e)  { update(); } //if user rmoved text
                public void changedUpdate(DocumentEvent e) { update(); } //if text style changed 

            private void update()
                {
                    //if i lost focus
                    if (!searchField.isUserTyping()) return;
                   
                    //if im in focus
                    String text = searchField.getText().trim();
                    if (text.isEmpty()) {
                        shopWindow.getHomeWindow().showCategories();//if i remove my search show categories
                        return;
                    }
                    //take this text go to shopWindow search products that include this text 
                    //come back here put these products in results 
                    //show results in homeWindow -> mainWindow -> itemHolder
                    ArrayList<Product> results = shopWindow.searchProducts(text);
                    shopWindow.getHomeWindow().showSearchedProducts(results);//Gui
                }
            });

        middlePanel.add(searchField);

     
      
      //rightPanel
      //===========
      
        //greeting
        //===========
        JPanel userGreetingPanel = new JPanel(new BorderLayout());
        userGreetingPanel.setPreferredSize(new Dimension(160, 32));
        userGreetingPanel.setOpaque(false);
        userGreetingPanel.add(mainWrapper.getUserGreetingLabel(), BorderLayout.CENTER);
        //getUserGreetingLabel gets the label after login checked
        rightPanel.add(userGreetingPanel);

        //login
        //=========
        PressableButton login = new PressableButton("#159069", "#21c48a", 10);
        login.setText("Login");
        login.setFont(new Font("SansSerif", Font.BOLD, 12));
        login.setPreferredSize(new Dimension(80, 32));
        login.addActionListener(e -> {
            shopWindow.showLoginWrapper();
            revalidate();
            repaint();
        });
        rightPanel.add(login);

        //cart
        //========
        PressableButton cart = new PressableButton("#159069", "#21c48a", 10);
        cart.setText("🛒 Cart");
        cart.setFont(new Font("SansSerif", Font.BOLD, 12));
        cart.setPreferredSize(new Dimension(80, 32));
        cart.addActionListener(e -> {
            shopWindow.showCartWindow();
            revalidate();
            repaint();
        });
        rightPanel.add(cart);





     //leftPanel
     //===============   
        PressableButton list = new PressableButton("#159069", "#21c48a", 10);
        list.setText("☰  Menu");
        list.setFont(new Font("SansSerif", Font.BOLD, 12));
        list.setPreferredSize(new Dimension(100, 32));
        list.addActionListener(e -> {
            panel.setVisible(!panel.isVisible());
            panel.revalidate();
            panel.repaint();
        });
        leftPanel.add(list);

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);
    }

    //helper 
    //==========
    public void resetSearch() { searchField.resetText(); }

}


class SideInner extends MyGradient {
    public SideInner(int startX, int startY, int endX, int endY,
                     float[] degrees, Color[] colors, int arc) {
        super(startX, startY, endX, endY, degrees, colors, arc);
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
    }
}

class WrapperSide extends JPanel {

    private final float[] degrees = {0.0f, 0.2f, 0.7f, 1.0f};
    private final Color[] colors  = {
        Color.decode("#191919"),
        Color.decode("#232323"),
        Color.decode("#282828"),
        Color.decode("#282828")
    };

    public WrapperSide(MainWindow mainWindow, MainWrapper mainWrapper, ShopWindow shopWindow) {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(260, 0));
        this.setBackground(Color.decode("#0e0e0e"));

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(new EmptyBorder(15, 10, 0, 10));
        wrapper.setOpaque(false);

        SideInner side = new SideInner(0, 0, 0, getHeight(), degrees, colors, 10);

        JPanel cateWrapper = new JPanel();
        cateWrapper.setLayout(new BoxLayout(cateWrapper, BoxLayout.Y_AXIS));
        cateWrapper.setOpaque(false);

                // Categories button
                PressableButton category = new PressableButton("#159069", "#21c48a", 10);
                category.setText("📂  Categories");
                category.setFont(new Font("SansSerif", Font.BOLD, 13));
                category.setMaximumSize(new Dimension(200, 36));
                category.setPreferredSize(new Dimension(200, 36));
                category.setAlignmentX(Component.CENTER_ALIGNMENT);
                category.addActionListener(e -> {
                    shopWindow.getHomeWindow().showCategories();
                    mainWindow.defaultScroll();
                    mainWrapper.panelVisible(false);
                });

                
                
                //  Login / Sign-in button 
                PressableButton loginBtn = new PressableButton("#159069", "#21c48a", 10);
                loginBtn.setText("🔑  Login / Sign in");
                loginBtn.setFont(new Font("SansSerif", Font.BOLD, 13));
                loginBtn.setMaximumSize(new Dimension(200, 36));
                loginBtn.setPreferredSize(new Dimension(200, 36));
                loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                loginBtn.addActionListener(e -> shopWindow.showLoginWrapper());


                // admin button

                PressableButton adminBtn = new PressableButton("#159069", "#21c48a", 10);
                adminBtn.setText("🛠️  admin");
                adminBtn.setFont(new Font("SansSerif", Font.BOLD, 13));
                adminBtn.setMaximumSize(new Dimension(200, 36));
                adminBtn.setPreferredSize(new Dimension(200, 36));
                adminBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                adminBtn.addActionListener(e ->shopWindow.showAdminWrapper());



        cateWrapper.add(Box.createVerticalStrut(30));
        cateWrapper.add(category);
        cateWrapper.add(Box.createVerticalStrut(12));
        cateWrapper.add(loginBtn);
        cateWrapper.add(Box.createVerticalStrut(12));
        cateWrapper.add(adminBtn);

        side.add(cateWrapper, BorderLayout.CENTER);
        wrapper.add(side, BorderLayout.CENTER);
        this.add(wrapper, BorderLayout.CENTER);
    }
}



class WrapperCenter extends JPanel 
{
    public WrapperCenter(MainWrapper mainWrapper) 
    {
     
        this.setBackground(new Color(0, 0, 0, 170));
        this.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                mainWrapper.panelVisible(false);
            }
        });
    }
}
