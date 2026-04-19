package shop.ui.MainWrapper;




//my imports 
import shop.ui.Helper.*;
import shop.ui.MainWindow.MainWindow;
import shop.ui.ShopWindow.ShopWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class MainWrapper extends JPanel{

    private WrapperTop wrapperTop;
    private WrapperSide wrapperSide;
    private WrapperCenter wrapperCenter;
    private JPanel wrapperBottom;



    private ShopWindow shopWindow;
    private JLabel userGreetingLabel;





    public MainWrapper(MainWindow mainWindow, ShopWindow shopWindow){




        this.setLayout(new BorderLayout());
        this.setOpaque(false);

    
        userGreetingLabel = new JLabel();
        this.shopWindow=shopWindow;


        wrapperBottom = new JPanel(new BorderLayout());
        wrapperSide = new WrapperSide(mainWindow ,this,shopWindow);
        wrapperCenter = new WrapperCenter(this);
        wrapperBottom.add(wrapperSide, BorderLayout.WEST);
        wrapperBottom.add(wrapperCenter, BorderLayout.CENTER);
        wrapperBottom.setOpaque(false);
        wrapperBottom.setVisible(false);

    
        wrapperTop = new WrapperTop(wrapperBottom, shopWindow,this);

        
        this.add(wrapperTop, BorderLayout.NORTH);
        this.add(wrapperBottom, BorderLayout.CENTER);

        greetingLabel();

    }

    // helping methods 



    public void panelVisible(boolean bool){
        wrapperBottom.setVisible(bool);
    }

    public void resetSearch(){
        wrapperTop.resetSearch();
    }



    public void greetingLabel(){


        userGreetingLabel.setOpaque(false);
        userGreetingLabel.setForeground(Color.WHITE);
        userGreetingLabel.setFont(new Font("Arial",Font.BOLD,12)); 
 
         if(shopWindow.getIsLogged())userGreetingLabel.setText("Hello, "+shopWindow.getUser().getFirstName());
         else userGreetingLabel.setText("please log in");
 

    }

    //getters
    public JLabel getUserGreetingLabel(){return userGreetingLabel;}


}


class WrapperTop extends JPanel{
    
    
    private float[] searchFloats = {0.0f,1.0f};
    private Color[] searchColors = {Color.decode("#222222"),Color.decode("#222222")};
    
    private MyText searchField;
    

    public WrapperTop(JPanel panel, ShopWindow shopWindow, MainWrapper mainWrapper){
       
       
       
       
        this.setLayout(new GridLayout(1,3,0,0));
        this.setPreferredSize(new Dimension(0,40));
        this.setBackground(Color.decode("#111111"));

       



        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(0,40));
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        middlePanel.setOpaque(false);
        middlePanel.setPreferredSize(new Dimension(0,40));
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(0,40));






        //search bar 
      

       
        searchField = new MyText(0,0,0,getHeight(),searchFloats,searchColors,30,"Search",false);
        searchField.setPreferredSize(new Dimension(400 , 30 ));
        searchField.setPreferredSize(new Dimension(300 , 30 ));
        searchField.setMaximumSize(new Dimension(300 , 30 ));
        searchField.setMinimumSize(new Dimension(300 , 30 ));
        middlePanel.add(searchField);



        //user greeting
        JPanel userGreetingPanel = new JPanel(new BorderLayout());
        userGreetingPanel.setPreferredSize(new Dimension(200,20));
        userGreetingPanel.setOpaque(false);

       
        userGreetingPanel.add(mainWrapper.getUserGreetingLabel(), BorderLayout.CENTER);

        rightPanel.add(userGreetingPanel);



        //login
        PressableButton login = new PressableButton("#159069","#56b798",10);
        login.setText("login");
        login.setPreferredSize(new Dimension(90,30));
        login.addActionListener(e->{
            System.out.println("login");
            
            shopWindow.showLoginWrapper();
            
            revalidate();
            repaint();


        });
        rightPanel.add(login);



        //cart
        PressableButton cart = new PressableButton("#159069","#56b798",10);
        cart.setText("Cart");
        cart.setMinimumSize(new Dimension(60,30));
        cart.setPreferredSize(new Dimension(60,30));
        cart.setMaximumSize(new Dimension(60,30));
        cart.addActionListener(e->{
            System.out.println("cart");
            

            
            shopWindow.showCartWindow();
            
            revalidate();
            repaint();


        });
        rightPanel.add(cart);




      



       //list button 
        PressableButton list = new PressableButton("#159069","#56b798",10);
        list.setPreferredSize(new Dimension(70,30));
        list.setText("list");
        list.addActionListener(e -> {
            System.out.println("list pressed");
            if(!panel.isVisible()){
                panel.setVisible(true);

            }
            else panel.setVisible(false);

            panel.revalidate();
            panel.repaint();

        });
        leftPanel.add(list);
       
       

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);




    }

    public void resetSearch(){
        searchField.resetText();
    }

}



class SideInner extends MyGradient{
   
   
    public SideInner(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        super(startX, startY , endX, endY, degrees, colors, arc);
        this.setLayout(new BorderLayout());
        this.setOpaque(false);



    }
}


class WrapperSide extends JPanel{

    private float[] degrees = {0.0f, 0.2f,0.7f ,1.0f};
    private Color[] colors ={Color.decode("#1d1d1d"),Color.decode("#2e2e2e"),Color.decode("#313131"),Color.decode("#313131")};
    

    public WrapperSide(MainWindow mainWindow,MainWrapper mainWrapper,ShopWindow shopWindow){

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300,0));
        this.setBackground(Color.decode("#313131"));
        //  this.setOpaque(false);
        

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(new EmptyBorder(15,10,0,10));
        wrapper.setOpaque(false);


        SideInner side = new SideInner(0,0,0,getHeight(),degrees,colors,10);


        JPanel cateWrapper = new JPanel();
        cateWrapper.setLayout(new BoxLayout(cateWrapper,BoxLayout.Y_AXIS));
        cateWrapper.setOpaque(false);

            PressableButton category = new PressableButton("#159069","#56b798",10);
            category.setText("Categories");
            category.setMaximumSize(new Dimension(250,30));
            category.setPreferredSize(new Dimension(250,30));
            category.setAlignmentX(Component.CENTER_ALIGNMENT);
            category.addActionListener( e->{

            mainWindow.showCategoriesHolder();
            mainWindow.defaultScroll();
            mainWrapper.panelVisible(false);


            });
        


            PressableButton login = new PressableButton("#159069","#56b798",10);
            login.setText("Login / Signin");
            login.setMaximumSize(new Dimension(250,30));
            login.setPreferredSize(new Dimension(250,30));
            login.setAlignmentX(Component.CENTER_ALIGNMENT);
            login.addActionListener( e->{
                shopWindow.showLoginWrapper();
                
            });
        



        
        cateWrapper.add(Box.createVerticalStrut(30));
        cateWrapper.add(category);
        cateWrapper.add(Box.createVerticalStrut(10));
        cateWrapper.add(login);




        side.add(cateWrapper, BorderLayout.CENTER);
        wrapper.add(side, BorderLayout.CENTER);
        this.add(wrapper,BorderLayout.CENTER);

    }

   
}


class WrapperCenter extends JPanel{
    public WrapperCenter(MainWrapper mainWrapper){

        this.setBackground(new Color(0, 0, 0, 150));

        this.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                mainWrapper.panelVisible(false);
            }

        });


    }
}

