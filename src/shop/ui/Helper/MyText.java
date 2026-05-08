

//main package
package shop.ui.Helper;





// main imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;


public class MyText extends MyGradient{
   
   private boolean isUserTyping = true;//for search
   
   private JTextComponent txt;
   //JTextCompontet as the text might be a plain text or a password

   private String name;
   //for default text shown
   



    public MyText(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc,String name,boolean isPassword){
        // for curved corners and color gradient if needed
        super(startX, startY , endX, endY, degrees, colors, arc);

       
        this.name=name;
        
        
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        
        


        if(isPassword){
            txt = new JPasswordField();
            ((JPasswordField)txt).setEchoChar((char)0);
            // change the password form dots to normal text if i needed it somewhere else for check so i pass txt as string not dots 

        }
        else txt = new JTextField();
       





        txt.setBorder(new EmptyBorder(0,30,0,30));//to make the text more centered
        txt.setCaretColor(Color.decode("159069"));//the vertical toggoling typing bar
        txt.setText(name);
        txt.setForeground(Color.GRAY);
        txt.setOpaque(false);
        txt.setFont(new Font("Segoe UI",Font.PLAIN,12));






        //clicking the field or going away? 
        
        
        txt.addFocusListener( new java.awt.event.FocusAdapter() {
        
            //once clicked
            @Override 
            public void focusGained(java.awt.event.FocusEvent e ){
                
                //at the start user isn't typing 
                isUserTyping = false;

                //check if no text found
                if(txt.getText().equals(name) && txt.getForeground().equals(Color.GRAY)){
                    
                    txt.setText("");
                    txt.setForeground(Color.WHITE);
                    //color is the confirmation that there is user words 
                   
                    if(txt instanceof JPasswordField){
                        ((JPasswordField)txt).setEchoChar('•');
                        // i want to show what is tying as dots
                    }
                    
                }
                //then when start typing
                isUserTyping = true;
            }

            //once went away 
            @Override
            public void focusLost(java.awt.event.FocusEvent e){
                
                isUserTyping = false;
                
                if(txt.getText().isEmpty()){
                    txt.setText(name);
                    txt.setForeground(Color.GRAY);
                    // gray means that no user text found

                    if(txt instanceof JPasswordField){
                        ((JPasswordField)txt).setEchoChar((char)0);
                        //bec i want to show the name as text not dots
                    }


                }
                isUserTyping = true;
            }

            });
            

        this.add(txt,BorderLayout.CENTER);
    }
   
    public String getText() {
       
       
       
       //if empty
       if(txt.getText().equals(name) && txt.getForeground().equals(Color.GRAY)) return "";
       

       if(txt instanceof JPasswordField){
        return new String(((JPasswordField)txt).getPassword()); // return array of char
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


    //im making the methed here because MyText isnt JTextCompontnent so I have to use it on txt

    public void addActionListener(java.awt.event.ActionListener listener){
        if(txt instanceof JTextField){
            ((JTextField)txt).addActionListener(listener);
        }
    } 



    // for dynamic checks of text found 
    
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