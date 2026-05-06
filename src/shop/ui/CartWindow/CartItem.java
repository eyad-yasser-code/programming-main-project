package shop.ui.CartWindow;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Helper.ImageLabel;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.*;


public class CartItem extends JPanel{


    private Color[] picColor = {Color.WHITE,Color.WHITE};
    private float[] picFloat = {0.0f,1.0f};

    private Color[] infoColor = {Color.decode("#4a806f"),Color.decode("#4a806f")};
    private float[] infoFloat = {0.0f, 1.0f};

    private Color[] buttonsBackColors = {Color.decode("#313131"),Color.decode("#313131")};
    private float[] buttonsBackFloats = {0.0f, 1.0f};
  
    private CartEntry entry;

   
    public CartItem(CartEntry entry,CartWindow cartWindow){

        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        this.setPreferredSize(new Dimension(0, 150));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setOpaque(false);
       
        this.entry = entry;
    
      


       
        JPanel base = new JPanel(new BorderLayout(20,5));
        base.setPreferredSize(new Dimension(700 , 150 ));
        base.setBorder(new EmptyBorder(0,25,0,20));
        base.setOpaque(false);



            ItemPic itemPic = new ItemPic(0,0,0,getHeight(),picFloat,picColor,30,entry.getProduct());
         
           
            ItemInfo itemInfo = new ItemInfo(0,0,0,getHeight(),infoFloat,infoColor,30,entry.getProduct());
           
           
            
            JPanel itemInfoJPaneWrapper = new JPanel(new BorderLayout());
            itemInfoJPaneWrapper.setBorder(new EmptyBorder(10,10,10,10));
            itemInfoJPaneWrapper.setOpaque(false);


                JPanel itemInfoButtons = new JPanel(new BorderLayout());
                itemInfoButtons.setOpaque(false);



                    JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    deletePanel.setPreferredSize(new Dimension(40,50)); // for height
                    deletePanel.setOpaque(false);

                    
                        PressableButton remove = new PressableButton("#313131","#6e6e6e",10);
                        remove.setText("x");
                        remove.setPreferredSize(new Dimension(40,30));
                        remove.setMaximumSize(new Dimension(40,30));
                        remove.setMinimumSize(new Dimension(40,30));
                        remove.setFont(new Font("Arial",Font.BOLD,10));
                        remove.addActionListener(e->{

                            cartWindow.removeFromCart(entry.getProduct().getId());
                        });

                    deletePanel.add(remove);
               
                           
                    
                    
                    ItemQuantityButtons quantityPanel = new ItemQuantityButtons(0,0,0,getHeight(),buttonsBackFloats,buttonsBackColors,10);
                  

                        PressableButton increase = new PressableButton("#313131","#6e6e6e",10);
                        increase.setText("+");
                        increase.setPreferredSize(new Dimension(40,30));
                        increase.setMaximumSize(new Dimension(40,30));
                        increase.setMinimumSize(new Dimension(40,30));
                        increase.setFont(new Font("Arial",Font.BOLD,10));
                        increase.addActionListener(e->{
                            entry.increase();
                            cartWindow.refreshUI();
                        });

                        
            
                        PressableButton decrease = new PressableButton("#313131","#6e6e6e",10);
                        decrease.setText("-");
                        decrease.setPreferredSize(new Dimension(40,30));
                        decrease.setMaximumSize(new Dimension(40,30));
                        decrease.setMinimumSize(new Dimension(40,30));
                        decrease.setFont(new Font("Arial",Font.BOLD,14));
                        decrease.addActionListener(e->{
                            entry.decrease();
                            cartWindow.refreshUI();
                        });

                      
            
                        JLabel quantityLabel = new JLabel();
                        quantityLabel.setText(String.valueOf(entry.getQuantity()));
                        quantityLabel.setOpaque(false);
                        quantityLabel.setForeground(Color.WHITE);
                        quantityLabel.setFont(new Font ("Arial",Font.BOLD,10));

                       
                        quantityPanel.add(decrease);
                        quantityPanel.add(quantityLabel);
                        quantityPanel.add(increase);


                itemInfoButtons.add(deletePanel,BorderLayout.NORTH);        
                itemInfoButtons.add(quantityPanel, BorderLayout.SOUTH);    

                JPanel itemInfoText = new JPanel(new BorderLayout());
                itemInfoText.setOpaque(false);        


                        JPanel textTop = new JPanel(new BorderLayout());
                        textTop.setOpaque(false);
                        
                        JLabel name = new JLabel();
                        name.setText(entry.getProduct().getName());
                        name.setOpaque(false);
                        name.setForeground(Color.WHITE);
                        name.setFont(new Font ("Arial",Font.BOLD,15));

                        textTop.add(name,BorderLayout.CENTER);


                        JPanel textCenter = new JPanel(new BorderLayout());
                        textCenter.setOpaque(false);
                        
                        JLabel description = new JLabel();
                        description.setText("<html>" + entry.getProduct().getDescription() + "</html>");
                        description.setOpaque(false);
                        description.setForeground(Color.WHITE);
                        description.setFont(new Font ("Arial",Font.PLAIN,12));

                        textCenter.add(description,BorderLayout.NORTH);


                        JPanel textBottom = new JPanel(new BorderLayout());
                        textBottom.setOpaque(false);
                        
                        JLabel price = new JLabel();
                        price.setText(String.valueOf(entry.getProduct().getPrice()+" L.E."));
                        price.setOpaque(false);
                        price.setForeground(Color.WHITE);
                        price.setFont(new Font ("Arial",Font.BOLD,20));

                        textBottom.add(price,BorderLayout.CENTER);
               
               
                itemInfoText.add(textTop,BorderLayout.NORTH);        
                itemInfoText.add(textCenter,BorderLayout.CENTER);        
                itemInfoText.add(textBottom,BorderLayout.SOUTH);        




              itemInfoJPaneWrapper.add(itemInfoText, BorderLayout.CENTER);          
              itemInfoJPaneWrapper.add(itemInfoButtons, BorderLayout.EAST);

              itemInfo.add(itemInfoJPaneWrapper,BorderLayout.CENTER);
        

        base.add(itemPic, BorderLayout.WEST);
        base.add(itemInfo, BorderLayout.CENTER);



        this.add(base, BorderLayout.CENTER);

    }



  

    //getters 
    public Product getProduct(){return entry.getProduct();}


}



class ItemPic extends MyGradient{
    
    
    
    private ImageLabel imageLabel;


    
    public ItemPic(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc,Product product){
    
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150,150));
        this.setOpaque(false);

        imageLabel = new ImageLabel("/images/",product.getImageName());

       
        this.add(imageLabel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }



}

class ItemInfo extends MyGradient{
    public ItemInfo(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc,Product product){
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new GridLayout());
        this.setPreferredSize(new Dimension(150,150));

    }

}


class ItemQuantityButtons extends MyGradient{

    public ItemQuantityButtons(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        super(startX, startY , endX, endY, degrees, colors, arc);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        this.setPreferredSize(new Dimension(120,30)); // for width
        this.setOpaque(false);

    }



}