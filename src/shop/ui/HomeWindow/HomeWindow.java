package shop.ui.HomeWindow;

import shop.ui.MainWindow.*;
import shop.ui.MainWrapper.MainWrapper;
import shop.ui.ShopWindow.ShopWindow;
import shop.ui.LogicHelper.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeWindow extends JPanel {

    private MainWindow  mainWindow;
    private MainWrapper mainWrapper;
    private ShopWindow  shopWindow;

    public HomeWindow(ShopWindow shopWindow) {

        this.shopWindow = shopWindow;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#141414")); // DESIGN: deeper, richer background

        mainWindow  = new MainWindow(this);
        mainWindow.setOpaque(false);

        mainWrapper = new MainWrapper(mainWindow, shopWindow);
        mainWrapper.setOpaque(false);

        JLayeredPane layeredPane = new JLayeredPane() {
            @Override
            public void doLayout() {
                int w = getWidth(), h = getHeight();
                mainWindow.setBounds(0, 0, w, h);
                mainWrapper.setBounds(0, 0, w, h);
            }
        };

        layeredPane.add(mainWindow,  JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(mainWrapper, JLayeredPane.PALETTE_LAYER);
        layeredPane.setOpaque(false);

        this.add(layeredPane, BorderLayout.CENTER);
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    public void panelVisible(boolean bool) { mainWrapper.panelVisible(bool); }
    public void resetSearch()              { mainWrapper.resetSearch(); }
    public void greetingLabel()            { mainWrapper.greetingLabel(); }

    // ── Adding (main) ─────────────────────────────────────────────────────────

    public void addItem(Product product)       { mainWindow.addItem(product); }
    public void addCategory(Category category) { mainWindow.addCategory(category); }

    // ── Adding (reverse) ──────────────────────────────────────────────────────

    public void addToCart(Product product) { shopWindow.addToCart(product); }

    // ── Removing ──────────────────────────────────────────────────────────────

    public void removeItem(Product product)       { mainWindow.removeItem(product); }
    public void removeCategory(Category removable){ mainWindow.removeCategory(removable); }

    // ── Showing ───────────────────────────────────────────────────────────────

    public ArrayList<Product> getAllProducts() { return shopWindow.getAllProducts(); }

    public void showAllProducts() {
        mainWindow.showItemsHolder();
        mainWindow.showSearchedProducts(getAllProducts());
    }

    public void showCategories() {
        mainWindow.showCategoriesHolder();
        mainWindow.defaultScroll();
    }

    public void showSearchedProducts(ArrayList<Product> searchedProducts) {
        mainWindow.showSearchedProducts(searchedProducts);
    }
}
