package shop.ui.MainWrapper;



//my imports 
import shop.ui.Helper.*;



import javax.swing.*;
import java.awt.*;


public class MainWrapper extends JPanel{

private WrapperTop wrapperTop;
private WrapperSide wrapperSide;
private WrapperCenter wrapperCenter;



public MainWrapper(){


    this.setLayout(new BorderLayout());

    JPanel wrapperBottom = new JPanel(new BorderLayout());
    wrapperSide = new WrapperSide();
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
            // sidePanel.setVisible(!sidePanel.isVisible());
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

    public WrapperSide(){

        this.setPreferredSize(new Dimension(300,0));
        this.setBackground(Color.decode("#4e4e4e"));
        

    }
}


class WrapperCenter extends JPanel{
    public WrapperCenter(){

        this.setBackground(new Color(0, 0, 0, 150
            
        ));

    }
}