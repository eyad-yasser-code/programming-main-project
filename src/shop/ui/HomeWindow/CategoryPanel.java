package shop.ui.HomeWindow;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Helper.ImageLabel;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.*;
import shop.ui.MainWindow.MainWindow;

public class CategoryPanel extends JPanel {

    
    private Category category;

   
    private static final int PANEL_WIDTH  = 210;
    private static final int PANEL_HEIGHT = 420;

    //mainWindow to pass filtered products back and forth
    public CategoryPanel(Category category, MainWindow mainWindow) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setMaximumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setOpaque(false);

        setCategory(category);
        

        //Image panel
        JPanel imagePanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

                Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20);
                Shape oldClip = g2d.getClip();
                g2d.setClip(clip);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2d.setClip(oldClip);
            }
        };
        imagePanel.setOpaque(false);
        imagePanel.setPreferredSize(new Dimension(0, 260));
        imagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 260));
        imagePanel.setBackground(new Color(255, 255, 255, 220));

        ImageLabel imageLabel = new ImageLabel(category.getSelectedFile());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

       
        //Text section
        JPanel textWrapper = new JPanel(new BorderLayout());
        textWrapper.setOpaque(false);
        textWrapper.setBorder(new EmptyBorder(10, 14, 0, 14));


        JLabel nameLabel = new JLabel(category.getName());
     
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        nameLabel.setForeground(Color.WHITE);

       
        JLabel subLabel = new JLabel("Browse collection →");
        subLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        subLabel.setForeground(new Color(0x21c48a));

        JPanel textStack = new JPanel();
        textStack.setLayout(new BoxLayout(textStack, BoxLayout.Y_AXIS));
        textStack.setOpaque(false);
        textStack.add(nameLabel);
        textStack.add(Box.createVerticalStrut(3));
        textStack.add(subLabel);

        textWrapper.add(textStack, BorderLayout.CENTER);

        //Button add to cart
        JPanel buttonWrapper = new JPanel(new BorderLayout());
        buttonWrapper.setOpaque(false);
        buttonWrapper.setBorder(new EmptyBorder(0, 14, 0, 14));
        buttonWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        PressableButton select = new PressableButton("#159069", "#21c48a", 10);
        select.setText("Explore Category");
        select.setFont(new Font("SansSerif", Font.BOLD, 12));
        select.setPreferredSize(new Dimension(0, 38));

        select.addActionListener(e -> {
          

            ArrayList<Product> filtered = new ArrayList<>();
            for (Product p : mainWindow.getAllProducts()) {
                if (p.getCategoryId() == category.getId()) {
                    filtered.add(p);
                }
            }

            mainWindow.showFilteredProducts(filtered);
            mainWindow.defaultScroll();
            mainWindow.showItemsHolder();
        });

        buttonWrapper.add(select, BorderLayout.CENTER);

        //Assemble
        this.add(imagePanel);
     
        this.add(Box.createVerticalStrut(10));
        this.add(textWrapper);
        this.add(Box.createVerticalStrut(12));
        this.add(buttonWrapper);
        this.add(Box.createVerticalStrut(8));
    }

    // Setters / Getters
    public void setCategory(Category category) { this.category = category; }
    public Category getCategory() { return category; }

   
    private final float[]  fractions = {0.0f, 0.5f, 1.0f};
    private final Color[]  colors    = {
        Color.decode("#252727"),
        Color.decode("#1e2020"),
        Color.decode("#161818")
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       
        LinearGradientPaint grad = new LinearGradientPaint(
                0, 0, 0, getHeight(), fractions, colors);
        g2d.setPaint(grad);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Subtle border
        g2d.setColor(new Color(0x2a2e2e));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
}
