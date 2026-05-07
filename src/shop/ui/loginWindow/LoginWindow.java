package shop.ui.loginWindow;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Data.ApiService;
import shop.ui.Data.User;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.MyText;
import shop.ui.Helper.PressableButton;
import shop.ui.ShopWindow.ShopWindow;

public class LoginWindow extends JPanel{


    private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    private float[] backgroundDegree={0.0f,1.0f};

    
    private float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
    
    private float[] topDegrees = {0.0f, 0.9f, 1.0f};
    private Color[] topColors ={Color.decode("#424242"),Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    
    private float[] textFloats = {0.0f,1.0f};
    private Color[] textColors = {Color.decode("#222222"),Color.decode("#222222")};

    
    // private MyText firstNameField; 
    // private MyText lastNameField;
    private MyText emailField;
    private MyText passwordField;
    
    
    
    public LoginWindow(ShopWindow shopWindow,LoginWrapperWindow loginWrapperWindow){


        
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#111111"));
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#111111"),10));

            
        BaseWrapper baseWrapper=new BaseWrapper(0,0,0,getHeight(),backgroundDegree,backgroundColors,30);
       

        LoginBase loginBase = new LoginBase(0,0,0,getHeight(),degrees,colors,30);





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

     
                
                   emailField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Email",false);
                   emailField.setPreferredSize(new Dimension(300 , 50 ));
                   emailField.setMaximumSize(new Dimension(300 , 50 ));
                   emailField.setMinimumSize(new Dimension(300 , 50 ));
                   emailField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                   
                   
                
              
                   
                   passwordField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Password",true);
                   passwordField.setPreferredSize(new Dimension(300 , 50 ));
                   passwordField.setMaximumSize(new Dimension(300 , 50 ));
                   passwordField.setMinimumSize(new Dimension(300 , 50 ));
                 

                   passwordField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                

                   PressableButton login = new PressableButton("#159069","#56b798",10);
                 
                   login.setText("Login");
                   login.setPreferredSize(new Dimension(300 , 50 ));
                   login.setMaximumSize(new Dimension(300 , 50 ));
                   login.setMinimumSize(new Dimension(300 , 50 ));
                   login.setAlignmentX(Component.CENTER_ALIGNMENT); 
                   
                   login.addActionListener(e -> {

  

                  String email = emailField.getText();
                  String password = passwordField.getText();

                 if(email.isEmpty())
                    {
                     CustomDialog.showMessage(this,"email can't be empty");
                      return;
                   }
  
               if(password.isEmpty())
                {
                  CustomDialog.showMessage(this,"password can't be empty");
                  return;
                }

            
              User user = ApiService.loginUser(email, password);

   
              if (user != null) 
                {

                 CustomDialog.showMessage(this, "Login Success");
                 shopWindow.setIsLogged(true);
                 shopWindow.setUser(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
                 shopWindow.showHomeWindow();
                 resetText();
              }
            else 
            {

            CustomDialog.showMessage(this, "Wrong Password");

             }
    }
);


                info.add(Box.createVerticalStrut(50));
                info.add(emailField);
                info.add(Box.createVerticalStrut(10));
                info.add(passwordField);
                info.add(Box.createVerticalStrut(20));
                info.add(login);
                
                info.add(Box.createVerticalStrut(250));
                      
              
                JPanel tosign = new JPanel(new BorderLayout());
                tosign.setPreferredSize(new Dimension(300 , 65));
                tosign.setOpaque(false);
               

                
                


                    JPanel tosignButtonWrapper = new JPanel(new BorderLayout());
                    tosignButtonWrapper.setBorder(new EmptyBorder(0,30,20,30));
                    tosignButtonWrapper.setOpaque(false);



                    PressableButton tosignButton = new PressableButton("#313131","#6e6e6e",10);
                    tosignButton.setText("Sign in instead");
              
                    tosignButton.addActionListener(e->{
                        loginWrapperWindow.showSignInWindow();
                        revalidate();
                        repaint();
                    });
                    

               
                
                tosignButtonWrapper.add(tosignButton, BorderLayout.CENTER);
                tosign.add(tosignButtonWrapper, BorderLayout.CENTER);

    
        top.add(info,BorderLayout.CENTER);
        top.add(tosign , BorderLayout.SOUTH);        
        topWrapper.add(top, BorderLayout.CENTER);         

       
        loginBase.add(topWrapper , BorderLayout.CENTER);   
        loginBase.add(Bottom, BorderLayout.SOUTH);        
        baseWrapper.add(loginBase);
        this.add(baseWrapper, BorderLayout.CENTER);



        

    }


    public void resetText(){
        emailField.resetText();
        passwordField.resetText();

    }



}


class BaseWrapper extends MyGradient{

    public BaseWrapper(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);
        
        this.setLayout(new  GridBagLayout());
        this.setBackground(Color.decode("#111111"));
        
        


    }

}

class LoginBase extends MyGradient{
    
    public LoginBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
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
