package shop.ui.MainWrapper;



//my imports 
import shop.ui.Helper.*;
import shop.ui.MainWindow.MainWindow;


import javax.swing.*;
import java.awt.*;


public class MainWrapper extends JPanel{

private WrapperTop wrapperTop;
private WrapperSide wrapperSide;
private WrapperCenter wrapperCenter;




public MainWrapper(MainWindow mainWindow){


    this.setLayout(new BorderLayout());


  


    JPanel wrapperBottom = new JPanel(new BorderLayout());
    wrapperSide = new WrapperSide(mainWindow , wrapperBottom);
    wrapperCenter = new WrapperCenter();
    wrapperBottom.add(wrapperSide, BorderLayout.WEST);
    wrapperBottom.add(wrapperCenter, BorderLayout.CENTER);
    wrapperBottom.setOpaque(false);
    wrapperBottom.setVisible(false);

   
    wrapperTop = new WrapperTop(wrapperBottom);

    
    this.add(wrapperTop, BorderLayout.NORTH);
    this.add(wrapperBottom, BorderLayout.CENTER);


}


}


class WrapperTop extends JPanel{
    

    PressableButton list = new PressableButton("#159069","#56b798",10);
    

    public WrapperTop(JPanel panel){
       
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(0,40));
        this.setBackground(Color.decode("#111111"));

       
       //list button 

        list.setPreferredSize(new Dimension(40,30));
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
        
       
        this.add(list);

    }


}

class WrapperSide extends JPanel{

    

    public WrapperSide(MainWindow mainWindow, JPanel panel){

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
          panel.setVisible(false);


        });

        this.add(Box.createVerticalStrut(20));
        this.add(category);

    }
}


class WrapperCenter extends JPanel{
    public WrapperCenter(){

        this.setBackground(new Color(0, 0, 0, 150));

    }
}