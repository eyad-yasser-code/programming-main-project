//main packages
package shop.ui.CartWindow;


//my imports 

import shop.ui.Helper.ImageLabel;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.Product;

//main imports

import javax.swing.*;
import javax.swing.border.EmptyBorder;



import java.awt.*;



public class CartItem extends JPanel{


    private Color[] picColor = {Color.WHITE,Color.WHITE};
    private float[] picFloat = {0.0f,1.0f};

    private Color[] infoColor = {Color.decode("#4a806f"),Color.decode("#4a806f")};
    private float[] infoFloat = {0.0f, 1.0f};

    public CartItem(Product product){

        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        this.setPreferredSize(new Dimension(0, 150));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setOpaque(false);
       
       
        JPanel base = new JPanel(new BorderLayout(20,5));
        base.setPreferredSize(new Dimension(700 , 150 ));
        base.setBorder(new EmptyBorder(0,25,0,20));
        base.setOpaque(false);



            ItemPic itemPic = new ItemPic(0,0,0,getHeight(),picFloat,picColor,30,product);
         
           
            ItemInfo itemInfo = new ItemInfo(0,0,0,getHeight(),infoFloat,infoColor,30,product);
           
           
            
            JPanel itemInfoJPaneWrapper = new JPanel(new BorderLayout());
            itemInfoJPaneWrapper.setBorder(new EmptyBorder(10,0,0,10));
            itemInfoJPaneWrapper.setOpaque(false);


                JPanel itemInfoTop = new JPanel(new BorderLayout());
                 itemInfoTop.setOpaque(false);


                    JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    deletePanel.setPreferredSize(new Dimension(40,50));
                    deletePanel.setOpaque(false);

                    
                        PressableButton remove = new PressableButton("#313131","#6e6e6e",10);
                        remove.setText("x");
                        remove.setPreferredSize(new Dimension(40,30));
                        remove.setMaximumSize(new Dimension(40,30));
                        remove.setMinimumSize(new Dimension(40,30));
                        remove.setFont(new Font("Arial",Font.BOLD,10));
                        remove.addActionListener(e->{

                            
                        });

                    deletePanel.add(remove);
               
                  itemInfoTop.add(deletePanel,BorderLayout.CENTER);        
                    

                JPanel itemInfoBottom = new JPanel(new BorderLayout());
                itemInfoBottom.setOpaque(false);


              itemInfoJPaneWrapper.add(itemInfoTop, BorderLayout.NORTH);
            //itemInfoJPaneWrapper.add(itemInfoBottom, BorderLayout.SOUTH);
        itemInfo.add(itemInfoJPaneWrapper,BorderLayout.CENTER);
        
        base.add(itemPic, BorderLayout.WEST);
        base.add(itemInfo, BorderLayout.CENTER);



        this.add(base, BorderLayout.CENTER);

    }
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