package shop.ui.MainWindow;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shop.ui.Helper.MyGradient;
import shop.ui.HomeWindow.CategoryPanel;
import shop.ui.HomeWindow.ItemPanel;
import shop.ui.LogicHelper.*;

public class MiddleView extends JPanel {

    private ItemsHolder itemsHolder;
    private CategoriesHolder categoriesHolder;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private MainWindow mainWindow;

    private final float[] degrees = {0.0f, 0.7f, 1.0f};

    private final Color[] colors = {
        Color.decode("#1e2020"),
        Color.decode("#1a1c1c"),
        Color.decode("#141616")
    };

    public MiddleView(MainWindow mainWindow) {

        this.setLayout(new BorderLayout());

        this.mainWindow = mainWindow;

        this.setOpaque(false);

        itemsHolder = new ItemsHolder(
                0,
                0,
                0,
                600,
                degrees,
                colors,
                30
        );

        categoriesHolder = new CategoriesHolder(
                0,
                0,
                0,
                600,
                degrees,
                colors,
                30
        );

        JPanel itemHolderWrapper = new JPanel(new BorderLayout());
        itemHolderWrapper.setOpaque(false);
        itemHolderWrapper.add(itemsHolder, BorderLayout.NORTH);

        JPanel categoryHolderWrapper = new JPanel(new BorderLayout());
        categoryHolderWrapper.setOpaque(false);
        categoryHolderWrapper.add(categoriesHolder, BorderLayout.NORTH);

        cardLayout = new CardLayout();

        cardPanel = new JPanel(cardLayout);

        cardPanel.setOpaque(false);

        cardPanel.add(itemHolderWrapper, "itemsHolder");

        cardPanel.add(categoryHolderWrapper, "categoriesHolder");

        this.add(cardPanel, BorderLayout.CENTER);

        showCategoriesHolder();
    }

    // =====================================================
    // Visibility
    // =====================================================

    public void showItemsHolder() {

        cardLayout.show(cardPanel, "itemsHolder");

        itemsHolder.revalidate();
        itemsHolder.repaint();
    }

    public void showCategoriesHolder() {

        cardLayout.show(cardPanel, "categoriesHolder");

        categoriesHolder.revalidate();
        categoriesHolder.repaint();
    }

    public void showFilteredProducts(ArrayList<Product> filteredProducts) {

        itemsHolder.removeAll();

        itemsHolder.resetGrid();

        for (Product p : filteredProducts) {

            itemsHolder.addItemPanel(
                    new ItemPanel(p, this)
            );
        }

        itemsHolder.addFiller();

        itemsHolder.revalidate();
        itemsHolder.repaint();

        showItemsHolder();
    }

    public void showSearchedProducts(ArrayList<Product> searchedProducts) {

        itemsHolder.removeAll();

        itemsHolder.resetGrid();

        for (Product p : searchedProducts) {

            itemsHolder.addItemPanel(
                    new ItemPanel(p, this)
            );
        }

        itemsHolder.addFiller();

        itemsHolder.revalidate();
        itemsHolder.repaint();

        showItemsHolder();
    }

    // =====================================================
    // Adding
    // =====================================================

    public void addItem(Product product) {

        itemsHolder.addItemPanel(
                new ItemPanel(product, this)
        );

        itemsHolder.addFiller();

        itemsHolder.revalidate();
        itemsHolder.repaint();
    }

    public void addCategory(Category category) {

        categoriesHolder.addCategoryPanel(
                new CategoryPanel(category, mainWindow)
        );

        categoriesHolder.addFiller();

        categoriesHolder.revalidate();
        categoriesHolder.repaint();
    }

    // =====================================================
    // Removing
    // =====================================================

    public void removeItem(Product product) {

        for (Component comp : itemsHolder.getComponents()) {

            if (comp instanceof ItemPanel) {

                ItemPanel ip = (ItemPanel) comp;

                if (ip.getProduct().equals(product)) {

                    itemsHolder.remove(ip);

                    break;
                }
            }
        }

        itemsHolder.revalidate();
        itemsHolder.repaint();
    }

    public void removeCategory(Category category) {

        for (Component comp : categoriesHolder.getComponents()) {

            if (comp instanceof CategoryPanel) {

                CategoryPanel cp = (CategoryPanel) comp;

                if (cp.getCategory().equals(category)) {

                    categoriesHolder.remove(cp);

                    break;
                }
            }
        }

        categoriesHolder.revalidate();
        categoriesHolder.repaint();
    }

    // =====================================================
    // Cart
    // =====================================================

    public void addToCart(Product product) {

        mainWindow.addToCart(product);
    }
}

// =========================================================
// Items Holder
// =========================================================

class ItemsHolder extends MyGradient {

    private GridBagConstraints gbc;

    private int col = 0;

    private int row = 0;

    private final int MAX_COLUMNS = 4;

    public ItemsHolder(
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

        this.setLayout(new GridBagLayout());

        this.setBorder(
                new EmptyBorder(100, 80, 80, 80)
        );

        this.setOpaque(false);

        gbc = new GridBagConstraints();

        gbc.insets = new Insets(
                20,
                20,
                20,
                20
        );

        gbc.anchor = GridBagConstraints.NORTHWEST;
    }

    public void addItemPanel(ItemPanel panel) {

        gbc.gridx = col;

        gbc.gridy = row;

        this.add(panel, gbc);

        col++;

        if (col >= MAX_COLUMNS) {

            col = 0;

            row++;
        }
    }

    public void addFiller() {

        GridBagConstraints filler = new GridBagConstraints();

        filler.gridx = MAX_COLUMNS;

        filler.gridy = row + 1;

        filler.weightx = 1;

        filler.weighty = 1;

        filler.fill = GridBagConstraints.BOTH;

        this.add(Box.createGlue(), filler);
    }

    public void resetGrid() {

        col = 0;

        row = 0;
    }
}

// =========================================================
// Categories Holder
// =========================================================

class CategoriesHolder extends MyGradient {

    private GridBagConstraints gbc;

    private int col = 0;

    private int row = 0;

    private final int MAX_COLUMNS = 4;

    public CategoriesHolder(
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

        this.setLayout(new GridBagLayout());

        this.setBorder(
                new EmptyBorder(100, 80, 80, 80)
        );

        this.setOpaque(false);

        gbc = new GridBagConstraints();

        gbc.insets = new Insets(
                20,
                20,
                20,
                20
        );

        gbc.anchor = GridBagConstraints.NORTHWEST;
    }

    public void addCategoryPanel(CategoryPanel panel) {

        gbc.gridx = col;

        gbc.gridy = row;

        this.add(panel, gbc);

        col++;

        if (col >= MAX_COLUMNS) {

            col = 0;

            row++;
        }
    }

    public void addFiller() {

        GridBagConstraints filler = new GridBagConstraints();

        filler.gridx = MAX_COLUMNS;

        filler.gridy = row + 1;

        filler.weightx = 1;

        filler.weighty = 1;

        filler.fill = GridBagConstraints.BOTH;

        this.add(Box.createGlue(), filler);
    }

    public void resetGrid() {

        col = 0;

        row = 0;
    }
}