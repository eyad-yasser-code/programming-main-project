package shop.ui.MainWindow;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Helper.ModifiedScroll;
import shop.ui.Helper.MyGradient;
import shop.ui.Helper.PressableButton;
import shop.ui.HomeWindow.HomeWindow;
import shop.ui.LogicHelper.*;

public class MainWindow extends JPanel {

    private BottomBasePanel bottomBasePanel;

    private TopBasePanel topBasePanel;

    private JPanel basePanel;

    private HomeWindow homeWindow;

    public MainWindow(HomeWindow homeWindow) {

        this.homeWindow = homeWindow;

        this.setLayout(new BorderLayout());

        this.setOpaque(false);

        basePanel = new JPanel(new BorderLayout());

        basePanel.setOpaque(false);

        topBasePanel = new TopBasePanel();

        bottomBasePanel = new BottomBasePanel(this);

        basePanel.add(topBasePanel, BorderLayout.NORTH);

        basePanel.add(bottomBasePanel, BorderLayout.CENTER);

        this.add(basePanel, BorderLayout.CENTER);
    }

    // ================= ADDING =================

    public void addItem(Product product) {

        bottomBasePanel.addItem(product);
    }

    public void addCategory(Category category) {

        bottomBasePanel.addCategory(category);
    }

    // ================= ADD TO CART =================

    public void addToCart(Product product) {

        homeWindow.addToCart(product);
    }

    // ================= REMOVE =================

    public void removeItem(Product product) {

        bottomBasePanel.removeItem(product);
    }

    public void removeCategory(Category removable) {

        bottomBasePanel.removeCategory(removable);
    }

    // ================= SHOW =================

    public void showCategoriesHolder() {

        bottomBasePanel.showCategoriesHolder();
    }

    public void showItemsHolder() {

        bottomBasePanel.showItemsHolder();
    }

    public void showFilteredProducts(
            ArrayList<Product> filtered
    ) {

        bottomBasePanel.showFilteredProducts(filtered);
    }

    public void showSearchedProducts(
            ArrayList<Product> searched
    ) {

        bottomBasePanel.showSearchedProducts(searched);
    }

    // ================= SCROLL =================

    public void defaultScroll() {

        bottomBasePanel.defaultScroll();
    }

    // ================= GETTERS =================

    public ArrayList<Product> getAllProducts() {

        return homeWindow.getAllProducts();
    }
}

// =====================================================

class TopBasePanel extends JPanel {

    public TopBasePanel() {

        this.setPreferredSize(
                new Dimension(0, 40)
        );

        this.setOpaque(false);
    }
}

// =====================================================

class BottomBasePanel extends JPanel {

    private MiddleView middleView;

    private JScrollPane scrollPane;

    private final float[] degrees = {
            0.0f,
            0.15f,
            0.25f,
            1.0f
    };

    private final Color[] colors = {
            Color.decode("#159069"),
            Color.decode("#159069"),
            Color.decode("#242424"),
            Color.decode("#141414")
    };

    public BottomBasePanel(MainWindow mainWindow) {

        this.setLayout(new BorderLayout());

        this.setOpaque(false);

        middleView = new MiddleView(mainWindow);

        middleView.showCategoriesHolder();

        middleView.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        middleView.setOpaque(false);

        middleView.setBorder(
                BorderFactory.createLineBorder(
                        Color.decode("#1c1c1c"),
                        10
                )
        );

        BottomPanel bottomPanel =
                new BottomPanel(
                        0,
                        0,
                        0,
                        getHeight(),
                        degrees,
                        colors,
                        60
                );

        JPanel informationWrapPanel =
                new JPanel();

        informationWrapPanel.setOpaque(false);

        informationWrapPanel.setBorder(
                new EmptyBorder(
                        50,
                        40,
                        50,
                        40
                )
        );

        // ================= BUTTON =================

        PressableButton backToTop =
                new PressableButton(
                        "#159069",
                        "#21c48a",
                        0
                );

        backToTop.setText("↑  Back To Top");

        backToTop.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        backToTop.setPreferredSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        44
                )
        );

        backToTop.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        44
                )
        );

        backToTop.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ================= ADD =================

        bottomPanel.add(backToTop);

        bottomPanel.add(informationWrapPanel);

        JPanel wrapper = new JPanel();

        wrapper.setLayout(
                new BoxLayout(
                        wrapper,
                        BoxLayout.Y_AXIS
                )
        );

        wrapper.add(middleView);

        wrapper.add(bottomPanel);

        wrapper.setOpaque(false);

        // ================= SCROLL =================

        scrollPane =
                new JScrollPane(wrapper);

        scrollPane.setWheelScrollingEnabled(true);

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.setBorder(null);

        scrollPane.setOpaque(false);

        scrollPane.getViewport().setOpaque(false);

        scrollPane.getVerticalScrollBar()
                .setUI(new ModifiedScroll());

        scrollPane.getVerticalScrollBar()
                .setPreferredSize(
                        new Dimension(10, 0)
                );

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(20);

        scrollPane.getHorizontalScrollBar()
                .setUI(new ModifiedScroll());

        scrollPane.getHorizontalScrollBar()
                .setPreferredSize(
                        new Dimension(0, 10)
                );

        // ================= BUTTON ACTION =================

        backToTop.addActionListener(
                e -> defaultScroll()
        );

        // ================= ADD TO PANEL =================

        this.add(
                scrollPane,
                BorderLayout.CENTER
        );
    }

    // ================= ADDING =================

    public void addItem(Product product) {

        middleView.addItem(product);
    }

    public void addCategory(Category category) {

        middleView.addCategory(category);
    }

    // ================= REMOVING =================

    public void removeItem(Product product) {

        middleView.removeItem(product);
    }

    public void removeCategory(Category removable) {

        middleView.removeCategory(removable);
    }

    // ================= SHOWING =================

    public void showCategoriesHolder() {

        middleView.showCategoriesHolder();
    }

    public void showItemsHolder() {

        middleView.showItemsHolder();
    }

    public void showFilteredProducts(
            ArrayList<Product> filtered
    ) {

        middleView.showFilteredProducts(filtered);
    }

    public void showSearchedProducts(
            ArrayList<Product> searchedProducts
    ) {

        middleView.showSearchedProducts(
                searchedProducts
        );
    }

    // ================= SCROLL =================

    public void defaultScroll() {

        scrollPane.getVerticalScrollBar()
                .setValue(0);
    }
}

// =====================================================

class BottomPanel extends MyGradient {

    public BottomPanel(
            int startX,
            int startY,
            int endX,
            int endY,
            float[] degrees,
            Color[] colors,
            int arc
    ) {

        super(
                startX,
                startY,
                endX,
                endY,
                degrees,
                colors,
                arc
        );

        this.setLayout(
                new BoxLayout(
                        this,
                        BoxLayout.Y_AXIS
                )
        );

        this.setPreferredSize(
                new Dimension(0, 400)
        );

        this.setBorder(
                BorderFactory.createLineBorder(
                        Color.decode("#1b1b1b"),
                        10
                )
        );

        this.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        this.setOpaque(false);
    }
}