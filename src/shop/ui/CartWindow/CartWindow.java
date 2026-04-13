


//main package 
package shop.ui.CartWindow;


//my imports
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.ShopWindow.ShopWindow;

//main imports
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CartWindow extends JPanel{
    

    private JPanel items;
    private JScrollPane scrollPane;

    
    private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    private float[] backgroundDegree={0.0f,1.0f};


    
    private float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
    

    


    public CartWindow(ShopWindow shopWindow){


    
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#111111"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));

      
       
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
                toTop.addActionListener(e->{
                    defaultCartScroll();
                });
           

            leftTop.add(scrollPane, BorderLayout.CENTER);
           


       
            
        cartLeft.add(leftTop, BorderLayout.CENTER);
        cartLeft.add(leftBottom, BorderLayout.SOUTH);





        JPanel cartRight = new JPanel(new BorderLayout());
        cartRight.setPreferredSize(new Dimension(300 , 600));
        cartRight.setBackground(Color.decode("#505050"));
      
         innerWrapper.add(cartLeft, BorderLayout.CENTER);
            innerWrapper.add(cartRight, BorderLayout.EAST);






        paddingWrapper.add(innerWrapper,BorderLayout.CENTER);
        cartBase.add(paddingWrapper,BorderLayout.CENTER);
        baseWrapper.add(cartBase); 
        this.add(baseWrapper, BorderLayout.CENTER);


        
        for(int i = 0 ; i < 20 ; i++){ 
            addItem();
          
        }
     
    

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

   //scrollpane

    public void defaultCartScroll(){
    this.scrollPane.getVerticalScrollBar().setValue(0);
   }


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


