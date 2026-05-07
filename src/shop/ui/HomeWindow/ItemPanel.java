package shop.ui.HomeWindow;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Helper.ImageLabel;
import shop.ui.Helper.PressableButton;
import shop.ui.LogicHelper.*;
import shop.ui.MainWindow.MiddleView;

public class ItemPanel extends JPanel {

    private Product product;

    // DESIGN: Slightly wider for breathing room
    private static final int PANEL_WIDTH  = 210;
    private static final int PANEL_HEIGHT = 370;

    public ItemPanel(Product product, MiddleView middleView) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setMaximumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setOpaque(false);

        this.product = product;

        // ── Image panel ──────────────────────────────────────────────────────
        JPanel imagePanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20);
                g2d.setClip(clip);
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        imagePanel.setOpaque(false);
        // BUG FIX: constrain height so image doesn't overflow the panel's fixed height
        imagePanel.setPreferredSize(new Dimension(0, 200));
        imagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        imagePanel.setBackground(new Color(255, 255, 255, 220));

        // BUG FIX: ImageLabel added to a BorderLayout panel — CENTER alignment on
        // the label itself had no effect. The CENTER constraint handles positioning.
        ImageLabel imageLabel = new ImageLabel("/images/", product.getImageName());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // ── Accent line ───────────────────────────────────────────────────────
        JPanel accentLine = new JPanel();
        accentLine.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        accentLine.setPreferredSize(new Dimension(0, 2));
        accentLine.setBackground(new Color(0x21c48a));
        accentLine.setOpaque(true);

        // ── Text section ──────────────────────────────────────────────────────
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(new EmptyBorder(10, 14, 0, 14));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descriptionLabel = new JLabel(
                "<html><body style='width:165px'>" + product.getDescription() + "</body></html>");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        descriptionLabel.setForeground(new Color(0xb0b0b0));
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // DESIGN: Price gets a distinct accent colour so it pops
        JLabel priceLabel = new JLabel(product.getPrice() + " EGP");
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        priceLabel.setForeground(new Color(0x21c48a));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(nameLabel);
        textPanel.add(Box.createVerticalStrut(4));
        textPanel.add(descriptionLabel);
        textPanel.add(Box.createVerticalStrut(8));
        textPanel.add(priceLabel);

        wrapper.add(textPanel, BorderLayout.WEST);

        // ── Button ────────────────────────────────────────────────────────────
        JPanel buttonWrapper = new JPanel(new BorderLayout());
        buttonWrapper.setOpaque(false);
        buttonWrapper.setBorder(new EmptyBorder(0, 14, 0, 14));
        buttonWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        PressableButton cartAdd = new PressableButton("#159069", "#21c48a", 10);
        cartAdd.setText("Add to Cart");
        cartAdd.setFont(new Font("SansSerif", Font.BOLD, 12));
        cartAdd.setPreferredSize(new Dimension(0, 38));

        cartAdd.addActionListener(e -> middleView.addToCart(product));

        buttonWrapper.add(cartAdd, BorderLayout.CENTER);

        // ── Assemble ──────────────────────────────────────────────────────────
        this.add(imagePanel);
        this.add(accentLine);
        this.add(Box.createVerticalStrut(8));
        this.add(wrapper);
        this.add(Box.createVerticalStrut(10));
        this.add(buttonWrapper);
        this.add(Box.createVerticalStrut(8));
    }

    public Product getProduct() { return product; }

    // ── Paint ─────────────────────────────────────────────────────────────────
    private final float[] fractions = {0.0f, 0.5f, 1.0f};
    private final Color[] colors    = {
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
        g2d.setStroke(new BasicStroke(1.2f));
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }
}
