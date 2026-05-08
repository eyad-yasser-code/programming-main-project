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

    private ItemsHolder      itemsHolder;
    private CategoriesHolder categoriesHolder;

    private CardLayout cardLayout;
    private JPanel     cardPanel;

    private MainWindow mainWindow;

    private final float[] degrees = {0.0f, 0.7f, 1.0f};
    private final Color[] colors  = {
        Color.decode("#1e2020"),
        Color.decode("#1a1c1c"),
        Color.decode("#141616")
    };

    public MiddleView(MainWindow mainWindow) {

        this.setLayout(new BorderLayout());
        this.mainWindow = mainWindow;
        this.setOpaque(false);

        itemsHolder = new ItemsHolder(0, 0, 0, 600, degrees, colors, 30);

        categoriesHolder = new CategoriesHolder(0, 0, 0, 600, degrees, colors, 30);
        
        categoriesHolder.setMinimumSize(new Dimension(800, 500));
        categoriesHolder.setPreferredSize(new Dimension(800, 500));

        JPanel categoryHolderWrapper = new JPanel(new BorderLayout());
        categoryHolderWrapper.setOpaque(false);
        categoryHolderWrapper.add(categoriesHolder, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
        cardPanel.setOpaque(false);

        cardPanel.add(itemsHolder,           "itemsHolder");
        cardPanel.add(categoryHolderWrapper, "categoriesHolder"); 
        this.add(cardPanel, BorderLayout.CENTER);
        showCategoriesHolder();
    }

    //Visibility
    public void showItemsHolder() {
        cardLayout.show(cardPanel, "itemsHolder");
        itemsHolder.revalidate();
        itemsHolder.repaint();
    }

    public void showFilteredProducts(ArrayList<Product> filteredProducts) 
    {
        itemsHolder.removeAll();
        for (Product p : filteredProducts) {
            itemsHolder.add(new ItemPanel(p, this));
        }
        itemsHolder.revalidate();
        itemsHolder.repaint();
        showItemsHolder();
    }

    public void showSearchedProducts(ArrayList<Product> searchedProducts)
     {
        itemsHolder.removeAll();
        for (Product p : searchedProducts) {
            itemsHolder.add(new ItemPanel(p, this));
        }
        itemsHolder.revalidate();
        itemsHolder.repaint();
        showItemsHolder();
    }

    public void showCategoriesHolder() {
       
        cardLayout.show(cardPanel, "categoriesHolder");
        categoriesHolder.revalidate();
        categoriesHolder.repaint();
    }

    //  Adding

    public void addItem(Product product) 
    {
        itemsHolder.add(new ItemPanel(product, this));
    }


    public void addCategory(Category category) 
    {
        categoriesHolder.add(new CategoryPanel(category, mainWindow));
    }



    // Removing 

    public void removeItem(Product product) 
    {
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



    public void addToCart(Product product) {
        mainWindow.addToCart(product);
    }
}


class ItemsHolder extends MyGradient 
{

    public ItemsHolder(int startX, int startY, int endX, int endY,
                       float[] degrees, Color[] colors, int arc) {
        super(startX, startY, endX, endY, degrees, colors, arc);
       
        this.setLayout(new GridLayout(0, 4, 40, 40));
        this.setBorder(new EmptyBorder(100, 80, 80, 80));
        this.setOpaque(false);
    }
}


class CategoriesHolder extends MyGradient 
{

    public CategoriesHolder(int startX, int startY, int endX, int endY,
                            float[] degrees, Color[] colors, int arc) {
        super(startX, startY, endX, endY, degrees, colors, arc);
        this.setLayout(new GridLayout(0, 4, 40, 40));
        this.setBorder(new EmptyBorder(100, 80, 80, 80));
        this.setOpaque(false);
    }
}
