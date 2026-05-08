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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shop.ui.LogicHelper.*;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.MyText;
import shop.ui.Helper.PressableButton;
import shop.ui.ShopWindow.ShopWindow;



public class AdminRemoveCategory extends JPanel{

   

        
        private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        private float[] backgroundDegree={0.0f,1.0f};
    
        
        private float[] degrees = {0.0f, 0.7f, 1.0f};
        private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        
        private float[] topDegrees = {0.0f, 0.9f, 1.0f};
        private Color[] topColors ={Color.decode("#424242"),Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        
        private float[] textFloats = {0.0f,1.0f};
        private Color[] textColors = {Color.decode("#222222"),Color.decode("#222222")};
    
        
      
        private MyText categoryIdField;
       
       
        
        
        public AdminRemoveCategory(ShopWindow shopWindow,AdminWrapper adminWrapper ){
    
            
    
            
            this.setLayout(new BorderLayout());
            this.setBackground(Color.decode("#111111"));
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));
    

            

                
            BaseWrapper baseWrapper=new BaseWrapper(0,0,0,getHeight(),backgroundDegree,backgroundColors,30);
            AdminBase adminBase = new AdminBase(0,0,0,getHeight(),degrees,colors,30);
    
    
    
    
    
            JPanel Bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
            Bottom.setBorder(new EmptyBorder(20,10,0,0));
            Bottom.setOpaque(false);
    
    
                    
                    PressableButton back = new PressableButton("#159069","#56b798",10);
                    back.setText("Back");
                    back.setPreferredSize(new Dimension(80,40));
                    back.addActionListener(e->{
                        adminWrapper.showAdminSelection();
                        
                        revalidate();
                        repaint();
                    });
    
                    Bottom.add(back);
    
    
            JPanel topWrapper = new JPanel(new BorderLayout());
            topWrapper.setBorder(new EmptyBorder(50,50,20,50));
            topWrapper.setOpaque(false);
    
         
         
         
            Top top = new Top(0,0,0,getHeight(),topDegrees,topColors,30);
            
    
    
                    JPanel info = new JPanel();
                    info.setLayout(new BoxLayout(info , BoxLayout.Y_AXIS));
                    info.setOpaque(false);
    
         
                    


                    categoryIdField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Category Id",false);
                    categoryIdField.setPreferredSize(new Dimension(300 , 50 ));
                    categoryIdField.setMaximumSize(new Dimension(300 , 50 ));
                    categoryIdField.setMinimumSize(new Dimension(300 , 50 ));
                    categoryIdField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                   


                    
                    PressableButton confirm = new PressableButton("#159069","#56b798",10);
                    confirm.setText("confirm");
                    confirm.setPreferredSize(new Dimension(300 , 50 ));
                    confirm.setMaximumSize(new Dimension(300 , 50 ));
                    confirm.setMinimumSize(new Dimension(300 , 50 ));
                    confirm.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    

                    confirm.addActionListener(e->{
                        


                     
                        try {


                            
                            int categoryId = Integer.parseInt(categoryIdField.getText());
                           
                            boolean found = false;
                           

                            for(Category test : shopWindow.getAllCategories()){
                               
                                if(test.getId()==categoryId){
                                  
                                    found = true;
                                    
                                    break;
    
                                }
    
    
                            }
    
                            if(found){
    
    
                                shopWindow.removeCategory(categoryId);
                                JOptionPane.showMessageDialog(this, "removed successfully");
                                resetText();
                                return;
                              
    
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "not found");
                                resetText();
                            }
                        
                        
                        
                        } catch(NumberFormatException ex) {
                        
                            JOptionPane.showMessageDialog(this,"Please enter valid numbers","WARNING",JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                   


                    });
                    
                       
              
                    info.add(Box.createVerticalStrut(50));
                    
                  
                    info.add(categoryIdField);
                   
                    info.add(Box.createVerticalStrut(10));
                    info.add(confirm);

                    info.add(Box.createVerticalStrut(250));
                          
                  
             
            top.add(info,BorderLayout.CENTER);
    

            topWrapper.add(top, BorderLayout.CENTER);         
    
           
            adminBase.add(topWrapper , BorderLayout.CENTER);   
            adminBase.add(Bottom, BorderLayout.SOUTH);        
            baseWrapper.add(adminBase);
            this.add(baseWrapper, BorderLayout.CENTER);
    
    
    
            
    
        }
    
    
        public void resetText(){
          
            categoryIdField.resetText();
            
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
