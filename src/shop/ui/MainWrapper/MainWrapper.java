package shop.ui.MainWrapper;



import shop.ui.CartWindow.CartWindow;
//my imports 
import shop.ui.Helper.*;
import shop.ui.MainWindow.MainWindow;
import shop.ui.ShopWindow.ShopWindow;

import javax.swing.*;
import java.awt.*;


public class MainWrapper extends JPanel{

private WrapperTop wrapperTop;
private WrapperSide wrapperSide;
private WrapperCenter wrapperCenter;

private JPanel wrapperBottom;





public MainWrapper(MainWindow mainWindow, ShopWindow shopWindow ,CartWindow cartWindow){


    this.setLayout(new BorderLayout());
    this.setOpaque(false);

  
    



    wrapperBottom = new JPanel(new BorderLayout());
    wrapperSide = new WrapperSide(mainWindow , this);
    wrapperCenter = new WrapperCenter(this);
    wrapperBottom.add(wrapperSide, BorderLayout.WEST);
    wrapperBottom.add(wrapperCenter, BorderLayout.CENTER);
    wrapperBottom.setOpaque(false);
    wrapperBottom.setVisible(false);

   
    wrapperTop = new WrapperTop(wrapperBottom, shopWindow, cartWindow);

    
    this.add(wrapperTop, BorderLayout.NORTH);
    this.add(wrapperBottom, BorderLayout.CENTER);


}

// helping methods 

public void panelVisible(boolean bool){
    wrapperBottom.setVisible(bool);
}

}


class WrapperTop extends JPanel{
    

   
    

    public WrapperTop(JPanel panel, ShopWindow shopWindow, CartWindow cartWindow){
       
       
       
       
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
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(400 , 30 ));
        
        middlePanel.add(searchField);



        //login
        PressableButton login = new PressableButton("#159069","#56b798",10);
        login.setText("login");
        login.setPreferredSize(new Dimension(90,30));
        login.addActionListener(e->{
            System.out.println("login");
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
            SwingUtilities.invokeLater(() -> {
                cartWindow.defaultCartScroll();
            });
        
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


}





class WrapperSide extends JPanel{

    

    public WrapperSide(MainWindow mainWindow,MainWrapper mainWrapper){

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300,0));
        this.setBackground(Color.decode("#4e4e4e"));
        

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

        this.add(Box.createVerticalStrut(20));
        this.add(category);

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