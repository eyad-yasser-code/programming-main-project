package shop.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;





//helper class

class PressableButton extends JButton{

private boolean hover = false;
private Color baseColor;
private Color hoverColor;
private int arc;



    @Override
    protected void paintComponent(Graphics g){
        
        
    Graphics2D g2D = (Graphics2D)g;


    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


    g2D.setColor(hover == false ? baseColor : hoverColor );
    g2D.fillRoundRect(0,0,getWidth(),getHeight(),arc,arc);
   


    super.paintComponent(g);
    }

    
public PressableButton(String base, String hover, int arc){

    baseColor = Color.decode(base);
    hoverColor = Color.decode(hover);
    this.arc=arc;

    this.setFocusPainted(false);
    this.setBorderPainted(false);
    this.setContentAreaFilled(false);
    this.setBackground(baseColor);
    this.setForeground(Color.WHITE);
    this.setOpaque(false);
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
   


    this.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e){
            setBackground(hoverColor);
            sethover(true);
        }    
        
        @Override
        public void mouseExited(java.awt.event.MouseEvent e){
            setBackground(baseColor);
            sethover(false);
        }
        

    });
   
  
}

  private void sethover(boolean hover){
        this.hover=hover;
    }

}





//main classes 

class ItemPanelHolder extends JPanel{

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

    public ItemPanelHolder(){
       
        this.setLayout(new GridLayout(0, 4, 50, 50));
        this.setBorder(new EmptyBorder(150,105,100,105));
     
    }

}




class MainPanel extends JPanel{

 private ItemPanelHolder itemPanelHolder;   

    public MainPanel(){

       
        this.setLayout(new BorderLayout());

       
       
        itemPanelHolder = new ItemPanelHolder();
        itemPanelHolder.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        
        
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
           wrapper.add(itemPanelHolder);
           wrapper.add(bottomPanel);
           



           
            JScrollPane scrollPane = new JScrollPane(wrapper);
            scrollPane.setWheelScrollingEnabled(true);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBorder(null);
           
           


            backToTop.addActionListener(e -> {
                System.out.println("back to top pressed");
                 scrollPane.getVerticalScrollBar().setValue(0);
            
            });




           
            this.add(scrollPane, BorderLayout.CENTER);
            
    }

    public void addItem(String name, String imagName, String price){
        itemPanelHolder.add(new ItemPanel(name,imagName,price));
        itemPanelHolder.revalidate();
        itemPanelHolder.repaint();

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
    
