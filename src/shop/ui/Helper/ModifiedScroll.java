
//main package
package shop.ui.Helper;


//my imports 


//main imports 
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;





public class ModifiedScroll extends BasicScrollBarUI{





    public ModifiedScroll(){


    }

    //function to create empty button and override dec and inc arrows with it
    private JButton createEmptyButton(){
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0,0));
        button.setMaximumSize(new Dimension(0,0));
        button.setMinimumSize(new Dimension(0,0));
        return button;

    }   

    @Override
    protected JButton createDecreaseButton(int orientation){
        return createEmptyButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation){
        return createEmptyButton();
    }

    //....


    @Override 
    protected void paintThumb(Graphics g, JComponent c, Rectangle r){
        
        Graphics2D g2 = (Graphics2D)g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 10 ;
        int marigin = 3; //side space 
        
        
        
        g2.setColor(Color.decode("#1f1f1f"));

        g2.fillRoundRect(r.x+marigin, r.y+marigin,r.width-(marigin*2),r.height-(marigin*2), arc, arc);
        //r.x , r.y are starting point for rectangle 

        g2.dispose();
        
    } 

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    
        Graphics2D g2 = (Graphics2D) g.create();
    
        g2.setColor(Color.decode("#303030"));
        g2.fillRect(r.x, r.y, r.width, r.height);
    
        g2.dispose();
    }


    @Override 
    protected Dimension getMinimumThumbSize(){
        return new Dimension(10,40);
    } 
   

}