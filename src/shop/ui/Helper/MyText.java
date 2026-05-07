

//main package
package shop.ui.Helper;





// main imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.*;


public class MyText extends MyGradient{
    private boolean isUserTyping = true;
   
   private JTextComponent txt;
   private String name;
   
    public MyText(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc,String name,boolean isPassword){
        super(startX, startY , endX, endY, degrees, colors, arc);
       
        this.name=name;
        
        
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        
        


        if(isPassword){
            txt = new JPasswordField();
            ((JPasswordField)txt).setEchoChar((char)0);

        }
        else txt = new JTextField();
       





        txt.setBorder(new EmptyBorder(0,30,0,30));
        txt.setCaretColor(Color.WHITE);
        txt.setText(name);
        txt.setForeground(Color.GRAY);
        txt.setOpaque(false);
        txt.setFont(new Font("Segoe UI",Font.PLAIN,12));



        txt.addFocusListener( new java.awt.event.FocusAdapter() {
        
            @Override 
            public void focusGained(java.awt.event.FocusEvent e ){
                
                isUserTyping = false;

                
                if(txt.getText().equals(name) && txt.getForeground().equals(Color.GRAY)){
                    
                    txt.setText("");
                    txt.setForeground(Color.WHITE);
                   
                    if(txt instanceof JPasswordField){
                        ((JPasswordField)txt).setEchoChar('•');
                    }
                    
                }
                isUserTyping = true;
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e){
                
                isUserTyping = false;
                
                if(txt.getText().isEmpty()){
                    txt.setText(name);
                    txt.setForeground(Color.GRAY);


                    
                    if(txt instanceof JPasswordField){
                        ((JPasswordField)txt).setEchoChar((char)0);
                    }


                }
                isUserTyping = true;
            }

            });
            


  

        this.add(txt,BorderLayout.CENTER);
    }
   
    public String getText() {
       
       
       
       
        if(txt.getText().equals(name) && txt.getForeground().equals(Color.GRAY)) return "";
       
       if(txt instanceof JPasswordField){
        return new String(((JPasswordField)txt).getPassword());
       }
        return txt.getText();
    }

    public void resetText(){

        txt.setText(name);
        txt.setForeground(Color.GRAY);


        
        if(txt instanceof JPasswordField){
            ((JPasswordField)txt).setEchoChar((char)0);
        }


    }


    public void addActionListener(java.awt.event.ActionListener listener){
        if(txt instanceof JTextField){
            ((JTextField)txt).addActionListener(listener);
        }
    } 

    public void addTextListener(javax.swing.event.DocumentListener listener){

        txt.getDocument().addDocumentListener(listener);


    }

    public boolean isAtive(){
        return txt.getText().equals(name) && txt.getForeground().equals(Color.GRAY);
    }

    public boolean isUserTyping(){
        return isUserTyping;
    }
}