package shop.ui.AdminWrapper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import shop.ui.Helper.MyText;
import shop.ui.Helper.PressableButton;
import shop.ui.ShopWindow.ShopWindow;


public class AdminConfirmation extends JPanel{

   

        
        private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        private float[] backgroundDegree={0.0f,1.0f};
    
        
        private float[] degrees = {0.0f, 0.7f, 1.0f};
        private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        
        private float[] topDegrees = {0.0f, 0.9f, 1.0f};
        private Color[] topColors ={Color.decode("#424242"),Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        
        private float[] textFloats = {0.0f,1.0f};
        private Color[] textColors = {Color.decode("#222222"),Color.decode("#222222")};
    
        
      
        private MyText confirmationField;
        private String confirmatinCode;
        
        
        
        public AdminConfirmation(ShopWindow shopWindow,AdminWrapper adminWrapper ){
    
    
            
            this.setLayout(new BorderLayout());
            this.setBackground(Color.decode("#111111"));
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));
    

            this.confirmatinCode="123";

                
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
    
         
                    
                       confirmationField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"confirmation code",true);
                       confirmationField.setPreferredSize(new Dimension(300 , 50 ));
                       confirmationField.setMaximumSize(new Dimension(300 , 50 ));
                       confirmationField.setMinimumSize(new Dimension(300 , 50 ));
                       confirmationField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                       
                       
                       
                       PressableButton confirm = new PressableButton("#159069","#56b798",10);
                       confirm.setText("confirm");
                       confirm.setPreferredSize(new Dimension(300 , 50 ));
                       confirm.setMaximumSize(new Dimension(300 , 50 ));
                       confirm.setMinimumSize(new Dimension(300 , 50 ));
                       confirm.setAlignmentX(Component.CENTER_ALIGNMENT); 
                       

                       confirm.addActionListener(e->{
                           

                           if(confirmationField.getText().equals(confirmatinCode)){
                           adminWrapper.showAdminSelection();
                           revalidate();
                           repaint();
                           }

                           else {
                               JOptionPane.showMessageDialog(this,"Wrong Code","confirmation", JOptionPane.ERROR_MESSAGE);
                               confirmationField.resetText();
                           }
                           


                       });
                     
                       
              
                    info.add(Box.createVerticalStrut(50));
                    info.add(confirmationField);
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
            confirmationField.resetText();
        }
    
    
    
    }
    
