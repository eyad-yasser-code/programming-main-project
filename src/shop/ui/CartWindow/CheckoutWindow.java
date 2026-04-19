




//main package;

package shop.ui.CartWindow;

import shop.ui.Helper.ModifiedScroll;
//my imports
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.CartEntry;
import shop.ui.ShopWindow.ShopWindow;

//main imports
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class CheckoutWindow extends JPanel{


    private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    private float[] backgroundDegree={0.0f,1.0f};

    
    private float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
    
   
    
    
    
    private JPanel items;
    private JScrollPane scrollPane;
    

    private JLabel totalPrice;

    
    public CheckoutWindow(ShopWindow shopWindow,CartWindow cartWindow){


        
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#111111"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));

            
        BaseWrapper baseWrapper=new BaseWrapper(0,0,0,getHeight(),backgroundDegree,backgroundColors,30);
       

        CheckoutBase checkoutBase = new CheckoutBase(0,0,0,getHeight(),degrees,colors,30);




        JPanel bottomWrapper = new JPanel(new BorderLayout());
        bottomWrapper.setOpaque(false);
        bottomWrapper.setPreferredSize(new Dimension(0,120));



        totalPrice = new JLabel();
        
        totalPrice.setBorder(new EmptyBorder(0,0,5,0));
        totalPrice.setOpaque(false);
        totalPrice.setForeground(Color.WHITE);
        totalPrice.setFont(new Font("Arial",Font.BOLD,20));
        

        bottomWrapper.add(totalPrice,BorderLayout.NORTH);
    


        JPanel Bottom = new JPanel(new FlowLayout());
        Bottom.setPreferredSize(new Dimension(40,50));
        
        Bottom.setOpaque(false);


                
                PressableButton back = new PressableButton("#159069","#56b798",10);
                back.setText("Back");
                back.setPreferredSize(new Dimension(80,40));
                back.addActionListener(e->{
                    shopWindow.showCartWindow();
                    
                    revalidate();
                    repaint();
                });

                
                
                PressableButton confirm = new PressableButton("#159069","#56b798",10);
             
                   
                confirm.setText("Confirm");
                confirm.setPreferredSize(new Dimension(300 , 40 ));
                confirm.setMaximumSize(new Dimension(300 , 40 ));
                confirm.setMinimumSize(new Dimension(300 , 40 ));
                confirm.setAlignmentX(Component.CENTER_ALIGNMENT); 
                confirm.addActionListener(e->{

                });



                Bottom.add(back);
                Bottom.add(confirm);


        bottomWrapper.add(Bottom,BorderLayout.CENTER);        


        JPanel topWrapper = new JPanel(new BorderLayout());
       
        topWrapper.setOpaque(false);

       
            JPanel itemsWrapper = new JPanel(new BorderLayout());
            itemsWrapper.setOpaque(false); 
            

            items = new JPanel();
            items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
            items.setOpaque(false);
            items.setAlignmentX(Component.CENTER_ALIGNMENT);




                
                itemsWrapper.add(items, BorderLayout.CENTER);
                itemsWrapper.setBorder(new EmptyBorder(0,50,20,50));

                
                scrollPane = new JScrollPane(itemsWrapper);
                scrollPane.setWheelScrollingEnabled(true);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setBorder(null);
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
                scrollPane.getVerticalScrollBar().setUI(new ModifiedScroll());
                scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15,0));
               
           
               


                topWrapper.add(scrollPane, BorderLayout.CENTER);
           


       
         
                

       
        checkoutBase.add(topWrapper , BorderLayout.CENTER);   
        checkoutBase.add(bottomWrapper, BorderLayout.SOUTH);        
        baseWrapper.add(checkoutBase);
        this.add(baseWrapper, BorderLayout.CENTER);



        

    }

    public void defaultCartScroll(){
        this.scrollPane.getVerticalScrollBar().setValue(0);
       }
    





    public void loadCheckout(   ArrayList<CartEntry> cart){

        items.removeAll();
        double sum =0 ; 

        for(CartEntry entry : cart ){


            double itemTotalPrice = entry.getQuantity()*entry.getProduct().getPrice();

            JPanel item = new JPanel(new BorderLayout());
            item.setPreferredSize(new Dimension(0,100));
            item.setMaximumSize(new Dimension(Integer.MAX_VALUE,100));
            item.setMinimumSize(new Dimension(Integer.MIN_VALUE,100));
            item.setOpaque(false);


            namePriceBase nameBase = new namePriceBase(0, 0, 0, getHeight(), degrees, colors,10);
            nameBase.setPreferredSize(new Dimension(230,0));

                JLabel nameQuantity = new JLabel();
                nameQuantity.setText("  "+entry.getProduct().getName()+"    x"+entry.getQuantity());
                nameQuantity.setBorder(new EmptyBorder(0,0,5,0));
                nameQuantity.setForeground(Color.WHITE);
                nameQuantity.setOpaque(false);
                nameQuantity.setFont(new Font("Arial",Font.BOLD,14));

            nameBase.add(nameQuantity, BorderLayout.SOUTH);    



            namePriceBase priceBase = new namePriceBase(0, 0, 0, getHeight(), degrees, colors,10);
            priceBase.setPreferredSize(new Dimension(150,0));

                JLabel price = new JLabel();
                price.setText(String.valueOf("   "+itemTotalPrice+" EGP"));
                price.setBorder(new EmptyBorder(0,0,5,0));
                price.setOpaque(false);
                price.setForeground(Color.WHITE);
                price.setFont(new Font("Arial",Font.BOLD,14));
                
            priceBase.add(price,BorderLayout.SOUTH);  
              
              
                item.add(nameBase,BorderLayout.WEST);
                item.add(priceBase, BorderLayout.EAST);    


    
            items.add(item);
            sum += itemTotalPrice;

        }
        totalPrice.setText(String.format("         Total: %.2f EGP",sum));
        items.revalidate();
        items.repaint();
      
    }

}


class BaseWrapper extends MyGradient{

    public BaseWrapper(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);
        
        this.setLayout(new  GridBagLayout());
        this.setBackground(Color.decode("#111111"));
        
        


    }

}

class CheckoutBase extends MyGradient{
    
    public CheckoutBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500,650));
        this.setBackground(Color.decode("#111111"));
       
    }

}

class Top extends MyGradient{
    
    
    
    public Top(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        this.setOpaque(false);

    }
}

class namePriceBase extends MyGradient{
   
    public namePriceBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        
    }

}