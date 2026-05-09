package shop.ui.AdminWrapper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.ShopWindow.ShopWindow;


public class AdminSelection extends JPanel{

   

        
        private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        private float[] backgroundDegree={0.0f,1.0f};
    
        
        private float[] degrees = {0.0f, 0.7f, 1.0f};
        private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        
        private float[] topDegrees = {0.0f, 0.9f, 1.0f};
        private Color[] topColors ={Color.decode("#424242"),Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        
       
       
        
        
        public AdminSelection(ShopWindow shopWindow,AdminWrapper adminWrapper ){
    
            
    
            
            this.setLayout(new BorderLayout());
            this.setBackground(Color.decode("#111111"));
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));
    

            

                
            BaseWrapper baseWrapper=new BaseWrapper(0,0,0,getHeight(),backgroundDegree,backgroundColors,30);
            AdminBase adminBase = new AdminBase(0,0,0,getHeight(),degrees,colors,30);
    
    
    
    
    
            JPanel Bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
            Bottom.setBorder(new EmptyBorder(20,10,0,0));
            Bottom.setOpaque(false);
    
    
                    
                    PressableButton home = new PressableButton("#159069","#56b798",10);
                    home.setText("Home");
                    home.setPreferredSize(new Dimension(80,40));
                    home.addActionListener(e->{
                        shopWindow.showHomeWindow();
                        
                        revalidate();
                        repaint();
                    });
    
                    Bottom.add(home);
    
    
            JPanel topWrapper = new JPanel(new BorderLayout());
            topWrapper.setBorder(new EmptyBorder(50,50,20,50));
            topWrapper.setOpaque(false);
    
         
         
         
            Top top = new Top(0,0,0,getHeight(),topDegrees,topColors,30);
            
    
    
                    JPanel info = new JPanel();
                    info.setLayout(new BoxLayout(info , BoxLayout.Y_AXIS));
                    info.setOpaque(false);
    
         
                 
                    
                       
                    PressableButton addItem = new PressableButton("#159069","#56b798",30);
                    addItem.setText("Add item");
                    addItem.setPreferredSize(new Dimension(300 , 50 ));
                    addItem.setMaximumSize(new Dimension(300 , 50 ));
                    addItem.setMinimumSize(new Dimension(300 , 50 ));
                    addItem.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    addItem.addActionListener(e->{
                        adminWrapper.showAdminAddItem();
                    });
                    
                    
                    PressableButton addCategory = new PressableButton("#159069","#56b798",30);
                    addCategory.setText("Add category");
                    addCategory.setPreferredSize(new Dimension(300 , 50 ));
                    addCategory.setMaximumSize(new Dimension(300 , 50 ));
                    addCategory.setMinimumSize(new Dimension(300 , 50 ));
                    addCategory.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    addCategory.addActionListener(e->{
                        adminWrapper.showAdminAddCategory();
                    });

                    
                    PressableButton removeItem = new PressableButton("#159069","#56b798",30);
                    removeItem.setText("Remove item");
                    removeItem.setPreferredSize(new Dimension(300 , 50 ));
                    removeItem.setMaximumSize(new Dimension(300 , 50 ));
                    removeItem.setMinimumSize(new Dimension(300 , 50 ));
                    removeItem.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    removeItem.addActionListener(e->{
                        adminWrapper.showAdminRemoveItem();
                    });

                    
                    PressableButton removeCategory = new PressableButton("#159069","#56b798",30);
                    removeCategory.setText("Remove category");
                    removeCategory.setPreferredSize(new Dimension(300 , 50 ));
                    removeCategory.setMaximumSize(new Dimension(300 , 50 ));
                    removeCategory.setMinimumSize(new Dimension(300 , 50 ));
                    removeCategory.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    removeCategory.addActionListener(e->{
                        adminWrapper.showAdminRemoveCategory();
                    });


                    info.add(Box.createVerticalStrut(50));
                    
                    info.add(addItem);
                    info.add(Box.createVerticalStrut(10));
                    info.add(addCategory);
                    info.add(Box.createVerticalStrut(10));
                    info.add(removeItem);
                    info.add(Box.createVerticalStrut(10));
                    info.add(removeCategory);
                   
                    info.add(Box.createVerticalStrut(250));
                          
                  
             
            top.add(info,BorderLayout.CENTER);
    

            topWrapper.add(top, BorderLayout.CENTER);         
    
           
            adminBase.add(topWrapper , BorderLayout.CENTER);   
            adminBase.add(Bottom, BorderLayout.SOUTH);        
            baseWrapper.add(adminBase);
            this.add(baseWrapper, BorderLayout.CENTER);
    
    
    
            
    
        }
    
    
      
    
    }
    
    
    class BaseWrapper extends MyGradient{
    
        public BaseWrapper(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
            
            super(startX, startY , endX, endY, degrees, colors, arc);
            
            this.setLayout(new  GridBagLayout());
            this.setBackground(Color.decode("#111111"));
            
            
    
    
        }
    
    }
    
    class AdminBase extends MyGradient{
        
        public AdminBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
            
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
    