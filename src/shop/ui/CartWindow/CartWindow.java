


//main package 
package shop.ui.CartWindow;


//my imports
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.HomeWindow.HomeWindow;
import shop.ui.ShopWindow.ShopWindow;

//main imports
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CartWindow extends JPanel{
    

    private JPanel items;



    
    private float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
            



    public CartWindow(ShopWindow shopWindow, HomeWindow homeWindow){

      this.setLayout(new BorderLayout());
    
      

      
      JPanel wrapper = new JPanel(new GridBagLayout());
      wrapper.setOpaque(false);

      JPanel cartBase = new JPanel(new BorderLayout());
      cartBase.setPreferredSize(new Dimension(1000,700));
      cartBase.setBackground(Color.BLACK);
      
       
      
      
      
        JPanel cartLeft = new JPanel(new BorderLayout());
        cartLeft.setPreferredSize(new Dimension(500,600));
        cartLeft.setBackground(Color.decode("#7c7c7c"));

           
        
            JPanel leftBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
            leftBottom.setPreferredSize(new Dimension(600,70));
            leftBottom.setOpaque(false);
            leftBottom.setBorder(new EmptyBorder(10,10,10,0));

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

            


            LeftTop leftTop = new LeftTop(0,0,0,getHeight(),degrees,colors,30);

                
         
          


            JPanel itemsWrapper = new JPanel(new BorderLayout());
            itemsWrapper.setOpaque(false); 


            items = new JPanel();
            items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
            items.setOpaque(false);

                
            
                PressableButton toTop = new PressableButton("#159069","#56b798",10);
                toTop.setText("Top");
                toTop.setPreferredSize(new Dimension(60,50));
                toTop.setMaximumSize(new Dimension(60,50));
                toTop.setMinimumSize(new Dimension(60,50));
                toTop.setAlignmentX(Component.RIGHT_ALIGNMENT);
                
                
                JPanel itemsButtons = new JPanel();
                itemsButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
                itemsButtons.setPreferredSize(new Dimension(400,60));
                itemsButtons.setMaximumSize(new Dimension(400,60));
                itemsButtons.setMinimumSize(new Dimension(400,60));
                itemsButtons.setOpaque(false);
                itemsButtons.add(toTop);
             
                itemsWrapper.add(items, BorderLayout.CENTER);
                itemsWrapper.add(itemsButtons, BorderLayout.SOUTH);

                
                JScrollPane scrollPane = new JScrollPane(itemsWrapper);
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
       // cartRight.setVisible(false);

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
    
    items.add(item);
    items.add(Box.createVerticalStrut(20));
    items.revalidate();
    items.repaint();



   }





}


class LeftTop extends MyGradient{
    
    
    
    public LeftTop(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super( startX,  startY ,  endX,  endY, degrees,  colors, arc);

        this.setLayout(new GridLayout());
        this.setOpaque(false);

    }
}


