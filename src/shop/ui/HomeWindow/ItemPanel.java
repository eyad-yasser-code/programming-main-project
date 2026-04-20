




//main package
package shop.ui.HomeWindow;

//my packages imports
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.*;
import shop.ui.MainWindow.MiddleView;
import shop.ui.Helper.ImageLabel;


// main imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.*;







public class ItemPanel extends JPanel{
   
   
   float fractions[]={0.0f,0.4f,1.0f};
   Color colors[]={Color.decode("#1d1f1d"),Color.decode("#1d1f1d"), Color.decode("#373737")};
   
   @Override
   protected void paintComponent(Graphics g){
        
    super.paintComponent(g);

    Graphics2D g2D = (Graphics2D)g;
    LinearGradientPaint linerG = new LinearGradientPaint(0,0,getWidth(),getHeight(), fractions,colors);

    g2D.setPaint(linerG);
    g2D.fillRoundRect(0 , 0 , getWidth(),getHeight(),30,30);
    
    }


    private Product product;


    public ItemPanel(Product product,MiddleView middleView){

       
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200,350));
        this.setMaximumSize(new Dimension(200,350));
        this.setMinimumSize(new Dimension(200,350));
        this.setOpaque(false);
        

        this.product=product;


    
        //image section

        JPanel imagPanel = new JPanel(new BorderLayout()){
            
            @Override 
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D)g;

                g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                Shape clip = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),30,30);
                g2D.setClip(clip);

                g2D.setColor(getBackground());
                g2D.fillRoundRect(0,0, getWidth(),getHeight(), 30, 30);

               
            }

        };
        imagPanel.setOpaque(false);
        imagPanel.setPreferredSize(new Dimension(0,300));
        imagPanel.setBackground(Color.WHITE);
  
  
        ImageLabel imagLabel = new ImageLabel("/images/",product.getImageName());
        imagLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    

        imagPanel.add(imagLabel, BorderLayout.CENTER);

     
        
        //text section
        
        
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(new EmptyBorder(5,20,0,0));



        JPanel textPanel = new JPanel();
      
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        
        

        
      
       

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Arial",Font.BOLD,12));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
       

        JLabel descriptionLabel = new JLabel("<html>" + product.getDescription() + "<html>");
        descriptionLabel.setPreferredSize(new Dimension(180,50));
        descriptionLabel.setFont(new Font("Arial",Font.PLAIN,10));
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
      
      
        JLabel priceLabel = new JLabel( product.getPrice() + " EGP");
        priceLabel.setFont(new Font("Arial",Font.BOLD,16));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

       



        textPanel.add(nameLabel);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(descriptionLabel);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(priceLabel);
        textPanel.add(Box.createVerticalStrut(15));

        wrapper.add(textPanel, BorderLayout.WEST);
   
        //buttons section


        JPanel buttonWrapper = new JPanel(new BorderLayout()){
           
          

        };
        buttonWrapper.setMaximumSize(new Dimension(120,40));
        buttonWrapper.setOpaque(false);


        PressableButton cartAdd = new PressableButton("#159069","#56b798",10);
        cartAdd.setText("Add to cart");
        cartAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartAdd.setPreferredSize(new Dimension(120, 40));
       
   
        cartAdd.addActionListener(e -> {
           

            middleView.addToCart(product);

        });

        buttonWrapper.add(cartAdd, BorderLayout.CENTER);


       
        this.add(imagPanel);
        this.add(Box.createVerticalStrut(10));
        this.add(wrapper);
        this.add(Box.createVerticalStrut(15));
        this.add(buttonWrapper);
        this.add(Box.createVerticalStrut(5));
      

    

    }


    public Product getProduct(){
        return product;
    }





}
