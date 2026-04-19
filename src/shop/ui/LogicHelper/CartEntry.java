package shop.ui.LogicHelper;



public class CartEntry {
   
    private Product product;
    private int quantity;


    public CartEntry(Product product){

        this.product=product;
        this.quantity=1;




    }


    public Product getProduct(){return product;}
    public int getQuantity(){return quantity;}


    public void increase(){quantity++;}
    public void decrease(){
        if(quantity>1)quantity--;
    }



}
