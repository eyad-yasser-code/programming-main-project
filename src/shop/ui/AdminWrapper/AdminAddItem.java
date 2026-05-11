package shop.ui.AdminWrapper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import shop.ui.Data.ApiService;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.MyText;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.Product;
import shop.ui.ShopWindow.ShopWindow;


public class AdminAddItem extends JPanel{

   

        
        private Color[] backgroundColors={Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        private float[] backgroundDegree={0.0f,1.0f};
    
        
        private float[] degrees = {0.0f, 0.7f, 1.0f};
        private Color[] colors ={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        
        private float[] topDegrees = {0.0f, 0.9f, 1.0f};
        private Color[] topColors ={Color.decode("#424242"),Color.decode("#1c1c1c"),Color.decode("#1c1c1c")};
        
        private float[] textFloats = {0.0f,1.0f};
        private Color[] textColors = {Color.decode("#222222"),Color.decode("#222222")};
    
        
      
        private MyText nameField;
        private MyText descriptionField;
        private MyText itemIdField;
        private MyText priceField;
        private MyText categoryIdField;
        private File[] selectedFiles;
        ///
        private File firstImage ;
        
        
        public AdminAddItem(ShopWindow shopWindow,AdminWrapper adminWrapper ){
    
            
    
            
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
    
         
                    
                    nameField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Item name",false);
                    nameField.setPreferredSize(new Dimension(300 , 50 ));
                    nameField.setMaximumSize(new Dimension(300 , 50 ));
                    nameField.setMinimumSize(new Dimension(300 , 50 ));
                    nameField.setAlignmentX(Component.CENTER_ALIGNMENT); 

                    descriptionField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Item description",false);
                    descriptionField.setPreferredSize(new Dimension(300 , 50 ));
                    descriptionField.setMaximumSize(new Dimension(300 , 50 ));
                    descriptionField.setMinimumSize(new Dimension(300 , 50 ));
                    descriptionField.setAlignmentX(Component.CENTER_ALIGNMENT); 

                    itemIdField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Item Id",false);
                    itemIdField.setPreferredSize(new Dimension(300 , 50 ));
                    itemIdField.setMaximumSize(new Dimension(300 , 50 ));
                    itemIdField.setMinimumSize(new Dimension(300 , 50 ));
                    itemIdField.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    
                    priceField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"price in EGP",false);
                    priceField.setPreferredSize(new Dimension(300 , 50 ));
                    priceField.setMaximumSize(new Dimension(300 , 50 ));
                    priceField.setMinimumSize(new Dimension(300 , 50 ));
                    priceField.setAlignmentX(Component.CENTER_ALIGNMENT); 

                    categoryIdField = new MyText(0,0,0,getHeight(),textFloats,textColors,30,"Category Id",false);
                    categoryIdField.setPreferredSize(new Dimension(300 , 50 ));
                    categoryIdField.setMaximumSize(new Dimension(300 , 50 ));
                    categoryIdField.setMinimumSize(new Dimension(300 , 50 ));
                    categoryIdField.setAlignmentX(Component.CENTER_ALIGNMENT); 




                    
                       
                    PressableButton selectImage = new PressableButton("#313131","#6e6e6e",10);
                    selectImage.setText("Select Image/s");
                    selectImage.setPreferredSize(new Dimension(300 , 50 ));
                    selectImage.setMaximumSize(new Dimension(300 , 50 ));
                    selectImage.setMinimumSize(new Dimension(300 , 50 ));
                    selectImage.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    

                    selectImage.addActionListener(e -> {

                            JFileChooser fileChooser = new JFileChooser();

                            fileChooser.setCurrentDirectory(new java.io.File("."));

                           
                            fileChooser.setMultiSelectionEnabled(true);

                           
                            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                           
                            FileNameExtensionFilter filter =
                                    new FileNameExtensionFilter("Image Files","png","jpg","jpeg","webp");

                            fileChooser.setFileFilter(filter);

                            int result = fileChooser.showOpenDialog(this);

                            if(result == JFileChooser.APPROVE_OPTION){

                                selectedFiles = fileChooser.getSelectedFiles();
                                ////
                                firstImage = selectedFiles[0];
                            }

                        });
                                            
                                            
                    
                    PressableButton confirm = new PressableButton("#159069","#56b798",10);
                    confirm.setText("confirm");
                    confirm.setPreferredSize(new Dimension(300 , 50 ));
                    confirm.setMaximumSize(new Dimension(300 , 50 ));
                    confirm.setMinimumSize(new Dimension(300 , 50 ));
                    confirm.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    

                    confirm.addActionListener(e->{
                        

                     
                        try {

                            String name = nameField.getText();
                            String description = descriptionField.getText();     
                            int itemId = Integer.parseInt(itemIdField.getText());
                            double price = Double.parseDouble(priceField.getText());
                            int categoryId = Integer.parseInt(categoryIdField.getText());
                            //
                            String imageName = firstImage.getName();
                            
                            if(selectedFiles==null){
                                
                            JOptionPane.showMessageDialog(this,"Please enter valid image","WARNING",JOptionPane.WARNING_MESSAGE);
                            return;

                            }

                            if(name.isEmpty() || description.isEmpty()){
                                JOptionPane.showMessageDialog(this,"please enter all fields","WARNING",JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                          
    
                            
                       
                           
                           
                            boolean accepted = true;
                        
                            
                            for(Product test : shopWindow.getAllProducts()){
                               
                                if(test.getId()==itemId){
                                  
                                    JOptionPane.showMessageDialog(this,"Id already exist","WARNING",JOptionPane.WARNING_MESSAGE);
                                    itemIdField.resetText();
                                    accepted = false;
                                    break;
    
                                }
    
    
                            }

    
                            if(accepted)
                                {
                         //
                         int response = ApiService.addProduct(name,description,price,categoryId,imageName);
                         //      
                               
                         shopWindow.addItem(itemId,name,selectedFiles,description,price,categoryId);
                         JOptionPane.showMessageDialog(this, "added successfully");
                         resetText();
                            }
    
                        
                        
                        
                        } catch(NumberFormatException ex) {
                        
                            JOptionPane.showMessageDialog(this,"Please enter valid numbers","WARNING",JOptionPane.WARNING_MESSAGE);
                            return;

                        }
                        catch(NullPointerException ex){

                            JOptionPane.showMessageDialog(this,"Please enter valid image","WARNING",JOptionPane.WARNING_MESSAGE);
                            return;

                        }

                   


                    });
                    
                       
              
                    info.add(Box.createVerticalStrut(50));
                    
                    info.add(nameField);
                    info.add(Box.createVerticalStrut(10));
                    info.add(descriptionField);
                    info.add(Box.createVerticalStrut(10));
                    info.add(itemIdField);
                    info.add(Box.createVerticalStrut(10));
                    info.add(categoryIdField);
                    info.add(Box.createVerticalStrut(10));
                    info.add(priceField);
                    info.add(Box.createVerticalStrut(10));
                    info.add(selectImage);
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
            nameField.resetText();
            descriptionField.resetText();
            itemIdField.resetText();
            categoryIdField.resetText();
            priceField.resetText();
        
        }
    
    
    
    }
    
    

    

    

    