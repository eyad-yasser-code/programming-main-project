



package shop.ui.Helper;





import javax.swing.*;
import java.awt.*;


public class PressableButton extends JButton{

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

