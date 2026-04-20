




//main package
package shop.ui.HomeWindow;

//my packages imports
import shop.ui.Helper.PressableButton;
import shop.ui.Helper.ImageLabel;
import shop.ui.MainWindow.MainWindow;
import shop.ui.LogicHelper.*;

// main imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;








public class CategoryPanel extends JPanel{
   
    private MainWindow mainWindow;



    private Category category;
    

    public CategoryPanel(Category category, MainWindow mainWindow){

       
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200,50));
        this.setOpaque(false);
        

    
        setCategory(category);




        this.mainWindow=mainWindow;
    
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
  
  
        ImageLabel imagLabel = new ImageLabel("/images/",category.getImageName());
        imagLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagPanel.add(imagLabel, BorderLayout.CENTER);

     
        
        //text section
        
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(new EmptyBorder(5,65,0,0));



        JLabel nameLabel = new JLabel(category.getName());
        nameLabel.setFont(new Font("Arial",Font.BOLD,14));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
      
      
        wrapper.add(nameLabel, BorderLayout.CENTER);
   
        //buttons section


        JPanel buttonWrapper = new JPanel(new BorderLayout()){
           
          

        };
        buttonWrapper.setMaximumSize(new Dimension(120,40));
        buttonWrapper.setOpaque(false);


        PressableButton select = new PressableButton("#159069","#56b798",10);
        select.setText("Select");
        select.setAlignmentX(Component.CENTER_ALIGNMENT);
        select.setPreferredSize(new Dimension(120, 40));
       
        
            
        
                select.addActionListener(e -> {
                
                
                
                    System.out.println(category.getName() + "selected");
                    
                    ArrayList<Product> filtered = new ArrayList<>();

                    for(Product test : mainWindow.getAllProducts()){

                        if(test.getCategoryId() == category.getId()){

                            filtered.add(test);

                        }

                    }
                 
                 
                    mainWindow.showFilteredProducts(filtered);
                 
                 
                    this.mainWindow.defaultScroll();
                    this.mainWindow.showItemsHolder();
                    
                    
                });

       
       
       
       
                buttonWrapper.add(select, BorderLayout.CENTER);


       
        this.add(imagPanel);
        this.add(Box.createVerticalStrut(10));
        this.add(wrapper);
        this.add(Box.createVerticalStrut(15));
        this.add(buttonWrapper);
        this.add(Box.createVerticalStrut(5));
      

    

    }


   
    //setters 
    public void setCategory(Category category){this.category = category;}


    //getters
  
    public Category getCategory(){return category; }






    
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


}
