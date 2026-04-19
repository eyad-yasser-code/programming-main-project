//main package 

package shop.ui.LogicHelper;





//my imports

//main imports





public class Product{
    
    private int id;
    private String name;
    private String imageName;
    private String description;
    private double price;
    
    
    public Product(int id,String name,String imageName,String description,double price) {
       setId(id);
       setName(name);
       setImageName(imageName);
       setDescritption(description); 
       setPrice(price); 
    }
    
    
    //getters 
    public int getId(){return id;}
    public String getName(){return name;}
    public String getImageName(){return imageName;}
    public String getDescription(){return description;}
    public double getPrice(){return price;}
    
    //setters
    public void setId(int id){this.id = id;};
    public void setName(String name){this.name=name;}
    public void setImageName(String imageName){this.imageName=imageName;}
    public void setDescritption(String description){this.description=description;}
    public void setPrice(double price){this.price=price;}
    
    

    
    @Override 
    public boolean equals(Object obj){

        if(this==obj)return true;
        if(!(obj instanceof Product) || obj == null) return false;

        Product other = (Product)obj;

        return this.getId() == other.getId();

    }






}