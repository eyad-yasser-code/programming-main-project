


//main package 
package shop.ui.CartWindow;



//my imports
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.*;
import shop.ui.ShopWindow.ShopWindow;
import shop.ui.Helper.ModifiedScroll;

//main imports
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CartWindow extends JPanel{
    

    
    private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    private float[] backgroundDegree={0.0f,1.0f};


    
    private float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
    

    
    private float[] paymentDegrees = {0.0f, 0.5f, 1.0f};
    private Color[] paymentColors ={Color.decode("#636363"),Color.decode("#474747"),Color.decode("#1c1c1c")};
    


    
    private float[] rightDegrees = {0.0f, 0.4f, 1.0f};
    private Color[] rightColors ={Color.decode("#1c1c1c"),Color.decode("#313131"),Color.decode("#313131")};
    




    
    private JPanel items;
    private JScrollPane scrollPane;

    private ArrayList<CartEntry> cart;



    public CartWindow(ShopWindow shopWindow){


        
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#111111"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));

      


        cart = new ArrayList<CartEntry>();



       
        BaseWrapper baseWrapper=new BaseWrapper(0,0,0,getHeight(),backgroundDegree,backgroundColors,30);
       
       
        CartBase cartBase = new CartBase(0,0,0,getHeight(),degrees,colors,30);
        
        
        JPanel paddingWrapper = new JPanel(new BorderLayout());
        paddingWrapper.setBorder(new EmptyBorder(20,20,20,20));
        paddingWrapper.setOpaque(false);


        JPanel innerWrapper = new JPanel();
        innerWrapper.setLayout(new BorderLayout());
        innerWrapper.setBackground(Color.BLACK);
        innerWrapper.setOpaque(false);
        innerWrapper.setBorder(new EmptyBorder(20,20,20,20));


        



      
        JPanel cartLeft = new JPanel(new BorderLayout());
        cartLeft.setOpaque(false);
        

           
        
            JPanel leftBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
            leftBottom.setPreferredSize(new Dimension(600,65));
            leftBottom.setBorder(new EmptyBorder(20,10,0,0));
            leftBottom.setOpaque(false);



                PressableButton back = new PressableButton("#159069","#56b798",10);
                back.setText("back");
                back.setPreferredSize(new Dimension(80,40));
                back.addActionListener(e->{
                    shopWindow.showHomeWindow();
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

                
                scrollPane = new JScrollPane(itemsWrapper);
                scrollPane.setWheelScrollingEnabled(true);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setBorder(null);
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
                scrollPane.getVerticalScrollBar().setUI(new ModifiedScroll());
                scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15,0));
               
           
               
                toTop.addActionListener(e->{
                    defaultCartScroll();
                });
                



            leftTop.add(scrollPane, BorderLayout.CENTER);
           


       
            
        cartLeft.add(leftTop, BorderLayout.CENTER);
        cartLeft.add(leftBottom, BorderLayout.SOUTH);




        JPanel cartRight = new JPanel(new BorderLayout());
        cartRight.setPreferredSize(new Dimension(300 , 600));
        cartRight.setOpaque(false);

        JPanel checkoutBase = new JPanel(new BorderLayout());
        checkoutBase.setPreferredSize(new Dimension(300 , 65));
        checkoutBase.setOpaque(false);


                JPanel checkoutWrapper = new JPanel(new BorderLayout());
                checkoutWrapper.setBorder(new EmptyBorder(0,30,20,30));
                checkoutWrapper.setOpaque(false);

                PressableButton checkout = new PressableButton("#159069","#56b798",10);
                checkout.setText("Check Out");
                checkout.setPreferredSize(new Dimension(250,50));
                checkout.setMaximumSize(new Dimension(250,50));
                checkout.setMinimumSize(new Dimension(250,50));
                checkout.setAlignmentX(Component.CENTER_ALIGNMENT);

                checkout.addActionListener(e->{

                    shopWindow.showCheckoutWindow();

                });



                checkoutWrapper.add(checkout,  BorderLayout.CENTER);


        checkoutBase.add(checkoutWrapper, BorderLayout.CENTER);





      
      
      
      
        PaymentBase paymentBase = new PaymentBase(0,0,0,getHeight(),rightDegrees,rightColors,30);
        
        
        JPanel paymentWrapper = new JPanel(new BorderLayout());
        paymentWrapper.setBorder(new EmptyBorder(20,20,100,20));
        paymentWrapper.setOpaque(false);

       
       
        PaymentBase paymentinner = new PaymentBase(0,0,0,getHeight(),paymentDegrees,paymentColors,30);
               
        
        paymentWrapper.add(paymentinner,BorderLayout.CENTER);


        paymentBase.add(paymentWrapper);


        JPanel payBWrapper = new JPanel();
        payBWrapper.setLayout(new BoxLayout(payBWrapper,BoxLayout.Y_AXIS));
        payBWrapper.setOpaque(false);

        PressableButton cash = new PressableButton("#313131","#6e6e6e",10);
        cash.setText("Cash On Delivery");
        cash.setPreferredSize(new Dimension(250,40));
        cash.setMaximumSize(new Dimension(250,40));
        cash.setMinimumSize(new Dimension(250,40));
        cash.setAlignmentX(Component.CENTER_ALIGNMENT);

        PressableButton credit = new PressableButton("#313131","#6e6e6e",10);
        credit.setText("Credit Card");
        credit.setPreferredSize(new Dimension(250,40));
        credit.setMaximumSize(new Dimension(250,40));
        credit.setMinimumSize(new Dimension(250,40));
        credit.setAlignmentX(Component.CENTER_ALIGNMENT);

        payBWrapper.add(Box.createVerticalStrut(10));
        payBWrapper.add(cash);
        payBWrapper.add(Box.createVerticalStrut(10));
        payBWrapper.add(credit);


       paymentWrapper.add(payBWrapper);         


        
        

        cartRight.add(paymentBase,BorderLayout.CENTER);
        cartRight.add(checkoutBase,BorderLayout.SOUTH);

        innerWrapper.add(cartLeft, BorderLayout.CENTER);
        innerWrapper.add(cartRight, BorderLayout.EAST);
       
        paddingWrapper.add(innerWrapper,BorderLayout.CENTER);
        cartBase.add(paddingWrapper,BorderLayout.CENTER);
        baseWrapper.add(cartBase); 
        
        this.add(baseWrapper, BorderLayout.CENTER);


     
    }


    //add cartEntry

    public void addToCart(Product product){

        for(CartEntry entry : cart){
            if(entry.getProduct().getId()== product.getId()){
                entry.increase();
                refreshUI();
                return;
            }
           
        }
        cart.add(new CartEntry(product));
       
        refreshUI();


    }

    public void removeFromCart(int id){

       
            cart.removeIf(entry -> entry.getProduct().getId()==id);
        
        refreshUI();

    }



    //refresh UI :remove everything then add the arraylist cart as it is with everychange i did 

    public void refreshUI(){

        items.removeAll();
        for(CartEntry entry : cart){
            items.add(new CartItem(entry,this));
            items.add(Box.createVerticalStrut(20));
        }
        items.revalidate();
        items.repaint();



    }





   //scrollpane

    public void defaultCartScroll(){
    this.scrollPane.getVerticalScrollBar().setValue(0);
   }




   public ArrayList<CartEntry> getCart(){ return new ArrayList<>(cart); }



}



class BaseWrapper extends MyGradient{

    public BaseWrapper(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);
        
        this.setLayout(new  GridBagLayout());
        this.setBackground(Color.decode("#111111"));
        
        


    }

}

class CartBase extends MyGradient{
    
    public CartBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000,650));
        this.setBackground(Color.decode("#111111"));
       
    }

}



class LeftTop extends MyGradient{
    
    
    
    public LeftTop(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new GridLayout());
        this.setOpaque(false);

    }
}


class PaymentBase extends MyGradient{

    
    public PaymentBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new GridLayout());
        this.setOpaque(false);

    }

}