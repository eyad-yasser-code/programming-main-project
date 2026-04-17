//main package 

package shop.ui.LogicHelper;





//my imports

//main imports





public class Product{
    
    private String name;
    private String imageName;
    private String description;
    private double price;
    
    
    public Product(String name,String imageName,String description,double price) {
        this.name=name;
        this.imageName=imageName;
        this.description=description;
        this.price=price;
    }
    
    
    //getters 
    public String getName(){return name;}
    public String getImageName(){return imageName;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}
    
    //setters
    public void setName(String name){this.name=name;}
    public void setImageName(String imageName){this.imageName=imageName;}
    public void setDescritption(String description){this.description=description;}
    public void setPrice(double price){this.price=price;}
    
    

}