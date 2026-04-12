




//main package
package shop.ui.ShopWindow;

//my packages import
import shop.ui.Helper.PressableButton;


//main imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;





//main classes 












class ItemsHolder extends JPanel{

    // @Override
    protected void paintComponent(Graphics graphics) {
       
        Color colors[]={Color.decode("#424242"),Color.decode("#424242"),Color.decode("#1c1c1c")};
        float degree[]={0.0f, 0.7f, 1.0f};

        super.paintComponent(graphics); //remove color of panel
        Graphics2D graphics2d = (Graphics2D) graphics;
        LinearGradientPaint linerG = new LinearGradientPaint(0,0, 0,getHeight(),degree,colors);
       
        graphics2d.setPaint(linerG);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public ItemsHolder(){
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,105,100,105));
     
    }

}





class MainPanel extends JPanel{

 private ItemsHolder itemsHolder;   

    public MainPanel(){

       
        this.setLayout(new BorderLayout());

       
       
        itemsHolder = new ItemsHolder();
        itemsHolder.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        
        
        JPanel bottomPanel = new JPanel(){
            
            float values[]={0.0f,0.1f,0.2f,1.0f};
            Color colors[]={Color.decode("#159069"),Color.decode("#159069"),Color.decode("#23221f"),Color.decode("#23221f")};

            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D)g;

                LinearGradientPaint linerG = new LinearGradientPaint(0,0 , 0,  getHeight() ,values ,colors);

                g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                g2D.setPaint(linerG);
                g2D.fillRect(0, 0, getWidth(), getHeight());
                
            }


        };

            
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
            bottomPanel.setPreferredSize(new Dimension(0,400));
            bottomPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            bottomPanel.setOpaque(false);

            //information panels

            JPanel inforamtionWrapPanel = new JPanel();
            inforamtionWrapPanel.setOpaque(false);
            inforamtionWrapPanel.setBorder(new EmptyBorder(50,40,50,40));
        

            //buttons 
            PressableButton backToTop = new PressableButton("#159069","#56b798",0);
            backToTop.setText("Back To Top");
            backToTop.setPreferredSize(new Dimension(Integer.MAX_VALUE,40));
            backToTop.setMaximumSize(new Dimension(Integer.MAX_VALUE,100));
            backToTop.setAlignmentX(Component.CENTER_ALIGNMENT);

            backToTop.setFont(new Font("Arial",Font.BOLD,14));



            bottomPanel.add(backToTop);
            bottomPanel.add(inforamtionWrapPanel);


           
          // wrapper for bottom and other panel
           JPanel wrapper = new JPanel();
           wrapper.setLayout(new BoxLayout (wrapper,BoxLayout.Y_AXIS));
           wrapper.setOpaque(false);
           wrapper.add(itemsHolder);
           wrapper.add(bottomPanel);
           



           
            JScrollPane scrollPane = new JScrollPane(wrapper);
            scrollPane.setWheelScrollingEnabled(true);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(null);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
           


            backToTop.addActionListener(e -> {
                System.out.println("back to top pressed");
                 scrollPane.getVerticalScrollBar().setValue(0);
            
            });




           
            this.add(scrollPane, BorderLayout.CENTER);
            
    }

    public void addItem(String name, String imagName, String price){
        itemsHolder.add(new ItemPanel(name,imagName,price));
        itemsHolder.revalidate();
        itemsHolder.repaint();

    }

}



class ItemWindow extends JPanel{

    private MainPanel mainPanel;
    
        public ItemWindow(){
           this.setLayout(new BorderLayout());
           
           mainPanel=new MainPanel(); 
           this.add(mainPanel,BorderLayout.CENTER);
    
        }
    

        public void addItem(String name, String imagName, String price){
            mainPanel.addItem(name,imagName,price);
        }
        
    }
    
