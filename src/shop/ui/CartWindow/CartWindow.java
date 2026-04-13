//main package 
package shop.ui.CartWindow;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import shop.ui.Helper.PressableButton;
import shop.ui.HomeWindow.HomeWindow;
import shop.ui.ShopWindow.ShopWindow;


public class CartWindow extends JPanel{
    

    private JPanel leftTopTop;



    public CartWindow(ShopWindow shopWindow, HomeWindow homeWindow){

      this.setLayout(new BorderLayout());
    
      


       


      
      
      
      JPanel wrapper = new JPanel(new GridBagLayout());
      wrapper.setOpaque(false);

      JPanel cartBase = new JPanel(new BorderLayout());
      cartBase.setPreferredSize(new Dimension(900,700));
      cartBase.setBackground(Color.BLACK);
      
       
      
      
      
        JPanel cartLeft = new JPanel(new BorderLayout());
        cartLeft.setPreferredSize(new Dimension(600,600));
        cartLeft.setBackground(Color.decode("#7c7c7c"));

           
        
            JPanel leftBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
            leftBottom.setPreferredSize(new Dimension(600,60));
            leftBottom.setOpaque(false);
            leftBottom.setBorder(new EmptyBorder(3,10,50,3));

            PressableButton back = new PressableButton("#159069","#56b798",10);
            back.setText("back");
            back.setPreferredSize(new Dimension(80,40));
            back.addActionListener(e->{
                shopWindow.showHomeWindow();
                homeWindow.panelVisible(false);
                revalidate();
                repaint();
            });

            leftBottom.add(back);

            
            

           
            



            JPanel leftTop = new JPanel(new BorderLayout());
           leftTop.setOpaque(false);



            JPanel leftWrapper = new JPanel(new BorderLayout());
            leftWrapper.setOpaque(false); 


                leftTopTop = new JPanel();
                leftTopTop.setLayout(new BoxLayout(leftTopTop, BoxLayout.Y_AXIS));
                leftTopTop.setOpaque(false);

                
            


                PressableButton toTop = new PressableButton("#159069","#56b798",10);
                toTop.setText("^");
                toTop.setPreferredSize(new Dimension(50,50));
                toTop.setMaximumSize(new Dimension(50,50));
                toTop.setAlignmentX(Component.RIGHT_ALIGNMENT);
               
               
                
                JPanel leftTopBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
                leftTopBottom.setPreferredSize(new Dimension(600,50));
                leftTopBottom.setOpaque(false);
                leftTopBottom.add(toTop);
                leftTopBottom.setAlignmentX(Component.RIGHT_ALIGNMENT);
                leftTopBottom.setBorder(new EmptyBorder(4,4,40,40));

                leftWrapper.add(leftTopTop, BorderLayout.CENTER);
                leftWrapper.add(leftTopBottom, BorderLayout.SOUTH);

                
                JScrollPane scrollPane = new JScrollPane(leftWrapper);
                scrollPane.setWheelScrollingEnabled(true);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setBorder(null);
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
                toTop.addActionListener(e->{
                    scrollPane.getVerticalScrollBar().setValue(0);
                });
           



            
            leftTop.add(scrollPane, BorderLayout.CENTER);
          
           // leftTop.add(leftTopBottom, BorderLayout.SOUTH);


       
        cartLeft.add(leftBottom, BorderLayout.SOUTH);    
        cartLeft.add(leftTop, BorderLayout.CENTER);



        JPanel cartRight = new JPanel(new BorderLayout());
        cartRight.setPreferredSize(new Dimension(300 , 600));
        cartRight.setBackground(Color.decode("#505050"));

        cartBase.add(cartLeft, BorderLayout.CENTER);
        cartBase.add(cartRight, BorderLayout.EAST);


     
     
     
     
        wrapper.add(cartBase);
        this.add(wrapper);


        
        for(int i = 0 ; i < 20 ; i++){ 
            addItem();
          
        }
     
    

    }



    //look
    
    @Override
   protected void paintComponent(Graphics graphics) {
      
       Color colors[]={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
       float degree[]={0.0f, 0.7f, 1.0f};

       super.paintComponent(graphics); //remove color of panel
       Graphics2D graphics2d = (Graphics2D) graphics;
       LinearGradientPaint linerG = new LinearGradientPaint(0,0, 0,getHeight(),degree,colors);
      
       graphics2d.setPaint(linerG);
       graphics2d.fillRect(0, 0, getWidth(), getHeight());
   }



   //add 

   public void addItem(){

    CartItem item = new CartItem();
    
    item.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    leftTopTop.add(item);
    leftTopTop.add(Box.createVerticalStrut(20));
    leftTopTop.revalidate();
    leftTopTop.repaint();



   }





}