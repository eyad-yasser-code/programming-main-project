package shop.ui.loginWindow;

import java.awt.*;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Data.ApiService;
import shop.ui.Data.User;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.MyText;
import shop.ui.Helper.PressableButton;
import shop.ui.ShopWindow.ShopWindow;



public class SignInWindow extends JPanel{


    private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    private float[] backgroundDegree={0.0f,1.0f};

    
    private float[] degrees = {0.0f, 0.7f, 1.0f};
    private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
    
    private float[] topDegrees = {0.0f, 0.9f, 1.0f};
    private Color[] topColors ={Color.decode("#424242"),Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
    
    private float[] textFloats = {0.0f,1.0f};
    private Color[] textColors = {Color.decode("#222222"),Color.decode("#222222")};

   
   
    private MyText firstNameField; 
    private MyText lastNameField;
    private MyText emailField;
    private MyText passwordField;
    private MyText confirmPasswordField;


   
    public SignInWindow(ShopWindow shopWindow,LoginWrapperWindow loginWrapperWindow){


        
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





            firstNameField= new MyText(0,0,0,getHeight(),textFloats,textColors,30,"First name",false);
            firstNameField.setPreferredSize(new Dimension(300 , 50 ));
            firstNameField.setMaximumSize(new Dimension(300 , 50 ));
            firstNameField.setMinimumSize(new Dimension(300 , 50 ));
            firstNameField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    

                
            lastNameField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Last name",false);
            lastNameField.setPreferredSize(new Dimension(300 , 50 ));
            lastNameField.setMaximumSize(new Dimension(300 , 50 ));
            lastNameField.setMinimumSize(new Dimension(300 , 50 ));
            lastNameField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    
                    
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
                    


        confirmPasswordField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Confirm password",true);
        confirmPasswordField.setPreferredSize(new Dimension(300 , 50 ));
        confirmPasswordField.setMaximumSize(new Dimension(300 , 50 ));
        confirmPasswordField.setMinimumSize(new Dimension(300 , 50 ));        
        confirmPasswordField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    
                    
                    
                  
                  
                  
     PressableButton signin = new PressableButton("#159069","#56b798",10);
                 
                signin.setText("Sign in");
                signin.setPreferredSize(new Dimension(300 , 50 ));
                signin.setMaximumSize(new Dimension(300 , 50 ));
                signin.setMinimumSize(new Dimension(300 , 50 ));
                signin.setAlignmentX(Component.CENTER_ALIGNMENT); 
                   
                    signin.addActionListener(e->{

                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String email = emailField.getText();
                    String password = passwordField.getText();
                    String confirmPassword = confirmPasswordField.getText();

                      

    if(firstName.isEmpty()){CustomDialog.showMessage(this,"First name can't be empty"); return;}
    if(lastName.isEmpty()){CustomDialog.showMessage(this,"Last name can't be empty"); return;}
    if(email.isEmpty()){CustomDialog.showMessage(this,"Email can't be empty"); return;}
    if(password.isEmpty()){CustomDialog.showMessage(this,"Password can't be empty"); return;}
                      
    if(!email.contains("@"))
        {
            CustomDialog.showMessage(this, "Invalid email format");
            emailField.resetText();
              return;
        }
                        
            String domain = "";
                        
            StringTokenizer tokenizer = new StringTokenizer(email,"@");
             while(tokenizer.hasMoreTokens())
                {
                 domain=tokenizer.nextToken();
            }



             if(!(domain.equals("gmail.com")) &&!(domain.equals("outlook.com")) &&!(domain.equals("yahoo.com")))
            {CustomDialog.showMessage(this,"domain isn't avilable");
                 emailField.resetText();
                return;
         }
                      

            if(!(password.equals(confirmPassword))){

             CustomDialog.showMessage(this, "password must match");
                confirmPasswordField.resetText();
                 return;
             }
                    
                        User user = new User(firstName, lastName, email, password);

                        /*UsersDataBase.users.add(user);

                        JOptionPane.showMessageDialog(this, "User added successfully");
                        shopWindow.setIsLogged(true);
                        shopWindow.setUser(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
                        shopWindow.showHomeWindow();
                        resetText();*/

                      int response = ApiService.registerUser(firstName, lastName, email, password);

                   /*  if(response == 200){
                    JOptionPane.showMessageDialog(this, "User added successfully");

                   shopWindow.setIsLogged(true);
                   shopWindow.setUser(firstName, lastName, email, password);
                   shopWindow.showHomeWindow();
                   resetText();

                   }     else {
                     CustomDialog.showMessage(this, "Registration failed!");
                   }*/

                     if(response == 200)
                       {
                         CustomDialog.showMessage(this, "Welcome,Login Success");
                         shopWindow.setIsLogged(true);
                         shopWindow.setUser(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
                         shopWindow.showHomeWindow();
                         shopWindow.refreshUI();
                         resetText();
                    }
                     else
                         {
                          CustomDialog.showMessage(this, "Login Failed");
                         }
                     
                    });




                info.add(Box.createVerticalStrut(50));
                info.add(firstNameField);
                info.add(Box.createVerticalStrut(10));
                info.add(lastNameField);
                info.add(Box.createVerticalStrut(10));
                info.add(emailField);
                info.add(Box.createVerticalStrut(10));
                info.add(passwordField);
                info.add(Box.createVerticalStrut(10));
                info.add(confirmPasswordField);
                info.add(Box.createVerticalStrut(20));
                info.add(signin);
                info.add(Box.createVerticalStrut(250));

              
              
              
              
                JPanel tologin = new JPanel(new BorderLayout());
                tologin.setPreferredSize(new Dimension(300 , 65));
                tologin.setOpaque(false);
            

                JPanel tologinButtonWrapper = new JPanel(new BorderLayout());
                tologinButtonWrapper.setBorder(new EmptyBorder(0,30,20,30));
                tologinButtonWrapper.setOpaque(false);



                PressableButton tologinButton = new PressableButton("#313131","#6e6e6e",10);
                tologinButton.setText("Login instead");
              
                tologinButton.addActionListener(e->{
                     loginWrapperWindow.showLoginWindow();
                    revalidate();
                    repaint();
            });
                    

               
                
            tologinButtonWrapper.add(tologinButton, BorderLayout.CENTER);
            tologin.add(tologinButtonWrapper, BorderLayout.CENTER);

    
        top.add(info,BorderLayout.CENTER);
        top.add(tologin , BorderLayout.SOUTH);        
        topWrapper.add(top, BorderLayout.CENTER);         

       
        loginBase.add(topWrapper , BorderLayout.CENTER);   
        loginBase.add(Bottom, BorderLayout.SOUTH);        
        baseWrapper.add(loginBase);
        this.add(baseWrapper, BorderLayout.CENTER);


    }


    
    public void resetText()
    {
      
        firstNameField.resetText();
        lastNameField.resetText();
        emailField.resetText();
        passwordField.resetText();
        confirmPasswordField.resetText();

    }


}


class BaseWrapper extends MyGradient
{

    public BaseWrapper(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);
        
        this.setLayout(new  GridBagLayout());
        this.setBackground(Color.decode("#111111"));


    }

}

class LoginBase extends MyGradient
{
    
    public LoginBase(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500,650));
        this.setBackground(Color.decode("#111111"));
    }

}

class Top extends MyGradient
{
    
    public Top(int startX, int startY , int endX, int endY, float[] degrees, Color[] colors,int arc){
        
        super(startX, startY , endX, endY, degrees, colors, arc);

        this.setLayout(new BorderLayout());
        this.setOpaque(false);
    }
}
