//main packages
package shop.ui.CartWindow;





//my imports 



//main imports

import javax.swing.*;


import java.awt.*;



public class CartItem extends JPanel{


    public CartItem(){

        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        
        JPanel base = new JPanel(new BorderLayout());
        base.setPreferredSize(new Dimension(700 , 150 ));
        base.setBackground(Color.decode("#159069"));



            JPanel leftBase = new JPanel(new BorderLayout());
            leftBase.setPreferredSize(new Dimension(100,100));
            leftBase.setBackground(Color.WHITE);




            JPanel rightBase = new JPanel(new BorderLayout());
            rightBase.setOpaque(false);
            

                JPanel rightBaseTop = new JPanel(new BorderLayout());
                rightBaseTop.setOpaque(false);



                JPanel rightBaseBottom = new JPanel(new BorderLayout());
                rightBaseBottom.setOpaque(false);


            rightBase.add(rightBaseTop, BorderLayout.CENTER);
            rightBase.add(rightBaseBottom, BorderLayout.SOUTH);
            
        
        base.add(leftBase, BorderLayout.WEST);
        base.add(rightBase, BorderLayout.CENTER);



        this.add(base, BorderLayout.CENTER);

    }
}

